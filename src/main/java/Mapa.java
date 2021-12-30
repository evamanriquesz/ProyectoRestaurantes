package main.java;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**Clase que genera el panel del mapa para implementarlo en la pantalla principal junto con sus elementos*/

public class Mapa extends JPanel implements ActionListener {

    JButton elPimientoverde,vips,casaRicardo,najera;
    public Mapa() {
        this.setLayout(null);
        this.setPreferredSize(new Dimension(500,500));

        JLabel lblvips = new JLabel("Vips");
        lblvips.setFont(new Font("Lirio", Font.BOLD, 9));
        lblvips.setForeground(Color.BLACK);
        lblvips.setBounds(330,345,35,35);
        this.add(lblvips);


         elPimientoverde = new JButton();
         vips = new JButton();
         casaRicardo = new JButton();
         najera = new JButton();

        ImageIcon geoloc = new ImageIcon("src"+ File.separator +"main"+ File.separator + "resources" + File.separator + "geolocalizacion.png");
        ImageIcon imagengeoloc = new ImageIcon(geoloc.getImage().getScaledInstance(35,-1, Image.SCALE_DEFAULT));
        //imagen del logo
        elPimientoverde.setIcon(imagengeoloc);
        vips.setIcon(imagengeoloc);
        casaRicardo.setIcon(imagengeoloc);
        najera.setIcon(imagengeoloc);

        elPimientoverde.setBounds(90,402,35,35);
        vips.setBounds(325,320,35,35);
        casaRicardo.setBounds(313,100,35,35);
        najera.setBounds(172,50,35,35);

        elPimientoverde.addActionListener(this);
        vips.addActionListener(this);
        casaRicardo.addActionListener(this);
        najera.addActionListener(this);


        this.add(elPimientoverde);
        this.add(vips);
        this.add(casaRicardo);
        this.add(najera);
    }

    @Override
    public void paintComponent(Graphics g){

        Dimension tamanio = getSize();
        ImageIcon imagenFondo = new ImageIcon("src"+ File.separator +"main"+ File.separator + "resources" + File.separator + "mapa2.png");
        g.drawImage(imagenFondo.getImage(), 0, 0,
                tamanio.width, tamanio.height, null);
        setOpaque(false);

        super.paintComponent(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==elPimientoverde)
        {
            JInicioSesion.crearPanelPeque("El Pimiento Verde ",new JPanelRellenarReserva("El pimiento verde", "ver info"));
        }

        if(e.getSource()==vips)
        {
            JInicioSesion.crearPanelPeque("Vips ", new JPanelRellenarReserva("vips", "ver info"));
        }

        if(e.getSource()==casaRicardo)
        {
            JInicioSesion.crearPanelPeque("Casa Ricardo ",new JPanelRellenarReserva("casa ricardo", "ver info"));
        }

        if(e.getSource()==najera)
        {
            JInicioSesion.crearPanelPeque("Nájera",new JPanelRellenarReserva("najera", "ver info"));
        }
    }
}

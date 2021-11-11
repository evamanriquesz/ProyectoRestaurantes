package main.java;


import de.fhpotsdam.unfolding.UnfoldingMap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.TreeSet;

//panel de restaurantes hecho a mano

public class PnlRestaurantes extends JPnlFondo implements ActionListener {

    private UnfoldingMap mapa;
    public TreeSet<Restaurante> restaurantes;
    public static JList<String> jlistrestaurantes;

    Mapa map;

    String[] listarestaurantes = new String[25];

    JLabel lblRestaurantes;
    JButton btnBuscar,btnGeneradorAleatorio,btnperfil;

    JTextField jtxtBuscar,jtxtbarrio;
    JLabel lblfiltros;

    JCheckBox tipo, restaurante, bar, taberna, comidarapida, barrio; //podriamos poner tambien valoraciones, valoraciones, una, dos, tres,cuatro,cinco;


    public PnlRestaurantes()
    {
        // restaurantes = IO.leerFicheroRestaurantes(); //no sirve porque no usamos la clase io ni ficheros
        this.setBounds(0, 0, getMaximumSize().width, getMaximumSize().height);


        //lista de restaurantes de prueba que vamos usando para asegurarnos que se muestran en el scrollpane
        restaurantes = new TreeSet<>();

        restaurantes.add(new Restaurante("Ginos", "Calle Julian Romea, 4 "));
        restaurantes.add(new Restaurante("La Máquina", "Calle Ponzano, 39"));
        restaurantes.add(new Restaurante("Lateral", "Pº Castellana, 42"));
        restaurantes.add(new Restaurante("Five Guys", "Calle Gran Via, 44"));
        //System.out.println(restaurantes);


        jlistrestaurantes = new JList<>(listarestaurantes);
        JScrollPane barraDesplazamiento = new JScrollPane(jlistrestaurantes);


        lblRestaurantes =new JLabel("Restaurantes");
        lblRestaurantes.setFont(new Font("Freestyle Script", Font.BOLD, 50));
        lblRestaurantes.setForeground(Color.BLACK);
        lblRestaurantes.setHorizontalTextPosition( SwingConstants.CENTER );
        lblRestaurantes.setVerticalTextPosition( SwingConstants.BOTTOM );
        lblRestaurantes.setBounds(650,75,300,100);
        this.add(lblRestaurantes);


        barraDesplazamiento.setViewportView(jlistrestaurantes);
        jlistrestaurantes.setLayoutOrientation(JList.VERTICAL);
        jlistrestaurantes.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jlistrestaurantes.setBackground(new Color(161, 201, 236));
        jlistrestaurantes.setLayoutOrientation(JList.VERTICAL);

        //recorremos el treeset de restaurantes para guardarlo en el vector de Strings que semete en el jlist
        for (Restaurante r : restaurantes)
        {
            for (int i = 0; i < listarestaurantes.length; i++){

                if(listarestaurantes[i]==null) {
                    listarestaurantes[i] = r.getNombre() + "," + r.getDireccion();
                    i = listarestaurantes.length;
                }
            }
        }
        jlistrestaurantes.setBackground(new Color(113, 152, 180));
        jlistrestaurantes.setFont(new Font("Georgia", Font.BOLD, 25));
        jlistrestaurantes.setForeground(Color.BLACK);


        barraDesplazamiento.setBounds(1000,240,500,400);
        this.add(barraDesplazamiento);

        jtxtBuscar = new JTextField(30);
        jtxtBuscar.setBounds(1180,190,200,40);
        this.add(jtxtBuscar);

        btnBuscar = new JButton("BUSCAR");
        //btnBuscar.addActionListener(this);
        btnBuscar.setFont(new Font("Georgia", Font.BOLD, 12));
        btnBuscar.setForeground(Color.BLACK);
        btnBuscar.setHorizontalTextPosition( SwingConstants.CENTER );
        btnBuscar.setVerticalTextPosition( SwingConstants.BOTTOM );
        btnBuscar.setBackground(new Color(90, 130, 156));
        btnBuscar.setBounds(1400,190,100,40);
        this.add(btnBuscar);

        lblfiltros=new JLabel("Filtros: ");
        lblfiltros.setFont(new Font("Freestyle Script", Font.BOLD, 35));
        lblfiltros.setForeground(Color.BLACK);
        lblfiltros.setBounds(150,190,100,40);
        this.add(lblfiltros);

        tipo=new JCheckBox("Tipo de comida");
        tipo.setFont(new Font("Georgia", Font.BOLD, 15));
        tipo.setForeground(Color.BLACK);
        tipo.setBounds(80,250,180,30);
        tipo.setBackground(new Color(90, 130, 156));
        this.add(tipo);

            restaurante =new JCheckBox("Restaurante");
            restaurante.setFont(new Font("Georgia", Font.BOLD, 15));
            restaurante.setForeground(Color.BLACK);
            restaurante.setBounds(100,300,160,30);
            restaurante.setBackground(new Color(90, 130, 156));
            restaurante.setEnabled(false);
            this.add(restaurante);

            bar =new JCheckBox("Bar");
            bar.setFont(new Font("Georgia", Font.BOLD, 15));
            bar.setForeground(Color.BLACK);
            bar.setBounds(100,350,160,30);
            bar.setBackground(new Color(90, 130, 156));
            bar.setEnabled(false);
            this.add(bar);

            taberna =new JCheckBox("Taberna");
            taberna.setFont(new Font("Georgia", Font.BOLD, 15));
            taberna.setForeground(Color.BLACK);
            taberna.setBounds(100,400,160,30);
            taberna.setBackground(new Color(90, 130, 156));
            taberna.setEnabled(false);
            this.add(taberna);

            comidarapida=new JCheckBox("Comida Rápida");
            comidarapida.setFont(new Font("Georgia", Font.BOLD, 15));
            comidarapida.setForeground(Color.BLACK);
            comidarapida.setBounds(100,450,160,30);
            comidarapida.setBackground(new Color(90, 130, 156));
            comidarapida.setEnabled(false);
            this.add(comidarapida);

        barrio =new JCheckBox("Barrio");
        barrio.setFont(new Font("Georgia", Font.BOLD, 15));
        barrio.setForeground(Color.BLACK);
        barrio.setBounds(80,520,180,30);
        barrio.setBackground(new Color(90, 130, 156));
        this.add(barrio);

            jtxtbarrio=new JTextField(20);
            jtxtbarrio .setBounds(100,570,160,30);
            jtxtbarrio.setEnabled(false);
            this.add(jtxtbarrio);



        btnGeneradorAleatorio= new JButton("GENERAR RESTAURANTE ALEATORIO");
        btnGeneradorAleatorio.setFont(new Font("Georgia", Font.BOLD, 30));
        btnGeneradorAleatorio.setForeground(Color.BLACK);
        btnGeneradorAleatorio.setHorizontalTextPosition( SwingConstants.CENTER );
        btnGeneradorAleatorio.setVerticalTextPosition( SwingConstants.BOTTOM );
        btnGeneradorAleatorio.setBackground(new Color(173, 199, 238));
        btnGeneradorAleatorio.setBounds(200,680,1200,50);
        this.add(btnGeneradorAleatorio);


        btnperfil = new JButton();
        ImageIcon perfil = new ImageIcon("src"+ File.separator +"main"+ File.separator + "resources" + File.separator + "perfilcoloreado.bmp.png");
        ImageIcon imagenperfil = new ImageIcon(perfil.getImage().getScaledInstance(100,-1,Image.SCALE_DEFAULT));
        //imagen del logo
        btnperfil.setIcon(imagenperfil);
        //btnperfil.setBackground(new Color(90, 130, 156));
        btnperfil.setBounds(1290,50,100,100);
        btnperfil.addActionListener(this);
        this.add(btnperfil);


        // map = new Mapa(40.429944f, -3.712778f, 480, 310); //coordenadas icai


        //map=new Mapa();//(40.429944f, -3.712778f);
        //map.setBounds(180,150,400,310);
        //this.add(map);

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==btnperfil)
        {
            JInicioSesion.crearPanel("Mi perfil", JInicioSesion.panelperfil);
        }
    }

//tengo que poner que si seleccionan el checkbox tipo de comida o el de precio se ponga setEnable(true) los correspondientes
}


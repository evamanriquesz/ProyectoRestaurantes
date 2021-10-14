package main.java;//import grep.SwingLink;
import javax.swing.*;
import java.awt.*;

/**
 * Clase padre de la clase PnlBotones de la que todos heredan el fondo, el titulo y los JLabels de la parte inferior de la ventana
 */

public class JPnlFondo extends JPanel
{

    public JLabel jlblesp2;
    public JLabel jlblesp1;
    //GridBagLayout layout = new GridBagLayout();
   // GridBagConstraints config = new GridBagConstraints();


    JLabel titulo;


    /**
     * Constructor de la clase que inicializa los parametros que heredan sus clases hijas
     */
    public JPnlFondo() {
        this.setBounds(171, 120, 600, 600);
        this.setBackground(new Color(141, 182, 206));

        titulo = new JLabel("DCBY");
        titulo.setFont(new Font("Abadi",Font.ITALIC, 80));
        titulo.setForeground(Color.BLACK);

        titulo.setBounds(150,70,400,100);
        this.add(titulo);
        /*config.gridx=0;
        config.gridy=0;
        config.gridwidth=9;
        config.gridheight=1;
        config.ipadx=100;
        config.ipady=10;
        config.weighty = 1.0;
        config.weightx=1.0;
        config.anchor=GridBagConstraints.CENTER;
        config.fill= GridBagConstraints.CENTER;
       this.add(titulo,config);
        config.weighty = 0.0;
        config.weightx=0.0;
        config.ipadx=0;
        config.ipady=0;*/

       /* jlblesp1 = new JLabel("          ");
        config.gridx=9;
        config.gridy=8;
        config.gridwidth=2;
        config.gridheight=1;
        //config.ipadx=100;
        //config.ipady=10;
        config.weightx=1.0;
        config.anchor=GridBagConstraints.EAST;
        config.fill= GridBagConstraints.CENTER;
        this.add(jlblesp1, config);
        config.weightx=0.0;

        jlblesp2 = new JLabel("          ");
        config.gridx=0;
        config.gridy=6;
        config.gridwidth=2;
        config.gridheight=3;
        //config.ipadx=100;
        //config.ipady=10;
        config.weightx=1.0;
        config.weighty=1.0;
        config.anchor=GridBagConstraints.EAST;
        config.fill= GridBagConstraints.CENTER;
        this.add(jlblesp2, config);
        config.weightx=0.0;
        config.weighty=0.0;*/



    }
/*
    @Override
    public void paintComponent(Graphics g){

        Dimension tamanio = getSize();
        ImageIcon imagenFondo = new ImageIcon("resources" + File.separator +"imagenes" + File.separator + "fondo.jpg");
        g.drawImage(imagenFondo.getImage(), 0, 0,
                tamanio.width, tamanio.height, null);
        setOpaque(false);

        super.paintComponent(g);
    }
*/
}

package main.java;//import grep.SwingLink;
import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * Clase padre de la clase de los paneles de la que todos heredan el fondo y el titulo
 */

public class JPnlFondo extends JPanel
{

    //public JLabel jlblesp2;
    //public JLabel jlblesp1;
    //GridBagLayout layout = new GridBagLayout();
   // GridBagConstraints config = new GridBagConstraints();

    JLabel titulo;


    /**
     * Constructor de la clase que inicializa los parametros que heredan sus clases hijas
     */
    public JPnlFondo() {

        JLabel imagen = new JLabel();

        this.setBounds(171, 120, 600, 600);
        this.setBackground(new Color(141, 182, 206));

        ImageIcon dcby = new ImageIcon("src"+ File.separator +"main"+ File.separator + "resources" + File.separator + "dcbyoscuro.png");
        ImageIcon imagendcby = new ImageIcon(dcby.getImage().getScaledInstance(100,-1,Image.SCALE_DEFAULT));
        //imagen del logo
        imagen.setIcon(imagendcby);
        //.setBackground(new Color(249, 226, 219));
        imagen.setBounds(20,20,100,100);
        this.add(imagen);
        /* config.gridx=1;
        config.gridy=1;
        config.gridwidth=9;
        config.gridheight=1;
        config.weighty = 1.0;
        config.weightx = 1.0;
        config.ipadx=100;
        config.anchor= GridBagConstraints.CENTER;
        config.fill= GridBagConstraints.CENTER;
        jPnlPassword.add(imagen,config);
        config.weighty = 0.0;
        config.ipadx=0;*/

       /* titulo = new JLabel("DCBY");
        titulo.setFont(new Font("Abadi",Font.ITALIC, 20));
        titulo.setForeground(Color.BLACK);

        titulo.setBounds(150,70,200,100);
        this.add(titulo);*/
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
}

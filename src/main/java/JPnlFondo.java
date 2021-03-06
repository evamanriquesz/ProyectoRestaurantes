package main.java;
import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * Clase padre de la clase de los paneles de la que todos heredan el fondo y el titulo y la imagen del logo
 * (es solo la franja superior de todos los paneles)
 */

public class JPnlFondo extends JPanel
{

    JLabel nombre;


    /**
     * Constructor de la clase fondo que inicializa los parametros que heredan sus clases hijas
     */
    public JPnlFondo(){

        this.setLayout(null);
        this.setPreferredSize(new Dimension(getMaximumSize().width,100));
        //this.setBounds(0, 0, JInicioSesion.screenSize.width, 100);
        this.setBounds(0, 0, JInicioSesion.screenSize.width, JInicioSesion.screenSize.height);
        //this.setBackground(new Color(133, 192, 227));
        this.setBackground(new Color(141, 182, 206));

        JLabel imagen = new JLabel();

        ImageIcon dcby = new ImageIcon("src"+ File.separator +"main"+ File.separator + "resources" + File.separator +"imagenes"+File.separator + "dcbyoscuro.png");
        ImageIcon imagendcby = new ImageIcon(dcby.getImage().getScaledInstance(80,-1,Image.SCALE_DEFAULT));
        //imagen del logo
        imagen.setIcon(imagendcby);
        //.setBackground(new Color(249, 226, 219));
        imagen.setBounds(20,10,80,80);
        this.add(imagen);

        nombre = new JLabel("DCBY");
        nombre.setFont(new Font("Lirio",Font.ITALIC, 30));
        nombre.setForeground(Color.BLACK);

        nombre.setBounds(130,15,100,80);
        this.add(nombre);

    }

}

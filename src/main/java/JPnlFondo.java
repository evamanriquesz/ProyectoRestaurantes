package main.java;//import grep.SwingLink;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
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

        this.setPreferredSize(new Dimension(getMaximumSize().width,getMaximumSize().height));
        //this.setBounds(0, 0, getMaximumSize().width, getMaximumSize().height);
        this.setBackground(new Color(205, 226, 253));

        JLabel imagen = new JLabel();

        ImageIcon dcby = new ImageIcon("src"+ File.separator +"main"+ File.separator + "resources" + File.separator + "dcbyoscuro.png");
        ImageIcon imagendcby = new ImageIcon(dcby.getImage().getScaledInstance(100,-1,Image.SCALE_DEFAULT));
        //imagen del logo
        imagen.setIcon(imagendcby);
        //.setBackground(new Color(249, 226, 219));
        imagen.setBounds(50,50,100,100);
        this.add(imagen);

       /* titulo = new JLabel("DCBY");
        titulo.setFont(new Font("Abadi",Font.ITALIC, 20));
        titulo.setForeground(Color.BLACK);

        titulo.setBounds(150,70,200,100);
        this.add(titulo);*/


    }

}

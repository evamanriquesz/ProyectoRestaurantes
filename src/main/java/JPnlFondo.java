//import grep.SwingLink;
import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * Clase padre de la clase PnlBotones de la que todos heredan el fondo, el titulo y los JLabels de la parte inferior de la ventana
 */

public class JPnlFondo extends JPanel
{

    GridBagLayout layout = new GridBagLayout();
    GridBagConstraints config = new GridBagConstraints();


    JLabel titulo, jlbllugar, jlblenvios,jlblesp;
    // SwingLink jlblinsta;


    /**
     * Constructor de la clase que inicializa los parametros que heredan sus clases hijas
     */
    public JPnlFondo() {
        this.setSize(800, 600);
        this.setLayout(new FlowLayout());


        titulo = new JLabel("Nombre Restaurante");
        titulo.setFont(new Font("Freestyle Script", Font.BOLD | Font.ITALIC, 50));
        titulo.setForeground(Color.BLACK);
        config.gridx=0;
        config.gridy=0;
        config.gridwidth=9;
        config.gridheight=1;
        config.ipadx=100;
        config.ipady=10;
        //config.weighty = 1.0;
        config.anchor=GridBagConstraints.CENTER;
        config.fill= GridBagConstraints.CENTER;
        this.add(titulo,config);
        config.weighty = 0.0;
        config.ipadx=0;
        config.ipady=0;


    /*
        jlbllugar = new JLabel("Madrid");
        config.gridx=0;
        config.gridy=6;
        config.gridwidth=1;
        config.gridheight=1;
        config.weightx=1.0;
        config.anchor=GridBagConstraints.WEST;
        config.fill= GridBagConstraints.CENTER;
        this.add(jlbllugar, config);
        config.weightx=0.0;

        jlblenvios = new JLabel("Envios a toda España");
        config.gridx=0;
        config.gridy=7;
        config.gridwidth=1;
        config.gridheight=1;
        //config.ipadx=100;
        //config.ipady=10;
        //config.weighty=0.0;
        config.weightx=1.0;
        config.anchor=GridBagConstraints.WEST;
        config.fill= GridBagConstraints.WEST;
        this.add(jlblenvios, config);
        config.weightx=0.0;

        jlblinsta = new SwingLink("Instagram: @ratitapresumidashop","https://www.instagram.com/ratitapresumidashop/");
        config.gridx=0;
        config.gridy=8;
        config.gridwidth=2;
        config.gridheight=1;
        //config.ipadx=100;
        //config.ipady=10;
        config.weightx=1.0;
        config.anchor=GridBagConstraints.WEST;
        config.fill= GridBagConstraints.HORIZONTAL;
        this.add(jlblinsta, config);
        config.weightx=0.0;

        jlblesp = new JLabel("          ");
        config.gridx=9;
        config.gridy=8;
        config.gridwidth=2;
        config.gridheight=1;
        //config.ipadx=100;
        //config.ipady=10;
        config.weightx=1.0;
        config.anchor=GridBagConstraints.EAST;
        config.fill= GridBagConstraints.CENTER;
        this.add(jlblesp, config);
        config.weightx=0.0;
    */
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

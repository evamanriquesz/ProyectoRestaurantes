package main.java;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**panel del perfil que se abre al dar al boton de perfil. Cuando lo conectemos a la base de datos mostrara la
 * informacion del usuario que tenga la cuenta iniciada
 */

public class JPanelPerfil extends JPanel {

    JLabel lbltitulo, nombre, apellidos, telefono, correo,imagen;
    JButton verReservasActuales, verReservasAnteriores;
    ArrayList<Cliente> clientes;

    static String nombrec, apellidosc, telefc,correoc;


    JLabel lblnombre, lblapellidos, lbltelefono,lblcorreo;

    public JPanelPerfil(){

        this.setLayout(null);
        //this.setBounds(0, 0, 600, 400);
        this.setBackground(new Color(221, 234, 245, 202));


        nombre = new JLabel("NOMBRE: ");
        nombre.setFont(new Font("Lirio", Font.BOLD, 20));
        nombre.setForeground(Color.BLACK);
        nombre.setBounds(80,150,150,30);
        nombre.setHorizontalTextPosition( SwingConstants.LEFT);
        nombre.setVerticalTextPosition( SwingConstants.BOTTOM );
        this.add(nombre);



        apellidos = new JLabel("APELLIDOS: ");
        apellidos.setFont(new Font("Lirio", Font.BOLD, 20));
        apellidos.setForeground(Color.BLACK);
        apellidos.setBounds(80,190,150,30);
        this.add(apellidos);



        telefono = new JLabel("TELÉFONO: ");
        telefono.setFont(new Font("Lirio", Font.BOLD, 20));
        telefono.setForeground(Color.BLACK);
        telefono.setBounds(80,230,150,30);
        this.add(telefono);



        correo = new JLabel("CORREO: ");
        correo.setFont(new Font("Lirio", Font.BOLD, 20));
        correo.setForeground(Color.BLACK);
        correo.setBounds(80,270,150,30);
        this.add(correo);


    }

    public static void rellenarInfo()
    {
        nombrec = JInicioSesion.cliente.getNombre();

        apellidosc = JInicioSesion.cliente.getApellidos();

        telefc = String.valueOf(JInicioSesion.cliente.getTelefono());

        correoc = JInicioSesion.cliente.getCorreo();

        JInicioSesion.panelperfil.incluirInfo();

    }

    public void incluirInfo()
    {
        lblnombre=new JLabel(nombrec);
        lblnombre.setFont(new Font("Lirio", Font.BOLD, 20));
        lblnombre.setForeground(Color.BLACK);
        lblnombre.setBounds(250,150,300,30);
        lblnombre.setHorizontalTextPosition( SwingConstants.LEFT);
        lblnombre.setVerticalTextPosition( SwingConstants.BOTTOM );
        this.add(lblnombre);

        lblapellidos =new JLabel(apellidosc);
        lblapellidos.setFont(new Font("Lirio", Font.BOLD, 20));
        lblapellidos.setForeground(Color.BLACK);
        lblapellidos.setBounds(250,190,300,30);
        lblapellidos.setHorizontalTextPosition( SwingConstants.LEFT);
        lblapellidos.setVerticalTextPosition( SwingConstants.BOTTOM );
        this.add(lblapellidos);

        lbltelefono =new JLabel(telefc);
        lbltelefono.setFont(new Font("Lirio", Font.BOLD, 20));
        lbltelefono.setForeground(Color.BLACK);
        lbltelefono.setBounds(250,230,300,30);
        lbltelefono.setHorizontalTextPosition( SwingConstants.LEFT);
        lbltelefono.setVerticalTextPosition( SwingConstants.BOTTOM );
        this.add(lbltelefono);

        lblcorreo=new JLabel(JInicioSesion.cliente.getCorreo());
        lblcorreo.setFont(new Font("Lirio", Font.BOLD, 20));
        lblcorreo.setForeground(Color.BLACK);
        lblcorreo.setBounds(250,270,300,30);
        lblcorreo.setHorizontalTextPosition( SwingConstants.LEFT);
        lblcorreo.setVerticalTextPosition( SwingConstants.BOTTOM );
        this.add(lblcorreo);
    }


}

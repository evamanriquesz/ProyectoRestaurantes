package main.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**panel del perfil que se abre al dar al boton de perfil. Cuando lo conectemos a la base de datos mostrara la
 * informacion del usuario que tenga la cuenta iniciada
 * tendra la opcion de visualizar los restaurantes favoritos, de ver las reservas anteriores y de editar la informacion
 * del usuario
 */

public class JPanelPerfil extends JPanel implements ActionListener {

    private JButton editarPerfil;
    JLabel lbltitulo, nombre, apellidos, telefono, correo,imagen;
    JButton verFavoritos, verReservasAnteriores;
    ArrayList<Cliente> clientes;

    static String nombrec, apellidosc, telefc,correoc;


    JLabel lblnombre, lblapellidos, lbltelefono,lblcorreo;
    private SwingUtilities Swingutilities;

    public JPanelPerfil(){

        this.setLayout(null);
        //this.setBounds(0, 0, 600, 400);
        this.setBackground(new Color(221, 234, 245, 202));


        nombre = new JLabel("NOMBRE: ");
        nombre.setFont(new Font("Lirio", Font.BOLD, 20));
        nombre.setForeground(Color.BLACK);
        nombre.setBounds(100,180,150,30);
        nombre.setHorizontalTextPosition( SwingConstants.LEFT);
        nombre.setVerticalTextPosition( SwingConstants.BOTTOM );
        this.add(nombre);



        apellidos = new JLabel("APELLIDOS: ");
        apellidos.setFont(new Font("Lirio", Font.BOLD, 20));
        apellidos.setForeground(Color.BLACK);
        apellidos.setBounds(100,240,150,30);
        this.add(apellidos);



        telefono = new JLabel("TELÉFONO: ");
        telefono.setFont(new Font("Lirio", Font.BOLD, 20));
        telefono.setForeground(Color.BLACK);
        telefono.setBounds(100,300,150,30);
        this.add(telefono);



        correo = new JLabel("CORREO: ");
        correo.setFont(new Font("Lirio", Font.BOLD, 20));
        correo.setForeground(Color.BLACK);
        correo.setBounds(100,360,150,30);
        this.add(correo);


        verFavoritos= new JButton("Ver Favoritos");
        verFavoritos.setFont(new Font("Lirio", Font.BOLD, 20));
        verFavoritos.setForeground(Color.BLACK);
        verFavoritos.setBackground(new Color(133, 177, 204, 182));
        verFavoritos.setBounds(100,450,280,50);
        this.add(verFavoritos);

        verReservasAnteriores= new JButton("Ver Reservas Anteriores");
        verReservasAnteriores.setFont(new Font("Lirio", Font.BOLD, 20));
        verReservasAnteriores.setBackground(new Color(133, 177, 204, 182));
        verReservasAnteriores.setForeground(Color.BLACK);
        verReservasAnteriores.setBounds(450,450,280,50);
        this.add(verReservasAnteriores);

        editarPerfil = new JButton("Editar Perfil");
        editarPerfil.setFont(new Font("Lirio", Font.BOLD, 20));
        editarPerfil.setBackground(new Color(133, 177, 204, 182));
        editarPerfil.setForeground(Color.BLACK);
        editarPerfil.setBounds(100,530,630,30);
        editarPerfil.addActionListener(this);
        this.add(editarPerfil);

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
        lblnombre.setBounds(250,180,300,30);
        lblnombre.setHorizontalTextPosition( SwingConstants.LEFT);
        lblnombre.setVerticalTextPosition( SwingConstants.BOTTOM );
        this.add(lblnombre);

        lblapellidos =new JLabel(apellidosc);
        lblapellidos.setFont(new Font("Lirio", Font.BOLD, 20));
        lblapellidos.setForeground(Color.BLACK);
        lblapellidos.setBounds(250,240,300,30);
        lblapellidos.setHorizontalTextPosition( SwingConstants.LEFT);
        lblapellidos.setVerticalTextPosition( SwingConstants.BOTTOM );
        this.add(lblapellidos);

        lbltelefono =new JLabel(telefc);
        lbltelefono.setFont(new Font("Lirio", Font.BOLD, 20));
        lbltelefono.setForeground(Color.BLACK);
        lbltelefono.setBounds(250,300,300,30);
        lbltelefono.setHorizontalTextPosition( SwingConstants.LEFT);
        lbltelefono.setVerticalTextPosition( SwingConstants.BOTTOM );
        this.add(lbltelefono);

        lblcorreo=new JLabel(JInicioSesion.cliente.getCorreo());
        lblcorreo.setFont(new Font("Lirio", Font.BOLD, 20));
        lblcorreo.setForeground(Color.BLACK);
        lblcorreo.setBounds(250,360,300,30);
        lblcorreo.setHorizontalTextPosition( SwingConstants.LEFT);
        lblcorreo.setVerticalTextPosition( SwingConstants.BOTTOM );
        this.add(lblcorreo);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==editarPerfil)
        {
            JFrame  topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            topFrame.dispose();

            JRegistrarUsuario paneleditar = new JRegistrarUsuario();

            paneleditar.txtNombre.setText(nombrec);
            paneleditar.txtApellidos.setText(apellidosc);
            paneleditar.txtTelefono.setText(telefc);
            paneleditar.txtEmail.setText(correoc);
            paneleditar.txtUsuario.setText(JInicioSesion.usuario);
            paneleditar.txtContra.setText(JInicioSesion.pw.toString());
            paneleditar.txtRepetirContra.setText(JInicioSesion.pw.toString());

            JCheckBox infoTarjeta = new JCheckBox("Añadir información tarjeta de crédito");
            infoTarjeta.setFont(new Font("Lirio", Font.BOLD, 15));
            infoTarjeta.setForeground(Color.BLACK);
            infoTarjeta.setBackground(new Color(221, 234, 245, 202));
            infoTarjeta.setBounds(80,500,400,30);
            //paneleditar.add(infoTarjeta);

            /*paneleditar.btnAceptar.addActionListener(e1 -> {
                 if (infoTarjeta.isSelected())
                 {
                     try {
                         JInicioSesion.crearPanelPeque("INFORMACION TARJETA DE CRÉDITO");
                     }catch {

                     }
                 }

                 }
            });*/
            JInicioSesion.crearPanelPeque("EDITAR PERFIL",paneleditar);



        }
    }
}

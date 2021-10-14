package main.java;

import icai.dtc.isw.client.Client;
import icai.dtc.isw.dao.CustomerDAO;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.*;
import java.io.File;
import java.util.HashMap;


public class JInicioSesion extends JFrame
{
    final static String USER = "postgres";
    final static String PASSWORD = "postgres";


    JButton btnIniciar;
    JTextField txtUser;
    JPasswordField txtPassword;

    JButton btnRegistrarse;

    JPanel jPnlPassword;
    JPanel jPnlRestaurante; //este es el nuevo que intentamos hacer con las funcionalidades de intellij
     JLabel titulo;
    //JPanel jPnlRestaurante //este es el hecho a mano

    //GridBagLayout layout = new GridBagLayout();
    //GridBagConstraints config = new GridBagConstraints();


    public static void main(String[] args)
    {
        new JInicioSesion(); /*falta*/
    }

    public JInicioSesion()
    {
        super("Don't Choose By Yourself");

        /*AQUI VA TOOOODO LO DE DENTRO DE LA APP*/

        this.setPreferredSize(new Dimension(800,600));

        //this.setLayout(layout);

        //jPnlRestaurante = new JPnlRestaurantes();
        jPnlRestaurante = new PnlRestaurantes();
        jPnlRestaurante.setLayout(null);



        crearPanelInicioSesion();



    /*    config.gridx=0;
        config.gridy=0;
        config.gridwidth=1;
        config.gridheight=1;
        config.weightx=1.0;
        config.weighty=1.0;
        config.ipadx=100;
        config.ipady=100;
        config.anchor=GridBagConstraints.CENTER;
        config.fill= GridBagConstraints.BOTH;*/

        this.add(jPnlRestaurante);//,config);
        this.add(jPnlPassword);//,config);

        jPnlPassword.setVisible(true);
        jPnlRestaurante.setVisible(false);

        this.setResizable(false);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(MAXIMIZED_BOTH);

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    public void crearPanelInicioSesion()
    {

        JLabel imagen = new JLabel(); //hay que elegir que imagen de inicio de sesion poner

        jPnlPassword = new JPanel();
        jPnlPassword.setBounds(171, 120, 600, 600);
        jPnlPassword.setBackground(new Color(141, 182, 206));
        jPnlPassword.setLayout(null);


        titulo = new JLabel("DCBY");
        titulo.setFont(new Font("Abadi",Font.ITALIC, 80));
        titulo.setForeground(Color.BLACK);

        titulo.setBounds(150,70,400,100);
        jPnlPassword.add(titulo);

        ImageIcon dcby = new ImageIcon("src"+ File.separator +"main"+ File.separator + "resources" + File.separator + "dcbyoscuro.png");
        ImageIcon imagendcby = new ImageIcon(dcby.getImage().getScaledInstance(200,-1,Image.SCALE_DEFAULT));
        //imagen del logo
        imagen.setIcon(imagendcby);
        //.setBackground(new Color(249, 226, 219));
        imagen.setBounds(500,20,200,200);
        jPnlPassword.add(imagen);
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



        //lbl user
        JLabel lblUser = new JLabel ("Usuario");
        lblUser.setFont(new Font("Arial", Font.PLAIN, 25));
        lblUser.setBounds(200,250,200,50);
        jPnlPassword.add(lblUser);
        /*config.gridx=1;
        config.gridy=2;
        config.gridwidth=1;
        config.gridheight=1;
        //config.weighty = 1.0;
        config.weightx = 1.0;
        config.anchor= GridBagConstraints.CENTER;
        config.fill= GridBagConstraints.CENTER;
        jPnlPassword.add(lblUser,config);
        config.weighty = 0.0;*/

        //txt user
        txtUser = new JTextField(10);
        txtUser.setBounds(400,250,200,40);
        jPnlPassword.add(txtUser);
       /* config.gridx=2;
        config.gridy=2;
        config.gridwidth=1;
        config.gridheight=1;
        //config.weighty = 1.0;
        config.weightx = 1.0;
        config.anchor= GridBagConstraints.CENTER;
        config.fill= GridBagConstraints.HORIZONTAL;
        jPnlPassword.add(txtUser,config);
        config.weighty = 0.0;*/


        //lbl password
        JLabel lblPassword = new JLabel( "Contraseña");
        lblPassword.setBounds(200,300,200,50);
        lblPassword.setFont(new Font("Arial", Font.PLAIN, 25));
        jPnlPassword.add(lblPassword);
        /*config.gridx=1;
        config.gridy=3;
        config.gridwidth=1;
        config.gridheight=1;
        //config.weighty = 1.0;
        config.weightx = 1.0;
        config.anchor= GridBagConstraints.CENTER;
        config.fill= GridBagConstraints.CENTER;
        jPnlPassword.add(lblPassword,config);
        config.weighty = 0.0;*/

        //txtpassword
        txtPassword = new JPasswordField(10);
        txtPassword.setBounds(400,300,200,40);
        jPnlPassword.add(txtPassword);
        /*config.gridx=2;
        config.gridy=3;
        config.gridwidth=1;
        config.gridheight=1;
        //config.weighty = 1.0;
        config.weightx = 1.0;
        config.anchor= GridBagConstraints.CENTER;
        config.fill= GridBagConstraints.HORIZONTAL;
        jPnlPassword.add(txtPassword,config);
        config.weighty = 0.0;*/

        btnIniciar = new JButton("Iniciar Sesión");
        btnIniciar.setFont(new Font("Arial", Font.BOLD, 30));
        btnIniciar.setForeground(Color.BLACK);
        btnIniciar.setHorizontalTextPosition( SwingConstants.CENTER );
        btnIniciar.setVerticalTextPosition( SwingConstants.BOTTOM );
        btnIniciar.setBackground(new Color(90, 130, 156));
        //btnIniciar.setSize(new Dimension(120,20));

        btnIniciar.setBounds(200,350,400,80);
        jPnlPassword.add(btnIniciar);
        /*config.gridx=1;
        config.gridy=4;
        config.gridwidth=2;
        config.gridheight=2;
        config.weighty = 1.0;
        config.weightx = 1.0;
        config.anchor= GridBagConstraints.CENTER;
        config.fill= GridBagConstraints.HORIZONTAL;
        jPnlPassword.add(btnIniciar);
        config.weighty = 0.0;
        config.weightx=0.0;*/

        JLabel pregunta = new JLabel("¿Aún no tienes cuenta?");
        pregunta.setFont(new Font("Arial", Font.BOLD, 15));
        pregunta.setBackground(Color.BLACK);
        pregunta.setBounds(250, 500, 200, 20);
        jPnlPassword.add(pregunta);

        btnRegistrarse= new JButton("Registrarse");
        btnRegistrarse.setFont(new Font("Arial", Font.BOLD, 10));
        btnRegistrarse.setForeground(Color.BLACK);
        btnRegistrarse.setHorizontalTextPosition( SwingConstants.CENTER );
        btnRegistrarse.setVerticalTextPosition( SwingConstants.BOTTOM );
        btnRegistrarse.setBackground(new Color(90, 130, 156));
        btnRegistrarse.setBounds(475, 495, 100, 30);
        jPnlPassword.add(btnRegistrarse);



        //jPnlPassword.add(btnRegistrarse);


        txtUser.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent keyEvent){
                if (keyEvent.getKeyCode() == KeyEvent.VK_ENTER)
                    txtPassword.requestFocus();
            }
        });

        txtPassword.addKeyListener (new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent keyEvent){
                if (keyEvent.getKeyCode() == KeyEvent.VK_ENTER)
                    btnIniciar.requestFocus();
            }
        });

        btnIniciar.setText("Iniciar Sesión");

        btnIniciar.addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent keyEvent){
                if(keyEvent.getKeyCode() == KeyEvent.VK_ENTER)
                    try{
                        String user =txtUser.getText(); //aqui tenemos que poner algo del tipo, si existe este nombre en la base de datod
                        char[] password = txtPassword.getPassword();
                        iniciarSesion(user, password);
                    }
                    catch(InicioSesionException ise)
                    {
                        JOptionPane.showMessageDialog(JInicioSesion.this, ise.getMessage());
                        txtUser.setText("");
                        txtPassword.setText("");
                        txtUser.requestFocus();
                    }
            }
        });

        btnIniciar.addActionListener(e -> {
            try{
                String user1 = txtUser.getText();
                char[] password1 = txtPassword.getPassword();
                iniciarSesion(user1,password1);
            }
            catch (InicioSesionException ise)
            {
                JOptionPane.showMessageDialog(JInicioSesion.this, ise.getMessage());
                txtUser.setText("");
                txtPassword.setText("");
                txtUser.requestFocus();
            }
        });
    /*
        btnRegistrarse.addActionListener(e->{
            JRegistrarUsuario jRegistrarUsuario = new JRegistrarUsuario();
            jRegistrarUsuario.setVisible(true);

            jRegistrarUsuario.btnAceptar.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    /*try
                    {
                        String usuario = jRegistrarUsuario.getUsuario();
                        String contra = jRegistrarUsuario.getContra();
                        String repetirContra = jRegistrarUsuario.getRepetirContra();
                        int telefono = Integer.parseInt(jRegistrarUsuario.txtTelefono.getText());
                        String email = jRegistrarUsuario.getEmail();

                        //aqui tengo que poner algo para que me redirija a CustomerDAO, y ahí crear un método que sea registrar parecido a autenticar
                    }


                }
            });


        }); */
    }

    public void iniciarSesion(String user, char[] password) throws InicioSesionException{
        StringBuilder pw = new StringBuilder();

        for (char c: password)
        {
            pw.append(c);
        }

        //Atilano
        Client client=new Client();
        HashMap<String,Object> session=new HashMap<String, Object>();
        session.put("user",user);
        session.put("pass",pw.toString());
        client.envio("/hacerLogin",session);
       // CustomerDAO customerDAO = new CustomerDAO();
        int respuesta = (Integer) session.get("RespuestaLogin");  //esto puede estar mal
                //customerDAO.autenticar(user, pw.toString());
        if(respuesta == 1)
        {
            jPnlPassword.setVisible(false);
            jPnlRestaurante.setVisible(true);
        }

        else if (respuesta ==0)
        {
            throw new InicioSesionException();
        }

    }

/*
    public void registrarUsuario(String usuario, String contra, int telefono, String email)
    {

    }
*/




}

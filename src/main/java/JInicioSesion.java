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
    JPanel jPnlRestaurante;


    public static void main(String[] args)
    {
        new JInicioSesion(); /*falta*/
    }

    public JInicioSesion()
    {
        super("Nombre de la App");

        /*AQUI VA TOOOODO LO DE DENTRO DE LA APP*/

        jPnlRestaurante = new PnlRestaurantes();

        crearPanelInicioSesion();


        this.add(jPnlPassword);
        this.add(jPnlRestaurante);


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
        jPnlPassword = new JPnlFondo();

        JLabel lblTitulo = new JLabel("Nombre Aplicación");
         lblTitulo.setFont(new Font("Freestyle Script", Font.BOLD | Font.ITALIC, 50));
        lblTitulo.setForeground(Color.BLACK);


        JLabel lblUser = new JLabel ("Usuario");
        JLabel lblPassword = new JLabel( "Contraseña");

        txtUser = new JTextField(10);
        txtPassword = new JPasswordField(10);

        btnIniciar = new JButton();

        btnRegistrarse= new JButton("Registrarse");

        jPnlPassword.add(lblTitulo);
        jPnlPassword.add(lblUser);
        jPnlPassword.add(txtUser);
        jPnlPassword.add(lblPassword);
        jPnlPassword.add(txtPassword);
        jPnlPassword.add(btnIniciar);
        jPnlPassword.add(btnRegistrarse);

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

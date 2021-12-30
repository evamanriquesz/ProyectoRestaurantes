package main.java;

import icai.dtc.isw.client.Client;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.HashMap;

/**clase principal en el que se inicia la aplicacion y se crea la ventana de inicio de sesion**/

public class JInicioSesion extends JFrame
{
    final static String USER = "postgres";
    final static String PASSWORD = "postgres";

    static JFrame ventana;
    static String usuario;
    static Cliente cliente;
    static TarjetaCredito tarjetaCredito;


    static JPanel jPnlPassword;
    static JLabel titulo;

    static StringBuilder pw;

    public static Dimension screenSize =Toolkit. getDefaultToolkit(). getScreenSize();

    public static JPanel panelNorte;
    public static JPanelPerfil panelperfil;

    public static int ancho = screenSize.width-35;;   // screenSize.width-35;//1450;
    public static int alto =screenSize.height-50; //screenSize.height-50;//780;

    static String[] args;

    public static void main(String[] args)
    {
        JInicioSesion.args=args;
        new JInicioSesion(); /*falta*/
        System.out.println("Tamaño: "+ screenSize.width + " x " + screenSize.height);
        System.out.println(args);
    }

    /**constructor de la ventana que muestra el inicio de sesion**/
    public JInicioSesion()
    {
        super("Don't Choose By Yourself");

        this.setPreferredSize(new Dimension(800,600));

        panelperfil =new JPanelPerfil();

        //jPnlRestaurante = new JPnlRestaurantes(); //el nuevo que intentamos crear con el gui
        //jPnlRestaurante = new PnlRestaurantes(); //el picado a mano
        //jPnlRestaurante.setLayout(null);


        crearPanelInicioSesion();


        //this.add(jPnlRestaurante);
        this.add(jPnlPassword);
        jPnlPassword.setVisible(true);
        //jPnlRestaurante.setVisible(false);

        this.setResizable(false);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    /**metodo para crear el panel de inicio de sesion**/
    public static void crearPanelInicioSesion()
    {

        JButton btnIniciar;
        JTextField txtUser;
        JPasswordField txtPassword;

        JButton btnRegistrarse;

        JLabel imagen = new JLabel();

        //informacion del panel
        jPnlPassword = new JPanel();
        jPnlPassword.setBounds(171, 120, 600, 600);
        jPnlPassword.setBackground(new Color(141, 182, 206));
        jPnlPassword.setLayout(null);

        //label del titulo del panel
        titulo = new JLabel("DCBY");
        titulo.setFont(new Font("Abadi",Font.ITALIC, 80));
        titulo.setForeground(Color.BLACK);

        titulo.setBounds(150,70,400,100);
        jPnlPassword.add(titulo);


        //imagen del logo
        ImageIcon dcby = new ImageIcon("src"+ File.separator +"main"+ File.separator + "resources" + File.separator + "dcbyoscuro.png");
        ImageIcon imagendcby = new ImageIcon(dcby.getImage().getScaledInstance(200,-1,Image.SCALE_DEFAULT));
        imagen.setIcon(imagendcby);
        imagen.setBounds(500,20,200,200);
        jPnlPassword.add(imagen);



        //etiqueta de usuario
        JLabel lblUser = new JLabel ("Usuario");
        lblUser.setFont(new Font("Arial", Font.PLAIN, 25));
        lblUser.setBounds(200,250,200,50);
        jPnlPassword.add(lblUser);


        //cuadro de etxto del usuario
        txtUser = new JTextField(10);
        txtUser.setBounds(400,250,200,40);
        jPnlPassword.add(txtUser);



        //etiqueta de contraseña
        JLabel lblPassword = new JLabel( "Contraseña");
        lblPassword.setBounds(200,300,200,50);
        lblPassword.setFont(new Font("Arial", Font.PLAIN, 25));
        jPnlPassword.add(lblPassword);


        //cuadro de texto para la contraseña
        txtPassword = new JPasswordField(10);
        txtPassword.setBounds(400,300,200,40);
        jPnlPassword.add(txtPassword);



        //boton de Iniciar sesion
        btnIniciar = new JButton("Iniciar Sesión");
        btnIniciar.setFont(new Font("Arial", Font.BOLD, 30));
        btnIniciar.setForeground(Color.BLACK);
        btnIniciar.setHorizontalTextPosition( SwingConstants.CENTER );
        btnIniciar.setVerticalTextPosition( SwingConstants.BOTTOM );
        btnIniciar.setBackground(new Color(90, 130, 156));
        btnIniciar.setBounds(200,350,400,80);
        jPnlPassword.add(btnIniciar);


        //pregunta para registrarse
        JLabel pregunta = new JLabel("¿Aún no tienes cuenta?");
        pregunta.setFont(new Font("Arial", Font.BOLD, 15));
        pregunta.setBackground(Color.BLACK);
        pregunta.setBounds(250, 500, 200, 20);
        jPnlPassword.add(pregunta);

        //boton para registrarse si no se tiene cuenta
        btnRegistrarse= new JButton("Registrarse");
        btnRegistrarse.setFont(new Font("Arial", Font.BOLD, 10));
        btnRegistrarse.setForeground(Color.BLACK);
        btnRegistrarse.setHorizontalTextPosition( SwingConstants.CENTER );
        btnRegistrarse.setVerticalTextPosition( SwingConstants.BOTTOM );
        btnRegistrarse.setBackground(new Color(90, 130, 156));
        btnRegistrarse.setBounds(475, 495, 100, 30);
        jPnlPassword.add(btnRegistrarse);


        //cuando se apriete "enter" tras poner el usuario que se vaya al cuadro de la contraseña
        txtUser.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent keyEvent){
                if (keyEvent.getKeyCode() == KeyEvent.VK_ENTER)
                    txtPassword.requestFocus();
            }
        });

        //cuando se apriete "enter" tras poner la contraseña que se vaya al boton de inicio de sesion
        txtPassword.addKeyListener (new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent keyEvent){
                if (keyEvent.getKeyCode() == KeyEvent.VK_ENTER)
                    btnIniciar.requestFocus();
            }
        });

        //si se presiona "enter" que guarde los valores de usuario y contraseña
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
                        JOptionPane.showMessageDialog(JInicioSesion.jPnlPassword, ise.getMessage());
                        txtUser.setText("");
                        txtPassword.setText("");
                        txtUser.requestFocus();
                    }
            }
        });

        //cuando se pulse que compare si son correctos o no el usuario y contraseña
        btnIniciar.addActionListener(e -> {
            try{
                String user1 = txtUser.getText();
                char[] password1 = txtPassword.getPassword();
                iniciarSesion(user1,password1);
            }
            catch (InicioSesionException ise)
            {
                JOptionPane.showMessageDialog(JInicioSesion.jPnlPassword, ise.getMessage());
                txtUser.setText("");
                txtPassword.setText("");
                txtUser.requestFocus();
            }
        });

        btnRegistrarse.addActionListener(e->{
            crearPanelPeque("REGISTRO",new JRegistrarUsuario());
        });
    }

    /**metodo para iniciar sesion que conecta la ventana con la base de datos
     * @throws InicioSesionException  si se introduce un usuario que no este registrado o cuando el usuario o la
     * contraseña sean incorrectos*/

    public static void iniciarSesion(String user, char[] password) throws InicioSesionException {
        pw = new StringBuilder();

        for (char c: password)
        {
            pw.append(c);
        }

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
            usuario= user;
            jPnlPassword.setVisible(false);
            JFrame framepw=(JFrame) SwingUtilities.getWindowAncestor(jPnlPassword);
            framepw.setVisible(false);
            crearPanelGrande("Don´t Choose By Yourself");
            informacionCliente(usuario);

        }

        else if (respuesta ==0)
        {
            throw new InicioSesionException();
        }
    }

    /**metodo que llamamos para crear un panel pequeño (como para el perfil o el registro)**/
    public static void crearPanelPeque (String titulo, JPanel panel)
    {
        JFrame ventana = new JFrame(titulo);

        ventana.setPreferredSize(new Dimension(800,700));
        panelNorte =new JPnlFondo();//titulo);
        panelNorte.setBounds(0,0,800,100);

        JLabel lbltitulo=new JLabel(titulo);
        lbltitulo.setFont(new Font("Lirio", Font.ITALIC, 30));
        lbltitulo.setForeground(Color.BLACK);
        lbltitulo.setHorizontalTextPosition( SwingConstants.CENTER );
        lbltitulo.setVerticalTextPosition( SwingConstants.BOTTOM );
        lbltitulo.setBounds(350,20,400,70);
        panelNorte.add(lbltitulo);

        ventana.add(panelNorte);

        panel.setBounds(0,101,800, 600);
        ventana.add(panel);

        ventana.pack();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }

    /**metodo para crear un panel grande en el que mostraremos la pantalla principal de la app**/

    public static void crearPanelGrande (String titulo)
    {
        ventana = new JFrame(titulo);
        ventana.setPreferredSize(new Dimension(ancho, alto));

        panelNorte =new JPnlFondo();
        panelNorte.setBounds(0,0,ancho,100);

        JLabel lbltitulo=new JLabel("RESTAURANTES");
        lbltitulo.setFont(new Font("Lirio", Font.ITALIC, 30));
        lbltitulo.setForeground(Color.BLACK);
        lbltitulo.setHorizontalTextPosition( SwingConstants.CENTER );
        lbltitulo.setVerticalTextPosition( SwingConstants.BOTTOM );
        //lbltitulo.setBounds(screenSize.width/2 -100,20,300,70);
        lbltitulo.setBounds(ancho/2 -100,20,300,70);
        panelNorte.add(lbltitulo);

        ventana.add(panelNorte);

        JPanel jPnlRestaurante = new PnlRestaurantes(); //el picado a mano
        //jPnlRestaurante.setBounds(0,101,screenSize.width, screenSize.height-100);

        jPnlRestaurante.setBounds(0,101,ancho, alto-100);

        //Info de la ventana que recoge todo
        ventana.add(jPnlRestaurante);
        ventana.setResizable(false);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.pack();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }


    /**método que conecta con la base de datos para obtener la informacion del cliente que ha iniciado sesión*/

    public static void informacionCliente(String user) {
        Client client = new Client();
        HashMap<String, Object> session = new HashMap<>();
        session.put("user", usuario);
        session.put("pass", pw.toString());
        session.put("usuario", user);

        client.envio("/obtenerInfoCliente", session);

        cliente = (Cliente) session.get("RespuestaObtenerInfoCliente");
        if (cliente.getId() == null) {
            System.out.println("No ha devuelto bien el cliente");
        } else if (cliente.getId().equals(user)) {
            System.out.println("Si ha devuelto bien el cliente\n");
            System.out.println(cliente);

            tarjetaCredito=cliente.getTarjeta();

        }
    }


}

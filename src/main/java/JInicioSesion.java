import javax.swing.*;
import java.awt.event.KeyAdapter;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.*;


public class JInicioSesion extends JFrame
{
    final static String USER = "postgres";
    final static String PASSWORD = "postgres";

    public static JPanel JPnlPassword;

    JButton btnIniciar;
    JTextField txtUser;
    JPasswordField txtPassword;
    JPanel jPnlPassword;


    public static void main(String[] args)
    {
        new JInicioSesion(); /*falta*/
    }

    public JInicioSesion()
    {
        super("Nombre de la App");

        /*AQUI VA TOOOODO LO DE DENTRO DE LA APP*/

        crearPanelInicioSesion();

        this.add(jPnlPassword);

        jPnlPassword.setVisible(true);

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
        JLabel lblUser = new JLabel ("Usuario");
        JLabel lblPassword = new JLabel( "Contrseña");

        txtUser = new JTextField(10);
        txtPassword = new JPasswordField(10);

        btnIniciar = new JButton();

        jPnlPassword.add(lblUser);
        jPnlPassword.add(txtUser);
        jPnlPassword.add(lblPassword);
        jPnlPassword.add(txtPassword);
        jPnlPassword.add(btnIniciar);

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
    }

    public void iniciarSesion(String user, char[] password) throws InicioSesionException{
        StringBuilder pw = new StringBuilder();

        for (char c: password)
        {
            pw.append(c);
        }

        if(user.equals(USER) && pw.toString().equals(PASSWORD))
        {
            jPnlPassword.setVisible(false);
            // jPnlPrincipal.setVisible(true);
        }
        else if(!user.equals(USER) || !pw.toString().equals(PASSWORD))
        {
            throw new InicioSesionException();
        }
    }



}

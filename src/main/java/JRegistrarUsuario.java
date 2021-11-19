package main.java;

import icai.dtc.isw.client.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

/**panel que se crea cuando se le da al boton de registrarse en la pantalla de inicio de sesion y
 * que se usa para guardar los datos si se quiere crear ua cuenta nueva. hay que conectarlo con la base de datos**/

public class JRegistrarUsuario extends JPanel implements ActionListener
{

    private JLabel lblIntro;
    private JLabel lblUsuario;
    private JLabel lblContra;
    private JLabel lblRepetirContra;
    private JLabel lblTelefono;
    private JLabel lblEmail;

    private JTextField txtUsuario;
    private JTextField txtContra;
    private JTextField txtRepetirContra;
     JTextField txtTelefono;
    private JTextField txtEmail;

     JButton btnAceptar;
     JButton btnCancelar;
    private SwingUtilities Swingutilities;

    private String usuario;
    private String contra;
    private String repetirContra;
    private String email;
    private int telefono;

    public JRegistrarUsuario() {
        //super("Registrar usuario");

        this.setLayout(null);
        this.setBackground(new Color(221, 234, 245, 202));


        lblIntro = new JLabel("Introduzca los datos. ");
        lblIntro.setFont(new Font("Lirio", Font.ITALIC, 30));
        lblIntro.setForeground(Color.BLACK);
        lblIntro.setBounds(100,190,300,40);
        this.add(lblIntro);


        lblUsuario = new JLabel("Usuario: ");
        lblUsuario.setFont(new Font("Lirio", Font.BOLD, 15));
        lblUsuario.setForeground(Color.BLACK);
        lblUsuario.setBounds(80,260,180,30);
        lblUsuario.setBackground(new Color(133, 177, 204, 182));
        this.add(lblUsuario);


        lblContra = new JLabel("Contraseña: ");
        lblContra.setFont(new Font("Lirio", Font.BOLD, 15));
        lblContra.setForeground(Color.BLACK);
        lblContra.setBounds(80,300,180,30);
        lblContra.setBackground(new Color(133, 177, 204, 182));
        this.add(lblContra);

        lblRepetirContra = new JLabel("Repetir contraseña: ");
        lblRepetirContra.setFont(new Font("Lirio", Font.BOLD, 15));
        lblRepetirContra.setForeground(Color.BLACK);
        lblRepetirContra.setBounds(80,340,180,30);
        lblRepetirContra.setBackground(new Color(133, 177, 204, 182));
        this.add(lblRepetirContra);

        lblTelefono = new JLabel("Teléfono: ");
        lblTelefono.setFont(new Font("Lirio", Font.BOLD, 15));
        lblTelefono.setForeground(Color.BLACK);
        lblTelefono.setBounds(80,380,180,30);
        lblTelefono.setBackground(new Color(133, 177, 204, 182));
        this.add(lblTelefono);

        lblEmail = new JLabel("Email: ");
        lblEmail.setFont(new Font("Lirio", Font.BOLD, 15));
        lblEmail.setForeground(Color.BLACK);
        lblEmail.setBounds(80,420,180,30);
        lblEmail.setBackground(new Color(133, 177, 204, 182));
        this.add(lblEmail);

        txtUsuario = new JTextField(50);
        txtUsuario.setBounds(290, 260, 200,30);
        this.add(txtUsuario);

        txtContra = new JTextField(50);
        txtContra.setBounds(290, 300, 200,30);
        this.add(txtContra);

        txtRepetirContra = new JTextField(50);
        txtRepetirContra.setBounds(290, 340, 200,30);
        this.add(txtRepetirContra);

        txtTelefono = new JTextField(50);
        txtTelefono.setBounds(290, 380, 200,30);
        this.add(txtTelefono);

        txtEmail = new JTextField(50);
        txtEmail.setBounds(290, 420, 200,30);
        this.add(txtEmail);

        btnAceptar = new JButton("Aceptar");
        btnAceptar.setFont(new Font("Lirio", Font.BOLD, 25));
        btnAceptar.setForeground(Color.BLACK);
        btnAceptar.setBackground(new Color(133, 177, 204, 182));
        btnAceptar.setBounds(150, 500, 150, 50);
        btnAceptar.addActionListener(this);
        this.add(btnAceptar);

        /*
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    registrarUsuario(txtUsuario.getText(), txtContra.getText(), txtRepetirContra.getText(), Integer.parseInt(txtTelefono.getText()), txtEmail.getText());
                    System.out.println("HECHOOO");

                    System.out.println("INSERT INTO clientes VALUES ('"+ usuario + ", '" + contra + "', "+ telefono + ",'" + email + "');"); // este es el que se imprime
                }
                catch (RegistroException re)
                {
                    re.printStackTrace();
                }

                catch (NumberFormatException nfe)
                {
                    JOptionPane.showMessageDialog(JRegistrarUsuario.this, "error, el telefono debe ser numerico.");
                    txtTelefono.requestFocus();
                }


            }
        });

         */

        //añadir que una vez pulses aceptar ACTION LISTENER
        // registrarUsuario(txtUsuario, txtContra, txtRepetirContra, txtTelefono, txtEmail);



        btnCancelar = new JButton("Cancelar");
        btnCancelar.setFont(new Font("Lirio", Font.BOLD, 25));
        btnCancelar.setForeground(Color.BLACK);
        btnCancelar.setBackground(new Color(133, 177, 204, 182));
        btnCancelar.setBounds(350, 500, 150, 50);
        btnCancelar.addActionListener(this);
        this.add(btnCancelar);



       /* this.setResizable(false);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(false);*/
    }

    public String getUsuario()
    {
        return txtUsuario.getText();
    }

    public String getContra()
    {
        return txtContra.getText();
    }

    public String getRepetirContra()
    {
        return txtRepetirContra.getText();
    }

    public String getEmail()
    {
        return txtEmail.getText();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btnCancelar)
        {
            JFrame  topFrame = (JFrame) Swingutilities.getWindowAncestor(this);
            topFrame.dispose();
        }
        else if (e.getSource() ==btnAceptar)
        {
            try
            {
                registrarUsuario(txtUsuario.getText(), txtContra.getText(), txtRepetirContra.getText(), Integer.parseInt(txtTelefono.getText()), txtEmail.getText());
                System.out.println("HECHOOO");

                System.out.println("INSERT INTO clientes VALUES ('"+ usuario + ", '" + contra + "', "+ telefono + ",'" + email + "');"); // este es el que se imprime
            }
            catch (RegistroException re)
            {
                re.printStackTrace();
            }

            catch (NumberFormatException nfe)
            {
                JOptionPane.showMessageDialog(JRegistrarUsuario.this, "error, el telefono debe ser numerico.");
                txtTelefono.requestFocus();
            }
        }
    }
    /*
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==btnAceptar)
        {
            try
            {
                registrarUsuario(txtUsuario.getText(), txtContra.getText(), txtRepetirContra.getText(), Integer.parseInt(txtTelefono.getText()), txtEmail.getText());
                System.out.println("HECHOOO");

                System.out.println("INSERT INTO clientes VALUES ('"+ usuario + ", '" + contra + "', "+ telefono + ",'" + email + "');"); // este es el que se imprime
            }
            catch (RegistroException re)
            {
                re.printStackTrace();
            }

            catch (NumberFormatException nfe)
            {
                JOptionPane.showMessageDialog(JRegistrarUsuario.this, "error, el telefono debe ser numerico.");
                txtTelefono.requestFocus();
            }

        }
    }

     */

    public void registrarUsuario (String usuario, String contra, String repetirContra, int telefono, String email) throws RegistroException
    {
        Client client = new Client();
        HashMap<String, Object> session = new HashMap<String, Object>();
        session.put("usuario", usuario);
        session.put("contra", contra);
        session.put("repetirContra", repetirContra);
        session.put("telefono", telefono);
        session.put("email", email);



        client.envio("/hacerRegistro", session);
        // CustomerDAO customerDAO = new CustomerDAO();


       // System.out.println(session);
        int respuesta = (Integer) session.get("RespuestaRegistro");  //esto puede estar mal

       // System.out.println("Llego hasta aqui");
        //System.out.println(respuesta);
        //customerDAO.autenticar(user, pw.toString());
            /*
            if (respuesta == 1) {
                jPnlPassword.setVisible(false);
                this.setVisible(false);
                crearPanelGrande("Don´t Choose By Yourself");
                //jPnlRestaurante.setVisible(true);

                //para que cuando se inicie sesion y cambie a la pantalla principal se ponga en modo panalla completa:
                //this.setPreferredSize(new Dimension(getMaximumSize().width,getMaximumSize().height));
                //this.setExtendedState(MAXIMIZED_BOTH);


            } else if (respuesta == 0) {
                throw new RegistroException();
            }

        */
    }
}

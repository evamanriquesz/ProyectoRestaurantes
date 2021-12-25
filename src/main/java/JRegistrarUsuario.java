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
    private JLabel lblUsuario,lblNombre,lblApellidos;
    private JLabel lblContra;
    private JLabel lblRepetirContra;
    private JLabel lblTelefono;
    private JLabel lblEmail;

     JTextField txtUsuario, txtNombre, txtApellidos;
     JTextField txtContra;
     JTextField txtRepetirContra;
     JTextField txtTelefono;
     JTextField txtEmail;

     JButton btnAceptar;
     JButton btnCancelar;
    private SwingUtilities Swingutilities;


    public JRegistrarUsuario() {
        //super("Registrar usuario");

        this.setLayout(null);
        this.setBackground(new Color(221, 234, 245, 202));


        lblIntro = new JLabel("Introduzca los datos. ");
        lblIntro.setFont(new Font("Lirio", Font.ITALIC, 30));
        lblIntro.setForeground(Color.BLACK);
        lblIntro.setBounds(100,150,300,40);
        this.add(lblIntro);

        lblNombre = new JLabel("Nombre: ");
        lblNombre.setFont(new Font("Lirio", Font.BOLD, 15));
        lblNombre.setForeground(Color.BLACK);
        lblNombre.setBounds(80,220,300,40);
        this.add(lblNombre);

        lblApellidos = new JLabel("Apellidos: ");
        lblApellidos.setFont(new Font("Lirio", Font.BOLD, 15));
        lblApellidos.setForeground(Color.BLACK);
        lblApellidos.setBounds(80,260,300,40);
        this.add(lblApellidos);


        lblUsuario = new JLabel("Usuario: ");
        lblUsuario.setFont(new Font("Lirio", Font.BOLD, 15));
        lblUsuario.setForeground(Color.BLACK);
        lblUsuario.setBounds(80,300,180,30);
        lblUsuario.setBackground(new Color(133, 177, 204, 182));
        this.add(lblUsuario);


        lblContra = new JLabel("Contraseña: ");
        lblContra.setFont(new Font("Lirio", Font.BOLD, 15));
        lblContra.setForeground(Color.BLACK);
        lblContra.setBounds(80,340,180,30);
        lblContra.setBackground(new Color(133, 177, 204, 182));
        this.add(lblContra);

        lblRepetirContra = new JLabel("Repetir contraseña: ");
        lblRepetirContra.setFont(new Font("Lirio", Font.BOLD, 15));
        lblRepetirContra.setForeground(Color.BLACK);
        lblRepetirContra.setBounds(80,380,180,30);
        lblRepetirContra.setBackground(new Color(133, 177, 204, 182));
        this.add(lblRepetirContra);

        lblTelefono = new JLabel("Teléfono: ");
        lblTelefono.setFont(new Font("Lirio", Font.BOLD, 15));
        lblTelefono.setForeground(Color.BLACK);
        lblTelefono.setBounds(80,420,180,30);
        lblTelefono.setBackground(new Color(133, 177, 204, 182));
        this.add(lblTelefono);

        lblEmail = new JLabel("Email: ");
        lblEmail.setFont(new Font("Lirio", Font.BOLD, 15));
        lblEmail.setForeground(Color.BLACK);
        lblEmail.setBounds(80,460,180,30);
        lblEmail.setBackground(new Color(133, 177, 204, 182));
        this.add(lblEmail);

        txtNombre = new JTextField(50);
        txtNombre.setBounds(290, 220, 200,30);
        this.add(txtNombre);

        txtApellidos = new JTextField(50);
        txtApellidos.setBounds(290, 260, 200,30);
        this.add(txtApellidos);

        txtUsuario = new JTextField(50);
        txtUsuario.setBounds(290, 300, 200,30);
        this.add(txtUsuario);

        txtContra = new JTextField(50);
        txtContra.setBounds(290, 340, 200,30);
        this.add(txtContra);

        txtRepetirContra = new JTextField(50);
        txtRepetirContra.setBounds(290, 380, 200,30);
        this.add(txtRepetirContra);

        txtTelefono = new JTextField(50);
        txtTelefono.setBounds(290, 420, 200,30);
        this.add(txtTelefono);

        txtEmail = new JTextField(50);
        txtEmail.setBounds(290, 460, 200,30);
        this.add(txtEmail);

        btnAceptar = new JButton("Aceptar");
        btnAceptar.setFont(new Font("Lirio", Font.BOLD, 25));
        btnAceptar.setForeground(Color.BLACK);
        btnAceptar.setBackground(new Color(133, 177, 204, 182));
        btnAceptar.setBounds(150, 550, 150, 50);
        btnAceptar.addActionListener(this);
        this.add(btnAceptar);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setFont(new Font("Lirio", Font.BOLD, 25));
        btnCancelar.setForeground(Color.BLACK);
        btnCancelar.setBackground(new Color(133, 177, 204, 182));
        btnCancelar.setBounds(350, 550, 150, 50);
        btnCancelar.addActionListener(this);
        this.add(btnCancelar);


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
                if (txtContra.getText().equals(txtRepetirContra.getText())) {
                    registrarUsuario(txtUsuario.getText(), txtContra.getText(), txtRepetirContra.getText(), Integer.parseInt(txtTelefono.getText()), txtEmail.getText(), txtNombre.getText(), txtApellidos.getText());
                    System.out.println("usuario registrado");
                }else{
                    JOptionPane.showMessageDialog(JRegistrarUsuario.this, "La contraseña no coincide");
                    txtContra.setText("");
                    txtRepetirContra.setText("");
                    txtContra.requestFocus();
                }

            }
            catch (RegistroException re)
            {
                JOptionPane.showMessageDialog(JRegistrarUsuario.this, re.getMessage());
                txtUsuario.setText("");
                txtContra.setText("");
                txtRepetirContra.setText("");
                txtTelefono.setText("");
                txtEmail.setText("");

            }

            catch (NumberFormatException nfe)
            {
                JOptionPane.showMessageDialog(JRegistrarUsuario.this, "Error, el telefono debe ser numérico.");
                txtTelefono.requestFocus();
            }
        }
    }


    public void registrarUsuario (String usuario, String contra, String repetirContra, int telefono, String email, String nombre, String apellidos) throws RegistroException
    {
        Client client = new Client();
        HashMap<String, Object> session = new HashMap<String, Object>();
        session.put("usuario", usuario);
        session.put("contra", contra);
        session.put("repetirContra", repetirContra);
        session.put("telefono", telefono);
        session.put("email", email);
        session.put("nombre",nombre);
        session.put("apellidos", apellidos);



        client.envio("/hacerRegistro", session);


       // System.out.println(session);
        int respuesta = (Integer) session.get("RespuestaRegistro");  //esto puede estar mal

            if (respuesta == 1) {
                JOptionPane.showMessageDialog(JRegistrarUsuario.this, "Usuario registrado correctamente");

            } else if (respuesta == 0) {
                throw new RegistroException();
            }

    }
}

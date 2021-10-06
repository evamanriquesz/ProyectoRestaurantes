/*package main.java;

import javax.swing.*;
import java.awt.*;

public class JRegistrarUsuario extends JFrame //hace falta el extends JFrame????
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

    public JRegistrarUsuario() {
        super("Registrar usuario");

        this.setLayout(new BorderLayout());

        //pnl norte
        JPanel pnlNorte = new JPanel(new FlowLayout());

        lblIntro = new JLabel("Introduzca los datos. ");

        pnlNorte.add(lblIntro);

        //pnlCentro
        JPanel pnlCentro = new JPanel(new GridLayout(6, 2));

        lblUsuario = new JLabel("Usuario: ");
        lblContra = new JLabel("Contraseña: ");
        lblRepetirContra = new JLabel("Repetir contraseña: ")
        lblTelefono = new JLabel("Teléfono: ");
        lblEmail = new JLabel("Email: ");

        txtUsuario = new JTextField(20);
        txtContra = new JTextField(20);
        txtRepetirContra = new JTextField(20);
        txtTelefono = new JTextField(20);
        txtEmail = new JTextField(20);

        btnAceptar = new JButton("Aceptar");
        btnCancelar = new JButton("Cancelar");


        pnlCentro.add(lblUsuario);
        pnlCentro.add(txtUsuario);
        pnlCentro.add(lblContra);
        pnlCentro.add(txtContra);
        pnlCentro.add(lblRepetirContra);
        pnlCentro.add(txtRepetirContra);
        pnlCentro.add(lblTelefono);
        pnlCentro.add(txtTelefono);
        pnlCentro.add(lblEmail);
        pnlCentro.add(txtEmail);

        pnlCentro.add(btnAceptar);
        pnlCentro.add(btnCancelar);

        this.add(pnlNorte, BorderLayout.NORTH);
        this.add(pnlCentro, BorderLayout.CENTER);


        this.setResizable(false);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(false);
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
}


 */
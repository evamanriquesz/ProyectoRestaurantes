package main.java;

import icai.dtc.isw.client.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.HashMap;

/**panel que se crea cuando se le da al boton de registrarse en la pantalla de inicio de sesion y
 * que se usa para guardar los datos si se quiere crear ua cuenta nueva. hay que conectarlo con la base de datos**/

/**Tambien sirve para el panel que se crea cuando se desea editar el perfil del usuario*/

public class JRegistrarUsuario extends JPanel implements ActionListener {

    static String accion;

    JLabel lblfechaCad, lblcvv, lblnum, lblIntro, lblUsuario, lblNombre, lblApellidos, lblContra, lblRepetirContra, lblEmail, lblTelefono;

    JTextField txtmes, txtanio, txtUsuario, txtNombre,txtNombretarjeta, txtApellidos, txtContra, txtRepetirContra, txtTelefono, txtEmail, txtNumTarjeta, txtCVV, txtFecha;

    JCheckBox infoTarjeta;

    JButton btnAceptar, btnCancelar, btnAceptar2;

    static Cliente c;
    static TarjetaCredito t;
    JRegistrarUsuario panelInfoTarjeta;

/**constructor para registrar un nuevo usuario introduciendo los datos del cliente sin la tarjeta*/
    public JRegistrarUsuario() {
        //super("Registrar usuario");

        this.setLayout(null);
        this.setBackground(new Color(221, 234, 245, 202));

        accion="registrar";

        c=new Cliente();
        t=new TarjetaCredito();

        lblIntro = new JLabel("Introduzca los datos de usuario. ");
        lblIntro.setFont(new Font("Lirio", Font.ITALIC, 30));
        lblIntro.setForeground(Color.BLACK);
        lblIntro.setBounds(100, 150, 300, 40);
        this.add(lblIntro);

        lblNombre = new JLabel("Nombre: ");
        lblNombre.setFont(new Font("Lirio", Font.BOLD, 15));
        lblNombre.setForeground(Color.BLACK);
        lblNombre.setBounds(80, 220, 300, 40);
        this.add(lblNombre);

        lblApellidos = new JLabel("Apellidos: ");
        lblApellidos.setFont(new Font("Lirio", Font.BOLD, 15));
        lblApellidos.setForeground(Color.BLACK);
        lblApellidos.setBounds(80, 260, 300, 40);
        this.add(lblApellidos);


        lblUsuario = new JLabel("Usuario: ");
        lblUsuario.setFont(new Font("Lirio", Font.BOLD, 15));
        lblUsuario.setForeground(Color.BLACK);
        lblUsuario.setBounds(80, 300, 180, 30);
        lblUsuario.setBackground(new Color(133, 177, 204, 182));
        this.add(lblUsuario);


        lblContra = new JLabel("Contraseña: ");
        lblContra.setFont(new Font("Lirio", Font.BOLD, 15));
        lblContra.setForeground(Color.BLACK);
        lblContra.setBounds(80, 340, 180, 30);
        lblContra.setBackground(new Color(133, 177, 204, 182));
        this.add(lblContra);

        lblRepetirContra = new JLabel("Repetir contraseña: ");
        lblRepetirContra.setFont(new Font("Lirio", Font.BOLD, 15));
        lblRepetirContra.setForeground(Color.BLACK);
        lblRepetirContra.setBounds(80, 380, 180, 30);
        lblRepetirContra.setBackground(new Color(133, 177, 204, 182));
        this.add(lblRepetirContra);

        lblTelefono = new JLabel("Teléfono: ");
        lblTelefono.setFont(new Font("Lirio", Font.BOLD, 15));
        lblTelefono.setForeground(Color.BLACK);
        lblTelefono.setBounds(80, 420, 180, 30);
        lblTelefono.setBackground(new Color(133, 177, 204, 182));
        this.add(lblTelefono);

        lblEmail = new JLabel("Email: ");
        lblEmail.setFont(new Font("Lirio", Font.BOLD, 15));
        lblEmail.setForeground(Color.BLACK);
        lblEmail.setBounds(80, 460, 180, 30);
        lblEmail.setBackground(new Color(133, 177, 204, 182));
        this.add(lblEmail);

        txtNombre = new JTextField(50);
        txtNombre.setBounds(290, 220, 200, 30);
        this.add(txtNombre);

        txtApellidos = new JTextField(50);
        txtApellidos.setBounds(290, 260, 200, 30);
        this.add(txtApellidos);

        txtUsuario = new JTextField(50);
        txtUsuario.setBounds(290, 300, 200, 30);
        this.add(txtUsuario);

        txtContra = new JTextField(50);
        txtContra.setBounds(290, 340, 200, 30);
        this.add(txtContra);

        txtRepetirContra = new JTextField(50);
        txtRepetirContra.setBounds(290, 380, 200, 30);
        this.add(txtRepetirContra);

        txtTelefono = new JTextField(50);
        txtTelefono.setBounds(290, 420, 200, 30);
        this.add(txtTelefono);

        txtEmail = new JTextField(50);
        txtEmail.setBounds(290, 460, 200, 30);
        this.add(txtEmail);

        infoTarjeta = new JCheckBox("Añadir información tarjeta de crédito");
        infoTarjeta.setFont(new Font("Lirio", Font.BOLD, 15));
        infoTarjeta.setForeground(Color.BLACK);
        infoTarjeta.setBackground(new Color(221, 234, 245, 202));
        infoTarjeta.setBounds(80, 500, 400, 30);
        this.add(infoTarjeta);


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

    /**Constructor para registrar / añadir tarjeta de crédito*/

    public JRegistrarUsuario(String tarjeta) {
        this.setLayout(null);
        this.setBackground(new Color(221, 234, 245, 202));


        lblIntro = new JLabel("Introduzca los datos de la tarjeta. ");
        lblIntro.setFont(new Font("Lirio", Font.ITALIC, 30));
        lblIntro.setForeground(Color.BLACK);
        lblIntro.setBounds(100, 150, 500, 40);
        this.add(lblIntro);

        lblNombre = new JLabel("Nombre del propietario: ");
        lblNombre.setFont(new Font("Lirio", Font.BOLD, 15));
        lblNombre.setForeground(Color.BLACK);
        lblNombre.setBounds(80, 220, 300, 40);
        this.add(lblNombre);

        lblnum = new JLabel("Número de la tarjeta: ");
        lblnum.setFont(new Font("Lirio", Font.BOLD, 15));
        lblnum.setForeground(Color.BLACK);
        lblnum.setBounds(80, 260, 300, 40);
        this.add(lblnum);


        lblcvv = new JLabel("Código cvv: ");
        lblcvv.setFont(new Font("Lirio", Font.BOLD, 15));
        lblcvv.setForeground(Color.BLACK);
        lblcvv.setBounds(80, 300, 180, 30);
        lblcvv.setBackground(new Color(133, 177, 204, 182));
        this.add(lblcvv);


        lblfechaCad = new JLabel("Fecha de caducidad: ");
        lblfechaCad.setFont(new Font("Lirio", Font.BOLD, 15));
        lblfechaCad.setForeground(Color.BLACK);
        lblfechaCad.setBounds(80, 340, 180, 30);
        lblfechaCad.setBackground(new Color(133, 177, 204, 182));
        this.add(lblfechaCad);

        txtNombretarjeta = new JTextField(50);
        txtNombretarjeta.setBounds(290, 230, 200, 30);
        this.add(txtNombretarjeta);

        txtNumTarjeta = new JTextField(50);
        txtNumTarjeta.setBounds(290, 270, 200, 30);
        this.add(txtNumTarjeta);

        txtCVV = new JTextField(50);
        txtCVV.setBounds(290, 310, 200, 30);
        this.add(txtCVV);

        txtFecha = new JTextField(50);
        txtFecha.setBounds(290, 360, 200, 30);
        //this.add(txtFecha);


        txtmes = new JTextField(2);
        txtmes.setBounds(290, 350, 30, 20);
        this.add(txtmes);

        JLabel guion1 = new JLabel("/");
        guion1.setFont(new Font("Lirio", Font.BOLD, 19));
        guion1.setForeground(Color.BLACK);
        guion1.setHorizontalTextPosition(SwingConstants.CENTER);
        guion1.setVerticalTextPosition(SwingConstants.BOTTOM);
        guion1.setBackground(new Color(133, 177, 204, 182));
        guion1.setBounds(330, 330, 15, 50);
        this.add(guion1);

        txtanio = new JTextField(5);
        txtanio.setBounds(350, 350, 80, 20);
        this.add(txtanio);


        btnAceptar2 = new JButton("Aceptar");
        btnAceptar2.setFont(new Font("Lirio", Font.BOLD, 25));
        btnAceptar2.setForeground(Color.BLACK);
        btnAceptar2.setBackground(new Color(133, 177, 204, 182));
        btnAceptar2.setBounds(150, 550, 150, 50);
        btnAceptar2.addActionListener(this);
        this.add(btnAceptar2);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setFont(new Font("Lirio", Font.BOLD, 25));
        btnCancelar.setForeground(Color.BLACK);
        btnCancelar.setBackground(new Color(133, 177, 204, 182));
        btnCancelar.setBounds(350, 550, 150, 50);
        btnCancelar.addActionListener(this);
        this.add(btnCancelar);
    }

    public String getUsuario() {
        return txtUsuario.getText();
    }

    public String getContra() {
        return txtContra.getText();
    }

    public String getRepetirContra() {
        return txtRepetirContra.getText();
    }

    public String getEmail() {
        return txtEmail.getText();
    }


    /**Funcion que describe la funcionalidad de los botones:
     * si se pulsa cancelar, se cierra la ventana en la que se encuentre
     *si se pulsa el boton "Aceptar" de la ventana del perfil y no esta marcada la casilla de la tarjeta, se
     * guardan los nuevos datos del perfil, si esta marcada la casilla, se pasa a la ventana de edicion de los
     * datos de la tarjeta
     *si se pulsa el boton aceptar de la ventana de edicion de la tarjeta de crédito, se guardan los nuevos
     * datos editados tanto del perfil como de la tarjeta de crédito
     */

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnCancelar) {
            JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            topFrame.dispose();



        } else if (e.getSource() == btnAceptar) {
            try {
                if (txtContra.getText().equals(txtRepetirContra.getText())) {
                    c = new Cliente(txtUsuario.getText(), txtNombre.getText(), Integer.parseInt(txtTelefono.getText()), txtEmail.getText(), txtApellidos.getText(), txtContra.getText());
                    if (infoTarjeta.isSelected()) {
                        panelInfoTarjeta = new JRegistrarUsuario("infoTarjeta");
                        incluirInfoTarjeta();
                        JInicioSesion.crearPanelPeque("REGISTRO TARJETA", panelInfoTarjeta);

                    } else {
                        if(c.getId()!=null &&c.getNombre()!=null &&c.getCorreo()!=null && c.getTelefono()!=0 && c.getApellidos()!=null) {
                            registrarUsuario(accion, c.getId(), c.getPassword(), c.getPassword(), c.getTelefono(), c.getCorreo(), c.getNombre(), c.getApellidos());
                            System.out.println("usuario registrado");
                            JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
                            topFrame.dispose();
                        }else{
                            JOptionPane.showMessageDialog(this, "Debe rellenar todos los campos");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(JRegistrarUsuario.this, "La contraseña no coincide");
                    txtContra.setText("");
                    txtRepetirContra.setText("");
                    txtContra.requestFocus();
                }
            } catch (RegistroException re) {
                JOptionPane.showMessageDialog(JRegistrarUsuario.this, re.getMessage());
                txtUsuario.setText("");
                txtContra.setText("");
                txtRepetirContra.setText("");
                txtTelefono.setText("");
                txtEmail.setText("");

            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(JRegistrarUsuario.this, "Error, el telefono debe ser numérico.");
                txtTelefono.requestFocus();
            }

        } else if (e.getSource() == btnAceptar2) {
            try {
                t = new TarjetaCredito(txtNombretarjeta.getText(), txtNumTarjeta.getText(), Integer.parseInt(txtCVV.getText()));
                t.setFechaCaducidad(LocalDate.of(Integer.parseInt(txtanio.getText()), Integer.parseInt(txtmes.getText()), 1));
                registrarUsuario(accion, c.getId(),c.getPassword(), c.getPassword(), c.getTelefono(),c.getCorreo(), c.getNombre(), c.getApellidos());
                if(t.getNtarjeta()!=null && t.getNombrePropietario()!=null && t.getCvv()!=0 && t.getFechaCaducidad()!=null) {
                    incluirTarjeta(c.getId(), t.getNombrePropietario(), t.getNtarjeta(), t.getCvv(), t.getFechaCaducidad().toString());
                    JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
                    topFrame.dispose();
                    JFrame topFrame2 = (JFrame) SwingUtilities.getWindowAncestor(JPanelPerfil.paneleditar);
                    topFrame2.dispose();
                }else{
                    JOptionPane.showMessageDialog(this, "Debe rellenar todos los campos");
                }
            } catch (ExceptionFecha | RegistroException ef) {
                JOptionPane.showMessageDialog(this, ef.getMessage());
                txtmes.setText("");
                txtanio.setText("");
                txtmes.requestFocus();
            }
        }
    }



    /**Funcion para acceder a la base de datos y registrar/editar el usuario que se desee
     * @throws RegistroException cuando el usuario que se introduce ya esta registrado*/

    public void registrarUsuario(String accion, String usuario, String contra, String repetirContra, int telefono, String email, String nombre, String apellidos) throws RegistroException {
        Client client = new Client();
        HashMap<String, Object> session = new HashMap<String, Object>();
        session.put("accion", accion);
        session.put("usuario", usuario);
        session.put("contra", contra);
        session.put("repetirContra", repetirContra);
        session.put("telefono", telefono);
        session.put("email", email);
        session.put("nombre", nombre);
        session.put("apellidos", apellidos);

        client.envio("/hacerRegistro", session);

        // System.out.println(session);
        int respuesta = (Integer) session.get("RespuestaRegistro");  //esto puede estar mal
        if (respuesta == 1 && accion.equals("registrar")) {
            JOptionPane.showMessageDialog(JRegistrarUsuario.this, "Usuario registrado correctamente");
        }else if(respuesta == 1 && accion.equals("editar"))
        {
            JOptionPane.showMessageDialog(JRegistrarUsuario.this, "datos actualizados correctamente");
            JInicioSesion.cliente=c;
            JInicioSesion.panelperfil.incluirInfo();
        } else if (respuesta == 0 && accion.equals("registrar")) {
            throw new RegistroException();
        }else{
            System.out.println("no se ha editado bien la info.");
        }
    }


    /**Funcion para acceder a la base de datos e incluir/Modificar la tarjeta de crédito del usuario indicado*/
    public void incluirTarjeta(String usuario, String nombre, String numeroTarjeta, int cvv, String fechaCad)
    {
        Client client = new Client();
        HashMap<String, Object> session = new HashMap<String, Object>();
        session.put("usuario", usuario);
        session.put("nombre", nombre);
        session.put("numeroTarjeta", numeroTarjeta);
        session.put("cvv", cvv);
        session.put("fechaCad", fechaCad);

        client.envio("/incluirTarjeta", session);

        // System.out.println(session);
        int respuesta = (Integer) session.get("RespuestaIncluirTarjeta");  //esto puede estar mal

        if (respuesta == 1) {
            JOptionPane.showMessageDialog(JRegistrarUsuario.this, "datos de la tarjeta actualizados correctamente");
            JInicioSesion.cliente.setTarjeta(t);
            JInicioSesion.tarjetaCredito=t;
        } else if (respuesta == 0 ) {
            JOptionPane.showMessageDialog(JRegistrarUsuario.this, "error al actualizar los datos de la tarjeta");
        }
    }


    /**Funcion para incluir los datos de la tarjeta de credito del usuario que haya iniciado sesion en el apartado del perfil*/
    public void incluirInfoTarjeta()
    {

        if (JInicioSesion.tarjetaCredito!=null) {

            panelInfoTarjeta.txtNombretarjeta.setText(JInicioSesion.tarjetaCredito.nombrePropietario);
            panelInfoTarjeta.txtNumTarjeta.setText(JInicioSesion.tarjetaCredito.ntarjeta);
            panelInfoTarjeta.txtCVV.setText(String.valueOf(JInicioSesion.tarjetaCredito.cvv));
            panelInfoTarjeta.txtmes.setText(String.valueOf(JInicioSesion.tarjetaCredito.getFechaCaducidad().getMonthValue()));
            panelInfoTarjeta.txtanio.setText(String.valueOf(JInicioSesion.tarjetaCredito.getFechaCaducidad().getYear()));
        }

    }
}

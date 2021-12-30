package main.java;

import icai.dtc.isw.client.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

/**panel que se crea cuando se le da al boton de verReservasAnteriores en la pantalla de perfil de usuario y
 * que se usa para poder ver las reservas previas de un usuario. hay que conectarlo con la base de datos**/

public class JMostrarReservasAnteriores extends JPanel implements ActionListener, Serializable
{
    JLabel lblTitulo;
    JButton btnCerrar;

    JList<String> reservas;
    JScrollPane barra;

    public JMostrarReservasAnteriores()
    {
        this.setLayout(null);
        this.setBackground(new Color(221, 234, 245, 202));

        lblTitulo = new JLabel("Introduzca los datos de usuario. ");
        lblTitulo.setFont(new Font("Lirio", Font.ITALIC, 30));
        lblTitulo.setForeground(Color.BLACK);
        lblTitulo.setBounds(100, 150, 300, 40);
        this.add(lblTitulo);

        btnCerrar = new JButton("Cerrar");
        btnCerrar.setFont(new Font("Lirio", Font.BOLD, 25));
        btnCerrar.setForeground(Color.BLACK);
        btnCerrar.setBackground(new Color(133, 177, 204, 182));
        btnCerrar.setBounds(350, 550, 150, 50);
        btnCerrar.addActionListener(this);
        this.add(btnCerrar);
    }

    /**Funcion que describe la funcionalidad de los botones:
     * si se pulsa cerrar, se cierra la ventana en la que se encuentre
     */

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnCerrar) {
            JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            topFrame.dispose();
        }
    }

    //Revisar esto
/**Funcion para acceder a la base de datos y mostrar las reservas anteriores del usuario
 * @throws ----- cuando el usuario que se introduce ya esta registrado*/

    public void mostrarReservasAnteriores(String usuario)
    {
        Client client = new Client();
        HashMap<String, Object> session = new HashMap<String, Object>();

        reservas = new JList<>();
        barra = new JScrollPane();

        session.put("usuario", usuario);
        client.envio("/mostrarReservasAnteriores", session);
        ArrayList<Reserva> respuesta = (ArrayList<Reserva>) session.get("RespuestaMostrarReservasAnteriores");

        if(respuesta == null)
        {
            JOptionPane.showMessageDialog(this, "No has hecho ninguna reserva anteriormente. ¡Anímate y empieza hoy!");
        } else{
            DefaultListModel<String> modelo = new DefaultListModel<>();
            for (Reserva r: respuesta)
            {
                String n = r.toString();
                modelo.addElement(n);
            }

            reservas.setModel(modelo);

            barra.setViewportView(reservas);
            reservas.setLayoutOrientation(JList.VERTICAL);
            reservas.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

            reservas.setLayoutOrientation(JList.VERTICAL);

            reservas.setBackground(new Color(133, 177, 204, 182));
            reservas.setFont(new Font("Lirio", Font.ITALIC, 15));
            reservas.setForeground(Color.BLACK);

            barra.setBounds(225,250,350,250);
            this.add(barra);



        }

    }
}



package main.java;

import icai.dtc.isw.client.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;


import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilCalendarModel;

public class JPanelInfoRestaurante extends JPanel implements ActionListener {
    JLabel  lblNombreRestaurante, lblNombreCalle, lblNumeroCalle, lbltitulo;
    JButton reservar;

    JScrollPane barra;
    JList<String> restaurantes;
    private SwingUtilities Swingutilities;
    public static int id;
    JButton btnAceptar,btnCancelar;

    Calendar c;

    JDatePickerImpl datePickerFecha;

    JDatePanelImpl datePanelFecha;



    public JPanelInfoRestaurante(String nombre){
        this.setLayout(null);
        this.setBackground(new Color(221, 234, 245, 202));

        lblNombreRestaurante = new JLabel("NOMBRE: ");
        lblNombreRestaurante.setFont(new Font("Lirio", Font.BOLD, 20));
        lblNombreRestaurante.setForeground(Color.BLACK);
        lblNombreRestaurante.setBounds(80,150,150,30);
        lblNombreRestaurante.setHorizontalTextPosition( SwingConstants.LEFT);
        lblNombreRestaurante.setVerticalTextPosition( SwingConstants.BOTTOM );
        //this.add(lblNombreRestaurante);

        lblNombreCalle = new JLabel("CALLE: ");
        lblNombreCalle.setFont(new Font("Lirio", Font.BOLD, 20));
        lblNombreCalle.setForeground(Color.BLACK);
        lblNombreCalle.setBounds(80,190,150,30);
      //  lblNombreCalle.setHorizontalTextPosition( SwingConstants.LEFT);
      //  lblNombreCalle.setVerticalTextPosition( SwingConstants.BOTTOM );
       // this.add(lblNombreCalle);

        lblNumeroCalle = new JLabel("NÚMERO: ");
        lblNumeroCalle.setFont(new Font("Lirio", Font.BOLD, 20));
        lblNumeroCalle.setForeground(Color.BLACK);
        lblNumeroCalle.setBounds(80,230,150,30);
       // lblNumeroCalle.setHorizontalTextPosition( SwingConstants.LEFT);
       // lblNumeroCalle.setVerticalTextPosition( SwingConstants.BOTTOM );
        //this.add(lblNumeroCalle);

        /**codigo para conectar con las bases de datos**/
        Client client=new Client();
        HashMap<String,Object> session=new HashMap<String, Object>();
        session.put("user",11);
        session.put("pass",11);
        ArrayList<Restaurante> respuesta,rest;

        restaurantes = new JList<>();
        barra = new JScrollPane();

        session.put("restaurante", nombre);
        client.envio("/obtenerIguales",session);
        respuesta = (ArrayList<Restaurante>) session.get("RespuestaObtenerIguales");
        rest=new ArrayList<>();

        DefaultListModel modelo = new DefaultListModel();

        for (Restaurante r: respuesta)
        {
            rest.add(r);
            String n = r.toString();
            modelo.addElement(n);
        }

        restaurantes.setModel(modelo);

        barra.setViewportView(restaurantes);
        restaurantes.setLayoutOrientation(JList.VERTICAL);
        restaurantes.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        restaurantes.setLayoutOrientation(JList.VERTICAL);

        restaurantes.setBackground(new Color(133, 177, 204, 182));
        restaurantes.setFont(new Font("Lirio", Font.ITALIC, 15));
        restaurantes.setForeground(Color.BLACK);

        barra.setBounds(225,250,350,250);
        this.add(barra);

        reservar= new JButton("RESERVAR AQUI");
        reservar.setFont(new Font("Lirio", Font.BOLD, 20));
        reservar.setForeground(Color.BLACK);
        reservar.setHorizontalTextPosition( SwingConstants.CENTER );
        reservar.setVerticalTextPosition( SwingConstants.BOTTOM );
        reservar.setBackground(new Color(133, 177, 204, 182));
        reservar.setBounds(225,510,350,50);
        reservar.addActionListener(this);
        this.add(reservar);


        lbltitulo = new JLabel("Seleccione la direccion del restaurante al que quiere ir: ");
        lbltitulo.setFont(new Font("Lirio", Font.BOLD, 20));
        lbltitulo.setForeground(Color.BLACK);
        lbltitulo.setHorizontalTextPosition( SwingConstants.CENTER );
        lbltitulo.setVerticalTextPosition( SwingConstants.BOTTOM );
        lbltitulo.setBackground(new Color(133, 177, 204, 182));
        lbltitulo.setBounds(125,180,550,50);
        this.add(lbltitulo);
    }

    public JPanelInfoRestaurante(String restauranteAReservar, int aux){

        this.setLayout(null);
        this.setBackground(new Color(221, 234, 245, 202));


        JLabel nombre, direccion, npersonas, hora, fecha, dia, mes, year, nombrepersona, npersona;
        JLabel nombreres, dirres, dospuntos, guion1,guion2;
        JTextField textnpersonas, textdighora, textdigmins, textdia, textmes, textyear;


        nombre = new JLabel("Restaurante");
        nombre.setFont(new Font("Lirio", Font.BOLD, 20));
        nombre.setForeground(Color.BLACK);
        nombre.setHorizontalTextPosition( SwingConstants.CENTER );
        nombre.setVerticalTextPosition( SwingConstants.BOTTOM );
        nombre.setBackground(new Color(133, 177, 204, 182));
        nombre.setBounds(60,150,150,50);
        this.add(nombre);

        nombreres = new JLabel(restauranteAReservar.substring(0,restauranteAReservar.indexOf(",")));
        nombreres.setFont(new Font("Lirio", Font.BOLD, 18));
        nombreres.setForeground(Color.BLACK);
        nombreres.setHorizontalTextPosition( SwingConstants.LEFT );
        nombreres.setVerticalTextPosition( SwingConstants.BOTTOM );
        nombreres.setBackground(new Color(133, 177, 204, 182));
        nombreres.setBounds(300,150,350,50);
        this.add(nombreres);

        direccion = new JLabel("Dirección");
        direccion.setFont(new Font("Lirio", Font.BOLD, 20));
        direccion.setForeground(Color.BLACK);
        direccion.setHorizontalTextPosition( SwingConstants.CENTER );
        direccion.setVerticalTextPosition( SwingConstants.BOTTOM );
        direccion.setBackground(new Color(133, 177, 204, 182));
        direccion.setBounds(60,200,100,50);
        this.add(direccion);

        dirres = new JLabel(restauranteAReservar.substring(restauranteAReservar.indexOf(",")+1,restauranteAReservar.indexOf("-")));
        dirres.setFont(new Font("Lirio", Font.BOLD, 18));
        dirres.setForeground(Color.BLACK);
        dirres.setHorizontalTextPosition( SwingConstants.LEFT );
        dirres.setVerticalTextPosition( SwingConstants.BOTTOM );
        dirres.setBackground(new Color(133, 177, 204, 182));
        dirres.setBounds(300,200,350,50);
        this.add(dirres);

        npersonas = new JLabel("Número de personas: ");
        npersonas.setFont(new Font("Lirio", Font.BOLD, 19));
        npersonas.setForeground(Color.BLACK);
        npersonas.setHorizontalTextPosition( SwingConstants.CENTER );
        //npersonas.setVerticalTextPosition( SwingConstants.BOTTOM );
        npersonas.setBackground(new Color(133, 177, 204, 182));
        npersonas.setBounds(60,250,220,50);
        this.add(npersonas);

        textnpersonas = new JTextField(2);
        textnpersonas.setBounds(300,270,30,20);
        this.add(textnpersonas);

        /*

        UtilCalendarModel modelFecha = new UtilCalendarModel();

        c = Calendar.getInstance();
        int currentYear = c.get(Calendar.YEAR);
        int currentMonth = c.get(Calendar.MONTH);
        int currentDay = c.get(Calendar.DAY_OF_MONTH);

        modelFecha.setDate(currentYear, currentMonth, currentDay);

        JDatePanelImpl datePanelFecha = new JDatePanelImpl(modelFecha);

        datePickerFecha = new JDatePickerImpl(datePanelFecha);

        pnlCentro.add(datePickerEntrada);
        pnlCentro.add(datePickerSalida);

        */


        fecha = new JLabel("Fecha ");
        fecha.setFont(new Font("Lirio", Font.BOLD, 19));
        fecha.setForeground(Color.BLACK);
        fecha.setHorizontalTextPosition( SwingConstants.CENTER );
        fecha.setVerticalTextPosition( SwingConstants.BOTTOM );
        fecha.setBackground(new Color(133, 177, 204, 182));
        fecha.setBounds(60,300,200,50);
        this.add(fecha);

        UtilCalendarModel modelFecha = new UtilCalendarModel();

        c = Calendar.getInstance();
        int currentYear = c.get(Calendar.YEAR);
        int currentMonth = c.get(Calendar.MONTH);
        int currentDay = c.get(Calendar.DAY_OF_MONTH);

        modelFecha.setDate(currentYear, currentMonth, currentDay);

        JDatePanelImpl datePanelFecha = new JDatePanelImpl(modelFecha);
        datePanelFecha.setBackground(new Color(221, 234, 245, 202));
        datePickerFecha = new JDatePickerImpl(datePanelFecha);
        datePickerFecha.setBounds(300,310,200,25);
        this.add(datePickerFecha);

        /*
        textdia = new JTextField(2);
        textdia.setBounds(300,320,30,20);
        this.add(textdia);

        guion1=new JLabel("/");
        guion1.setFont(new Font("Lirio", Font.BOLD, 19));
        guion1.setForeground(Color.BLACK);
        guion1.setHorizontalTextPosition( SwingConstants.CENTER );
        guion1.setVerticalTextPosition( SwingConstants.BOTTOM );
        guion1.setBackground(new Color(133, 177, 204, 182));
        guion1.setBounds(335,300,15,50);
        this.add(guion1);

        textmes = new JTextField(15);
        textmes.setBounds(350,320,80,20);
        this.add(textmes);

        */

        /*guion1=new JLabel("/");
        guion1.setFont(new Font("Lirio", Font.BOLD, 19));
        guion1.setForeground(Color.BLACK);
        guion1.setHorizontalTextPosition( SwingConstants.CENTER );
        guion1.setVerticalTextPosition( SwingConstants.BOTTOM );
        guion1.setBackground(new Color(133, 177, 204, 182));
        guion1.setBounds(60,250,10,50);
        this.add(guion1);*/


        hora =new JLabel("Hora");
        hora.setFont(new Font("Lirio", Font.BOLD, 19));
        hora.setForeground(Color.BLACK);
        hora.setHorizontalTextPosition( SwingConstants.CENTER );
        hora.setVerticalTextPosition( SwingConstants.BOTTOM );
        hora.setBackground(new Color(133, 177, 204, 182));
        hora.setBounds(60,350,200,50);
        this.add(hora);

        textdighora = new JTextField(2);
        textdighora.setBounds(300,370,30,20);
        this.add(textdighora);

        dospuntos=new JLabel(":");
        dospuntos.setFont(new Font("Lirio", Font.BOLD, 19));
        dospuntos.setForeground(Color.BLACK);
        dospuntos.setHorizontalTextPosition( SwingConstants.CENTER );
        dospuntos.setVerticalTextPosition( SwingConstants.BOTTOM );
        dospuntos.setBackground(new Color(133, 177, 204, 182));
        dospuntos.setBounds(335,350,15,50);
        this.add(dospuntos);

        textdigmins = new JTextField(15);
        textdigmins.setBounds(350,370,30,20);
        this.add(textdigmins);

        nombrepersona = new JLabel("Nombre de la reserva: ");
        nombrepersona.setFont(new Font("Lirio", Font.BOLD, 19));
        nombrepersona.setForeground(Color.BLACK);
        nombrepersona.setHorizontalTextPosition( SwingConstants.CENTER );
        nombrepersona.setVerticalTextPosition( SwingConstants.BOTTOM );
        nombrepersona.setBackground(new Color(133, 177, 204, 182));
        nombrepersona.setBounds(60,400,220,50);
        this.add(nombrepersona);

        JPanelPerfil.rellenarInfo();

        npersona = new JLabel(JPanelPerfil.nombrec + " " + JPanelPerfil.apellidosc);
        npersona.setFont(new Font("Lirio", Font.BOLD, 19));
        npersona.setForeground(Color.BLACK);
        npersona.setHorizontalTextPosition( SwingConstants.CENTER );
        npersona.setVerticalTextPosition( SwingConstants.BOTTOM );
        npersona.setBackground(new Color(133, 177, 204, 182));
        npersona.setBounds(300,400,250,50);
        this.add(npersona);


        btnAceptar = new JButton("Aceptar");
        btnAceptar.setFont(new Font("Lirio", Font.BOLD, 25));
        btnAceptar.setForeground(Color.BLACK);
        btnAceptar.setBackground(new Color(133, 177, 204, 182));
        btnAceptar.setBounds(150, 500, 150, 50);
        btnAceptar.addActionListener(this);
        this.add(btnAceptar);


        btnCancelar = new JButton("Cancelar");
        btnCancelar.setFont(new Font("Lirio", Font.BOLD, 25));
        btnCancelar.setForeground(Color.BLACK);
        btnCancelar.setBackground(new Color(133, 177, 204, 182));
        btnCancelar.setBounds(350, 500, 150, 50);
        btnCancelar.addActionListener(this);
        this.add(btnCancelar);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==reservar) {
            try {
                if (restaurantes.getSelectedValue() != null) {

                    String restauranteAReservar = restaurantes.getSelectedValue();
                    JPanel panel2 = new JPanelInfoRestaurante(restauranteAReservar,1);
                    
                    JInicioSesion.crearPanelPeque("Introducir Datos", panel2);

                    JFrame  topFrame = (JFrame) Swingutilities.getWindowAncestor(this);
                    topFrame.dispose();
                } else {
                    throw new ReservaException();
                }
            } catch (ReservaException re) {
                JOptionPane.showMessageDialog(JPanelInfoRestaurante.this, re.getMessage());
            }
        }
        if (e.getSource()==btnCancelar)
        {
            JFrame  topFrame = (JFrame) Swingutilities.getWindowAncestor(this);
            topFrame.dispose();
        }


    }
    
}

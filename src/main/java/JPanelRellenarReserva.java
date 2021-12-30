

package main.java;

import com.sun.jdi.request.InvalidRequestStateException;
import icai.dtc.isw.client.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;


import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilCalendarModel;


/**Clase que genera el panel para realizar reservas tras seleccionar el restaurante deseado*/

public class JPanelRellenarReserva extends JPanel implements ActionListener {
    JLabel  lblNombreRestaurante, lblNombreCalle, lblNumeroCalle, lbltitulo;
    JButton reservar;

//    JLabel dirres;

    Restaurante restauranteElegido;

    JScrollPane barra;
    JList<String> restaurantes;
    private SwingUtilities Swingutilities;
    public static int id;
    JButton btnAceptar,btnCancelar, ok;
    JButton btnAceptarIntroDatos,btnCancelarIntroDatos;
    Calendar c;

    JDatePickerImpl datePickerFecha;
    JCheckBox pedido;
    JDatePanelImpl datePanelFecha;
    int codigo_reserva = 0;

    static String fechaStr;
    static String horaStr;
    static String nombreresStr;
    static String numPersonasStr;
    static String dateStr;
    static String nombrePersonaStr;
    static String usuarioStr;
    static boolean pagado_reserva = false;

    static JTextField textnpersonas;

    static JComboBox comboBoxHoras;

    static String restauranteAReservar;

    private static ArrayList<Restaurante> rest;

    String accion;

    static int identificador_restaurante_definitivo=0;

    static String direccion_restaurante_definitivo="";

    static Calendar fechita = Calendar.getInstance();

    //static ArrayList<Restaurante> rest;
/**Constructor para acceder a la base de datos y genera el panel de restaurantes con el mismo nombre*/
    public JPanelRellenarReserva(String nombre,String accion){
        this.setLayout(null);
        this.setBackground(new Color(221, 234, 245, 202));

        this.accion =accion;

        Client client=new Client();
        HashMap<String,Object> session=new HashMap<String, Object>();
        session.put("user",11);
        session.put("pass",11);
        ArrayList<Restaurante> respuesta;
        //ArrayList<Restaurante> rest;

        restaurantes = new JList<>();
        barra = new JScrollPane();

        session.put("restaurante", nombre);
        client.envio("/obtenerIguales",session);
        respuesta = (ArrayList<Restaurante>) session.get("RespuestaObtenerIguales");
        rest=new ArrayList<>();

        DefaultListModel<String> modelo = new DefaultListModel<>();

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

        lbltitulo = new JLabel("Seleccione la direccion del restaurante al que quiere ir: ");
        lbltitulo.setFont(new Font("Lirio", Font.BOLD, 20));
        lbltitulo.setForeground(Color.BLACK);
        lbltitulo.setHorizontalTextPosition( SwingConstants.CENTER );
        lbltitulo.setVerticalTextPosition( SwingConstants.BOTTOM );
        lbltitulo.setBackground(new Color(133, 177, 204, 182));
        lbltitulo.setBounds(125,180,550,50);
        this.add(lbltitulo);

        reservar= new JButton("SELECCIONAR");
        reservar.setFont(new Font("Lirio", Font.BOLD, 20));
        reservar.setForeground(Color.BLACK);
        reservar.setHorizontalTextPosition( SwingConstants.CENTER );
        reservar.setVerticalTextPosition( SwingConstants.BOTTOM );
        reservar.setBackground(new Color(133, 177, 204, 182));
        reservar.setBounds(225,510,350,50);
        reservar.addActionListener(this);
        this.add(reservar);

    }

    /**constructor que genera el panel para rellenar los datos de la reserva una vez seleccionado el restaurante y la direccion deseadas*/
    public JPanelRellenarReserva(String restauranteAReservar, int aux){

        this.setLayout(null);
        this.setBackground(new Color(221, 234, 245, 202));


        JLabel nombre, direccion, npersonas, hora, fecha, nombrepersona, npersona;
        JLabel nombreres, dirres;
        //JTextField textnpersonas;
        int identificador_del_restaurante;



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

        nombreresStr = nombreres.getText();

        //System.out.println(restauranteAReservar.substring(0,restauranteAReservar.indexOf(",")));
        // identificador_del_restaurante = restauranteAReservar.substring(0,restauranteAReservar.indexOf(","))

        direccion = new JLabel("Dirección");
        direccion.setFont(new Font("Lirio", Font.BOLD, 20));
        direccion.setForeground(Color.BLACK);
        direccion.setHorizontalTextPosition( SwingConstants.CENTER );
        direccion.setVerticalTextPosition( SwingConstants.BOTTOM );
        direccion.setBackground(new Color(133, 177, 204, 182));
        direccion.setBounds(60,200,100,50);
        this.add(direccion);

        dirres = new JLabel(restauranteAReservar.substring(restauranteAReservar.indexOf(".")+1,restauranteAReservar.indexOf("-")));
        dirres.setFont(new Font("Lirio", Font.BOLD, 18));
        dirres.setForeground(Color.BLACK);
        dirres.setHorizontalTextPosition( SwingConstants.LEFT );
        dirres.setVerticalTextPosition( SwingConstants.BOTTOM );
        dirres.setBackground(new Color(133, 177, 204, 182));
        dirres.setBounds(300,200,350,50);
        this.add(dirres);

        int identificador_restaurante;
        String direccion_restaurante;

       // System.out.println("LODEANTES");
        //Esto sirve para tener la dirección y compararla
        //System.out.println(restauranteAReservar.substring(restauranteAReservar.indexOf(",")+1,restauranteAReservar.indexOf("-")));
        String direccion_restaurante_elegido = restauranteAReservar.substring(restauranteAReservar.indexOf(",")+1,restauranteAReservar.indexOf("-"));
        //System.out.println("REST");
        //System.out.println(rest);

        //System.out.println("direccion restaaurante elegido");
        //System.out.println(direccion_restaurante_elegido);

        for(Restaurante r: rest)
        {
            identificador_restaurante = r.getNumeroId();

            String calle = r.getCalle();
            String dir = r.getDireccion();
            //System.out.println("direccionsita corta");
            String dir_corta = dir.substring(0, dir.indexOf(" "));
            int numero = r.getNumeroDirecc();

            direccion_restaurante = calle.trim() + " " + dir_corta.trim() + " " + numero;


            if((direccion_restaurante_elegido.trim()).equals(direccion_restaurante.trim()))
            {
                identificador_restaurante_definitivo = identificador_restaurante;
                direccion_restaurante_definitivo = direccion_restaurante;

                System.out.println("DEFINITIVOS");
                System.out.println(identificador_restaurante_definitivo);
                System.out.println(direccion_restaurante_definitivo);

            }

        }


        npersonas = new JLabel("Número de personas: ");
        npersonas.setFont(new Font("Lirio", Font.BOLD, 19));
        npersonas.setForeground(Color.BLACK);
        npersonas.setHorizontalTextPosition( SwingConstants.CENTER );
        //npersonas.setVerticalTextPosition( SwingConstants.BOTTOM );
        npersonas.setBackground(new Color(133, 177, 204, 182));
        npersonas.setBounds(60,250,220,50);
        this.add(npersonas);

        textnpersonas = new JTextField(2);
        textnpersonas.setBounds(300,265,40,30);
        textnpersonas.setFont(new Font("Lirio", Font.BOLD, 17));
        this.add(textnpersonas);

        //AQUI HAY ALGUN PROBLEMA CON EL PARSEINT PERO NO SE CUAL ES :(

        //String numPersonasStr= textnpersonas.getText();
        //System.out.println("NUMPERSONASSTR" + numPersonasStr);

        //Aqui hay issues

        /*
        try
        {
            numPersonas = Integer.parseInt(numPersonasStr);

            System.out.println("NUMERO PERSONAS!!!!!!!!!" + numPersonas);
        }
        catch (NumberFormatException nfe)
        {
            nfe.printStackTrace();
        }

         */




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

       // fechita = (Calendar) datePickerFecha.getModel().getValue();
       // dateStr = fechita.toString();


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


        comboBoxHoras = new JComboBox();
        comboBoxHoras.addItem("13:00");
        comboBoxHoras.addItem("13:30");
        comboBoxHoras.addItem("14:00");
        comboBoxHoras.addItem("14:30");
        comboBoxHoras.addItem("15:00");
        comboBoxHoras.addItem("15:30");
        comboBoxHoras.addItem("20:00");
        comboBoxHoras.addItem("20:30");
        comboBoxHoras.addItem("21:00");
        comboBoxHoras.addItem("21:30");
        comboBoxHoras.addItem("22:00");
        comboBoxHoras.addItem("22:30");
        comboBoxHoras.addItem("23:00");
        comboBoxHoras.addItem("23:30");
        comboBoxHoras.setFont(new Font("Lirio", Font.BOLD, 18));
        comboBoxHoras.setForeground(Color.BLACK);
       // comboBoxHoras.setHorizontalTextPosition( SwingConstants.CENTER );
       // comboBoxHoras.setVerticalTextPosition( SwingConstants.BOTTOM );
        comboBoxHoras.setBackground(new Color(133, 177, 204, 182));
        comboBoxHoras.setBounds(300,370,150,30);
        this.add(comboBoxHoras);

        //horaStr = (comboBoxHoras.getSelectedItem()).toString();

        /*
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


 */
        nombrepersona = new JLabel("Nombre de la reserva: ");
        nombrepersona.setFont(new Font("Lirio", Font.BOLD, 19));
        nombrepersona.setForeground(Color.BLACK);
        nombrepersona.setHorizontalTextPosition( SwingConstants.CENTER );
        nombrepersona.setVerticalTextPosition( SwingConstants.BOTTOM );
        nombrepersona.setBackground(new Color(133, 177, 204, 182));
        nombrepersona.setBounds(60,400,220,50);
        this.add(nombrepersona);

        //REVISAR!!!!!!!!!!!!!
       // JPanelPerfil.rellenarInfo();

        //npersona = new JLabel(JPanelPerfil.nombrec + " " + JPanelPerfil.apellidosc);
        npersona = new JLabel(JInicioSesion.cliente.getNombre()+ " " + JInicioSesion.cliente.getApellidos());
        npersona.setFont(new Font("Lirio", Font.BOLD, 19));
        npersona.setForeground(Color.BLACK);
        npersona.setHorizontalTextPosition( SwingConstants.CENTER );
        npersona.setVerticalTextPosition( SwingConstants.BOTTOM );
        npersona.setBackground(new Color(133, 177, 204, 182));
        npersona.setBounds(300,400,250,50);
        this.add(npersona);

        nombrePersonaStr = npersona.getText();

        usuarioStr= JInicioSesion.cliente.getId();


        pedido=new JCheckBox("Hacer pedido por adelantado");
        pedido.setFont(new Font("Lirio", Font.BOLD, 18));
        pedido.setForeground(Color.BLACK);
        //pedido.setHorizontalTextPosition( SwingConstants.CENTER );
        //pedido.setVerticalTextPosition( SwingConstants.BOTTOM );
        pedido.setBackground(new Color(221, 234, 245, 202));
        pedido.setBounds(60,460,400,30);
        this.add(pedido);

        /*

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
            */


        btnAceptarIntroDatos = new JButton("Aceptar");
        btnAceptarIntroDatos.setFont(new Font("Lirio", Font.BOLD, 25));
        btnAceptarIntroDatos.setForeground(Color.BLACK);
        btnAceptarIntroDatos.setBackground(new Color(133, 177, 204, 182));
        btnAceptarIntroDatos.setBounds(150, 500, 150, 50);
        btnAceptarIntroDatos.addActionListener(this);
        this.add(btnAceptarIntroDatos);

        btnCancelarIntroDatos = new JButton("Cancelar");
        btnCancelarIntroDatos.setFont(new Font("Lirio", Font.BOLD, 25));
        btnCancelarIntroDatos.setForeground(Color.BLACK);
        btnCancelarIntroDatos.setBackground(new Color(133, 177, 204, 182));
        btnCancelarIntroDatos.setBounds(350, 500, 150, 50);
        btnCancelarIntroDatos.addActionListener(this);
        this.add(btnCancelarIntroDatos);
    }


    /**Constructor del panel que se crea para visualizar la informacion del restaurante seleccionado*/
    public JPanelRellenarReserva(String restaurante)
    {
        this.setLayout(null);
        this.setBackground(new Color(221, 234, 245, 202));


        JLabel nombre, direccion, barrio, num;
        JLabel nombreres, dirres, barriores, numres;


        nombre = new JLabel("Restaurante");
        nombre.setFont(new Font("Lirio", Font.BOLD, 20));
        nombre.setForeground(Color.BLACK);
        nombre.setHorizontalTextPosition( SwingConstants.CENTER );
        nombre.setVerticalTextPosition( SwingConstants.BOTTOM );
        nombre.setBackground(new Color(133, 177, 204, 182));
        nombre.setBounds(90,200,150,50);
        this.add(nombre);

        nombreres = new JLabel(restaurante.substring(0,restaurante.indexOf(".")));
        nombreres.setFont(new Font("Lirio", Font.BOLD, 18));
        nombreres.setForeground(Color.BLACK);
        nombreres.setHorizontalTextPosition( SwingConstants.LEFT );
        nombreres.setVerticalTextPosition( SwingConstants.BOTTOM );
        nombreres.setBackground(new Color(133, 177, 204, 182));
        nombreres.setBounds(330,200,350,50);
        this.add(nombreres);

        direccion = new JLabel("Dirección");
        direccion.setFont(new Font("Lirio", Font.BOLD, 20));
        direccion.setForeground(Color.BLACK);
        direccion.setHorizontalTextPosition( SwingConstants.CENTER );
        direccion.setVerticalTextPosition( SwingConstants.BOTTOM );
        direccion.setBackground(new Color(133, 177, 204, 182));
        direccion.setBounds(90,250,100,50);
        this.add(direccion);

        dirres = new JLabel(restaurante.substring(restaurante.indexOf(".")+1,restaurante.indexOf(",")));
        dirres.setFont(new Font("Lirio", Font.BOLD, 18));
        dirres.setForeground(Color.BLACK);
        dirres.setHorizontalTextPosition( SwingConstants.LEFT );
        dirres.setVerticalTextPosition( SwingConstants.BOTTOM );
        dirres.setBackground(new Color(133, 177, 204, 182));
        dirres.setBounds(330,250,350,50);
        this.add(dirres);

        num = new JLabel("Número");
        num.setFont(new Font("Lirio", Font.BOLD, 20));
        num.setForeground(Color.BLACK);
        num.setHorizontalTextPosition( SwingConstants.CENTER );
        num.setVerticalTextPosition( SwingConstants.BOTTOM );
        num.setBackground(new Color(133, 177, 204, 182));
        num.setBounds(90,300,100,50);
        this.add(num);

        numres = new JLabel(restaurante.substring(restaurante.indexOf(",")+1, restaurante.indexOf("-")));
        numres.setFont(new Font("Lirio", Font.BOLD, 18));
        numres.setForeground(Color.BLACK);
        numres.setHorizontalTextPosition( SwingConstants.LEFT );
        numres.setVerticalTextPosition( SwingConstants.BOTTOM );
        numres.setBackground(new Color(133, 177, 204, 182));
        numres.setBounds(330,300,350,50);
        this.add(numres);

        barrio = new JLabel("Barrio");
        barrio.setFont(new Font("Lirio", Font.BOLD, 20));
        barrio.setForeground(Color.BLACK);
        barrio.setHorizontalTextPosition( SwingConstants.CENTER );
        barrio.setVerticalTextPosition( SwingConstants.BOTTOM );
        barrio.setBackground(new Color(133, 177, 204, 182));
        barrio.setBounds(90,350,100,50);
        this.add(barrio);

        barriores = new JLabel(restaurante.substring(restaurante.indexOf("-")+1));
        barriores.setFont(new Font("Lirio", Font.BOLD, 18));
        barriores.setForeground(Color.BLACK);
        barriores.setHorizontalTextPosition( SwingConstants.LEFT );
        barriores.setVerticalTextPosition( SwingConstants.BOTTOM );
        barriores.setBackground(new Color(133, 177, 204, 182));
        barriores.setBounds(330,350,350,50);
        this.add(barriores);

        ok=new JButton("OK");
        ok.setFont(new Font("Lirio", Font.BOLD, 25));
        ok.setForeground(Color.BLACK);
        ok.setBackground(new Color(133, 177, 204, 182));
        ok.setBounds(150, 500, 500, 30);
        ok.addActionListener(this);
        this.add(ok);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

       // String restauranteAReservar;
        if (e.getSource() == ok) {
            JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            topFrame.dispose();
        }
        if (e.getSource() == reservar) {
            try {
                if (restaurantes.getSelectedValue() != null) {

                     restauranteAReservar = restaurantes.getSelectedValue();

                    JPanel panel2 = new JPanelRellenarReserva(restauranteAReservar, 1);
                    JPanel panel3 = new JPanelRellenarReserva(restauranteAReservar);

                    if (this.accion.equals("reservar")) {
                        JInicioSesion.crearPanelPeque("Introducir Datos", panel2);
                    } else {
                        JInicioSesion.crearPanelPeque("Informacion del restaurante", panel3);
                    }

                    JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
                    topFrame.dispose();
                } else {
                    throw new ReservaException();
                }
            } catch (ReservaException re) {
                JOptionPane.showMessageDialog(JPanelRellenarReserva.this, re.getMessage());
            }
        }

        /*
        if (e.getSource()==btnCancelar)
        {
            JFrame  topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            topFrame.dispose();
        }

        if(e.getSource()==btnAceptar)
        {
            PnlHacerPedido pnlPedido = new PnlHacerPedido();
            if (pedido.isSelected()){
                JInicioSesion.crearPanelPeque("Hacer Pedido",pnlPedido);
            }
        }

         */
        if (e.getSource() == btnCancelarIntroDatos) {
            JFrame topFrame = (JFrame) Swingutilities.getWindowAncestor(this);
            topFrame.dispose();
        }

        if (e.getSource() == btnAceptarIntroDatos) {
            PnlHacerPedido pnlPedido = new PnlHacerPedido();
            if (pedido.isSelected()) {
                JInicioSesion.crearPanelPeque("Hacer Pedido", pnlPedido);
                pagado_reserva = true;
            }
            /**codigo de reserva **/
            codigo_reserva = codigo_reserva + 1; // dar retoques

            /**usuario que hace la reserva**/
            usuarioStr = JInicioSesion.cliente.getId();

            /**identificador de la reserva y restaurante (direccion)**/

            int identificador_restaurante;
            String direccion_restaurante;
            //if (introDatos == 1) {

            //System.out.println("Restaurante a reservar" + restauranteAReservar);
            String direccion_restaurante_elegido = restauranteAReservar.substring(restauranteAReservar.indexOf(",") + 1, restauranteAReservar.indexOf("-"));
           // String direccion_restaurante_elegido = restauranteAReservar.substring(0, restauranteAReservar.indexOf("-"));
            System.out.println("Direccc ressstt eleegggg" + direccion_restaurante_elegido);

            for (Restaurante r : rest) {
                identificador_restaurante = r.getNumeroId();

                String calle = r.getCalle();
                String dir = r.getDireccion();
                //System.out.println("direccionsita corta");
                String dir_corta = dir.substring(0, dir.indexOf(" "));
                int numero = r.getNumeroDirecc();

                direccion_restaurante = calle.trim() + " " + dir_corta.trim() + " " + numero;



                if ((direccion_restaurante_elegido.trim()).equals(direccion_restaurante.trim())) {
                    System.out.println("Dentr deeeee");
                    identificador_restaurante_definitivo = identificador_restaurante;
                    direccion_restaurante_definitivo = direccion_restaurante;

                    System.out.println("DEFINITIVOS");
                    System.out.println(identificador_restaurante_definitivo);
                    System.out.println(direccion_restaurante_definitivo);
                }
            }
           /* }
            else
            {
                Restaurante res_aleat = PnlRestaurantes.restauranteElegidoAleat;
                identificador_restaurante_definitivo = res_aleat.getNumeroId();

                //String direccion_restaurante_elegido = res_aleat
                //String direccion_restaurante_elegido = PnlRestaurantes.
            }
*/

            //de aqui usamos identificador_restaurante_definitivo

            /** fecha**/
            Calendar f = (Calendar) datePickerFecha.getModel().getValue();
            SimpleDateFormat sdfFecha = new SimpleDateFormat("dd-MM-yyyy");
            fechaStr = sdfFecha.format(new Date(f.getTimeInMillis()));


            //fechaStr = JPanelRellenarReserva.dateStr;  //modifciarr

            /** num personas **/
            numPersonasStr = textnpersonas.getText();

            /** hora **/
            horaStr = (JPanelRellenarReserva.comboBoxHoras.getSelectedItem()).toString();

            /**pagado**/
            //pagado_reserva


            System.out.println("codigo reserva" + codigo_reserva + "  usuarioStr " + usuarioStr + " identifi " + identificador_restaurante_definitivo);
            System.out.println(" fecha " + fechaStr + " num Personas " + numPersonasStr + " hora " + horaStr + " pagado " + pagado_reserva);


            try {
                rellenarReserva(codigo_reserva, usuarioStr, identificador_restaurante_definitivo, fechaStr, numPersonasStr, horaStr, pagado_reserva);
            } catch (RellenarReservaException rre) {
                rre.printStackTrace();
            }


        }
    }


        public void rellenarReserva (int codigo, String usuario, int identificador, String fecha, String numero_personas, String hora, boolean pagado) throws RellenarReservaException
    {
        Client client=new Client();
        HashMap<String,Object> session=new HashMap<String, Object>();
        session.put("codigo",codigo);
        session.put("usuario",usuario);
        session.put("identificador",identificador);
        session.put("fecha",fecha);
        session.put("numero_personas",numero_personas);
        session.put("hora",hora);
        session.put("pagado",pagado);
        client.envio("/hacerReserva",session);
        // CustomerDAO customerDAO = new CustomerDAO();
        int respuesta = (Integer) session.get("RespuestaReserva");
        //customerDAO.autenticar(user, pw.toString());
        if(respuesta == 1)
        {
            JOptionPane.showMessageDialog(JPanelRellenarReserva.this, "Reserva realizada correctamente.");
        }

        else if (respuesta ==0)
        {
            throw new RellenarReservaException();
        }
    }


}

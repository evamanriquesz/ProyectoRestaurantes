package main.java;


//import de.fhpotsdam.unfolding.UnfoldingMap;
import icai.dtc.isw.client.Client;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.TreeSet;

import java.io.*;

/**panel princpal en el que se muestra la lista de restaurantes, los filtros y mas adelante el mapa**/

public class PnlRestaurantes extends JPanel implements ActionListener, ChangeListener, Serializable{

    //private UnfoldingMap mapa;
    public ArrayList<Restaurante> restaurantes;
    public static JList<String> jlistrestaurantes;
    public static JList<String> restaurantesfiltrados;

    public static JPanel panelNorte;

    public static JPanel panelInfoRestaurante;

    public ArrayList<String> filtros;

    public JPanel panelReserva;

    Mapa map;

    JScrollPane barraDesplazamiento;

    JButton btnBuscar,btnGeneradorAleatorio,btnperfil, borrarfiltros, reservar, aceptar;

    JTextField jtxtBuscar,jtxtbarrio;
    JLabel lblfiltros, lbltitulo;

    JCheckBox tipo, restaurante, bar, taberna, comidarapida, barrio; //podriamos poner tambien valoraciones, valoraciones, una, dos, tres,cuatro,cinco;

    private Dimension dim;

    /**constructor del panel en el que inicializamos todos los elementos**/

    public PnlRestaurantes()
    {
        this.setLayout(null);
        //this.setBounds(0, 0, getMaximumSize().width, 1000);
        this.setBackground(new Color(221, 234, 245, 202));

        dim = super.getToolkit().getScreenSize();
        this.setSize(JInicioSesion.screenSize.width, JInicioSesion.screenSize.height-100);



        //super.setSize(dim);

        //para que cuando se inicie sesion y cambie a la pantalla principal se ponga en modo panalla completa:
        //this.setPreferredSize(new Dimension(getMaximumSize().width,getMaximumSize().height));
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        //lista de restaurantes de prueba que vamos usando para asegurarnos que se muestran en el scrollpane
        restaurantes = new ArrayList<Restaurante>();



        /**codigo para conectar con las bases de datos**/
        Client client=new Client();
        HashMap<String,Object> session=new HashMap<String, Object>();
        session.put("user",11);
        session.put("pass",11);
        client.envio("/obtenerListaRestaurantes",session);

        // CustomerDAO customerDAO = new CustomerDAO();
        ArrayList<Restaurante> respuesta = (ArrayList<Restaurante>) session.get("RespuestaObtenerListaRestaurantes");  //esto puede estar mal
        //ArrayList<Restaurante> respuesta = session.get("RespuestaObtenerListaRestaurantes");  //esto puede estar mal



        jlistrestaurantes = new JList<>();
        restaurantesfiltrados = new JList<>();
        barraDesplazamiento = new JScrollPane();

        DefaultListModel modelo = new DefaultListModel();


        for (Restaurante r: respuesta)
        {
            restaurantes.add(r);
            String nombre = r.getNombreRestaurante();
            modelo.addElement(nombre);
        }


        jlistrestaurantes.setModel(modelo);

        barraDesplazamiento.setViewportView(jlistrestaurantes);
        jlistrestaurantes.setLayoutOrientation(JList.VERTICAL);
        jlistrestaurantes.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jlistrestaurantes.setLayoutOrientation(JList.VERTICAL);

        jlistrestaurantes.setBackground(new Color(133, 177, 204, 182));
        jlistrestaurantes.setFont(new Font("Lirio", Font.ITALIC, 15));
        jlistrestaurantes.setForeground(Color.BLACK);




        barraDesplazamiento.setBounds(JInicioSesion.ancho-350-35,210,350,420);
        this.add(barraDesplazamiento);


        //info del boton reservar

        reservar= new JButton("RESERVAR");
        reservar.setFont(new Font("Lirio", Font.BOLD, 20));
        reservar.setForeground(Color.BLACK);
        reservar.setHorizontalTextPosition( SwingConstants.CENTER );
        reservar.setVerticalTextPosition( SwingConstants.BOTTOM );
        reservar.setBackground(new Color(133, 177, 204, 182));
        reservar.setBounds(JInicioSesion.ancho-350-35,640,350,60);
        reservar.addActionListener(this);
        this.add(reservar);

        jtxtBuscar = new JTextField(30);
        jtxtBuscar.setBounds(JInicioSesion.ancho-350-35,160,200,40);
        this.add(jtxtBuscar);

        btnBuscar = new JButton("BUSCAR");
        //btnBuscar.addActionListener(this);
        btnBuscar.setFont(new Font("Georgia", Font.BOLD, 12));
        btnBuscar.setForeground(Color.BLACK);
        btnBuscar.setHorizontalTextPosition( SwingConstants.CENTER );
        btnBuscar.setVerticalTextPosition( SwingConstants.BOTTOM );
        btnBuscar.setBackground(new Color(133, 177, 204, 182));//(90, 130, 156));
        btnBuscar.setBounds(JInicioSesion.ancho-130-35,160,130,40);
        this.add(btnBuscar);



        //cuando se apriete "enter" tras introducir en el buscador que se vaya al boton de buscar
        jtxtBuscar.addKeyListener (new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent keyEvent){
                if (keyEvent.getKeyCode() == KeyEvent.VK_ENTER)
                    btnBuscar.requestFocus();
            }
        });

        //si se presiona "enter" que guarde lo escrito en el buscador
        btnBuscar.addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent keyEvent){
                if(keyEvent.getKeyCode() == KeyEvent.VK_ENTER)
                    try{
                        String restauranteBuscado =jtxtBuscar.getText(); //aqui tenemos que poner algo del tipo, si existe este nombre en la base de datod
                        comprobarRestaurante(restauranteBuscado);
                    }
                    catch (BuscarRestauranteException bre) {
                        JOptionPane.showMessageDialog(PnlRestaurantes.this, bre.getMessage());
                        jtxtBuscar.setText("");
                        jtxtBuscar.requestFocus();
                    }

            }
        });

        //cuando se pulse que compare si esta el restaurante en la bbdd
        btnBuscar.addActionListener(e -> {
            try{
                String restauranteBuscado =jtxtBuscar.getText(); //aqui tenemos que poner algo del tipo, si existe este nombre en la base de datod
                comprobarRestaurante(restauranteBuscado.toUpperCase(Locale.ROOT));
                jtxtBuscar.setText("");
            }
            catch (BuscarRestauranteException bre) {
                JOptionPane.showMessageDialog(PnlRestaurantes.this, bre.getMessage());
                jtxtBuscar.setText("");
                jtxtBuscar.requestFocus();
            }
        });



        lblfiltros=new JLabel("Filtros: ");
        lblfiltros.setFont(new Font("Lirio", Font.ITALIC, 30));
        lblfiltros.setForeground(Color.BLACK);
        lblfiltros.setBounds(100,160,100,40);
        this.add(lblfiltros);

        tipo=new JCheckBox("Tipo de comida");
        tipo.setFont(new Font("Georgia", Font.BOLD, 15));
        tipo.setForeground(Color.BLACK);
        tipo.setBounds(80,230,180,30);
        tipo.setBackground(new Color(133, 177, 204, 182));
        this.add(tipo);

            restaurante =new JCheckBox("Restaurante");
            restaurante.setFont(new Font("Georgia", Font.BOLD, 15));
            restaurante.setForeground(Color.BLACK);
            restaurante.setBounds(100,270,160,30);
            restaurante.setBackground(new Color(133, 177, 204, 182));
            restaurante.setEnabled(false);
            this.add(restaurante);

            bar =new JCheckBox("Bar");
            bar.setFont(new Font("Georgia", Font.BOLD, 15));
            bar.setForeground(Color.BLACK);
            bar.setBounds(100,310,160,30);
            bar.setBackground(new Color(133, 177, 204, 182));
            bar.setEnabled(false);
            this.add(bar);

            taberna =new JCheckBox("Taberna");
            taberna.setFont(new Font("Georgia", Font.BOLD, 15));
            taberna.setForeground(Color.BLACK);
            taberna.setBounds(100,350,160,30);
            taberna.setBackground(new Color(133, 177, 204, 182));
            taberna.setEnabled(false);
            this.add(taberna);

            comidarapida=new JCheckBox("Comida Rápida");
            comidarapida.setFont(new Font("Georgia", Font.BOLD, 15));
            comidarapida.setForeground(Color.BLACK);
            comidarapida.setBounds(100,390,160,30);
            comidarapida.setBackground(new Color(133, 177, 204, 182));
            comidarapida.setEnabled(false);
            this.add(comidarapida);

        barrio =new JCheckBox("Barrio");
        barrio.setFont(new Font("Georgia", Font.BOLD, 15));
        barrio.setForeground(Color.BLACK);
        barrio.setBounds(80,450,180,30);
        barrio.setBackground(new Color(133, 177, 204, 182));
        this.add(barrio);

            jtxtbarrio=new JTextField(20);
            jtxtbarrio .setBounds(100,490,160,30);
            jtxtbarrio.setEnabled(false);
            this.add(jtxtbarrio);

        tipo.addChangeListener(this);
        barrio.addChangeListener(this);


        borrarfiltros=new JButton("Borrar filtros");
        borrarfiltros.setFont(new Font("Lirio", Font.BOLD, 15));
        borrarfiltros.setForeground(Color.BLACK);
        borrarfiltros.setHorizontalTextPosition( SwingConstants.CENTER );
        borrarfiltros.setVerticalTextPosition( SwingConstants.BOTTOM );
        borrarfiltros.setBackground(new Color(133, 177, 204, 182));
        borrarfiltros.setBounds(80,580,200,20);
        borrarfiltros.addActionListener(this);
        this.add(borrarfiltros);

        aceptar=new JButton("Aceptar");
        aceptar.setFont(new Font("Lirio", Font.BOLD, 15));
        aceptar.setForeground(Color.BLACK);
        aceptar.setHorizontalTextPosition( SwingConstants.CENTER );
        aceptar.setVerticalTextPosition( SwingConstants.BOTTOM );
        aceptar.setBackground(new Color(133, 177, 204, 182));
        aceptar.setBounds(80,550,200,20);
        aceptar.addActionListener(this);
        aceptar.setEnabled(false);
        this.add(aceptar);


        btnGeneradorAleatorio= new JButton();
        btnGeneradorAleatorio.setText("<html><p>RESTAURANTE</p><p>ALEATORIO</p></html>");
        btnGeneradorAleatorio.setFont(new Font("Georgia", Font.BOLD, 20));
        btnGeneradorAleatorio.setForeground(Color.BLACK);
        btnGeneradorAleatorio.setHorizontalTextPosition( SwingConstants.CENTER );
        btnGeneradorAleatorio.setVerticalTextPosition( SwingConstants.BOTTOM );
        btnGeneradorAleatorio.setBackground(new Color(133, 177, 204, 182));
        btnGeneradorAleatorio.setBounds(80,620,200,80);
        this.add(btnGeneradorAleatorio);


        btnperfil = new JButton();
        ImageIcon perfil = new ImageIcon("src"+ File.separator +"main"+ File.separator + "resources" + File.separator + "perfilcoloreado.bmp.png");
        ImageIcon imagenperfil = new ImageIcon(perfil.getImage().getScaledInstance(80,-1,Image.SCALE_DEFAULT));
        //imagen del logo
        btnperfil.setIcon(imagenperfil);
        //btnperfil.setBackground(new Color(90, 130, 156));
        btnperfil.setBounds(JInicioSesion.ancho-120,10,80,80);
        btnperfil.addActionListener(this);
        JInicioSesion.panelNorte.add(btnperfil);


        // map = new Mapa(40.429944f, -3.712778f, 480, 310); //coordenadas icai


        //map=new Mapa();//(40.429944f, -3.712778f);
        //map.setBounds(180,150,400,310);
        //this.add(map);

    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==btnperfil)
        {
            JInicioSesion.crearPanelPeque("MI PERFIL", JInicioSesion.panelperfil);
           // JInicioSesion.informacionCliente(JInicioSesion.usuario);
            if (JInicioSesion.cliente!=null)
            {
                JPanelPerfil.rellenarInfo();
            }

        }


        if (e.getSource()==borrarfiltros)
        {
            if(tipo.isSelected())
            {
                tipo.setSelected(false);
            }
            if(barrio.isSelected())
            {
                barrio.setSelected(false);
            }

            barraDesplazamiento.setViewportView(jlistrestaurantes);
            jlistrestaurantes.setLayoutOrientation(JList.VERTICAL);
            jlistrestaurantes.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

            jlistrestaurantes.setLayoutOrientation(JList.VERTICAL);

            jlistrestaurantes.setBackground(new Color(133, 177, 204, 182));
            jlistrestaurantes.setFont(new Font("Lirio", Font.ITALIC, 15));
            jlistrestaurantes.setForeground(Color.BLACK);

            restaurantesfiltrados.setVisible(false);
            jlistrestaurantes.setVisible(true);

            barraDesplazamiento.setBounds(JInicioSesion.ancho-350-35,210,350,420);
            this.add(barraDesplazamiento);

        }

        if (e.getSource()==aceptar)
        {
            try {
                if (restaurante.isSelected()) {
                    aplicarFiltros("RESTAURANTE");
                }
                if (bar.isSelected()) {
                    aplicarFiltros("BAR RESTAURANTE");
                }
                if (taberna.isSelected()) {
                    aplicarFiltros("TABERNA");
                }
                if (comidarapida.isSelected()) {
                    aplicarFiltros("RESTAURANTES DE COMIDA RAPIDA");
                }
                if (barrio.isSelected()) {
                    aplicarFiltros(jtxtbarrio.getText().toUpperCase(Locale.ROOT));
                }
            }catch (FiltrosException fe) {
                JOptionPane.showMessageDialog(PnlRestaurantes.this, fe.getMessage());
                if(tipo.isSelected())
                {
                    tipo.setSelected(false);
                }
                if(barrio.isSelected())
                {
                    barrio.setSelected(false);
                }
            }
        }

        if(e.getSource()==reservar)
        {
            try{
            if(jlistrestaurantes.isVisible()){
                if (jlistrestaurantes.getSelectedValue()!=null) {
                    String name=jlistrestaurantes.getSelectedValue();
                    reservarRestaurante(name);
                }else{
                    throw new ReservaException();
                }
            }else if(restaurantesfiltrados.isVisible())
            {
                if (restaurantesfiltrados.getSelectedValue()!=null) {
                    String name=restaurantesfiltrados.getSelectedValue();
                    reservarRestaurante(name);
                }else{
                    throw new ReservaException();
                }
            }
            }catch (ReservaException re){
                JOptionPane.showMessageDialog(PnlRestaurantes.this, re.getMessage());

            }

        }
    }

    @Override
    public void stateChanged(ChangeEvent e)
    {
        if(tipo.isSelected()) {
            restaurante.setEnabled(true);
            bar.setEnabled(true);
            taberna.setEnabled(true);
            comidarapida.setEnabled(true);
        }else{
            restaurante.setSelected(false);
            bar.setSelected(false);
            taberna.setSelected(false);
            comidarapida.setSelected(false);

            restaurante.setEnabled(false);
            bar.setEnabled(false);
            taberna.setEnabled(false);
            comidarapida.setEnabled(false);

        }
        if(restaurante.isSelected()||bar.isSelected()||taberna.isSelected()||comidarapida.isSelected())
        {
            aceptar.setEnabled(true);
        }
        if (barrio.isSelected())
        {
            jtxtbarrio.setEnabled(true);
            aceptar.setEnabled(true);
        }else{
            jtxtbarrio.setText("");
            jtxtbarrio.setEnabled(false);
        }

    }

    /**metodo que conecta el panel con la base de datos de restaurantes**/

    public void comprobarRestaurante(String restaurante) throws BuscarRestauranteException {
        //Atilano
        Client client=new Client();
        HashMap<String,Object> session=new HashMap<String, Object>();
        session.put("restaurante",restaurante);

        client.envio("/buscarRestaurante",session);
        // CustomerDAO customerDAO = new CustomerDAO();
        int respuesta = (Integer) session.get("RespuestaBuscarRestaurante");  //esto puede estar mal
        //customerDAO.autenticar(user, pw.toString());
        if(respuesta == 1)
        {
            PnlRestaurantes.jlistrestaurantes.setSelectedValue(restaurante,true);
        }
        else if (respuesta ==0)
        {
            throw new BuscarRestauranteException();
        }
    }
/**metodo que conecta con la base de datos para filtrar el listado de restaurantes segun lo seleccionado en los checkboxes*/
    public void aplicarFiltros (String filtro) throws FiltrosException {
        /**codigo para conectar con las bases de datos**/
        Client client=new Client();
        HashMap<String,Object> session=new HashMap<String, Object>();
        session.put("user",11);
        session.put("pass",11);
        int i=1;
        ArrayList<Restaurante> resfiltrados = new ArrayList<>();
        ArrayList<Restaurante> respuesta;

        session.put("filtro", filtro);
        client.envio("/filtrar",session);
        respuesta = (ArrayList<Restaurante>) session.get("RespuestaFiltrar");
        /*for (String s :filtros)
        {
            session.put("filtro"+ i,s);
            client.envio("/filtrar",session);
            respuesta = (ArrayList<Restaurante>) session.get("RespuestaFiltrar");
        }*/


        DefaultListModel modelo = new DefaultListModel();

        for (Restaurante r: respuesta)
        {
            resfiltrados.add(r);
            String nombre = r.getNombreRestaurante();
            modelo.addElement(nombre);
        }


        if(resfiltrados.size()>1)
        {
            System.out.println("el vector no esta vacio");
            restaurantesfiltrados.setModel(modelo);

            barraDesplazamiento.setViewportView(restaurantesfiltrados);
            restaurantesfiltrados.setLayoutOrientation(JList.VERTICAL);
            restaurantesfiltrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

            restaurantesfiltrados.setLayoutOrientation(JList.VERTICAL);

            restaurantesfiltrados.setBackground(new Color(133, 177, 204, 182));
            restaurantesfiltrados.setFont(new Font("Lirio", Font.ITALIC, 15));
            restaurantesfiltrados.setForeground(Color.BLACK);


            jlistrestaurantes.setVisible(false);
            restaurantesfiltrados.setVisible(true);

            barraDesplazamiento.setBounds(JInicioSesion.ancho-350-35,210,350,420);
            this.add(barraDesplazamiento);

            JOptionPane.showMessageDialog(PnlRestaurantes.this, "Se ha actualizado la lista de restaurantes.");

        }else{
            System.out.println("el vector esta vacio");
            throw new FiltrosException();
        }


    }

    public void reservarRestaurante (String nombre){
        panelReserva = new JPanelInfoRestaurante(nombre);
        JInicioSesion.crearPanelPeque("RESERVA", panelReserva);

    }


}


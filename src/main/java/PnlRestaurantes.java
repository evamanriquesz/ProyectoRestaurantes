package main.java;


import javax.swing.*;
import java.awt.*;
import java.util.TreeSet;

//panel de restaurantes hecho a mano

public class PnlRestaurantes extends JPnlFondo {

    public TreeSet<Restaurante> restaurantes;
    public static JList<String> jlistrestaurantes;


    String[] listarestaurantes = new String[25];

    JLabel lblRestaurantes;

    public PnlRestaurantes()
    {
        // restaurantes = IO.leerFicheroRestaurantes(); //no sirve porque no usamos la clase io ni ficheros
        this.setBounds(0, 0, 800, 600);


        //lista de restaurantes de prueba que vamos usando para asegurarnos que se muestran en el scrollpane
        restaurantes = new TreeSet<>();

        restaurantes.add(new Restaurante("Ginos", "Calle Julian Romea, 4 "));
        restaurantes.add(new Restaurante("La Máquina", "Calle Ponzano, 39"));
        restaurantes.add(new Restaurante("Lateral", "Pº Castellana, 42"));
        restaurantes.add(new Restaurante("Five Guys", "Calle Gran Via, 44"));
        //System.out.println(restaurantes);


        jlistrestaurantes = new JList<>(listarestaurantes);
        JScrollPane barraDesplazamiento = new JScrollPane(jlistrestaurantes);


        lblRestaurantes =new JLabel("Restaurantes");
        lblRestaurantes.setFont(new Font("Freestyle Script", Font.BOLD, 40));

        lblRestaurantes.setBounds(300,50,300,100);
        this.add(lblRestaurantes);


        barraDesplazamiento.setViewportView(jlistrestaurantes);
        jlistrestaurantes.setLayoutOrientation(JList.VERTICAL);
        jlistrestaurantes.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jlistrestaurantes.setBackground(new Color(161, 201, 236));
        jlistrestaurantes.setLayoutOrientation(JList.VERTICAL);

        //recorremos el treeset de restaurantes para guardarlo en el vector de Strings que semete en el jlist
        for (Restaurante r : restaurantes)
        {
            for (int i = 0; i < listarestaurantes.length; i++){

                if(listarestaurantes[i]==null) {
                    listarestaurantes[i] = r.getNombre() + "," + r.getDireccion();
                    i = listarestaurantes.length;
                }
            }
        }
        jlistrestaurantes.setBackground(new Color(113, 152, 180));
        jlistrestaurantes.setFont(new Font("Georgia", Font.BOLD, 20));

        barraDesplazamiento.setBounds(250,150,300,150);
        this.add(barraDesplazamiento);


    }
}

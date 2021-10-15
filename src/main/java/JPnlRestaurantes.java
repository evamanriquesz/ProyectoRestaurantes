package main.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.TreeSet;

//clase que estamos intentado crear para el panel de restaurantes con la ayuda del gui

public class JPnlRestaurantes extends JPanel{
    public JList jlistrestaurantes;


    public TreeSet<Restaurante> restaurantes;

    String[] listarestaurantes = new String[25];
    private JLabel lblRestaurantes;
    private JLabel logo;
    private JPanel panelRest;
    private JScrollPane scroll;

    public JPnlRestaurantes(){


        restaurantes = new TreeSet<>();

        restaurantes.add(new Restaurante("Ginos", "Calle Julian Romea, 4 "));
        restaurantes.add(new Restaurante("La Máquina", "Calle Ponzano, 39"));
        restaurantes.add(new Restaurante("Lateral", "Pº Castellana, 42"));
        restaurantes.add(new Restaurante("Five Guys", "Calle Gran Via, 44"));

        lblRestaurantes.setFont(new Font("Freestyle Script", Font.BOLD, 40));

        jlistrestaurantes = new JList<>(listarestaurantes);
       // barraDesplazamiento = new JScrollPane(jlistrestaurantes);

        for (Restaurante r : restaurantes)
        {
            for (int i = 0; i < listarestaurantes.length; i++){

                if(listarestaurantes[i]==null) {
                    listarestaurantes[i] = r.getNombre() + "," + r.getDireccion();
                    i = listarestaurantes.length;
                }
            }
        }

        //this.add(lblRestaurantes);
        this.add(panelRest);

    }


}

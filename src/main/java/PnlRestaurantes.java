package main.java;

import main.java.JPnlFondo;

import javax.swing.*;
import java.awt.*;
import java.util.TreeSet;

public class PnlRestaurantes extends JPnlFondo {

    TreeSet<Restaurante> restaurantes;
    public static JList<String> jlistrestaurantes;


    String[] listarestaurantes = new String[25];

    JLabel label;

    public PnlRestaurantes()
    {
        restaurantes = IO.leerFicheroRestaurantes();
        jlistrestaurantes = new JList<>(listarestaurantes);
        JScrollPane barraDesplazamiento = new JScrollPane(jlistrestaurantes);



        jlistrestaurantes = new JList<>(listarestaurantes);
        //btnAnadir = new JButton("Añadir al carrito");
        //btonCarrito = new JButton();


        label =new JLabel("Colgantes");
        label.setFont(new Font("Freestyle Script", Font.BOLD, 40));


        config.gridx=3;
        config.gridy=2;
        config.gridwidth=4;
        config.gridheight=1;
        config.weighty = 1.0;
        config.anchor= GridBagConstraints.CENTER;
        config.fill= GridBagConstraints.BOTH;
        this.add(label,config);


        barraDesplazamiento.setViewportView(jlistrestaurantes);
        jlistrestaurantes.setLayoutOrientation(JList.VERTICAL);
        jlistrestaurantes.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jlistrestaurantes.setBackground(new Color(249, 226, 219));
        jlistrestaurantes.setFont(new Font("Georgia", Font.BOLD, 20));


        for (Restaurante r : restaurantes)
        {
            for (int i = 0; i < listarestaurantes.length; i++){

                if(listarestaurantes[i]==null) {
                    listarestaurantes[i] = r.getNombre();
                    i = listarestaurantes.length;
                }
            }
        }

        config.gridx=2;
        config.gridy=3;
        config.gridwidth=3;
        config.gridheight=1;
        config.weighty = 1.0;
        config.anchor= GridBagConstraints.CENTER;
        config.fill= GridBagConstraints.BOTH;
        this.add(barraDesplazamiento,config);
    }
}

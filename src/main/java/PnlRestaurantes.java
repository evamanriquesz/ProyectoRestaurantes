package main.java;

import main.java.JPnlFondo;
import main.java.Restaurante;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.TreeSet;

public class PnlRestaurantes extends JPnlFondo {

    public TreeSet<Restaurante> restaurantes;
    public static JList<String> jlistrestaurantes;


    String[] listarestaurantes = new String[25];

    JLabel lblRestaurantes;

    public PnlRestaurantes()
    {
        // restaurantes = IO.leerFicheroRestaurantes();
        this.setBounds(0, 0, 800, 600);



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

       //JPanel pnlNorte = new JPanel(new FlowLayout());
        //pnlNorte.add(lblRestaurantes);

      /*  config.gridx=3;
        config.gridy=2;
        config.gridwidth=4;
        config.gridheight=1;
        config.weighty = 1.0;
        config.anchor= GridBagConstraints.CENTER;
        config.fill= GridBagConstraints.BOTH;
        this.add(lblRestaurantes,config);

        config.weighty = 0.0;*/



        barraDesplazamiento.setViewportView(jlistrestaurantes);
        jlistrestaurantes.setLayoutOrientation(JList.VERTICAL);
        jlistrestaurantes.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jlistrestaurantes.setBackground(new Color(161, 201, 236));
        jlistrestaurantes.setLayoutOrientation(JList.VERTICAL);

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

       /* config.gridx=2;
        config.gridy=3;
        config.gridwidth=3;
        config.gridheight=1;
        config.weighty = 1.0;
        config.anchor= GridBagConstraints.CENTER;
        config.fill= GridBagConstraints.BOTH;
        this.add(barraDesplazamiento,config);*/
    }
}

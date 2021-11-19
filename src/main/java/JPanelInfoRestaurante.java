package main.java;

import javax.swing.*;
import java.awt.*;

public class JPanelInfoRestaurante extends JPanel
{
    JLabel lblTitulo, lblNombreRestaurante, lblNombreCalle, lblNumeroCalle;
    //JButton reservar;

    public JPanelInfoRestaurante(){
        this.setLayout(null);
        this.setBackground(new Color(221, 234, 245, 202));


        lblNombreRestaurante = new JLabel("NOMBRE: ");
        lblNombreRestaurante.setFont(new Font("Lirio", Font.BOLD, 20));
        lblNombreRestaurante.setForeground(Color.BLACK);
        lblNombreRestaurante.setBounds(80,150,150,30);
        lblNombreRestaurante.setHorizontalTextPosition( SwingConstants.LEFT);
        lblNombreRestaurante.setVerticalTextPosition( SwingConstants.BOTTOM );
        this.add(lblNombreRestaurante);


        lblNombreCalle = new JLabel("CALLE: ");
        lblNombreCalle.setFont(new Font("Lirio", Font.BOLD, 20));
        lblNombreCalle.setForeground(Color.BLACK);
        lblNombreCalle.setBounds(80,190,150,30);
        this.add(lblNombreCalle);


        lblNumeroCalle = new JLabel("NÚMERO: ");
        lblNumeroCalle.setFont(new Font("Lirio", Font.BOLD, 20));
        lblNumeroCalle.setForeground(Color.BLACK);
        lblNumeroCalle.setBounds(80,230,150,30);
        this.add(lblNumeroCalle);







    }
}

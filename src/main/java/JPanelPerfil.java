package main.java;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class JPanelPerfil extends JPanel {

    JLabel lbltitulo, nombre, apellidos, edad, correo,imagen;
    JButton verReservasActuales, verReservasAnteriores;

    public JPanelPerfil(){

        this.setLayout(null);
        //this.setBounds(0, 0, 600, 400);
        this.setBackground(new Color(221, 234, 245, 202));


        nombre = new JLabel("NOMBRE: ");
        nombre.setFont(new Font("Lirio", Font.BOLD, 20));
        nombre.setForeground(Color.BLACK);
        nombre.setBounds(80,150,150,30);
        nombre.setHorizontalTextPosition( SwingConstants.LEFT);
        nombre.setVerticalTextPosition( SwingConstants.BOTTOM );
        this.add(nombre);

        apellidos = new JLabel("APELLIDOS: ");
        apellidos.setFont(new Font("Lirio", Font.BOLD, 20));
        apellidos.setForeground(Color.BLACK);
        apellidos.setBounds(80,190,150,30);
        this.add(apellidos);

        edad = new JLabel("EDAD: ");
        edad.setFont(new Font("Lirio", Font.BOLD, 20));
        edad.setForeground(Color.BLACK);
        edad.setBounds(80,230,150,30);
        this.add(edad);

        correo = new JLabel("CORREO: ");
        correo.setFont(new Font("Lirio", Font.BOLD, 20));
        correo.setForeground(Color.BLACK);
        correo.setBounds(80,270,150,30);
        this.add(correo);

    }
}

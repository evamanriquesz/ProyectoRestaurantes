package main.java;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class JPanelPerfil extends JPanel {

    JLabel perfil, nombre, apellidos, edad, correo,imagen;
    JButton verReservasActuales, verReservasAnteriores;

    public JPanelPerfil(){

        this.setBounds(0, 0, 600, 400);
        this.setBackground(new Color(141, 182, 206));

        imagen = new JLabel();

        ImageIcon dcby = new ImageIcon("src"+ File.separator +"main"+ File.separator + "resources" + File.separator + "dcbyoscuro.png");
        ImageIcon imagendcby = new ImageIcon(dcby.getImage().getScaledInstance(80,-1,Image.SCALE_DEFAULT));
        //imagen del logo
        imagen.setIcon(imagendcby);
    //.setBackground(new Color(249, 226, 219));
        imagen.setBounds(20,20,80,80);
        this.add(imagen);

        perfil= new JLabel("MI PERFIL");
        perfil.setFont(new Font("Georgia", Font.BOLD, 50));
        perfil.setForeground(Color.BLACK);
        perfil.setBounds(150,20,100,80);
        this.add(perfil);

        nombre = new JLabel("NOMBRE: ");
        nombre.setFont(new Font("Georgia", Font.BOLD, 10));
        nombre.setForeground(Color.BLACK);
        nombre.setBounds(80,150,100,20);
        nombre.setHorizontalTextPosition( SwingConstants.LEFT);
        nombre.setVerticalTextPosition( SwingConstants.BOTTOM );
        this.add(nombre);

        apellidos = new JLabel("APELLIDOS: ");
        apellidos.setFont(new Font("Georgia", Font.BOLD, 10));
        apellidos.setForeground(Color.BLACK);
        apellidos.setBounds(80,180,100,20);
        this.add(apellidos);

        edad = new JLabel("EDAD: ");
        edad.setFont(new Font("Georgia", Font.BOLD, 10));
        edad.setForeground(Color.BLACK);
        edad.setBounds(80,210,100,20);
        this.add(edad);

        correo = new JLabel("CORREO: ");
        correo.setFont(new Font("Georgia", Font.BOLD, 10));
        correo.setForeground(Color.BLACK);
        correo.setBounds(80,240,100,20);
        this.add(correo);

    }
}

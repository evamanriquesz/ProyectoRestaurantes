package main.java;

import java.util.TreeSet;

public class Restaurante {

    private String nombre, direccion;

    public Restaurante (String nombre, String direccion)
    {
        this.nombre=nombre;
        this.direccion=direccion;
    }



    public String getNombre()
    {
        return this.nombre;
    }
}

package main.java;

import java.io.Serializable;

public class Cliente extends Usuario implements Serializable {

    private int telefono;
    private String correo;
    private String apellidos;
    private String nombre;
    private String id;

    public Cliente()
    {

    }

    public Cliente (String usuario)
    {
        this.id=usuario;
    }

    public Cliente (String id, String nombre,int telefono, String correo, String apellidos)
    {
        this.id=id;
        this.nombre=nombre;
        this.telefono=telefono;
        this.correo=correo;
        this.apellidos=apellidos;
    }

    public String getNombre(){return this.nombre;}

    public int getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getId() {
        return id;
    }

    public String toString(){
        return("CLIENTE: " + getNombre() + " " + getApellidos() + "," + getTelefono() + "," + getCorreo() + ", @"+ getId());

    }
}

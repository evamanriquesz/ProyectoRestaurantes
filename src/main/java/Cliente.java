package main.java;

import java.io.Serializable;


/**Objeto cliente que guarda los datos de un usuario al que se le puede asociar una tarjeta de crédito*/

public class Cliente extends Usuario implements Serializable {

    private int telefono;
    private String correo;
    private String apellidos;
    private String nombre;
    private String id;
    private String password;
    public TarjetaCredito tarjeta;

    public Cliente()
    {

    }

    public Cliente (String usuario)
    {
        this.id=usuario;
    }

    public Cliente (String id, String nombre,int telefono, String correo, String apellidos, String password)
    {
        this.id=id;
        this.nombre=nombre;
        this.telefono=telefono;
        this.correo=correo;
        this.apellidos=apellidos;
        this.password=password;
    }

    public Cliente (String id, String nombre,int telefono, String correo, String apellidos)
    {
        this.id=id;
        this.nombre=nombre;
        this.telefono=telefono;
        this.correo=correo;
        this.apellidos=apellidos;
    }

    /**Seter para asociar una tarjeta de crédito
     * @throws ExceptionFecha  si se introduce una fecha anterior a la actual*/
    public void setTarjeta(String nombre, String numero, int cvv, String fechaCad) throws ExceptionFecha {
            this.tarjeta=new TarjetaCredito(nombre, numero, cvv, fechaCad);
    }

    public void setTarjeta(TarjetaCredito t)
    {
        this.tarjeta=t;
    }

    public TarjetaCredito getTarjeta(){
        return this.tarjeta;
    }

    public String getPassword(){return this.password;}

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

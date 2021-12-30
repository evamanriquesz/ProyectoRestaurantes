package main.java;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDate;

/**Clase del objeto Tarjeta de crédito que guarda la informacion referente a ella*/
public class TarjetaCredito implements Serializable
{
    String nombrePropietario;
    String ntarjeta;
    int cvv;
    LocalDate fechaCaducidad;


    /**Constructor para incluir toda la informacion de una vez
     * @throws ExceptionFecha  si se introduce una fecha anterior a la actual*/
    public TarjetaCredito (String nombrePropietario, String ntarjeta, int cvv, String fechaCaducidad) throws ExceptionFecha {
        this.nombrePropietario=nombrePropietario;
        this.ntarjeta=ntarjeta;
        this.cvv=cvv;
        this.setFechaCaducidad(fechaCaducidad);
    }

    /**Constructor sin incluir la fecha para añadirla mas tarde con el setter*/
    public TarjetaCredito(String nombre, String ntarjeta, int cvv)
    {
        this.nombrePropietario=nombre;
        this.ntarjeta=ntarjeta;
        this.cvv=cvv;
    }

    /**Constructor vacío para inicializar los objetos antes de hacer nada con ellos*/
    public TarjetaCredito(){}

    /**Setter de la fecha decaducidad que  recibe la fecha como un String
     * @throws ExceptionFecha  si se introduce una fecha anterior a la actual*/
    public void setFechaCaducidad(String fechaCaducidad) throws ExceptionFecha {
       LocalDate hoy = LocalDate.now();

        String[] parts = fechaCaducidad.split("-");
        int anio = Integer.parseInt(parts[0]);
        int mes=  Integer.parseInt(parts[1]);

        LocalDate fechaCad= LocalDate.of(anio,mes, 1);
        if(fechaCad.isBefore(hoy)){
            throw  new ExceptionFecha();
        }else {
            this.fechaCaducidad = fechaCad;
        }
    }

    /**Setter de la fecha decaducidad que  recibe la fecha como un LocalDate
     *  @throws ExceptionFecha  si se introduce una fecha anterior a la actual
     */
    public void setFechaCaducidad(LocalDate fechaCad)throws ExceptionFecha{
        LocalDate hoy = LocalDate.now();
        if(fechaCad.isBefore(hoy)){
            throw  new ExceptionFecha();
        }else {
            this.fechaCaducidad = fechaCad;
        }
    }

    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public String getNtarjeta() {
        return ntarjeta;
    }

    public int getCvv() {
        return cvv;
    }

    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }

    public String toString ()
    {
        return "TARJETA DE CREDITO DEL CLIENTE : nombre propietario: " + getNombrePropietario() + " ,numero de tarjeta: "+ getNtarjeta() + " ,cvv: " +getCvv() + " ,fecha de caducidad : " + getFechaCaducidad().toString();
    }
}


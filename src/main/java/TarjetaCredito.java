package main.java;

import javax.swing.*;
import java.time.LocalDate;
import java.util.Date;

public class TarjetaCredito
{
    String nombrePropietario;
    int ntarjeta;
    int cvv;
    LocalDate fechaCaducidad;

    public TarjetaCredito (String nombrePropietario, int ntarjeta, int cvv, LocalDate fechaCaducidad)
    {
        this.nombrePropietario=nombrePropietario;
        this.ntarjeta=ntarjeta;
        this.cvv=cvv;
        this.setFechaCaducidad(fechaCaducidad);
    }

    public void setFechaCaducidad(LocalDate fechaCaducidad) {
       LocalDate hoy = LocalDate.now();

        if(fechaCaducidad.isBefore(hoy)){

        }
        this.fechaCaducidad = fechaCaducidad;
    }

    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public int getNtarjeta() {
        return ntarjeta;
    }

    public int getCvv() {
        return cvv;
    }

    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }

    /*public static JPanel panelEditar()
    {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel nombre = new JLabel("NOMBRE DEL PROPIETARIO");
        JLabel numero = new JLabel("NUMERO DE LA TARJETA");
        JLabel cvv = new JLabel("CÓDIGO CVV");
        JLabel fechacad = new JLabel("FECHA DE CADUCIDAD");

        return panel;
    }*/
}


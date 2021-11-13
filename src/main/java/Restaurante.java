package main.java;

import java.io.Serializable;
import java.util.TreeSet;
import java.util.*;

public class Restaurante implements Comparable, Serializable {

    private String nombreRestaurante, nombreDistrito, calle, direccion, tipoRest;
    private double coordX, coordY;
    private int idDistrito, numeroDirecc, numeroId;

    public Restaurante (String nombreRestaurante, int idDistrito, String nombreDistrito, double coordX, double coordY, String calle, String direccion, int numeroDirecc, String tipoRest, int numeroId)
    {
        this.nombreRestaurante=nombreRestaurante;
        this.idDistrito = idDistrito;
        this.nombreDistrito=nombreDistrito;
        this.coordX = coordX;
        this.coordY = coordY;
        this.calle = calle;
        this.direccion= direccion;
        this.numeroDirecc = numeroDirecc;
        this.tipoRest = tipoRest;
        this.numeroId = numeroId;

    }

    public String getNombreRestaurante()
    {
        return this.nombreRestaurante;
    }
    public String getNombreDistrito() {return this.nombreDistrito;}
    public int getIdDistrito() {return this.idDistrito;}
    public double getCoordX() {return this.coordX;}
    public double getCoordY() {return this.coordY;}
    public String getCalle() {return this.calle;}
    public String getDireccion()
    {
        return this.direccion;
    }
    public int getNumeroDirecc() {return this.numeroDirecc;}
    public String getTipoRest(){return this.tipoRest;}
    public int getNumeroId(){return this.numeroId;}

    @Override
    public int compareTo(Object o) {
        if(o instanceof Restaurante) {
            Restaurante r = (Restaurante) o;

            if (this.getNombreRestaurante().equals(r.getNombreRestaurante()))
                if (this.getDireccion().equals(r.getDireccion()))
                    return 0;
                else
                    return this.getDireccion().compareTo(r.getDireccion());
            else
                return this.getNombreRestaurante().compareTo(r .getNombreRestaurante());

        }else
            return -1;

    }

    @Override
    public boolean equals(Object o)
    {
        if(!(o instanceof Restaurante))
            return false;
        else{
            Restaurante r = (Restaurante)o;
            return(this.getNombreRestaurante().equals(r.getNombreRestaurante()));
        }
    }
}

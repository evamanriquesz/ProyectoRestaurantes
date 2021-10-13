package main.java;

import java.util.TreeSet;

public class Restaurante implements Comparable{

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

    public String getDireccion()
    {
        return this.direccion;
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Restaurante) {
            Restaurante r = (Restaurante) o;

            if (this.getNombre().equals(r.getNombre()))
                if (this.getDireccion().equals(r.getDireccion()))
                    return 0;
                else
                    return this.getDireccion().compareTo(r.getDireccion());
            else
                return this.getNombre().compareTo(r.getNombre());

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
            return(this.getNombre().equals(r.getNombre()));
        }
    }
}

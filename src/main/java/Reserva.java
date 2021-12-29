package main.java;

import java.util.Date;

public class Reserva
{
    Restaurante restaurante;
    Cliente cliente;
    int digHora, digMin;
    Date fecha;
    int id;

    public Reserva (Restaurante restaurante,Cliente cliente, int digHora, int digMin, Date fecha)
    {
        this.restaurante=restaurante;
        this.id = (int) Math.round(Math.random() * 100000);
        this.cliente=cliente;

    }

    public int getId()
    {
        return this.id;
    }

    public String toString()
    {
        return restaurante.toString();
    }
}

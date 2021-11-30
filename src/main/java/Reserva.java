package main.java;

import java.util.Date;

public class Reserva
{
    Restaurante restaurante;
    Cliente cliente;
    int digHora, digMin;
    Date fecha;

    public Reserva (Restaurante restaurante,Cliente cliente, int digHora, int digMin, Date fecha)
    {
        this.restaurante=restaurante;

    }

    public String toString()
    {
        return restaurante.toString();
    }
}

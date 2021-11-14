package main.java;

public class BuscarRestauranteException extends Exception
{
    public BuscarRestauranteException()
    {
        super("Restaurante no encontrado. Pruebe otra vez.");
    }
}


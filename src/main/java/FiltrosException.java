package main.java;

public class FiltrosException extends Exception
{
    public FiltrosException(){
        super("No se han encontrado restaurantes con sus especificaciones. Pruebe otra vez");
    }
}

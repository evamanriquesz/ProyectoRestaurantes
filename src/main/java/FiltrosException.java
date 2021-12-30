package main.java;

/**Excepcion que salta cuando se introcuce un barrio que no es de los que se ofrecen*/
public class FiltrosException extends Exception
{
    public FiltrosException(){
        super("No se han encontrado restaurantes con sus especificaciones. Pruebe otra vez");
    }
}

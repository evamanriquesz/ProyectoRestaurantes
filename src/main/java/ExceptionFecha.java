package main.java;

/**Excepcion que salta cuando se introduce una fecha anterior a la actual*/

public class ExceptionFecha extends Exception
{
    public ExceptionFecha() {
        super("La fecha introducida no es válida");
    }
}

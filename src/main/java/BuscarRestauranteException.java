package main.java;

/**excepcion que salta cuando en el buscador de restaurantes se introduce el nombre de un restaurante que no forma parte
 * de la base de datos o cuando no se introduce ninguna cadena de caracteres
 */

public class BuscarRestauranteException extends Exception
{
    public BuscarRestauranteException()
    {
        super("Restaurante no encontrado. Pruebe otra vez.");
    }
}


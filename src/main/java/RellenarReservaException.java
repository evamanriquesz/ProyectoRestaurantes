package main.java;
/**Excepcion que salta cuando no se ha rellenado correctamente la reserva*/
public class RellenarReservaException extends Exception
{
        public RellenarReservaException()
        {
            super("Ha rellenado algún campo imcorrectamente");
        }
}

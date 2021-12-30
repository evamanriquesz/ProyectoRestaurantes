package main.java;

/**Excepcion que salta cuando no se ha seleccionado un restaurante de la lista de repetidos*/
public class ReservaException extends Exception {
    public ReservaException(){
        super("Debe seleccionar algún restaurante de la lista");
    }
}

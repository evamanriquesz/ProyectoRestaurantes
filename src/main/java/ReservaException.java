package main.java;

public class ReservaException extends Exception {
    public ReservaException(){
        super("Debe seleccionar algún restaurante de la lista");
    }
}

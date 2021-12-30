package main.java;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Esta clase se ocupa de todo lo referente a escribir o leer fickeros
 */

public class IO {
    /**
     * Metodo que crea un fichero Ticket al finalizar una compra
     * @throws NullPointerException cuando recibe la excepcion de la clase Ticket si el carrito estuviese vacio
     */

    public static void crearTicket(Reserva reserva) throws NullPointerException {

        try {
            Ticket ticket = new Ticket(reserva);
            String nombre = "Ticket" + ticket.getId();
            FileWriter fw = new FileWriter("src"+ File.separator +"main"+ File.separator +"resources" + File.separator + "tickets" + File.separator + nombre + ".txt");
            PrintWriter pw = new PrintWriter(fw);

            pw.println(ticket.toString());

            pw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

package main.java;


/**
 * Esta clase contiene la plantilla para crear un ticket al realizar una compra
 */

public class Ticket
{
    /**
     * @param id hace referencia al numero identificador del ticket. Se genera de forma aleatoria
     */
    int id;
    StringBuilder sb ;

    /**
     * El constructor contiene la plantilla como tal del ticket a imprimir en un txt.
     * @throws NullPointerException si al recoger los pedidos con la llamada PanelCarrito.venta.getPedidoString(); devuelve un null (el carrito estaria vacio)
     */
    public Ticket(Reserva res) throws NullPointerException
    {

        String pedido= res.toString();


        sb = new StringBuilder();
        id = (int) Math.round(Math.random() * 100000);

        sb.append("                 TICKET\n")
                .append("==========================================\n")
                .append("Nombre usuario: AgustinICAI\n")
                .append("Numero del pedido: ")
                .append(id)
                .append("\n")
                .append("\nLista de pedidos: ")
                .append(pedido)
                .append("\n==========================================\n");
               // .append("\t\t\tPrecio total a pagar: ")
                //.append(res.getPrecio());

    }

    /**
     * Metodo que devuelve el id del ticket
     * @return el id del ticket generado aleatoriamente en el constructor
     */
    public int getId()
    {
        return id;
    }

    @Override
    public String toString()
    {
        return sb.toString();
    }
}

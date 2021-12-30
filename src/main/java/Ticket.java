package main.java;


import icai.dtc.isw.client.Client;

import java.util.HashMap;

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
        Pedido pedido= res.getPedido();

        Client client=new Client();
        HashMap<String,Object> session=new HashMap<String, Object>();
        session.put("numeroAleatorio",res.identificador);
        client.envio("/obtenerRestauranteAleatorio",session);

        Restaurante restaurante = (Restaurante) session.get("RespuestaObtenerRestauranteAleatorio");


        sb = new StringBuilder();
        id = (int) Math.round(Math.random() * 100000);

        sb.append("                 TICKET\n")
                .append("==========================================\n")
                .append("Nombre usuario:")
                .append(JInicioSesion.cliente.getNombre())
                .append(" ")
                .append(JInicioSesion.cliente.getApellidos())
                .append("\n\nNumero de reserva: ")
                .append(id)
                .append("\n")
                .append("\nRestaurante: ")
                .append(restaurante)
                .append("\nDía: ")
                .append(res.fecha)
                .append("\nHora: ")
                .append(res.getHora())
                .append("\nNúmero de personas: ")
                .append(res.getNumeroPersonas())
                .append("\nPedido de comida por adelantado: ");

                if (pedido!=null)
                {
                    sb.append("SÍ:")
                        .append("\n\tPrimer plato: ")
                        .append(res.getPrimerPlato())
                        .append("\n\tSegundo plato: ")
                        .append(res.getSegundoPlato())
                        .append("\n\tPostre ")
                        .append(res.getPostre())
                        .append("\n\tBebida ")
                        .append(res.getBebida())
                        .append("\n\tEstado del pago: ")
                        .append(res.getPago())
                        .append("\n===============================================\n")
                        .append("\n===============================================\n");
                }else{
                    sb.append("NO.")
                        .append("\n===============================================\n")
                        .append("\n===============================================\n");
                }

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

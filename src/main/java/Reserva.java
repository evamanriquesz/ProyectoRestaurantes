
package main.java;


import icai.dtc.isw.client.Client;

import java.io.Serializable;
import java.util.HashMap;

import static main.java.Pagado.noPagado;
import static main.java.Pagado.pagado;

/*Clase que guarda la infomracion de una reserva concreta*/
public class Reserva implements Serializable
{

    int codigo, identificador;
    String cliente, fecha, numero_personas, hora, primer_plato, segundo_plato, postre, bebida;
    boolean pago;
    Pedido pedido;

    Restaurante restaurante;
    private Object Pagado;

    public Reserva()
    {

    }

    public Reserva (int codigo, String cliente, int identificador, String fecha, String numero_personas, String hora, boolean pagado)
    {
        this.codigo=codigo;
        this.cliente=cliente;
        this.identificador=identificador;
        this.fecha=fecha;
        this.numero_personas=numero_personas;
        this.hora=hora;
        this.pago=pagado;

    }


    public Reserva (int codigo, String cliente, int identificador, String fecha, String numero_personas, String hora, boolean pagado, String primer_plato, String segundo_plato, String postre, String bebida)
    {
        this.codigo=codigo;
        this.cliente=cliente;
        this.identificador=identificador;
        this.fecha=fecha;
        this.numero_personas=numero_personas;
        this.hora=hora;
        this.pago=pagado;
        this.primer_plato=primer_plato;
        this.segundo_plato=segundo_plato;
        this.postre=postre;
        this.bebida =bebida;

    }
    public void setPedido(String primer_plato, String segundo_plato, String postre, String bebida, Boolean pago)
    {

        Pagado pag;
        if (pago) {
            pag = pagado;
        }else {
            pag = noPagado;
        }


        this.pedido= new Pedido(PrimerPlato.valueOf(primer_plato),SegundoPlato.valueOf(segundo_plato),Postre.valueOf(postre),Bebida.valueOf(bebida),pag);
    }

    public void setPedido(Pedido p)
    {
        this.pedido=p;
    }

    public Pedido getPedido()
    {
        return this.pedido;
    }

    public int getCodigo()
    {
        return this.codigo;
    }
    public String getCliente() {return this.cliente;}
    public int getIdentificador() {return this.identificador;}
    public String getFecha() {return this.fecha;}
    public String getNumeroPersonas() {return this.numero_personas;}
    public String getHora() {return this.hora;}
    public String getPago()
    {
        String respuesta;

        if(this.pago)
        {
            respuesta= "Pagado";
        }else{
            respuesta="No Pagado";
        }
        return respuesta;
    }

    public String getPrimerPlato() {return this.primer_plato;}
    public String getSegundoPlato() {return this.segundo_plato;}
    public String getPostre() {return this.postre;}
    public String getBebida() {return this.bebida;}


/* hemos reciclado la funcion general aleatorio para obtener el objeto restaurante sabiendo su identificador*/
    public String toString(){

        StringBuilder sb = new StringBuilder();
        //Restaurante rEncontrado = this.getRestaurante(identificador);

        Client client = new Client();
        HashMap<String, Object> session = new HashMap<String, Object>();
        session.put("user", 11);
        session.put("pass", 11);
        session.put("numeroAleatorio", identificador);
        client.envio("/obtenerRestauranteAleatorio", session);
        Restaurante restaurante = (Restaurante) session.get("RespuestaObtenerRestauranteAleatorio");

        sb.append("Restaurante: ")
                .append(restaurante.getNombreRestaurante())
                .append(" Dirección: ")
                .append(restaurante.getCalle())
                .append(" ")
                .append(restaurante.getDireccion())
                .append(" ")
                .append(restaurante.getNumeroDirecc())
                .append(" Fecha: ")
                .append(this.getFecha());



        return sb.toString();
    }

}


package main.java;



/**Clase que guarda la infomracion de una reserva concreta*/
public class Reserva
{

    int codigo, identificador;
    String cliente, fecha, numero_personas, hora;
    boolean pagado;

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
        this.pagado=pagado;

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
    public boolean getPagado()
    {
        return this.pagado;
    }

}

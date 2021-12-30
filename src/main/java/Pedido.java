package main.java;

enum Pagado{ pagado, noPagado;}

enum PrimerPlato{
    Pasta_carbonara, Verduras_salteadas, Sopa, Ensalada_Mixta;
}

enum SegundoPlato{
    Salmon, Merluza, Rabo_de_toro, Solomillo, Pollo;
}

enum Postre{
    Helado,Café,Infusion,Tarta_de_queso, Arroz_con_leche;
}

enum Bebida{
    Agua, Refresco, Vino, Cerveza;}

/**clase que genera el objeto pedido cuando el usuario marca la opcion de pedir comida por adelantado*/
public class Pedido
{
    private PrimerPlato primerPlato;
    private SegundoPlato segundoPlato;
    private Postre postre;
    private Bebida bebida;
    private Pagado pago;

    public Pedido (PrimerPlato primerPlato, SegundoPlato segundoPlato, Postre postre, Bebida bebida, Pagado pago){
        this.primerPlato=primerPlato;
        this.segundoPlato=segundoPlato;
        this.postre=postre;
        this.bebida=bebida;
        this.pago=pago;
    }

}

package main.java;

import org.junit.Test;
import org.junit.BeforeClass;

import static org.junit.Assert.*;

public class PnlRestaurantesTest {

    private static String restaurantePrueba;
    private static PnlRestaurantes pnlRestaurantes;

    @BeforeClass
    public static void testInitialization(){
        restaurantePrueba = "BASARRI";
        pnlRestaurantes = new PnlRestaurantes();
    }

    @Test
    public void comprobarRestaurante() throws BuscarRestauranteException {

        assertEquals(1, pnlRestaurantes.comprobarRestaurante(restaurantePrueba));
    }
}



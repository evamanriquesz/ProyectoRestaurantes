package main.java;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReservaTest {

    private static Reserva reserva;
    private static int codigo;
    private static int identificador;

    @Before
    public void setUp() throws Exception {
        reserva = new Reserva(23, "sofia", 4567, "12-01-2022", "12", "13.00", true, "lentejas", "judias", "tarta", "vino");
        codigo = 23;
        identificador= 4567;
    }

    @Test
    public void getCodigo() {
        assertEquals(codigo, reserva.getCodigo());
    }

    @Test
    public void getIdentificador() {
        assertEquals(identificador, reserva.getIdentificador());
    }
}
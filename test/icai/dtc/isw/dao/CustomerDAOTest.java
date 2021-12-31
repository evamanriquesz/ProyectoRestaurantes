package icai.dtc.isw.dao;

import main.java.Restaurante;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerDAOTest {

    private static int respuesta;
    private static String restaurante;

    @Before
    public void setUp() throws Exception {

        respuesta = 1;
        restaurante = "BASARRI";


    }

    @Test
    public void buscarEnLista() {
        assertEquals(respuesta, CustomerDAO.buscarEnLista(restaurante));
    }
}
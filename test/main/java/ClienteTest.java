package main.java;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClienteTest {

    private static Cliente cliente;
    private static String id;


    @Before
    public void setUp() throws Exception {
        cliente = new Cliente("evams", "Eva", 630720672,"eva@gmail.com", "Manrique", "123" );
        id = "evams";
    }

    @Test
    public void getId() {
        assertEquals(id, cliente.getId());

    }

}
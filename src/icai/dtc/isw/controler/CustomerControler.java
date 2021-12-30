package icai.dtc.isw.controler;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import icai.dtc.isw.dao.CustomerDAO;
import icai.dtc.isw.domain.Customer;
import main.java.*;

import java.io.*;

public class CustomerControler implements  Serializable{

	public int hacerLogin(String user, String pass)
	{
		return CustomerDAO.autenticar(user,pass);
	}


	public int buscarRestaurante(String restaurante)
	{
		return CustomerDAO.buscarEnLista(restaurante);
	}

	public Cliente obtenerInfoCliente (String user){ return CustomerDAO.infoCliente(user);}

	public ArrayList<Restaurante> obtenerListaRestaurantes() {return CustomerDAO.iterarLista();}

	public ArrayList<Restaurante> filtrarListaRestaurantes(String filtros) {return CustomerDAO.filtrarLista(filtros);}

	public ArrayList<Restaurante> obtenerIguales (String nombre){return CustomerDAO.obtenerIguales(nombre);}

	public int hacerRegistro(String accion, String usuario, String contra, Integer telefono, String email, String nombre, String apellidos) {return CustomerDAO.registrar(accion,usuario,contra,telefono,email, nombre, apellidos);}

	public Restaurante obtenerRestauranteAleatorio(int n) {	return CustomerDAO.obtenerRestauranteAleatorio(n);	}

    public int incluirTarjeta( String usuario, String nombre, String numeroTarjeta, Integer cvv, String fechaCad) { return CustomerDAO.incluirTarjeta(usuario,nombre,numeroTarjeta,cvv,fechaCad);}

	public int hacerReserva(int codigo_reserva, String usuario_reserva, int identificador_restaurante_reserva, String fecha_reserva, String numero_personas_reserva, String hora_reserva, boolean pagado_reserva) {return CustomerDAO.reservar( codigo_reserva,  usuario_reserva,  identificador_restaurante_reserva,  fecha_reserva,  numero_personas_reserva,  hora_reserva, pagado_reserva);}

	public ArrayList<Reserva> mostrarReservasAnteriores(String cliente)  {return CustomerDAO.mostrarReservasAnteriores(cliente);}


	/*
	public HashMap<String, String> mostrarLista()
	{
		return CustomerDAO.iterarLista();
	}
	*/
	/*public int hacerRegistro(String usuario, String contra, String repetirContra, int telefono, String email) {return CustomerDAO.registrar(usuario, contra, repetirContra, telefono, email);};
*/
}

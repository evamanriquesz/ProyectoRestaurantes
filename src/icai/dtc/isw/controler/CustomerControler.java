package icai.dtc.isw.controler;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

import icai.dtc.isw.dao.CustomerDAO;
import icai.dtc.isw.domain.Customer;
import main.java.Cliente;
import main.java.Restaurante;

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

	public int hacerRegistro(String usuario, String contra, String repetirContra, Integer telefono, String email) {return CustomerDAO.registrar(usuario,contra,repetirContra,telefono,email);}

	public Restaurante obtenerRestauranteAleatorio(int n) {	return CustomerDAO.obtenerRestauranteAleatorio(n);	}
	/*
	public HashMap<String, String> mostrarLista()
	{
		return CustomerDAO.iterarLista();
	}

	public int hacerRegistro(String usuario, String contra, String repetirContra, int telefono, String email) {return CustomerDAO.registrar(usuario, contra, repetirContra, telefono, email);};
*/
}

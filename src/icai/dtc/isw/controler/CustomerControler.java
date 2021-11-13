package icai.dtc.isw.controler;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

import icai.dtc.isw.dao.CustomerDAO;
import icai.dtc.isw.domain.Customer;
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

	public ArrayList<Restaurante> obtenerListaRestaurantes() {return CustomerDAO.iterarLista();}
	/*
	public HashMap<String, String> mostrarLista()
	{
		return CustomerDAO.iterarLista();
	}

	 */

}

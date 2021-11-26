package icai.dtc.isw.dao;

import java.sql.*;
import java.util.ArrayList;

import main.java.Restaurante;

import icai.dtc.isw.domain.Customer;

import java.io.*;

public class CustomerDAO implements Serializable {


	
	public static void getClientes(ArrayList<Customer> lista) {
		Connection con=ConnectionDAO.getInstance().getConnection();
		try (PreparedStatement pst = con.prepareStatement("SELECT * FROM clientes");
                ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
            	lista.add(new Customer(rs.getString(1),rs.getString(2)));
            }
        } catch (SQLException ex)
		{
			System.out.println(ex.getMessage());
        }
	}
	
	public static void main(String[] args) {
		
		
		ArrayList<Customer> lista=new ArrayList<Customer>();
		CustomerDAO.getClientes(lista);
		
		
		 for (Customer customer : lista) {			
			System.out.println("He leído el usuario: "+customer.getUsuario()+" con contra: "+customer.getContra());
		}
		
	
	}
	public static int autenticar(String usuario, String contra)
	{
		int encontrado = 0;
		int respuesta = 0;
		Connection con = ConnectionDAO.getInstance().getConnection();
		try(PreparedStatement pst = con.prepareStatement("SELECT * FROM clientes");
		ResultSet rs = pst.executeQuery()) {
			while (rs.next()){
				if(usuario.equals(rs.getString(1)) && (contra.equals(rs.getString(2))))
				{
					System.out.println("El usuario está registrado en la bbdd");
					encontrado = 1;
					respuesta = 1;
				}
				else
				{
					encontrado= 0;
				}
			}
			if(encontrado == 0)
			{
				System.out.println("El usuario no está en la base de datos");
			}
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}

		return respuesta;
	}

		//////////////////////////// intento para tabla restaurantes

	public static int buscarEnLista(String restaurante)
	{
		int encontrado = 0;
		int respuesta = 0;
		Connection con = ConnectionDAO.getInstance().getConnection();
		try(PreparedStatement pst = con.prepareStatement("SELECT * FROM restaurantes1");
			ResultSet rs = pst.executeQuery()) {
			while (rs.next()){
				if(restaurante.equals(rs.getString(13)) ) // el 13 es la posicion de rotulo pero lo tengo que cambiar
				{
					System.out.println("El restaurante está registrado en la bbdd");
					encontrado = 1;
					respuesta = 1;
				}
				else
				{
					encontrado= 0;
				}
			}
			if(encontrado == 0)
			{
				System.out.println("El restaurante no está en la base de datos");
			}
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}

		return respuesta;
	}



	public static ArrayList<Restaurante> iterarLista()
	{

		ArrayList<Restaurante> restaurantes = new ArrayList<Restaurante>();

		//HashMap<String, ArrayList> restaurantes = new HashMap <String, ArrayList> ();  ///cambiar lo de string string

		Connection con = ConnectionDAO.getInstance().getConnection();
		try(PreparedStatement pst = con.prepareStatement("SELECT * FROM restaurantes1");
			ResultSet rs = pst.executeQuery())
		{
			while (rs.next())
			{
				Restaurante r = new Restaurante(rs.getString(13), Integer.valueOf (rs.getString(2)), rs.getString(3), Double.parseDouble(rs.getString(6)), Double.parseDouble(rs.getString(7)), rs.getString(8), rs.getString(9), Integer.parseInt(rs.getString(12)), rs.getString(15), Integer.parseInt(rs.getString(16)));
				restaurantes.add(r);

				//public Restaurante (String nombreRestaurante,int idDistrito, String nombreDistrito, double coordX, double coordY, String calle, String direccion, int numeroDirecc, String tipoRest, int numeroId)
				//	infoRestaurante.add(rs.getString(2)); //id distrito---0
				//	infoRestaurante.add(rs.getString(6)); //coord x-----2
				//	infoRestaurante.add(rs.getString(7)); //coord y-----3
				//	infoRestaurante.add(rs.getString(8)); //calle-avd-...-----4
				//	infoRestaurante.add(rs.getString(9)); //nombre calle...------5
				//	infoRestaurante.add(rs.getString(12)); //numero-----6
				//	infoRestaurante.add(rs.getString(15)); //restaur-bar-taberna-comida rapida-----7
				//	infoRestaurante.add(rs.getString(16)); //numero identificador-----8

				//13 es el nombre del bar

				//restaurantes.put(rs.getString((13), infoRestaurante); // clave: nombre, valor: arraylist con la info del restaurante
				//infoRestaurante.clear();
			}
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}

		return restaurantes;
	}



	//SOLO FALTA HACER BIEN ESTE MÉTODO

		public static int registrar(String usuario, String contra, String repetirContra, int telefono, String email)  {
			//no llega a entrar a este metodo creo
			int respuesta = 0;
			Connection con = ConnectionDAO.getInstance().getConnection();

			System.out.println("llega aqui");

			try {
				Statement statement=con.createStatement();
				statement.executeQuery("INSERT INTO clientes VALUES ('"+ usuario + "', '" + contra + "', "+ telefono + ",'" + email + "');");
			}catch(SQLException ex)
			{
				System.out.println(ex.getMessage());
			}


			return 1;
		}






}

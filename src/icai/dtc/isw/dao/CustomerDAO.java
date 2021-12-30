package icai.dtc.isw.dao;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

import main.java.*;

import icai.dtc.isw.domain.Customer;

import java.io.*;
import java.util.Locale;
import java.util.Objects;

public class CustomerDAO implements Serializable {


	public static void getClientes(ArrayList<Customer> lista) {
		Connection con = ConnectionDAO.getInstance().getConnection();
		try (PreparedStatement pst = con.prepareStatement("SELECT * FROM clientes");
			 ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				lista.add(new Customer(rs.getString(1), rs.getString(2)));
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static void main(String[] args) {

		ArrayList<Customer> lista = new ArrayList<Customer>();
		CustomerDAO.getClientes(lista);

		for (Customer customer : lista) {
			System.out.println("He leído el usuario: " + customer.getUsuario() + " con contra: " + customer.getContra());
		}
	}

	public static int autenticar(String usuario, String contra) {
		int encontrado = 0;
		int respuesta = 0;
		Connection con = ConnectionDAO.getInstance().getConnection();
		try (PreparedStatement pst = con.prepareStatement("SELECT * FROM clientes WHERE usuario ='" + usuario +"' AND contra ='" + contra + "';");
			 ResultSet rs = pst.executeQuery()) {
			while (rs.next()) {
					System.out.println("El usuario está registrado en la bbdd");
					encontrado = 1;
					respuesta = 1;
			}
			if (encontrado == 0) {
				System.out.println("El usuario no está en la base de datos");
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return respuesta;
	}

	public static Cliente infoCliente(String user) {
		Cliente cliente = new Cliente();
		TarjetaCredito t;

		Connection con = ConnectionDAO.getInstance().getConnection();
		try (PreparedStatement pst = con.prepareStatement("SELECT * FROM clientes WHERE usuario ='" + user +"'");
			 ResultSet rs = pst.executeQuery()) {
			while (rs.next()) {
				cliente = new Cliente(rs.getString("usuario"), rs.getString("nombre"), Integer.parseInt(rs.getString("telefono")), rs.getString("email"), rs.getString("apellidos")); //usuario,nombre,telefono,correo,apellidos
				t= new TarjetaCredito(rs.getString("propietariotarjeta"), rs.getString("numerotarjeta"), rs.getInt("cvv"), rs.getString("fechacaducidad")); //usuario,nombre,telefono,correo,apellidos
				cliente.setTarjeta(t);
				System.out.println(cliente);
			}
		} catch (SQLException | ExceptionFecha ex) {
			System.out.println(ex.getMessage());
		}
		return cliente;
	}


	public static int buscarEnLista(String restaurante) {
		int respuesta = 0;
		Connection con = ConnectionDAO.getInstance().getConnection();
		try (PreparedStatement pst = con.prepareStatement("SELECT * FROM restaurantes1 WHERE rotulo ='" + restaurante + "';");
			 ResultSet rs = pst.executeQuery()) {
			while (rs.next()) {
				System.out.println("El restaurante está registrado en la bbdd");
				respuesta = 1;
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return respuesta;
	}

	public static ArrayList<Restaurante> filtrarLista(String filtro) {

		ArrayList<Restaurante> restaurantes = new ArrayList<Restaurante>();

		Connection con = ConnectionDAO.getInstance().getConnection();
		if (filtro.equals("RESTAURANTE") || filtro.equals("BAR RESTAURANTE") || filtro.equals("TABERNA") || filtro.equals("RESTAURANTES DE COMIDA RAPIDA")) {
			try (PreparedStatement pst = con.prepareStatement("SELECT * FROM restaurantes1 WHERE desc_epigrafe='" + filtro + "'");
				 ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					Restaurante r = new Restaurante(rs.getString(13), Integer.parseInt(rs.getString(2)), rs.getString(3), Double.parseDouble(rs.getString(6)), Double.parseDouble(rs.getString(7)), rs.getString(8), rs.getString(9), Integer.parseInt(rs.getString(12)), rs.getString(15), Integer.parseInt(rs.getString(16)), rs.getString(5));
					restaurantes.add(r);
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		} else {
			int i = filtro.length();
			String barrio = filtro;
			while (i < 20) {
				barrio = barrio + " ";
				i++;
			}
			if (barrio.equals("ARGÜELLES"))
			{
				barrio= "ARGUELLES";
			}
			try (PreparedStatement pst = con.prepareStatement("SELECT * FROM restaurantes1 WHERE  desc_barrio_local LIKE '" + barrio + "'");
				 ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					Restaurante r = new Restaurante(rs.getString(13), Integer.parseInt(rs.getString(2)), rs.getString(3), Double.parseDouble(rs.getString(6)), Double.parseDouble(rs.getString(7)), rs.getString(8), rs.getString(9), Integer.parseInt(rs.getString(12)), rs.getString(15), Integer.parseInt(rs.getString(16)), rs.getString(5));
					restaurantes.add(r);
				}

			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}

		}

		return restaurantes;
	}

	public static ArrayList<Restaurante> obtenerIguales(String nombre) {
		ArrayList<Restaurante> listaIguales = new ArrayList<>();

		Connection con = ConnectionDAO.getInstance().getConnection();
		try (PreparedStatement pst = con.prepareStatement("SELECT * FROM restaurantes1 WHERE rotulo='" + nombre.toUpperCase(Locale.ROOT) + "'");
			 ResultSet rs = pst.executeQuery()) {
			while (rs.next()) {
				Restaurante r = new Restaurante(rs.getString(13), Integer.parseInt(rs.getString(2)), rs.getString(3), Double.parseDouble(rs.getString(6)), Double.parseDouble(rs.getString(7)), rs.getString(8), rs.getString(9), Integer.parseInt(rs.getString(12)), rs.getString(15), Integer.parseInt(rs.getString(16)), rs.getString(5));
				listaIguales.add(r);

			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return listaIguales;
	}

	public static ArrayList<Restaurante> iterarLista() {
		ArrayList<Restaurante> restaurantes = new ArrayList<Restaurante>();

		//HashMap<String, ArrayList> restaurantes = new HashMap <String, ArrayList> ();  ///cambiar lo de string string

		Connection con = ConnectionDAO.getInstance().getConnection();
		try (PreparedStatement pst = con.prepareStatement("SELECT * FROM restaurantes1");
			 ResultSet rs = pst.executeQuery()) {
			while (rs.next()) {
				Restaurante r = new Restaurante(rs.getString(13), Integer.parseInt(rs.getString(2)), rs.getString(3), Double.parseDouble(rs.getString(6)), Double.parseDouble(rs.getString(7)), rs.getString(8), rs.getString(9), Integer.parseInt(rs.getString(12)), rs.getString(15), Integer.parseInt(rs.getString(16)), rs.getString(5));
				restaurantes.add(r);
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return restaurantes;
	}


	public static int registrar(String accion, String usuario, String contra, int telefono, String email, String nombre, String apellidos) {
		//no llega a entrar a este metodo creo
		Cliente c = new Cliente();
		int respuesta = 0; //1= bien, 0 = mal
		int introducir = 1; //1 = si, 0 = no
		Connection con = ConnectionDAO.getInstance().getConnection();
		Statement statement;
		System.out.println("llega aqui");

		if (accion.equals("registrar")) {
			try (PreparedStatement pst = con.prepareStatement("SELECT * FROM clientes WHERE usuario='" + usuario + "';");
				 ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					c=new Cliente(rs.getString("usuario"), rs.getString("nombre"), Integer.parseInt(rs.getString("telefono")), rs.getString("email"), rs.getString("apellidos")); //usuario,nombre,telefono,correo,apellidos
				}

				if (c.getId() == null) {
					try {
						respuesta = 1;
						statement = con.createStatement();
						statement.executeQuery("INSERT INTO clientes (usuario,contra,telefono,email,nombre,apellidos) VALUES ('" + usuario + "', '" + contra + "', " + telefono + ",'" + email + "','" + nombre + "','" + apellidos + "');");
					} catch (SQLException ex) {
						System.out.println(ex.getMessage());
					}
				} else {
					respuesta = 0;
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		} else{// if (accion.equals("editar")) {
			try (PreparedStatement pst = con.prepareStatement("SELECT * FROM clientes WHERE usuario ='" + usuario +"'");
				 ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					try {
						respuesta = 1;
						statement = con.createStatement();
						statement.executeQuery("UPDATE clientes SET usuario ='" + usuario + "',contra='" + contra + "',telefono= " + telefono + ",email= '" + email + "',nombre='" + nombre + "',apellidos = '" + apellidos + "' WHERE  usuario='" + usuario + "';");
					} catch (SQLException ex) {
						System.out.println(ex.getMessage());
					}
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		//}else{
		//	throw new NullPointerException();
		}
		return respuesta;
	}


	public static Restaurante obtenerRestauranteAleatorio(int n) {

		Restaurante rAleatorio = new Restaurante();

		Connection con = ConnectionDAO.getInstance().getConnection();
		try (PreparedStatement pst = con.prepareStatement("SELECT * FROM restaurantes1 WHERE identificador=" + n);
			 ResultSet rs = pst.executeQuery()) {
			while (rs.next()) {
				rAleatorio = new Restaurante(rs.getString(13), Integer.parseInt(rs.getString(2)), rs.getString(3), Double.parseDouble(rs.getString(6)), Double.parseDouble(rs.getString(7)), rs.getString(8), rs.getString(9), Integer.parseInt(rs.getString(12)), rs.getString(15), Integer.parseInt(rs.getString(16)), rs.getString(5));
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return rAleatorio;
	}



	public static int incluirTarjeta(String usuario, String nombre, String numeroTarjeta, Integer cvv, String fechaCad) {

		int respuesta = 0;

		Statement statement;
		Connection con = ConnectionDAO.getInstance().getConnection();

		try (PreparedStatement pst = con.prepareStatement("SELECT * FROM clientes WHERE usuario='" + usuario + "';");
			 ResultSet rs = pst.executeQuery()) {
			while (rs.next()) {
				try {
					respuesta = 1;
					statement = con.createStatement();
					statement.executeQuery("UPDATE clientes SET propietariotarjeta = '" + nombre + "',numerotarjeta= '" + numeroTarjeta + "',cvv= " + cvv + " ,fechacaducidad = '" + fechaCad + "' WHERE usuario='" + usuario + "';");
					respuesta=1;
				} catch (SQLException ex) {
					System.out.println(ex.getMessage());
				}
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return respuesta;
	}

	public static int reservar(int codigo_reserva, String usuario_reserva, int identificador_restaurante_reserva, String fecha_reserva, String numero_personas_reserva, String hora_reserva,boolean pagado_reserva)
	{
		//no llega a entrar a este metodo creo
		Cliente c ;
		int respuesta=0; //1= bien, 0 = mal
		int introducir=1; //1 = si, 0 = no
		Connection con = ConnectionDAO.getInstance().getConnection();
		Statement statement;
		System.out.println("llega aqui!!!!!!!!");

		System.out.println("Antes de...");

		try(PreparedStatement pst = con.prepareStatement("SELECT * FROM reservas");// WHERE usuario ='" + user +"'");
			ResultSet rs = pst.executeQuery()) {
			while (rs.next()) {
				// esto......................
				if((String.valueOf(identificador_restaurante_reserva).equals(rs.getString("identificador"))) && (fecha_reserva.equals(rs.getString("fecha"))) && (hora_reserva.equals(rs.getString("hora")))) //falta poner algo del numero de reservas en total
				{
					introducir=0;
				}
			}


			if (introducir==1){
				try
				{
					System.out.println("Despues de....");
					respuesta = 1;
					statement = con.createStatement();
					statement.executeQuery("INSERT INTO reservas (codigo,usuario,identificador,fecha,numero_personas,hora,pagado) VALUES ('" + codigo_reserva + "', '" + usuario_reserva + "', " + identificador_restaurante_reserva + ",'" + fecha_reserva + "','" + numero_personas_reserva + "','" + hora_reserva + " ','" + pagado_reserva + "');");
					//System.out.println("INSERT INTO reservas (codigo,cliente,identificador,fecha,numero_personas,hora,pagado) VALUES ('" + codigo_reserva + "', '" + usuario_reserva + "', " + identificador_restaurante_reserva + ",'" + fecha_reserva + "','" + numero_personas_reserva + "','" + hora_reserva + " ','" + pagado_reserva + "');");
				}catch (SQLException ex)
				{
					System.out.println(ex.getMessage());
				}
			}else{
				respuesta=0;
			}
		}catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
		return respuesta;
	}

	public static ArrayList<Reserva> mostrarReservasAnteriores(String usuario)
	{
		ArrayList<Reserva> listaReservasAnteriores = new ArrayList<Reserva>();

		Connection con = ConnectionDAO.getInstance().getConnection();
		try(PreparedStatement pst = con.prepareStatement("SELECT * FROM reservas WHERE usuario = '" + usuario + "';" );
			ResultSet rs = pst.executeQuery())
		{
			while (rs.next())
			{
				Reserva r = new Reserva( Integer.parseInt(rs.getString(1)),rs.getString(2), Integer.parseInt(rs.getString(3)), rs.getString(4), rs.getString(5), rs.getString(6), rs.getBoolean(7));
				listaReservasAnteriores.add(r);
			}
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}

		return listaReservasAnteriores;
	}
}


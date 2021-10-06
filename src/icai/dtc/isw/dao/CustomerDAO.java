package icai.dtc.isw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import icai.dtc.isw.domain.Customer;

public class CustomerDAO {
	
	
	
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

}

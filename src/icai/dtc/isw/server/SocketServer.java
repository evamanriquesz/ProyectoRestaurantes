package icai.dtc.isw.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

import icai.dtc.isw.controler.CustomerControler;
import icai.dtc.isw.domain.Customer;
import icai.dtc.isw.message.Message;
import main.java.Cliente;
import main.java.Restaurante;

public class SocketServer extends Thread implements Serializable {
	public static final int PORT_NUMBER = 8081;

	protected Socket socket;

	private SocketServer(Socket socket) {
		this.socket = socket;
		System.out.println("New client connected from " + socket.getInetAddress().getHostAddress());
		start();
	}

	public void run() {
		InputStream in = null;
		OutputStream out = null;

		try {
			in = socket.getInputStream();
			out = socket.getOutputStream();

			//first read the object that has been sent
			ObjectInputStream objectInputStream = new ObjectInputStream(in);
		    Message mensajeIn= (Message)objectInputStream.readObject();
		    //Object to return informations 
		    ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);
		    Message mensajeOut=new Message();

			HashMap<String,Object> session=new HashMap<String, Object>();
			CustomerControler customerControler=new CustomerControler();

		    switch (mensajeIn.getContext()) {
		    	case ("/hacerLogin"):
		    		//CustomerControler customerControler=new CustomerControler();
		    		//ArrayList<Customer> lista=new ArrayList<Customer>(); // no se si esta bien
		    		int i=customerControler.hacerLogin((String)mensajeIn.getSession().get("user"),(String)mensajeIn.getSession().get("pass"));
		    		mensajeOut.setContext("/hacerLoginResponse");
		    		//HashMap<String,Object> session=new HashMap<String, Object>();
		    		session.put("RespuestaLogin",i);
		    		mensajeOut.setSession(session);
		    		objectOutputStream.writeObject(mensajeOut);

				case("/buscarRestaurante"):
					int j=customerControler.buscarRestaurante((String)mensajeIn.getSession().get("restaurante"));
					mensajeOut.setContext("/buscarRestauranteResponse");
					//HashMap<String,Object> session=new HashMap<String, Object>();
					session.put("RespuestaBuscarRestaurante",j);
					mensajeOut.setSession(session);
					objectOutputStream.writeObject(mensajeOut);


				case ("/obtenerListaRestaurantes"):
					//CustomerControler customerControler1 = new CustomerControler();
					ArrayList<Restaurante> rest= customerControler.obtenerListaRestaurantes();
					mensajeOut.setContext("/obtenerListaRestaurantesResponse");
					//HashMap<String,Object> session1=new HashMap<String, Object>();
					session.put("RespuestaObtenerListaRestaurantes",rest);
					mensajeOut.setSession(session);
					objectOutputStream.writeObject(mensajeOut);


				case ("/obtenerInfoCliente"):
					//CustomerControler customerControler1 = new CustomerControler();
					Cliente  cliente= customerControler.obtenerInfoCliente((String)mensajeIn.getSession().get("usuario"));
					mensajeOut.setContext("/obtenerInfoClienteResponse");
					//HashMap<String,Object> session1=new HashMap<String, Object>();
					session.put("RespuestaObtenerInfoCliente",cliente);
					mensajeOut.setSession(session);
					objectOutputStream.writeObject(mensajeOut);

				case ("/filtrar"):
					//CustomerControler customerControler1 = new CustomerControler();
					ArrayList<Restaurante> listafiltrada= customerControler.filtrarListaRestaurantes((String)mensajeIn.getSession().get("filtro"));
					mensajeOut.setContext("/filtrarResponse");
					//HashMap<String,Object> session1=new HashMap<String, Object>();
					session.put("RespuestaFiltrar",listafiltrada);
					mensajeOut.setSession(session);
					objectOutputStream.writeObject(mensajeOut);

				case ("/obtenerIguales"):
					//CustomerControler customerControler1 = new CustomerControler();
					ArrayList<Restaurante> listaIguales= customerControler.obtenerIguales((String)mensajeIn.getSession().get("restaurante"));
					mensajeOut.setContext("/obtenerIgualesResponse");
					//HashMap<String,Object> session1=new HashMap<String, Object>();
					session.put("RespuestaObtenerIguales",listaIguales);
					mensajeOut.setSession(session);
					objectOutputStream.writeObject(mensajeOut);

				case("/hacerRegistro"):
					int k=customerControler.hacerRegistro((String)mensajeIn.getSession().get("usuario"),(String)mensajeIn.getSession().get("contra"),(Integer)mensajeIn.getSession().get("telefono"), (String)mensajeIn.getSession().get("email"),(String)mensajeIn.getSession().get("nombre"),(String)mensajeIn.getSession().get("apellidos"));
					mensajeOut.setContext("/hacerRegistroResponse");
					//HashMap<String,Object> session=new HashMap<String, Object>();
					session.put("RespuestaRegistro",k);
					mensajeOut.setSession(session);
					objectOutputStream.writeObject(mensajeOut);

				case ("/obtenerRestauranteAleatorio"):
					//CustomerControler customerControler1 = new CustomerControler();
					Restaurante restauranteAleatorio= customerControler.obtenerRestauranteAleatorio((Integer)mensajeIn.getSession().get("numeroAleatorio"));
					mensajeOut.setContext("/obtenerRestauranteAleatorioResponse");
					//HashMap<String,Object> session1=new HashMap<String, Object>();
					session.put("RespuestaObtenerRestauranteAleatorio",restauranteAleatorio);
					mensajeOut.setSession(session);
					objectOutputStream.writeObject(mensajeOut);

				case ("/editarPerfil"):
					int n=customerControler.editarPerfil((String)mensajeIn.getSession().get("usuario"),(String)mensajeIn.getSession().get("contra"),(Integer)mensajeIn.getSession().get("telefono"), (String)mensajeIn.getSession().get("email"),(String)mensajeIn.getSession().get("nombre"),(String)mensajeIn.getSession().get("apellidos"));
					mensajeOut.setContext("/editarPerfilResponse");
					//HashMap<String,Object> session=new HashMap<String, Object>();
					session.put("RespuestaEditarPerfil",n);
					mensajeOut.setSession(session);
					objectOutputStream.writeObject(mensajeOut);


		    	default:
		    		System.out.println("\nParámetro no encontrado");
		    		break;
		    }
		    
		    //Lógica del controlador 
		    //System.out.println("\n1.- He leído: "+mensaje.getContext());
		    //System.out.println("\n2.- He leído: "+(String)mensaje.getSession().get("Nombre"));
		    
		    
		    
		    //Prueba para esperar
		    /*try {
		    	System.out.println("Me duermo");
				Thread.sleep(15000);
				System.out.println("Me levanto");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			// create an object output stream from the output stream so we can send an object through it
			/*ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);
			
			//Create the object to send
			String cadena=((String)mensaje.getSession().get("Nombre"));
			cadena+=" añado información";
			mensaje.getSession().put("Nombre", cadena);
			//System.out.println("\n3.- He leído: "+(String)mensaje.getSession().get("Nombre"));
			objectOutputStream.writeObject(mensaje);*
			*/

		} catch (IOException ex) {
			System.out.println("Unable to get streams from client");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				in.close();
				out.close();
				socket.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("SocketServer Example");
		ServerSocket server = null;
		try {
			server = new ServerSocket(PORT_NUMBER);
			while (true) {
				/**
				 * create a new {@link SocketServer} object for each connection
				 * this will allow multiple client connections
				 */
				new SocketServer(server.accept());
			}
		} catch (IOException ex) {
			System.out.println("Unable to start server.");
		} finally {
			try {
				if (server != null)
					server.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
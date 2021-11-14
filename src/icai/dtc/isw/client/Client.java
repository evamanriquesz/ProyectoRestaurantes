package icai.dtc.isw.client;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.cert.CertificateParsingException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;

import icai.dtc.isw.configuration.PropertiesISW;
import icai.dtc.isw.domain.Customer;
import icai.dtc.isw.message.Message;

import main.java.Restaurante;

import javax.swing.*;

public class Client implements Serializable {
	private String host;
	private int port;
	final static Logger logger = Logger.getLogger(Client.class);

	public void envio(String contexto, HashMap<String, Object> session) {
		//quitamos el main y ponemos que esto sea un método.

		//Configure connections
		String host = PropertiesISW.getInstance().getProperty("host");
		int port = Integer.parseInt(PropertiesISW.getInstance().getProperty("port"));
		Logger.getRootLogger().info("Host: "+host+" port"+port);
		//Create a cliente class
		Client cliente=new Client(host, port);
		
	//	HashMap<String,Object> session=new HashMap<String, Object>();
		//session.put("/getCustomer","");
		
		Message mensajeEnvio=new Message();
		Message mensajeVuelta=new Message();
		mensajeEnvio.setContext(contexto);
		mensajeEnvio.setSession(session);
		cliente.sent(mensajeEnvio,mensajeVuelta);


		switch (mensajeVuelta.getContext()) {
			case "/hacerLoginResponse": //"/hacerLoginResponse"
				int res=(Integer) mensajeVuelta.getSession().get("RespuestaLogin");
				session.put("RespuestaLogin",res);
				break;

			case"/buscarRestauranteResponse":
				int res2 =(Integer) mensajeVuelta.getSession().get("RespuestaBuscarRestaurante");
				session.put("RespuestaBuscarRestaurante", res2);
				break;

			case "/obtenerListaRestaurantesResponse":
				ArrayList<Restaurante> res1 = (ArrayList<Restaurante>) mensajeVuelta.getSession().get("RespuestaObtenerListaRestaurantes");
				session.put("RespuestaObtenerListaRestaurantes", res1);
				break;


			default:
				Logger.getRootLogger().info("Option not found");
				System.out.println("\nError a la vuelta");
				break;

		}

		//System.out.println("3.- En Main.- El valor devuelto es: "+((String)mensajeVuelta.getSession().get("Nombre")));
	}

	public Client()
	{

	}

	public Client(String host, int port) {
		this.host=host;
		this.port=port;
	}

	public void sent(Message messageOut, Message messageIn) {
		try {

			System.out.println("Connecting to host " + host + " on port " + port + ".");

			Socket echoSocket = null;
			OutputStream out = null;
			InputStream in = null;

			try {
				echoSocket = new Socket(host, port);
				in = echoSocket.getInputStream();
				out = echoSocket.getOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);

				//Create the objetct to send
				objectOutputStream.writeObject(messageOut);


				// create a DataInputStream so we can read data from it.
		        ObjectInputStream objectInputStream = new ObjectInputStream(in);
				//HASTA AQUI SE EJECUTA PARA RESTAURANTES
		        Message msg=(Message)objectInputStream.readObject(); //esta linea ya no se ejecuta en restaurantes
				messageIn.setContext(msg.getContext());
		        messageIn.setSession(msg.getSession());
		        /*System.out.println("\n1.- El valor devuelto es: "+messageIn.getContext());
		        String cadena=(String) messageIn.getSession().get("Nombre");
		        System.out.println("\n2.- La cadena devuelta es: "+cadena);*/
				
			} catch (UnknownHostException e) {
				System.err.println("Unknown host: " + host);
				System.exit(1);
			} catch (IOException e) {
				System.err.println("Unable to get streams from server");
				System.exit(1);

			}		

			/** Closing all the resources */
			out.close();
			in.close();			
			echoSocket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
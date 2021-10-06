package icai.dtc.isw.domain;

import java.io.Serializable;

public class Customer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String usuario;
	private String contra;
	
	public Customer() {
		this.setUsuario(new String());
		this.setContra(new String());
	}
	
	public Customer(String usuario, String contra) {
		this.setContra(contra);
		this.setUsuario(usuario);
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContra() {
		return contra;
	}

	public void setContra(String contra) {
		this.contra = contra;
	}
	
	
}

package icai.dtc.isw.controler;

import java.util.ArrayList;

import icai.dtc.isw.dao.CustomerDAO;
import icai.dtc.isw.domain.Customer;

public class CustomerControler {

	public int hacerLogin(String user, String pass)
	{
		return CustomerDAO.autenticar(user,pass);
	}	
}

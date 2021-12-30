package main.java;

/**Excepcion que salta durante el registro cuando el usuario ya esta registrado*/
public class RegistroException extends Exception
{

    public RegistroException()
    {
        //JOptionPane.showMessageDialog(JRegistrarUsuario.this, "Error, el telefono debe ser numerico.");
       // JRegistrarUsuario.txtTelefono.requestFocus();
        super("usuario ya registrado");
    }



}

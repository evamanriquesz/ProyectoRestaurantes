package main.java;

/**excepcion que salta en un cuadro de dialogo si se introducen un usuario o contraseña incorrectos al iniciar sesion*/

public class InicioSesionException extends Exception
{
    public InicioSesionException()
    {
        super("Usuario o contraseña incorrectos. Pruebe otra vez.");
    }
}


public class InicioSesionException extends Exception
{
    public InicioSesionException()
    {
        super("Usuario o contraseña incorrectos. Pruebe otra vez.");
    }
}


package main.java;

public class Usuario //esta clase la conectaremos con el inicio desesion para poder mostrar los datos del usuario en su perfil
{

    private String nombre;
    private char[] id;
    private String[] restaurantesfav;

    public Usuario (String nombre, char[] id){
        this.id=id;
        this.nombre=nombre;
    }
}

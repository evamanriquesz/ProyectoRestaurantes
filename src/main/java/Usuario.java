package main.java;


/**clase del objeto usuario del que heredaran cliente y restaurante**/

public class Usuario //esta clase la conectaremos con el inicio desesion para poder mostrar los datos del usuario en su perfil
{

    private String id;
    private char[] pass;
    private String[] restaurantesfav;

    public Usuario (String id, char[] pass){
        this.id=id;
        this.pass=pass;
    }

    public Usuario() {
    }
}

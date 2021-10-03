import javax.swing.*;
import java.util.TreeSet;

public class PnlRestaurantes extends JPanel {

    TreeSet<String> restaurantes;

    //String[] listarestaurantes = new String[25];

    public PnlRestaurantes()
    {
        restaurantes = IO.leerFichero();


    }
}

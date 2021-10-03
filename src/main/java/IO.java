package main.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.TreeSet;

public class IO {

    public static TreeSet<Restaurante> leerFicheroRestaurantes()
    {
        TreeSet<Restaurante> restaurantes = new TreeSet<>();

        try
        {
            FileReader fr = new FileReader(  "resources" + File.separator + "productos" + File.separator + "Restaurantes.csv"); //hay que crear un csv con los restaurantes
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            while(linea != null)
            {
                String[] s = linea.split(",");

                //restaurantes.add(new Restaurante(s[1].trim()));
                linea = br.readLine();
            }

            br.close();
            fr.close();
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
        return restaurantes;
    }

    public static TreeSet<Usuario> leerFicheroUsuarios()
    {
        TreeSet<Usuario> usuarios = new TreeSet<>();

        try
        {
            FileReader fr = new FileReader(  "resources" + File.separator + "productos" + File.separator + "Restaurantes.csv"); //hay que crear un csv con los restaurantes
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            while(linea != null)
            {
                String[] s = linea.split(",");

               // usuarios.add(new Usuario(s[1].trim(), )); //hay que añadir el elemento del id asi que lo comento para que no salte el error
                linea = br.readLine();
            }

            br.close();
            fr.close();
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
        return usuarios;
    }
}

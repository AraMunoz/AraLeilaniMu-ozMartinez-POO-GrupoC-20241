package Libros.Serializer;

import Libros.Libro;
import Libros.LibroAccion;
import Libros.LibroComedia;
import Libros.LibroTerror;
import Libros.ModelsLibros.ModelsLibro;
import Libros.utils.constants.Genero;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import libreria.Libreria;
import usuarios.ModelsUsers.UsuarioModel;
import usuarios.Usuario;
import usuarios.utils.Rol;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class libroDeserializer {
    public static void deserialize() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\leila_pe8dh8w\\Downloads\\TrabajoLibreria\\Libreria\\src\\libros.json"));
            Gson gson = new GsonBuilder()
                    .excludeFieldsWithoutExposeAnnotation()
                    .create();
            ModelsLibro libroModel = gson.fromJson(reader, ModelsLibro.class);

            ArrayList<Libro> librosAccion = new ArrayList<>(libroModel.getACCION());
            ArrayList<Libro> librosComedia = new ArrayList<>(libroModel.getCOMEDIA());
            ArrayList<Libro> librosTerror = new ArrayList<>(libroModel.getTERROR());

            Libreria.libros.put(Genero.ACCION,librosAccion);
            Libreria.libros.put(Genero.COMEDIA,librosComedia);
            Libreria.libros.put(Genero.TERROR, librosTerror);
            System.out.println(Libreria.libros.values());
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        } catch (JsonSyntaxException e) {
            System.out.println(e);
        } catch (JsonParseException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

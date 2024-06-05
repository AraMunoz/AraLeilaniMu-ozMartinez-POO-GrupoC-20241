package PasarAJson.Deserializer;

import Escuela.Sistema;
import Usuarios.Coordinador;
import Usuarios.Estudiante;
import Usuarios.Rol;
import Usuarios.Usuario;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class deserializarCoordinador {
    public static void deserializeCoordinar() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\jose_\\Documents\\NetBeansProjects\\POO1\\BocetoExamen5\\coordinadores.json"));
            Gson gson = new GsonBuilder()
                    .excludeFieldsWithoutExposeAnnotation()
                    .create();

            Type coordinadorListType = new TypeToken<List<Coordinador>>() {}.getType();
            List<Coordinador> listaCoordinador = gson.fromJson(reader, coordinadorListType);

            ArrayList<Usuario> listaUsuarios = new ArrayList<>(listaCoordinador);

            Sistema.listaCoordinadores.addAll(listaCoordinador);

            System.out.println("Lista coordinadores "+listaCoordinador);
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

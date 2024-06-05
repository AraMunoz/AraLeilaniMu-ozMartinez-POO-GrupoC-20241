package PasarAJson.Deserializer;

import Escuela.Sistema;
import Usuarios.Estudiante;
import Escuela.Calificaciones;
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

public class deserializerCalificaciones {
    public static void deserializeCalificacion() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\jose_\\Documents\\NetBeansProjects\\POO1\\BocetoExamen5\\calificaciones.json"));
            Gson gson = new GsonBuilder()
                    .excludeFieldsWithoutExposeAnnotation()
                    .create();

            Type calificacionListType = new TypeToken<List<Calificaciones>>() {}.getType();
            List<Calificaciones> listaCalificaciones = gson.fromJson(reader, calificacionListType);

            Sistema.todasLasCalificaciones.addAll(listaCalificaciones);

            System.out.println("Lista de calificaciones: "+listaCalificaciones);
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

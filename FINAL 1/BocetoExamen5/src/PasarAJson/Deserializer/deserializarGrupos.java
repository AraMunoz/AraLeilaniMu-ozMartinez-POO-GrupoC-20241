package PasarAJson.Deserializer;

import Escuela.Calificaciones;
import Escuela.Grupo;
import Escuela.Sistema;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class deserializarGrupos {
     public static void deserializeGrupos() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\jose_\\Documents\\NetBeansProjects\\POO1\\BocetoExamen5\\grupos.json"));
            Gson gson = new GsonBuilder()
                    .excludeFieldsWithoutExposeAnnotation()
                    .create();

            Type grupoListType = new TypeToken<List<Grupo>>() {}.getType();
            List<Grupo> listaGrupos = gson.fromJson(reader, grupoListType);

            Sistema.grupos.addAll(listaGrupos);

            System.out.println("Lista de grupos: "+listaGrupos);
        } catch (java.io.FileNotFoundException e) {
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

package PasarAJson.Deserializer;

import Escuela.Sistema;
import Extras.GrupoTieneAlumnos;
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

public class deserializerGrupoTieneAlumnos {
    public static void deserializeGrupoYAlumno() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\jose_\\Documents\\NetBeansProjects\\POO1\\BocetoExamen5\\alumnosEstanEnGrupo.json"));
            Gson gson = new GsonBuilder()
                    .excludeFieldsWithoutExposeAnnotation()
                    .create();

            Type grupoTieneAlumnosListType = new TypeToken<List<GrupoTieneAlumnos>>() {}.getType();
            List<GrupoTieneAlumnos> listaGrupoTieneAlumnos = gson.fromJson(reader, grupoTieneAlumnosListType);

            Sistema.listaDeAlumnosEnGrupos.addAll(listaGrupoTieneAlumnos);

            System.out.println("Lista alumnos en grupo: "+listaGrupoTieneAlumnos);
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

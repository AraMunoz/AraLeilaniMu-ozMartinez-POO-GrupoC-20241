package PasarAJson.Deserializer;

import Escuela.Sistema;
import PasarAJson.Models.EstudianteModels;
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
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class deserializerEstudiante {
    public static void deserialize() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\jose_\\Documents\\NetBeansProjects\\POO1\\BocetoExamen5\\estudiantes.json"));
            Gson gson = new GsonBuilder()
                    .excludeFieldsWithoutExposeAnnotation()
                    .create();

            Type estudianteListType = new TypeToken<List<Estudiante>>() {}.getType();
            List<Estudiante> listaAlumno = gson.fromJson(reader, estudianteListType);

            ArrayList<Usuario> listaUsuarios = new ArrayList<>(listaAlumno);

            Sistema.usuariosISC.put(Rol.ESTUDIANTE, listaUsuarios);
            Sistema.listaEstudiantes.addAll(listaAlumno);

            System.out.println(listaUsuarios);

            System.out.println("Lista estudiante"+Sistema.listaEstudiantes);
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
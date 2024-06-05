
package PasarAJson.Deserializer;

import Escuela.Sistema;
import Usuarios.Rol;
import Usuarios.Usuario;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import PasarAJson.Models.usuariosModel;
import com.google.gson.GsonBuilder;
import utilsGlobal.Carrera.Carreras;

public class deserialaizerUsuariosIMAT {
    public static void deserialize() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\leila_pe8dh8w\\Downloads\\TrabajoLibreria\\Libreria\\src\\libros.json"));
            Gson gson = new GsonBuilder()
                    .excludeFieldsWithoutExposeAnnotation()
                    .create();
            usuariosModel usuariosModel = gson.fromJson(reader, usuariosModel.class);

            ArrayList<Usuario> profesores = new ArrayList<>(usuariosModel.getPROFESOR());
            ArrayList<Usuario> estudiantes = new ArrayList<>(usuariosModel.getESTUDIANTE());
            ArrayList<Usuario> coordinadores = new ArrayList<>(usuariosModel.getCOORDINADOR());

            Sistema.usuariosIMAT.put(Rol.PROFESOR, profesores);
            Sistema.usuariosIMAT.put(Rol.ESTUDIANTE, estudiantes);
            Sistema.usuariosIMAT.put(Rol.COORDINADOR, coordinadores);

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

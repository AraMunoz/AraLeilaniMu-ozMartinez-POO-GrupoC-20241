package PasarAJson.Deserializer;

import Escuela.Sistema;
import Usuarios.Profesor;
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

public class deserializerProfesores {
    public static void deserializeProfes() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\jose_\\Documents\\NetBeansProjects\\POO1\\BocetoExamen5\\profesores.json"));
            Gson gson = new GsonBuilder()
                    .excludeFieldsWithoutExposeAnnotation()
                    .create();

            Type profesListType = new TypeToken<List<Profesor>>() {}.getType();
            List<Profesor> listaProfesores = gson.fromJson(reader, profesListType);

            ArrayList<Usuario> listaUsuarios = new ArrayList<>(listaProfesores);

            agregarEstudianteAHashMap(listaUsuarios);
            Sistema.listaProfesores.addAll(listaProfesores);

            System.out.println(listaUsuarios);

            System.out.println("Lista estudiante"+Sistema.listaProfesores);
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

    public static void agregarEstudianteAHashMap(ArrayList<Usuario>listaUsuarios) {
        for(Usuario buscarUsuario : listaUsuarios){
        switch (buscarUsuario.getCarrera()) {
            case ISC:
                Sistema.usuariosISC.put(Rol.PROFESOR, listaUsuarios);
                break;
            case IMAT:
                Sistema.usuariosIMAT.put(Rol.PROFESOR, listaUsuarios);
                break;
            case ELC:
                Sistema.usuariosELC.put(Rol.PROFESOR, listaUsuarios);
                break;
            }
        }
    }
}

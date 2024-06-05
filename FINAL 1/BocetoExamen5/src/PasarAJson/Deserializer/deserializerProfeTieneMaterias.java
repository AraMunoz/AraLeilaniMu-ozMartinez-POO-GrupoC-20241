package PasarAJson.Deserializer;

import Escuela.Sistema;
import Extras.ProfesorTieneMateria;
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

public class deserializerProfeTieneMaterias {
    public static void deserializeProfeTieneMateria() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\jose_\\Documents\\NetBeansProjects\\POO1\\BocetoExamen5\\profesorTieneMateria.json"));
            Gson gson = new GsonBuilder()
                    .excludeFieldsWithoutExposeAnnotation()
                    .create();

            Type profeTieneMateriaListType = new TypeToken<List<ProfesorTieneMateria>>() {}.getType();
            List<ProfesorTieneMateria> listaProfeTieneMateria = gson.fromJson(reader, profeTieneMateriaListType);

            Sistema.listaRelacionProfeYMateria.addAll(listaProfeTieneMateria);

            System.out.println("Lista Profe tiene materia: "+listaProfeTieneMateria);
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

package PasarAJson.Serializers;

import Extras.ProfesorTieneMateria;
import Usuarios.Profesor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class profesorTieneMateriaSerializer {
    public static void serialize(ArrayList<ProfesorTieneMateria> profesorTieneMateria) {
        Gson json = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("profesorTieneMateria.json"));
            //BufferedWriter writer = new BufferedWriter(new FileWriter("newProfesorTieneMateria.json"));
            json.toJson(profesorTieneMateria, writer);
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

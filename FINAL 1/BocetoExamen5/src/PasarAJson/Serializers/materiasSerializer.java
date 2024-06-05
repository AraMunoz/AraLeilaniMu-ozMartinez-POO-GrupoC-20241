package PasarAJson.Serializers;

import Escuela.Materias;
import Extras.ProfesorTieneMateria;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class materiasSerializer {
    public static void serialize(ArrayList<Materias> materias) {
        Gson json = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("materias.json"));
            //BufferedWriter writer = new BufferedWriter(new FileWriter("newMaterias.json"));

            json.toJson(materias, writer);
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

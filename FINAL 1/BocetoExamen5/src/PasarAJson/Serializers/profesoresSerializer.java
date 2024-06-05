package PasarAJson.Serializers;

import Usuarios.Estudiante;
import Usuarios.Profesor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class profesoresSerializer {
    public static void serialize(ArrayList<Profesor> profesores) {
        Gson json = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter("profesores.json"));
            //BufferedWriter writer = new BufferedWriter(new FileWriter("newProfesores.json"));

            json.toJson(profesores, writer);
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

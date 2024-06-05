package PasarAJson.Serializers;

import Usuarios.Estudiante;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class EstudiantesSerialazer {
    public static void serialize(ArrayList<Estudiante> estudiante) {
        Gson json = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("estudiantes.json"));
            //BufferedWriter writer = new BufferedWriter(new FileWriter("newEstudiantes.json"));

            json.toJson(estudiante, writer);
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

package PasarAJson.Serializers;

import Escuela.Calificaciones;
import Extras.ProfesorTieneMateria;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class calificacionesSerializer {
    public static void serialize(ArrayList<Calificaciones> calificaciones) {
        Gson json = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("calificaciones.json"));
            //BufferedWriter writer = new BufferedWriter(new FileWriter("newCalificaciones.json"));

            json.toJson(calificaciones, writer);
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

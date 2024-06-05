package PasarAJson.Serializers;

import Usuarios.Coordinador;
import Usuarios.Profesor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class coordinadoresSerialazer {
    public static void serialize(ArrayList<Coordinador> coordinadores) {
        Gson json = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("coordinadores.json"));
           // BufferedWriter writer = new BufferedWriter(new FileWriter("newCoordinadores.json"));

            json.toJson(coordinadores, writer);
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

package PasarAJson.Deserializer;

import Escuela.Calificaciones;
import Escuela.Semestre;
import Escuela.Sistema;import com.google.gson.Gson;import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;import com.google.gson.reflect.TypeToken;import java.io.BufferedReader;import java.io.FileNotFoundException;import java.io.FileReader;import java.io.IOException;import java.lang.reflect.Type;import java.util.List;public class deserializerSemestre {
     public static void deserializeCalificacion() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\jose_\\Documents\\NetBeansProjects\\POO1\\BocetoExamen5\\semestre.json"));
            Gson gson = new GsonBuilder()
                    .excludeFieldsWithoutExposeAnnotation()
                    .create();

            Type calificacionListType = new TypeToken<List<Semestre>>() {}.getType();
            List<Semestre> semestres = gson.fromJson(reader, calificacionListType);

            Sistema.semestres.addAll(semestres);

            System.out.println("Lista de semestres: "+semestres);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        } catch (com.google.gson.JsonSyntaxException e) {
            System.out.println(e);
        } catch (JsonParseException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

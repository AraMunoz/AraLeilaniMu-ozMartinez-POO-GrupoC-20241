import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;


public class Main {
    public static void main(String[] args) {
        System.out.println("¿Qué es un JSON? \n En terminos sencillos un archivo JSON es básicamente un tipo de archivo que guarda información" +
                " de una manera organizada y fácil de entender tanto para las personas como para las computadoras.  \nEs como una caja con compartimentos donde puedes guardar diferentes tipos de información, " +
                "como nombres, números, descripciones, entre otros. \n Y ademas esta caja  pude emplearse en distintas cajoneras. Es decir un JSON permite intercambiar informacion entre otros lenguajes o sistemas");

        try  {
            Reader reader = new FileReader("src/ejemplo1.json");
            // Parsear el archivo JSON
            JsonElement json = JsonParser.parseReader(reader);
            Gson gson = new Gson();

            // Imprimir el contenido
            System.out.println("Contenido del JSON 1");
            System.out.println(gson.toJson(json));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try  {
            Reader reader = new FileReader("src/ejemplo2.json");
            // Parsear el archivo JSON
            JsonElement json = JsonParser.parseReader(reader);
            Gson gson = new Gson();

            // Imprimir el contenido
            System.out.println("Contenido del JSON 2");
            System.out.println(gson.toJson(json));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }

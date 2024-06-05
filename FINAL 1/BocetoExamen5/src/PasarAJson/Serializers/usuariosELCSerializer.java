package PasarAJson.Serializers;

import Usuarios.Rol;
import Usuarios.Usuario;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class usuariosELCSerializer {
    public static void serialize(HashMap<Rol, ArrayList<Usuario>> usuarios) {
        Gson json = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("usuariosELC.json"));
            //BufferedWriter writer = new BufferedWriter(new FileWriter("newUsuariosELC.json"));
            json.toJson(usuarios, writer);
            writer.close();
        } catch (java.io.FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

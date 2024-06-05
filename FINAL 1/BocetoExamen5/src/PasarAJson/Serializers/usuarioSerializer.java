package PasarAJson.Serializers;

import Usuarios.Rol;
import Usuarios.Usuario;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class usuarioSerializer {

    public static void serialize(HashMap<Rol, ArrayList<Usuario>> usuarios) {
        Gson json = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("usuarios.json"));
            //BufferedWriter writer = new BufferedWriter(new FileWriter("newUsuarios.json"));
            json.toJson(usuarios, writer);
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

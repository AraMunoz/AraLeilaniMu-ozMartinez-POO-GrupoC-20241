package usuarios.Serializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.Expose;
import libreria.Libreria;
import usuarios.Usuario;
import usuarios.ModelsUsers.UsuarioModel;
import usuarios.utils.Rol;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class deserializer {
    public static void deserialize() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\leila_pe8dh8w\\Downloads\\TrabajoLibreria\\Libreria\\src\\usuarios.json"));
            Gson gson = new GsonBuilder()
                    .excludeFieldsWithoutExposeAnnotation()
                    .create();
            UsuarioModel usuariosModel = gson.fromJson(reader, UsuarioModel.class);

            ArrayList<Usuario> usuariosClientes = new ArrayList<>(usuariosModel.getClientes());
            ArrayList<Usuario> usuariosAsistente = new ArrayList<>(usuariosModel.getAsistente());
            ArrayList<Usuario> usuariosGerentes = new ArrayList<>(usuariosModel.getGerente());

            Libreria.usuarios.put(Rol.GERENTE, usuariosGerentes);
            Libreria.usuarios.put(Rol.ASISTENTE, usuariosAsistente);
            Libreria.usuarios.put(Rol.CLIENTE, usuariosClientes);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        } catch (JsonSyntaxException e) {
            System.out.println(e);
        } catch (JsonParseException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

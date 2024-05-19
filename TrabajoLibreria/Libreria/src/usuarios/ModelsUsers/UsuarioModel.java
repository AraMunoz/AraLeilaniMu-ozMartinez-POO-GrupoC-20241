package usuarios.ModelsUsers;

import com.google.gson.annotations.Expose;
import usuarios.Asistente;
import usuarios.Cliente;
import usuarios.Gerente;
import usuarios.Usuario;

import java.util.ArrayList;

public class UsuarioModel {

    @Expose
    private ArrayList<Asistente> ASISTENTE = new ArrayList<>();
    @Expose
    private ArrayList<Cliente> CLIENTE = new ArrayList<>();
    @Expose
    private ArrayList<Gerente> GERENTE = new ArrayList<>();

    public ArrayList<Cliente> getClientes() {
        return CLIENTE;
    }

    public ArrayList<Gerente> getGerente() {
        return GERENTE;
    }

    public ArrayList<Asistente> getAsistente() {
        return ASISTENTE;
    }
}

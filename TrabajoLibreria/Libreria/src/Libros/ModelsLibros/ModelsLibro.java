package Libros.ModelsLibros;

import Libros.LibroAccion;
import Libros.LibroComedia;
import Libros.LibroTerror;
import com.google.gson.annotations.Expose;
import usuarios.Asistente;
import usuarios.Cliente;
import usuarios.Gerente;

import java.util.ArrayList;

public class ModelsLibro {

    @Expose
    private ArrayList<LibroAccion> ACCION = new ArrayList<>();
    @Expose
    private ArrayList<LibroComedia> COMEDIA = new ArrayList<>();
    @Expose
    private ArrayList<LibroTerror> TERROR = new ArrayList<>();

    public ArrayList<LibroAccion> getACCION() {
        return ACCION;
    }

    public ArrayList<LibroComedia> getCOMEDIA() {
        return COMEDIA;
    }

    public ArrayList<LibroTerror> getTERROR() {
        return TERROR;
    }
}


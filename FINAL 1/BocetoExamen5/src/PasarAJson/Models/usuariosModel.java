package PasarAJson.Models;

import Usuarios.Coordinador;
import Usuarios.Estudiante;
import Usuarios.Profesor;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;

public class usuariosModel {

    @Expose
    private ArrayList<Estudiante> ESTUDIANTE = new ArrayList<>();
    @Expose
    private ArrayList<Profesor> PROFESOR = new ArrayList<>();
    @Expose
    private ArrayList<Coordinador> COORDINADOR = new ArrayList<>();

    public ArrayList<Estudiante> getESTUDIANTE() {
        return ESTUDIANTE;
    }

    public ArrayList<Profesor> getPROFESOR() {
        return PROFESOR;
    }

    public ArrayList<Coordinador> getCOORDINADOR() {
        return COORDINADOR;
    }
}

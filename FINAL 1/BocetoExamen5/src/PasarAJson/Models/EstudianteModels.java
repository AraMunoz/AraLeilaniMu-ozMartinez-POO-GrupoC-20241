package PasarAJson.Models;

import Usuarios.Estudiante;
import Usuarios.Profesor;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;

public class EstudianteModels {
    @Expose
    public  static ArrayList<Estudiante> ESTUDIANTE = new ArrayList<>();

    public  static ArrayList<Estudiante> getESTUDIANTE() {
        return ESTUDIANTE;
    }



}

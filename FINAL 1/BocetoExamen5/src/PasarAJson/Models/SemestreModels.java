package PasarAJson.Models;

import Escuela.Calificaciones;
import Escuela.Semestre;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;

public class SemestreModels {
    @Expose
    public  static ArrayList<Semestre> semestres = new ArrayList<>();

    public  static ArrayList<Semestre> getsemestres() {
        return semestres;
    }
}

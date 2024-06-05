package PasarAJson.Models;

import Escuela.Calificaciones;
import Usuarios.Coordinador;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;

public class CalificacionesModels {
    @Expose
    public  static ArrayList<Calificaciones> todasLasCalificaciones = new ArrayList<>();

    public  static ArrayList<Calificaciones> getTodasLasCalificaciones() {
        return todasLasCalificaciones;
    }
}

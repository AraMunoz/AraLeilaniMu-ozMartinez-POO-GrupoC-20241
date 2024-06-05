package PasarAJson.Models;
import Usuarios.Profesor;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;

public class ProfesorModels {
    @Expose
    public  static ArrayList<Profesor> PROFESOR = new ArrayList<>();

    public  static ArrayList<Profesor> getPROFESOR() {
        return PROFESOR;
    }
}

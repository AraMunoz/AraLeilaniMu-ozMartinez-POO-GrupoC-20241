package PasarAJson.Models;


import Usuarios.Coordinador;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;

public class CoordinadorModel {
    @Expose
    public  static ArrayList<Coordinador> COORDINADOR = new ArrayList<>();

    public  static ArrayList<Coordinador> getPROFESOR() {
        return COORDINADOR;
    }
}

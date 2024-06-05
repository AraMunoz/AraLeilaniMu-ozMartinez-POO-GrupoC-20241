package PasarAJson.Models;

import Escuela.Grupo;
import Extras.ProfesorTieneMateria;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;

public class GrupoModels {
    @Expose
    public  static ArrayList<Grupo> grupos = new ArrayList<>();

    public  static ArrayList<Grupo> getGrupos() {
        return grupos;
    }
}

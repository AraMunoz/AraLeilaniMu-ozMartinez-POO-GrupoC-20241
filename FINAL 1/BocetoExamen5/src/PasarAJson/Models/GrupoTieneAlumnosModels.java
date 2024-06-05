package PasarAJson.Models;
import Extras.GrupoTieneAlumnos;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;

public class GrupoTieneAlumnosModels {
    @Expose
    public  static ArrayList<GrupoTieneAlumnos> listaAlumnosEnGrupos = new ArrayList<>();

    public  static ArrayList<GrupoTieneAlumnos> getListaAlumnosEnGrupos() {
        return listaAlumnosEnGrupos;
    }
}

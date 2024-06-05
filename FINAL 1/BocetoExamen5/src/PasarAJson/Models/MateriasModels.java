package PasarAJson.Models;

import Escuela.Materias;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;

public class MateriasModels {
    @Expose
    public  static ArrayList<Materias> listaMaterias = new ArrayList<>();

    public  static ArrayList<Materias> getListaMaterias() {
        return listaMaterias;
    }
}

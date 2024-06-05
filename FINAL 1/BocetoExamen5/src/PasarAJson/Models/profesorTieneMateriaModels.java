package PasarAJson.Models;
import Extras.ProfesorTieneMateria;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;

public class profesorTieneMateriaModels {
    @Expose
    public  static ArrayList<ProfesorTieneMateria> listaRelacionProfeYMateria = new ArrayList<>();

    public  static ArrayList<ProfesorTieneMateria> getListaRelacionProfeYMateria() {
        return listaRelacionProfeYMateria;
    }
}

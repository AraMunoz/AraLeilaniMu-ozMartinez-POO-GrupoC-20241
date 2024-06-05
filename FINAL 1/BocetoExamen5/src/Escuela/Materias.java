package Escuela;

import Usuarios.Profesor;
import com.google.gson.annotations.Expose;

public class Materias {
    @Expose
    private String nombre;
    @Expose
    private int id;
    @Expose
    private String carrera;
    @Expose
    private int nombreSemestre;

    public Materias(int id, String nombre, String carrera, int nombreSemestre) {
        this.nombre = nombre;
        this.id = id;
        this.carrera = carrera;
        this.nombreSemestre = nombreSemestre;
    }
    public int getNombreSemestre() {
        return nombreSemestre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    @Override
    public String toString() {
        return String.format("Materia: nombre='%s', id=%d, carrera='%s', nombreSemestre=%d}", nombre, id, carrera, nombreSemestre);
    }

    public void setNombreSemestre(int nombreSemestre) {
        this.nombreSemestre = nombreSemestre;
    }
}

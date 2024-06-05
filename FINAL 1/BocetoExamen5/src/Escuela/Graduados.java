package Escuela;

import java.util.List;

public class Graduados
{
    private String fechaGraduacion;
    private String carrera;
    private List<AlumnoGraduado> alumnos;
    private String generacion;

    public Graduados(String fechaGraduacion, String carrera, List<AlumnoGraduado> alumnos, String generacion) {
        this.fechaGraduacion = fechaGraduacion;
        this.carrera = carrera;
        this.alumnos = alumnos;
        this.generacion = generacion;
    }

    // Getters y setters
    public String getFechaGraduacion() {
        return fechaGraduacion;
    }

    public void setFechaGraduacion(String fechaGraduacion) {
        this.fechaGraduacion = fechaGraduacion;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public List<AlumnoGraduado> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<AlumnoGraduado> alumnos) {
        this.alumnos = alumnos;
    }

    public String getGeneracion() {
        return generacion;
    }

    public void setGeneracion(String generacion) {
        this.generacion = generacion;
    }

    // Clase interna AlumnoGraduado, COMO Q NO CUADRA ESTE JALE
    public static class AlumnoGraduado {
        private String nombre;
        private double promedio;

        public AlumnoGraduado(String nombre, double promedio) {
            this.nombre = nombre;
            this.promedio = promedio;
        }

        // Getters y setters
        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public double getPromedio() {
            return promedio;
        }

        public void setPromedio(double promedio) {
            this.promedio = promedio;
        }
    }
}

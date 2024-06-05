package Escuela;

import Extras.GrupoTieneAlumnos;
import Usuarios.Estudiante;
import Usuarios.Usuario;
import com.google.gson.annotations.Expose;
import utilsGlobal.Carrera.Carrera;
import utilsGlobal.Carrera.Carreras;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Escuela.Sistema.*;

public class Semestre {

    private static int idSemestre = 1;
    @Expose
    private int id;
    @Expose
    private int numero;
    @Expose
    private Carreras carrera;
    @Expose
    private int year;

    public Semestre()
    {
    }
    public Semestre(int numero, Carreras carrera, int year) {
        this.id = idSemestre;
        this.numero = numero;
        this.carrera = carrera;
        this.year = year;
        idSemestre++;
    }
    public static void registrarSemestre(Usuario usuarioActual) {
        Scanner leer = new Scanner(System.in);
        boolean datoValido = true;
        int nombreSemestre = 0;

        do {
            System.out.println("\nIngresa el semestre a registrar: ");
            System.out.println("\n1. Primer semestre");
            System.out.println("2. Segundo semestre");
            System.out.println("3. Tercer semestre");

            try {
                nombreSemestre = leer.nextInt();
                if (nombreSemestre >= 1 && nombreSemestre <= 3) {
                    datoValido = false;
                } else {
                    System.out.println("\nIngrese un número entre 1 y 3.");
                }

            } catch (Exception e) {
                System.out.println("\nIngrese un número");
                leer.nextLine();
            }
        } while (datoValido);

        Semestre newSemestre = new Semestre(nombreSemestre, usuarioActual.getCarrera(), 2023);
        Sistema.semestres.add(newSemestre);

        System.out.println("\nEl semestre ha sido registrado con exito. El id del semestre es: " + newSemestre.getId());
        Sistema.serializar();
    }

   /* public void avanzar2doSemestre(Usuario usuarioActual, int idGrupo) {
        for (GrupoTieneAlumnos buscar : listaDeAlumnosEnGrupos) {
            if (buscar.getIdGrupo() == idGrupo) {
                for (Estudiante alumno : listaEstudiantes) {
                    if (alumno.getEsAprobado() && buscar.getNumeroDeControlAlumno().equals(alumno.getNumeroDeControl())) {
                        int año = Integer.valueOf(alumno.getFechaDeRegistro());
                        Semestre avanzarSemestre = new Semestre(
                                2, usuarioActual.getCarrera(), año);
                        AvanzarSemestre.actualizarInformacionAlumno(alumno, avanzarSemestre, usuarioActual);
                        semestres.add(avanzarSemestre);
                        System.out.println("El id del semestre es: " + avanzarSemestre.getId());
                    }
                }
            }
            // Hacer un método para que al calificar se vea que el estudiante está aprobado o reprobado.
        }
    } */
   @Override
   public String toString() {
       return String.format("Semestre: id=%d, numero=%d, carrera=%s, year=%d}", id, numero, carrera, year);
   }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Carreras getCarrera() {
        return carrera;
    }

    public void setCarrera(Carreras carrera) {
        this.carrera = carrera;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}

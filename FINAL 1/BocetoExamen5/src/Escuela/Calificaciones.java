package Escuela;

import Extras.ProfesorTieneMateria;
import Usuarios.Estudiante;
import Usuarios.Profesor;
import Usuarios.Usuario;
import com.google.gson.annotations.Expose;

import java.util.*;
import java.util.stream.Collectors;

public class Calificaciones {

    private static int CONTADOR = 1;
    @Expose
    private int id;
    @Expose
    private int idProfesorTieneMateria;
    @Expose
    private String numeroControlAlumno;
    @Expose
    private double calificacion;


    public Calificaciones(int idProfesorTieneMateria, String numeroControlAlumno, double calificacion) {
        this.id = CONTADOR++;
        this.idProfesorTieneMateria = idProfesorTieneMateria;
        this.numeroControlAlumno = numeroControlAlumno;
        setCalificacion(calificacion); // Asigna la calificación usando el setter para validación
    }

    //////// ASIGNAR CALIFICACIÓN A ESTUDIANTE EN PARTICULAR.////////
    public static void asignarCalificacionAAlumno() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese el número de control del alumno:");
        String numeroControlAlumno = leer.nextLine();

        Estudiante alumno = buscarAlumnoPorNumeroDeControl(numeroControlAlumno);
        if (alumno == null) {
            System.out.println("No se encontró un alumno con ese número de control.");
            return;
        }

        boolean folioValido = true;
        int idProfesorTieneMateria = 0;
        do {
            System.out.println("Ingrese el folio de la asignación (profesor tiene materia): ");
            try {
                idProfesorTieneMateria = leer.nextInt();
                leer.nextLine();
                folioValido = false;
            } catch (Exception e) {
                System.out.println("Ingrese solo números");
                leer.nextLine();
            }
        } while (folioValido);

        boolean idValido = true;
        int idmateria = 0;
        do {
            System.out.println("Ingrese id de la materia: ");
            try {
                idmateria = leer.nextInt();
                leer.nextLine();
                idValido = false;
            } catch (Exception e) {
                System.out.println("Ingrese solo números");
                leer.nextLine();
            }
        } while (idValido);


        if (!validarRelacionProfeTieneMateria(idProfesorTieneMateria)) {
            System.out.println("El id del bloque no existe.");
            return;
        }

        if (!validarMateriaParaAlumno(idmateria, alumno)) {

            System.out.println("El alumno no tiene asignada esa materia.");
            return;
        }

        double calificacion = 0.0;
        boolean calificacionValida = true;
        do {
            System.out.println("Ingrese la calificación:");
            try {
                calificacion = leer.nextDouble();
                leer.nextLine();
                calificacionValida = false;
            } catch (Exception e) {
                System.out.println("Ingrese solo números");
                leer.nextLine();
            }
        } while (calificacionValida);


        Calificaciones newCalificacion = new Calificaciones(idProfesorTieneMateria, numeroControlAlumno, calificacion);
        System.out.println("Calificación asignada correctamente");

        if (estaAprobado(calificacion)) {
            System.out.println("El estudiante ha sido aprobado con una calificación de: " + calificacion);
            alumno.setEsAprobado(true);
        } else {
            System.out.println("El estudiante ha reprobado con una calificación de: " + calificacion);
        }
        Sistema.todasLasCalificaciones.add(newCalificacion);
        Sistema.serializar();

    }


    public static boolean validarMateriaParaAlumno(int idMateria, Estudiante alumno) {
        for (Materias materiaAlumno : alumno.getMisMaterias()) {
            if (materiaAlumno.getId() == idMateria) {
                return true;
            }
        }
        return false;
    }

    public static String mostrarMateriaParaAlumno(Estudiante alumno) {
        for (Materias materiaAlumno : alumno.getMisMaterias()) {
            if (materiaAlumno.getNombreSemestre() == alumno.getSemestre()) {
                return materiaAlumno.getNombre();
            }
        }
        return null;
    }

    public static int obtenerMateriaDelBloque(int idProfesorMateria) {
        for (ProfesorTieneMateria relacion : Sistema.listaRelacionProfeYMateria) {
            if (relacion.getIdRelacion() == idProfesorMateria) {
                return relacion.getIdMateria();
            }
        }
        throw new IllegalArgumentException("No se encontró una relación de profesor y materia con el ID proporcionado: " + idProfesorMateria);
    }

    public static Materias buscarMateriaPorId(int idMateria) {
        for (Materias materia : Sistema.listaMaterias) {
            if (materia.getId() == idMateria) {
                return materia;
            }
        }
        return null;
    }

    public static boolean validarRelacionProfeTieneMateria(int idProfesorTieneMateria) {
        for (ProfesorTieneMateria buscarRelacion : Sistema.listaRelacionProfeYMateria) {
            if (buscarRelacion.getIdRelacion() == idProfesorTieneMateria) {
                return true;
            }
        }
        return false;
    }

    public static void verInformacionAlumno(String numeroDeControl) {

        Estudiante alumno = buscarAlumnoPorNumeroDeControl(numeroDeControl);

        if (alumno != null) {
            System.out.println("Información del Alumno:");
            System.out.println(alumno.toString());

            System.out.println("\nMaterias Inscritas:");
            List<Materias> materiasInscritas = alumno.getMisMaterias();
            if (materiasInscritas.isEmpty()) {
                System.out.println("El alumno no tiene materias inscritas.");
            } else {
                mostrarMateriaParaAlumno(alumno);
            }
        } else {
            System.out.println("No se encontró un alumno con el número de control proporcionado.");
        }
    }

    private static Estudiante buscarAlumnoPorNumeroDeControl(String numeroControlAlumno) {

        for (Estudiante buscarEstudiante : Sistema.listaEstudiantes) {
            if (buscarEstudiante.getNumeroDeControl().equals(numeroControlAlumno) && buscarEstudiante != null) {
                return buscarEstudiante;
            }
        }
        return null;
    }

    public static List<Calificaciones> obtenerCalificacionesPorAlumno(String numeroControlAlumno) {
        return Sistema.todasLasCalificaciones.stream()
                .filter(calificacion -> calificacion.getNumeroControlAlumno().equals(numeroControlAlumno))
                .collect(Collectors.toList());
    }

    public static List<Calificaciones> obtenerCalificacionesPorProfesorYMateria(int idProfesorTieneMateria) {
        return Sistema.todasLasCalificaciones.stream()
                .filter(calificacion -> calificacion.getIdProfesorTieneMateria() == idProfesorTieneMateria)
                .collect(Collectors.toList());
    }

    public static double calcularPromedioAlumno(String numeroControlAlumno) {
        List<Calificaciones> calificaciones = obtenerCalificacionesPorAlumno(numeroControlAlumno);
        return calificaciones.stream()
                .mapToDouble(Calificaciones::getCalificacion)
                .average()
                .orElse(0.0); // Retorna 0 si no hay calificaciones.
    }


    public static boolean estaAprobado(double calificacion) {
        return calificacion >= 70;
    }


    public static void buscarCalificacionParaActualizarla(int idCalificacion, double nuevaCalificacion) {
        for (Calificaciones calificacion : Sistema.todasLasCalificaciones) {
            if (calificacion.getId() == idCalificacion) {
                calificacion.setCalificacion(nuevaCalificacion);
                break;
            }
        }
    }

    public static void eliminarCalificacion(int idCalificacion) {
        Sistema.todasLasCalificaciones.removeIf(calificacion -> calificacion.getId() == idCalificacion);
    }

    public int getId() {
        return id;
    }

    public int getIdProfesorTieneMateria() {
        return idProfesorTieneMateria;
    }

    public void setIdProfesorTieneMateria(int idProfesorTieneMateria) {
        this.idProfesorTieneMateria = idProfesorTieneMateria;
    }

    public String getNumeroControlAlumno() {
        return numeroControlAlumno;
    }

    public void setNumeroControlAlumno(String numeroControlAlumno) {
        this.numeroControlAlumno = numeroControlAlumno;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;

    }

    public static boolean obtenerSemestresCursadosPorAlumno(String numeroControlAlumno, int semestre) {
        for (Estudiante alumno : Sistema.listaEstudiantes) {
            if (alumno.getSemestre() == semestre) {
                return true;
            }
        }
        return false;
    }

    public static List<Calificaciones> obtenerCalificacionesPorAlumnoYSemestre(String numeroControlAlumno, int semestre) {
        List<Calificaciones> calificacionesPorSemestre = new ArrayList<>();
        if (obtenerSemestresCursadosPorAlumno(numeroControlAlumno, semestre)) {
            List<Calificaciones> calificacionesAlumno = obtenerCalificacionesPorAlumno(numeroControlAlumno);
            for (Calificaciones calificacion : calificacionesAlumno) {
                int idMateria = obtenerMateriaDelBloque(calificacion.getIdProfesorTieneMateria());
                Materias materia = buscarMateriaPorId(idMateria);
                if (materia != null && materia.getNombreSemestre() == semestre) {
                    calificacionesPorSemestre.add(calificacion);
                }
            }
        }
        return calificacionesPorSemestre;
    }
}
package Escuela;

import Extras.GrupoTieneAlumnos;
import Usuarios.Estudiante;
import Usuarios.Usuario;
import utilsGlobal.Carrera.Carrera;
import utilsGlobal.Carrera.Carreras;
import utilsGlobal.TipoGrupo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static Escuela.Sistema.*;

public class AvanzarSemestre {

    /*
    CREACIÓN DE SEMESTRE
    Hay 2o de generación actual - 2? -> Crea un semestre de 3o con la misma generación							X-2
    Hay 1o de generación actual - 1? -> Crea un semestre de 2o con la misma generación							X-1
    Crea un semestre de 1o con la generación actual					                                    		X

*/
    private List<Semestre> obtenerSemestre(int generacion, Carreras carrera) {
        return semestres.stream()
                .filter(semestre -> semestre.getYear() == generacion && semestre.getCarrera() == carrera)
                .collect(Collectors.toList());
    }


    public static void actualizarInformacionAlumno(Estudiante alumno, Semestre avanzando, Usuario usuarioActual) {
        alumno.setSemestre(avanzando.getNumero());

        ArrayList<Materias> nuevasMaterias = actualizarMaterias(alumno, avanzando, usuarioActual);
        if (nuevasMaterias != null) {
            alumno.setMisMaterias(nuevasMaterias);
        }
    }
    public static ArrayList<Materias> actualizarMaterias(Estudiante alumno, Semestre avanzarSemestre, Usuario usuarioActual) {
        ArrayList<Materias> nuevasMaterias = new ArrayList<>();
        for (Materias materia : Sistema.listaMaterias) {
            if (materia.getNombreSemestre() == avanzarSemestre.getNumero() &&
                    materia.getCarrera().equals(usuarioActual.getCarrera())) {
                nuevasMaterias.add(materia);
            }
        }
        return nuevasMaterias;
    }

    public static void avanzarAlumnoDeSemestre(Usuario usuarioActual){
        System.out.println("Ingrese el número de control: ");
        String noDeControl = leer.nextLine();
        for (Estudiante buscarEstudiante: listaEstudiantes){
            if (buscarEstudiante.getNumeroDeControl().equals(noDeControl) && buscarEstudiante.isEsAprobado()){
                avanzarSemestre(buscarEstudiante, usuarioActual);
            }
            else {
                System.out.println("No se puede avanzar de semestre al estudiante.");
            }
        }
    }

    public static void avanzarSemestre(Estudiante alumno, Usuario usuarioActual) {
        int year = Integer.parseInt(alumno.getFechaDeRegistro());
        if(!((alumno.getSemestre()+1) < 4)) {
            Semestre nuevoSemestre = new Semestre(alumno.getSemestre() + 1, alumno.getCarrera(), year);
            semestres.add(nuevoSemestre);
            Grupo newGrupo = new Grupo(usuarioActual.getCarrera(), nuevoSemestre.getNumero(), TipoGrupo.A);
            grupos.add(newGrupo);
            alumno.setSemestre(alumno.getSemestre() + 1);
            List<Materias> nuevasMaterias = obtenerMateriasParaSemestre(alumno.getSemestre(), newGrupo.getIdGrupo(), usuarioActual);
            alumno.getMisMaterias().addAll(nuevasMaterias);

            alumno.setPromedio(0);  // Reiniciar el promedio

            System.out.println("El estudiante " + alumno.getNombre() + " " + alumno.getApellidoPaterno() + " ha avanzado al semestre " + alumno.getSemestre());
            System.out.println("Nuevas materias asignadas:");

            for (Materias materia : nuevasMaterias) {
                System.out.println("Materia: " + materia.getNombre());
            }
        }
        else {
            alumno.setGraduado(true);
            System.out.println("¡Felicidades! Te has graduado.");
        }
    }


    private static List<Materias> obtenerMateriasParaSemestre(int semestre, int idGrupo, Usuario usuarioActual) {
        /*List<Materias> materiasParaSemestre = new ArrayList<>();
        for (Materias materia : listaMaterias) {
            if (materia.getNombreSemestre() == semestre) {
                materiasParaSemestre.add(materia);
            }
        }
        return materiasParaSemestre;*/
        String carreraUsuario = String.valueOf(usuarioActual.getCarrera());
        for (Grupo grupo : Sistema.grupos) {
            if (grupo.getIdGrupo() == idGrupo) {
                List<Materias> materiasDelGrupo = new ArrayList<>();
                for (Materias materia : Sistema.listaMaterias) {
                    String carreraMateria = String.valueOf(materia.getCarrera());
                    if (materia.getNombreSemestre() == grupo.getSemestre() &&  carreraUsuario.equals(carreraMateria)) {
                        materiasDelGrupo.add(materia);
                    }
                }
                return materiasDelGrupo;
            }
        }
        return null;
    }

public void promoverEstudiantes() {
    // Crear un nuevo semestre para la nueva generación
        Semestre nuevoSemestre1 = new Semestre();
        semestres.add(nuevoSemestre1);

        // Crear un nuevo semestre 2 para la generación actual
        Semestre nuevoSemestre2 = new Semestre();
        semestres.add(nuevoSemestre2);

        // Mapa para rastrear estudiantes por carrera y semestre
        Map<Carreras, Map<Integer, List<Estudiante>>> estudiantesPorCarreraYSemestre = new HashMap<>();

        // Inicializar el mapa con listas vacías para cada carrera y semestre
        for (Carreras carrera : Carreras.values()) {
            Map<Integer, List<Estudiante>> semestresPorCarrera = new HashMap<>();
            for (int i = 1; i <= 3; i++) {
                semestresPorCarrera.put(i, new ArrayList<>());
            }
            estudiantesPorCarreraYSemestre.put(carrera, semestresPorCarrera);
        }

        // Procesar cada estudiante para promover o retener
        for (Estudiante estudiante : obtenerTodosLosEstudiantes()) {
            if (estudiante.isEsAprobado()) {
                // Si el estudiante está en el semestre 1, promover al semestre 2
                if (estudiante.getSemestre() == 1) {
                    estudiante.setSemestre(2);
                    estudiantesPorCarreraYSemestre.get(estudiante.getCarrera()).get(2).add(estudiante);
                }
                // Si el estudiante está en el semestre 3, se gradúa
                else if (estudiante.getSemestre() == 3) {
                    estudiante.setGraduado(true);
                    // Agregar a la lista de graduados o manejar según sea necesario
                }
            } else {
                // Los estudiantes que no aprueban se quedan en el mismo semestre
                estudiantesPorCarreraYSemestre.get(estudiante.getCarrera()).get(estudiante.getSemestre()).add(estudiante);
            }
        }


        // Actualizar la lista de grupos y estudiantes en grupos según los cambios
        actualizarGrupos(estudiantesPorCarreraYSemestre);
    }

    private List<Estudiante> obtenerTodosLosEstudiantes() {
        // Implementar lógica para obtener todos los estudiantes del sistema
        return new ArrayList<>();
    }

    private void actualizarGrupos(Map<Carreras, Map<Integer, List<Estudiante>>> estudiantesPorCarreraYSemestre) {
        // Implementar lógica para actualizar los grupos con los estudiantes promovidos
    }



/*
    public AvanzarSemestre(List<Semestre> semestres) {
        this.semestres = semestres;
    }

    public boolean avanzarSemestre(Carreras carrera) {
        // Obtener el último semestre registrado para esta carrera
        Semestre ultimoSemestre = obtenerUltimoSemestre(carrera);

        // Si el último semestre es null o si es el tercer semestre, se gradúan los estudiantes
        if (ultimoSemestre == null || ultimoSemestre.getNumero() == 3) {
            graduarEstudiantes(carrera);
            return false; // No se puede avanzar más semestres
        }

        // Obtener el siguiente semestre
        int siguienteNumeroSemestre = ultimoSemestre.getNumero() + 1;
        Semestre siguienteSemestre = new Semestre(siguienteNumeroSemestre, carrera, ultimoSemestre.getYear());

        // Validar que los estudiantes aprueben todas sus materias para avanzar
        if (!validarEstudiantesAprobados(carrera, siguienteSemestre)) {
            return false; // No se pueden avanzar semestres si hay estudiantes reprobados
        }

        // Agregar el siguiente semestre
        semestres.add(siguienteSemestre);
        return true;
    }

    private Semestre obtenerUltimoSemestre(Carreras carrera) {
        return semestres.stream()
                .filter(semestre -> semestre.getCarrera() == carrera)
                .max((s1, s2) -> Integer.compare(s1.getYear(), s2.getYear()))
                .orElse(null);
    }

    private void graduarEstudiantes(Carreras carrera) {
        // Lógica para graduar estudiantes
        List<Estudiante> estudiantesPorGraduar = obtenerEstudiantesPorGraduar(carrera);
        // Aquí iría la lógica para graduar a los estudiantes, por ejemplo, cambiar su estado a "graduado"
        // También se podrían realizar otras acciones como enviar notificaciones, generar certificados, etc.
    }

    private List<Estudiante> obtenerEstudiantesPorGraduar(Carreras carrera) {
        return Sistema.listaEstudiantes.stream()
                .filter(estudiante -> estudiante.getCarrera() == carrera && estudiante.getSemestre() == 6) // Se gradúan en el sexto semestre
                .collect(Collectors.toList());
    }

    private boolean validarEstudiantesAprobados(Carreras carrera, Semestre siguienteSemestre) {
        // Lógica para validar que los estudiantes aprueben todas sus materias
        List<Estudiante> estudiantes = obtenerEstudiantesPorSemestre(carrera, siguienteSemestre);
        for (Estudiante estudiante : estudiantes) {
            // Aquí se debería validar que el estudiante apruebe todas sus materias
            // Si un estudiante reprueba una materia, retornar false
            // Por ejemplo:
            // if (!estudiante.aproboTodasLasMaterias()) {
            //     return false;
            // }
        }
        return true; // Temporal: Debe implementarse la lógica real
    }

    private List<Estudiante> obtenerEstudiantesPorSemestre(Carreras carrera, Semestre semestre) {
        return Sistema.listaEstudiantes.stream()
                .filter(estudiante -> estudiante.getCarrera() == carrera && estudiante.getSemestre() == semestre.getNumero())
                .collect(Collectors.toList());
    }
     */
}
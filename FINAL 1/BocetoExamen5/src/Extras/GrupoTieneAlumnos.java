package Extras;

import Escuela.Grupo;
import Escuela.Materias;
import Escuela.Sistema;
import Usuarios.Estudiante;
import Usuarios.Profesor;
import Usuarios.Rol;
import Usuarios.Usuario;
import com.google.gson.annotations.Expose;
import utilsGlobal.Carrera.Carreras;
import utilsGlobal.TipoGrupo;
import utilsGlobal.UsuarioEnSesion;

import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

public class GrupoTieneAlumnos {
    private static Scanner leer = new Scanner(System.in);
    @Expose
    private int idGrupo;
    @Expose
    private String numeroDeControlAlumno;

    public GrupoTieneAlumnos(String numeroDeControlAlumno, int idGrupo) {
        this.idGrupo = idGrupo;
        this.numeroDeControlAlumno = numeroDeControlAlumno;
    }

   /////////////////////////////////Registrar Alumnos a Grupos////////////////////////////////

    private static void registrarAlumnosEnGrupo(int idGrupo, Usuario usuarioActual){
        Scanner leer = new Scanner(System.in);

        Estudiante alumno = null;
        boolean alumnoSiExiste = true;
        String numeroDeControlAlumno = null;
        String carreraUsuario = String.valueOf(usuarioActual.getCarrera());
        String carreraAlumno = null;
        do {
            try {
                System.out.println("\nIngresa el numero de control del alumno: ");
                numeroDeControlAlumno = leer.nextLine();
                 alumno = encontrarEstudiantePorNumeroDeControl(usuarioActual, numeroDeControlAlumno);
                 if(alumno!= null)
                     carreraAlumno = String.valueOf(encontrarEstudiantePorNumeroDeControl(usuarioActual, numeroDeControlAlumno).getCarrera());

                if (!alumnoExiste(numeroDeControlAlumno)) {
                    alumnoSiExiste = true;
                    System.out.println("El numero de control ingresado no existe.");
                } if (!carreraUsuario.equals(carreraAlumno)) {
                    System.out.println("El alumno no pertenece a la carrera de " + usuarioActual.getCarrera());
                    alumnoSiExiste = true;
                }
                else {
                    alumnoSiExiste = false;

                }
            }catch(Exception e){
                System.out.println("Error "+e);
            }
        }while(alumnoSiExiste);
        leer.nextLine();


        Grupo grupoSeleccionado = null;
        for (Grupo grupo : Sistema.grupos) {
            if (grupo.getIdGrupo() == idGrupo) {
                grupoSeleccionado = grupo;
                break;
            }
        }

        if (grupoSeleccionado != null && !alumno.isEstaEnGrupo()) {

            if (grupoSeleccionado.getAlumnosEnGrupo() < 20 && alumnoExiste(numeroDeControlAlumno )&& alumno.getCarrera().equals(usuarioActual.getCarrera()) ) {
                GrupoTieneAlumnos alumnoEnGrupo = new GrupoTieneAlumnos(numeroDeControlAlumno, idGrupo);
                Sistema.listaDeAlumnosEnGrupos.add(alumnoEnGrupo);
                grupoSeleccionado.agregarAlumno();
                alumno.setSemestre(grupoSeleccionado.getSemestre());
                System.out.println("El alumno ha sido registrado correctamente.\n " +
                        "Ahora el grupo tiene: " + grupoSeleccionado.getAlumnosEnGrupo() + " alumnos.");

                // Asignar las materias del grupo al alumno
                Estudiante estudiante = encontrarEstudiantePorNumeroDeControl(UsuarioEnSesion.obtenerInstancia().getUsuarioActual(), numeroDeControlAlumno);
                if(estudiante != null){
                    List<Materias> materiasDelGrupo = obtenerMateriasPorGrupo(idGrupo, usuarioActual);
                    estudiante.getMisMaterias().addAll(materiasDelGrupo);
                    System.out.println("Las materias han sido asignadas al estudiante.");
                }
                estudiante.setEstaEnGrupo(true);

            } else if (grupoSeleccionado.getAlumnosEnGrupo() >= 20){
                System.out.println("El grupo A ya está lleno, creando un nuevo grupo tipo B.");
                Grupo nuevoGrupoB = Grupo.crearNuevoGrupo(grupoSeleccionado.getCarrera(), grupoSeleccionado.getSemestre(), TipoGrupo.B);
                Sistema.grupos.add(nuevoGrupoB);
                GrupoTieneAlumnos alumnoEnGrupo = new GrupoTieneAlumnos(numeroDeControlAlumno, nuevoGrupoB.getIdGrupo());
                Sistema.listaDeAlumnosEnGrupos.add(alumnoEnGrupo);
                nuevoGrupoB.agregarAlumno();
                alumno.setSemestre(grupoSeleccionado.getSemestre());
                System.out.println("El alumno ha sido registrado en el nuevo grupo B correctamente.\n " +
                        "El nuevo grupo tiene: " + nuevoGrupoB.getAlumnosEnGrupo() + " alumno.");


                // Asignar las materias del grupo al alumno
                Estudiante estudiante = encontrarEstudiantePorNumeroDeControl(UsuarioEnSesion.obtenerInstancia().getUsuarioActual(), numeroDeControlAlumno);
                if(estudiante != null){
                    List<Materias> materiasDelGrupo = obtenerMateriasPorGrupo(idGrupo, usuarioActual);
                    estudiante.getMisMaterias().addAll(materiasDelGrupo);
                    System.out.println("Las materias han sido asignadas al estudiante.");
                }
            }
        } else if (alumno.isEstaEnGrupo()){
            System.out.println("El alumno ya esta en el grupo.");
        }
        else{
            System.out.println("Verifique sus datos.");
        }

        Sistema.serializar();
    }


    public static void registrarVariosAlumnos(int numeroAlumnos, Usuario usuarioActual){
        System.out.println("\n*******Bienvenido*******");
        int contador=0;
        boolean datoValido = true;
        int idGrupo=0;
        do{
            System.out.println("Ingresa el id del grupo: ");
            try {
                idGrupo = leer.nextInt();
                leer.nextLine();
                datoValido = false;
            } catch (Exception e) {
                System.out.printf("Ingresa un número");
                leer.nextLine();
            }
        }while(datoValido);
        if (verificarGrupoExistente(idGrupo)) {
        while(contador<numeroAlumnos) {

            registrarAlumnosEnGrupo(idGrupo, usuarioActual);
            contador++;
        }
            }else{
                System.out.println("Grupo no encontrado.");
            }
    }
    public static boolean verificarGrupoExistente(int idGrupo){
        for (Grupo buscarGrupo : Sistema.grupos){
            if (buscarGrupo.getIdGrupo() == idGrupo){
                return true;
            }
        } return false;
    }

    /////////////////////////////////////Ver alumnos de un grupo //////////////////////////
    public static void verAlumnosDeGrupo(Usuario usuarioActual) {
        boolean datoValido = true;
        int idGrupo=0;
        do{
            System.out.println("Ingresa el id del grupo: ");
            try {
                idGrupo = leer.nextInt();
                datoValido = false;
            } catch (Exception e) {
                System.out.printf("Ingresa un número");
                leer.nextLine();
            }
        }while(datoValido);

        Grupo grupoSeleccionado = null;
        for (Grupo grupo : Sistema.grupos) {
            if (grupo.getIdGrupo() == idGrupo) {
                grupoSeleccionado = grupo;
                break;
            }
        }

        if (grupoSeleccionado != null) {
            boolean hayAlumnos = false;
            for (GrupoTieneAlumnos relacion : Sistema.listaDeAlumnosEnGrupos) {
                if (relacion.getIdGrupo() == idGrupo) {
                    Estudiante estudiante = encontrarEstudiantePorNumeroDeControl(usuarioActual,relacion.getNumeroDeControlAlumno());
                    if (estudiante != null) {
                        hayAlumnos = true;
                        System.out.println("\nNúmero de Control: " + estudiante.getNumeroDeControl());
                        System.out.println("Nombre: " + estudiante.getNombre());
                        System.out.println("Grupo ID: " + idGrupo);
                        System.out.println("Tipo de Grupo: " + grupoSeleccionado.getTipoGrupo());
                        System.out.println("Carrera: " + estudiante.getCarrera());
                        System.out.println("-------------------------");
                    }
                }
            }
            if (!hayAlumnos) {
                System.out.println("No hay alumnos registrados en este grupo.");
            }
        } else {
            System.out.println("El id ingresado no es correcto.");
        }
    }
    /////////////////////////////////////Ver información de grupo //////////////////////////

    /*public static void verInformacionDeGrupo() {
        System.out.println("Ingresa el id del grupo: ");
        boolean datoValido = true;
        int idGrupo = 0;
        do{
            System.out.println("Ingresa el id del grupo: ");
            try {
                idGrupo = leer.nextInt();
                datoValido = false;
            } catch (Exception e) {
                System.out.printf("Ingresa un número");
                leer.nextLine();
            }
        }while(datoValido);

        Grupo grupoSeleccionado = null;
        for (Grupo grupo : Sistema.grupos) {
            if (grupo.getIdGrupo() == idGrupo) {
                grupoSeleccionado = grupo;
                break;
            }
        }
        if (grupoSeleccionado != null) {
            System.out.println("\nInformación del Grupo ID: " + grupoSeleccionado.getIdGrupo());
            System.out.println("Tipo de Grupo: " + grupoSeleccionado.getTipoGrupo());
            System.out.println("Carrera: " + grupoSeleccionado.getCarrera());
            System.out.println("Semestre: " + grupoSeleccionado.getSemestre());
            System.out.println("Número de Alumnos: " + grupoSeleccionado.getAlumnosEnGrupo());
        } else {
            System.out.println("El id ingresado no es correcto.");
        }
    }*/

    public static void verInformacionDeGrupo(Usuario usuarioActual) {

        boolean idValido = true;
        int idGrupo = 0;
        do
        {
            System.out.println("Ingresa el id del grupo: ");
            try {
                idGrupo = leer.nextInt();
                idValido = false;
                leer.nextLine();
            } catch (Exception e) {
                System.out.println("Ingrese solo números");
                leer.nextLine();
            }
        }while(idValido);


        Grupo grupoSeleccionado = null;
        for (Grupo grupo : Sistema.grupos) {
            if (grupo.getIdGrupo() == idGrupo) {
                grupoSeleccionado = grupo;
                break;
            }
        }

        if (grupoSeleccionado != null) {
            System.out.println("Información del Grupo:");
            System.out.println("ID del Grupo: " + grupoSeleccionado.getIdGrupo());
            System.out.println("Carrera: " + grupoSeleccionado.getCarrera());
            System.out.println("Semestre: " + grupoSeleccionado.getSemestre());
            System.out.println("Tipo de Grupo: " + grupoSeleccionado.getTipoGrupo());
            System.out.println("Número de Alumnos: " + grupoSeleccionado.getAlumnosEnGrupo());

            System.out.println("\nAlumnos:");
            boolean hayAlumnos = false;
            for (GrupoTieneAlumnos relacion : Sistema.listaDeAlumnosEnGrupos) {
                if (relacion.getIdGrupo() == idGrupo) {
                    Estudiante estudiante = encontrarEstudiantePorNumeroDeControl( usuarioActual, relacion.getNumeroDeControlAlumno());
                    if (estudiante != null) {
                        hayAlumnos = true;
                        System.out.println("Número de Control: " + estudiante.getNumeroDeControl());
                        System.out.println("Nombre: " + estudiante.getNombre()+" "+estudiante.getApellidoPaterno()+" "+estudiante.getApellidoMaterno());
                        System.out.println("-------------------------");
                    }
                }
            }
            if (!hayAlumnos) {
                System.out.println("No hay alumnos registrados en este grupo.");
            }

            System.out.println("\nProfesores:");
            List<Profesor> profesores = obtenerProfesoresPorGrupo(idGrupo);
            if (profesores.isEmpty()) {
                System.out.println("No hay profesores asignados a este grupo.");
            } else {
                for (Profesor profesor : profesores) {
                    System.out.println("Nombre: " + profesor.getNombre());
                }
            }

            System.out.println("\nMaterias:");
            List<Materias> materias = obtenerMateriasPorGrupo(idGrupo, usuarioActual);
            if (materias.isEmpty()) {
                System.out.println("No hay materias asignadas a este grupo.");
            } else {
                for (Materias materia : materias) {
                    System.out.println("Materia: " + materia.getNombre());
                }
            }
        } else {
            System.out.println("El id ingresado no es correcto.");
        }
    }




    public static Estudiante encontrarEstudiantePorNumeroDeControl(Usuario usuarioActual, String numeroDeControl) {

        if(usuarioActual.getCarrera().equals(Carreras.ISC)){
            for (Usuario usuario : Sistema.usuariosISC.get(Rol.ESTUDIANTE)) {
                Estudiante estudiante = (Estudiante) usuario;
                if (estudiante.getNumeroDeControl().equals(numeroDeControl)) {
                    return estudiante;
                }
            }
        }
        else if (usuarioActual.getCarrera().equals(Carreras.ELC)){
            for (Usuario usuario : Sistema.usuariosELC.get(Rol.ESTUDIANTE)) {
                Estudiante estudiante = (Estudiante) usuario;
                if (estudiante.getNumeroDeControl().equals(numeroDeControl)) {
                    return estudiante;
                }
            }
        }
        else if(usuarioActual.getCarrera().equals(Carreras.IMAT)){
            for (Usuario usuario : Sistema.usuariosIMAT.get(Rol.ESTUDIANTE)) {
                Estudiante estudiante = (Estudiante) usuario;
                if (estudiante.getNumeroDeControl().equals(numeroDeControl)) {
                    return estudiante;
                }
            }
        }
        else{
            for (Usuario usuario : Sistema.listaEstudiantes) {
                Estudiante estudiante = (Estudiante) usuario;
                if (estudiante.getNumeroDeControl().equals(numeroDeControl)) {
                    return estudiante;
                }
            }
        }

        return null;
    }

    private static List<Profesor> obtenerProfesoresPorGrupo(int idGrupo) {
        List<Profesor> profesores = new ArrayList<>();
        for (ProfesorTieneMateria relacion : Sistema.listaRelacionProfeYMateria) {
            if (relacion.idGrupo == idGrupo) {
                Profesor profesor = encontrarProfesorPorNumeroDeControl(relacion.getNoControlProfesor());
                if (profesor != null) {
                    profesores.add(profesor);
                }
            }
        }
        return profesores;
    }

    public static Profesor encontrarProfesorPorNumeroDeControl(String numeroDeControl) {
        for (Profesor profesor : Sistema.listaProfesores) {
            if (profesor.getNumeroDeControl().equals(numeroDeControl)) {
                return profesor;
            }
        }
        return null;
    }


    private static List<Materias> obtenerMateriasPorGrupo(int idGrupo, Usuario usuarioActual) {
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

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }


    public String getNumeroDeControlAlumno() {
        return numeroDeControlAlumno;
    }

    public void setNumeroDeControlAlumno(String numeroDeControlAlumno) {
        this.numeroDeControlAlumno = numeroDeControlAlumno;
    }

    public static boolean alumnoExiste (String noControlAlumno){
        for (Estudiante buscarAlumno : Sistema.listaEstudiantes){
            if (buscarAlumno.getNumeroDeControl().equals(noControlAlumno)){
                return true;
            }
        } return false;
    }
    @Override
    public String toString() {
        return String.format(" idGrupo=%d, numeroDeControlAlumno='%s'}",
                idGrupo, numeroDeControlAlumno);
    }
}
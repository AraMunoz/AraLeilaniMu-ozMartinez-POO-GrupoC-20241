package Escuela;

import Extras.GrupoTieneAlumnos;
import Extras.ProfesorTieneMateria;
import PasarAJson.Serializers.EstudiantesSerialazer;
import Usuarios.*;
import utilsGlobal.Carrera.Carreras;

import java.sql.SQLOutput;
import java.util.*;

public class Sistema {

    public static Scanner leer = new Scanner(System.in);
    public static HashMap<Rol, ArrayList<Usuario>> usuariosISC = new HashMap<>();
    public static HashMap<Rol, ArrayList<Usuario>> usuariosIMAT = new HashMap<>();
    public static HashMap<Rol, ArrayList<Usuario>> usuariosELC = new HashMap<>();
    public static ArrayList<Semestre> semestres = new ArrayList<Semestre>();
    public static ArrayList<Grupo> grupos = new ArrayList<Grupo>();
    public static ArrayList<GrupoTieneAlumnos> listaDeAlumnosEnGrupos = new ArrayList<GrupoTieneAlumnos>();
    public static ArrayList<ProfesorTieneMateria> listaRelacionProfeYMateria = new ArrayList<>();
    public static ArrayList<Profesor> listaProfesores = new ArrayList<>();
    public static ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();
    public static final ArrayList<Coordinador> listaCoordinadores = new ArrayList<>();
    public static ArrayList<Calificaciones> todasLasCalificaciones = new ArrayList<>();
    public static ArrayList<Materias> listaMaterias = new ArrayList<Materias>();

    public Sistema() {
        usuariosISC.put(Rol.ESTUDIANTE, new ArrayList<>());
        usuariosISC.put(Rol.PROFESOR, new ArrayList<>());
        usuariosISC.put(Rol.COORDINADOR, new ArrayList<>());

        usuariosIMAT.put(Rol.ESTUDIANTE, new ArrayList<>());
        usuariosIMAT.put(Rol.PROFESOR, new ArrayList<>());
        usuariosIMAT.put(Rol.COORDINADOR, new ArrayList<>());

        usuariosELC.put(Rol.ESTUDIANTE, new ArrayList<>());
        usuariosELC.put(Rol.PROFESOR, new ArrayList<>());
        usuariosELC.put(Rol.COORDINADOR, new ArrayList<>());

        inicializarCoordinadores();
        inicializarEstudiantes();
        inicializarProfes();
        MateriasData.agregarMaterias();
        Sistema.serializar();
        //Sistema.leerJSON();
    }


    public static void registrarAlumnosEnGrupo(Usuario usuarioActual){

        boolean numerooAlumnos = true;
        do{
            System.out.println("Ingresa el numero de alumnos a registrar. ");
            int numeroAlumnos= leer.nextInt();
            leer.nextLine();
            if(numeroAlumnos<3){
                System.out.println("No puedes registrar menos de tres alumnos en un grupo. ");
            }
            else{
                GrupoTieneAlumnos.registrarVariosAlumnos(numeroAlumnos, usuarioActual);
                numerooAlumnos= false;
            }

        }while(numerooAlumnos);

    }
    public static void registrarSemestre(Usuario usuarioActual){
        Semestre.registrarSemestre(usuarioActual);
    }
    public static void registrarGrupo(Usuario usuarioActual){
        Grupo.registrarGrupo(usuarioActual);
    }
    public static void verUnGrupo(Usuario usuarioActual){
        GrupoTieneAlumnos.verInformacionDeGrupo(usuarioActual);
    }

    private void inicializarProfes(){
        Profesor profesorISC = new Profesor("Poncho", "ApellidoPaterno", "ApellidoMaterno", "FechaNacimiento",
                "CURP", "RFC", 10000.0, "NumeroDeControlISC", "FechaDeRegistro", "Estado", "Ciudad", "Dirección",
                Rol.PROFESOR, "Contraseña", Carreras.ISC, new ArrayList<>(), "Hombre");
        listaProfesores.add(profesorISC);
        usuariosISC.get(Rol.PROFESOR).add(profesorISC);
        Profesor profesorIMAT = new Profesor("María", "ApellidoPaterno", "ApellidoMaterno", "FechaNacimiento",
                "CURP", "RFC", 10000.0, "NumeroDeControlIMAT", "FechaDeRegistro", "Estado", "Ciudad", "Dirección",
                Rol.PROFESOR, "Contraseña", Carreras.IMAT, new ArrayList<>(), "Mujer");
        listaProfesores.add(profesorIMAT);
        usuariosIMAT.get(Rol.PROFESOR).add(profesorIMAT);
        Profesor profesorELC = new Profesor("Josefina", "ApellidoPaterno", "ApellidoMaterno", "FechaNacimiento",
                "CURP", "RFC", 10000.0, "NumeroDeControlELC", "FechaDeRegistro", "Estado", "Ciudad", "Dirección",
                Rol.PROFESOR, "Contraseña", Carreras.ELC,new ArrayList<>(), "hombre");
        listaProfesores.add(profesorELC);
        usuariosELC.get(Rol.PROFESOR).add(profesorELC);
    }

    private void inicializarCoordinadores() {
        Coordinador coordinadorISC;
        Coordinador coordinadorIMAT;
        Coordinador coordinadorELC;
        coordinadorISC = new Coordinador(
                "Bertin", "García", "Olmos", "1975/10/21",
                Usuario.generarCurp("Bertin", "García", "Olmos", "1975/10/21", "hombre", "MICHOACAN"),
                Usuario.generateRFC("Bertin", "García", "Olmos", "1975/10/21"),
                20000, "B19ISC0", "2024-05-27", "MICHOACAN", "Morelia", "José Frontera 210",
                Rol.COORDINADOR, "bertin123", Carreras.ISC, "Hombre");

        listaCoordinadores.add(coordinadorISC);
        usuariosISC.get(Rol.COORDINADOR).add(coordinadorISC);

        coordinadorIMAT = new Coordinador(
                "Camila", "Aguilar", "Cortéz", "1980/02/12",
                Usuario.generarCurp("Camila", "Aguilar", "Cortéz", "1980/02/12", "MUJER", "Guerrero"),
                Usuario.generateRFC("Camila", "Aguilar", "Cortéz", "1980/02/12"),
                30000, "C19IMAT0", "19/05/2020", "GUANAJUATO", "Acámbaro", "Av. Francisco I. Madero 560",
                Rol.COORDINADOR, "camila123", Carreras.IMAT, "Mujer");
        listaCoordinadores.add(coordinadorIMAT);
        usuariosIMAT.get(Rol.COORDINADOR).add(coordinadorIMAT);

        coordinadorELC = new Coordinador(
                "Nadia", "Rosales", "Pérez", "1977/08/17",
                Usuario.generarCurp("Nadia", "Rosales", "Pérez", "1977/08/17", "hombre", "MICHOACAN"),
                Usuario.generateRFC("Nadia", "Rosales", "Pérez", "1977/08/17"),
                20000, "N19ELC0", "27/09/2023", "MICHOACAN", "Morelia", "Romano Picutti 36",
                Rol.COORDINADOR, "carlos123", Carreras.ELC, "Mujer");
        listaCoordinadores.add(coordinadorELC);
        usuariosELC.get(Rol.COORDINADOR).add(coordinadorELC);
    }

    private void inicializarEstudiantes() {
        Estudiante estudianteISC = new Estudiante("Pancracia", "Juarez", "Zacarías", "09/09/2000", "PAJUZA0909200POO3", "PISC0", "01/06/2006", "MICHOACÁN", "MORELIA", "SU CASA",  "PATASDEPES", Carreras.ISC, false, "Mujer");
        listaEstudiantes.add(estudianteISC);
        usuariosISC.get(Rol.ESTUDIANTE).add(estudianteISC);
        Estudiante estudianteIMAT = new Estudiante("Ramona", "Sanchez", "Barriles", "09/09/2000", "PAJUZA0909200POO3", "RIMAT0", "01/06/2006", "MICHOACÁN", "MORELIA", "SU CASA",  "PEPSI", Carreras.IMAT,false, "Mujer");
        listaEstudiantes.add(estudianteIMAT);
        usuariosIMAT.get(Rol.ESTUDIANTE).add(estudianteIMAT);
        Estudiante estudianteELC = new Estudiante("Simón", "Alvaro", "Zacarías", "09/09/2000", "PAJUZA0909200POO3", "SELC0", "01/06/2006", "MICHOACÁN", "MORELIA", "SU CASA", "PATASDEPES", Carreras.ELC, false, "Hombre");
        listaEstudiantes.add(estudianteELC);
        usuariosELC.get(Rol.ESTUDIANTE).add(estudianteELC);
    }

    public static Usuario verificarInicioSesion(Carreras carrera, String nombreUsuario, String contrasena) {

        HashMap<Rol, ArrayList<Usuario>> usuariosPorCarreras = carrera.equals(Carreras.ISC) ? usuariosISC : carrera.equals(Carreras.IMAT) ? usuariosIMAT : usuariosELC;
        Collection<ArrayList<Usuario>> usuarios = usuariosPorCarreras.values();

        if (usuarios != null) {
            for (ArrayList<Usuario> users : usuarios) {

                for (Usuario user : users) {

                    if (user.getNumeroDeControl().equals(nombreUsuario) && user.getContrasena().equals(contrasena)) {

                        return user;
                    }
                }
            }
        } else {
            System.out.println("No hay usuarios registrados.");
        }
        return null;
    }

    public static void verCalificacionesPorAlumnoYSemestre(){
        boolean datosCorrectos = true;
        String numeroDeControl = null;
        do {
            System.out.println("Ingresa tu numero de control: ");
            numeroDeControl = leer.nextLine();
            if (!GrupoTieneAlumnos.alumnoExiste(numeroDeControl)) {
                System.out.println("El número de control ingresado no existe. Intenta nuevamente.");
            } else {
                datosCorrectos = false;
            }
        } while (datosCorrectos);


        datosCorrectos = true;

        int semestre = 0;
        do {
            System.out.println("Ingresa el semestre que quieres consultar: ");
            try {
                semestre = leer.nextInt();
                leer.nextLine();
                if (!Calificaciones.obtenerSemestresCursadosPorAlumno(numeroDeControl, semestre)) {
                    System.out.println("El semestre ingresado no ha sido cursado por el alumno. Intenta nuevamente.");
                } else {
                    datosCorrectos = false;
                }
            } catch (NumberFormatException e) {
               System.out.println("Ingresa un número válido para el semestre.");
            }
        } while (datosCorrectos);
        List<Calificaciones> calificacionesPorSemestre = Calificaciones.obtenerCalificacionesPorAlumnoYSemestre(numeroDeControl, semestre);
        if (!calificacionesPorSemestre.isEmpty()) {
            System.out.println("\nCalificaciones para el semestre " + semestre + ":");
            for (Calificaciones calificacion : calificacionesPorSemestre) {
                int idMateria = Calificaciones.obtenerMateriaDelBloque(calificacion.getIdProfesorTieneMateria());
                Materias materia = Calificaciones.buscarMateriaPorId(idMateria);
                if (materia != null) {
                    System.out.println("\nMateria: " + materia.getNombre() + "\nCalificación: " + calificacion.getCalificacion());

                }
            }
        } else {
            System.out.println("No hay calificaciones disponibles para el semestre " + semestre + ".");
        }
    }

    public static void mostrarBoleta(Usuario usuarioActual) {
        String numeroDeControl = obtenerNumeroDeControl();
        Estudiante encontrarEstudiante = GrupoTieneAlumnos.encontrarEstudiantePorNumeroDeControl(usuarioActual, numeroDeControl);
        System.out.println(encontrarEstudiante.toString());
        for (int semestre = 1; semestre <= 3; semestre++) {
            System.out.println("\nCalificaciones para el semestre " + semestre + ":");
            List<Calificaciones> calificacionesPorSemestre = Calificaciones.obtenerCalificacionesPorAlumnoYSemestre(numeroDeControl, semestre);

            if (!calificacionesPorSemestre.isEmpty()) {
                for (Calificaciones calificacion : calificacionesPorSemestre) {
                    int idMateria = Calificaciones.obtenerMateriaDelBloque(calificacion.getIdProfesorTieneMateria());
                    Materias materia = Calificaciones.buscarMateriaPorId(idMateria);
                    if (materia != null) {
                        System.out.println("----------------------------------");
                        System.out.println("\nMateria: " + materia.getNombre() + "\nCalificación: " + calificacion.getCalificacion());

                    }
                }
            } else {
                System.out.println("No hay calificaciones disponibles para el semestre " + semestre + ".");
            }
        }
    }

    private static String obtenerNumeroDeControl() {
        boolean datosCorrectos = true;
        String numeroDeControl = null;
        do {
            System.out.println("Ingresa tu número de control: ");
            numeroDeControl = leer.nextLine();
            if (!GrupoTieneAlumnos.alumnoExiste(numeroDeControl)) {
                System.out.println("El número de control ingresado no existe. Intenta nuevamente.");
            } else {
                datosCorrectos = false;
            }
        } while (datosCorrectos);
        return numeroDeControl;
    }


    public static void verInformacionEstudiante(){
        boolean datosCorrectos = true;
        String numeroDeControl = null;
        do {
            System.out.println("Ingresa tu numero de control: ");
            numeroDeControl = leer.nextLine();
            if (!GrupoTieneAlumnos.alumnoExiste(numeroDeControl)) {
                System.out.println("El número de control ingresado no existe. Intenta nuevamente.");
            } else {
                datosCorrectos = false;
            }
        } while (datosCorrectos);
        Calificaciones.verInformacionAlumno(numeroDeControl);
    }

    public  static void serializar() {
        PasarAJson.Serializers.usuariosISCSerializer.serialize(usuariosISC);
        PasarAJson.Serializers.usuariosIMATSerializer.serialize(usuariosIMAT);
        PasarAJson.Serializers.usuariosELCSerializer.serialize(usuariosELC);
        EstudiantesSerialazer.serialize(listaEstudiantes);
        PasarAJson.Serializers.profesoresSerializer.serialize(listaProfesores);
        PasarAJson.Serializers.coordinadoresSerialazer.serialize(listaCoordinadores);
        PasarAJson.Serializers.materiasSerializer.serialize(listaMaterias);
        PasarAJson.Serializers.grupoSerializer.serialize(grupos);
        PasarAJson.Serializers.semestreSerializer.serialize(semestres);
        PasarAJson.Serializers.grupoTieneAlumnosSerializer.serialize(listaDeAlumnosEnGrupos);
        PasarAJson.Serializers.profesorTieneMateriaSerializer.serialize(listaRelacionProfeYMateria);
        PasarAJson.Serializers.calificacionesSerializer.serialize(todasLasCalificaciones);
    }
    public static void leerJSON() {
        System.out.println("----------------STUDENTS----------");
        PasarAJson.Deserializer.deserializerEstudiante.deserialize();
        System.out.println("----------------MATERIAS----------");
        PasarAJson.Deserializer.deserializerMaterias.deserializeMateria();
        System.out.println("----------------PROFES----------");
        PasarAJson.Deserializer.deserializerProfesores.deserializeProfes();
        System.out.println("----------------CALFICACIONES----------");
        PasarAJson.Deserializer.deserializerCalificaciones.deserializeCalificacion();
        System.out.println("----------------SEMESTRE----------");
        PasarAJson.Deserializer.deserializerSemestre.deserializeCalificacion();
        System.out.println("----------------COORDINADORES----------");
        PasarAJson.Deserializer.deserializarCoordinador.deserializeCoordinar();
        System.out.println("----------------GRUPOS----------");
        PasarAJson.Deserializer.deserializarGrupos.deserializeGrupos();
        System.out.println("----------------GRUPO TIENE ALUMNO----------");
        PasarAJson.Deserializer.deserializerGrupoTieneAlumnos.deserializeGrupoYAlumno();
        System.out.println("----------------PROFE TIENE MATERIA----------");
        PasarAJson.Deserializer.deserializerProfeTieneMaterias.deserializeProfeTieneMateria();
        PasarAJson.Deserializer.deserializarUsuariosISC.deserialize();
        PasarAJson.Deserializer.deserializarUsuariosELC.deserialize();
        PasarAJson.Deserializer.deserialaizerUsuariosIMAT.deserialize();
    }

    public static boolean sonSoloLetras(String cadena) {
        if (cadena == null) {
            return false;
        }
        for (char caracter : cadena.toCharArray()) {
            if (!Character.isLetter(caracter) && caracter != ' ') {
                return false;
            }
        }
        return true;
    }


}
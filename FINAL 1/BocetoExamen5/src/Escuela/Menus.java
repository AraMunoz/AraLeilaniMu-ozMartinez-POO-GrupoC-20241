package Escuela;

import Extras.ProfesorTieneMateria;
import Usuarios.Estudiante;
import Usuarios.Profesor;
import Usuarios.Usuario;
import utilsGlobal.Carrera.Carreras;
import utilsGlobal.UsuarioEnSesion;

import java.util.Scanner;

public class Menus {
public Menus(){

    menuPrincipal();
}
    public static void menuPrincipal() {
        Scanner leer = new Scanner(System.in);
        System.out.println("\n****************************BIENVENIDO AL SISTEMA MINDBOX****************************");
        boolean validarOpcionCarrera = true;
        int opcionCarrera = 0;

        System.out.println("Ingrese el número de la carrera.");
        System.out.println("1. ISC.   \n2. IMAT.    \n3. ILEC.    \n4. Salir.");
        while (validarOpcionCarrera) {
            try {
                opcionCarrera = leer.nextInt();
                if (opcionCarrera < 1 || opcionCarrera > 4) {
                    throw new Exception ("Ingrese un número entre 1 y 4");
                } else{
                    validarOpcionCarrera = false;
                }
            } catch (Exception e) {
                System.out.println("Ingrese la opción en número, de favor.");
                validarOpcionCarrera = true;
                leer.nextLine();
            }
        }

            switch (opcionCarrera) {
                case 1:
                    iniciarSesion(Carreras.ISC);
                    break;
                case 2:
                    iniciarSesion(Carreras.IMAT);
                    break;
                case 3:
                    iniciarSesion(Carreras.ELC);
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
            }

    }

    public  static void iniciarSesion(Carreras carrera){
        boolean datosCorrectos = false;
        Scanner leer = new Scanner (System.in);
        do{
            System.out.print("Ingresa tu numero de control: ");
            String usuario = leer.nextLine();
            System.out.print("Ingresa tu contrasena: ");
            String contrasena = leer.nextLine();

            Usuario usuarioActual = Sistema.verificarInicioSesion(carrera,usuario, contrasena);

            if(usuarioActual!= null){
                datosCorrectos = true;

                UsuarioEnSesion.obtenerInstancia().setUsuarioActual(usuarioActual);

                System.out.println(usuarioActual.getCarrera()+" inicio sesion");
                seleccionarMenu();


            }
            else{
                System.out.println("Datos incorrectos, intentalo de nuevo.");
                leer.nextLine();
            }
        }while(!datosCorrectos);

    }
    public static void seleccionarMenu() {
        Usuario usuario =  UsuarioEnSesion.obtenerInstancia().getUsuarioActual();
        System.out.println(usuario.getCarrera()+" seleccionarMenu");
        switch (usuario.getRol()) {
            case ESTUDIANTE -> menuEstudiante(usuario);
            case PROFESOR -> menuProfesor(usuario);
            case COORDINADOR -> menuCoordinador(usuario);
        }
    }
    public static void menuEstudiante(Usuario usuario){
        Scanner leer = new Scanner (System.in);
        boolean validarOpcionMenuEstudiante = true;
        int opcionMenuEstudiante = 0;

        do {
            validarOpcionMenuEstudiante = true;
            opcionMenuEstudiante = 0;
            System.out.println("\nMENÚ ESTUDIANTE.");
            System.out.println("\n1. Ver mi información.");
            System.out.println("2. Ver calificaciones por semestre.");
            System.out.println("3. Ver boleta.");
            System.out.println("4. Salir.");


            System.out.println("\nIngrese el número de la opción que desea realizar.");


            while (validarOpcionMenuEstudiante){
                try {
                    opcionMenuEstudiante = leer.nextInt();
                    leer.nextLine();

                    if (opcionMenuEstudiante < 1 || opcionMenuEstudiante > 4) {
                        throw new Exception("Ingrese un número entre 1 y 18, por favor.");
                    } else {
                        validarOpcionMenuEstudiante = false;
                    }
                } catch (Exception error){
                    System.out.println("Ingrese una opción válida, por favor.");
                    validarOpcionMenuEstudiante = true;
                    leer.nextLine();
                }
            }

            switch (opcionMenuEstudiante){
                case 1:
                    Sistema.verInformacionEstudiante();
                    leer.nextLine();
                    break;
                case 2:
                    Sistema.verCalificacionesPorAlumnoYSemestre();
                    break;
                case 3:
                    Sistema.mostrarBoleta(usuario);
                    break;
                case 4:
                    System.out.println("Cerrar sesión");
                    UsuarioEnSesion.obtenerInstancia().cerrarSesion();
                    menuPrincipal();
                    break;
            }
        } while (opcionMenuEstudiante != 4);
    }

    public static void menuProfesor(Usuario usuario){
        Scanner leer = new Scanner (System.in);
        boolean validarOpcionMenuProfesor = true;
        int opcionMenuProfesor = 0;

        do {
            validarOpcionMenuProfesor = true;
            opcionMenuProfesor = 0;
            System.out.println("\nMENÚ PROFESOR..");
            System.out.println("\n1. Ver información..");
            System.out.println("2. Asignar calificaciones.");
            System.out.println("3. Salir.");
            System.out.println("\nIngrese el número de la opción que desea realizar.");


            while (validarOpcionMenuProfesor){
                try {
                    opcionMenuProfesor = leer.nextInt();
                    leer.nextLine();

                    if (opcionMenuProfesor < 1 || opcionMenuProfesor > 3) {
                        throw new Exception("Ingrese un número entre 1 y 18, por favor.");
                    } else {
                        validarOpcionMenuProfesor = false;
                    }
                } catch (Exception error){
                    System.out.println("Ingrese una opción válida, por favor.");
                    validarOpcionMenuProfesor = true;
                    leer.nextLine();
                }
            }

            switch (opcionMenuProfesor){
                case 1:
                    Profesor.mostrarInfoProfesor(usuario);
                    break;
                case 2:
                    Calificaciones.asignarCalificacionAAlumno();
                    break;
                case 3:
                    System.out.println("Cerrando sesion...");
                    UsuarioEnSesion.obtenerInstancia().cerrarSesion();
                    menuPrincipal();
                    break;
            }
        } while (opcionMenuProfesor != 3);
    }

    public static void menuCoordinador(Usuario usuario){
        Scanner leer = new Scanner (System.in);
       boolean validarOpcionMenuCoordinador = true;
        int opcionMenuCoordinador = 0;

        do {
            validarOpcionMenuCoordinador = true;
            opcionMenuCoordinador = 0;
            System.out.println("\nMENÚ COORDINADOR.");
            System.out.println("\n1. Registrar estudiante.");
            System.out.println("2. Registrar profesor.");
            System.out.println("3. Registrar Semestre.");
            System.out.println("4. Registrar alumnos en grupo.");
            System.out.println("5. Ver un grupo.");
            System.out.println("6. Dar de alta un grupo.");
            System.out.println("7. Mostrar alumnos");
            System.out.println("8. Mostrar profesores");
            System.out.println("9. Modificar estudiante.");
            System.out.println("10. Modificar profesor.");
            System.out.println("11. Asignar calificación.");
            System.out.println("12. Avanzar un grupo de semestre.");
            System.out.println("13. Asignar materias.");
            System.out.println("14. Ver calificaciones por semestre de un estudiante en particular."); //Materias, nombre de profesores y calificaciones por semestre.
            System.out.println("15. Ver boleta de calificaciones de un estudiante en particular."); //Materias, calificaciones y promedios por materia y semestre.
            System.out.println("16. Ver materia."); //Materia y profesor.
            System.out.println("17. Eliminar estudiante");
            System.out.println("18. Eliminar profesor");
            System.out.println("19. Salir.");


            System.out.println("\nIngrese el número de la opción que desea realizar.");


            while (validarOpcionMenuCoordinador){
                try {
                    opcionMenuCoordinador = leer.nextInt();
                    leer.nextLine();

                    if (opcionMenuCoordinador < 1 || opcionMenuCoordinador > 19) {
                        throw new Exception("Ingrese un número entre 1 y 18, por favor.");
                    } else {
                        validarOpcionMenuCoordinador = false;
                    }
                } catch (Exception error){
                    System.out.println("Ingrese una opción válida, por favor.");
                    validarOpcionMenuCoordinador = true;
                    leer.nextLine();
                }
            }

            switch (opcionMenuCoordinador){
                case 1:
                    Estudiante.registrarEstudiante(usuario);
                    leer.nextLine();
                    break;
                case 2:
                    Profesor.registrarProfesor(usuario);
                    break;
                case 3:
                    Sistema.registrarSemestre(usuario);
                    break;
                case 4:
                    Sistema.registrarAlumnosEnGrupo(usuario);
                    break;
                case 5:
                    Sistema.verUnGrupo(usuario);
                    break;
                case 6:
                    Sistema.registrarGrupo(usuario);
                    break;
                case 7:
                    Estudiante.mostrarEstudiantes(usuario);
                    break;
                case 8:
                    Profesor.mostrarProfesor(usuario);
                    break;
                case 9:
                    Estudiante.modificarEstudiante(usuario);
                    break;
                case 10:
                    Profesor.modificarProfesor(usuario);
                    break;
                case 11:
                    Calificaciones.asignarCalificacionAAlumno();
                    break;
                case 12:
                    AvanzarSemestre.avanzarAlumnoDeSemestre(usuario);
                    break;
                case 13:
                    ProfesorTieneMateria.asignarMaterias(usuario);
                    break;
                case 14:
                    Sistema.verInformacionEstudiante();
                    break;
                case 15:
                    Sistema.mostrarBoleta(usuario);
                    break;
                case 16:
                    ProfesorTieneMateria.mostrarProfesorYMateria(usuario);
                    break;
                case 17:
                    Estudiante.eliminarEstudiante(usuario);
                    break;

                case 18:
                    Profesor.eliminarProfesor(usuario);
                    break;
                case 19:
                    System.out.println("Cerrando sesion...");
                    UsuarioEnSesion.obtenerInstancia().cerrarSesion();
                    menuPrincipal();
                    break;
            }
        } while (opcionMenuCoordinador != 19);
    }
}

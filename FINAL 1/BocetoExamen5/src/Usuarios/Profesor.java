package Usuarios;

import Escuela.Calificaciones;
import Escuela.Materias;
import Escuela.Sistema;
import Extras.GrupoTieneAlumnos;
import utilsGlobal.Carrera.Carreras;

import java.util.ArrayList;
import java.util.Scanner;

import static Escuela.Sistema.leer;
//import static Escuela.Sistema.obtenerNumeroDeControl;

public class Profesor extends Usuario {
    public static int indiceProfesores = 100;
    public ArrayList<Materias> materiasImpartidas = new ArrayList<>();

    public Profesor(String nombre, String apellidoPaterno, String apellidoMaterno, String fechaNacimiento, String CURP, String RFC, double sueldo, String numeroDeControl, String fechaDeRegistro, String estado, String ciudad, String dirección, Rol rol, String contrasena, Carreras carrera, ArrayList<Materias> materiasImpartidas, String sexo) {
        super(nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, CURP, RFC, sueldo, numeroDeControl, fechaDeRegistro, estado, ciudad, dirección, rol, contrasena, carrera, sexo);
        this.materiasImpartidas = materiasImpartidas;

    }

    public ArrayList<Materias> getMateriasImpartidas() {
        return materiasImpartidas;
    }

    public void setMateriasImpartidas(ArrayList<Materias> materiasImpartidas) {
        this.materiasImpartidas = materiasImpartidas;
    }

    //*****************Registro*****************************

    public static void registrarProfesor(Usuario usuarioActual) {
        Scanner leer = new Scanner(System.in);


        System.out.println("\n***Registro de Profesor***");
        ArrayList<String> datosComun = Usuario.registrarUsuario(usuarioActual, Rol.PROFESOR);
        String nombreProfesor = datosComun.get(0);
        String apellidoPaternoProfesor = datosComun.get(1);
        String apellidoMaternoProfesor = datosComun.get(2);
        String fechaDeNacimiento = datosComun.get(3);
        String ciudadProfesor = datosComun.get(4);
        String estadoProfesor = datosComun.get(5);
        String CURPProfesor = datosComun.get(6);
        String direccionProfesor = datosComun.get(7);
        String sexoProfesor = datosComun.get(8);
        String RFCProfesor = Usuario.generateRFC(nombreProfesor, apellidoPaternoProfesor, apellidoMaternoProfesor, fechaDeNacimiento);
        String passwordProfesor = datosComun.get(9);
        String fechaDeRegistro = datosComun.get(10);
        String noDeControlProfesor = datosComun.get(11);
        double salario = 0;
        boolean datoSueldo = true;
        do {
            try {
                System.out.print("Ingrese su salario: ");
                salario = leer.nextDouble();
                datoSueldo = false;
            } catch (Exception e) {
                System.out.println("Ingrese un número.");
                leer.nextLine();
            }
        } while (datoSueldo);

        ArrayList<Materias> materiasImpartidas = new ArrayList<>();

        Profesor newProfesor = new Profesor(nombreProfesor, apellidoPaternoProfesor, apellidoMaternoProfesor, fechaDeNacimiento, CURPProfesor, RFCProfesor,
                salario, noDeControlProfesor, fechaDeRegistro, estadoProfesor, ciudadProfesor, direccionProfesor, Rol.PROFESOR, passwordProfesor,
                usuarioActual.getCarrera(), materiasImpartidas, sexoProfesor);
        Sistema.listaProfesores.add(newProfesor);
        agregarProfesorAHashMap(usuarioActual, newProfesor);
        System.out.println("\nProfesor registtrado con número de control " + newProfesor.getNumeroDeControl());
        Sistema.serializar();
    }

    public static void agregarProfesorAHashMap(Usuario usuarioActual, Profesor newProfesor) {
        switch (usuarioActual.getCarrera()) {
            case ISC:
                Sistema.usuariosISC.get(Rol.PROFESOR).add(newProfesor);
                break;
            case IMAT:
                Sistema.usuariosIMAT.get(Rol.PROFESOR).add(newProfesor);
                break;
            case ELC:
                Sistema.usuariosELC.get(Rol.PROFESOR).add(newProfesor);
                break;

        }

    }

    //****************************Mostrar listas*******************************************
    public static void mostrarProfesor(Usuario usuarioActual) {
        System.out.println("\n**Lista de Profesores**");
        try {
            for (Profesor mostrarProfesor : Sistema.listaProfesores) {
                if (mostrarProfesor.getCarrera().equals(usuarioActual.getCarrera())) {
                    System.out.println(mostrarProfesor.toString());
                }
            }
        } catch (Exception e) {
            System.out.println("\nLista vacía");
        }
    }
    public static Profesor encontrarEstudiantePorNumeroDeControl(Usuario usuarioActual, String numeroDeControl) {

        if(usuarioActual.getCarrera().equals(Carreras.ISC)){
            for (Usuario usuario : Sistema.usuariosISC.get(Rol.PROFESOR)) {
                Profesor profe = (Profesor) usuario;
                if (profe.getNumeroDeControl().equals(numeroDeControl)) {
                    return profe;
                }
            }
        }
        else if (usuarioActual.getCarrera().equals(Carreras.ELC)){
            for (Usuario usuario : Sistema.usuariosELC.get(Rol.PROFESOR)) {
                Profesor profe = (Profesor) usuario;
                if (profe.getNumeroDeControl().equals(numeroDeControl)) {
                    return profe;
                }
            }
        }
        else if(usuarioActual.getCarrera().equals(Carreras.IMAT)){
            for (Usuario usuario : Sistema.usuariosIMAT.get(Rol.PROFESOR)) {
                Profesor profe = (Profesor) usuario;
                if (profe.getNumeroDeControl().equals(numeroDeControl)) {
                    return profe;
                }
            }
        }
        else{
            for (Usuario usuario : Sistema.listaEstudiantes) {
                Profesor profe = (Profesor) usuario;
                if (profe.getNumeroDeControl().equals(numeroDeControl)) {
                    return profe;
                }
            }
        }

        return null;
    }

    //********************Modificar datos************************************
    public static void modificarProfesor(Usuario usuario) {
        Scanner leer = new Scanner(System.in);
        System.out.println("\n***Modificación de Profesor***");
        System.out.println("Ingrese el número de control del profesor a modificar: ");
        String numeroDeControl = leer.nextLine();

        boolean encontrado = false;

        if (usuario.getCarrera().equals(Carreras.ISC)) {
            encontrado = modificarProfesorEnCarrera(Sistema.usuariosISC.get(Rol.PROFESOR), numeroDeControl);
        } else if (usuario.getCarrera().equals(Carreras.IMAT)) {
            encontrado = modificarProfesorEnCarrera(Sistema.usuariosIMAT.get(Rol.PROFESOR), numeroDeControl);
        } else if (usuario.getCarrera().equals(Carreras.ELC)) {
            encontrado = modificarProfesorEnCarrera(Sistema.usuariosELC.get(Rol.PROFESOR), numeroDeControl);
        }

        if (!encontrado) {
            System.out.println("Profesor no encontrado.");
        }
    }

    private static boolean modificarProfesorEnCarrera(ArrayList<Usuario> usuarios, String numeroDeControl) {
        boolean encontrado = false;

        for (Usuario usuario : usuarios) {
            if (usuario.getNumeroDeControl().equals(numeroDeControl)) {
                encontrado = true;
                Profesor profesor = (Profesor) usuario;
                modificarDatosProfesor(profesor);
                break;
            }
        }

        return encontrado;
    }

    private static void modificarDatosProfesor(Profesor profesor) {
        Scanner leer = new Scanner(System.in);
        int opcionModificar;

        do {
            System.out.println("¿Qué desea modificar?");
            System.out.println("1. Nombre.");
            System.out.println("2. Apellido paterno.");
            System.out.println("3. Apellido materno.");
            System.out.println("4. Fecha de Nacimiento.");
            System.out.println("5. Ciudad.");
            System.out.println("6. Estado.");
            System.out.println("7. Dirección.");
            System.out.println("8. Contraseña.");
            System.out.println("9. Salir.");

            opcionModificar = leer.nextInt();
            leer.nextLine();

            switch (opcionModificar) {
                case 1:
                    String newName;
                    do {
                        System.out.println("Ingresa el nuevo Nombre: ");
                        newName = leer.nextLine();
                        profesor.setNombre(newName);
                        Usuario.generarCurp(newName, profesor.getApellidoPaterno(), profesor.getApellidoMaterno(), profesor.getFechaNacimiento(), profesor.getSexo(), profesor.getEstado());
                        Usuario.generarNumeroDeControl(newName, profesor.getFechaNacimiento(), profesor.getCarrera(), profesor.getRol());
                        Sistema.serializar();

                        if (!Sistema.sonSoloLetras(newName)) {
                            System.out.println("Ingresa solo letras");
                        }
                    } while (!Sistema.sonSoloLetras(newName));

                    break;

                case 2:
                    String newApellidoPaterno;
                    do {
                        System.out.println("Ingresa el nuevo apellido paterno: ");
                        newApellidoPaterno = leer.nextLine();
                        profesor.setApellidoPaterno(newApellidoPaterno);
                        Usuario.generarCurp(profesor.getNombre(), newApellidoPaterno, profesor.getApellidoMaterno(), profesor.getFechaNacimiento(), profesor.getSexo(), profesor.getEstado());
                        Sistema.serializar();

                        if (!Sistema.sonSoloLetras(newApellidoPaterno)) {
                            System.out.println("Ingresa solo letras");
                        }
                    } while (!Sistema.sonSoloLetras(newApellidoPaterno));

                    break;

                case 3:
                    String newAppelidoMaterno;
                    do {
                        System.out.println("Ingresa el nuevo apellido materno: ");
                        newAppelidoMaterno = leer.nextLine();
                        profesor.setApellidoMaterno(newAppelidoMaterno);
                        Usuario.generarCurp(profesor.getNombre(), profesor.getApellidoPaterno(), newAppelidoMaterno, profesor.getFechaNacimiento(), profesor.getSexo(), profesor.getEstado());
                        Sistema.serializar();

                        if (!Sistema.sonSoloLetras(newAppelidoMaterno)) {
                            System.out.println("Ingresa solo letras");
                        }
                    } while (!Sistema.sonSoloLetras(newAppelidoMaterno));

                    break;

                case 4:
                    int newYear = 0;
                    boolean yearValido = true;

                    do {
                        System.out.print("Ingrese el nuevo año de nacimiento: ");
                        try {
                            newYear = leer.nextInt();
                            Sistema.serializar();
                            yearValido = false;
                        } catch (Exception e) {
                            System.out.println("Ingrese solo números");
                            leer.nextLine();
                        }
                    } while (yearValido);


                    int newMes = 0;
                    boolean mesValido = true;

                    do {
                        System.out.print("Ingrese el nuevo mes de nacimiento: ");
                        try {
                            newMes = leer.nextInt();
                            Sistema.serializar();
                            mesValido = false;
                        } catch (Exception e) {
                            System.out.println("Ingrese solo números");
                            leer.nextLine();
                        }
                    } while (mesValido);

                    int newDia = 0;
                    boolean diaValido = true;

                    do {
                        System.out.print("Ingrese el nuevo día de nacimiento: ");
                        try {
                            newDia = leer.nextInt();
                            Sistema.serializar();
                            diaValido = false;
                        } catch (Exception e) {
                            System.out.println("Ingrese solo números");
                            leer.nextLine();
                        }
                    } while (diaValido);

                    String newFecha = String.valueOf(newYear) + "/" + String.valueOf(newMes) + "/" + String.valueOf(newDia);
                    Usuario.generarCurp(profesor.getNombre(), profesor.getApellidoPaterno(), profesor.getApellidoPaterno(), newFecha, profesor.getSexo(), profesor.getEstado());
                    Usuario.generarNumeroDeControl(profesor.getNombre(), newFecha, profesor.getCarrera(), profesor.getRol());
                    profesor.setFechaNacimiento(newFecha);
                    Sistema.serializar();
                    break;

                case 5:
                    String newCiudad;
                    do {
                        System.out.println("Ingresa la nueva ciudad: ");
                        newCiudad = leer.nextLine();
                        profesor.setCiudad(newCiudad);
                        Sistema.serializar();

                        if (!Sistema.sonSoloLetras(newCiudad)) {
                            System.out.println("Ingresa solo letras");
                        }
                    } while (!Sistema.sonSoloLetras(newCiudad));
                    break;

                case 6:
                    String newEstado;
                    do {
                        System.out.println("Ingresa el nuevo estado: ");
                        newEstado = leer.nextLine();
                        profesor.setEstado(newEstado);
                        Usuario.generarCurp(profesor.getNombre(), profesor.getApellidoPaterno(), profesor.getApellidoMaterno(), profesor.getFechaNacimiento(), profesor.getSexo(), newEstado);
                        Sistema.serializar();

                        if (!Sistema.sonSoloLetras(newEstado)) {
                            System.out.println("Ingresa solo letras");
                        }
                    } while (!Sistema.sonSoloLetras(newEstado));
                    break;

                case 7:
                    String newDireccion;
                    do {
                        System.out.println("Ingresa la nueva dirección: ");
                        newDireccion = leer.nextLine();
                        profesor.setDireccion(newDireccion);
                        Sistema.serializar();

                        if (!Sistema.sonSoloLetras(newDireccion)) {
                            System.out.println("Ingresa solo letras");
                        }
                    } while (!Sistema.sonSoloLetras(newDireccion));
                    break;

                case 8:
                    System.out.println("Ingresa la contraseña: ");
                    String newContra = leer.nextLine();
                    profesor.setContrasena(newContra);
                    Sistema.serializar();
                    break;

                case 9:
                    System.out.println("Salir");
                    return;

                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (opcionModificar != 9);
    }

    public static void mostrarInfoProfesor(Usuario usuario) {
        Scanner leer = new Scanner(System.in);
        System.out.println("\n***Mostrar Información del Profesor***");
        System.out.println("Ingrese el número de control del profesor: ");
        String numeroDeControl = leer.nextLine();

        boolean encontrado = false;

        if (usuario.getCarrera().equals(Carreras.ISC)) {
            encontrado = mostrarProfesorEnCarrera(Sistema.usuariosISC.get(Rol.PROFESOR), numeroDeControl);
        } else if (usuario.getCarrera().equals(Carreras.IMAT)) {
            encontrado = mostrarProfesorEnCarrera(Sistema.usuariosIMAT.get(Rol.PROFESOR), numeroDeControl);
        } else if (usuario.getCarrera().equals(Carreras.ELC)) {
            encontrado = mostrarProfesorEnCarrera(Sistema.usuariosELC.get(Rol.PROFESOR), numeroDeControl);
        }

        if (!encontrado) {
            System.out.println("Profesor no encontrado.");
        }
    }

    private static boolean mostrarProfesorEnCarrera(ArrayList<Usuario> usuarios, String numeroDeControl) {
        boolean encontrado = false;

        for (Usuario usuario : usuarios) {
            if (usuario.getNumeroDeControl().equals(numeroDeControl)) {
                encontrado = true;
                Profesor profesor = (Profesor) usuario;
                imprimirInformacionProfesor(profesor);
                break;
            }
        }

        return encontrado;
    }

    private static void imprimirInformacionProfesor(Profesor profesor) {
        System.out.println("\nInformación del Profesor:");
        System.out.println("Nombre: " + profesor.getNombre());
        System.out.println("Apellido Paterno: " + profesor.getApellidoPaterno());
        System.out.println("Apellido Materno: " + profesor.getApellidoMaterno());
        System.out.println("Fecha de Nacimiento: " + profesor.getFechaNacimiento());
        System.out.println("CURP: " + profesor.getCURP());
        System.out.println("RFC: " + profesor.getRFC());
        System.out.println("Sueldo: " + profesor.getSueldo());
        System.out.println("Número de Control: " + profesor.getNumeroDeControl());
        System.out.println("Fecha de Registro: " + profesor.getFechaDeRegistro());
        System.out.println("Estado: " + profesor.getEstado());
        System.out.println("Ciudad: " + profesor.getCiudad());
        System.out.println("Dirección: " + profesor.getDireccion());
        System.out.println("Carrera: " + profesor.getCarrera());
        System.out.println("Sexo: " + profesor.getSexo());
    }

    public static void eliminarProfesor(Usuario usuarioActual) {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese el número de control del profesor: ");
        String numeroBorrar = leer.nextLine();
        for (Profesor eliminarProfe : Sistema.listaProfesores) {
            if (eliminarProfe.getNumeroDeControl().equals(numeroBorrar)) {
                Sistema.listaProfesores.remove(eliminarProfe);
                Sistema.serializar();
            }
        }
        Profesor eliminarProfeDos = encontrarEstudiantePorNumeroDeControl(usuarioActual, numeroBorrar);
            eliminarProfesorAHashMap(eliminarProfeDos);
    }
    public static void eliminarProfesorAHashMap(Profesor profesor) {
        switch (profesor.getCarrera()) {
            case ISC:
                Sistema.usuariosISC.remove(Rol.PROFESOR, profesor);
                Sistema.serializar();
                break;
            case IMAT:
                Sistema.usuariosIMAT.remove(Rol.PROFESOR, profesor);
                Sistema.serializar();
                break;
            case ELC:
                Sistema.usuariosELC.remove(Rol.PROFESOR, profesor);
                Sistema.serializar();
                break;
        }

    }
}
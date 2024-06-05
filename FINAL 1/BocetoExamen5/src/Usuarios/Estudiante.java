package Usuarios;

import Escuela.Materias;
import Escuela.Sistema;
import Extras.GrupoTieneAlumnos;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import utilsGlobal.Carrera.Carreras;

import java.util.ArrayList;
import java.util.Scanner;

public class Estudiante extends Usuario {
    public static int indiceEstudiantes = 0;
    @Expose
    private int semestre;
    @Expose
    private double promedio;
    @Expose
    private ArrayList<Materias> misMaterias;
    @Expose
    private boolean esAprobado;
    @Expose
    private boolean estaEnGrupo;
    Scanner leer = new Scanner(System.in);
    private boolean Graduado;

    public Estudiante(String nombre, String apellidoPaterno, String apellidoMaterno, String fechaNacimiento, String CURP, String numeroDeControl,
                      String fechaDeRegistro, String estado, String ciudad, String dirección, String contrasena, Carreras carrera, boolean esAprobado, String sexo) {
        super(nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, CURP, numeroDeControl, estado, ciudad, dirección, Rol.ESTUDIANTE, contrasena, carrera, sexo);
        this.promedio = 0;
        this.semestre = 0;
        misMaterias = new ArrayList<Materias>();
        this.esAprobado = esAprobado;
        this.estaEnGrupo = false;
        indiceEstudiantes++;
    }

    //////////////////////////////////Registrar estudiantes/////////////////////////////////////
    public static void registrarEstudiante(Usuario usuarioActual) {
        Scanner leer = new Scanner(System.in);

        System.out.println("\n***Registro de Estudiante***");
        ArrayList<String> datosComun = Usuario.registrarUsuario(usuarioActual, Rol.ESTUDIANTE);
        String nombreEstudiante = datosComun.get(0);
        String apellidoPaternoEstudiante = datosComun.get(1);
        String apellidoMaternoEstudiante = datosComun.get(2);
        String fechaDeNacimiento = datosComun.get(3);
        String ciudadEstudiante = datosComun.get(4);
        String estadoEstudiante = datosComun.get(5);
        String CURPEstudiante = datosComun.get(6);
        String direccionEstudiante = datosComun.get(7);
        String sexoEstudiante = datosComun.get(8);
        String passwordEstudiante = datosComun.get(9);
        String fechaRegistro = datosComun.get(10);
        String noDeControlEstudiante = datosComun.get(11);

        boolean esAprobado = false;
        Estudiante newEstudiante = new Estudiante(nombreEstudiante, apellidoPaternoEstudiante, apellidoMaternoEstudiante, fechaDeNacimiento, CURPEstudiante, noDeControlEstudiante, fechaRegistro,
                estadoEstudiante, ciudadEstudiante, direccionEstudiante, passwordEstudiante, usuarioActual.getCarrera(), esAprobado, sexoEstudiante);
        Sistema.listaEstudiantes.add(newEstudiante);
        agregarEstudianteAHashMap(usuarioActual, newEstudiante);

        validarRegistroDeEstudiante(usuarioActual, newEstudiante);
        Sistema.serializar();
    }

    public static void agregarEstudianteAHashMap(Usuario usuarioActual, Estudiante newEstudiante) {
        switch (usuarioActual.getCarrera()) {
            case ISC:
                Sistema.usuariosISC.get(Rol.ESTUDIANTE).add(newEstudiante);
                break;
            case IMAT:
                Sistema.usuariosIMAT.get(Rol.ESTUDIANTE).add(newEstudiante);
                break;
            case ELC:
                Sistema.usuariosELC.get(Rol.ESTUDIANTE).add(newEstudiante);
                break;

        }

    }

    public static void validarRegistroDeEstudiante(Usuario usuarioActual, Estudiante newEstudiante) {
        Scanner leer = new Scanner(System.in);
        if (usuarioActual.getCarrera().equals(Carreras.ISC)) {
            Sistema.usuariosISC.get(Rol.ESTUDIANTE).add(newEstudiante);
            System.out.println("El estudiante fue registrado de manera correcta, su numero de control es: " + newEstudiante.getNumeroDeControl());
        } else if (usuarioActual.getCarrera().equals(Carreras.ELC)) {
            Sistema.usuariosELC.get(Rol.ESTUDIANTE).add(newEstudiante);
            System.out.println("El estudiante fue registrado de manera correcta");
        } else if (usuarioActual.getCarrera().equals(Carreras.IMAT)) {
            Sistema.usuariosIMAT.get(Rol.ESTUDIANTE).add(newEstudiante);
            System.out.println("El estudiante fue registrado de manera correcta");
            leer.nextLine();
        }
    }

    //////////////////////////////////Mostrar estudiantes//////////////////////////////////////////
    public static void mostrarEstudiantes(Usuario usuarioActual) {
        System.out.println("\n**Lista de Estudiantes**");
        try {
            for (Estudiante mostrarEstudiante : Sistema.listaEstudiantes) {
                if (mostrarEstudiante.getCarrera().equals(usuarioActual.getCarrera())) {
                    System.out.println(mostrarEstudiante.toString());
                }
            }
        } catch (Exception e) {
            System.out.println("\nLista vacía");
        }
    }

    //********************Modificar datos************************************
    public static void modificarEstudiante(Usuario usuario) {
        Scanner leer = new Scanner(System.in);
        System.out.println("\n***Modificación de Estudiante***");
        System.out.println("Ingrese el número de control del estudiante a modificar: ");
        String numeroDeControl = leer.nextLine();

        boolean encontrado = false;

        if (usuario.getCarrera().equals(Carreras.ISC)) {
            encontrado = modificarEstudianteEnCarrera(Sistema.usuariosISC.get(Rol.ESTUDIANTE), numeroDeControl);
        } else if (usuario.getCarrera().equals(Carreras.IMAT)) {
            encontrado = modificarEstudianteEnCarrera(Sistema.usuariosIMAT.get(Rol.ESTUDIANTE), numeroDeControl);
        } else if (usuario.getCarrera().equals(Carreras.ELC)) {
            encontrado = modificarEstudianteEnCarrera(Sistema.usuariosELC.get(Rol.ESTUDIANTE), numeroDeControl);
        }

        if (!encontrado) {
            System.out.println("Estudiante no encontrado.");
        }
    }

    private static boolean modificarEstudianteEnCarrera(ArrayList<Usuario> usuarios, String numeroDeControl) {
        boolean encontrado = false;

        for (Usuario usuario : usuarios) {
            if (usuario.getNumeroDeControl().equals(numeroDeControl)) {
                encontrado = true;
                Estudiante estudiante = (Estudiante) usuario;
                modificarDatosEstudiante(estudiante);
                break;
            }
        }

        return encontrado;
    }

    private static void modificarDatosEstudiante(Estudiante estudiante) {
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
                        estudiante.setNombre(newName);
                        Usuario.generarCurp(newName, estudiante.getApellidoPaterno(), estudiante.getApellidoMaterno(), estudiante.getFechaNacimiento(), estudiante.getSexo(), estudiante.getEstado());
                        Usuario.generarNumeroDeControl(newName, estudiante.getFechaNacimiento(), estudiante.getCarrera(), estudiante.getRol());
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
                        estudiante.setApellidoPaterno(newApellidoPaterno);
                        Usuario.generarCurp(estudiante.getNombre(), newApellidoPaterno, estudiante.getApellidoMaterno(), estudiante.getFechaNacimiento(), estudiante.getSexo(), estudiante.getEstado());
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
                        estudiante.setApellidoMaterno(newAppelidoMaterno);
                        Usuario.generarCurp(estudiante.getNombre(), estudiante.getApellidoPaterno(), newAppelidoMaterno, estudiante.getFechaNacimiento(), estudiante.getSexo(), estudiante.getEstado());
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
                    Usuario.generarCurp(estudiante.getNombre(), estudiante.getApellidoPaterno(), estudiante.getApellidoPaterno(), newFecha, estudiante.getSexo(), estudiante.getEstado());
                    Usuario.generarNumeroDeControl(estudiante.getNombre(), newFecha, estudiante.getCarrera(), estudiante.getRol());
                    estudiante.setFechaNacimiento(newFecha);
                    Sistema.serializar();
                    break;

                case 5:
                    String newCiudad;
                    do {
                        System.out.println("Ingresa la nueva ciudad: ");
                        newCiudad = leer.nextLine();
                        estudiante.setCiudad(newCiudad);
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
                        estudiante.setEstado(newEstado);
                        Usuario.generarCurp(estudiante.getNombre(), estudiante.getApellidoPaterno(), estudiante.getApellidoMaterno(), estudiante.getFechaNacimiento(), estudiante.getSexo(), newEstado);
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
                        estudiante.setDireccion(newDireccion);
                        Sistema.serializar();

                        if (!Sistema.sonSoloLetras(newDireccion)) {
                            System.out.println("Ingresa solo letras");
                        }
                    } while (!Sistema.sonSoloLetras(newDireccion));
                    break;

                case 8:
                    System.out.println("Ingresa la contraseña: ");
                    String newContra = leer.nextLine();
                    estudiante.setContrasena(newContra);
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

    public static void eliminarEstudiante(Usuario usuarioActual) {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese el número de control del estudiante: ");
        String numeroBorrar = leer.nextLine();
        /*for (Estudiante eliminarEstudiante : Sistema.listaEstudiantes) {
            if (eliminarEstudiante.getNumeroDeControl().equals(numeroBorrar)) {
                Sistema.listaEstudiantes.remove(eliminarEstudiante);

            }
        }*/
        Estudiante eliminarEstudianteDos = GrupoTieneAlumnos.encontrarEstudiantePorNumeroDeControl(usuarioActual, numeroBorrar);
        Sistema.listaEstudiantes.remove(eliminarEstudianteDos);
        eliminarEstudianteAHashMap(eliminarEstudianteDos);
        Sistema.serializar();
    }

    public static void eliminarEstudianteAHashMap(Estudiante estudiante) {
        switch (estudiante.getCarrera()) {
            case ISC:
                Sistema.usuariosISC.remove(Rol.PROFESOR, estudiante);
                break;
            case IMAT:
                Sistema.usuariosIMAT.remove(Rol.PROFESOR, estudiante);
                break;
            case ELC:
                Sistema.usuariosELC.remove(Rol.PROFESOR, estudiante);
                break;

        }

    }

    public void setEstaEnGrupo(boolean estaEnGrupo) {
        this.estaEnGrupo = estaEnGrupo;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public double getPromedio() {
        return promedio;
    }

    public boolean isEsAprobado() {
        return esAprobado;
    }

    public boolean isGraduado() {
        return Graduado;
    }

    public void setGraduado(boolean graduado) {
        Graduado = graduado;
    }

    public boolean isEstaEnGrupo() {
        return estaEnGrupo;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public ArrayList<Materias> getMisMaterias() {
        return misMaterias;
    }

    public void setMisMaterias(ArrayList<Materias> misMaterias) {
        this.misMaterias = misMaterias;
    }

    @Override
    public String toString() {
        return String.format(" %s  \nSemestre: %d   ", super.toString(), getSemestre());
    }

    public boolean getEsAprobado() {
        return esAprobado;
    }

    public void setEsAprobado(boolean esAprobado) {
        this.esAprobado = esAprobado;
    }
}

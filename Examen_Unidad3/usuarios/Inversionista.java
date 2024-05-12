
package examen_unidad3_herencia.usuarios;

import examen_unidad3_herencia.Banco;
import examen_unidad3_herencia.Menu;
import examen_unidad3_herencia.utils.Inversion;
import examen_unidad3_herencia.utils.Rol;
import examen_unidad3_herencia.utils.Sucursal;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Inversionista extends Usuario {

    private double fondoInversion;
    private static String llaveSeguridad = null;
    List<Inversion> inversionesPropias;

    public Inversionista(String nombre, String apellidoPaterno, String apellidoMaterno, String fechaDeNacimiento, String ciudad, String estado, String curp, String direccion, String RFC, double salario, Rol rol, Sucursal sucursal, String sexo, String userName, String password, double fondoInversion, String llaveSeguridad) {
        super(nombre, apellidoMaterno, apellidoPaterno, fechaDeNacimiento, ciudad, estado, curp, direccion, RFC, salario, rol, sucursal, sexo, userName, password);
        this.fondoInversion = fondoInversion;
        this.llaveSeguridad = llaveSeguridad;
        this.inversionesPropias = new ArrayList<>();
    }

    public String getLlaveSeguridad() {
        return llaveSeguridad;
    }

    public void setLlaveSeguridad(String llaveSeguridad) {
        this.llaveSeguridad = llaveSeguridad;
    }

    public double getFondoInversion() {
        return fondoInversion;
    }

    public void setFondoInversion(double fondoInversion) {
        this.fondoInversion = fondoInversion;
    }

    public List<Inversion> getInversionesPropias() {
        return inversionesPropias;
    }

    public void setInversionesPropias(List<Inversion> inversionesPropias) {
        this.inversionesPropias = inversionesPropias;
    }

    //**********************************Registro*******************************************
    public static void registarInversionista(Usuario usuarioActual) {
        Scanner leer = new Scanner(System.in);

        System.out.println("\n***Registro de inversionista***");
        ArrayList<String> datosComun = Usuario.registerUser(Rol.INVERSIONISTA);
        String nameInversionista = datosComun.get(0);
        String fatherLastNameInversionista = datosComun.get(1);
        String motherLastNameInversionista = datosComun.get(2);
        String fechaDeNacimiento = datosComun.get(3);
        String cityInversionista = datosComun.get(4);
        String estadoIinversionista = datosComun.get(5);
        String CURPInversionista = datosComun.get(6);
        String direccionInversionista = datosComun.get(7);
        String sexoInversionista = datosComun.get(8);
        String usuarioCInversionista = datosComun.get(9);
        String passwordIinversionista = datosComun.get(10);
        String RFCInversionista = Usuario.generateRFC(nameInversionista, fatherLastNameInversionista, motherLastNameInversionista, fechaDeNacimiento);

        System.out.print("Salario: ");
        Double salary = leer.nextDouble();

        System.out.print("Ingrese el fondo de inversión: ");
        double fondo = leer.nextDouble();

        if (RFCInversionista != null) {
            RFCList.add(RFCInversionista);
            Usuario.validarRFC(RFCInversionista);
            Inversionista newInversionista = new Inversionista(nameInversionista, fatherLastNameInversionista, motherLastNameInversionista,
                    fechaDeNacimiento, cityInversionista, estadoIinversionista, CURPInversionista, direccionInversionista, RFCInversionista, salary, Rol.INVERSIONISTA, usuarioActual.getSucursal(), sexoInversionista, usuarioCInversionista, passwordIinversionista, fondo, null);

            if (usuarioActual.getSucursal().equals(Sucursal.MADERO)) {
                if (!Banco.usuariosMadero.containsKey(Rol.INVERSIONISTA)) {
                    Banco.usuariosMadero.put(Rol.INVERSIONISTA, new ArrayList<Usuario>());
                }
                Banco.usuariosMadero.get(Rol.INVERSIONISTA).add(newInversionista);
                System.out.println("Inversionista registrado con éxito. Su rfc es:" + RFCInversionista.toUpperCase() + " su CURP es: " + CURPInversionista);

            } else {
                if (!Banco.usuariosAcueducto.containsKey(Rol.INVERSIONISTA)) {
                    Banco.usuariosAcueducto.put(Rol.INVERSIONISTA, new ArrayList<Usuario>());
                }
                Banco.usuariosAcueducto.get(Rol.INVERSIONISTA).add(newInversionista);
                System.out.println("Inversionista registrado con éxito. Su rfc es:" + RFCInversionista + " su CURP es: " + CURPInversionista);

            }
        } else {
            System.out.println("Inténtelo de nuevo.");
        }

    }

    //*******************Info********************************************************
    @Override
    public String toString() {
        return String.format("%s \nSalario: %.4f \nFondo de inversion: %.4f \nLlave de seguridad: %s \nFecha de registro: %s", super.toString(), salario, fondoInversion, llaveSeguridad, super.fechaRegistro);
    }

    //*************************Mostrar listas**********************************
    public static void mostrarInversionista(Usuario usuarioActual) {
        System.out.println("\n**Lista de Inversionistas**");
        try {
            if (usuarioActual.getSucursal().equals(Sucursal.MADERO)) {
                for (Usuario usuario : Banco.usuariosMadero.get(Rol.INVERSIONISTA)) {
                    if (usuario.getRol() == Rol.INVERSIONISTA) {
                        Inversionista newInversionista = (Inversionista) usuario;
                        System.out.println(newInversionista.toString());
                    }
                }
            }
            if (usuarioActual.getSucursal().equals(Sucursal.ACUEDUCTO)) {
                for (Usuario usuario : Banco.usuariosAcueducto.get(Rol.INVERSIONISTA)) {
                    if (usuario.getRol() == Rol.INVERSIONISTA) {
                        Inversionista newInversionista = (Inversionista) usuario;
                        System.out.println(newInversionista.toString());
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("\nLa lista está vacía");
        }
    }

    public static void modificarInversionista(Usuario usuario) {
        Scanner leer = new Scanner(System.in);
        System.out.println("\n***Modificación de inversionista***");
        System.out.println("\nIngrese el RFC del inversionista a modificar: ");
        String modificarRFC = leer.nextLine();

        boolean encontrado = false;

        if (usuario.getSucursal().equals(Sucursal.MADERO)) {
            encontrado = modificarInversionistaEnSucursal(Banco.usuariosMadero.get(Rol.INVERSIONISTA), modificarRFC);
        } else if (usuario.getSucursal().equals(Sucursal.ACUEDUCTO)) {
            encontrado = modificarInversionistaEnSucursal(Banco.usuariosAcueducto.get(Rol.INVERSIONISTA), modificarRFC);
        }

        if (!encontrado) {
            System.out.println("Inversionista no encontrado.");
            if (usuario.getSucursal().equals(Sucursal.MADERO)) {
                Menu.menuGerente(Sucursal.MADERO);
            } else if (usuario.getSucursal().equals(Sucursal.ACUEDUCTO)) {
                Menu.menuGerente(Sucursal.ACUEDUCTO);
            }
        }
    }

    private static boolean modificarInversionistaEnSucursal(ArrayList<Usuario> usuarios, String modificarRFC) {
        boolean encontrado = false;

        for (Usuario usuario : usuarios) {
            if (usuario.getRFC().equals(modificarRFC)) {
                encontrado = true;
                Inversionista inversionista = (Inversionista) usuario;
                modificarDatos(inversionista, modificarRFC);
                break;
            }
        }

        return encontrado;
    }

    private static void modificarDatos(Inversionista inversionista, String modificarRFC) {
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
            System.out.println("7. Domicilio.");
            System.out.println("8. Salario.");
            System.out.println("9. Usuario.");
            System.out.println("10. Contraseña.");
            System.out.println("11. Fondo de inversión.");
            System.out.println("12. Salir.");

            opcionModificar = leer.nextInt();
            leer.nextLine();
            switch (opcionModificar) {
                case 1:
                    System.out.print("Ingrese el nuevo nombre: ");
                    String newName = leer.nextLine().toUpperCase();
                    inversionista.setNombre(newName);
                    inversionista.setRFC(Usuario.generateRFC(newName, inversionista.getApellidoPaterno(), inversionista.getApellidoMaterno(), inversionista.getFechaDeNacimiento()));
                    inversionista.setCurp(Usuario.generarCurp(newName, inversionista.getApellidoPaterno(), inversionista.getApellidoMaterno(), inversionista.getFechaDeNacimiento(), inversionista.getEstado(), inversionista.getSexo()));
                    break;

                case 2:
                    System.out.print("Ingrese el nuevo apellido Paterno: ");
                    String newFatherLastName = leer.nextLine().toUpperCase();
                    inversionista.setApellidoPaterno(newFatherLastName);
                    inversionista.setRFC(Usuario.generateRFC(inversionista.getNombre(), newFatherLastName, inversionista.getApellidoMaterno(), inversionista.getFechaDeNacimiento()));
                    inversionista.setCurp(Usuario.generarCurp(inversionista.getNombre(), newFatherLastName, inversionista.getApellidoMaterno(), inversionista.getFechaDeNacimiento(), inversionista.getEstado(), inversionista.getSexo()));
                    break;

                case 3:
                    System.out.println("Ingrese el nuevo apellido Materno");
                    String newMotherLastName = leer.nextLine().toUpperCase();
                    inversionista.setApellidoMaterno(newMotherLastName);
                    inversionista.setRFC(Usuario.generateRFC(inversionista.getNombre(), inversionista.getApellidoPaterno(), newMotherLastName, inversionista.getFechaDeNacimiento()));
                    inversionista.setCurp(Usuario.generarCurp(inversionista.getNombre(), inversionista.getApellidoPaterno(), newMotherLastName, inversionista.getFechaDeNacimiento(), inversionista.getEstado(), inversionista.getSexo()));
                    break;

                case 4:
                    System.out.println("Ingrese la nueva Fecha de Nacimiento: ");
                    String newFechaDeNacimiento = leer.nextLine().toUpperCase();
                    inversionista.setFechaDeNacimiento(newFechaDeNacimiento);
                    inversionista.setRFC(Usuario.generateRFC(inversionista.getNombre(), inversionista.getApellidoPaterno(), inversionista.getApellidoMaterno(), newFechaDeNacimiento));
                    inversionista.setCurp(Usuario.generarCurp(inversionista.getNombre(), inversionista.getApellidoPaterno(), inversionista.getApellidoMaterno(), newFechaDeNacimiento, inversionista.getEstado(), inversionista.getSexo()));
                    break;

                case 5:
                    System.out.println("Ingrese la ciudad: ");
                    String newCity = leer.nextLine().toUpperCase();
                    inversionista.setCiudad(newCity);
                    break;

                case 6:
                    System.out.println("Ingrese el estado: ");
                    String newEstado = leer.nextLine().toUpperCase();
                    inversionista.setEstado(newEstado);
                    inversionista.setCurp(Usuario.generarCurp(inversionista.getNombre(), inversionista.getApellidoPaterno(), inversionista.getApellidoMaterno(), inversionista.getFechaDeNacimiento(), newEstado, inversionista.getSexo()));
                    break;

                case 7:
                    System.out.println("Ingrese el domicilio: ");
                    String newDomicilio = leer.nextLine().toUpperCase();
                    inversionista.setDireccion(newDomicilio);
                    break;

                case 8:
                    System.out.println("Ingrese el salario: ");
                    double newSalary = leer.nextDouble();
                    inversionista.setSalario(newSalary);
                    break;

                case 9:
                    System.out.println("Ingrese el nuevo nombre de usuario: ");
                    String newUserName = leer.nextLine();
                    inversionista.setUserName(newUserName);
                    break;

                case 10:
                    System.out.println("Ingrese la nueva contraseña: ");
                    String newPassword = leer.nextLine();
                    inversionista.setPassword(newPassword);
                    break;

                case 11:
                    System.out.println("Ingrese su nuevo fondo de inversión: ");
                    Double newFondo = leer.nextDouble();
                    inversionista.setFondoInversion(newFondo);
                    break;

                case 12:
                    return;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (opcionModificar != 12);
    }

    public static void eliminarInversionista(Usuario usuarioActual) {
        System.out.println("\n***Eliminación de inversionista***");
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese el RFC del inversionista a eliminar:");
        String buscarRFC = leer.nextLine();

        if (usuarioActual.getSucursal().equals(Sucursal.ACUEDUCTO)) {
            ArrayList<Usuario> inversionistasAcueducto = Banco.usuariosAcueducto.get(Rol.INVERSIONISTA);
            for (Usuario inversionista : inversionistasAcueducto) {
                if (inversionista.getRFC().equals(buscarRFC)) {
                    inversionistasAcueducto.remove(inversionista);
                    System.out.println("\nInversionista eliminado");
                    return;
                }
            }
        } else if (usuarioActual.getSucursal().equals(Sucursal.MADERO)) {
            ArrayList<Usuario> inversionistasMadero = Banco.usuariosMadero.get(Rol.INVERSIONISTA);
            for (Usuario inversionista : inversionistasMadero) {
                if (inversionista.getRFC().equals(buscarRFC)) {
                    inversionistasMadero.remove(inversionista);
                    System.out.println("\nInversionista eliminado");
                    return;
                }
            }
        }
        System.out.println("Usuario no encontrado.");
    }

    //*************Inversión****************
    public static void realizarInversion(Usuario usuarioActual) {
        Scanner leer = new Scanner(System.in);
        int opcion = 0;

        if (usuarioActual instanceof Inversionista) {
            Inversionista inversionista = (Inversionista) usuarioActual;

            do {
                System.out.println("\n***Inversión en sucursal***");
                System.out.println("\n\tSucursales");
                System.out.println("1) Sucursal Madero");
                System.out.println("2) Sucursal Acueducto");
                System.out.println("3) Salir");

                System.out.print("\nSeleccione la sucursal en la que desea invertir: ");
                opcion = leer.nextInt();
                leer.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.print("\nDigite la contraseña de seguridad: ");
                        String claveMadero = leer.nextLine();

                        if (claveMadero.equals(inversionista.getLlaveSeguridad())) {
                            System.out.print("Ingrese la cantidad a invertir en la sucursal Madero: ");
                            double cantidadMadero = leer.nextDouble();

                            Inversion inversionAcueducto = new Inversion(inversionista.getNombre(), cantidadMadero);
                            inversionista.agregarInversionPropia(inversionAcueducto);

                            Sucursal.MADERO.realizarInversion(cantidadMadero, inversionista.getNombre(), inversionista);

                            System.out.println("Inversión realizada con éxito en la sucursal Madero.");

                        } else {
                            System.out.println("Clave incorrecta");
                        }
                        break;
                    case 2:
                        System.out.print("\nDigite la contraseña de seguridad: ");
                        String claveAcueducto = leer.nextLine();
                        if (claveAcueducto.equals(inversionista.getLlaveSeguridad())) {
                            System.out.print("Ingrese la cantidad a invertir en la sucursal Acueducto: ");
                            double cantidadAcueducto = leer.nextDouble();

                            leer.nextLine();

                            Inversion inversionAcueducto = new Inversion(inversionista.getNombre(), cantidadAcueducto);
                            inversionista.agregarInversionPropia(inversionAcueducto);
                            Sucursal.ACUEDUCTO.realizarInversion(cantidadAcueducto, inversionista.getNombre(), inversionista);

                            System.out.println("Inversión realizada con éxito en la sucursal Acueducto.");

                        } else {
                            System.out.println("Clave incorrecta");
                        }
                        break;
                    case 3:
                        System.out.println("Saliendo...");
                        return;
                    default:
                        System.out.println("Opción no válida");
                }
            } while (opcion != 3);

        } else {
            System.out.println("Acceso no autorizado. No eres inversionista para realizar esta operación.");
        }

    }

    public void agregarInversionPropia(Inversion inversion) {
        inversionesPropias.add(inversion);
    }

    public static void mostrarInversionesPropias(Usuario usuarioActual) {
        Inversionista inversionista = (Inversionista) usuarioActual;
        System.out.println("Tus inversiones:");
        for (Inversion inversion : inversionista.getInversionesPropias()) {
            System.out.println(inversion.toString());
        }
    }

    public static void mostrarInversiones(Sucursal sucursal) {
        System.out.println("\n***Inversiones realizadas en la sucursal " + sucursal.name() + "***");
        mostrarInversionesSucursal(sucursal);
    }


    private static void mostrarInversionesSucursal(Sucursal sucursal) {
        List<Inversion> inversiones = sucursal.getInversiones();

        if (inversiones.isEmpty()) {
            System.out.println("No se han realizado inversiones en esta sucursal.");
        } else {
            System.out.println("\n***Lista de inversiones***");
            for (Inversion inversion : inversiones) {
                System.out.println("\nFecha: " + inversion.getFecha() + "\nInversionista: " + inversion.getNombreInversionista() + "\nCantidad: " + inversion.getCantidad());
            }
        }
    }

    public static void mostrarDatosPersonales(Usuario usuarioActual) {

        Inversionista inversionista = (Inversionista) usuarioActual;
        System.out.println("\nDatos personales:");
        System.out.println("Nombre: " + inversionista.getNombre());
        System.out.println("Apellido paterno: " + inversionista.getApellidoPaterno());
        System.out.println("Apellido materno: " + inversionista.getApellidoMaterno());
        System.out.println("Fecha de nacimiento: " + inversionista.getFechaDeNacimiento());
        System.out.println("Ciudad: " + inversionista.getCiudad());
        System.out.println("Estado: " + inversionista.getEstado());
        System.out.println("CURP: " + inversionista.getCurp());
        System.out.println("RFC: %s" + inversionista.getRFC());
        System.out.println("Fondo de inversión: " + inversionista.getFondoInversion());
        System.out.println("Salario: " + inversionista.getSalario());
        System.out.println("Usuario: " + inversionista.getUserName());
        System.out.println("Contraseña:" + inversionista.getPassword());
        System.out.println("Llave de seguridad: " + inversionista.getLlaveSeguridad());

    }

}

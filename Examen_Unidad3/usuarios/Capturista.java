
package examen_unidad3_herencia.usuarios;

import examen_unidad3_herencia.Banco;
import examen_unidad3_herencia.Menu;
import examen_unidad3_herencia.utils.Rol;
import examen_unidad3_herencia.utils.Sucursal;

import java.util.ArrayList;
import java.util.Scanner;

public class Capturista extends Usuario {

    public Capturista(String nombre, String apellidoPaterno, String apellidoMaterno, String fechaDeNacimiento, String ciudad, String estado, String curp, String direccion, String RFC, double salario, Rol rol, Sucursal sucursal, String sexo, String userName, String password) {
        super(nombre, apellidoMaterno, apellidoPaterno, fechaDeNacimiento, ciudad, estado, curp, direccion, RFC, salario, rol, sucursal, sexo, userName, password);
    }

    //***********************Registro************************************

    public static void registerCapturista(Usuario usuarioActual) {
        Scanner leer = new Scanner(System.in);

        System.out.println("\n***Registro de capturista***");
        ArrayList<String> datosComun = Usuario.registerUser(Rol.CAPTURISTA);
        String nameCapturista = datosComun.get(0);
        String fatherLastNameCapturista = datosComun.get(1);
        String motherLastNameCapturista = datosComun.get(2);
        String fechaDeNacimiento = datosComun.get(3);
        String cityCapturista = datosComun.get(4);
        String estadoCapturista = datosComun.get(5);
        String CURPCapturista = datosComun.get(6);
        String direccionCapturista = datosComun.get(7);
        String sexoCapturista = datosComun.get(8);
        String RFCCapturista = Usuario.generateRFC(nameCapturista, fatherLastNameCapturista, motherLastNameCapturista, fechaDeNacimiento);
        System.out.print("Salario: ");
        Double salaryCapturista = leer.nextDouble();
        String usuarioCapturista = datosComun.get(9);
        String passwordCapturista = datosComun.get(10);

        if (RFCCapturista != null) {
            RFCList.add(RFCCapturista);
            Usuario.validarRFC(RFCCapturista);
            Capturista newCapturista = new Capturista(nameCapturista, fatherLastNameCapturista, motherLastNameCapturista,
                    fechaDeNacimiento, cityCapturista, estadoCapturista, CURPCapturista, direccionCapturista, RFCCapturista, salaryCapturista, Rol.CAPTURISTA, usuarioActual.getSucursal(), sexoCapturista, usuarioCapturista, passwordCapturista);

            if (usuarioActual.getSucursal().equals(Sucursal.MADERO)) {
                if (!Banco.usuariosMadero.containsKey(Rol.CAPTURISTA)) {
                    Banco.usuariosMadero.put(Rol.CAPTURISTA, new ArrayList<Usuario>());
                }
                Banco.usuariosMadero.get(Rol.CAPTURISTA).add(newCapturista);
                System.out.println("Capturista registrado con éxito. Su rfc es:" + RFCCapturista + " su CURP es: " + CURPCapturista);

            } else {
                if (!Banco.usuariosAcueducto.containsKey(Rol.CAPTURISTA)) {
                    Banco.usuariosAcueducto.put(Rol.CAPTURISTA, new ArrayList<Usuario>());
                }
                Banco.usuariosAcueducto.get(Rol.CAPTURISTA).add(newCapturista);
                System.out.println("Capturista registrado con éxito. Su rfc es:" + RFCCapturista + " su CURP es: " + CURPCapturista);

            }
        } else {
            System.out.println("Inténtelo de nuevo.");
        }
    }



    public static void modificarCapturista(Usuario usuario) {
        Scanner leer = new Scanner(System.in);
        System.out.println("\n***Modificación de capturista***");
        System.out.println("Ingrese el RFC del inversionista a modificar: ");
        String modificarRFC = leer.nextLine();

        boolean encontrado = false;

        if (usuario.getSucursal().equals(Sucursal.MADERO)) {
            encontrado = modificarCapturistaEnSucursal(Banco.usuariosMadero.get(Rol.CAPTURISTA), modificarRFC);
        } else if (usuario.getSucursal().equals(Sucursal.ACUEDUCTO)) {
            encontrado = modificarCapturistaEnSucursal(Banco.usuariosAcueducto.get(Rol.CAPTURISTA), modificarRFC);
        }

        if (!encontrado) {
            System.out.println("Capturista no encontrado.");
            return;

        }
    }

    private static boolean modificarCapturistaEnSucursal(ArrayList<Usuario> usuarios, String modificarRFC) {
        boolean encontrado = false;

        for (Usuario usuario : usuarios) {
            if (usuario.getRFC().equals(modificarRFC)) {
                encontrado = true;
                Capturista capturista = (Capturista) usuario;
                modificarDatos(capturista, modificarRFC);
                break;
            }
        }

        return encontrado;
    }

    private static void modificarDatos(Capturista capturista, String modificarRFC) {
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
            System.out.println("11. Salir.");

            opcionModificar = leer.nextInt();
            leer.nextLine();
            switch (opcionModificar) {
                case 1:
                    System.out.print("Ingrese el nuevo nombre: ");
                    String newName = leer.nextLine().toUpperCase();
                    capturista.setNombre(newName);
                    capturista.setRFC(Usuario.generateRFC(newName, capturista.getApellidoPaterno(), capturista.getApellidoMaterno(), capturista.getFechaDeNacimiento()));
                    capturista.setCurp(Usuario.generarCurp(newName, capturista.getApellidoPaterno(), capturista.getApellidoMaterno(), capturista.getFechaDeNacimiento(), capturista.getEstado(), capturista.getSexo()));
                    break;

                case 2:
                    System.out.print("Ingrese el nuevo apellido Paterno: ");
                    String newFatherLastName = leer.nextLine().toUpperCase();
                    capturista.setApellidoPaterno(newFatherLastName);
                    capturista.setRFC(Usuario.generateRFC(capturista.getNombre(), newFatherLastName, capturista.getApellidoMaterno(), capturista.getFechaDeNacimiento()));
                    capturista.setCurp(Usuario.generarCurp(capturista.getNombre(), newFatherLastName, capturista.getApellidoMaterno(), capturista.getFechaDeNacimiento(), capturista.getEstado(), capturista.getSexo()));
                    break;

                case 3:
                    System.out.println("Ingrese el nuevo apellido Materno");
                    String newMotherLastName = leer.nextLine().toUpperCase();
                    capturista.setApellidoMaterno(newMotherLastName);
                    capturista.setRFC(Usuario.generateRFC(capturista.getNombre(), capturista.getApellidoPaterno(), newMotherLastName, capturista.getFechaDeNacimiento()));
                    capturista.setCurp(Usuario.generarCurp(capturista.getNombre(), capturista.getApellidoPaterno(), newMotherLastName, capturista.getFechaDeNacimiento(), capturista.getEstado(), capturista.getSexo()));
                    break;

                case 4:
                    System.out.println("Ingrese la nueva Fecha de Nacimiento: ");
                    String newFechaDeNacimiento = leer.nextLine().toUpperCase();
                    capturista.setFechaDeNacimiento(newFechaDeNacimiento);
                    capturista.setRFC(Usuario.generateRFC(capturista.getNombre(), capturista.getApellidoPaterno(), capturista.getApellidoMaterno(), newFechaDeNacimiento));
                    capturista.setCurp(Usuario.generarCurp(capturista.getNombre(), capturista.getApellidoPaterno(), capturista.getApellidoMaterno(), newFechaDeNacimiento, capturista.getEstado(), capturista.getSexo()));
                    break;

                case 5:
                    System.out.println("Ingrese la ciudad: ");
                    String newCity = leer.nextLine().toUpperCase();
                    capturista.setCiudad(newCity);
                    break;

                case 6:
                    System.out.println("Ingrese el estado: ");
                    String newEstado = leer.nextLine().toUpperCase();
                    capturista.setEstado(newEstado);
                    capturista.setCurp(Usuario.generarCurp(capturista.getNombre(), capturista.getApellidoPaterno(), capturista.getApellidoMaterno(), capturista.getFechaDeNacimiento(), newEstado, capturista.getSexo()));
                    break;

                case 7:
                    System.out.println("Ingrese el domicilio: ");
                    String newDomicilio = leer.nextLine().toUpperCase();
                    capturista.setDireccion(newDomicilio);
                    break;

                case 8:
                    System.out.println("Ingrese el salario: ");
                    double newSalary = leer.nextDouble();
                    capturista.setSalario(newSalary);
                    break;

                case 9:
                    System.out.println("Ingrese el nuevo nombre de usuario: ");
                    String newUserName = leer.nextLine();
                    capturista.setUserName(newUserName);
                    break;

                case 10:
                    System.out.println("Ingrese la nueva contraseña: ");
                    String newPassword = leer.nextLine();
                    capturista.setPassword(newPassword);
                    break;

                case 11:
                    return;

                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (opcionModificar != 11);
    }

    //***************Mostrar info*******************
    @Override
    public String toString() {
        return String.format("%s \nSalario: %.4f \nFecha de registro: %s", super.toString(), salario, super.fechaRegistro);
    }


    //**********************Eliminación*********************************************

    public static void eliminarCapturista(Usuario usuarioActual) {
        Scanner leer = new Scanner(System.in);
        System.out.println("\n****Eliminación de capturista****");
        System.out.println("\nIngrese el RFC del capturista a eliminar:");
        String buscarRFC = leer.nextLine();

        if (usuarioActual.getSucursal().equals(Sucursal.ACUEDUCTO)) {
            ArrayList<Usuario> capturistaAcueducto = Banco.usuariosAcueducto.get(Rol.CAPTURISTA);
            for (Usuario capturista : capturistaAcueducto) {
                if (capturista.getRFC().equals(buscarRFC)) {
                    capturistaAcueducto.remove(capturista);
                    System.out.println("\nCapturista eliminado");
                    return;
                }
            }
        } else if (usuarioActual.getSucursal().equals(Sucursal.MADERO)) {
            ArrayList<Usuario> capturistaMadero = Banco.usuariosMadero.get(Rol.CAPTURISTA);
            for (Usuario capturista : capturistaMadero) {
                if (capturista.getRFC().equals(buscarRFC)) {
                    capturistaMadero.remove(capturista);
                    System.out.println("\nCapturista eliminado");
                    return;
                }
            }
        }
        System.out.println("Usuario no encontrado.");
    }


    //****************************Mostrar listas*******************************************
    public static void mostrarCapturista(Usuario usuarioActual)
    {
        System.out.println("\n**Lista de Capturistas**");
        try {
            if (usuarioActual.getSucursal().equals(Sucursal.MADERO)) {
                for (Usuario usuario : Banco.usuariosMadero.get(Rol.CAPTURISTA)) {
                    if (usuario.getRol() == Rol.CAPTURISTA) {
                        Capturista capturista = (Capturista) usuario;
                        System.out.println(capturista.toString());
                    }
                }
            }
            if (usuarioActual.getSucursal().equals(Sucursal.ACUEDUCTO)) {
                for (Usuario usuario : Banco.usuariosAcueducto.get(Rol.CAPTURISTA)) {
                    if (usuario.getRol() == Rol.CAPTURISTA) {
                        Capturista capturista = (Capturista) usuario;
                        System.out.println(capturista.toString());
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("\nLista vacía");
        }
    }


}


package examen_unidad3_herencia.usuarios;

import examen_unidad3_herencia.Banco;
import examen_unidad3_herencia.Menu;
import examen_unidad3_herencia.Tarjetas.*;
import examen_unidad3_herencia.utils.Rol;
import examen_unidad3_herencia.utils.Sucursal;

import static examen_unidad3_herencia.Banco.listaSolicitudes;
import static examen_unidad3_herencia.Banco.listaTarjetas;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Cliente extends Usuario {
    private  Debito tarjetaDebito = new Debito();
    ArrayList<Tarjeta> listaTarjetaCredito;
    ArrayList<SolicitudTarjetaCredito> listaSolicitudes;

    public Cliente(String nombre, String apellidoPaterno, String apellidoMaterno, String fechaDeNacimiento, String ciudad, String estado, String curp, String direccion, String RFC, Rol rol, Sucursal sucursal, String sexo, String userName, String password) {
        super(nombre, apellidoMaterno, apellidoPaterno, fechaDeNacimiento, ciudad, estado, curp, direccion, RFC, rol, sucursal, sexo, userName, password);
        this.tarjetaDebito = Debito.crearTarjeta();
        this.listaTarjetaCredito = new ArrayList<>();
        this.listaSolicitudes = new ArrayList<>();
    }

    //**********************Registro****************************
    public static void registerClient(Usuario usuarioActual) {
        System.out.println("\n***Registro de cliente***");
        ArrayList<String> datosComun = Usuario.registerUser(Rol.CLIENTE);
        String nameClient = datosComun.get(0);
        String fatherLastNameClient = datosComun.get(1);
        String motherLastNameClient = datosComun.get(2);
        String fechaDeNacimiento = datosComun.get(3);
        String cityClient = datosComun.get(4);
        String estadoCliente = datosComun.get(5);
        String CURPClient = datosComun.get(6);
        String direccionClient = datosComun.get(7);
        String sexoClient = datosComun.get(8);
        String usuarioClient = datosComun.get(9);
        String passwordClient = datosComun.get(10);
        String RFCClient = Usuario.generateRFC(nameClient, fatherLastNameClient, motherLastNameClient, fechaDeNacimiento);

        if (RFCClient != null) {
            RFCList.add(RFCClient);
            Usuario.validarRFC(RFCClient);
            Cliente newCliente = new Cliente(nameClient, fatherLastNameClient, motherLastNameClient,
                    fechaDeNacimiento, cityClient, estadoCliente, CURPClient, direccionClient, RFCClient, Rol.CLIENTE, usuarioActual.getSucursal(), sexoClient, usuarioClient, passwordClient);

            if (usuarioActual.getSucursal().equals(Sucursal.MADERO)) {
                if (!Banco.usuariosMadero.containsKey(Rol.CLIENTE)) {
                    Banco.usuariosMadero.put(Rol.CLIENTE, new ArrayList<Usuario>());
                }
                Banco.usuariosMadero.get(Rol.CLIENTE).add(newCliente);
                System.out.println("\nCliente registrado con éxito. Su rfc es:" + RFCClient + " su CURP es: " + CURPClient);
                System.out.print("Su tarjeta de debito es: "+ newCliente.verTarjeta());

            } else {
                if (!Banco.usuariosAcueducto.containsKey(Rol.CLIENTE)) {
                    Banco.usuariosAcueducto.put(Rol.CLIENTE, new ArrayList<Usuario>());
                }
                Banco.usuariosAcueducto.get(Rol.CLIENTE).add(newCliente);
                System.out.println("\nCliente registrado con éxito. Su rfc es:" + RFCClient + " su CURP es: " + CURPClient);

            }
        } else {
            System.out.println("\nInténtelo de nuevo.");
        }

    }
    public void verFondosTarjetas() {
        verFondosDebito();
        verTarjetasCredito();
    }
    public String verTarjeta() {
        return (this.tarjetaDebito.toString());

    }
    public void verFondosDebito() {
        System.out.println("\n*** Tarjeta de Débito ***");
        System.out.println("Número de Cuenta: " + tarjetaDebito.getNumeroDeCuenta());
        System.out.println("Saldo Disponible: " + tarjetaDebito.getSaldo());
    }
    public void verTarjetasCredito() {
        System.out.println("\n*** Tarjetas de Crédito ***");
        if (listaTarjetaCredito.isEmpty()) {
            System.out.println("No hay tarjetas de crédito asociadas a este cliente.");
        } else {
            for (Tarjeta tarjeta : listaTarjetaCredito) {
                Credito credito = (Credito) tarjeta;
                System.out.println("Tipo: " + credito.getType());
                System.out.println("Número de Tarjeta: " + credito.getNumeroDeCuenta());
                System.out.println("Saldo Disponible: " + credito.getSaldo());
                System.out.println("-----------------------------------");
            }
        }
    }

    //***************Mostrar info*******************

    public  String toString() {

        return String.format("%s \nFecha de registro: %s \n Tarjeta de debito : %s ", super.toString(), super.fechaRegistro, tarjetaDebito.toString());
    }
    public  void mostrarInfo(){
        System.out.println("**** Su informacion ****");
        System.out.println(toString());
        verTarjetasCredito();
    }



    //****************Mostrar listas**************
    public static void mostrarCliente(Usuario usuarioActual) {
        System.out.println("\n***Lista de clientes***");
        try {
            if (usuarioActual.getSucursal().equals(Sucursal.MADERO)) {
                for (Usuario usuario : Banco.usuariosMadero.get(Rol.CLIENTE)) {
                    if (usuario.getRol() == Rol.CLIENTE) {
                        Cliente cliente = (Cliente) usuario;
                        System.out.println(cliente.toString());
                    }
                }
            }
            if (usuarioActual.getSucursal().equals(Sucursal.ACUEDUCTO)) {
                for (Usuario usuario : Banco.usuariosAcueducto.get(Rol.CLIENTE)) {
                    if (usuario.getRol() == Rol.CLIENTE) {
                        Cliente cliente = (Cliente) usuario;
                        System.out.println(cliente.toString());
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("\nLista vacía");
        }
    }

    public static void modificarCliente(Usuario usuario) {
        Scanner leer = new Scanner(System.in);
        System.out.println("\n***Modificación de cliente***");
        System.out.println("Ingrese el RFC del cliente a modificar: ");
        String modificarRFC = leer.nextLine();

        boolean encontrado = false;

        if (usuario.getSucursal().equals(Sucursal.MADERO)) {
            encontrado = modificarClienteEnSucursal(Banco.usuariosMadero.get(Rol.CLIENTE), modificarRFC);
        } else if (usuario.getSucursal().equals(Sucursal.ACUEDUCTO)) {
            encontrado = modificarClienteEnSucursal(Banco.usuariosAcueducto.get(Rol.CLIENTE), modificarRFC);
        }

        if (!encontrado) {
            System.out.println("Cliente no encontrado.");
            return;
        }
    }

    private static boolean modificarClienteEnSucursal(ArrayList<Usuario> usuarios, String modificarRFC) {
        boolean encontrado = false;

        for (Usuario usuario : usuarios) {
            if (usuario.getRFC().equals(modificarRFC)) {
                encontrado = true;
                Cliente cliente = (Cliente) usuario;
                modificarDatos(cliente, modificarRFC);
                break;
            }
        }

        return encontrado;
    }

    private static void modificarDatos(Cliente cliente, String modificarRFC) {
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
            System.out.println("8. Usuario.");
            System.out.println("9. Contraseña.");
            System.out.println("10. Salir.");

            opcionModificar = leer.nextInt();
            leer.nextLine();
            switch (opcionModificar) {
                case 1:
                    System.out.print("Ingrese el nuevo nombre: ");
                    String newName = leer.nextLine().toUpperCase();
                    cliente.setNombre(newName);
                    cliente.setRFC(Usuario.generateRFC(newName, cliente.getApellidoPaterno(), cliente.getApellidoMaterno(), cliente.getFechaDeNacimiento()));
                    cliente.setCurp(Usuario.generarCurp(newName, cliente.getApellidoPaterno(), cliente.getApellidoMaterno(), cliente.getFechaDeNacimiento(), cliente.getEstado(), cliente.getSexo()));
                    break;

                case 2:
                    System.out.print("Ingrese el nuevo apellido Paterno: ");
                    String newFatherLastName = leer.nextLine().toUpperCase();
                    cliente.setApellidoPaterno(newFatherLastName);
                    cliente.setRFC(Usuario.generateRFC(cliente.getNombre(), newFatherLastName, cliente.getApellidoMaterno(), cliente.getFechaDeNacimiento()));
                    cliente.setCurp(Usuario.generarCurp(cliente.getNombre(), newFatherLastName, cliente.getApellidoMaterno(), cliente.getFechaDeNacimiento(), cliente.getEstado(), cliente.getSexo()));
                    break;

                case 3:
                    System.out.println("Ingrese el nuevo apellido Materno");
                    String newMotherLastName = leer.nextLine().toUpperCase();
                    cliente.setApellidoMaterno(newMotherLastName);
                    cliente.setRFC(Usuario.generateRFC(cliente.getNombre(), cliente.getApellidoPaterno(), newMotherLastName, cliente.getFechaDeNacimiento()));
                    cliente.setCurp(Usuario.generarCurp(cliente.getNombre(), cliente.getApellidoPaterno(), newMotherLastName, cliente.getFechaDeNacimiento(), cliente.getEstado(), cliente.getSexo()));
                    break;

                case 4:
                    System.out.println("Ingrese la nueva Fecha de Nacimiento: ");
                    String newFechaDeNacimiento = leer.nextLine().toUpperCase();
                    cliente.setFechaDeNacimiento(newFechaDeNacimiento);
                    cliente.setRFC(Usuario.generateRFC(cliente.getNombre(), cliente.getApellidoPaterno(), cliente.getApellidoMaterno(), newFechaDeNacimiento));
                    cliente.setCurp(Usuario.generarCurp(cliente.getNombre(), cliente.getApellidoPaterno(), cliente.getApellidoMaterno(), newFechaDeNacimiento, cliente.getEstado(), cliente.getSexo()));
                    break;

                case 5:
                    System.out.println("Ingrese la ciudad: ");
                    String newCity = leer.nextLine().toUpperCase();
                    cliente.setCiudad(newCity);
                    break;

                case 6:
                    System.out.println("Ingrese el estado: ");
                    String newEstado = leer.nextLine().toUpperCase();
                    cliente.setEstado(newEstado);
                    cliente.setCurp(Usuario.generarCurp(cliente.getNombre(), cliente.getApellidoPaterno(), cliente.getApellidoMaterno(), cliente.getFechaDeNacimiento(), newEstado, cliente.getSexo()));
                    break;

                case 7:
                    System.out.println("Ingrese el domicilio: ");
                    String newDomicilio = leer.nextLine().toUpperCase();
                    cliente.setDireccion(newDomicilio);
                    break;

                case 8:
                    System.out.println("Ingrese el nuevo nombre de usuario: ");
                    String newUserName = leer.nextLine();
                    cliente.setUserName(newUserName);
                    break;

                case 9:
                    System.out.println("Ingrese la nueva contraseña: ");
                    String newPassword = leer.nextLine();
                    cliente.setPassword(newPassword);
                    break;

                case 10:
                    return;

                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (opcionModificar != 10);
    }


    public static void eliminarCliente(Usuario usuarioActual) {
        Scanner leer = new Scanner(System.in);
        System.out.println("\n****Eliminación de Cliente****");
        System.out.println("\nIngrese el RFC del cliente a eliminar:");
        String buscarRFC = leer.nextLine();

        if (usuarioActual.getSucursal().equals(Sucursal.ACUEDUCTO)) {
            ArrayList<Usuario> clienteAcueducto = Banco.usuariosAcueducto.get(Rol.CLIENTE);
            for (Usuario cliente : clienteAcueducto) {
                System.out.println(cliente);
                if (cliente.getRFC().equals(buscarRFC)) {
                    clienteAcueducto.remove(cliente);
                    System.out.println("\nCliente de cuenta eliminado");
                    return;
                }
            }
        } else if (usuarioActual.getSucursal().equals(Sucursal.MADERO)) {
            ArrayList<Usuario> clienteMadero = Banco.usuariosMadero.get(Rol.CLIENTE);
            for (Usuario cliente : clienteMadero) {
                if (cliente.getRFC().equals(buscarRFC)) {
                    clienteMadero.remove(cliente);
                    System.out.println("\nCliente eliminado");
                    return;
                }
            }
        }
        System.out.println("Usuario no encontrado.");
    }

    //********************Tarjetas*******************
    public void solicitarTarjeta(Usuario usuarioActual) {
        Scanner leer = new Scanner(System.in);
        Cliente clienteSolicitar = (Cliente) usuarioActual;
        if (validarSolicitudesPendientes(clienteSolicitar)) {
            System.out.println("Ingrese el tipo de tarjeta que desea solicitar: ");
            System.out.println("1. Simplicity.  2. Platinium.   3. Gold.");
            int opcionTarjetaSolicitar = leer.nextInt();
            tipoTarjetaDeCredito tipoTarjetaSolicitar = null;
            EstadoSolicitud estado = EstadoSolicitud.PENDIENTE;
            switch (opcionTarjetaSolicitar) {
                case 1:
                    tipoTarjetaSolicitar = tipoTarjetaDeCredito.SIMPLICITY;
                    break;
                case 2:
                    tipoTarjetaSolicitar = tipoTarjetaDeCredito.PLATINUM;
                    break;
                case 3:
                    tipoTarjetaSolicitar = tipoTarjetaDeCredito.GOLD;
                    break;
            }


            if (validarRequisitosParaSolicitud(tipoTarjetaSolicitar, clienteSolicitar)) {
                SolicitudTarjetaCredito nuevaSolicitud = new SolicitudTarjetaCredito(clienteSolicitar, tipoTarjetaSolicitar, estado, LocalDateTime.now());
                listaSolicitudes.add(nuevaSolicitud);
                Banco.listaSolicitudes.add(nuevaSolicitud);
            } else {
                System.out.println("No cuentas con el saldo requerido para este tipo de tarjeta.");
            }
        } else {
            System.out.println("Tienes solicitudes pendientes.");
        }
    }


    public boolean validarSolicitudesPendientes(Cliente clienteActual) {
        for (SolicitudTarjetaCredito solicitudBuscar : listaSolicitudes) {
            if (solicitudBuscar.getClienteSolicitando() == clienteActual && solicitudBuscar.getStatus().equals(EstadoSolicitud.PENDIENTE)) {
                return false;
            }
        }
        return true;
    }

    public  Debito getTarjetaDebito() {
        return tarjetaDebito;
    }

    public static boolean validarRequisitosParaSolicitud(tipoTarjetaDeCredito tipoTarjetaASolicitar, Cliente cliente) {
        if (cliente.getTarjetaDebito().getSaldo() >= tipoTarjetaASolicitar.getSaldoMinimo()){
                return true;
            }
        return false;
    }

    public  void mostrarSolicitudesPropias(){
            System.out.println("\n*** SOLICITUDES  ***");
            if (listaSolicitudes.isEmpty()) {
                System.out.println("No has realizado ninguna solicitud de tarjetas de crédito.");
            } else {
                for (SolicitudTarjetaCredito buscarSolicitud : listaSolicitudes) {
                    System.out.println("\nTipo: " + buscarSolicitud.getTipoTarjeta());
                    System.out.println("Id solicitud: " + buscarSolicitud.getIdSolicitud());
                    System.out.println("Estado: " + buscarSolicitud.getStatus());
                    System.out.println("Fecha: " + buscarSolicitud.getFechaDeSolicitud());
                    System.out.println("-----------------------------------");
                }
            }
    }



}







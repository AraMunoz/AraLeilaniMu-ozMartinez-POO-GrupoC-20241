
package examen_unidad3_herencia;

import examen_unidad3_herencia.Tarjetas.Credito;
import examen_unidad3_herencia.Tarjetas.Debito;
import examen_unidad3_herencia.Tarjetas.Tarjeta;
import examen_unidad3_herencia.usuarios.Cliente;
import examen_unidad3_herencia.usuarios.Gerente;
import examen_unidad3_herencia.usuarios.Inversionista;
import examen_unidad3_herencia.usuarios.Usuario;
import examen_unidad3_herencia.utils.Sucursal;
import examen_unidad3_herencia.utils.UsuarioEnSesion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Menu {
    Scanner leer = new Scanner(System.in);
    Banco sistema = new Banco();

    public static HashMap<Sucursal, ArrayList<Cliente>> listaClientes = new HashMap<Sucursal, ArrayList<Cliente>>();

    public static void iniciarSesion() {
        boolean datosCorrectos = false;
        Scanner leer = new Scanner(System.in);
        do {
            System.out.println("\n\tBIENVENIDO AL SISTEMA BANCO ");

            System.out.println("Pulsa enter para iniciar sesion: ");
            leer.nextLine();
            System.out.println("\nSucursales ");
            System.out.println("1.Acueducto.");
            System.out.println("2.Madero.");

            int sucursalActual = 0;
            try {
                System.out.print("\nSelecciona tu sucursal: ");
                sucursalActual = leer.nextInt();
                leer.nextLine();
            } catch (Exception e) {
                System.out.println("\nIngresa un número");
            }
            System.out.print("Ingresa tu usuario: ");
            String usuario = leer.nextLine();
            System.out.print("Ingresa tu contrasena: ");
            String contrasena = leer.nextLine();


            Usuario usuarioActual = null;
            if (sucursalActual == 1)
                usuarioActual = Banco.verificarInicioSesion(Sucursal.ACUEDUCTO, usuario, contrasena);
            else if (sucursalActual == 2) {
                usuarioActual = Banco.verificarInicioSesion(Sucursal.MADERO, usuario, contrasena);
            }


            //libreria.verificarInicioSesion(usuario, contrasena);
            //Usuario usuarioActual = Banco.verificarInicioSesion(usuario, contrasena);
            if (usuarioActual != null) {
                datosCorrectos = true;

                UsuarioEnSesion.obtenerInstancia().setUsuarioActual(usuarioActual);

                seleccionarMenu();

            } else {
                System.out.println("Datos incorrectos, intentalo de nuevo.");
            }
        } while (!datosCorrectos);

    }

    public static void seleccionarMenu() {
        Usuario usuario = UsuarioEnSesion.obtenerInstancia().getUsuarioActual();
        switch (usuario.getRol()) {
            case CLIENTE:
                menuCliente(usuario.getSucursal());
                break;
            case CAPTURISTA:
                menuCapturista(usuario.getSucursal());
                break;
            case INVERSIONISTA:
                menuInversionista(usuario.getSucursal());
                break;
            case EJECUTIVODECUENTA:
                menuEjecutivoCuenta(usuario.getSucursal());
                break;
            case GERENTE:
                menuGerente(usuario.getSucursal());
                break;

            /*" -> funciones landa  */
        }
    }

    public static void menuGerente(Sucursal sucursal) {
        Usuario usuario = UsuarioEnSesion.obtenerInstancia().getUsuarioActual();
        Scanner leer = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n\n\t***Menu de Gerente****");
            System.out.println("1) Registrar cliente.");
            System.out.println("2) Mostrar lista de clientes");
            System.out.println("3) Modificar clientes");
            System.out.println("4) Eliminar clientes");
            System.out.println("5) Registrar capturista.");
            System.out.println("6) Mostrar lista de capturistas");
            System.out.println("7) Modificar capturistas");
            System.out.println("8) Eliminar capturistas");
            System.out.println("9) Registrar ejecutivo de venta.");
            System.out.println("10) Mostrar lista de ejecutivos de cuenta");
            System.out.println("11) Modificar ejecutivo de cuenta");
            System.out.println("12) Eliminar ejecutivo de cuenta");
            System.out.println("13) Registrar inversionista");
            System.out.println("14) Mostrar lista de inversionistas");
            System.out.println("15) Modificar inversionista");
            System.out.println("16) Eliminar inversionista");
            System.out.println("17) Ver solicitudes de tarjetas");
            System.out.println("18) Autorizar / rechazar solicitudes de tarjetas.");
            System.out.println("19) Generar llave de seguridad a inversionista");
            System.out.println("20) Consultar movimientos de inversionistas");
            System.out.println("21) Cerrar sesión.");

            System.out.println("\nAcción a realizar: ");
            opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    Banco.registrarCliente(usuario);
                    break;

                case 2:
                    Banco.mostrarClientes(usuario);
                    break;

                case 3:
                    Banco.modificarCliente(usuario);
                    break;

                case 4:
                    Banco.eliminarCliente(usuario);
                    break;

                case 5:
                    Banco.registrarCapturista(usuario);
                    break;

                case 6:
                    Banco.mostrarCapturista(usuario);
                    break;

                case 7:
                    Banco.modificarCapturista(usuario);
                    break;

                case 8:
                    Banco.eliminarCapturista(usuario);
                    break;

                case 9:
                    Banco.registrarEjecutivo(usuario);
                    break;

                case 10:
                    Banco.mostrarEjecutivos(usuario);
                    break;

                case 11:
                    Banco.modificarEjecutivo(usuario);
                    break;

                case 12:
                    Banco.eliminarEjecutivo(usuario);
                    break;

                case 13:
                    Banco.registrarInversionista(usuario);
                    break;

                case 14:
                    Banco.mostrarInversionista(usuario);
                    break;

                case 15:
                    Banco.modificarInversionista(usuario);
                    break;

                case 16:
                    Banco.eliminarInversionista(usuario);
                    break;

                case 17:
                    Banco.mostrarSolicitudes();
                    break;

                case 18:
                    Banco.autorizarSolicitud(usuario);
                    break;

                case 19:
                    Gerente.generarClaveSeguridad(usuario);
                    break;

                case 20:
                    Banco.mostrarInversiones(usuario, sucursal);
                    break;

                case 21:
                    System.out.println("\nCerrando sesión");
                    UsuarioEnSesion.obtenerInstancia().cerrarSesion();
                    iniciarSesion();
                    break;

                default:
                    System.out.println("\nOpción no válida");
            }
        } while (opcion != 21);
    }


    public static void menuCapturista(Sucursal sucursal) {
        Scanner leer = new Scanner(System.in);
        Usuario usuario = UsuarioEnSesion.obtenerInstancia().getUsuarioActual();
        int opcion;

        do {
            System.out.println("\n\t***Menu de capturista****");
            System.out.println("1) Registrar ejecutivo de venta.");
            System.out.println("2) Mostrar lista de ejecutivos de cuenta");
            System.out.println("3) Modificar ejecutivo de cuenta");
            System.out.println("4) Eliminar ejecutivo de cuenta");
            System.out.println("5) Cerrar sesión");

            System.out.println("\nAcción a realizar: ");
            opcion = leer.nextInt();
            switch (opcion) {

                case 1:
                    Banco.registrarInversionista(usuario);
                    break;

                case 2:
                    Banco.mostrarEjecutivos(usuario);
                    break;

                case 3:
                    Banco.modificarEjecutivo(usuario);
                    break;

                case 4:
                    Banco.eliminarEjecutivo(usuario);
                    break;

                case 5:
                    System.out.println("\nCerrando sesión");
                    UsuarioEnSesion.obtenerInstancia().cerrarSesion();
                    iniciarSesion();
                    break;

                default:
                    System.out.println("\nOpción no válida");
            }
        } while (opcion != 5);
    }

    public static void menuEjecutivoCuenta(Sucursal sucursal) {
        Scanner leer = new Scanner(System.in);
        Usuario usuario = UsuarioEnSesion.obtenerInstancia().getUsuarioActual();
        int opcion;
        do {
            System.out.println("\n\t***Menu de ejecutivo de cuenta****");
            System.out.println("1) Registrar cliente.");
            System.out.println("2) Mostrar lista de clientes");
            System.out.println("3) Modificar clientes");
            System.out.println("4) Eliminar clientes");
            System.out.println("5) Ver solicitudes de tarjetas");
            System.out.println("6) Autorizar / rechazar solicitudes de tarjetas.");
            System.out.println("7) Cerrar sesión.");

            System.out.println("\nAcción a realizar: ");
            opcion = leer.nextInt();
            switch (opcion) {
                case 1:
                    Banco.registrarCliente(usuario);
                    break;

                case 2:
                    Banco.mostrarClientes(usuario);
                    break;

                case 3:
                    Banco.modificarCliente(usuario);
                    break;

                case 4:
                    Banco.eliminarCliente(usuario);
                    break;
                case 5:
                    Banco.mostrarSolicitudes();
                    break;

                case 6:
                    Banco.autorizarSolicitud(usuario);
                    break;

                case 7:
                    System.out.println("\nCerrando sesión");
                    UsuarioEnSesion.obtenerInstancia().cerrarSesion();
                    iniciarSesion();
                    break;

                default:
                    System.out.println("\nOpción no válida");
            }
        } while (opcion != 7);
    }

    public static void menuCliente(Sucursal sucursal) {
        Scanner leer = new Scanner(System.in);
        Usuario usuario = UsuarioEnSesion.obtenerInstancia().getUsuarioActual();
        Cliente user = (Cliente) usuario;
        int opcion;
        do {
            System.out.println("\n\t***Menu de cliente****");
            System.out.println("1) Ver información.");
            System.out.println("2) Ver fondos");
            System.out.println("3) Solicitar tarjeta");
            System.out.println("4) Ver solicitudes");
            System.out.println("5) Realizar compra.");
            System.out.println("6) Abonar a tarjeta de crédito.");
            System.out.println("7) Cerrar sesión.");

            System.out.println("\nAcción a realizar: ");
            opcion = leer.nextInt();
            switch (opcion) {

                case 1:
                user.mostrarInfo();
                    break;

                case 2:
                    user.verFondosTarjetas();
                    break;

                case 3:
                   Banco.solicitarTarjetaCredito(usuario);
                    break;

                case 4:
                    user.mostrarSolicitudesPropias();
                    break;

                case 5:
                    int compra = 0;
                    System.out.println("1. Comprar con debito");
                    System.out.println("2. Comprar con credito");
                    System.out.print("Como vas a realizar tus compras: ");
                    compra = leer.nextInt();
                    if(compra==1)
                        Tarjeta.comprar();
                    else  {
                        Tarjeta.comprar();
                    }

                    break;

                case 6:
                    int abono = 0;
                    System.out.println("1. Abonar con debito");
                    System.out.println("2. Abonar con credito");
                    System.out.print("Como vas a realizar el abono: ");
                    abono = leer.nextInt();
                    if(abono==1)
                        Debito.abonarDebito();

                    else  {
                        Tarjeta.abonar();
                    }
                    break;

                case 7:
                    System.out.println("\nCerrando sesión");
                    UsuarioEnSesion.obtenerInstancia().cerrarSesion();
                    iniciarSesion();
                    break;


                default:
                    System.out.println("\nOpción no válida");
            }
        } while (opcion != 7);
    }


    public static void menuInversionista(Sucursal sucursal) {
        Scanner leer = new Scanner(System.in);
        Usuario usuario = UsuarioEnSesion.obtenerInstancia().getUsuarioActual();
        int opcion;

        do {
            System.out.println("\n\t***Menu de inversionista****");
            System.out.println("1) Ver información.");
            System.out.println("2) Ver fondos de inversión");
            System.out.println("3) Realizar fondo de inversión");
            System.out.println("4) Cerrar sesión.");

            System.out.println("\nAcción a realizar: ");
            opcion = leer.nextInt();
            switch (opcion) {

                case 1:
                    Inversionista.mostrarDatosPersonales(usuario);
                    break;

                case 2:
                    Inversionista.mostrarInversionesPropias(usuario);
                    break;

                case 3:
                    Inversionista.realizarInversion(usuario);
                    break;

                case 4:
                    System.out.println("\nCerrando sesión");
                    UsuarioEnSesion.obtenerInstancia().cerrarSesion();
                    iniciarSesion();
                    break;

                default:
                    System.out.println("\nOpción no válida");
            }
        } while (opcion != 4);
    }

}

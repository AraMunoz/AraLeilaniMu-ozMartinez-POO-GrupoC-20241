
package examen_unidad3_herencia;

import examen_unidad3_herencia.Tarjetas.Credito;
import examen_unidad3_herencia.Tarjetas.SolicitudTarjetaCredito;
import examen_unidad3_herencia.Tarjetas.Tarjeta;
import examen_unidad3_herencia.Tarjetas.tipoTarjetaDeCredito;
import examen_unidad3_herencia.usuarios.*;
import examen_unidad3_herencia.utils.Rol;
import examen_unidad3_herencia.utils.Sucursal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

import static examen_unidad3_herencia.Tarjetas.SolicitudTarjetaCredito.mostrarListaSolicitudes;


public class Banco {
    Scanner leer = new Scanner(System.in);
    public static HashMap<Sucursal, Gerente> listaGerentes = new HashMap<Sucursal, Gerente>();
    public static HashMap<Rol, ArrayList<Usuario>> usuariosMadero = new HashMap<Rol, ArrayList<Usuario>>();
    public static HashMap<Rol, ArrayList<Usuario>> usuariosAcueducto = new HashMap<Rol, ArrayList<Usuario>>();
    public static ArrayList <Tarjeta> listaTarjetas = new ArrayList<>();
    public static ArrayList <SolicitudTarjetaCredito> listaSolicitudes = new ArrayList<>();

    Gerente gerenteMadero = new Gerente("GerenteMadero", "123m", "Maite", "Hernandez", "Muñoz", "2000-20-09", "Morelia", "Michoacan", "Mujer", "HEMUM000920MIC09", "Av. Hidalgo", 200000.90, Rol.GERENTE, Sucursal.MADERO, "mujer");
    Gerente gerenteAcueducto = new Gerente("GerenteAcueducto", "123a", "Liam", "Lopez", "Perez", "1985-22-10", "Morelia", "Aguascalientes", "Hombre", "LOPEL851022HAGU07", "Av. Morelos", 200000.90, Rol.GERENTE, Sucursal.ACUEDUCTO, "hombre");

    public Banco() {
        if (!listaGerentes.containsKey(Sucursal.ACUEDUCTO)) {
            usuariosAcueducto.put(Rol.GERENTE, new ArrayList<Usuario>());
            usuariosAcueducto.get(Rol.GERENTE).add(gerenteAcueducto);
            listaGerentes.put(Sucursal.ACUEDUCTO, gerenteAcueducto);
        }
        if (!listaGerentes.containsKey(Sucursal.MADERO)) {
            listaGerentes.put(Sucursal.MADERO, gerenteMadero);
            usuariosMadero.put(Rol.GERENTE, new ArrayList<Usuario>());
            usuariosMadero.get(Rol.GERENTE).add(gerenteMadero);

        }

    }

    public static Usuario verificarInicioSesion(Sucursal sucursal, String nombreUsuario, String contrasena) {
        HashMap<Rol, ArrayList<Usuario>> usuariosPorSucursal = sucursal.equals(Sucursal.ACUEDUCTO) ? usuariosAcueducto : usuariosMadero;
        Collection<ArrayList<Usuario>> usuarios = usuariosPorSucursal.values();

        if (usuarios != null) {
            for (ArrayList<Usuario> users : usuarios) {
                for(Usuario user: users)
                    if (user.getUserName().equals(nombreUsuario) && user.getPassword().equals(contrasena)) {
                        return user;
                    }
            }
        }
        System.out.println("Datos incorrectos.");
        return null;
    }
/*
        if (usuariosAcueducto.get(Sucursal.ACUEDUCTO).stream().getUserName().equals(nombreUsuario)) {
            if (listaGerentes.get(Sucursal.ACUEDUCTO).getContasena().equals(contrasena)) {
                return listaGerentes.get(Sucursal.ACUEDUCTO);
            }

        } else if (listaGerentes.get(Sucursal.MADERO).getUserName().equals(nombreUsuario)) {
            if (listaGerentes.get(Sucursal.MADERO).getContasena().equals(contrasena)) {
                return listaGerentes.get(Sucursal.MADERO);
            }

        */

    //**********Registro**********************

    public static void registrarCliente(Usuario usuarioActual) {
        Cliente.registerClient(usuarioActual);
    }

    public static void registrarEjecutivo(Usuario usuarioActual) {
        EjecutivoDeVentas.registerEjecutivo(usuarioActual);
    }

    public static void registrarCapturista(Usuario usuarioActual) {
        Capturista.registerCapturista(usuarioActual);
    }

    public static void registrarInversionista(Usuario usuarioActual) {
        Inversionista.registarInversionista(usuarioActual);
    }


    //**************Listas***********************

    public static void mostrarClientes(Usuario usuarioActual) {
        Cliente.mostrarCliente(usuarioActual);
    }

    public static void mostrarCapturista(Usuario usuarioActual) {
        Capturista.mostrarCapturista(usuarioActual);
    }

    public static void mostrarEjecutivos(Usuario usuarioActual) {
        EjecutivoDeVentas.mostrarEjecutivo(usuarioActual);
    }

    public static void mostrarInversionista(Usuario usuarioActual) {
        Inversionista.mostrarInversionista(usuarioActual);
    }


    //******************Modificación*****************

    public static void modificarCliente(Usuario usuarioActual) {
        Cliente.modificarCliente(usuarioActual);
    }

    public static void modificarCapturista(Usuario usuarioActual) {
        Capturista.modificarCapturista(usuarioActual);
    }

    public static void modificarInversionista(Usuario usuarioActual) {
        Inversionista.modificarInversionista(usuarioActual);
    }

    public static void modificarEjecutivo(Usuario usuarioActual) {
        EjecutivoDeVentas.modificarEjecutivo(usuarioActual);
    }


    //******************Eliminación******************

    public static void eliminarCliente(Usuario usuarioActual) {
        Cliente.eliminarCliente(usuarioActual);
    }
    public static void eliminarEjecutivo(Usuario usuarioActual) {
        EjecutivoDeVentas.eliminarEjecutivo(usuarioActual);
    }
    public static void eliminarCapturista(Usuario usuarioActual) {
        Capturista.eliminarCapturista(usuarioActual);
    }

    public static void eliminarInversionista(Usuario usuarioActual) {
        Inversionista.eliminarInversionista(usuarioActual);
    }


    //**********SOLICITUD.**********************
    public static void solicitarTarjetaCredito(Usuario usuarioActual){
        Cliente userSolicita = (Cliente) usuarioActual;
        userSolicita.solicitarTarjeta(usuarioActual);
    }
    public static void autorizarSolicitud(Usuario usuarioActual){
        Usuario.aceptarSolicitud(usuarioActual);
    }
    public static void mostrarSolicitudes(){
        mostrarListaSolicitudes();
    }

    //**********TARJETAS.**********************
    public static void realizarCompra(){
        Tarjeta.comprar();
    }
    public static void realizarAbono(){
        Tarjeta.abonar();
    }

    //*************Inversiones*************
    public static void mostrarInversiones(Usuario usuarioActual, Sucursal sucursal) {
            Inversionista.mostrarInversiones(sucursal);

    }

}

package Usuarios;

import Escuela.Materias;
import utilsGlobal.Carrera.Carreras;
import Escuela.Sistema;

import java.util.List;
import java.util.Scanner;

public class Coordinador extends Usuario {

    private Carreras carrera;
    private List<Materias> materiasImpartidas;


    public Coordinador(String nombre, String apellidoPaterno, String apellidoMaterno, String fechaNacimiento,
                       String CURP, String RFC, double sueldo, String numeroDeControl, String fechaDeRegistro,
                       String estado, String ciudad, String dirección, Rol rol, String contraseña, Carreras carrera, String sexo) {
        super(nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, CURP, RFC,
                sueldo, numeroDeControl, fechaDeRegistro, estado, ciudad, dirección, rol, contraseña, carrera, sexo);
    }

    //public Carreras getCarrera() {
       // return carrera;
    //}

    public void setCarrera(Carreras carrera) {
        this.carrera = carrera;
    }


    ///////////////////////////////Mostrar coordinadores//////////////////////
    public static void mostrarCoordinador() {
        Scanner leer = new Scanner(System.in);
        System.out.println("*****COORDINADORES*****");
        System.out.println("Ingrese el número de Control que desee mostrar: ");

        boolean valdiarOpcionCoordinador = true;
        String opcionCoordinador = null;
        while (valdiarOpcionCoordinador) {
            try {
                opcionCoordinador = leer.nextLine();
                for (Usuario buscarCoordinadorAMostrar : Sistema.listaCoordinadores) {
                    if (buscarCoordinadorAMostrar.getNumeroDeControl() == opcionCoordinador) {
                        valdiarOpcionCoordinador = false;
                        buscarCoordinadorAMostrar.toString();
                    } else {
                        System.out.println("Coordinador no encontrado.");
                        valdiarOpcionCoordinador = true;
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
                valdiarOpcionCoordinador = true;
            }
        }
    }

    ///////////////////////////////Impartir materias como coordinadores//////////////////////
    public void tomarMateriasCoordinador() {
        System.out.println("Ingrese la carrera que desea impartir: ");
    }
}



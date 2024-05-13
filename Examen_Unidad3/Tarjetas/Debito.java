
package examen_unidad3_herencia.Tarjetas;

import examen_unidad3_herencia.Banco;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import static examen_unidad3_herencia.Banco.listaTarjetas;

/**
 *
 * @author leila_pe8dh8w
 */
public class Debito extends Tarjeta {
     Debito(String numeroDeCuenta,  int CVV, String clabeInterbancaria, Double saldo, LocalDate fechaDeVencimiento, LocalDate fechaDeCreacion) {
        super(numeroDeCuenta, CVV, clabeInterbancaria, saldo, fechaDeVencimiento, fechaDeCreacion);
    }
    public Debito(){

    }

    public static Debito crearTarjeta(){
        String numeroTarjeta = Tarjeta.GenerarNumeroCuenta();
        LocalDate fechaCreacion = LocalDate.now();
        int CVV = generarCVV();
        String clabe = Tarjeta.GenerarClabe();
        LocalDate fechaVencimiento = generarFechaDeVencimiento(fechaCreacion);
        Scanner leer = new Scanner(System.in);
        System.out.println("Su número de tarjeta es: " + numeroTarjeta);
        System.out.println("Fecha de Creación: " + fechaCreacion);
        System.out.println("CVV: " + CVV);
        System.out.println("Clave interbancaria: " + clabe);
        System.out.println("Ingrese el saldo inicial de la cuenta: ");
        double saldo = leer.nextDouble();
        System.out.println("Fecha de vencimiento: " + fechaVencimiento);
        Debito newTarjeta = new Debito(numeroTarjeta,CVV, clabe,saldo, fechaVencimiento,fechaCreacion);
        Banco.listaTarjetas.add(newTarjeta);
        return newTarjeta;
    }

    public String toString(){
        return String.format("El numero de tarjeta crédito es: %s, \nSu CVV: %d, " +
                "\nSu clabe interbancaria: %s " +
                "\nSu fecha de vencimiento: %s \nSu saldo actual es: %.2f \nSu fecha de creacion es: %s ", getNumeroDeCuenta(), getCVV(), getClabeInterbancaria(), getFechaDeVencimiento().toString(), getSaldo(), this.fechaDeCreacion);
    }
    public static void abonarDebito(){
        Scanner leer = new Scanner(System.in);
        System.out.println("Realizar abono.");
        System.out.println("Ingresar el número de tarjeta: ");
        String numeroTarjeta = leer.nextLine();
        for (Tarjeta buscarTarjeta : Banco.listaTarjetas) {

                System.out.println("Ingrese el monto a abonar: ");
                double abono = leer.nextDouble();
                System.out.println("Abono ingresado: " + abono);
                    double saldoAFavor = buscarTarjeta.getSaldo() + abono;
                    buscarTarjeta.setSaldo(saldoAFavor);
                    System.out.println("Abono realizado con éxito. Nuevo saldo: " + saldoAFavor);

            }
        }
    }

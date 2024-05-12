/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen_unidad3_herencia.Tarjetas;

import examen_unidad3_herencia.Banco;
import examen_unidad3_herencia.usuarios.Usuario;
import examen_unidad3_herencia.utils.Rol;
import examen_unidad3_herencia.utils.Sucursal;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import static examen_unidad3_herencia.Banco.listaTarjetas;

public class Credito extends Tarjeta
{
    private double creditoMaximo;
    private double creditoMinimo;

    public Credito(){
    }

    public Credito(String numeroDeCuenta, int CVV, String clabeInterbancaria, Double saldo,
                   LocalDate fechaDeVencimiento, LocalDate fechaDeCreacion, tipoTarjetaDeCredito type) {
        super(numeroDeCuenta, CVV, clabeInterbancaria, saldo, fechaDeVencimiento, fechaDeCreacion);
        this.type = type;
        this.creditoMaximo = creditoMaximo;
        this.creditoMinimo = creditoMinimo;
    }

    public static Credito crearTarjetaCredito(tipoTarjetaDeCredito tipoTarjeta, Usuario usuario) {
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
        System.out.println("Fecha de vencimiento: " + fechaVencimiento);
        System.out.println("Tipo de tarjeta: " + tipoTarjeta);

        double saldo = tipoTarjeta.getSaldoMinimo();

        System.out.println("Su saldo es de: " + saldo);
        Credito newTarjeta = new Credito(numeroTarjeta, CVV, clabe, saldo, fechaVencimiento, fechaCreacion, tipoTarjeta);
        listaTarjetas.add(newTarjeta);
        return newTarjeta;
    }


    public tipoTarjetaDeCredito getType() {
        return type;
    }

@Override
    public String toString(){
        return String.format("El numero de tarjeta crédito es: %s \nSu CVV: %d" +
                "\nSu clabe interbancaria: %s" +
                "\nsu fecha de vencimiento: %s \nSu saldo actual es: %.2f", getNumeroDeCuenta(), getCVV(), getClabeInterbancaria(), getFechaDeVencimiento().toString(), getSaldo());
    }
}

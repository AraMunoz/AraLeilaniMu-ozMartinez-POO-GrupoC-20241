
package Libros.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LibrosUtils {
    
    public static ArrayList<String> registrarLibroDatosComun (){
     Scanner leer = new Scanner(System.in);
        ArrayList<String> datosComun = new ArrayList<>();
        System.out.print("Ingresa el nombre del libro: ");
        String nombre=leer.nextLine();
        System.out.print("Ingresa el autor del libro: ");
        String autor=leer.nextLine();
        System.out.print("Ingresa la editorial del libro: ");
        String editorial = leer.nextLine();
        System.out.print("Ingresa el dia de publicacion del libro: ");
        int dia = leer.nextInt();
        System.out.print("Ingresa el mes de publicacion del libro: ");
        int mes = leer.nextInt();
        System.out.print("Ingresa el año de publicacion del libro: ");
        int year = leer.nextInt();
        
        LocalDate fecha = LocalDate.of(year, mes, dia);
        System.out.println("Ingresa el precio");
        double precio = leer.nextDouble();
        System.out.println("Ingresa el stock del libro: ");
        int stock = leer.nextInt();
        datosComun.addAll(Arrays.asList(nombre,autor,editorial,String.valueOf(fecha),String.valueOf(precio),String.valueOf(stock)));
        return datosComun;
}
}

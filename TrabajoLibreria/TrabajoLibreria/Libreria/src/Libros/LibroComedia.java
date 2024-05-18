/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Libros;

import Libros.utils.LibrosUtils;
import Libros.utils.constants.ClasificacionLibro;
import Libros.utils.constants.Genero;
import Libros.utils.constants.TerrorSubgenero;
import libreria.Libreria;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author leila_pe8dh8w
 */
public class LibroComedia extends Libro{

    public LibroComedia(String titulo, String fechaLanzamiento, String autor, double precio, String editorial,  int stock) {
        super(titulo, fechaLanzamiento, autor, precio, editorial, Genero.COMEDIA, stock);
    }

    public LibroComedia() {
    }
    
    
    public static void registrarLibroComedia(){
       Scanner leer = new Scanner(System.in);
       ArrayList<String> datosComun = LibrosUtils.registrarLibroDatosComun();
       String nombre = datosComun.get(0);
       String autor = datosComun.get(1);
       String editorial = datosComun.get(2);
       LocalDate fecha = LocalDate.parse(datosComun.get(3));
       double precio = Double.parseDouble(datosComun.get(4));
       int stock = Integer.parseInt(datosComun.get(5));
        LibroComedia newLibroComedia = new LibroComedia (nombre, fecha.toString(), autor, precio, editorial, stock);
        libreria.Libreria.libros.get(Genero.COMEDIA).add(newLibroComedia);
        Libreria.serializar();
        System.out.println("El libro ha sido registrado correctamente. Su ID es: "+ newLibroComedia.getID());
    }
    public static void eliminarLibroComedia()
    {
        Scanner leer = new Scanner(System.in);
        ArrayList<Libro> librosEliminar = libreria.Libreria.libros.get(Genero.COMEDIA);
        System.out.println("Ingrese el ID del libro a eliminar:");
        int id = leer.nextInt();
            for (Libro libro : librosEliminar) {
                if (libro.getID()==id) {
                    libreria.Libreria.libros.get(Genero.COMEDIA).remove(libro);
                    System.out.println("\n Libro eliminado");
                    return;
                }
            }
    }
    
    public static void mostrarLibroComedia()
    {
        LibroComedia libro = new LibroComedia();
        Scanner leer = new Scanner (System.in);
        System.out.println("1. Filtrar por precio");                     
        System.out.println("2. Filtrar por editorial"); 
        System.out.println("3. Ver todos los libros"); 
        System.out.print("Ingresa una opcion: ");
        int opcion = leer.nextInt();
        switch (opcion) {               
                case 1:                    
                    System.out.println("Filtrar por precio");  
                    System.out.println("Ingresa el precio minimo: ");
                    double precioInicial = leer.nextDouble();
                    System.out.println("Ingresa el precio maximo: ");
                    double precioFinal = leer.nextDouble();
                    libro.filtrarPorRangoDePrecio(precioInicial, precioFinal);
                    break;                
                              
                case 2:                    
                    System.out.println("Filtrar por editorial ");
                    System.out.println("Ingresa el nombre de la editorial: ");
                    String editorialBuscar = leer.nextLine();
                    libro.filtrarPorEditorial(editorialBuscar);
                    break;
                case 3:                    
                    System.out.println("**Lista de libros**");  
                    mostrarLibrosComedia();
                    break;
            } 
        
    }
    
   
    
    public static void mostrarLibrosComedia()
    {
            for (Libro libro : libreria.Libreria.libros.get(Genero.COMEDIA)) {
                System.out.println(libro.toString());
            }
    }
    @Override
    public void filtrarPorEditorial(String editoralBuscada){
        libreria.Libreria.libros.get(Genero.COMEDIA).stream()
                .filter(libro -> libro.getEditorial().equals(editoralBuscada))
                .forEach(libro -> System.out.println(libro.toString()));
    }
    @Override
    public void filtrarPorPrecioMayorA  (double precio){
        libreria.Libreria.libros.get(Genero.COMEDIA).stream()
                .filter(libro -> libro.getPrecio() >precio)
                        .forEach(libro -> System.out.println(libro.toString()));
    }
    @Override
    public void filtrarPorRangoDePrecio(double precioInicial, double precioFinal){
        libreria.Libreria.libros.get(Genero.COMEDIA).stream()
                .filter(libro -> libro.getPrecio() <= precioFinal)
                .filter( libro -> libro.getPrecio() >= precioInicial )
                .forEach(libro -> System.out.println(libro.toString()));
    }
    
    @Override
     public void filtrarLibroPorInicialDeAutor(String inicial){
         libreria.Libreria.libros.get(Genero.COMEDIA)
                 .stream()
                 .map(libro->libro.getAutor().toUpperCase())
                 .forEach(libro-> System.out.println(libro.toString()));
     }
}

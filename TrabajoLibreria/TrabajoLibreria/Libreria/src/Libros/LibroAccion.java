/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Libros;

import Libros.utils.LibrosUtils;
import Libros.utils.constants.Genero;
import Libros.utils.constants.ClasificacionLibro;
import Libros.utils.constants.TerrorSubgenero;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author leila_pe8dh8w
 */
public class LibroAccion extends Libro{
    private ClasificacionLibro clasificacion;
    public LibroAccion(String titulo , String fechaLanzamiento, String autor, double precio, String editorial, int stock, ClasificacionLibro clasificacion) {
        super(titulo, fechaLanzamiento, autor, precio, editorial, Genero.ACCION, stock);
        this.clasificacion=clasificacion;
    }

    public LibroAccion() {
        
    }
    
    public static void registrarLibroAccion(){
       Scanner leer = new Scanner(System.in);
       ArrayList<String> datosComun = LibrosUtils.registrarLibroDatosComun();
       String nombre = datosComun.get(0);
       String autor = datosComun.get(1);
       String editorial = datosComun.get(2);
       LocalDate fecha = LocalDate.parse(datosComun.get(3));
       double precio = Double.parseDouble(datosComun.get(4));
       int stock = Integer.parseInt(datosComun.get(5));
       
       ClasificacionLibro clasificacion = null;
        System.out.println("Ingresa la clasificacion del libro");
        System.out.println("1.A");
        System.out.println("2. B");
        System.out.println("3. C");
        int opcionSubgenero = leer.nextInt();
        if(opcionSubgenero ==1){
            clasificacion = ClasificacionLibro.A;
        }if(opcionSubgenero ==2){
             clasificacion = ClasificacionLibro.B;
        }
        else{
            clasificacion = ClasificacionLibro.C;
        } 
        
        LibroAccion newLibroAccion = new LibroAccion(nombre, fecha.toString(), autor, precio, editorial, stock, clasificacion);
        libreria.Libreria.libros.get(Genero.ACCION).add(newLibroAccion);
        System.out.println("El libro ha sido registrado correctamente. Su ID es: "+ newLibroAccion.getID());
    }
    public static void eliminarLibroAccion()
    {
        Scanner leer = new Scanner(System.in);
        ArrayList<Libro> librosEliminar = libreria.Libreria.libros.get(Genero.ACCION);
        System.out.println("Ingrese el ID del libro a eliminar:");
        int id = leer.nextInt();
            for (Libro libro : librosEliminar) {
                if (libro.getID()==id) {
                    libreria.Libreria.libros.get(Genero.ACCION).remove(libro);
                    System.out.println("\n Libro eliminado");
                    return;
                }
            }
    }
    public ClasificacionLibro getClasificacion() {
        return clasificacion;
    }
    
    
    public static void mostrarLibroAccion()
    {
        LibroAccion libro = new LibroAccion();
        Scanner leer = new Scanner (System.in);
        System.out.println("1. Filtrar por precio");  
        System.out.println("2. Filtrar por clasificacion"); 
        System.out.println("3. Filtrar por editorial"); 
        System.out.println("4. Ver todos los libros"); 
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
                    System.out.println("Filtrar por clasificacion: ");  
                    filtrarPorClasificacion();
                    break;                
                case 3:                    
                    System.out.println("Filtrar por editorial ");
                    System.out.println("Ingresa el nombre de la editorial: ");
                    String editorialBuscar = leer.nextLine();
                    libro.filtrarPorEditorial(editorialBuscar);
                    break;
                case 4:                    
                    System.out.println("**Lista de libros**");  
                    Libro.mostrarLibrosPorGenero(Genero.ACCION);
                    break;
            } 
        
    }
    
    
    public static void filtrarPorClasificacion(){
        Scanner scanner = new Scanner(System.in); 
        boolean esDatoValido = false;
        int opcion = 0;
        ArrayList<Libro> librosAccion = libreria.Libreria.libros.get(Genero.ACCION);
        System.out.print("Que clasificacion deseas ver: ");
        System.out.println("1. A");
        System.out.println("2. B");
        System.out.println("3. C");
        while (!esDatoValido) {                
                try {                    
                    opcion = scanner.nextInt();                                      
                        esDatoValido = true;                
                } catch (InputMismatchException error) {                   
                    System.out.println("Ingresaste un valor incorrecto, intenta de nuevo");                
                } finally {                    
                    scanner.nextLine();                
                }            
            }            
            esDatoValido = false;   
            if(opcion == 1){
                librosAccion.stream()
            .filter(libro -> ((LibroAccion)libro).getClasificacion() == ClasificacionLibro.A)
            .forEach(libro->System.out.println(libro.toString()));
            }
            else if(opcion==2){
                librosAccion.stream()
            .filter(libro -> ((LibroAccion)libro).getClasificacion() == ClasificacionLibro.B)
            .forEach(libro->System.out.println(libro.toString()));
            }else if(opcion == 3){
                librosAccion.stream()
            .filter(libro -> ((LibroAccion)libro).getClasificacion() == ClasificacionLibro.C)
            .forEach(libro->System.out.println(libro.toString()));
            }
                
                
        
    }
   @Override
    public  void filtrarPorPrecioMayorA  (double precio){
        libreria.Libreria.libros.get(Genero.ACCION).stream()
                .filter(libro -> libro.getPrecio() >precio)
                        .forEach(libro -> System.out.println(libro.toString()));
    }
    
    @Override
    public void filtrarPorRangoDePrecio(double precioInicial, double precioFinal){
        libreria.Libreria.libros.get(Genero.ACCION).stream()
                .filter(libro -> libro.getPrecio() <= precioFinal)
                .filter( libro -> libro.getPrecio() >= precioInicial )
                .forEach(libro -> System.out.println(libro.toString()));
    }
    
    @Override
    public void filtrarPorEditorial(String editoralBuscada){
        libreria.Libreria.libros.get(Genero.ACCION).stream()
                .filter(libro -> libro.getEditorial().equals(editoralBuscada))
                .forEach(libro -> System.out.println(libro.toString()));
    }
    
    
    @Override
     public void filtrarLibroPorInicialDeAutor(String inicial){
         libreria.Libreria.libros.get(Genero.ACCION)
                 .stream()
                 .map(libro->libro.getAutor().toUpperCase())
                 .forEach(libro-> System.out.println(libro.toString()));
     }
    
}

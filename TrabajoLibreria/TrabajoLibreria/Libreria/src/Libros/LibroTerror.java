/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Libros;

import Libros.utils.LibrosUtils;
import Libros.utils.constants.TerrorSubgenero;
import Libros.utils.constants.Genero;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author leila_pe8dh8w
 */
public class LibroTerror extends Libro{
   

    private TerrorSubgenero subgenero;
    
    public LibroTerror(String titulo, String fechaLanzamiento, String autor, double precio, String editorial, int stock, TerrorSubgenero subgerenero) {
        super(titulo, fechaLanzamiento, autor, precio, editorial, Genero.TERROR, stock);
        this.subgenero= subgenero;
    }

    public LibroTerror() {
    }
    
   
    public static void registrarLibroTerror(){
       Scanner leer = new Scanner(System.in);
       ArrayList<String> datosComun = LibrosUtils.registrarLibroDatosComun();
       String nombre = datosComun.get(0);
       String autor = datosComun.get(1);
       String editorial = datosComun.get(2);
       LocalDate fecha = LocalDate.parse(datosComun.get(3));
       double precio = Double.parseDouble(datosComun.get(4));
       int stock = Integer.parseInt(datosComun.get(5));
       
       TerrorSubgenero subgenero = null;
        System.out.println("Ingresa el subgenero del libro");
        System.out.println("1.Psicologico");
        System.out.println("2. Monjas");
        int opcionSubgenero = leer.nextInt();
        if(opcionSubgenero ==1){
            subgenero = TerrorSubgenero.PSCICOLOGICO;
        }else{
            subgenero = TerrorSubgenero.MONJAS;
        } 
        
        LibroTerror newLibroTerror = new LibroTerror(nombre, fecha.toString(), autor, precio, editorial, stock, subgenero);
        libreria.Libreria.libros.get(Genero.TERROR).add(newLibroTerror);
        System.out.println("El libro ha sido registrado correctamente. Su ID es: "+ newLibroTerror.getID());
    }
    
    public static void eliminarLibroTerror()
    {
        Scanner leer = new Scanner(System.in);
        ArrayList<Libro> librosTerror = libreria.Libreria.libros.get(Genero.TERROR);
        System.out.println("Ingrese el ID del libro a eliminar:");
        int id = leer.nextInt();
            for (Libro libro : librosTerror) {
                if (libro.getID()==id) {
                    libreria.Libreria.libros.get(Genero.TERROR).remove(libro);
                    System.out.println("\n Libro eliminado");
                    return;
                }
            }
    }
    
   public static void mostrarLibroTerror()
    {
        LibroTerror libro = new LibroTerror();
        Scanner leer = new Scanner (System.in);
        System.out.println("1. Filtrar por precio"); 
        System.out.println("2. Filtrar por subgenero"); 
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
                    filtrarPorSubgenero();
                    break;                
                case 3:                    
                    System.out.println("Filtrar por editorial ");
                    System.out.println("Ingresa el nombre de la editorial: ");
                    String editorialBuscar = leer.nextLine();
                    libro.filtrarPorEditorial(editorialBuscar);
                    break;
                case 4:                    
                    System.out.println("**Lista de libros**");  
                    mostrarLibrosTerror();
                    break;
            } 
        
    }
    
    
    public static void filtrarPorSubgenero(){
        Scanner scanner = new Scanner(System.in); 
        boolean esDatoValido = false;
        int opcion = 0;
        ArrayList<Libro> librosAccion = libreria.Libreria.libros.get(Genero.ACCION);
        System.out.print("Que clasificacion deseas ver: ");
        System.out.println("1. Psicoogico");
        System.out.println("2. Monjas");
   
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
            .filter(libro -> ((LibroTerror)libro).getSubgenero()== TerrorSubgenero.PSCICOLOGICO)
            .forEach(libro->System.out.println(libro.toString()));
            }
            else if(opcion==2){
                librosAccion.stream()
            .filter(libro -> ((LibroTerror)libro).getSubgenero()== TerrorSubgenero.MONJAS)
            .forEach(libro->System.out.println(libro.toString()));
            }
    }
    
    public static void mostrarLibrosTerror()
    {
            for (Libro libro : libreria.Libreria.libros.get(Genero.TERROR)) {
                System.out.println(libro.toString());
            }
    }
    @Override
    public void filtrarPorEditorial(String editoralBuscada){
        libreria.Libreria.libros.get(Genero.TERROR).stream()
                .filter(libro -> libro.getEditorial().equals(editoralBuscada))
                .forEach(libro -> System.out.println(libro.toString()));
    }

    @Override
    public void filtrarPorRangoDePrecio(double precioInicial, double precioFinal){
        libreria.Libreria.libros.get(Genero.TERROR).stream()
                .filter(libro -> libro.getPrecio() <= precioFinal)
                .filter( libro -> libro.getPrecio() >= precioInicial )
                .forEach(libro -> System.out.println(libro.toString()));
    }
    @Override
    public void filtrarPorPrecioMayorA  (double precio){
        libreria.Libreria.libros.get(Genero.TERROR).stream()
                .filter(libro -> libro.getPrecio() >precio)
                .forEach(libro -> System.out.println(libro.toString()));
    }
    
    @Override
     public void filtrarLibroPorInicialDeAutor(String inicial){
         libreria.Libreria.libros.get(Genero.TERROR)
                 .stream()
                 .map(libro->libro.getAutor().toUpperCase())
                 .forEach(libro-> System.out.println(libro.toString()));
     }

    public TerrorSubgenero getSubgenero() {
        return subgenero;
    }
        
}

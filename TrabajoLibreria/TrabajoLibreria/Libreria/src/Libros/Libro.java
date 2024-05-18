
package Libros;

import Libros.utils.constants.Genero;
import java.util.ArrayList;
import static libreria.Libreria.usuarios;
import usuarios.Usuario;


public abstract class  Libro {
    private int ID;
    private String titulo;
    private String fechaLanzamiento;
    private String autor;
    private double precio;
    private String editorial;
    private Genero genero;
    private int stock;
   public static int CODIGOLIBRE = 1;
/*Stream: Es una coleccion de datos que nos permite concatenar funciones como : filter*/
    public Libro( String titulo, String fechaLanzamiento, String autor, double precio, String editorial, Genero genero, int stock) {
        this.ID = CODIGOLIBRE;
        this.titulo = titulo;
        this.fechaLanzamiento = fechaLanzamiento;
        this.autor = autor;
        this.precio = precio;
        this.editorial = editorial;
        this.genero = genero;
        this.stock = stock;
        CODIGOLIBRE++;
    }

    public Libro() {
    }
    
    
    @Override
    public String toString(){
        return String.format("Titulo: %s, \n Autor: %s, \n Precio: %.2f \n Genero: %s", titulo, autor, precio, genero.toString());
    }
        
   
    public static void mostrarTodosLosLibros(){
        for (ArrayList<Libro> listaLibros : libreria.Libreria.libros.values()) {
            for(Libro libro: listaLibros){
                System.out.println(libro.toString());
            }
                
            }
    }
    
    public static void mostrarLibrosPorGenero(Genero genero){
        if(genero.equals(Genero.ACCION))
            libreria.Libreria.libros.get(Genero.ACCION).stream()
            .forEach(libro -> System.out.println(libro.toString()));
        if(genero.equals(Genero.COMEDIA))
            libreria.Libreria.libros.get(Genero.COMEDIA).stream()
            .forEach(libro -> System.out.println(libro.toString()));
        if(genero.equals(Genero.TERROR))
            libreria.Libreria.libros.get(Genero.TERROR).stream()
            .forEach(libro -> System.out.println(libro.toString()));
    }
        
    protected abstract void filtrarPorPrecioMayorA(double precio);
    protected abstract void filtrarPorRangoDePrecio(double precioInicial, double precioFinal);
    protected abstract void filtrarLibroPorInicialDeAutor(String inicial);
    protected abstract void filtrarPorEditorial(String editoralBuscada);

    public int getID() {
        return ID;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public double getPrecio() {
        return precio;
    }

    public Genero getGenero() {
        return genero;
    }

    
   
   
}

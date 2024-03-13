
package tarea_8;
import java.util.*;
public class Usuarios {
    private int id;
    private String nombre;
    private int edad;
    private List<Libro> librosRentados;

    public Usuarios(String nombre, int edad) {
        Random rand = new Random();
        this.id = rand.nextInt(1000) + 1;
        this.nombre = nombre;
        this.edad = edad;
        this.librosRentados = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public List<Libro> getLibrosRentados() {
        return librosRentados;
    }

    public void rentarLibro(Libro libro) {
        librosRentados.add(libro);
        System.out.println("El libro " + libro.getNombre() + " ha sido rentado por " + nombre + ".");
    }
}

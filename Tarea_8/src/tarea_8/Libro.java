
package tarea_8;
import java.util.*;
public class Libro {
    private int id;
    private String nombre;
    private String autor;
    private boolean disponible;

    public Libro(String nombre, String autor) {
        Random rand = new Random();
        this.id = rand.nextInt(1000) + 1;
        this.nombre = nombre;
        this.autor = autor;
        this.disponible = true;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAutor() {
        return autor;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}

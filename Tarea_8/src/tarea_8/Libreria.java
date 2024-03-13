/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea_8;
import java.util.*;
public class Libreria {
    
    private List<Usuarios> usuarios = new ArrayList<>();
    private List<Libro> libros = new ArrayList<>();

    

    public void agregarUsuario(Usuarios usuario) {
        usuarios.add(usuario);
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public void rentarLibro(int idUsuario, int idLibro) {
        Usuarios usuarioEncontrado = null;
        for (Usuarios usuario : usuarios) {
            if (usuario.getId() == idUsuario) {
                usuarioEncontrado = usuario;
                break;
            }
        }

        if (usuarioEncontrado == null) {
            System.out.println("Usuario no encontrado.");
            return;
        }

        Libro libroEncontrado = null;
        for (Libro libro : libros) {
            if (libro.getId() == idLibro) {
                libroEncontrado = libro;
                break;
            }
        }

        if (libroEncontrado == null) {
            System.out.println("Libro no encontrado.");
            return;
        }

        if (libroEncontrado.isDisponible()) {
            usuarioEncontrado.rentarLibro(libroEncontrado);
            libroEncontrado.setDisponible(false);
            System.out.println("El libro fue rentado con éxito.");
        } else {
            System.out.println("El libro no está disponible para renta.");
        }
    }

    public void mostrarUsuarios() {
        System.out.println("*** Usuarios ***");
        for (Usuarios usuario : usuarios) {
            System.out.println("Nombre: " + usuario.getNombre() + ", Edad: " + usuario.getEdad() + ", ID: " + usuario.getId());
        }
    }

    public void mostrarUsuariosConLibrosRentados() {
        System.out.println("*** Usuarios con libros rentados ***");
        for (Usuarios usuario : usuarios) {
            if (!usuario.getLibrosRentados().isEmpty()) {
                System.out.println("Nombre: " + usuario.getNombre() + ", Libros rentados:");
                for (Libro libro : usuario.getLibrosRentados()) {
                    System.out.println("- " + libro.getNombre() + " de " + libro.getAutor());
                }
            }
        }
    }

    public void mostrarLibros() {
        System.out.println("*** Libros ***");
        for (Libro libro : libros) {
            System.out.println("Nombre: " + libro.getNombre() + ", Autor: " + libro.getAutor() + ", ID: " + libro.getId());
        }
    }

    public void mostrarLibrosRentados() {
        System.out.println("*** Libros Rentados ***");
        for (Libro libro : libros) {
            if (!libro.isDisponible()) {
                System.out.println("Nombre: " + libro.getNombre() + ", Autor: " + libro.getAutor());
            }
        }
    }

    public void mostrarLibrosNoRentados() {
        System.out.println("*** Libros No Rentados ***");
        for (Libro libro : libros) {
            if (libro.isDisponible()) {
                System.out.println("Nombre: " + libro.getNombre() + ", Autor: " + libro.getAutor());
            }
        }
    }
}

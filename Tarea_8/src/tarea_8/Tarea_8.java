
package tarea_8;
import java.util.*;
public class Tarea_8 {

    public static void main(String[] args) {
        Libreria libreria = new Libreria();
        Usuarios usuario_uno = new Usuarios("Maria Perez", 20);
        Usuarios usuario_dos = new Usuarios("Ara Martinez", 18);

        libreria.agregarUsuario(usuario_uno);
        libreria.agregarUsuario(usuario_dos);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("BIENVENIDO A LA LIBRERIA");
            System.out.println("Elige una opción para continuar");
            System.out.println("1. Añadir usuario");
            System.out.println("2. Añadir libro");
            System.out.println("3. Rentar libro");
            System.out.println("4. Mostrar Usuarios ");
            System.out.println("5. Mostrar Usuarios con libros");
            System.out.println("6. Mostrar libros registrados");
            System.out.println("7. Mostrar libros rentados");
            System.out.println("8. Mostrar libros disponibles");
            System.out.println("9. Salir");
            System.out.print("Ingresa a opción: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.println("\nElegiste la opción 1\n");
                    System.out.print("Ingresa el nombre del usuario: ");
                    String nombreUsuario = scanner.nextLine();
                    System.out.print("Ingresa la edad del usuario: ");
                    int edadUsuario = Integer.parseInt(scanner.nextLine());
                    Usuarios usuario = new Usuarios(nombreUsuario, edadUsuario);
                    libreria.agregarUsuario(usuario);
                    System.out.println("El usuario " + nombreUsuario + " ha sido registrado\n");
                    break;
                case "2":
                    System.out.println("\nElegiste la opción 2\n");
                    System.out.print("Ingresa el nombre del libro: ");
                    String nombreLibro = scanner.nextLine();
                    System.out.print("Ingresa el autor del libro: ");
                    String autorLibro = scanner.nextLine();
                    Libro libro = new Libro(nombreLibro, autorLibro);
                    libreria.agregarLibro(libro);
                    System.out.println("El libro " + nombreLibro + " de autor " + autorLibro + " ha sido registrado\n");
                    break;
                case "3":
                    System.out.println("\nElegiste la opción 3\n");
                    System.out.print("Ingresa el ID del usuario: ");
                    int idUsuario = Integer.parseInt(scanner.nextLine());
                    System.out.print("Ingresa el ID del libro: ");
                    int idLibro = Integer.parseInt(scanner.nextLine());
                    libreria.rentarLibro(idUsuario, idLibro);
                    break;
                case "4":
                    System.out.println("\nElegiste la opción 4\n");
                    libreria.mostrarUsuarios();
                    break;
                case "5":
                    System.out.println("\nElegiste la opción 5\n");
                    libreria.mostrarUsuariosConLibrosRentados();
                    break;
                case "6":
                    System.out.println("\nElegiste la opción 6\n");
                    libreria.mostrarLibros();
                    break;
                case "7":
                    System.out.println("\nElegiste la opción 7\n");
                    libreria.mostrarLibrosRentados();
                    break;
                case "8":
                    System.out.println("\nElegiste la opción 8\n");
                    libreria.mostrarLibrosNoRentados();
                    break;
                case "9":
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, elige una opción válida.");
                    break;
            }
        }
    }
    
}

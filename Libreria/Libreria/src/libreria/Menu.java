package libreria;
/*****Realizar el registro cliente, libros y consualta de clientes y libros.
 --Tratar de almacenar el usuario en sesion en la clase Usuario en sesion y verificar su comportamiento(Si se guarda o no)
 */
import Libros.Libro;
import Libros.LibroAccion;
import Libros.LibroComedia;
import Libros.LibroTerror;
import Libros.utils.constants.Genero;
import java.util.*;
import usuarios.Cliente;
import usuarios.Usuario;
import utils.UsuarioEnSesion;
public class Menu {
    private Libreria libreria = new Libreria();
   // ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    private Scanner leer = new Scanner(System.in);
    public  void iniciarSesion(){
        boolean datosCorrectos = false;
        
        do{
        System.out.println("\n Bienvenido al Sistema de la Biblioteca ");
        
        System.out.println("Pulsa enter para iniciar sesion: ");
        leer.nextLine();
        System.out.print("Ingresa tu usuario: ");
        String usuario = leer.nextLine();
        System.out.print("Ingresa tu contrasena: ");
        String contrasena = leer.nextLine();
        //libreria.verificarInicioSesion(usuario, contrasena);
        Usuario usuarioActual = libreria.verificarInicioSesion(usuario, contrasena);
        if(usuarioActual!= null){
            datosCorrectos = true;
          
           UsuarioEnSesion.obtenerInstancia().setUsuarioActual(usuarioActual);
           
            seleccionarMenu();
            
        }
        else{
            System.out.println("Datos incorrectos, intentalo de nuevo.");
        }
        }while(!datosCorrectos);
        
    }
    
    public void seleccionarMenu(){
        Usuario usuario = UsuarioEnSesion.obtenerInstancia().getUsuarioActual();
        switch(usuario.getRol()){
            case CLIENTE: mostrarMenuCliente();
                break;
            case ASISTENTE : mostrarMenuAsistente();
                break;
            case GERENTE: mostrarMenuGerente();
                break;
                
                /*" -> funciones landa  */
            }
    }
    
    private void mostrarMenuCliente(){
        System.out.println("***Bienvenido al menu del cliente***");
        System.out.println("1. Ver libros");
        System.out.println("2. Consualtar rentas");
        System.out.println("3. Mostrar mis datos");
         System.out.println("4. Editar mi informacion");
        System.out.println("5. Cerrar sesion");
        System.out.println("Ingresa la opcion: ");
        int opcion = leer.nextInt();
        do{
        switch(opcion){
            case 1: 
                break;
            case 2: 
                break;
            case 3: 
                break;
           case 4: 
                break;
            case 5: 
                System.out.println("Cerrando sesion...");
                UsuarioEnSesion.obtenerInstancia().cerrarSesion();
                this.iniciarSesion();
                break;
            }
        }while(opcion!=5);
    }
    private void mostrarMenuAsistente(){
        int opcion;
        do{
        System.out.println("***Bienvenido al menu del asistente***");
        System.out.println("1. Registrar libros");
        System.out.println("2. Registrar clientes");
        System.out.println("3. Ver libros");
        System.out.println("4. Ver clientes");
        System.out.println("5. Modificar libros");
        System.out.println("6. Modificar clientes");
        System.out.println("7. Consultar rentas");
        System.out.println("8. Eliminar clientes");
        System.out.println("9. Eliminar libros");
        System.out.println("10. Cerrar sesion");
        System.out.println("Ingresa la opcion: ");
        opcion = leer.nextInt();
        switch(opcion){
            case 1: 
                this.menuRegistrarLibro();
                break;
            case 2: 
                libreria.registrarCliente();
                break;
            case 3: 
                this.mostrarLibros();
                break;
            case 4: 
                libreria.mostrarCliente();
                break;
            case 5: 
                break;
            case 6: 
                break;
            case 7: 
                break;
            case 8: 
                break;
            case 9: 
                System.out.println("***Eliminemos un libro***");
                this.eliminarLibros();
                
                break;
            case 10: 
                System.out.println("Cerrando sesion...");
                UsuarioEnSesion.obtenerInstancia().cerrarSesion();
                this.iniciarSesion();
                break;
            }
        }while(opcion!=10);  
            
    }
    
    private void eliminarLibros(){
        Scanner scanner = new Scanner(System.in);        
        int opcionMenuRegistrarLibro = 0;        
        boolean esDatoValido = false; 
        do {                        
            System.out.println("Ingresa el tipo de libro que deseas eliminar");           
            System.out.println("1. Acción");            
            System.out.println("2. Comedia");            
            System.out.println("3. Terror");            
            System.out.println("4. Salir");            
            while (!esDatoValido) {                
                try {                    
                    opcionMenuRegistrarLibro = scanner.nextInt();                    
                    if (opcionMenuRegistrarLibro > 4 || opcionMenuRegistrarLibro < 1) {          
                        throw new InputMismatchException();                    }                  
                        esDatoValido = true;                
                } catch (InputMismatchException error) {                   
                    System.out.println("Ingresaste un valor incorrecto, intenta de nuevo");                
                } finally {                    
                    scanner.nextLine();                
                }            
            }            
            esDatoValido = false;            
            switch (opcionMenuRegistrarLibro) {               
                case 1:                    
                    System.out.println("Accion");  
                    LibroAccion.eliminarLibroAccion();
                    break;                
                case 2:                    
                    System.out.println("Comedia"); 
                    LibroComedia.eliminarLibroComedia();
                    break;                
                case 3:                    
                    System.out.println("Terror");  
                    LibroTerror.eliminarLibroTerror();
                    break;            
            }        
        } 
    while(opcionMenuRegistrarLibro != 4); 
    }
    private void menuRegistrarLibro() {        
        Scanner scanner = new Scanner(System.in);        
        int opcionMenuRegistrarLibro = 0;        
        boolean esDatoValido = false;        
        do {            
            System.out.println("\nRegistrar libro");            
            System.out.println("Ingresa el tipo de libro que deseas registrar");           
            System.out.println("1. Acción");            
            System.out.println("2. Comedia");            
            System.out.println("3. Terror");            
            System.out.println("4. Salir");            
            while (!esDatoValido) {                
                try {                    
                    opcionMenuRegistrarLibro = scanner.nextInt();                    
                    if (opcionMenuRegistrarLibro > 4 || opcionMenuRegistrarLibro < 1) {          
                        throw new InputMismatchException();                    }                  
                        esDatoValido = true;                
                } catch (InputMismatchException error) {                   
                    System.out.println("Ingresaste un valor incorrecto, intenta de nuevo");                
                } finally {                    
                    scanner.nextLine();                
                }            
            }            
            esDatoValido = false;            
            switch (opcionMenuRegistrarLibro) {               
                case 1:                    
                    System.out.println("Accion"); 
                    LibroAccion.registrarLibroAccion();
                    break;                
                case 2:                    
                    System.out.println("Comedia");  
                    LibroComedia.registrarLibroComedia();
                    break;                
                case 3:                    
                    System.out.println("Terror");  
                    LibroTerror.registrarLibroTerror();
                    break;            
            }        
        } 
    while(opcionMenuRegistrarLibro != 4);    
    }
    private void mostrarMenuGerente(){
        int opcion;
        do{
        System.out.println("***Bienvenido al menu del asistente***");
        System.out.println("1. Registrar libros");
        System.out.println("2. Registrar clientes");
        System.out.println("3. Registrar Asistente");
        System.out.println("4. Registrar Gerente");
        System.out.println("5. Ver libros");
        System.out.println("6. Ver clientes");
        System.out.println("7. Ver asistente");
        System.out.println("8. Ver gerentes");
        System.out.println("9. Modificar clientes");
        System.out.println("10. Modificar libros");
        System.out.println("11. Modificar asistente");
        System.out.println("12. Crear rentas");
        System.out.println("13. Consultar rentas");
        System.out.println("14. Eliminar clientes");
        System.out.println("15. Eliminar libros");
        System.out.println("16. Eliminar Asistente");
        System.out.println("17. Eliminar Gerente");
        System.out.println("18. Cerrar sesion");
        System.out.println("Ingresa la opcion: ");
        opcion = leer.nextInt();
        switch(opcion){
            case 1: 
                break;
            case 2: 
                libreria.registrarCliente();
                break;
            case 3: 
                libreria.registrarAsistente();
                break;
            case 4: 
                libreria.registrarGerente();
                break;
            case 5: 
                
                break;
            case 6: 
                libreria.mostrarCliente();
                break;
            case 7: 
                libreria.mostrarAsistentes();
                break;
            case 8:
                libreria.mostrarGerentes();
                break;
            case 9: 
                break;
            case 10: 
            break;
            case 11: 
            break;
            case 12: 
                
            break;
            case 13: 
            break;
            case 14:
                libreria.eliminarCliente();
            break;
           case 15: 
            break;
            case 16:
                libreria.eliminarAsistente();
            break;
           case 17:
               libreria.eliminarGerente();
            break;
            case 18: 
                System.out.println("Cerrando sesion...");
                UsuarioEnSesion.obtenerInstancia().cerrarSesion();
                this.iniciarSesion();
                break;
            }
        }while(opcion!=15);  
            
    }
  
    
    public void mostrarLibros(){       
        Scanner scanner = new Scanner(System.in);        
        int opcionMenuRegistrarLibro = 0;        
        boolean esDatoValido = false;        
        do {            
            System.out.println("\n Mostrar libros");            
            System.out.println("Ingresa el genero de libro que deseas ver");           
            System.out.println("1. Acción");            
            System.out.println("2. Comedia");            
            System.out.println("3. Terror");            
            System.out.println("4. Salir");            
            while (!esDatoValido) {                
                try {                    
                    opcionMenuRegistrarLibro = scanner.nextInt();                    
                    if (opcionMenuRegistrarLibro > 4 || opcionMenuRegistrarLibro < 1) {          
                        throw new InputMismatchException();                    }                  
                        esDatoValido = true;                
                } catch (InputMismatchException error) {                   
                    System.out.println("Ingresaste un valor incorrecto, intenta de nuevo");                
                } finally {                    
                    scanner.nextLine();                
                }            
            }            
            esDatoValido = false;            
            switch (opcionMenuRegistrarLibro) {               
                case 1:                    
                    System.out.println("Accion");  
                    LibroAccion.mostrarLibroAccion();
                    break;                
                case 2:                    
                    System.out.println("Comedia");   
                    LibroComedia.mostrarLibroComedia();
                    break;                
                case 3:                    
                    System.out.println("Terror");  
                    LibroTerror.mostrarLibroTerror();
                    break;            
            }        
        } 
    while(opcionMenuRegistrarLibro != 4);    
    }
    
    
    
}

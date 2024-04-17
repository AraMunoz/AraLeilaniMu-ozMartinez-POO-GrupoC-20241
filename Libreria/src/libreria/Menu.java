package libreria;
/*****Realizar el registro cliente, libros y consualta de clientes y libros.
 --Tratar de almacenar el usuario en sesion en la clase Usuario en sesion y verificar su comportamiento(Si se guarda o no)
 */
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
                break;
            case 2: 
                libreria.registrarCliente();
                break;
            case 3: 
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
                break;
            case 10: 
                System.out.println("Cerrando sesion...");
                UsuarioEnSesion.obtenerInstancia().cerrarSesion();
                this.iniciarSesion();
                break;
            }
        }while(opcion!=10);  
            
    }
    private void mostrarMenuGerente(){
        int opcion;
        do{
        System.out.println("***Bienvenido al menu del asistente***");
        System.out.println("1. Registrar libros");
        System.out.println("2. Registrar clientes");
        System.out.println("3. Registrar Asistente");
        System.out.println("4. Ver libros");
        System.out.println("5. Ver clientes");
        System.out.println("6. Ver asistente");
        System.out.println("7. Modificar clientes");
        System.out.println("8. Modificar libros");
        System.out.println("9. Modificar asistente");
        System.out.println("10. Crear rentas");
        System.out.println("11. Consultar rentas");
        System.out.println("12. Eliminar clientes");
        System.out.println("13. Eliminar libros");
        System.out.println("14. Eliminar Asistente");
        System.out.println("15. Cerrar sesion");
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
                break;
            case 5: 
                libreria.mostrarCliente();
                break;
            case 6: 
                libreria.mostrarAsistentes();
                break;
            case 7: 
                break;
            case 8: 
                break;
            case 9: 
                break;
            case 10: 
            break;
            case 11: 
            break;
            case 12: 
                libreria.eliminarCliente();
            break;
            case 13: 
            break;
            case 14:
                libreria.eliminarAsistente();
            break;
            case 15: 
                System.out.println("Cerrando sesion...");
                UsuarioEnSesion.obtenerInstancia().cerrarSesion();
                this.iniciarSesion();
                break;
            }
        }while(opcion!=15);  
            
    }
    
    
    
}

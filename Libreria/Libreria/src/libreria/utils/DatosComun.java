
package libreria.utils;

import java.util.ArrayList;
import java.util.Scanner;
import static libreria.Libreria.usuarios;
import usuarios.Usuario;
import usuarios.utils.Rol;

public class DatosComun {
    
    public   static String [] registrarUsuario(Rol rol){
        Scanner leer = new Scanner (System.in);

        String rolUsuario = rol == Rol.CLIENTE ? "Cliente" : rol == Rol.ASISTENTE ?"Asistente" : "Gerente";
        System.out.println(String.format("Bienvenido, comencemos el registro del %s", rolUsuario));
        
        String datos[] = new String[5];
        System.out.print("Ingresa el nombre:: ");
        String nombre = leer.nextLine();
        datos[0]=nombre;
        System.out.print("Ingresa el apellido: ");
        String apellido = leer.nextLine();
        datos[1]=apellido;
        String telefono = registrarTelefonoUsuario(rol);
        datos[2]=telefono;
        String nombreUsuario = registrarNombreUsuario(rol);
        datos[3]=nombreUsuario;
        System.out.print("Ingresa una contrasena: ");
        String contrasena = leer.nextLine();
        datos[4]=contrasena;
        
        return datos;
    }
    
    
    
    private static String registrarTelefonoUsuario(Rol rol){
        Scanner leer = new Scanner (System.in);

        boolean telefonoExistente = true;
        String telefono;
        do{
        System.out.print("Ingresa el telefono del cliente: ");
         telefono = leer.nextLine();
         telefonoExistente = false;
         if(usuarios!= null && usuarios.containsKey(rol) && !usuarios.get(rol).isEmpty()){
             ArrayList<Usuario> user = usuarios.get(rol);
            for(Usuario usuario: user){
            if(usuario.getTelefono().equals(telefono)){
                 telefonoExistente=true;
            }
            
            if(telefonoExistente){
                System.out.println("El telefono ingresado ya esta registrado. Intenta de nuevo. ");
                break;
            }
        }
         }
         
        
        
        }while(telefonoExistente);
        
        return telefono;
    }
    
    
    
    private static String registrarNombreUsuario(Rol rol){
        Scanner leer = new Scanner (System.in);

         boolean nombreUusarioExistente = true;
         String nombreUsuario;
        do{
           
            System.out.println("Ingresa un nombre de usuario: ");
             nombreUsuario = leer.nextLine();
            nombreUusarioExistente = false;
            if(usuarios!= null && usuarios.containsKey(rol) && !usuarios.get(rol).isEmpty()){
            ArrayList<Usuario> user = usuarios.get(rol);
            for(Usuario usuario: user){
            if(usuario.getNombreUsuario().equals(nombreUsuario)){
                 nombreUusarioExistente=true;
                 break;
            }
            if( nombreUusarioExistente)
                System.out.println("El nombre de usuario ingresado ya esta registrado. Intenta de nuevo. ");
               
            
        }
            }
   
    }while(nombreUusarioExistente);
       
        return nombreUsuario;
  }
}

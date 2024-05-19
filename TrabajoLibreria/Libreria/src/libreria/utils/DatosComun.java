
package libreria.utils;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import static libreria.Libreria.usuarios;
import usuarios.Usuario;
import usuarios.utils.Rol;

public class DatosComun {
    
    public   static String [] registrarUsuario(Rol rol){
        Scanner leer = new Scanner (System.in);

        String rolUsuario = rol == Rol.CLIENTE ? "Cliente" : rol == Rol.ASISTENTE ?"Asistente" : "Gerente";
        System.out.println(String.format("Bienvenido, comencemos el registro del %s", rolUsuario));
        
        String datos[] = new String[6];
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
        System.out.print("Ingresa tu año de nacimiento: ");
        int YYYY = leer.nextInt();
        System.out.print("Ingresa tu mes de nacimiento: ");
        int MM = leer.nextInt();
        System.out.print("Ingresa tu dia de nacimiento: ");
        int dd = leer.nextInt();
        LocalDate fechaNacimiento = LocalDate.of(YYYY, MM, dd);
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        String fecha = fechaNacimiento.format(pattern);
        datos[5] = fecha;

        leer.nextLine();
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

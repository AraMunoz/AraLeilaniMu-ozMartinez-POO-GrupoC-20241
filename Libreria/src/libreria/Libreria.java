package libreria;

import java.util.ArrayList;
import java.util.Scanner;
import usuarios.Asistente;
import usuarios.Cliente;
import usuarios.Gerente;
import usuarios.Usuario;
import usuarios.utils.Rol;
import utils.UsuarioEnSesion;


public class Libreria {
    Scanner leer = new Scanner(System.in);
    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    
    Libreria(){
        Gerente gerente = new Gerente ( 250000.98, "IMKLOP09","Leilani",  "Martinez",  "4434851024", "LeilanMartinez",  "Www90");
        usuarios.add(gerente);
    }
    
    
    public Usuario verificarInicioSesion(String nombreUsuario, String contrasena){
        for(Usuario usuario: usuarios){
            if(usuario.getNombreUsuario().equals(nombreUsuario)){
                if(usuario.getContrasena().equals(contrasena)){
                    return usuario;
                }
                    
                
                return null;
            }
          
        }
        return null;
    }
    
    public String [] registrarUsuario(){
        String datos[] = new String[5];
        System.out.print("Ingresa el nombre:: ");
        String nombre = leer.nextLine();
        datos[0]=nombre;
        System.out.print("Ingresa el apellido: ");
        String apellido = leer.nextLine();
        datos[1]=apellido;
        String telefono = registrarTelefonoUsuario();
        datos[2]=telefono;
        String nombreUsuario = registrarNombreUsuario();
        datos[3]=nombreUsuario;
        System.out.print("Ingresa una contrasena: ");
        String contrasena = leer.nextLine();
        datos[4]=contrasena;
        return datos;
    }
    public void registrarCliente(){
        System.out.println("**Comencemos con el registro de Cliente**");
        String datos[] = registrarUsuario();
        String nombre = datos[0];
        String apellido = datos[1];
        String telefono = datos[2];
        String nombreUsuario = datos[3]; 
        String contrasena = datos[4];
        Cliente cliente = new Cliente ( nombre,  apellido,  telefono, nombreUsuario,  contrasena);
        System.out.println("El cliente ha sido registrado correctamente. ");
        usuarios.add(cliente);
        leer.nextLine();
    }
    
    public void registrarAsistente(){
        System.out.println("**Comencemos con el registro de Asistente**");
        String datos[] = registrarUsuario();
        String nombre = datos[0];
        String apellido = datos[1];
        String telefono = datos[2];
        String nombreUsuario = datos[3]; 
        String contrasena = datos[4];
        System.out.print("Ingresa el RFC: ");
        String rfc = leer.nextLine();
        System.out.print("Ingresa el sueldo: ");
        Double sueldo = leer.nextDouble();
        Asistente asistente = new Asistente ( sueldo, rfc,nombre,  apellido,  telefono, nombreUsuario,  contrasena);
        System.out.println("El asistente ha sido registrado correctamente. ");
        usuarios.add(asistente);
        leer.nextLine();
    }
    
    public void registrarGerente(){
        System.out.println("**Comencemos con el registro de Gerente**");
        String datos[] = registrarUsuario();
        String nombre = datos[0];
        String apellido = datos[1];
        String telefono = datos[2];
        String nombreUsuario = datos[3]; 
        String contrasena = datos[4];
        System.out.print("Ingresa la INE: ");
        String ine = leer.nextLine();
        System.out.print("Ingresa el sueldo: ");
        Double sueldo = leer.nextDouble();
        Gerente gerente = new Gerente ( sueldo, ine,nombre,  apellido,  telefono, nombreUsuario,  contrasena);
        
        System.out.println("El gerente ha sido registrado correctamente. ");
        usuarios.add(gerente);
        leer.nextLine();
    }
    
    public void mostrarCliente(){
        System.out.println("**Cliente**");
      
            for(Usuario usuario: usuarios){  
              if(usuario.getRol() == Rol.CLIENTE){
                Cliente cliente = (Cliente)usuario;
                System.out.println(cliente.toString());
            }
              
                
        }
        
        
    }
    
    public void mostrarAsistentes(){
        System.out.println("**Asistentes**");
      
            for(Usuario usuario: usuarios){  
              if(usuario.getRol() == Rol.ASISTENTE){
                Asistente asistente = (Asistente)usuario;
                System.out.println(asistente.toString());
            }
              
                
        }
        
        
    }
    public void mostrarGerentes(){
        System.out.println("**Gerentes**");
      
            for(Usuario usuario: usuarios){  
              if(usuario.getRol() == Rol.GERENTE){
                Gerente gerente = (Gerente)usuario;
                System.out.println(gerente.toString());
            }
              
                
        }
        
        
    }
        
    private String registrarTelefonoUsuario(){
        boolean telefonoExistente = true;
        String telefono;
        do{
        System.out.print("Ingresa el telefono del cliente: ");
         telefono = leer.nextLine();
         telefonoExistente = false;
        for(Usuario usuario: usuarios){
            if(usuario.getTelefono().equals(telefono)){
                 telefonoExistente=true;
            }
            
            if( telefonoExistente){
                System.out.println("El telefono ingresado ya esta registrado. Intenta de nuevo. ");
                break;
            }
        }
        
        }while(telefonoExistente);
        
        return telefono;
    }
    
    
    
    private String registrarNombreUsuario(){
         boolean nombreUusarioExistente = true;
         String nombreUsuario;
        do{
           
            System.out.println("Ingresa un nombre de usuario: ");
             nombreUsuario = leer.nextLine();
            nombreUusarioExistente = false;
            for(Usuario usuario: usuarios){
            if(usuario.getNombreUsuario().equals(nombreUsuario)){
                 nombreUusarioExistente=true;
                 break;
            }
            if( nombreUusarioExistente)
                System.out.println("El nombre de usuario ingresado ya esta registrado. Intenta de nuevo. ");
               
            
        }
        
   
    }while(nombreUusarioExistente);
       
        return nombreUsuario;
  }
    
    
    public void eliminarCliente(){
        if(UsuarioEnSesion.obtenerInstancia().getUsuarioActual().getRol()==Rol.ASISTENTE || UsuarioEnSesion.obtenerInstancia().getUsuarioActual().getRol()==Rol.GERENTE){
            System.out.print("Ingresa el nombre de usuario a eliminar:  ");
            String usuarioEliminar = leer.nextLine();
            int i=0;
            for(Usuario usuario: usuarios){
                if(usuario.getNombreUsuario().equals(usuarioEliminar)){
                    usuarios.remove(i);
                    System.out.println("El usuario ha sido eliminado");
                    break;
                }
                i++;
            }
        }
        else{
            System.out.println("No tienes permiso asignado para eliminar clientes.");
        }
        
    }
    
    public void eliminarAsistente(){
        if( UsuarioEnSesion.obtenerInstancia().getUsuarioActual().getRol()==Rol.GERENTE){
            System.out.print("Ingresa el nombre de usuario a eliminar:  ");
            String usuarioEliminar = leer.nextLine();
            int i=0;
            for(Usuario usuario: usuarios){
                if(usuario.getNombreUsuario().equals(usuarioEliminar)){
                    usuarios.remove(i);
                    System.out.println("El usuario ha sido eliminado");
                    break;
                }
                i++;
            }
        }
        else{
            System.out.println("No tienes permiso asignado para eliminar asistentes.");
        }
        
    }
    public void eliminarGerente(){
        if(UsuarioEnSesion.obtenerInstancia().getUsuarioActual().getRol()==Rol.GERENTE){
            System.out.print("Ingresa el nombre de usuario a eliminar:  ");
            String usuarioEliminar = leer.nextLine();
            int i=0;
            for(Usuario usuario: usuarios){
                if(usuario.getNombreUsuario().equals(usuarioEliminar)){
                    usuarios.remove(i);
                    System.out.println("El usuario ha sido eliminado");
                    break;
                }
                i++;
            }
        }
        else{
            System.out.println("No tienes permiso asignado para eliminar gerentes.");
        }
        
    }
}

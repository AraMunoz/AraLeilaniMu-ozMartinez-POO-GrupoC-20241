package libreria;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import usuarios.Asistente;
import usuarios.Cliente;
import usuarios.Gerente;
import usuarios.Usuario;
import usuarios.utils.Rol;
import utils.UsuarioEnSesion;


public class Libreria {
    Scanner leer = new Scanner(System.in);
    //private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    private HashMap<Rol, ArrayList<Usuario>> usuarios= new HashMap<Rol, ArrayList<Usuario>>();
   
    Libreria(){
        Gerente gerente = new Gerente ( 250000.98, "IMKLOP09","Leilani",  "Martinez",  "4434851024", "LeilanMartinez",  "Www90");
        if(!usuarios.containsKey(Rol.GERENTE)){
            usuarios.put(Rol.GERENTE, new ArrayList<Usuario>());
        }
        usuarios.get(Rol.GERENTE).add(gerente);
       
    }
    
    
    public Usuario verificarInicioSesion(String nombreUsuario, String contrasena){
        for (ArrayList<Usuario> lista : usuarios.values()) {
            for (Usuario usuario : lista) {
                if(usuario.getNombreUsuario().equals(nombreUsuario)){
                if(usuario.getContrasena().equals(contrasena)){
                    return usuario;
                }
                    
                
                return null;
            }
            }
        }
        
        
        
        /*for(Usuario usuario: usuarios){
            if(usuario.getNombreUsuario().equals(nombreUsuario)){
                if(usuario.getContrasena().equals(contrasena)){
                    return usuario;
                }
                    
                
                return null;
            }
          
        }*/
        return null;
    }
    
    public String [] registrarUsuario(Rol rol){
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
    public void registrarCliente(){
        String datos[] = registrarUsuario(Rol.CLIENTE);
        String nombre = datos[0];
        String apellido = datos[1];
        String telefono = datos[2];
        String nombreUsuario = datos[3]; 
        String contrasena = datos[4];
        Cliente cliente = new Cliente ( nombre,  apellido,  telefono, nombreUsuario,  contrasena);
        
       // usuarios.add(cliente);
        
        if(!usuarios.containsKey(Rol.CLIENTE)){
            usuarios.put(Rol.CLIENTE, new ArrayList<Usuario>());
        }
        usuarios.get(Rol.CLIENTE).add(cliente);
        System.out.println("El cliente ha sido registrado correctamente. ");
        leer.nextLine();
    }
    
    public void registrarAsistente(){
        String datos[] = registrarUsuario(Rol.ASISTENTE);
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
        if(!usuarios.containsKey(Rol.ASISTENTE)){
            usuarios.put(Rol.ASISTENTE, new ArrayList<Usuario>());
        }
        usuarios.get(Rol.ASISTENTE).add(asistente);
        leer.nextLine();
    }
    
    public void registrarGerente(){
        String datos[] = registrarUsuario(Rol.GERENTE);
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
       if(!usuarios.containsKey(Rol.GERENTE)){
            usuarios.put(Rol.GERENTE, new ArrayList<Usuario>());
        }
        usuarios.get(Rol.GERENTE).add(gerente);
        leer.nextLine();
    }
    
    public void mostrarCliente(){
        System.out.println("**Cliente**");
            
            for(Usuario usuario: usuarios.get(Rol.CLIENTE)){  
              if(usuario.getRol() == Rol.CLIENTE){
                Cliente cliente = (Cliente)usuario;
                System.out.println(cliente.toString());
            }
              
                
        }
        
        
    }
    
    public void mostrarAsistentes(){
        System.out.println("**Asistentes**");
      
            for(Usuario usuario: usuarios.get(Rol.ASISTENTE)){  
                Asistente asistente = (Asistente)usuario;
                System.out.println(asistente.toString()); 
        }
        
        
    }
    public void mostrarGerentes(){
        System.out.println("**Gerentes**");
      
            for(Usuario usuario: usuarios.get(Rol.GERENTE)){  
                Gerente gerente = (Gerente)usuario;
                System.out.println(gerente.toString());        
        }
        
        
    }
        
    private String registrarTelefonoUsuario(Rol rol){
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
    
    
    
    private String registrarNombreUsuario(Rol rol){
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
    
    
    public void eliminarCliente(){
        if(UsuarioEnSesion.obtenerInstancia().getUsuarioActual().getRol()==Rol.ASISTENTE || UsuarioEnSesion.obtenerInstancia().getUsuarioActual().getRol()==Rol.GERENTE){
            System.out.print("Ingresa el nombre de usuario a eliminar:  ");
            String usuarioEliminar = leer.nextLine();
            
            ArrayList<Usuario> clientes = usuarios.get(Rol.CLIENTE);
            if (clientes != null) {
            boolean usuarioEncontrado = false;
            for (int i = 0; i < clientes.size(); i++) {
                Usuario usuario = clientes.get(i);
                if (usuario.getNombreUsuario().equals(usuarioEliminar)) {
                    clientes.remove(i);
                    usuarioEncontrado = true;
                    System.out.println("El usuario ha sido eliminado");
                    break;
                }
            }
            if (!usuarioEncontrado) {
                System.out.println("No se encontró ningún usuario con el nombre especificado.");
            }
        } else {
            System.out.println("No hay clientes registrados en la librería.");
        }
    } else {
        System.out.println("No tienes permiso asignado para eliminar clientes.");
    }
            
       
        
    }
    
    public void eliminarAsistente(){
        if( UsuarioEnSesion.obtenerInstancia().getUsuarioActual().getRol()==Rol.GERENTE){
            System.out.print("Ingresa el nombre de usuario a eliminar:  ");
            String usuarioEliminar = leer.nextLine();
            ArrayList<Usuario> asistentes = usuarios.get(Rol.ASISTENTE);
            
            if (asistentes != null) {
            boolean usuarioEncontrado = false;
            for (int i = 0; i < asistentes.size(); i++) {
                Usuario usuario = asistentes.get(i);
                if (usuario.getNombreUsuario().equals(usuarioEliminar)) {
                    asistentes.remove(i);
                    usuarioEncontrado = true;
                    System.out.println("El usuario ha sido eliminado");
                    break;
                }
            }
            if (!usuarioEncontrado) {
                System.out.println("No se encontró ningún usuario con el nombre especificado.");
            }
        } else {
            System.out.println("No hay asistentes registrados en la librería.");
        }
    } else {
        System.out.println("No tienes permiso asignado para eliminar asistentes.");
    }
            
       
    }
    public void eliminarGerente(){
        if(UsuarioEnSesion.obtenerInstancia().getUsuarioActual().getRol()==Rol.GERENTE){
            System.out.print("Ingresa el nombre de usuario a eliminar:  ");
            String usuarioEliminar = leer.nextLine();
       
            ArrayList<Usuario> gerentes = usuarios.get(Rol.GERENTE);
            if (gerentes != null) {
            boolean usuarioEncontrado = false;
            for (int i = 0; i < gerentes.size(); i++) {
                Usuario usuario = gerentes.get(i);
                if (usuario.getNombreUsuario().equals(usuarioEliminar)) {
                    gerentes.remove(i);
                    usuarioEncontrado = true;
                    System.out.println("El usuario ha sido eliminado");
                    break;
                }
            }
            if (!usuarioEncontrado) {
                System.out.println("No se encontró ningún usuario con el nombre especificado.");
            }
        } else {
            System.out.println("No hay gerentes registrados en la librería.");
        }
    } else {
        System.out.println("No tienes permiso asignado para eliminar gerentes.");
    }
            
       
    }
    
    
    
    /*HasMap
    Tambien llamado hast table o hash map o hash set.
    Sirve para buscar un elemento y encontrarlo de manera rapida. Se le proporsiona una llave (Key) y por medio de esta accede al elemento. 
    
    */
    
}

package libreria;
/*HasMap
    Tambien llamado hast table o hash map o hash set.
    Sirve para buscar un elemento y encontrarlo de manera rapida. Se le proporsiona una llave (Key) y por medio de esta accede al elemento. 
    
    */
import java.time.LocalDate;
import java.time.Month;
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
import libreria.utils.DatosComun;

public class Libreria {
    Scanner leer = new Scanner(System.in);
    //private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    public static final HashMap<Rol, ArrayList<Usuario>> usuarios = new HashMap<Rol, ArrayList<Usuario>>(); //para poder acceder a este desde otras clases y que no se cambie su valor.
   
    Libreria(){
        Gerente gerente = new Gerente ( 250000.98, "IMKLOP09","Leilani",  "Martinez",  "4434851024", "LeilanMartinez",  "Www90", String.format("2000, 04, 20"));
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
   
     public void registrarCliente(){
        Cliente.registrarCliente();
    }
    
    public void mostrarCliente(){
       Cliente.mostrarCliente();
    }
    
    
     public void eliminarCliente(){
        Cliente.eliminarCliente();
    }
     
     
      
    public void registrarAsistente(){
        Asistente.registrarAsistente();
    }
    
     public void mostrarAsistentes(){
       Asistente.mostrarAsistentes();
        
    }
    
    
     public void eliminarAsistente(){
        Asistente.eliminarAsistente();
       
    }
     
     
     
    public void registrarGerente(){
        Gerente.registrarGerente();
    }
   
    public void mostrarGerentes(){
        Gerente.mostrarGerentes();
    }
  
   
    public void eliminarGerente(){
       Gerente.eliminarGerente();
    }
     
    
    
}

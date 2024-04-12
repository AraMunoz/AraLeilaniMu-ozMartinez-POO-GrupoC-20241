package libreria;

import java.util.ArrayList;
import usuarios.Usuario;


public class Libreria {
    
    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    
    public Usuario verificarInicioSesion(String nombreUsuario, String contrasena){
        for(Usuario usuario: usuarios){
            if(usuario.getNombreUsuario().equals(nombreUsuario)){
                if(usuario.getContrasena().equals(contrasena))
                    return usuario;
                
                return null;
            }
          
        }
        return null;
    }
    
    
}

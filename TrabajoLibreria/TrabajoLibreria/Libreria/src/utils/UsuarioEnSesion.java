
package utils;

import usuarios.Usuario;


/* Proceso 1:
        Iniciar sesion:
          Validamos sus datos: 
            1. Si todo sale correcto:
               mandamos llamar a usuarioEnSesion
                UsuarioEnSesion.setUusarioActual(usuario)
            2. Si no devolvemos un error

Editar datos: 
usuario = UsuarioEnSesion.obtenerInstancia()
Login
*/
public class UsuarioEnSesion {
    static UsuarioEnSesion instancia;

   
    private Usuario usuarioActual;
    
    private UsuarioEnSesion(){}
    
    public static UsuarioEnSesion obtenerInstancia(){
        if(instancia==null){
            instancia=new UsuarioEnSesion();
        }
        return instancia;
    }
    
    public Usuario getUsuarioActual(){
        return usuarioActual;
    }
    
    public  void setUsuarioActual(Usuario usuarioActual){
        this.usuarioActual = usuarioActual;
    }
    
    public boolean hayUsuarioEnSesion(){
        return usuarioActual!=null;
    }
    
    public void cerrarSesion(){
        instancia = null;
        usuarioActual = null;
    }
}

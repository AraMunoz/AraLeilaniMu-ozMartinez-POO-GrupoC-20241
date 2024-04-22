
package usuarios;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import libreria.Libreria;
import static libreria.Libreria.usuarios;
import libreria.utils.DatosComun;
import usuarios.utils.Rol;
import utils.UsuarioEnSesion;

public class  Cliente extends Usuario {
    Scanner leer = new Scanner(System.in);
    private LocalDate fecha_Union;
    
    public Cliente(String nombre, String apellido, String telefono,String nombreUsuario, String contrasena) {
        super(nombre, apellido, telefono, Rol.CLIENTE, nombreUsuario, contrasena);
        this.fecha_Union=LocalDate.now(); //Asigna la fecha del dia actual.
    }
    
//    @Override //Spbreescritura de metodos.
//   public String mostrarInfo(){
//       return String.format("%s, fecha de registro: %s", super.mostrarInfo(), fecha_Union);
//   }
    
//    public String toString(){
//        return String.format("ID: %d, Nombre completo %s %s, telefono: %s, rol: %s",
//                super.getId(), super.getNombre(), super.getApellido(), super.getTelefono(), super.getRol());
//    }
    @Override
    public String toString (){
      return String.format("%s, \n fecha de registro: %s", super.toString(), fecha_Union);
  }
    
    
    
    public static void registrarCliente(){
        Scanner leer = new Scanner(System.in);
        String datos[] = DatosComun.registrarUsuario(Rol.CLIENTE);
        String nombre = datos[0];
        String apellido = datos[1];
        String telefono = datos[2];
        String nombreUsuario = datos[3]; 
        String contrasena = datos[4];
        Cliente cliente = new Cliente ( nombre,  apellido,  telefono, nombreUsuario,  contrasena);
        
       // usuarios.add(cliente);
        
        if(!Libreria.usuarios.containsKey(Rol.CLIENTE)){
            Libreria.usuarios.put(Rol.CLIENTE, new ArrayList<Usuario>());
        }
        Libreria.usuarios.get(Rol.CLIENTE).add(cliente);
        System.out.println("El cliente ha sido registrado correctamente. ");
        leer.nextLine();
    }
    
    public static void mostrarCliente(){
        System.out.println("**Cliente**");
            
            for(Usuario usuario: usuarios.get(Rol.CLIENTE)){  
              if(usuario.getRol() == Rol.CLIENTE){
                Cliente cliente = (Cliente)usuario;
                System.out.println(cliente.toString());
            }
              
                
        }
        
        
    }
    
    
     public static void eliminarCliente(){
        Scanner leer = new Scanner(System.in);
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
     
    
}


package usuarios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import static libreria.Libreria.usuarios;

import com.google.gson.annotations.Expose;
import libreria.Libreria;
import libreria.utils.DatosComun;
import usuarios.utils.Rol;
import utils.UsuarioEnSesion;

public class Asistente extends Usuario implements EmpleadoUtils{
    @Expose(serialize = false, deserialize = false)
    private Scanner leer = new Scanner(System.in);
    @Expose
    private Double sueldo;
    @Expose
    private LocalDate fechaInicio;
    @Expose
    private String RFC;
   
    public Asistente(Double sueldo, String RFC, String nombre, String apellido, String telefono,String nombreUsuario, String contrasena, String fechaNacimiento) {
        super(nombre, apellido, telefono, Rol.ASISTENTE,nombreUsuario, contrasena, fechaNacimiento);
        this.sueldo = sueldo;
        this.fechaInicio = LocalDate.now();
        this.RFC = RFC;
        
       
    }
    
    @Override
    public String toString (){
      return String.format("%s, \n fecha de inicio: %s, \n RFC: %s, \n Sueldo: %f", super.toString(),fechaInicio, RFC, sueldo);
  }
    
    
    
    public static void registrarAsistente(){
        Scanner leer = new Scanner(System.in);
        String datos[] = DatosComun.registrarUsuario(Rol.ASISTENTE);
        String nombre = datos[0];
        String apellido = datos[1];
        String telefono = datos[2];
        String nombreUsuario = datos[3]; 
        String contrasena = datos[4];
        System.out.print("Ingresa el RFC: ");
        String rfc = leer.nextLine();
        System.out.print("Ingresa el sueldo: ");
        Double sueldo = leer.nextDouble();
        String fecha = datos[5];
        Asistente asistente = new Asistente ( sueldo, rfc,nombre,  apellido,  telefono, nombreUsuario,  contrasena, fecha);
        System.out.println("El asistente ha sido registrado correctamente. ");
        if(!usuarios.containsKey(Rol.ASISTENTE)){
            usuarios.put(Rol.ASISTENTE, new ArrayList<Usuario>());
        }
        usuarios.get(Rol.ASISTENTE).add(asistente);
        Libreria.serializar();
        leer.nextLine();
    }
    
     public static void mostrarAsistentes(){
        Scanner leer = new Scanner(System.in);
        System.out.println("**Asistentes**");
      
            for(Usuario usuario: usuarios.get(Rol.ASISTENTE)){  
                Asistente asistente = (Asistente)usuario;
                System.out.println(asistente.toString()); 
        }
        
        
    }
    
    
     public static void eliminarAsistente(){
         Scanner leer = new Scanner(System.in);
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
     
     @Override
    public void checarEntrada(){
         System.out.println("Checar con correo");
    }
    @Override
    public void checarSalida(){
        System.out.println("Salir con correo");
    }

    public Double getSueldo() {
        return sueldo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }
}

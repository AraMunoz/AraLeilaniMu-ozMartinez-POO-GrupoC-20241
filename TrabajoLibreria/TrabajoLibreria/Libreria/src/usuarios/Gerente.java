
package usuarios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import static libreria.Libreria.usuarios;

import libreria.Libreria;
import libreria.utils.DatosComun;
import usuarios.utils.Rol;
import utils.UsuarioEnSesion;

public class Gerente extends Usuario implements EmpleadoUtils{
   
    private Double sueldo;
    private String INE;

    public Gerente(Double sueldo, String INE, String nombre, String apellido, String telefono,String nombreUsuario, String contrasena, String fechaNacimiento) {
        super(nombre, apellido, telefono, Rol.GERENTE,nombreUsuario, contrasena, fechaNacimiento);
        this.sueldo = sueldo;
        this.INE = INE;
    }
    
     @Override
    public String toString (){
      return String.format("%s, \n Sueldo: %f, \n INE: %s", super.toString(),  sueldo, INE);
  }
    
    
    
    
    public static void registrarGerente(){
        Scanner leer = new Scanner(System.in);
        String datos[] = DatosComun.registrarUsuario(Rol.GERENTE);
        String nombre = datos[0];
        String apellido = datos[1];
        String telefono = datos[2];
        String nombreUsuario = datos[3]; 
        String contrasena = datos[4];
        System.out.print("Ingresa la INE: ");
        String ine = leer.nextLine();
        System.out.print("Ingresa el sueldo: ");
        Double sueldo = leer.nextDouble();
        String fecha = datos[5];
        Gerente gerente = new Gerente ( sueldo, ine,nombre,  apellido,  telefono, nombreUsuario,  contrasena, fecha);
        
        System.out.println("El gerente ha sido registrado correctamente. ");
       if(!usuarios.containsKey(Rol.GERENTE)){
            usuarios.put(Rol.GERENTE, new ArrayList<Usuario>());
        }
        usuarios.get(Rol.GERENTE).add(gerente);
        Libreria.serializar();
        leer.nextLine();
    }
    
    
    
   
    public static void mostrarGerentes(){
        Scanner leer = new Scanner(System.in);
        System.out.println("**Gerentes**");
      
            for(Usuario usuario: usuarios.get(Rol.GERENTE)){  
                Gerente gerente = (Gerente)usuario;
                System.out.println(gerente.toString());        
        }
        
        
    }
  
   
    public static  void eliminarGerente(){
        Scanner leer = new Scanner(System.in);
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
    @Override
    public void checarEntrada(){
        System.out.println("Checar con huella");
    }
    @Override
    public void checarSalida(){
        System.out.println("Salir con huella");
    }
}

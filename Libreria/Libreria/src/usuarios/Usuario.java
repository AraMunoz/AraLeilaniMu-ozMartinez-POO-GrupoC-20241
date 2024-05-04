
package usuarios;

import java.time.LocalDate;
import usuarios.utils.Rol;

public abstract class Usuario {
    private static int CANTIDAD_USUARIOS = 1;
    private int id;
    private String nombre;
    private String apellido;
    private String telefono;
    private Rol rol; //Cliente, asistente, gerente.
    private String nombreUsuario;
    private String contrasena;
    private String fechaNacimiento;

    public Usuario(String nombre, String apellido, String telefono, Rol rol, String nombreUsuario, String contrasena,String fechaNacimiento ) {
        this.id=CANTIDAD_USUARIOS;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.rol = rol;
        this.contrasena= contrasena;
        this.nombreUsuario= nombreUsuario;
        this.fechaNacimiento = fechaNacimiento;
        CANTIDAD_USUARIOS++;
    }
    
//    public String mostrarInfo(){
//        return String.format("ID: %d, Nombre completo %s %s, telefono: %s, rol: %s",
//                id, nombre, apellido, telefono, rol);
//    }

    @Override
    public String toString(){
       return String.format("ID: %d, \n Nombre completo %s %s, \n telefono: %s, \n rol: %s",
               id, nombre, apellido, telefono, rol);
    }
    public static int getCANTIDAD_USUARIOS() {
        return CANTIDAD_USUARIOS;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public Rol getRol() {
        return rol;
        
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }
    
    
}

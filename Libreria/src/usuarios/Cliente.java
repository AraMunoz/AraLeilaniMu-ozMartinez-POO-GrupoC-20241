
package usuarios;
import java.time.LocalDate;

import usuarios.utils.Rol;

public class Cliente extends Usuario {
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
    
}

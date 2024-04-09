
package usuarios;

import java.time.LocalDate;
import utils.Rol;

public class Asistente extends Usuario {
    private Double sueldo;
    private LocalDate fechaInicio;
    private String RFC;
   
    public Asistente(Double sueldo, String RFC, String nombre, String apellido, String telefono, Rol rol) {
        super(nombre, apellido, telefono, rol);
        this.sueldo = sueldo;
        this.fechaInicio = LocalDate.now();
        this.RFC = RFC;
       
    }
    
    @Override
    public String toString (){
      return String.format("%s, \n fecha de inicio: %s, \n RFC: %s, \n Sueldo: %f", super.toString(),fechaInicio, RFC, sueldo);
  }
    
    
}

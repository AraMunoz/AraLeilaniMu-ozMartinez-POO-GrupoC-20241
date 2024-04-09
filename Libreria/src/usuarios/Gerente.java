
package usuarios;

import utils.Rol;

public class Gerente extends Usuario{
    private Double sueldo;
    private String INE;

    public Gerente(Double sueldo, String INE, String nombre, String apellido, String telefono, Rol rol) {
        super(nombre, apellido, telefono, rol);
        this.sueldo = sueldo;
        this.INE = INE;
    }
    
     @Override
    public String toString (){
      return String.format("%s, \n Sueldo: %f, \n INE: %s", super.toString(),  sueldo, INE);
  }
    
}


package tareacinco;

public class Empleado {
    
    String calcularSalario(double sueldoBase){
        return String.format("El sueldo del empleado es: %.3f", sueldoBase);
    }
    String calcularSalario(double sueldoBase, double bonificacion){
        return String.format("El sueldo del empleado mas bonificacion es: %.3f", (sueldoBase+bonificacion)); 
    }
    String calcularSalario(double sueldoBase, double bonificacion, double horasExtra){
         return String.format("El sueldo del empleado mas bonificacion es: %.3f", (sueldoBase+bonificacion)+(horasExtra*20));
    }
}

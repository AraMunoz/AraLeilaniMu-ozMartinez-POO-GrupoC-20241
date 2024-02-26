
package tareacinco;
import java.util.*;
public class TareaCinco {

    public static void main(String[] args) {
        Scanner leer = new Scanner (System.in);
        Rectangulo rectangulo = new Rectangulo();
        Empleado empleado = new Empleado ();
        CalculadoraImpuestos calculadoraImpuestos = new CalculadoraImpuestos ();
        System.out.println("Areas: ");
        System.out.println("El area del rectangulo es: (double)   "+ rectangulo.area(5.4,10.7));
        System.out.println("El area del rectangulo es:   "+ rectangulo.area(5,10));
        System.out.println("El perimetro del rectangulo es:(double)  "+ rectangulo.perimetro(9.4,10.7));
        System.out.println("El perimetro del rectangulo es:  "+ rectangulo.perimetro(8,12));
        System.out.println("");
        System.out.println("Empleados: ");
        System.out.println(empleado.calcularSalario(15643.87));
        System.out.println(empleado.calcularSalario(15543.87, 543.12));
        System.out.println(empleado.calcularSalario(15673.87, 569.23, 1.5));
        System.out.println("");
        System.out.println("Calculo de Impuestos");
        
        System.out.println("Ingresos: "+ calculadoraImpuestos.CalcularImpuestos(23980));
        System.out.println("Ingresos y su porcentaje de impuestos: "+ calculadoraImpuestos.CalcularImpuestos(23980, 15.30));
        System.out.println("Dividendos, porcentaje de impuestos y exencion: "+ calculadoraImpuestos.CalcularImpuestos(23930, 20, 1500));
    }
    
}


package shape;

import java.util.Scanner;

public class Cuadrado implements Shapee {
    
    @Override
    public void calcularArea(){
        System.out.print("Ingresa la medida de los lados: ");
        int lado = leer.nextInt();
        double area =lado*lado;
        System.out.println("");
        System.out.print("El area del cuadrado es: "+ area);
    }
    @Override
    public void calcularPerimetro(){
        System.out.print("Ingresa la medida de los lados: ");
        int lados = leer.nextInt();
        double perimetro =lados*4;
        System.out.println("");
        System.out.print("El perimetro del cuadrado es: "+ perimetro);
    }
}

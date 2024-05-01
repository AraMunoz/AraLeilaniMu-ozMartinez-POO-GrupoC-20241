
package shape;

import java.util.Scanner;

public class Rectangulo implements Shapee{
    
    @Override
    public void calcularArea(){
        System.out.print("Ingresa la medida del lado largo: ");
        int lado1 = leer.nextInt();
        System.out.println("");
        System.out.print("Ingresa la medida del lado corto: ");
        int lado2 = leer.nextInt();
        double area =lado1*lado2;
        System.out.println("");
        System.out.println("El area del rectangulo es: "+ area);
    }
    @Override
    public void calcularPerimetro(){
        System.out.print("Ingresa la medida del lado largo: ");
        int lado1 = leer.nextInt();
        System.out.println("");
        System.out.print("Ingresa la medida del lado corto: ");
        int lado2 = leer.nextInt();
        double perimetro =lado1*2+lado2*2;
        System.out.println("");
        System.out.println("El perimetro del rectangulo es: "+ perimetro);
    }
}

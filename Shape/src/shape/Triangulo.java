
package shape;

import java.util.Scanner;

public class Triangulo implements Shapee {
   
    @Override
    public void calcularArea(){
        System.out.print("Ingresa la medida de la base: ");
        int lado = leer.nextInt();
        System.out.println("");
        System.out.print("Ingresa la medida de la altura: ");
        int altura = leer.nextInt();
        double area =(lado*altura)/2;
        System.out.println("");
        System.out.println("El area del triangulo es: "+ area);
    }
    @Override
    public void calcularPerimetro(){
        System.out.print("Ingresa la medida de los lados: ");
        int lados = leer.nextInt();
        System.out.println("");
        double perimetro =lados*3;
        System.out.println("El perimetro del triangulo es: "+ perimetro);
    }
}


package main_polimorfismo;

import java.util.Scanner;

public class Rectangulo extends Shape{
    
    Scanner leer = new Scanner (System.in);
    
    @Override
    public  void calcularArea(){
        System.out.println("***Rectangulo***");
         System.out.println("Calculemos el area de un rectangulo");
        System.out.print("Ingresa la medida del lado largo: ");
        int lado1 = leer.nextInt();
        System.out.println("");
        System.out.print("Ingresa la medida del lado corto: ");
        int lado2 = leer.nextInt();
        super.area =lado1*lado2;
        System.out.println("");
        System.out.println("El area del rectangulo es: "+ super.area);
    }
    @Override
    public void calcularPerimetro(){
         System.out.println("Calculemos el perimetro de un rectangulo");
        System.out.print("Ingresa la medida del lado largo: ");
        int lado1 = leer.nextInt();
        System.out.println("");
        System.out.print("Ingresa la medida del lado corto: ");
        int lado2 = leer.nextInt();
        super.perimetro =lado1*2+lado2*2;
        System.out.println("");
        System.out.println("El perimetro del rectangulo es: "+ super.perimetro);
    }
}

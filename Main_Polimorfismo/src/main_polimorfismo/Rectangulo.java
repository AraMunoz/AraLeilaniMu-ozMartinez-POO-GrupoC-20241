
package main_polimorfismo;

import java.util.Scanner;

public class Rectangulo extends Shape{
    
    Scanner leer = new Scanner (System.in);
    
    @Override
    public  void calcularArea(){
        
        System.out.println("Ingresa la medida del lado largo: ");
        int lado1 = leer.nextInt();
        System.out.println("Ingresa la medida del lado corto: ");
        int lado2 = leer.nextInt();
        super.area =lado1*lado2;
        System.out.println("El area del rectangulo es: "+ super.area);
    }
    @Override
    public void calcularPerimetro(){
        System.out.println("Ingresa la medida del lado largo: ");
        int lado1 = leer.nextInt();
        System.out.println("Ingresa la medida del lado corto: ");
        int lado2 = leer.nextInt();
        super.perimetro =lado1*2+lado2*2;
        System.out.println("El area del rectangulo es: "+ super.perimetro);
    }
}


package main_polimorfismo;

import java.util.Scanner;

public class Cuadrado extends Shape{
    
    Scanner leer = new Scanner (System.in);
    
    @Override
    public  void calcularArea(){
        System.out.println("Ingresa la medida de los lados: ");
        int lado = leer.nextInt();
        super.area =lado*lado;
        System.out.println("El area del cuadrado es: "+ super.area);
    }
    @Override
    public void calcularPerimetro(){
         System.out.println("Ingresa la medida de los lados: ");
        int lados = leer.nextInt();
        super.perimetro =lados*4;
        System.out.println("El area del cuadrado es: "+ super.perimetro);
    }
}


package main_polimorfismo;

import java.util.Scanner;

public class Cuadrado extends Shape{
    
    Scanner leer = new Scanner (System.in);
    
    @Override
    public  void calcularArea(){
        System.out.println("***Cuatrado***");
         System.out.println("Calculemos el area de un cuatrado");
        System.out.print("Ingresa la medida de los lados: ");
        int lado = leer.nextInt();
        super.area =lado*lado;
        System.out.println("");
        System.out.println("El area del cuadrado es: "+ super.area);
    }
    @Override
    public void calcularPerimetro(){
         System.out.println("Calculemos el perimetro de un cuatrado");
         System.out.print("Ingresa la medida de los lados: ");
        int lados = leer.nextInt();
        super.perimetro =lados*4;
        System.out.println("");
        System.out.println("El perimetro del cuadrado es: "+ super.perimetro);
    }
}

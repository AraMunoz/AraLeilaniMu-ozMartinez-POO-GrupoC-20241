
package main_polimorfismo;

import java.util.Scanner;

public class Triangulo extends Shape {
     Scanner leer = new Scanner (System.in);
    
    @Override
    public  void calcularArea(){
        System.out.println("Calculemos el area de un triangulo equilatero");
        System.out.println("Ingresa la medida de la base: ");
        int lado = leer.nextInt();
        System.out.println("Ingresa la medida de la altura: ");
        int altura = leer.nextInt();
        super.area =(lado*altura)/2;
        System.out.println("El area del triangulo es: "+ super.area);
    }
    @Override
    public void calcularPerimetro(){
         System.out.println("Ingresa la medida de los lados: ");
        int lados = leer.nextInt();
        super.area =lados*3;
        System.out.println("El area del triangulo es: "+ super.area);
    }
}

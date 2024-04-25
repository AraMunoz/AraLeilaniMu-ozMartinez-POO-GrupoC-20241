
package main_polimorfismo;

import java.util.Scanner;

public class Triangulo extends Shape {
     Scanner leer = new Scanner (System.in);
    
    @Override
    public  void calcularArea(){
        System.out.println("*** Triangulo ***");
        System.out.println("Calculemos el area de un triangulo equilatero");
        System.out.print("Ingresa la medida de la base: ");
        int lado = leer.nextInt();
        System.out.println("");
        System.out.print("Ingresa la medida de la altura: ");
        int altura = leer.nextInt();
        super.area =(lado*altura)/2;
        System.out.println("");
        System.out.println("El area del triangulo es: "+ super.area);
    }
    @Override
    public void calcularPerimetro(){
         System.out.println("Calculemos el perimetro de un triangulo");
         System.out.print("Ingresa la medida de los lados: ");
        int lados = leer.nextInt();
        System.out.println("");
        super.perimetro =lados*3;
        System.out.println("El perimetro del triangulo es: "+ super.perimetro);
    }
}

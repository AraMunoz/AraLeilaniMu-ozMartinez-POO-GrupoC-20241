
package main_polimorfismo;

import java.util.Scanner;

public class Circulo extends Shape {
    Scanner leer = new Scanner (System.in);
    
    @Override
    public  void calcularArea(){
        System.out.println("***Circulo***");
        System.out.println("Calculemos el area de un circulo");
        System.out.print("Ingresa la medida del radio: ");
        int radio = leer.nextInt();
        System.out.println("");
        super.area =3.1416*(radio*radio);
        System.out.println("El area del circulo es: "+ super.area);
    }
    @Override
    public void calcularPerimetro(){
         System.out.print("Ingresa la medida del radio: ");
        int radio = leer.nextInt();
        System.out.println("");
        super.perimetro =(2*3.1416)*radio;
        System.out.println("El perimetro del circulo es: "+ super.perimetro);
        
    }
}

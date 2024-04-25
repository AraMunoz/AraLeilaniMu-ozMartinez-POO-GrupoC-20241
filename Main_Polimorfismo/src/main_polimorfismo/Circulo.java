
package main_polimorfismo;

import java.util.Scanner;

public class Circulo extends Shape {
    Scanner leer = new Scanner (System.in);
    
    @Override
    public  void calcularArea(){
        System.out.println("Calculemos el area de un circulo");
        System.out.println("Ingresa la medida del radio: ");
        int radio = leer.nextInt();
        super.area =3.1416*radio;
        System.out.println("El area del triangulo es: "+ super.area);
    }
    @Override
    public void calcularPerimetro(){
         System.out.println("Ingresa la medida del radio: ");
        int radio = leer.nextInt();
        super.area =(2*3.1416)*radio;
        System.out.println("El area del triangulo es: "+ super.area);
    }
}

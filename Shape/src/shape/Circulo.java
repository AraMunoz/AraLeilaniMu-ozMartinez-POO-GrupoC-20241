
package shape;

import java.util.Scanner;

public class Circulo implements Shapee {
  
    @Override
    public void calcularArea(){
        System.out.print("Ingresa la medida del radio: ");
        int radio = leer.nextInt();
        System.out.println("");
        double area =3.1416*(radio*radio);
        System.out.println("El area del circulo es: "+ area);
    }
    @Override
    public void calcularPerimetro(){
        System.out.print("Ingresa la medida del radio: ");
        int radio = leer.nextInt();
        System.out.println("");
        double perimetro =(2*3.1416)*radio;
        System.out.println("El perimetro del circulo es: "+ perimetro);
    }
}

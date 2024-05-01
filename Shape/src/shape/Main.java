
package shape;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner leer = new Scanner (System.in);
        Cuadrado cuadrado = new Cuadrado();
        Triangulo triangulo = new Triangulo();
        Rectangulo rectangulo = new Rectangulo();
        Circulo circulo = new Circulo();
        
        
        System.out.println("***Hola, calculemos áreas y perimetros****");
        System.out.println("Ingresa la figura con la que deseas trabajar");
        System.out.println("1.Cuatrado");
        System.out.println("2.Circulo");
        System.out.println("3.Rectangulo");
        System.out.println("4.Triangulo");
        int opcion = leer.nextInt();
        switch(opcion){
            case 1:
                System.out.println("Has seleccionado la figura CUADRADO.");
                System.out.println("1.Calcular area");
                System.out.println("2.Calcular perimetro");
                System.out.print("Ingresa la operacion ha realizar: ");
                int operacion = leer.nextInt();
                switch (operacion){
                    case 1:
                        cuadrado.calcularArea();
                    break;
                    case 2:
                        cuadrado.calcularPerimetro();
                    break;
                    default:
                        System.out.println("Ingresa una opcion correcta");
                }
            break;
           case 2:
               System.out.println("Has seleccionado la figura CIRCULO.");
                System.out.println("1.Calcular area");
                System.out.println("2.Calcular perimetro");
                System.out.print("Ingresa la operacion ha realizar: ");
                operacion = leer.nextInt();
                switch (operacion){
                    case 1:
                       circulo.calcularArea();
                    break;
                    case 2:
                        circulo.calcularPerimetro();
                    break;
                    default:
                        System.out.println("Ingresa una opcion correcta");
                }
            break;
           case 3:
               System.out.println("Has seleccionado la figura RECTANGULO.");
                System.out.println("1.Calcular area");
                System.out.println("2.Calcular perimetro");
                System.out.print("Ingresa la operacion ha realizar: ");
                operacion = leer.nextInt();
                switch (operacion){
                    case 1:
                     rectangulo.calcularArea();
                    break;
                    case 2:
                        rectangulo.calcularPerimetro();
                    break;
                    default:
                        System.out.println("Ingresa una opcion correcta");
                }
            break;
               
           case 4:
               System.out.println("Has seleccionado la figura TRIANGULO.");
                System.out.println("1.Calcular area");
                System.out.println("2.Calcular perimetro");
                System.out.print("Ingresa la operacion ha realizar: ");
                operacion = leer.nextInt();
                switch (operacion){
                    case 1:
                      triangulo.calcularArea();
                    break;
                    case 2:
                        triangulo.calcularPerimetro();
                    break;
                    default:
                        System.out.println("Ingresa una opcion correcta");
                }
            break;
               
           default:
               System.out.println("Lo siento, debes elegir una opcion correcta. Intenta de nuevo");
        }
    }
    
}

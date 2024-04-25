
package main_polimorfismo;

public class Main_Polimorfismo {

    public static void main(String[] args) {
        Cuadrado cuadrado = new Cuadrado();
        Triangulo triangulo = new Triangulo();
        Rectangulo rectangulo = new Rectangulo();
        Circulo circulo = new Circulo();
        
        cuadrado.calcularArea();
        cuadrado.calcularPerimetro();
        triangulo.calcularArea();
        triangulo.calcularPerimetro();
        rectangulo.calcularArea();
        rectangulo.calcularPerimetro();
        circulo.calcularArea();
        circulo.calcularPerimetro();
    }
    
}


package main_polimorfismo;

public abstract class Shape {
    
    double area;
    double perimetro;
    
    protected abstract void calcularArea();
    protected abstract void calcularPerimetro();
}

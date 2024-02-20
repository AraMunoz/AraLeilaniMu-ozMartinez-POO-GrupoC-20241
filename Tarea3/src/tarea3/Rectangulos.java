
package tarea3;

public class Rectangulos {
    double ancho, alto;
    
    
    public Rectangulos( double ancho, double alto){
    
        this.alto=alto;
        this.ancho=ancho;
}
    public double area(double ancho, double alto){
        return ancho*alto;
    }
    
    public double perimetro(double ancho, double alto){
        return 2*ancho+2*alto;
    }
}


package tarea3;

public class Tarea3 {

    
    public static void main(String[] args) {
        Personas persona1 = new Personas ("Maria", "Femenino", 12);
        Personas persona2 = new Personas ("Carlos", "Maculino", 39);
        Personas persona3 = new Personas ("Alonso", "Masculino", 19);
        Personas persona4 = new Personas ("Alejandra", "Femenino",35);
        
        System.out.println("*****Personas*****");
        persona1.getPersoninfo();
        persona2.getPersoninfo();
        persona3.getPersoninfo();
        persona4.getPersoninfo();
        
        System.out.println("*****Libros*****");
        Libros libro1= new Libros();
        libro1.getPersoninfo();
        Libros libro2= new Libros();
        Libros libro3= new Libros();
        Libros libro4= new Libros();
        
        libro2.titulo="La de sonrisa bonita";
        libro2.autor="Maria Cervantes";
        libro2.year=2011;
        libro2.getPersoninfo();
        
        libro3.titulo="Vamonos a marte";
        libro3.autor="Alonso Mojica";
        libro3.year=2005;
        libro3.getPersoninfo();
        
        libro4.titulo="Amor de verano";
        libro4.autor="Susana Martinez";
        libro4.year=2024;
        libro4.getPersoninfo();
        
        
        System.out.println("*****Rectangulos*****");
        Rectangulos rectangulo1 = new Rectangulos (2.5, 8);
        System.out.println("Area: "+rectangulo1.area(rectangulo1.ancho, rectangulo1.alto));
        System.out.println("Perimetro: "+rectangulo1.perimetro(rectangulo1.ancho, rectangulo1.alto));
        Rectangulos rectangulo2 = new Rectangulos (22.5, 5.3);
        System.out.println("Area: "+rectangulo2.area(rectangulo2.ancho, rectangulo2.alto));
        System.out.println("Perimetro: "+rectangulo2.perimetro(rectangulo1.ancho, rectangulo1.alto));
        Rectangulos rectangulo3 = new Rectangulos (19.5, 5);
        System.out.println("Area: "+rectangulo3.area(rectangulo3.ancho, rectangulo3.alto));
        System.out.println("Perimetro: "+rectangulo3.perimetro(rectangulo1.ancho, rectangulo1.alto));
        Rectangulos rectangulo4 = new Rectangulos (20, 2.3);
        System.out.println("Area: "+rectangulo4.area(rectangulo4.ancho, rectangulo4.alto));
        System.out.println("Perimetro: "+rectangulo4.perimetro(rectangulo1.ancho, rectangulo1.alto));
        
        
    }
    
}

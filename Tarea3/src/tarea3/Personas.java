
package tarea3;

public class Personas {
    String nombre;
    String genero;
    int year;
    
    
    public Personas(String nombre, String genero, int year){
       
        this.nombre=nombre;
        this.genero=genero;
        this.year=year;
    }
    
    public void getPersoninfo(){
        System.out.println(String.format("Name: %s  Genero: %s  Edad: %d", 
                this.nombre,  this.genero, this.year));
        
    }
}

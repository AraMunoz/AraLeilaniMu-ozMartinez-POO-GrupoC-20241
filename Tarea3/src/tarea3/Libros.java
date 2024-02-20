
package tarea3;

public class Libros {
    String titulo="Mi cielo";
    String autor="Juan Mozqueda";
    int year= 2012;
    
    public void getPersoninfo(){
        System.out.println(String.format("Titulo: %s  Autor: %s  Año de publicacion: %d", 
                this.titulo,  this.autor, this.year));
        
    }
}


package tarea6;

public class Tarea6 {

    public static void main(String[] args) {
        Producto producto = new Producto ("Galletas", 28.90f, 20);
        Producto productoDos = new Producto ("Arroz", 20.50f, 10);
        Producto productoTres = new Producto ("Atun", 23.90f);
        Producto productoCuatro = new Producto ("Dulces", 5.90f, 200);
        
        producto.getInformation();
        producto.aumentarStock(15);
        producto.reducirStock(10);
        producto.getInformation();
        System.out.println("");
        productoDos.aumentarStock(15);
        productoDos.getInformation();
        
        System.out.println("");
        productoCuatro.reducirStock(12);
        productoCuatro.getInformation();
    }
    
}

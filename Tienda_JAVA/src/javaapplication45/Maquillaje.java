
package javaapplication45;

public class Maquillaje extends Producto {
    private static int ID = 200;
    int id;
    private String color;
    
    public Maquillaje( String nombre, double precio, String fechaImportacion, int stock, String color){
        super( nombre,  precio,  fechaImportacion,  stock);
        this.color = color;
        this.id=ID;
        ID++;
        
    }

    public int getId() {
        return id;
    }
    
    public String ObtenerInformaciopnconColor(){
    return super.obtenerInformacion() +", color "+ color+ "ID: "+id;
}
}

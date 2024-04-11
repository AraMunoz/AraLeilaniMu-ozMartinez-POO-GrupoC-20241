
package javaapplication45;

public class Alimento extends Producto {
    private String fechaCaducidad;
    private static int ID = 100;
    int id;
    
    public Alimento ( String nombre, double precio, String fechaImportacion, int stock, String fechaCaducidad){
        super(nombre,  precio,  fechaImportacion,  stock);
        this.fechaCaducidad= fechaCaducidad;
        this.id=ID;
        ID++;
        
    }

    public int getId() {
        return id;
    }
    
    public String ObtenerInformaciopnconFechaDeCaducidad(){
    return super.obtenerInformacion() +", fecha de caducidad "+ fechaCaducidad+ "ID: "+id;
}
}

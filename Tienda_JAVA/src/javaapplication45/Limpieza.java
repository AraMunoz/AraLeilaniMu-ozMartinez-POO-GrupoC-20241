
package javaapplication45;

public class Limpieza extends Producto{
    private static int ID = 100;
    int id;
    String marca;
    
    public Limpieza ( String nombre, double precio, String fechaImportacion, int stock, String marca){
        super( nombre,  precio,  fechaImportacion,  stock);
        this.id = ID;
        this.marca=marca;
        ID++;
        
    }

    public int getId() {
        return id;
    }
    
    public String ObtenerInformaciopnconMarca(){
    return super.obtenerInformacion() +", marca "+ marca+ "ID: "+id;
}
}


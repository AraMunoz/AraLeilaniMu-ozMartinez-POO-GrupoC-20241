
package javaapplication45;

public class Electrodomesticos extends Producto {
    private double voltaje;
    private static int ID = 300;
    int id;
    public Electrodomesticos( String nombre, double precio, String fechaImportacion, int stock, double voltaje){
        super( nombre,  precio,  fechaImportacion,  stock);
        this.voltaje = voltaje;
        this.id=ID;
        ID++;
    }

    public int getId() {
        return id;
    }
    
    public String ObtenerInformaciopnconVoltaje(){
    return super.obtenerInformacion() +", voltaje "+ voltaje+ "ID: "+id;
}
}

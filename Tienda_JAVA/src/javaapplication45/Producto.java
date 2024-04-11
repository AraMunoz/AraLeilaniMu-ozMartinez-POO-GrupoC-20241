
package javaapplication45;

public class Producto {
    private int CANTIDAD_PRODUCTO = 0;
    private String nombre;
    private double precio;
    private String fechaImportacion;
    private int numeroSerie;
    private int stock;
    private boolean tieneCompras;

    public Producto() {
    }

    public Producto(String nombre, double precio, String fechaImportacion, int stock) {
        this.numeroSerie = this.CANTIDAD_PRODUCTO +=1;
        this.nombre = nombre;
        this.precio = precio;
        this.fechaImportacion = fechaImportacion;
        this.stock = stock;
        this.tieneCompras=false;
        this.CANTIDAD_PRODUCTO = this.CANTIDAD_PRODUCTO +=1;
    }

    public  int getCANTIDAD_PRODUCTO() {
        return CANTIDAD_PRODUCTO;
    }
    
    public void agregarStock(int cantidad){
        stock += cantidad;
    }
    
    public void eliminarStock(int cantidad){
        if(validarStock())
            System.out.println("No es posible disminuir la cantidad ingresada, el stock disponible es menor");
        else
            stock -= cantidad;
    }
    
    private boolean validarStock(){
        return stock == 0 ? true : false;
        
    }
    
    public String obtenerInformacion(){
        return String.format("Nombre: %s, precio %f, fecha de importacion %s, stock %d, numero de serie %s", nombre, precio, fechaImportacion, stock, numeroSerie);
    }

    public String getNombre() {
        return nombre;
    }

    public void setTieneCompras(boolean tieneCompras) {
        this.tieneCompras = tieneCompras;
    }

    public boolean isTieneCompras() {
        return tieneCompras;
    }
    
    
}

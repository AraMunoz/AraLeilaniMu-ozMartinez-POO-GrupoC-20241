
package javaapplication45;
import java.util.*;
public class Cliente {
    private static int CANTIDAD_CLIENTES = 0;
    private int id;
    private String nombre;
    private String direccion;
    private boolean tieneCompras;

    public Cliente() {
    }
    
    public Cliente( int id, String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.id = id;
        this.tieneCompras=false;
        CANTIDAD_CLIENTES++;
    }

    public int getId() {
        return id;
    }

    public  int getCANTIDADCLIENTES() {
        return CANTIDAD_CLIENTES;
    }
    
    
    public String ObtenerInformacion(){
        return String.format("ID: %d nombre: %s y direccion %s", this.id, this.nombre, this.direccion);
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


package tarea6;

public class Producto {
    private String name;
    private float precio;
    private int stock = 0;

    public Producto(String name, float precio, int stock) {
            this.name = name;
            this.precio = precio;
            this.stock = stock;
    }

    public Producto(String name, float precio) {
            this.name = name;
            this.precio = precio;
    }
    public void aumentarStock (int cantidad){
    
        if( cantidad > 0 ){
            this.stock = this.stock+cantidad;
        System.out.println("Se sumo "+cantidad +" unidades al stock correctamente ahora el stock disponible de "+this.name+" es de: "+this.stock);
        }
        else
            System.out.println("No fue prosible aumentar el stock, ingresa un valor valido");
    }
    public void reducirStock (int cantidad){
        if( cantidad > 0 && cantidad <= this.stock){
            this.stock = this.stock-cantidad;
            System.out.println("Se restaron " + cantidad+" unidades al stock, ahora "+ this.name+" cuenta con un stock de: "+ this.stock);
        }
        else
            System.out.println("No fue posible reducir el stock, ingresa un valor valido");
    }

    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("El nombre no puede ser nulo");
        }
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        if (precio > 0)
            this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
       if (stock > 0 && stock > this.stock)
        this.stock = stock;
       else
           throw new IllegalArgumentException ("Introduce un stock valido");
    }
    public void getInformation (){
        System.out.println(String.format("El producto : %s tiene un precio de $ %.2f y cuenta con un stock de: %d",this.name,this.precio,this.stock));
    }
    
}


package javaapplication45;

public class Compras {
    private Cliente cliente;
    private Producto producto;
    private String fecha;
    private int cantidad;

    public Compras(Cliente cliente, Producto producto, String fecha, int cantidad) {
        this.cliente = cliente;
        this.producto = producto;
        this.fecha=fecha;
        this.cantidad= cantidad;
    }
    
    public String ObtenerInformacionCompra(){
        return String.format("El cliente: %s compro: %d %s el dia: %s", cliente.getNombre(), cantidad, producto.getNombre(), fecha);
    }
}

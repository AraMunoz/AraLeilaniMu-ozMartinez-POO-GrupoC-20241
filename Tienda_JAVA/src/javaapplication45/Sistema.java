
package javaapplication45;
import java.util.*;
public class Sistema {
    private final String CONTRASENA_SEGURA = "H1/m";
    Tienda tienda = new Tienda ();
    Scanner leer = new Scanner (System.in);
    
    public void ejecutarPrograma(){
        boolean contrasenaValida = false;
        do{
            System.out.println("***Bienvenido***");
        System.out.println("Ingresa la contraseña: ");
         String contrasena = leer.nextLine();
        
        if(validarContrasena(contrasena)){
            contrasenaValida = true;
            //Mostrar menu
            this.mostrarMenuSistema();
        }
        else {
            System.out.println("Contrasena invalida, intenta de nuevo");
        }
        }while(!contrasenaValida);
        
    }
   
    private boolean validarContrasena(String contrasena){
        return contrasena.equals(CONTRASENA_SEGURA);
    }
    
    private void mostrarMenuSistema(){
        int opcion = 0;
        do{
            System.out.println("***Bienvenido***");
            System.out.println("Elige una opcion para continuar");
            System.out.println("1. Agregar cliente");
            System.out.println("2. Agregar producto");
            System.out.println("3. Añadir stock");
            System.out.println("4. Disminuir stock");
            System.out.println("5. Consultar clientes");
            System.out.println("6. Consultar productos");
            System.out.println("7. Consultar productos por categoria");
            System.out.println("8. Realizar una compra");
            System.out.println("9. Ver compras");
            System.out.println("10. Consultar total de clientes y productos");
            System.out.println("11. Eliminar cliente");
            System.out.println("12. Eliminar producto");
            System.out.println("13. Salir");
            System.out.print("Ingresa la opcion: ");
            opcion = leer.nextInt();
            
            switch ( opcion ){
                case 1: tienda.registrarCliente();
                break;
                    
                case 2: 
                    System.out.println("Ingresa el tipo de producto: ");
                    System.out.println("1. Limpieza");
                    System.out.println("2.Electrodomesticos");
                    System.out.println("3.Alimento");
                    System.out.println("4.Maquillaje");
                    int opcionProducto = leer.nextInt();
                    switch(opcionProducto){
                        case 1:
                            System.out.println("***Elegiste la opcion de registrar un producto de limpieza***");
                            tienda.registrarProductoLimpieza();
                        break;
                        case 2:
                            System.out.println("***Elegiste la opcion de registrar un producto de electrodomestico***");
                            tienda.registrarProductoElectrodomesticos();
                        break;
                        case 3:
                            System.out.println("***Elegiste la opcion de registrar un producto de alimento***");
                            tienda.registrarProductoAlimento();
                        break;
                        case 4:
                            System.out.println("***Elegiste la opcion de registrar un producto de maquillaje***");
                            tienda.registrarProductoMaquillaje();
                        break;
                        
                    }
                break;
                case 5: tienda.consultarClientes();
                    break;
                case 6: tienda.consultarProductos();
                    break;
                    
                case 7:
                    System.out.println("Elegiste la opcion ver productos por categoria: ");
                    System.out.println("Ingresa el tipo de producto: ");
                    System.out.println("1. Limpieza");
                    System.out.println("2.Electrodomesticos");
                    System.out.println("3.Alimento");
                    System.out.println("4.Maquillaje");
                    int opcionver=leer.nextInt();
                    switch(opcionver){
                        case 1:
                            System.out.println("***Elegiste la opcion de ver productos de limpieza***");
                            tienda.registrarProductoLimpieza();
                        break;
                        case 2:
                            System.out.println("***Elegiste la opcion de ver productos de electrodomestico***");
                            tienda.registrarProductoElectrodomesticos();
                        break;
                        case 3:
                            System.out.println("***Elegiste la opcion de ver productos de alimento***");
                            tienda.registrarProductoAlimento();
                        break;
                        case 4:
                            System.out.println("***Elegiste la opcion de ver productos de maquillaje***");
                            tienda.registrarProductoMaquillaje();
                        break;
                    }
                    break;
                case 8: 
                    System.out.println("***Elegiste la opcion de realizar una compra***");
                    tienda.comprarProductos();
                    break;
                case 9: 
                    System.out.println("***Elegiste la opcion de ver todas las compras***");
                    tienda.verCompras();
                    break;
                case 10: 
                    System.out.println("***Elegiste la opcion de ver total de productos y clientes***");
                    tienda.consultarTotalDeClientesYProductos();
                    break;
               case 11: 
                    System.out.println("***Elegiste la opcion de eliminar clientes***");
                    tienda.eliminarCliente();
                    break;
                case 12: 
                    System.out.println("***Elegiste la opcion de eliminar producto***");
                    tienda.eliminarProducto();
                    break;
                case 13: 
                    System.out.println("Saliendo...");
                    break;
            }
        }while(opcion !=13);
        
        
    }
}

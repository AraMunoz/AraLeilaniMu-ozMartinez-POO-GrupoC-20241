
package javaapplication45;

import java.util.*;
public class Tienda {
    
    private Random random = new Random();
    private Producto producto = new Producto ();
    private Cliente cliente = new Cliente();
    private ArrayList<Cliente> clientes = new ArrayList<Cliente>(); 
    private ArrayList<Maquillaje> maquillajes = new ArrayList<Maquillaje>();
    private ArrayList<Limpieza> Productolimpieza = new ArrayList<Limpieza>();
    private ArrayList<Electrodomesticos> electrodomesticos = new ArrayList<Electrodomesticos>();
    private ArrayList<Alimento> alimentos = new ArrayList<Alimento>();
    private ArrayList<Compras> compras = new ArrayList<Compras>();
    private Scanner leer = new Scanner (System.in);
    
    public void registrarCliente(){
       int id = validarIdCliente();
        System.out.print("Ingresa el nombre del cliente: ");
        String nombre = leer.nextLine();
        System.out.print("Ingresa la direccion del cliente: ");
        String direccion = leer.nextLine();
        Cliente cliente = new Cliente (id, nombre, direccion);
        clientes.add(cliente);
        System.out.println("Cliente registrado su id es: "+cliente.getId());
        
    }
    
    public void consultarClientes(){
        System.out.println("***Clientes***");
        for(Cliente cliente: clientes){
            System.out.println(cliente.ObtenerInformacion());
        }
    }
    
    private int validarIdCliente(){
        boolean idValido = true;
        int id = random.nextInt(1000)+1;
        do{
        for(Cliente cliente: clientes){
            if(id == cliente.getId()){
                idValido = false;
                id = random.nextInt(1000)+1;
            }
        }
        }while(!idValido);
        
        return id;
    }
    
    public ArrayList<String> registrarDatosComun(){
        ArrayList<String> datos = new ArrayList<String>();
        System.out.println("Ingresa el nombre: ");
        String nombre = leer.nextLine();
        datos.add(nombre);
        System.out.println("Ingresa el precio: ");
        double precio = leer.nextDouble();
        System.out.println(precio);
        datos.add(String.valueOf(precio));
        leer.nextLine();
        System.out.println("Ingresa fecha de importacion: ");
        String fecha = leer.nextLine();
        datos.add(fecha);
        System.out.println("Ingresa el stock: ");
        int stock = leer.nextInt();
        datos.add(String.valueOf(stock));
        
        
        return datos;
    }
    public void registrarProductoLimpieza(){
        System.out.println("***Elegiste registrar un producto de limpieza***");
        ArrayList<String> datosUsuario = registrarDatosComun();
        String nombre = datosUsuario.get(0);
        double precio = Double.parseDouble(datosUsuario.get(1));
        String fecha = datosUsuario.get(2);
        int stock = Integer.parseInt(datosUsuario.get(3));
        leer.nextLine();
        System.out.println("Ingresa la marca: ");
        String marca = leer.nextLine();
        Limpieza limpieza = new Limpieza(nombre, precio, fecha, stock, marca);
        System.out.println("El producto ha sido registrado correctamente el ID es: "+limpieza.getId());
        Productolimpieza.add(limpieza);
        
    }
    
    public void registrarProductoAlimento(){
        System.out.println("***Elegiste registrar un producto de alimentos***");
        ArrayList<String> datosUsuario = registrarDatosComun();
        String nombre = datosUsuario.get(0);
        double precio = Double.parseDouble(datosUsuario.get(1));
        String fecha = datosUsuario.get(2);
        int stock = Integer.parseInt(datosUsuario.get(3));
        leer.nextLine();
        System.out.println("Ingresa la fecha de caducidad: ");
        String fechaCaducidad = leer.nextLine();
        Alimento alimento = new Alimento (nombre,precio, fecha, stock, fechaCaducidad);
        System.out.println("El producto ha sido registrado correctamente el ID es: "+alimento.getId());
        alimentos.add(alimento);
        
    }
    public void registrarProductoElectrodomesticos(){
        System.out.println("***Elegiste registrar un producto de electrodomesticos***");
        ArrayList<String> datosUsuario = registrarDatosComun();
        String nombre = datosUsuario.get(0);
        double precio = Double.parseDouble(datosUsuario.get(1));
        String fecha = datosUsuario.get(2);
        int stock = Integer.parseInt(datosUsuario.get(3));
        leer.nextLine();
        System.out.println("Ingresa el voltaje: ");
        Double voltaje = leer.nextDouble();
        Electrodomesticos electrodomestico = new Electrodomesticos(nombre, precio, fecha, stock, voltaje);
        System.out.println("El producto ha sido registrado correctamente el ID es: "+electrodomestico.getId());
        electrodomesticos.add(electrodomestico);
    }
    public void registrarProductoMaquillaje(){
        System.out.println("***Elegiste registrar un producto de maquillaje***");
        ArrayList<String> datosUsuario = registrarDatosComun();
        String nombre = datosUsuario.get(0);
        double precio = Double.parseDouble(datosUsuario.get(1));
        String fecha = datosUsuario.get(2);
        int stock = Integer.parseInt(datosUsuario.get(3));
        leer.nextLine();
        System.out.println("Ingresa el color: ");
        String color = leer.nextLine();
        Maquillaje maquillaje = new Maquillaje(nombre, precio, fecha, stock, color);
        System.out.println("El producto ha sido registrado correctamente el ID es: "+maquillaje.getId());
        maquillajes.add(maquillaje);
    }
    
    public void consultarProductos (){
        System.out.println("***Productos***");
        consultarProductosLimpieza();
        consultarProductosAlimento();
        consultarProductosElectrodomesticos();
        consultarProductosMaquillaje();  
    }
    
    public void consultarProductosLimpieza(){
        for(Limpieza limpieza : Productolimpieza){
            System.out.println(limpieza.ObtenerInformaciopnconMarca());
        }
    
    }
    public void consultarProductosAlimento(){
        for(Alimento alimento: alimentos){
            System.out.println(alimento.ObtenerInformaciopnconFechaDeCaducidad());
        }
    
    }
    public void consultarProductosElectrodomesticos(){
        for(Electrodomesticos electrodomestico: electrodomesticos){
            System.out.println(electrodomestico.ObtenerInformaciopnconVoltaje());
        }
    
    }
    public void consultarProductosMaquillaje(){
        for(Maquillaje maquillaje: maquillajes){
            System.out.println(maquillaje.ObtenerInformaciopnconColor());
        }
    
    }
     public void consultarTotalDeClientesYProductos(){
         System.out.println("El sistema tiene registrados un total de: " + producto.getCANTIDAD_PRODUCTO()+" productos.");
         System.out.println("El sistema tiene registrados un total de: " + cliente.getCANTIDADCLIENTES()+" clientes.");
    }
    
     public void comprarProductos(){
         System.out.print("Ingrese el id del cliente: ");
         int id = leer.nextInt();
         if(esCliente(id)!= null){
             Cliente clienteComprador=esCliente(id);
             clienteComprador.setTieneCompras(true);
             System.out.println("Bienvenido "+ clienteComprador.getNombre() +" "
                     + "ingresa la categoria de prductos que deseas comprar: ");
                    System.out.println("Tipo de producto: ");
                    System.out.println("1. Limpieza");
                    System.out.println("2.Electrodomesticos");
                    System.out.println("3.Alimento");
                    System.out.println("4.Maquillaje");
                    int opcionProducto = leer.nextInt();
                    System.out.println("Ingresa el id del producto: ");
                    int idProducto = leer.nextInt();
                    if(esProducto(opcionProducto, idProducto)!=null){
                        Producto productoVendido = esProducto(opcionProducto, idProducto);
                        productoVendido.setTieneCompras(true);
                        System.out.println("Ingresa la cantidad que deseas comprar: ");
                        int cantidadComprar = leer.nextInt();
                        productoVendido.eliminarStock(cantidadComprar);
                        String fecha = "09-Abril-2024";
                        Compras compra = new Compras(clienteComprador, productoVendido, fecha, cantidadComprar);
                        compras.add(compra);
                    }
                    
                
         }
     }
     public Cliente esCliente(int id){
         for(Cliente cliente:clientes){
             if(cliente.getId()==id)
                 return cliente;
         }
         return null;
     }  
     
     public Producto esProducto (int opcion, int id){
         
         switch(opcion){
                        case 1:
                          for(Limpieza limpieza : Productolimpieza){
                             if(limpieza.getId()==id)
                                 return limpieza;
                            }  
                        break;
                        case 2:
                            for(Electrodomesticos electrodomestico: electrodomesticos){
                                    if(electrodomestico.getId()==id)
                                        return electrodomestico;
                            }
                        break;
                        case 3:
                         for(Alimento alimento: alimentos){
                                if(alimento.getId()==id)
                                        return alimento;
                         }
                        break;
                        case 4:
                         for(Maquillaje maquillaje: maquillajes){
                             if(maquillaje.getId()==id)
                                 return maquillaje;
                         }
                        break;
                        
                    }
         return null;
     }
     
     public void verCompras(){
         for(Compras compra: compras)
            System.out.println(compra.ObtenerInformacionCompra());
     }
     
     public void eliminarCliente(){
         System.out.print("Ingresa el Id del cliente que deseas eliminar: ");
         int id = leer.nextInt();
         leer.nextLine();
         int i=0;
         for(Cliente cliente:clientes){
             if(cliente.getId()==id && cliente.isTieneCompras()==false){
                 clientes.remove(i);
                 System.out.println("El cliente ha sido eliminado correctamente. ");
                 return;
             }else
                 i++;
             System.out.println("El cliente no puede ser eliminado, es posible que este realizando una compra. ");
             
         }
         
     }
     public void eliminarProducto(){
         System.out.println("Ingresa el tipo de producto que deseas eliminar: ");
         System.out.println("Tipo de producto: ");
         System.out.println("1. Limpieza");
         System.out.println("2.Electrodomesticos");
         System.out.println("3.Alimento");
         System.out.println("4.Maquillaje");
          int opcion = leer.nextInt();
         System.out.println("Ingresa el id del producto: ");
         int id = leer.nextInt();
         int i=0;
         switch(opcion){
                        case 1:
                          for(Limpieza limpieza : Productolimpieza){
                             if(limpieza.getId()==id && limpieza.isTieneCompras()==false){
                                 Productolimpieza.remove(i);
                                 System.out.println("El producto ha sido eliminado correctamente. ");
                                 return;
                             }else
                                 i++;
                            }
                          System.out.println("El producto no puede ser eliminado, es posible que se encuentre vendido. ");
                        break;
                        case 2:
                            for(Electrodomesticos electrodomestico: electrodomesticos){
                                    if(electrodomestico.getId()==id && electrodomestico.isTieneCompras()==false){
                                        electrodomesticos.remove(i);
                                        System.out.println("El producto ha sido eliminado correctamente. ");
                                        return;
                                    }else 
                                        i++;
                            }
                          System.out.println("El producto no puede ser eliminado, es posible que se encuentre vendido. ");
                        break;
                            
                        case 3:
                         for(Alimento alimento: alimentos){
                            if(alimento.getId()==id && alimento.isTieneCompras()==false){
                               alimentos.remove(i);
                               System.out.println("El producto ha sido eliminado correctamente. ");
                               return;
                            }else 
                                i++;
                         }
                         System.out.println("El producto no puede ser eliminado, es posible que se encuentre vendido. ");
                        break;
                        case 4:
                         for(Maquillaje maquillaje: maquillajes){
                             if(maquillaje.getId()==id && maquillaje.isTieneCompras()==false){
                                 maquillajes.remove(i);
                                 System.out.println("El producto ha sido eliminado correctamente. ");
                                 return;
                             }else
                                 i++;
                         }
                            System.out.println("El producto no puede ser eliminado, es posible que se encuentre vendido. ");
                        break;
                        
                    }
     }

}

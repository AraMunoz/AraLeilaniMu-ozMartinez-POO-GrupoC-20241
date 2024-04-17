

import libreria.Menu;
import usuarios.Cliente;
import usuarios.utils.Rol;
public class Main {

    public static void main(String[] args) {
        //ejercicioLibreria/parte1/Unidad3
        
        //Cliente cliente = new Cliente ("Maria", "Martinez", "2233456");
        
       // System.out.println(cliente.toString());
        /*Patron Singleton tambien llamado instancia unica, 
        es un patron de diseno creacional  nos permite asegurarnos de que una clase tenga una unica instancia.ademas nos permite acceder a esta instancia
//        desde cualquier parte. .*/
        Menu menu = new Menu();
        menu.iniciarSesion();
    }
    
}

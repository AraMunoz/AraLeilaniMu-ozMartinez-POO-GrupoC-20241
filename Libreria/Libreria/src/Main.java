

import java.util.Scanner;
import libreria.Menu;
import usuarios.Cliente;
import usuarios.utils.Rol;
public class Main {

    public static void main(String[] args) {
        //ejercicioLibreria/parte1/Unidad3
        Scanner leer = new Scanner (System.in);
        //Cliente cliente = new Cliente ("Maria", "Martinez", "2233456");
        
       // System.out.println(cliente.toString());
        /*Patron Singleton tambien llamado instancia unica, 
        es un patron de diseno creacional  nos permite asegurarnos de que una clase tenga una unica instancia.ademas nos permite acceder a esta instancia
//        desde cualquier parte. .*/
        Menu menu = new Menu();
        menu.iniciarSesion();
        
        //LocalDate fecha = LocalDate.of(2000,8,10)
        //LocalTime hora = LocalTime.now();
        //LocalDateTime fechaCompleta = LocalDateTime.now();
        //DateTimeFormatter patter = DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm:ss");
        //String fechaFormateada = fechaCompleta.format(pattern);
        
        
        /*
        YYY - YEAR
        MM - MONTH OF YEAR
        dd - day of month 
        HH - hour 
        mm - minutes
        ss - seconds
        */
        
        /*
        - Investigar 10 tipos de exceptions con ejemplos
        - Subir el avance de la libreria en fechas
        - Investigar que es una libreria, para que sirve y como se instalan en un proyecto de Java
        */
        
//        try{
//            //Lo que deseamos probar
//            System.out.println(110/0);
//        }catch(ArithmeticException error){
//            //Dentro de aqui manejamos el error
//            System.out.println(error);
//        }catch(Exception error){
//            
//        }finally {
//            System.out.println("Se ejecuta siempre. Con o sin error");
//        }
        
        boolean esDatoValido = false;
        int edad = 0; 
        while(!esDatoValido){
            try{
                System.out.println("Ingresa tu edad: ");
                edad =leer.nextInt();
                esDatoValido = true;
            }catch (Exception e){
                System.out.println("Ingresa un valor correcto.");
        }
    }
    
}
}

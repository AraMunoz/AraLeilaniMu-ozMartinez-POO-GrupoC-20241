
package pkg10_excepciones;

import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
       
        /* 1. NullPointerException: Se da cuando se intenta acceder a un metodo
        o propiedad de un objeto que no ha sido inicializado, es decir, que es un null.*/
        try{
        String palabra = null;
        System.out.println(palabra.length());
        }catch(Exception e){
            System.out.println("Ha ocurrido un error: "+ e);
        }
        
        /* 2. ArrayIndexOutOfBoundsException: Significa que se esta intentando acceder
        al indice de un arreglo o vector que es menor a 0, mayor o igual a la longitud 
        del mismo.*/
        try{
        int[] vector = new int[3];
        System.out.println(vector[3]);
        }catch(Exception e){
            System.out.println("Ha ocurrido un error: "+ e);
        }
        
        /* 3. ArithmeticException: Ocurre cuando existe un error aritmetico.*/
        
        try{
        int resultado = 10 / 0;
        }catch(Exception e){
            System.out.println("Ha ocurrido un error: "+ e);
        }
        
        /* 4. NumberFormatException: Indica que el formato de una cadena no
        es compatible con el tipo numerico que estas intentando convertir. */
        
        try{
        String cadena = "abc";
        int num = Integer.parseInt(cadena);
        }catch(Exception e){
            System.out.println("Ha ocurrido un error: "+ e);
        }
        
        /* 5. ConcurrentModificationException: Ocurre cuando se intenta modificar 
        una coleccion, por ejemplo, una lista mientras se itera sobre ella de manera 
        concurrente, con un "for-each"*/
        
        try{
        ArrayList<String> lista = new ArrayList<>();
        lista.add("a");
        for (String s : lista) {
            lista.add("b"); 
        }
        }catch(Exception e){
            System.out.println("Ha ocurrido un error: "+ e);
        }
        
        /* 6. SintaxError: Ocurre cuando el codigo no sigue las reglas 
        gramaticales del lenguaje de programacion.*/
        
        try{
        int x = 5
        }catch(Exception e){
            System.out.println("Ha ocurrido un error: "+ e);
        }
        
        /* 7.NoSuchMethodError: Este error ocurre cuando se intenta
        llamar a un método que no existe en una clase. */
        
        try{
        String str = "Hello";
        int length = str.;
        }catch(Exception e){
            System.out.println("Ha ocurrido un error: "+ e);
        }
        /* 8. IndexOutOfBoundsException: Cuando se intenta acceder a un elemento
        que no existe.*/
        try{
        ArrayList<String> prueba = new ArrayList<String>();
        System.out.println(prueba.get(0));
        }catch(Exception e){
            System.out.println("Ha ocurrido un error: "+ e);
        }
        
        /*9. FileNotFoundException: Ocurre cuando intentas acceder a un archivo que 
        no existe en el sistema de archivos*/
        
        try{
        FileReader reader = new FileReader("archivo_que_no_existe.txt");
        }catch(Exception e){
            System.out.println("Ha ocurrido un error: "+ e);
        }
        
        /*10.StringIndexOutOfBoundsException: Ocurre  cuando se intenta acceder a un índice 
        en una cadena que está fuera de su rango válido. */
        
        try{
          String str = "Hello";
          char ch = str.charAt(10);
     }catch(Exception e){
            System.out.println("Ha ocurrido un error: "+ e);
        }
    }
    
}

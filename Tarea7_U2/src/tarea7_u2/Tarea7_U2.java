
package tarea7_u2;
import java.util.*;
public class Tarea7_U2 {

    public static void main(String[] args) {
        Scanner leer = new Scanner (System.in);
        ArrayList<Employee> employee = new ArrayList<>();//lista para los empleados
        ArrayList <BankAccount> cuentas = new ArrayList<>();//lista para las cuentas
        
        Banco banco = new Banco();//instancia de banco
        char tipoCuenta='a';
        int op;
        boolean err;
        System.out.println("****BIENVENIDO AL BANCO****");
        do{
        try{
        // Inicia registr del empleado
        do{
        String nombre; 
        Employee empleado = new Employee (null, 0, tipoCuenta, 0, 00);//instancia de empleado
        System.out.print("Ingresa el nombre del empleado: ");
        nombre = leer.nextLine();
        empleado.setName(nombre);
        System.out.print("Ingresa la edad del empleado: ");
        int edad = leer.nextInt();
        leer.nextLine();
        empleado.setAge(edad);
        System.out.print("Ingresa el sueldo de "+nombre+" ");
        double sueldo = leer.nextDouble();
        leer.nextLine();
        empleado.setSalary(sueldo);
        System.out.print("Cuantas cuentas deseas ingresar para este usuario? ");
        int numCuentas = leer.nextInt();
        leer.nextLine();
        for(int i = 0; i<numCuentas; i++){
            boolean tipovalido = false;
            do{
            System.out.print("Ingresa el tipo de cuenta del empleado: " );
            tipoCuenta = leer.next().charAt(0);
            String formatAccoundType = Character.toString(tipoCuenta).toUpperCase();
            if( formatAccoundType.equals("A") || formatAccoundType.equals("B") || formatAccoundType.equals("C") ){
            tipovalido = true;
            }
            else {
            System.out.println("Ingresa un tipo de cuenta valido");
            }
            }while(!tipovalido);
            System.out.print("Ingresa el numero de cuenta del empleado: ");
            long numeroCuenta = leer.nextLong();
            leer.nextLine();
            BankAccount cuenta = new BankAccount (numeroCuenta,tipoCuenta);//Instancia de cuenta
            cuentas.add(cuenta);
            empleado.setAccount(cuenta);
            empleado.getCuentas().add(cuenta);
            
            
        }
            
            employee.add(empleado);
            banco.agregarEmpleado(empleado);
        
            System.out.print("Deseas agregar otro empleado? \n 1.Si \n 2.No  ");
            op = leer.nextInt();
            leer.nextLine();
        }while(op!=2);
        err = false;
        }catch (Exception e){
            System.out.println("Has ingresado un valor invalido, por favor revisa que tu informacion sea correcta. ");
            err = true;
        }
         
        }while(err);
       
        
        
       
        
        
        
        
        do{
            System.out.print("Que deseas realizar? \n 1.Ver todos los usuarios registrados \n 2.Ver un usuario registrado " );
            op = leer.nextInt();
            switch (op){
                case 1: {
                    banco.mostrarEmpleados();
                }
                break;
                case 2: {
                    System.out.print("Ingresa el numero de cuenta del empleado que deseas ver: ");
                    long number = leer.nextLong();
                    boolean us = false;
                    Employee emplead;
                    if (banco.buscarEmpleado(number)!= null){
                        emplead = banco.buscarEmpleado(number);
                        emplead.verCuentas();       
                        do{
                        System.out.print("Que deseas realizar con la cuenta: "+number+" \n 1. Depositar \n 2. Retirar \n 3.Salir");
                        op=leer.nextInt();
                        switch(op){
                            case 1:{
                              
                                System.out.print("Que cantidad deseas depositar $");
                                double cantidad = leer.nextDouble();
                                Employee empleadoDeposito = banco.buscarEmpleado(number);
                                if (empleadoDeposito != null) {
                                    BankAccount cuentaDeposito = empleadoDeposito.buscarCuenta(number);
                                    if (cuentaDeposito != null) {
                                            char tipo = cuentaDeposito.getTipo();
                                         empleadoDeposito.buscarCuenta(number).depositar(cantidad, tipo);
                                    } else {
                                        System.out.println("Número de cuenta no encontrado.");
                                        }
                                } else {
                                    System.out.println("Empleado no encontrado.");
                                    }
                            }
                            break;
                            case 2: {
                            System.out.print("Que cantidad deseas retirar $");
                            double cantidad = leer.nextDouble();
                            Employee empleadoRetiro = banco.buscarEmpleado(number);
                            if (empleadoRetiro != null) {
                                 BankAccount cuentaRetiro = empleadoRetiro.buscarCuenta(number);
                                 if (cuentaRetiro != null) {
                                     char tipo = cuentaRetiro.getTipo();
                                     
                                         empleadoRetiro.buscarCuenta(number).retirar(cantidad, tipo);
                                        
                                    } else {
                                         System.out.println("Número de cuenta no encontrado.");
                                        }
                            } else {
                                 System.out.println("Empleado no encontrado.");
                                }
                            }
                            break;
                            case 3: System.out.println("Good bye! ");
                            break;
                            default: System.out.println("Introduce una opcion valida. ");
                        }
                        }while(op!=3);
                    }
                        else
                            System.out.println("Usuario no encontrado");
                    }
                   break;
                   default: System.out.println("Introdue una opcion valida"); 
                }
                
            
            System.out.print("Deseas realizar otra opcion? \n 1.Si \n 2.No, salir ahora ");
            op=leer.nextInt();
        }while(op!=2);
        
        
        
        
        
    }
    
}

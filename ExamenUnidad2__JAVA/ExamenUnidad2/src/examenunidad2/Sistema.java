package examenunidad2;

import java.util.Scanner;

public class Sistema {
    Zoo objetoZoo = new Zoo();
    Visita objetoVisita = new Visita();
    Scanner leer = new Scanner(System.in);

    private final String CLAVE = "Hola546%";

    public void ejecutarPrograma()
    {
        boolean claveValida = false;

        do {
            System.out.print("\nIngrese la contraseña del sistema: ");
            String clave = leer.nextLine();

            if (validarClave(clave)) 
            {
                //mostramos menú
                claveValida = true;
                mostrarMenu();
                
            } 
            else 
            {
                System.out.println("\n***Clave inválida, intenta de nuevo***");
            }
        } while (!claveValida);
    }
    
    private boolean validarClave(String clave)
    {
        return clave.equals(CLAVE);
    }
    
    private void mostrarMenu()
    {
        int opcion = 0;
        
        do
        {
            System.out.println("\n\n\t***BIENVENIDO AL ZOOLOGICO***");
            System.out.println("\nMenú de opciones");
            System.out.println("1) Agregar empleado");
            System.out.println("2) Agregar visitante");
            System.out.println("3) Agregar animal");
            System.out.println("4) Mostrar lista de empleados");
            System.out.println("5) Mostrar lista de visitantes");
            System.out.println("6) Mostrar lista de animales");
            System.out.println("7) Eliminar empleado");
            System.out.println("8) Eliminar visitante");
            System.out.println("9) Eliminar animal");
            System.out.println("10) Modificar información de un empleado");
            System.out.println("11) Modificar información de un visitante");
            System.out.println("12) Modificar información de un animal");
            System.out.println("13) Realizar visita");
            System.out.println("14) Realizar cuidado de animales");
            System.out.println("15) Mostrar mantenimiento de animal");
            System.out.println("16) Salir");
            
            System.out.print("\nSeleccione una opción: ");
            opcion = leer.nextInt();
            
            switch(opcion)
            {
                case 1:
                    System.out.println("\nSeleccionaste registrar empleado");
                    objetoZoo.registrarPersonaEmpleado();
                    break;
                    
                case 2:
                    System.out.println("\nSeleccionaste registrar visitantes");
                    objetoZoo.registrarVisitantes();
                    break;
                    
                case 3:
                    System.out.println("\nSeleccionaste registrar animal");
                    objetoZoo.registrarAnimal();
                    break;
                    
                case 4:
                    System.out.println("\nSeleccionaste listar empleados");
                    objetoZoo.mostrarEmpleados();
                    break;
                    
                case 5:
                    int opcion2=0;
                    do
                    {
                        
                    System.out.println("\n**Listas disponibles**");
                    System.out.println("\n1) Lista de adultos registrados");
                    System.out.println("2) Lsta de niños registrados");
                    System.out.println("3) Mostrar todos los visitantes");
                    System.out.println("4) Volver al menú principal");
                    
                    System.out.println("\nElige una opción: ");
                    opcion2 = leer.nextInt();
                    
                    switch(opcion2)
                    {
                        case 1: objetoZoo.mostrarVisitantesAdultos();
                            break;
                            
                        case 2:objetoZoo.mostrarVisitantesMenores();
                            break;
                            
                        case 3:objetoZoo.mostrarTodosLosVisitantes();
                            break;
                            
                        case 4: System.out.println("\nMenú principal");
                            break;
                            
                        default: System.out.println("\nOpción no válida");
                    }
                    }while(opcion2 != 4);
                    
                    break;
                    
                case 6:
                    System.out.println("\nSeleccionaste listar animales");
                    objetoZoo.mostrarAnimales();
                    break;
                    
                case 7:
                    System.out.println("\nSeleccionaste eliminar empleado");
                    objetoZoo.eliminarEmpleado();
                    break;
                    
                case 8:
                    System.out.println("\nSeleccionaste eliminar visitante");
                    objetoZoo.eliminarVisitante();
                    break;
                    
                case 9:
                    System.out.println("\nSeleccionaste elimnar animal");
                    objetoZoo.eliminarAnimal();
                    break;
                    
                case 10:
                    System.out.println("\nSeleccionaste modificar empleado");
                    objetoZoo.modificarEmpleado();
                    break;
                    
                case 11:
                    System.out.println("\nSeleccionaste modificar visitante");
                    objetoZoo.modificarVisitante();
                    break;
                    
                case 12:
                    System.out.println("\nSeleccionaste modificar información de animal");
                    objetoZoo.modificarAnimal();
                    break;
                    
                case 13:
                    System.out.println("\nSeleccionaste realizar visita");
                    objetoZoo.realizarVisita();
                    break;

                case 14:
                    System.out.println("\nSeleccionaste cuidado de animales");
                    objetoZoo.mantenimientoAnimales();
                    break;
                    
                case 15:
                    System.out.println("\nSeleccionaste mostrar mantenimiento de animal");
                    objetoZoo.mostrarMantenimiento();
                    break;
                    
                case 16:
                    System.out.println("\nSaliendo del programa");
                    break;
                    
                default: System.out.println("\nOpción no válida");
            }
            
        }while(opcion !=16);
    }
}



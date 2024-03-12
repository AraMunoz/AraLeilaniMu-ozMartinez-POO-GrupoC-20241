
package tarea7_u2;

import java.util.*;

public class Banco {
  ArrayList <Employee> empleados = new ArrayList<>();

    public Banco(Employee empleado){
        empleados.add(empleado);
    }

    public Banco() {
    }
  public void agregarEmpleado(Employee empleado) {
        empleados.add(empleado);
    }

  
    public List<Employee> getEmpleados() {
        return empleados;
    }

    public void mostrarEmpleados()
    {
        if (empleados.isEmpty()) 
        {
            System.out.println("\nNo hay empleados registrados.");
            return;
        }
        System.out.println("\n*** LISTA DE EMPLEADOS ***");
        for (Employee empleados : empleados) 
        {
            empleados.verCuentas();
            
        }
    }
    public void mostrarEmpleados(long numCuenta){
        if (empleados.isEmpty()) 
        {
            System.out.println("\nNo hay empleados registrados.");
            return;
        }
        System.out.println("\n*** LISTA DE EMPLEADOS ***");
        for (Employee empleados : empleados) 
        {
            if(empleados.account.getAccountNumber()==numCuenta)
                empleados.verCuentas();
            
        }
    }
     public Employee buscarEmpleado(long numCuenta) {
        for (Employee empleado : empleados) {
            for (BankAccount cuenta : empleado.getCuentas()) {
                if (cuenta.getAccountNumber() == numCuenta) {
                    return empleado;
                }
            }
        }
        return null;
}

  
  
    
    
    
}


package tarea7_u2;
import java.util.*;

public class Employee {
    private String name;
    private  int age;
    private double salary;
    BankAccount account; 
    List <BankAccount> cuentas = new ArrayList<>();

    public Employee(String name, int age, double salary, BankAccount account) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.account = account;
    }
    
    
    
    public Employee(String name, int age,  char tipo, double salary, long account) {
        String formatAccoundType = Character.toString(tipo).toUpperCase();
        if( formatAccoundType.equals("A") || formatAccoundType.equals("B") || formatAccoundType.equals("C") ){
            this.name = name;
            this.age = age;
            this.salary = salary;
            this.account = new BankAccount (account, tipo);
        }
        else 
        {
            System.out.println("Ingresa un tipo de cuenta valido");
        }
            
    }

    public List<BankAccount> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<BankAccount> cuentas) {
        this.cuentas = cuentas;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public BankAccount getAccount() {
        return account;
    }

    public void setAccount(BankAccount account) {
        this.account = account;
    }
    
    
    public String getInformation (){
          
       return String.format("El nombre del empleado es  %s su cuenta  %d , su saldo actual es %.2f y la "
        + "cuenta es de tipo %s  ", this.name, this.account.getAccountNumber(), 
        this.account.getMonto(), this.account.tipo);
      
      }
    
    public void verCuentas() 
    {
        System.out.println("\nINFORMACIÓN DEL EMPLEADO");
        System.out.println("Nombre: " + this.getName() + "\nEdad: " + this.getAge() + "\nSalario: " + this.getSalary());
        System.out.println("****Cuentas bancarias:");
        for (BankAccount b : cuentas) {
            b.mostrarInformacion();
        }
    }
    public BankAccount buscarCuenta(long numeroCuenta) 
    {
        for (BankAccount cuenta : cuentas)
        {
            if (cuenta.getAccountNumber() == numeroCuenta) 
            {
                return cuenta;
            }
        }
        return null;
    }
}

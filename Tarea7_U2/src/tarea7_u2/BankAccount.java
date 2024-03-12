
package tarea7_u2;

public class BankAccount {
    Employee empleado;
    private long accountNumber;
    private double monto;
    public char tipo;

    public BankAccount(long accountNumber, char tipo) {
        this.accountNumber = accountNumber;
        this.tipo = tipo;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }
    
    public void mostrarInformacion() {
        System.out.println("Número de cuenta: " + accountNumber + "\nSaldo: " + monto + "\nTipo de cuenta: " + tipo);
    }

    
    public void depositar (double cantidad, char tipo){
        try{
        if( tipo == 'A' || tipo == 'a') addMoneyA(cantidad);
        else if( tipo == 'B' || tipo == 'b') addMoneyB(cantidad);
        else this.monto += cantidad; 
        }catch(Exception e){
            System.out.println("Introduce una cantidad valida para tu cuenta");
        }
    }
    private void addMoneyA(double cantidad){
        if(this.monto + cantidad >= 50000){
            System.out.println("No puedes tener mas de 50 000 en tipo de cuenta A");
            
        }
        else{
            monto = monto + cantidad;
            System.out.println("Se ha depositado correctamente "+cantidad+ " a su cuenta, ahora su saldo es "+this.monto);
            
        }
    }
    private void addMoneyB(double cantidad){
        if(this.monto + cantidad >= 100000){
            System.out.println("No puedes tener mas de 100 000 en tipo de cuenta B");
            
        }
        else{
           
            monto = monto + cantidad;
            System.out.println("Se ha depositado correctamente "+cantidad+ " a su cuenta, ahora su saldo es "+this.monto);
        }
    }
    public void retirar (double cantidad, char tipo){
        if( tipo == 'A'|| tipo == 'a')retirarMoneyA (cantidad);
        else if( tipo == 'B'|| tipo == 'b')retirarMoneyB (cantidad);
        else if( tipo == 'C'|| tipo == 'c')retirarMoneyC (cantidad);
           
    }
    private void retirarMoneyA (double cantidad){
        if( this.monto - cantidad >= 1000 ){
           monto = monto-cantidad;
           System.out.println("Se ha retirado correctamente "+cantidad+ " a su cuenta, ahora su saldo es "+this.monto);
        }
        else 
            System.out.println("No puedes tener menos de 1000 en tu cuenta tipo A");
        }
    private void retirarMoneyB (double cantidad){
        if( this.monto - cantidad >= 5000 ){
           monto = monto-cantidad;
           System.out.println("Se ha retirado correctamente "+cantidad+ " a su cuenta, ahora su saldo es "+this.monto);
        }
        else 
            System.out.println("No puedes tener menos de 5000 en tu cuenta tipo B");
        }
    private void retirarMoneyC (double cantidad){
        if(this.monto - cantidad >= 10000 ){
           monto = monto-cantidad;
           System.out.println("Se ha retirado correctamente "+cantidad+ " a su cuenta, ahora su saldo es "+this.monto);
        }
        else 
            System.out.println("No puedes tener menos de 10000 en tu cuenta tipo C");
        }
    
    private void depositoCorrecto (double cantidad){
        System.out.println("Se ha depositado correctamente" +cantidad+ " a su cuenta, ahora su saldo es"+this.monto);
    }

}

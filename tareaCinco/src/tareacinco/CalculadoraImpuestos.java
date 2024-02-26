
package tareacinco;

public class CalculadoraImpuestos {
    
    
    double CalcularImpuestos ( double dividendos, double porcentajeImpuestos, double exencion ){
        double Impuestos=0;
        Impuestos=dividendos*(porcentajeImpuestos/100);
        if(Impuestos>exencion){
            return Impuestos-exencion;
        }
        else
            return 0;
    }
    double CalcularImpuestos (int ingresos){
        
            return ingresos+0.15;
    }
    double CalcularImpuestos (int ingresos, double porcentajeImpuestos){
        
            return ingresos*(porcentajeImpuestos/100);
    }
}


package examenunidad2;

public class Mantenimiento
{
    
   private static int IDENTIFICADOR = 200;
    private int id;
    private int idEncargado;
    private String tipoDeMantenimiento;
    private String fechaProceso;
    private String observaciones;
    
    public Mantenimiento(int idEncargado,String tipoDeMantenimiento, String fechaProceso, String observaciones ) 
    {
        this.idEncargado=idEncargado;
        this.tipoDeMantenimiento = tipoDeMantenimiento;
        this.fechaProceso = fechaProceso;
        this.observaciones = observaciones;
        this.id=IDENTIFICADOR;
        IDENTIFICADOR++;
    }
 
    public Mantenimiento(int idEncargado, String tipoDeMantenimiento, String fechaProceso)
    {
        this.idEncargado = idEncargado;
        this.tipoDeMantenimiento = tipoDeMantenimiento;
        this.fechaProceso = fechaProceso;
        this.id=IDENTIFICADOR;
        IDENTIFICADOR++;
    }
    
    
    public int getId() {
        return id;
    }
 
    
    public int getIdEncargado() {
        return idEncargado;
    }
    
    
    public String getInformacionMantenimiento()
    {
        return String.format("\nId: %d \nTipo de mantenimiento: %s \nFecha de mantenimiento: %s \nGuia encargado: %d \nObservaciones: %s",
            id,tipoDeMantenimiento, fechaProceso, idEncargado, observaciones );
    }
 
    

}

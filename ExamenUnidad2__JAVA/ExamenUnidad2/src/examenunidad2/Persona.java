
package examenunidad2;

public class Persona 
{
    
    public static int IDENTIFICADOR = 0;
    private String name;
    private String apellidos;
    protected String fechaDeNacimiento;
    private String CURP;
    private int id;
  

    public Persona(String name, String apellidos, String fechaDeNacimiento, String CURP)
    {
        this.name = name;
        this.apellidos = apellidos;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.CURP = CURP;
        
    }

    public Persona() 
    {
    }
   
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(String fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getCURP() {
        return CURP;
    }

    public void setCURP(String CURP) {
        this.CURP = CURP;
    }

    public static int getIDENTIFICADOR() {
        return IDENTIFICADOR;
    }

    public static void setIDENTIFICADOR(int IDENTIFICADOR) {
        Persona.IDENTIFICADOR = IDENTIFICADOR;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
 
}

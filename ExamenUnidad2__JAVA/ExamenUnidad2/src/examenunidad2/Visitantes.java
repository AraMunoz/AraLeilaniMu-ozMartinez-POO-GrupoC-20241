package examenunidad2;
import java.util.ArrayList;

public class Visitantes extends Persona 
{
     public static int IDENTIFICADOR = 0;
    public static int NUMERO_DE_VISITAS = 0;
    private String fechaDeRegistro;
    private int numDeVisitas=0;
    private boolean estaEnVisita = false;
    private int id;

    public Visitantes() {
    }
    
    public Visitantes(String name, String apellidos,
            String fechaDeNacimiento, String CURP, String fechaDeRegistro) 
    {
        super(name, apellidos, fechaDeNacimiento, CURP);
        this.fechaDeRegistro = fechaDeRegistro;
        this.id = IDENTIFICADOR +=1;
        this.estaEnVisita=false;
    }

    public static int getNUMERO_DE_VISITAS() {
        return NUMERO_DE_VISITAS;
    }

    public static void setNUMERO_DE_VISITAS(int NUMERO_DE_VISITAS) {
        Visitantes.NUMERO_DE_VISITAS = NUMERO_DE_VISITAS;
    }

    public String getFechaDeRegistro() {
        return fechaDeRegistro;
    }

    public void setFechaDeRegistro(String fechaDeRegistro) {
        this.fechaDeRegistro = fechaDeRegistro;
    }

    public int getNumDeVisitas() {
        return numDeVisitas;
    }   

    public void setNumDeVisitas() {
        
        this.numDeVisitas++;
        
    }

    public static int getIDENTIFICADOR() {
        return IDENTIFICADOR;
    }

    public static void setIDENTIFICADOR(int IDENTIFICADOR) {
        Visitantes.IDENTIFICADOR = IDENTIFICADOR;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    public boolean getEstaEnVisita() {
        return estaEnVisita;
    }

    public void setEstaEnVisita(boolean estaEnVisita) {
        this.estaEnVisita = estaEnVisita;
    }
    
    public String obtenerInformacionVisitante()
    {
        return String.format("\nId: %d \nNombre: %s \nEdad: %d \nApellido: %s \nFecha de nacimiento: %s \nCurp: %s \nFecha de registro: %s \nNúmero de visitas: %d ",getId(), getName(), calcularEdad(), getApellidos(), getFechaDeNacimiento(), getCURP(),
             fechaDeRegistro, numDeVisitas);
    }

    
    public Visitantes esVisitante(int id, ArrayList <Visitantes> listavisitantes ){
        for(Visitantes visitante: listavisitantes){
            if(visitante.getId()==id){
                return visitante;
            }
        }
        return null;
    }
    public int calcularEdad() 
    {
        // Calcular la edad en años
        // (Suponemos que la fecha de nacimiento está en formato "YYYY-MM-DD")
        String[] nacimiento = fechaDeNacimiento.split("-");
        int anioNacimiento = Integer.parseInt(nacimiento[0]);
        int anioActual = 2024; // Año actual (puede ser obtenido dinámicamente)
        return anioActual - anioNacimiento;
    }
    public double obtenerDescuento() {
        // Cada 5 visitas, se aplica un descuento del 20%
        if (numDeVisitas == 5) {
            return 0.2;
        } else {
            return 0;
        }
    }
}

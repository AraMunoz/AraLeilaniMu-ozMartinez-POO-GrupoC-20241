package examenunidad2;

public class Empleados extends Persona
{
    public static int IDENTIFICADOR = 100;
    private String fechaDeIngresoComoTrabajador;
    private String RFC;
    private double salary;
    private String horario;
    private String rol;
    private int numeroDeRol ;//
    private int id;
    private boolean estaEnVisita;
    public Empleados(String name, String apellidos, String fechaDeNacimiento, String CURP,
            String fechaDeIngresoComoTrabajador, String RFC, double salary, String horario, String rol) 
    {
        super(name, apellidos, fechaDeNacimiento, CURP);
        this.fechaDeIngresoComoTrabajador = fechaDeIngresoComoTrabajador;
        this.RFC = RFC;
        this.salary = salary;
        this.horario = horario;
        this.rol = rol;
        this.id = IDENTIFICADOR +=1;
        if(rol.equals("Guía"))
            this.estaEnVisita=false;
    }
    
    public Empleados(String name, String apellidos, String fechaDeNacimiento, String CURP, int numeroDeRol) 
    {
        super(name, apellidos, fechaDeNacimiento, CURP);
        this.numeroDeRol = numeroDeRol;
    }

    public String getFechaDeIngresoComoTrabajador() {
        return fechaDeIngresoComoTrabajador;
    }

    public void setFechaDeIngresoComoTrabajador(String fechaDeIngresoComoTrabajador) {
        this.fechaDeIngresoComoTrabajador = fechaDeIngresoComoTrabajador;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getNumeroDeRol() {
        return numeroDeRol;
    }

    public void setNumeroDeRol(int numeroDeRol) {
        this.numeroDeRol = numeroDeRol;
    }

    public static int getIDENTIFICADOR() {
        return IDENTIFICADOR;
    }

    public static void setIDENTIFICADOR(int IDENTIFICADOR) {
        Empleados.IDENTIFICADOR = IDENTIFICADOR;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    public String obtenerInformacionEmpleado()
    {
        return String.format("\nId: %d \nNombre: %s \nApellido: %s \nFecha de nacimiento: %s \nCurp: %s \nFecha de ingreso como trabajdor: %s \nRFC: %s \nSalario: %.4f \nHorario: %s \nRol: %s ",id, getName(), getApellidos(), getFechaDeNacimiento(), getCURP(),
             fechaDeIngresoComoTrabajador, RFC,  salary, horario, rol);
    }

    public boolean getEstaEnVisita() {
        return estaEnVisita;
    }

    public void setEstaEnVisita(boolean estaEnVisita) {
        this.estaEnVisita = estaEnVisita;
    }
    
    
}

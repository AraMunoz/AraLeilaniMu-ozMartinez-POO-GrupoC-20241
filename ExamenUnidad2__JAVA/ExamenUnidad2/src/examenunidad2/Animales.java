package examenunidad2;


public class Animales {

    private static int IDENTIFICADOR2 = 1000;
    private int id;
    private String tipoAnimal;
    private String fechaDeLlegada;
    private String[] enfermedad;
    private String tipoDeAlimentacion;
    private String fechaDeNacimiento;
    private double peso;
    private int frecuenciaDeAlimentacion;
    private boolean cuentaConVacunas;

    public Animales(String tipoAnimal, String fechaDeNacimiento, String fechaDeLlegada, String[] enfermedad,
            String tipoDeAlimentacion, double peso,
            int frecuenciaDeAlimentacion, boolean cuentaConVacunas) {
        this.tipoAnimal = tipoAnimal;
        this.fechaDeLlegada = fechaDeLlegada;
        this.enfermedad = enfermedad;
        this.tipoDeAlimentacion = tipoDeAlimentacion;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.peso = peso;
        this.frecuenciaDeAlimentacion = frecuenciaDeAlimentacion;
        this.cuentaConVacunas = cuentaConVacunas;
        this.id = IDENTIFICADOR2 +=1;
    }

    public static int getIDENTIFICADOR2() {
        return IDENTIFICADOR2;
    }

    public static void setIDENTIFICADOR2(int IDENTIFICADOR2) {
        Animales.IDENTIFICADOR2 = IDENTIFICADOR2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(String tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    public String getFechaDeLlegada() {
        return fechaDeLlegada;
    }

    public void setFechaDeLlegada(String fechaDeLlegada) {
        this.fechaDeLlegada = fechaDeLlegada;
    }

    public String[] getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String[] enfermedad) {
        this.enfermedad = enfermedad;
    }

    

    public String getTipoDeAlimentacion() {
        return tipoDeAlimentacion;
    }

    public void setTipoDeAlimentacion(String tipoDeAlimentacion) {
        this.tipoDeAlimentacion = tipoDeAlimentacion;
    }

    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(String fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getFrecuenciaDeAlimentacion() {
        return frecuenciaDeAlimentacion;
    }

    public void setFrecuenciaDeAlimentacion(int frecuenciaDeAlimentacion) {
        this.frecuenciaDeAlimentacion = frecuenciaDeAlimentacion;
    }

    public boolean isCuentaConVacunas() {
        return cuentaConVacunas;
    }

    public void setCuentaConVacunas(boolean cuentaConVacunas) {
        this.cuentaConVacunas = cuentaConVacunas;
    }
    
    public String obtenerInformacionAnimal()
    {
        StringBuilder enfermedadesString = new StringBuilder();
    if (enfermedad != null) {
        for (String e : enfermedad) {
            enfermedadesString.append(e).append(", ");
        }
    }
       return String.format("\nId: %d \nTipo de animal: %s \nFecha de nacimiento: %s \nFecha de llegada al zoológico: %s \nPeso: %.2f \nEnfermedades: %s \nFrecuencia de alimentación: %d \nTipo de alimentación: %s \nCuenta con vacunas: %b",
            id, tipoAnimal, fechaDeNacimiento, fechaDeLlegada, peso, enfermedadesString, frecuenciaDeAlimentacion, tipoDeAlimentacion, cuentaConVacunas);
}
    
    
    
}

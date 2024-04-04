
package examenunidad2;

import java.util.ArrayList;
import java.util.Scanner;

public class Visita 
{
    Scanner leer = new Scanner (System.in);

    public static int IDENTIFICADOR = 90;
    private int guiaCargo;
    double costoTotal;
    private int cantidadNiños;
    private int cantidadAdultos;
    String fechaDeLaVisita;
    int idVisita ;
    ArrayList<Visitantes> listaDeVisitantes = new ArrayList<Visitantes>();
    
    public Visita() {
    }

    public Visita(int guiaACargo, String fechaDeLaVisita, 
                  int cantidadAdultos, int cantidadNiños) 
    {
        this.guiaCargo = guiaCargo;
        this.fechaDeLaVisita = fechaDeLaVisita;
        this.idVisita = IDENTIFICADOR;
        this.cantidadAdultos = cantidadAdultos;
        this.cantidadNiños = cantidadNiños;
        IDENTIFICADOR++;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public int getCantidadNiños() {
        return cantidadNiños;
    }

    public int getCantidadAdultos() {
        return cantidadAdultos;
    }

    public String getFechaDeLaVisita() {
        return fechaDeLaVisita;
    }
    
    public int getIdVisita() {
        return idVisita;
    }

    public static int getIDENTIFICADOR() {
        return IDENTIFICADOR;
    }

    public static void setIDENTIFICADOR(int IDENTIFICADOR) {
        Visita.IDENTIFICADOR = IDENTIFICADOR;
    }

    public int getGuiaCargo() {
        return guiaCargo;
    }

    public void setGuiaCargo(int guiaCargo) {
        this.guiaCargo = guiaCargo;
    }

    public ArrayList<Visitantes> getListaDeVisitantes() {
        return listaDeVisitantes;
    }

    public void setListaDeVisitantes(ArrayList<Visitantes> listaDeVisitantes) {
        this.listaDeVisitantes = listaDeVisitantes;
    }
    
    
    public double calcularCostoTotal(ArrayList<Visitantes> visitantes) 
    {
        double costoAdulto = 100;
        double costoNino = 50;
        int totalAdultos = 0;
        int totalNinos = 0;
        
        for (Visitantes visitante : visitantes)
        {
            if (visitante.calcularEdad() >= 18) 
            {
                totalAdultos++;
            } 
            else 
            {
                totalNinos++;
            }
        }
 
        
        double costoTotal = (totalAdultos * costoAdulto) + (totalNinos * costoNino);
        double descuento = 1 - visitantes.stream().mapToDouble(Visitantes::obtenerDescuento).sum();
        double costoFinal = costoTotal * descuento;
        return costoFinal;
    }

    
    
    
}

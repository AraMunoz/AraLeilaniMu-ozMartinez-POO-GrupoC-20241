package examen_unidad3_herencia.Tarjetas;

import examen_unidad3_herencia.Banco;
import examen_unidad3_herencia.usuarios.Cliente;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class SolicitudTarjetaCredito
{
    private Cliente clienteSolicitando;
    private tipoTarjetaDeCredito tipoTarjeta;
    private EstadoSolicitud status;
    LocalDateTime fechaDeSolicitud;
    int idSolicitud ;
    private static int ID_SOLICITUD;

    static ArrayList<SolicitudTarjetaCredito> listaSolicitudes;

    public SolicitudTarjetaCredito(Cliente clienteSolicitando, tipoTarjetaDeCredito tipoTarjeta, EstadoSolicitud status, LocalDateTime fechaDeSolicitud) {
        this.clienteSolicitando = clienteSolicitando;
        this.tipoTarjeta = tipoTarjeta;
        this.status = status;
        this.fechaDeSolicitud = fechaDeSolicitud;
        this.idSolicitud = ID_SOLICITUD;
        ID_SOLICITUD++;
    }
    public static void mostrarListaSolicitudes(){
        for (SolicitudTarjetaCredito solicitud : Banco.listaSolicitudes) {
            System.out.println("\nID de Solicitud: " + solicitud.getIdSolicitud());
            System.out.println("Usuario: " + solicitud.getClienteSolicitando().getNombre());
            System.out.println("Tipo de Tarjeta: " + solicitud.getTipoTarjeta());
            System.out.println("Estado: " + solicitud.getStatus());
            System.out.println("Fecha de Solicitud: " + solicitud.getFechaDeSolicitud());
            System.out.println();
        }
    }
    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setStatus(EstadoSolicitud status) {
        this.status = status;
    }

    public Cliente getClienteSolicitando() {
        return clienteSolicitando;
    }

    public tipoTarjetaDeCredito getTipoTarjeta() {
        return tipoTarjeta;
    }

    public EstadoSolicitud getStatus() {
        return status;
    }

    public LocalDateTime getFechaDeSolicitud() {
        return fechaDeSolicitud;
    }
}

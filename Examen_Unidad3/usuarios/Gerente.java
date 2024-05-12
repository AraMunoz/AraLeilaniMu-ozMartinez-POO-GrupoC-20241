
package examen_unidad3_herencia.usuarios;

import examen_unidad3_herencia.Banco;
import examen_unidad3_herencia.utils.Rol;
import examen_unidad3_herencia.utils.Sucursal;
import java.util.*;
import java.util.ArrayList;

public class Gerente extends Usuario {

    String userName;
    String contasena;
    public Gerente(String userName, String contrasena, String nombre, String apellidoMaterno, String apellidoPaterno, String fechaDeNacimiento, String ciudad, String estado, String curp, String direccion, String RFC, double salario, Rol rol, Sucursal sucursal, String sexo) {
        super(nombre, apellidoMaterno, apellidoPaterno, fechaDeNacimiento, ciudad, estado, curp, direccion, RFC, salario, rol, sucursal, sexo, userName, contrasena);
        this.userName= userName;
        this.contasena = contrasena;
    }

    public static void generarClaveSeguridad(Usuario usuarioActual) {
        Scanner leer = new Scanner(System.in);

        if (usuarioActual.getRol() != Rol.GERENTE) {
            System.out.println("Acceso no autorizado. Debes ser gerente para generar una clave de seguridad");
            return;
        }else{

            System.out.println("\n***Generar llave de seguridad para inversionista***");
            System.out.println("Ingrese el RFC del inversionista:");
            String buscarRFC = leer.nextLine();

            if (usuarioActual.getSucursal().equals(Sucursal.ACUEDUCTO)) {
                //ArrayList<Usuario> inversionistasAcueducto = new ArrayList<>(Banco.usuariosAcueducto.get(Rol.INVERSIONISTA));
                ArrayList<Usuario> inversionistasAcueducto = Banco.usuariosAcueducto.get(Rol.INVERSIONISTA);
                for (Usuario inversionista : inversionistasAcueducto) {
                    if (inversionista.getRFC().equals(buscarRFC)) {
                        System.out.println("\nIngrese la clave de seguridad:");
                        String nuevaClave = leer.nextLine();

                        Inversionista newInversionista = (Inversionista) inversionista;
                        newInversionista.setLlaveSeguridad(nuevaClave);

                        System.out.println("Se ha asignado llave de seguridad");
                        return;
                    }
                }
            } else if (usuarioActual.getSucursal().equals(Sucursal.MADERO)) {
                ArrayList<Usuario> inversionistasMadero = Banco.usuariosMadero.get(Rol.INVERSIONISTA);
                for (Usuario inversionista : inversionistasMadero) {
                    if (inversionista.getRFC().equals(buscarRFC)) {
                        System.out.println("\nIngrese la clave de seguridad:");
                        String nuevaClave = leer.nextLine();

                        Inversionista newInversionista = (Inversionista) inversionista;
                        newInversionista.setLlaveSeguridad(nuevaClave);


                        System.out.println("Se ha asignado llave de seguridad");
                        return;
                    }
                }
            }
            System.out.println("\nUsuario no encontrado.");
        }
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContasena() {
        return contasena;
    }

    public void setContasena(String contasena) {
        this.contasena = contasena;
    }

    
}

package Escuela;

import Usuarios.Estudiante;
import Usuarios.Rol;
import Usuarios.Usuario;
import com.google.gson.annotations.Expose;
import utilsGlobal.Carrera.Carrera;
import utilsGlobal.Carrera.Carreras;
import utilsGlobal.TipoGrupo;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Grupo

{
    private static int idGrupoCounter = 1;
    @Expose
    private int idGrupo;
    @Expose
    private Carreras carrera;
    @Expose
    private TipoGrupo tipoGrupo;
    @Expose
    private int semestre;
    @Expose
    private int alumnosEnGrupo;

    public Grupo(Carreras carrera, int semestre, TipoGrupo tipoGrupo) {
        this.idGrupo = idGrupoCounter++;
        this.carrera = carrera;
        this.semestre = semestre;
        this.tipoGrupo = tipoGrupo;
        this.alumnosEnGrupo = 0;
    }

    public static Grupo crearNuevoGrupo(Carreras carrera, int semestre, TipoGrupo tipoGrupo) {
        return new Grupo(carrera, semestre, tipoGrupo);
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public int getAlumnosEnGrupo() {
        return alumnosEnGrupo;
    }

    public void agregarAlumno() {
        alumnosEnGrupo++;
    }

    public Carreras getCarrera() {
        return carrera;
    }

    public TipoGrupo getTipoGrupo() {
        return tipoGrupo;
    }

    public int getSemestre() {
        return semestre;
    }
    public static  void registrarGrupo(Usuario usuarioActual) {
        Scanner leer = new Scanner(System.in);

        int semestreAlQuePertenece = 0;
        boolean datoValido = true;

        Carreras carrera = usuarioActual.getCarrera();
        TipoGrupo grupoAoB = null;
        do {
            System.out.print("\nIngrese el ID del semestre: ");
            try {
                semestreAlQuePertenece = leer.nextInt();
                grupoAoB = TipoGrupo.A;
                datoValido = false;
            } catch (Exception e) {
                System.out.println("\nIngrese un número por favor");
                leer.nextLine();
            }
        } while (datoValido);

        Grupo grupoNuevo = new Grupo(carrera, semestreAlQuePertenece, grupoAoB);
        Sistema.grupos.add(grupoNuevo);
        System.out.println("\nEl grupo ha sido registrado con éxito. El id del grupo es: " + grupoNuevo.getIdGrupo());
        Sistema.serializar();
    }
    public static void mostrarUnEstudiante(Usuario usuarioActual, String numeroDeControl){
        if (usuarioActual.getCarrera().equals(Carreras.ISC)) {
            for (Usuario usuario : Sistema.usuariosISC.get(Rol.ESTUDIANTE)) {
                Estudiante estudiante = (Estudiante) usuario;
                if(estudiante.getNumeroDeControl().equals(numeroDeControl))
                    System.out.println(estudiante.toString());

            }
        }
    }

    public String toString()
    {
        return String.format("\nId de grupo: %d \nCarrera: %s \nTipo de grupo: %s \nSemestre: %d \nAlumnos en grupo: %d",idGrupo,carrera,tipoGrupo,semestre,alumnosEnGrupo);
    }

}

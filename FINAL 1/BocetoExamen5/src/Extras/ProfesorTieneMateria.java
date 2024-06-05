package Extras;

import Escuela.Grupo;
import Escuela.Materias;
import Escuela.Sistema;
import Usuarios.Usuario;
import Usuarios.Profesor;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class ProfesorTieneMateria {
    private static int id = 1;
    @Expose
    private int idMateria;
    @Expose
    private  String noControlProfesor;
    @Expose
    int idRelacion;
    @Expose
    int idGrupo;

    public ProfesorTieneMateria(String noControlProfesor, int idMateria, int idGrupo) {
        this.noControlProfesor = noControlProfesor;
        this.idRelacion = id;
        this.idGrupo = idGrupo;
        this.idMateria = idMateria;
        id++;
    }

    //**********************Selección de Materias*********************************
    public static void asignarMaterias(Usuario usuarioActual) {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese el número de control del profesor: ");

        boolean verificarNoControlProfe = true;

        String noControlProfesor = null;
        while (verificarNoControlProfe) {
            try {
                noControlProfesor = leer.nextLine();
                leer.nextLine();
                if (noControlProfesor == null) {
                    throw new Exception("Este dato no puede estar vacío.");
                }
                verificarNoControlProfe = false;
            } catch (Exception error) {
                System.out.println("Ingrese un dato válido, por favor.");
                verificarNoControlProfe = true;
            }
        }

        Profesor profe = filtrarProfesores(noControlProfesor);
        System.out.println(profe);
        
        boolean semestreValido = true;
        int noSemestre = 0;
        do {
            System.out.println("\nIngrese el número de semestre");
            try {
                noSemestre = leer.nextInt();
                semestreValido = false;
            } catch (Exception e) {
                System.out.println("Ingrese solo números");
                leer.nextLine();
            }
        }while(semestreValido);
        

        mostrarListaDeGruposBuscados(noSemestre, usuarioActual);

        boolean idValido = true;
        int idGrupo=0;
        do {
            System.out.println("Ingrese el id del grupo: ");
            try {
                idGrupo = leer.nextInt();
                idValido = false;
            } catch (Exception e) {
                System.out.println("Ingrese solo números");
                leer.nextLine();
            }
        }while(idValido);


        System.out.println("\nPuede seleccionar hasta 3 materias");
        System.out.println("¿Cuántas materias desea impartir?");

        int numeroDeMateriasAElegir = leer.nextInt();
        mostrarMateriasDelGrupo(usuarioActual, noSemestre);
        int materia = 0;
        for (int i = 0; i < numeroDeMateriasAElegir; i++) {
            boolean materiaValida = true;
            do {
                try {
                    System.out.print("\nSeleccione la materia que desea impartir: ");
                    materia = leer.nextInt();

                    materiaValida = false;

                } catch (Exception e) {
                    System.out.println("Ingrese un número por favor");
                    leer.next();
                }
            } while (materiaValida);
            ProfesorTieneMateria nuevaRelacion = new ProfesorTieneMateria(noControlProfesor, materia, idGrupo);
            System.out.print("Se asignó correctamente la materia. El folio de la asignación es: " + nuevaRelacion.getIdRelacion());
            Sistema.listaRelacionProfeYMateria.add(nuevaRelacion);
            Sistema.serializar();
        }
    }

    public static Profesor filtrarProfesores(String noDeControl) {
        for (Profesor buscarProfesores : Sistema.listaProfesores) {
            if (buscarProfesores.getNumeroDeControl().equals(noDeControl)) {
                return buscarProfesores;
            }
        }
        return null;
    }

    public int getIdRelacion() {
        return idRelacion;
    }

    public static List<Grupo> buscarGruposPorSemestreYCarrera(int numeroSemestre, Usuario
            usuarioActual) {
        List<Grupo> gruposEncontrados = new ArrayList<>();
        for (Grupo grupo : Sistema.grupos) {
            if (grupo.getSemestre() == numeroSemestre && grupo.getCarrera().equals(usuarioActual.getCarrera())) {
                gruposEncontrados.add(grupo);
            }
        }
        return gruposEncontrados;
    }

    public static void mostrarListaDeGruposBuscados(int idSemestre, Usuario usuarioActual) {
        List<Grupo> grupos = buscarGruposPorSemestreYCarrera(idSemestre, usuarioActual);
        if (!grupos.isEmpty()) {
            System.out.println("Grupos del semestre " + idSemestre + " para la carrera " + usuarioActual.getCarrera() + ":");
            for (Grupo grupo : grupos) {
                if (grupo.getCarrera().equals(usuarioActual.getCarrera()))
                    System.out.println(grupo.getIdGrupo());
            }
        } else {
            System.out.println("No se encontraron grupos para el semestre " + idSemestre + " y la carrera " + usuarioActual.getCarrera());
        }
    }

    public static List<Materias> obtenerMateriasPorGrupo(Usuario usuarioActual, int idSemestre) {
        List<Materias> materiasDelGrupo = new ArrayList<>();
        String carreraUsuario = String.valueOf(usuarioActual.getCarrera());
        for (Materias materia : Sistema.listaMaterias) {
            String carreraMateria = String.valueOf(materia.getCarrera());
            if (materia.getNombreSemestre() == idSemestre) {
                if (carreraUsuario.equals(carreraMateria)) {
                    materiasDelGrupo.add(materia);
                }
            }

        }
        return materiasDelGrupo;
    }

    public static void mostrarMateriasDelGrupo(Usuario usuarioActual, int noSemestre) {
        List<Materias> listaMateriasDelGrupo = obtenerMateriasPorGrupo(usuarioActual, noSemestre);
        for (Materias mostrarMateria : listaMateriasDelGrupo) {
            System.out.println("Materia: " + mostrarMateria.getNombre() + "  ID: " + mostrarMateria.getId());
        }
    }

    public static void mostrarMateria(int idMateria) {
        for (Materias buscarMateria : Sistema.listaMaterias) {
            if (buscarMateria.getId() == idMateria) {
                System.out.println("Materia: " + buscarMateria.getNombre());
                return;
            }
        }
    }

    public static void mostrarProfesorYMateria(Usuario usuarioActual) {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese el folio de asignación que desea ver: ");
        int buscarRelacion = leer.nextInt();

        for (ProfesorTieneMateria datosDeRelacion : Sistema.listaRelacionProfeYMateria) {
            if (datosDeRelacion.getIdRelacion() == buscarRelacion) {
                Profesor profeAMostrar = filtrarProfesores(datosDeRelacion.getNoControlProfesor());
                System.out.println("Profesor: " + profeAMostrar.getNombre());
                System.out.println("Carrera: " + profeAMostrar.getCarrera());
                System.out.println("No. De Control: " + profeAMostrar.getNumeroDeControl());
                System.out.println("ID Grupo: " + datosDeRelacion.getIdGrupo());
                mostrarMateria(datosDeRelacion.getIdMateria());
            }
        }
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        ProfesorTieneMateria.id = id;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public String getNoControlProfesor() {
        return noControlProfesor;
    }

    public  void setNoControlProfesor(String noControlProfesor) {
        this.noControlProfesor = noControlProfesor;
    }

    public void setIdRelacion(int idRelacion) {
        this.idRelacion = idRelacion;
    }

    public int getIdGrupo() {
        return idGrupo;
    }
    @Override
    public String toString() {
        return String.format("Profesor tiene materia: idMateria=%d, noControlProfesor= %s, idRelacion=%d, idGrupo=%d}", idMateria, noControlProfesor, idRelacion, idGrupo);
    }
    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }
}
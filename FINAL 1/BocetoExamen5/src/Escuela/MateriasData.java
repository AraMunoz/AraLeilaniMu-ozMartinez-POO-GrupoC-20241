package Escuela;

import java.util.ArrayList;

public class MateriasData {


    public static void agregarMaterias() {
        // Datos para la carrera de ISC
        Sistema.listaMaterias.add(new Materias(0, "Programación 1", "ISC", 1));
        Sistema.listaMaterias.add(new Materias(1, "Probabilidad 1", "ISC", 1));
        Sistema.listaMaterias.add(new Materias(2, "Cálculo 1", "ISC", 1));
        Sistema.listaMaterias.add(new Materias(3, "Programación 2", "ISC", 2));
        Sistema.listaMaterias.add(new Materias(4, "Probabilidad 2", "ISC", 2));
        Sistema.listaMaterias.add(new Materias(5, "Cálculo 2", "ISC", 2));
        Sistema.listaMaterias.add(new Materias(6, "Programación 3", "ISC", 3));
        Sistema.listaMaterias.add(new Materias(7, "Probabilidad 3", "ISC", 3));
        Sistema.listaMaterias.add(new Materias(8, "Cálculo 3", "ISC", 3));

        // Datos para la carrera de IMAT
        Sistema.listaMaterias.add(new Materias(9, "Estadística 1", "IMAT", 1));
        Sistema.listaMaterias.add(new Materias(10, "Contabilidad 1", "IMAT", 1));
        Sistema.listaMaterias.add(new Materias(11, "Cálculo 1", "IMAT", 1));
        Sistema.listaMaterias.add(new Materias(12, "Estadística 2", "IMAT", 2));
        Sistema.listaMaterias.add(new Materias(13, "Contabilidad 2", "IMAT", 2));
        Sistema.listaMaterias.add(new Materias(14, "Cálculo 2", "IMAT", 2));
        Sistema.listaMaterias.add(new Materias(15, "Estadística 3", "IMAT", 3));
        Sistema.listaMaterias.add(new Materias(16, "Contabilidad 3", "IMAT", 3));
        Sistema.listaMaterias.add(new Materias(17, "Cálculo 3", "IMAT", 3));

        // Datos para la carrera de ELC
        Sistema.listaMaterias.add(new Materias(18, "Redes 1", "ELC", 1));
        Sistema.listaMaterias.add(new Materias(19, "Circuitos 1", "ELC", 1));
        Sistema.listaMaterias.add(new Materias(20, "Cálculo 1", "ELC", 1));
        Sistema.listaMaterias.add(new Materias(21, "Redes 2", "ELC", 2));
        Sistema.listaMaterias.add(new Materias(22, "Circuitos 2", "ELC", 2));
        Sistema.listaMaterias.add(new Materias(23, "Cálculo 2", "ELC", 2));
        Sistema.listaMaterias.add(new Materias(24, "Redes 3", "ELC", 3));
        Sistema.listaMaterias.add(new Materias(25, "Circuitos 3", "ELC", 3));
        Sistema.listaMaterias.add(new Materias(26, "Cálculo 3", "ELC", 3));
        Sistema.serializar();
    }
}
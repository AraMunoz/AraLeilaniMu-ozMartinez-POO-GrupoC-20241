package examenunidad2;

import java.util.ArrayList;
import java.util.Scanner;

public class Zoo {
    
    Scanner leer = new Scanner(System.in);
    Visita visitaPrueba = new Visita();
    
    int cantidadAdultos;
    int cantidadNiños;
    
    //***********************LISTAS******************************************
    ArrayList<Empleados> listaDeEmpleados = new ArrayList<Empleados>();
    ArrayList<Empleados> listaDeEmpleadosVeterinarios = new ArrayList<Empleados>();
    ArrayList<Empleados> listaDeEmpleadosGuias = new ArrayList<Empleados>();
    ArrayList<Empleados> listaDeEmpleadosAdministrativos = new ArrayList<Empleados>();
    ArrayList<Empleados> listaDeEmpleadosMantenimiento = new ArrayList<Empleados>();
    ArrayList<Visitantes> listaDeVisitantesAdultos = new ArrayList<Visitantes>();
    ArrayList<Visitantes> listaDeVisitantesMenores = new ArrayList<Visitantes>();
    ArrayList<Animales> listaDeAnimales = new ArrayList<Animales>();
    ArrayList<Visitantes> listavisitantes = new ArrayList<Visitantes>();

    //
    ArrayList<Visitantes> listaDeVisitantesAdultosEnVisita = new ArrayList<Visitantes>();
    ArrayList<Visitantes> listaDeVisitantesMenoresEnVisita = new ArrayList<Visitantes>();
    //Listas de visitantes dentro de una visitasS
    ArrayList<Visitantes> listaDeVisitantes = new ArrayList<Visitantes>();
    ArrayList<Visita> listaDeVisitas = new ArrayList<Visita>();

    //************************************REGISTROS*********************************
    public ArrayList<String> registrarPersonaEmpleado() {
        ArrayList<String> datosPersona = new ArrayList<String>();

        System.out.println("\nTu ID se genera automáticamente");
        System.out.print("Ingresar el nombre: ");
        String newName = leer.nextLine();
        datosPersona.add(newName);

        System.out.print("Apellido: ");
        String newApellido = leer.nextLine();
        datosPersona.add(newApellido);

        System.out.print("Fecha de Nacimiento:");
        String registrarFechaDeNacimiento = leer.nextLine();
        datosPersona.add(registrarFechaDeNacimiento);

        System.out.print("CURP:");
        String newCURP = leer.nextLine();
        datosPersona.add(newCURP);

        System.out.print("Fecha de ingreso:");
        String registrarFechaDeIngreso = leer.nextLine();
        datosPersona.add(registrarFechaDeIngreso);

        System.out.print("Ingresar RFC:");
        String newRFC = leer.nextLine();
        datosPersona.add(newRFC);

        System.out.print("Ingresar salario: ");
        double newSalary = leer.nextDouble();
        datosPersona.add(String.valueOf(newSalary));

        leer.nextLine();
        System.out.print("Ingresar horario: ");
        String newHorario = leer.nextLine();
        datosPersona.add(newHorario);

        System.out.print("\n**Ingresar rol** \n1. Veterinario. \n2. Guía. \n3. Administración. \n4. Mantenimiento");
        System.out.print("\n\nSeleccione una opción: ");
        int numeroDeRol = leer.nextInt();

        String newRol = "";
        switch (numeroDeRol) {
            case 1:
                newRol = "Veterinario";
                datosPersona.add(newRol);
                break;
            case 2:
                newRol = "Guía";
                datosPersona.add(newRol);
                break;
            case 3:
                newRol = "Administración";
                datosPersona.add(newRol);
                break;
            case 4:
                newRol = "Mantenimiento";
                datosPersona.add(newRol);
                break;
            default:
                System.out.println("Ingrese una opción válida.");

        }

        Empleados newEmpleado = new Empleados(newName, newApellido, registrarFechaDeNacimiento, newCURP,
                registrarFechaDeIngreso, newRFC, newSalary, newHorario, newRol);
        leer.nextLine();
        tipoDeEmpleado(numeroDeRol, newEmpleado);
        listaDeEmpleados.add(newEmpleado);

        System.out.println("\n**Empleado registrado, el id generado es " + newEmpleado.getId() + " **");
        return datosPersona;
    }

    public void tipoDeEmpleado(int numeroDeRol, Empleados newEmpleado) {

        switch (numeroDeRol) {
            case 1:
                leer.nextLine();
                listaDeEmpleadosVeterinarios.add(newEmpleado);
                break;

            case 2:
                leer.nextLine();
                listaDeEmpleadosGuias.add(newEmpleado);
                break;

            case 3:
                leer.nextLine();
                listaDeEmpleadosAdministrativos.add(newEmpleado);
                break;

            case 4:
                leer.nextLine();
                listaDeEmpleadosMantenimiento.add(newEmpleado);
                break;

            default:
                System.out.println("Ingrese una opción váldia.");
                leer.nextLine();
        }

    }

    public void registrarVisitantes() {
        ArrayList<String> datosPersonaVisitante = new ArrayList<String>();

        System.out.println("\nTu ID se genera automáticamente");

        leer.nextLine();
        System.out.print("Ingresar el nombre: ");
        String newName = leer.nextLine();
        datosPersonaVisitante.add(newName);

        System.out.print("Apellido: ");
        String newApellido = leer.nextLine();
        datosPersonaVisitante.add(newApellido);

        System.out.print("Fecha de Nacimiento con formato YYYY-MM-DD:");
        String registrarFechaDeNacimiento = leer.nextLine();
        datosPersonaVisitante.add(registrarFechaDeNacimiento);

        System.out.print("CURP:");
        String newCURP = leer.nextLine();
        datosPersonaVisitante.add(newCURP);

        System.out.print("Fecha de Registro:");
        String fechaDeRegistro = leer.nextLine();
        datosPersonaVisitante.add(newCURP);

        Visitantes newVisitante = new Visitantes(newName, newApellido, registrarFechaDeNacimiento, newCURP,
                fechaDeRegistro);

        listavisitantes.add(newVisitante);
        if (newVisitante.calcularEdad() >= 18) {
            listaDeVisitantesAdultos.add(newVisitante);
        } else {
            listaDeVisitantesMenores.add(newVisitante);
        }

        System.out.println("\n**Visitante registrado, el id generado es " + newVisitante.getId() + " **");
    }

    public void registrarAnimal() {
        leer.nextLine();
        System.out.println("\nEl id se genera automáticamente");
        System.out.print("Ingresa el tipo de animal: ");
        String tipoAnimal = leer.nextLine();

        System.out.print("Ingresa la fecha de nacimiento del animal: ");
        String fechaDeNacimiento = leer.nextLine();

        System.out.print("Ingresa la fecha de llegada del animal: ");
        String fechaDeLlegada = leer.nextLine();

        System.out.print("El animal tiene alguna enfermedad? Si/No: ");
        String enfermedad = leer.nextLine();

        String[] enfermedades = null;
        if (enfermedad.equals("Si") || enfermedad.equals("SI") || enfermedad.equals("si")) {
            System.out.println("\nNúmero de enfermedades: ");
            int totalEnfermedades = leer.nextInt();

            enfermedades = new String[totalEnfermedades];
            leer.nextLine();

            for (int i = 0; i < totalEnfermedades; i++) {
                System.out.println("Enfermedad " + (i + 1) + " : ");
                enfermedades[i] = leer.nextLine();
            }
        }

        System.out.print("Ingresa el tipo de alimentacion del animal: ");
        String tipoDeAlimentacion = leer.nextLine();

        System.out.print("Ingresa el peso del animal: ");
        double peso = leer.nextDouble();

        System.out.print("Ingresa la frecuencia de alimentacion del animal: ");
        int frecuenciaDeAlimentacion = leer.nextInt();

        leer.nextLine();
        System.out.print("\nEl animal cuenta con vacunas \n 1.Si \n 2.No ");
        System.out.println("\nSeleccione una opción: ");
        int cuentaConVacuna = leer.nextInt();
        boolean cuentaConVacunas = (cuentaConVacuna == 1);

        Animales animal = new Animales(tipoAnimal, fechaDeNacimiento, fechaDeLlegada, enfermedades,
                tipoDeAlimentacion, peso, frecuenciaDeAlimentacion, cuentaConVacunas);
        listaDeAnimales.add(animal);

        System.out.println("\n**Animal registrado, el id generado es " + animal.getId() + " **");
    }

    //******************************MOSTRAR LISTAS***********************************
    public void mostrarEmpleados() {
        if (listaDeEmpleados.isEmpty()) {
            System.out.println("\n\t***No hay empleados registrados***");
            return;
        } else {
            System.out.println("\n***Empleados registrados***");
            for (Empleados contador : listaDeEmpleados) {
                System.out.println(contador.obtenerInformacionEmpleado());
            }
        }

    }

    public void mostrarTodosLosVisitantes() {
        if (listavisitantes.isEmpty()) {
            System.out.println("\n\t***No hay visitantes registrados***");
            return;
        } else {
            System.out.println("\n***Total de Visitantes registrados***");

            for (Visitantes contador : listavisitantes) {
                System.out.println(contador.obtenerInformacionVisitante());
            }
        }

    }

    public void mostrarVisitantesAdultos() {
        if (listaDeVisitantesAdultos.isEmpty()) {
            System.out.println("\n\t***No hay visitantes adultos registrados***");
            return;
        } else {
            System.out.println("\n***Visitantes adultos registrados***");

            for (Visitantes contador : listaDeVisitantesAdultos) {
                System.out.println(contador.obtenerInformacionVisitante());
            }
        }

    }

    public void mostrarVisitantesMenores() {
        if (listaDeVisitantesMenores.isEmpty()) {
            System.out.println("\n\t***No hay visitantes menores registrados***");
            return;
        } else {
            System.out.println("\n***Visitantes menores registrados***");

            for (Visitantes contador : listaDeVisitantesMenores) {
                System.out.println(contador.obtenerInformacionVisitante());
            }
        }

    }

    public void mostrarAnimales() {
        if (listaDeAnimales.isEmpty()) {
            System.out.println("\n\t***No hay animales registrados***");
            return;
        } else {
            System.out.println("\n***Animales registrados***");

            for (Animales contador : listaDeAnimales) {
                System.out.println(contador.obtenerInformacionAnimal());
            }
        }

    }

    //***************************ELIMINACIÓN**********************************
    public void eliminarEmpleado() {
        System.out.print("\nIngresa el id del empleado que deseas eliminar: ");
        int id = leer.nextInt();
        int indiceDelEliminado = 0;

        for (Empleados empleado : listaDeEmpleados) {
            if (empleado.getId() == id && empleado.getEstaEnVisita()==false) {
                listaDeEmpleados.remove(indiceDelEliminado);
                System.out.println("\n**El empleado ha sido eliminado de forma correcta**");
                return;
            }
            indiceDelEliminado++;
        }
        System.out.println("No fue posible eliminar ese empleado.");
    }

    public void eliminarVisitante() {
        System.out.println("\n**Listas disponibles**");
        System.out.println("\n1. Niños \n2. Adultos");
        System.out.println("\nSeleccione una lista: ");
        int opcion = leer.nextInt();

        switch (opcion) {
            case 1:
                System.out.print("\nIngresa el id del visitante menor que deseas eliminar: ");
                int id = leer.nextInt();
                int indiceDelEliminado = 0;

                for (Visitantes visitante : listaDeVisitantesMenores) {
                    if (visitante.getId() == id && visitante.getEstaEnVisita()==false) {
                        listaDeVisitantesMenores.remove(indiceDelEliminado);
                        System.out.println("\n**El visitante menor ha sido eliminado de forma correcta**");
                        return;
                    }
                    indiceDelEliminado++;
                }
                System.out.println("No fue posible eliminar ese visitante. ");
                break;

            case 2:
                System.out.print("\nIngresa el id del visitante adulto que deseas eliminar: ");
                int id2 = leer.nextInt();
                int indiceDelEliminado2 = 0;

                for (Visitantes visitante : listaDeVisitantesAdultos) {
                    if (visitante.getId() == id2 && visitante.getEstaEnVisita()==false) {
                        listaDeVisitantesAdultos.remove(indiceDelEliminado2);
                        System.out.println("\n**El visitante adulto ha sido eliminado de forma correcta**");
                        return;
                    }
                    indiceDelEliminado2++;
                }
                System.out.println("No fue posible eliminar ese visitante. ");
                break;
        }

    }

    public void eliminarAnimal() {
        System.out.print("\nIngresa el id del animal que deseas eliminar: ");
        int id = leer.nextInt();
        int indiceDelEliminado = 0;
        for (Animales animal : listaDeAnimales) {
            if (animal.getId() == id) {
                listaDeAnimales.remove(indiceDelEliminado);
                System.out.println("\n**El animal ha sido eliminado de forma correcta**");
                return;
            }
            indiceDelEliminado++;
        }
    }

    //****************************MODIFICACIÓN DE DATOS********************************
    public void modificarEmpleado() {
        System.out.print("\nIngrese el id: ");
        int empleadoID = leer.nextInt();
        for (Empleados buscarEmpleado : listaDeEmpleados) {
            if (buscarEmpleado.getId() == empleadoID) {
                int seguirModificando;
                do {
                    System.out.print("\n¿Qué desea modificar?: \n");
                    System.out.println("\n1. Nombre. \n2. Apellido. \n3. Fecha De Nacimiento \n4. CURP. \n5. Fecha De Ingreso Como Trabajador. \n6. RFC  \n7. Salario. \n8. Horario \n9. Rol");
                    
                    System.out.print("\nSeleccione una opción: ");
                    int modificacion = leer.nextInt();
                    
                    ArrayList<String> datosPersona = new ArrayList<String>();
                    switch (modificacion) {
                        case 1:
                            leer.nextLine();
                            System.out.print("\nNuevo nombre: ");
                            String newName = leer.nextLine();
                            buscarEmpleado.setName(newName);
                            break;
                        case 2:
                            leer.nextLine();
                            System.out.print("\nNuevo apellido");
                            String newApellido = leer.nextLine();
                            buscarEmpleado.setApellidos(newApellido);
                            break;
                        case 3:
                            leer.nextLine();
                            System.out.print("\nNueva fecha de nacimiento: ");
                            String newFechaDeNacimiento = leer.nextLine();
                            buscarEmpleado.setFechaDeNacimiento(newFechaDeNacimiento);
                            break;
                        case 4:
                            leer.nextLine();
                            System.out.print("\nCorrección de CURP: ");
                            String newCURP = leer.nextLine();
                            buscarEmpleado.setCURP(newCURP);
                            break;
                        case 5:
                            leer.nextLine();
                            System.out.print("\nFecha de ingreso como trabajador: ");
                            String newFechaDeIngreso = leer.nextLine();
                            buscarEmpleado.setFechaDeIngresoComoTrabajador(newFechaDeIngreso);
                            break;
                        case 6:
                            leer.nextLine();
                            System.out.print("\nNuevo RFC: ");
                            String newRFC = leer.nextLine();
                            buscarEmpleado.setRFC(newRFC);
                            break;
                        case 7:
                            leer.nextLine();
                            System.out.print("\nNuevo Salario: ");
                            double newSalary = leer.nextDouble();
                            buscarEmpleado.setSalary(newSalary);
                            break;
                        case 8:
                            leer.nextLine();
                            System.out.print("\nNuevo horario de trabajo: ");
                            String newHorario = leer.nextLine();
                            buscarEmpleado.setHorario(newHorario);
                            break;
                        case 9:
                            leer.nextLine();
                            System.out.print("\nNuevo rol: ");
                            System.out.println(" \n1. Veterinario. \n2. Guía. \n3. Administración. \n4. Mantenimiento. \n5. Exit:");
                            System.out.print("\nEscriba el número: ");
                            int numeroDeRol = leer.nextInt();
                            buscarEmpleado.setNumeroDeRol(numeroDeRol);
                            leer.nextLine();
                            String newRol;
                            switch (numeroDeRol) {
                                case 1:
                                    newRol = "Veterinario";
                                    datosPersona.add(newRol);
                                    break;
                                case 2:
                                    newRol = "Guía";
                                    datosPersona.add(newRol);
                                    break;
                                case 3:
                                    newRol = "Administración";
                                    datosPersona.add(newRol);
                                    break;
                                case 4:
                                    newRol = "Mantenimiento";
                                    datosPersona.add(newRol);
                                    break;
                                default:
                                    System.out.println("\nIngrese una opción váldia.");
                                    leer.nextLine();
                            }
                            break;
                        default:
                            System.out.println("Ingrese una opción válida.");
                    }
                    System.out.println("¿Desea seguir modificando? \n1. Sí. \n2. No.");
                    System.out.print("\nSeleccione una opción: ");
                    seguirModificando = leer.nextInt();
                } while (seguirModificando != 2);
            }
        }
    }

    public void modificarVisitante() {

        System.out.println("\n**Listas disponibles**");
        System.out.println("\n1. Niños \n2. Adultos");
        System.out.print("\nSeleccione una lista: ");
        int opcion = leer.nextInt();

        switch (opcion) {
            case 1:
                System.out.print("Ingrese el id del visitante menor: ");
                int buscarVisitante = leer.nextInt();

                for (Visitantes newVisitante : listaDeVisitantesMenores) {
                    if (newVisitante.getId() == buscarVisitante) {
                        int seguirModificando;
                        do {
                            System.out.print("\n¿Qué desea modificar?: ");
                            System.out.println("\n1. Nombre.   \n2. Apellido.   \n3. Fecha De Nacimiento."
                                    + "\n4. CURP.    \n5. Fecha De Registro");
                            System.out.print("\nSeleccione una opción: ");
                            int modificacion = leer.nextInt();
                            leer.nextLine();

                            switch (modificacion) {
                                case 1:
                                    System.out.print("\nNuevo nombre: ");
                                    String newName = leer.nextLine();
                                    newVisitante.setName(newName);
                                    break;
                                case 2:
                                    System.out.print("\nNuevo apellido: ");
                                    String newApellido = leer.nextLine();
                                    newVisitante.setApellidos(newApellido);
                                    break;
                                case 3:
                                    System.out.print("\nNueva fecha de nacimiento: ");
                                    String newFechaDeNacimiento = leer.nextLine();
                                    newVisitante.setFechaDeNacimiento(newFechaDeNacimiento);
                                    break;
                                case 4:
                                    System.out.print("\nNueva CURP: ");
                                    String newCURP = leer.nextLine();
                                    newVisitante.setCURP(newCURP);
                                    break;
                                case 5:
                                    System.out.print("\nNueva fecha de registro: ");
                                    String newFechaDeRegistro = leer.nextLine();
                                    newVisitante.setFechaDeRegistro(newFechaDeRegistro);
                                    break;
                                default:
                                    System.out.println("\nOpción no válida.");
                            }
                            System.out.print("\n¿Desea seguir modificando? \n1: Sí \n2: No");
                            System.out.print("\nSeleccione una opción: ");
                            seguirModificando = leer.nextInt();
                            leer.nextLine();

                        } while (seguirModificando != 2);
                    } else {
                        System.out.println("\nEl visitante no fue encontrado.");
                    }
                }

                break;

            case 2:

                System.out.println("\nIngrese el id del visitante adulto: ");
                int buscarVisitante2 = leer.nextInt();

                for (Visitantes newVisitante : listaDeVisitantesAdultos) {
                    if (newVisitante.getId() == buscarVisitante2) {
                        int seguirModificando;
                        do {
                            System.out.print("\n¿Qué desea modificar?: ");
                            System.out.println("\n1. Nombre.   \n2. Apellido.   \n3. Fecha De Nacimiento."
                                    + "\n4. CURP.    \n5. Fecha De Registro");
                            System.out.print("\nSeleccione una opción: ");
                            int modificacion = leer.nextInt();
                            leer.nextLine();

                            switch (modificacion) {
                                case 1:
                                    System.out.print("\nNuevo nombre: ");
                                    String newName = leer.nextLine();
                                    newVisitante.setName(newName);
                                    break;
                                case 2:
                                    System.out.print("\nNuevo apellido: ");
                                    String newApellido = leer.nextLine();
                                    newVisitante.setApellidos(newApellido);
                                    break;
                                case 3:
                                    System.out.print("\nNueva fecha de nacimiento: ");
                                    String newFechaDeNacimiento = leer.nextLine();
                                    newVisitante.setFechaDeNacimiento(newFechaDeNacimiento);
                                    break;
                                case 4:
                                    System.out.print("\nNueva CURP: ");
                                    String newCURP = leer.nextLine();
                                    newVisitante.setCURP(newCURP);
                                    break;
                                case 5:
                                    System.out.print("\nNueva fecha de registro: ");
                                    String newFechaDeRegistro = leer.nextLine();
                                    newVisitante.setFechaDeRegistro(newFechaDeRegistro);
                                    break;
                                default:
                                    System.out.println("\nOpción no válida.");
                            }
                            System.out.print("\n¿Desea seguir modificando? \n1: Sí \n2: No");
                            System.out.print("\nSeleccione una opción: ");
                            seguirModificando = leer.nextInt();
                            leer.nextLine();

                        } while (seguirModificando != 2);
                    } else {
                        System.out.println("\nEl visitante no fue encontrado.");
                    }
                }
                break;

            default:
                System.out.println("\nOpción no válida");
        }

    }


    public void modificarAnimal() {
        System.out.print("\nIngresa el id del animal que deseas modificar: ");
        int id = leer.nextInt();
        
        leer.nextLine();
        int opcion = 0;
        for (Animales animal : listaDeAnimales) {
            if (animal.getId() == id) {
                do {
                    System.out.println("\nQue deseas modificar del animal? ");
                    System.out.println("1. Tipo de animal");
                    System.out.println("2. Fecha de nacimiento");
                    System.out.println("3. Fecha de llegada");
                    System.out.println("4. Enfermedades");
                    System.out.println("5. Tipo de alimentacion");
                    System.out.println("6. Peso");
                    System.out.println("7. Frecuencia de alimentacion");
                    System.out.println("8. Cuenta con vacunas");
                    System.out.println("9.Salir ");
                    
                    System.out.print("\nSeleccione una opción: ");
                    opcion = leer.nextInt();
                    
                    leer.nextLine();
                    switch (opcion) {
                        case 1:
                            System.out.print("\nIngresa el tipo de animal: ");
                            String tipo = leer.nextLine();
                            animal.setTipoAnimal(tipo);
                            break;
                        case 2:
                            System.out.print("\nIngresa la fecha de nacimiento: ");
                            String fecha = leer.nextLine();
                            animal.setFechaDeNacimiento(fecha);
                            break;
                        case 3:
                            System.out.print("\nIngresa la fecha de llegada: ");
                            String llegada = leer.nextLine();
                            animal.setFechaDeLlegada(llegada);
                            break;
                        case 4:
                            System.out.println("\nIngresa las enfermedades: ");
                            
                            int numeroEnfermedades = animal.getEnfermedad().length;
                            
                            String[] enfermedades = new String[numeroEnfermedades];
                            
                            leer.nextLine();
                            
                            for (int i = 0; i < numeroEnfermedades; i++) 
                            {
                                System.out.println("Enfermedad " + (i + 1) + " : ");
                                enfermedades[i] = leer.nextLine();
                            }
                            animal.setEnfermedad(enfermedades);
                            break;
                        case 5:
                            System.out.print("\nIngresa el tipo de alimentacion: ");
                            String alimentacion = leer.nextLine();
                            animal.setTipoDeAlimentacion(alimentacion);
                            break;
                        case 6:
                            System.out.print("\nIngresa el peso: ");
                            double peso = leer.nextDouble();
                            animal.setPeso(peso);
                            break;
                        case 7:
                            System.out.print("\nIngresa la frecuencia de alimentacion: ");
                            int frecuenciaAlimentos = leer.nextInt();
                            animal.setFrecuenciaDeAlimentacion(frecuenciaAlimentos);
                            break;
                        case 8:
                            System.out.print("\nCuenta con vacunas. \n 1.Si \n 2.No");
                            System.out.println("\nSeleccione una opción");
                            
                            String vacunas = leer.nextLine();
                            if (vacunas == "si" || vacunas == "Si" || vacunas == "SI") 
                            {
                                animal.setCuentaConVacunas(true);
                            } 
                            else if (vacunas == "no" || vacunas == "No" || vacunas == "NO") 
                            {
                                animal.setCuentaConVacunas(false);
                            }
                            break;
                            
                        case 9:
                            System.out.println("\nSalir");
                            break;
                        default:
                            System.out.println("Ingresa una opcion valida");
                            leer.nextLine();
                    }
                } while (opcion != 9);
            }
        }
        if (opcion == 0) {
            System.out.println("\nEl animal no fue encontrado, verifica el id ingresado. ");
        }
    }

    //***************************VISITAS**************************************
    public void realizarVisita()
    {
        ArrayList<Visitantes> listaDeVisitantes = new ArrayList<Visitantes>();
        System.out.print("\nIngresa el id del guia: ");
        int idGuia = leer.nextInt();
        
        if(esGuia(idGuia))
        {
            Visita newVisita = new Visita();
            System.out.print("Ingresa la cantidad de visitantes: ");
            int numeroVisitantes = leer.nextInt();
            
            leer.nextLine();
            
            int idVisitante;
            for(int i=0; i<numeroVisitantes; i++)
            {
                System.out.print("Ingresa el id del visitante: ");
                idVisitante = leer.nextInt();
                
                Visitantes newVisitante = new Visitantes();
                
                if(esVisitante(idVisitante))
                {
                    newVisitante.esVisitante(idVisitante, listavisitantes).setNumDeVisitas();
                    newVisitante.esVisitante(idVisitante, listavisitantes).setEstaEnVisita(true);
                    listaDeVisitantes.add(newVisitante.esVisitante(idVisitante, listavisitantes));
                    agregarVisitante(newVisitante.esVisitante(idVisitante, listavisitantes));
                }
            }  
            leer.nextLine();
            System.out.print("Fecha de la visita con formato YYYY-MM-DD: ");
            String fechaDeLaVisita = leer.nextLine();
            
            
             Visita newwVisita = new Visita(idGuia, fechaDeLaVisita,
                    cantidadAdultos, cantidadNiños);
            
            System.out.print("\n**Visita agregada, el id generado es " +newwVisita.getIdVisita() +"**");
            
            
            System.out.println("\n\n***Información de visita***");
            System.out.println("Id de visita: "+newwVisita.getIdVisita());
            System.out.println("No. de adultos en visita: " + newwVisita.getCantidadAdultos());
            System.out.println("No. de niños en visita: " + newwVisita.getCantidadNiños());
            System.out.println("Fecha de la visita: " + newwVisita.getFechaDeLaVisita());
            System.out.println("Costo total de la visita: " + newwVisita.calcularCostoTotal(listaDeVisitantes));
        }
    }
    
    public boolean esVisitante(int id)
    {
        for(Visitantes visitante: listavisitantes)
        {
            if(visitante.getId()==id)
            {
                return true;
            }
        }
        return false;
    }
    
    void agregarVisitante(Visitantes visitante) 
    {
        if (esAdulto(visitante))
        {
            cantidadAdultos++;
        } 
        else 
        {
            cantidadNiños++;
        }
    }
    
    public boolean esAdulto(Visitantes visitante)
    {
        return visitante.calcularEdad() >= 18;
    }
    
    public boolean esGuia (int empleadoID) 
    {
        for (Empleados empleadoBuscar : listaDeEmpleados) 
        {
            if (empleadoBuscar.getId() == empleadoID) 
            {
                empleadoBuscar.setEstaEnVisita(true);
                return  empleadoBuscar.getRol().equals("Guía");
            }
        }
        return false;
    }
    
    //************************MANTENIMIENTO DE ANIMAL***********************************
    ArrayList<Mantenimiento> listaMantenimientos = new ArrayList<Mantenimiento>();

    public void mantenimientoAnimales() {

        System.out.print("\nIngresar id del empleado: ");
        int empleadoAsignado = leer.nextInt();

        if (esMantenimiento(empleadoAsignado)) {
            System.out.print("Id del animal en mantenimiento: ");
            int animalMantenido = leer.nextInt();
            
            if (esAnimal(animalMantenido)) 
            {
                leer.nextLine();
                System.out.print("Ingresa el proceso de mantenimiento realizado: ");
                String procesoRealizado = leer.nextLine();

                System.out.print("Ingresa la fecha del mantenimiento: ");
                String fechaMantenimiento = leer.nextLine();

                System.out.print("Deseas agregar observaciones al proceso? \n1.Si \n2.No");
                System.out.println("\nSeleccione una opción: ");
                int opcionObservaciones = leer.nextInt();

                switch (opcionObservaciones) {
                    case 1:
                        
                        leer.nextLine();
                        System.out.print("Ingresa las observaciones correspondientes: ");
                        String observaciones = leer.nextLine();
                        Mantenimiento newMantenimiento = new Mantenimiento(empleadoAsignado, procesoRealizado, fechaMantenimiento, observaciones);
                        listaMantenimientos.add(newMantenimiento);
                        System.out.print("**\nEl mantenimiento ha sido registrado, su id es: " + newMantenimiento.getId());
                        break;

                    case 2:
                        Mantenimiento nMantenimiento = new Mantenimiento(empleadoAsignado, procesoRealizado, fechaMantenimiento);
                        listaMantenimientos.add(nMantenimiento);
                        System.out.print("**\nEl mantenimiento ha sido registrado, su id es: " + nMantenimiento.getId());
                        break;
                }
            }

        } else {
            System.out.println("\nEl id ingresado no corresponde a un empleado de mantenimiento.");
        }

    }

    public boolean esMantenimiento(int empleadoID) {
        for (Empleados empleadoBuscar : listaDeEmpleados) {
            if (empleadoBuscar.getId() == empleadoID) {
                return empleadoBuscar.getRol().equals("Mantenimiento");
            }
        }
        return false;
    }

    public boolean esAnimal(int animal) 
    {
        for (Animales animales : listaDeAnimales) 
        {
            if (animales.getId() == animal)
            {
                return true;
            }
        }
        return false;
    }

    public void mostrarMantenimiento() {
        System.out.print("\nIngresa el id del mantenimiento: ");
        int idMantenimiento = leer.nextInt();
        for (Mantenimiento mantenimiento : listaMantenimientos) {
            if (mantenimiento.getId() == idMantenimiento) {
                for (Empleados empleado : listaDeEmpleados) {

                    if (empleado.getId() == mantenimiento.getIdEncargado()) {
                        System.out.println(mantenimiento.getInformacionMantenimiento() + "\nEl nombre del empleado es: " + empleado.getName());
                    }
                }
            }
        }
    }
}

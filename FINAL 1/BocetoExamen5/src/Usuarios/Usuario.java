package Usuarios;
import com.google.gson.annotations.Expose;
import utilsGlobal.Estados;
import utilsGlobal.Carrera.Carreras;
import Escuela.Sistema;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Usuario {
    @Expose
    private String nombre;
    @Expose
    private String apellidoPaterno;
    @Expose
    private String apellidoMaterno;
    @Expose
    private String fechaNacimiento;
    @Expose
    private String CURP;
    @Expose
    private String RFC;
    @Expose
    private double sueldo;
    @Expose
    private String numeroDeControl;
    @Expose
    private String fechaDeRegistro;
    @Expose
    private String estado;
    @Expose
    private String ciudad;
    @Expose
    private String direccion;
    @Expose
    private Rol rol;
    @Expose
    private String contrasena;
    @Expose
    private Carreras carrera;
    @Expose
    private String sexo;

//    Constructor para profesor y coordinador.
    public Usuario(String nombre, String apellidoPaterno, String apellidoMaterno, String fechaNacimiento, String CURP, String RFC, double sueldo, String numeroDeControl,
                   String fechaDeRegistro, String estado, String ciudad, String direccion, Rol rol, String contrasena, Carreras carrera, String sexo) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.CURP = CURP;
        this.RFC = RFC;
        this.sueldo = sueldo;
        this.numeroDeControl = numeroDeControl;
        this.fechaDeRegistro = fechaDeRegistro;
        this.estado = estado;
        this.ciudad = ciudad;
        this.contrasena = contrasena;
        this.carrera = carrera;
        this.direccion = direccion;
        this.rol = rol;
        this.sexo = sexo;
    }

//    Constructor para estudiante.
    public Usuario(String nombre, String apellidoPaterno, String apellidoMaterno, String fechaNacimiento, String CURP, String numeroDeControl,
                   String estado, String ciudad, String direccion, Rol rol, String contrasena, Carreras carrera, String sexo) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.CURP = CURP;
        this.numeroDeControl = numeroDeControl;
        this.fechaDeRegistro = fechaDeRegistro;
        this.estado = estado;
        this.ciudad = ciudad;
        this.contrasena = contrasena;
        this.direccion = direccion;
        this.rol = rol;
        this.carrera = carrera;
        this.sexo = sexo;
    }

    public static ArrayList<String> registrarUsuario(Usuario usuario, Rol userRol) {
        Scanner leer = new Scanner(System.in);
        ArrayList<String> datosComun = new ArrayList<>();

         String nombre;
        do {
            System.out.println("Ingresa el Nombre: ");
            nombre = leer.nextLine();

            if (!Sistema.sonSoloLetras(nombre)) {
                System.out.println("Ingresa solo letras");
            }
        } while (!Sistema.sonSoloLetras(nombre));

        String fatherLastName;
        do {
            System.out.println("Ingrese el apellido paterno: ");
            fatherLastName = leer.nextLine();

            if (!Sistema.sonSoloLetras(fatherLastName)) {
                System.out.println("Ingresa solo letras");
            }
        } while (!Sistema.sonSoloLetras(fatherLastName));


        String motherLastName;
        do {
            System.out.println("Ingrese el apellido materno: ");
            motherLastName = leer.nextLine();

            if (!Sistema.sonSoloLetras(motherLastName)) {
                System.out.println("Ingresa solo letras");
            }
        } while (!Sistema.sonSoloLetras(motherLastName));


        int añoNacimiento = 0;
        boolean yearValido = true;
        do {
            System.out.println("Ingrese el año de nacimiento (1950-2024): ");
            try {
                añoNacimiento = leer.nextInt();
                yearValido = false;
            } catch (Exception e) {
                System.out.println("Ingrese solo números");
                leer.nextLine();
            }
        }while(yearValido);


        int mesNacimiento = 0;
        boolean mesValido = true;
        do {
            System.out.println("Ingrese el mes de nacimiento (1-12): ");
            try {
                mesNacimiento = leer.nextInt();
                mesValido = false;
            } catch (Exception e) {
                System.out.println("Ingrese solo números");
                leer.nextLine();
            }
        }while(mesValido);

        int diaNacimiento = 0;
        boolean diaValido = true;
        do {
            System.out.println("Ingrese el día de nacimiento (1-31): ");
            try {
                diaNacimiento = leer.nextInt();
                diaValido =false;
            } catch (Exception e) {
                System.out.println("Ingrese solo números");
                leer.nextLine();
            }
        }while(diaValido);


        String fechaNacimiento = generarFechaDeNacimiento(añoNacimiento, mesNacimiento, diaNacimiento);
        leer.nextLine();
        String ciudad;
        do {
            System.out.println("Ingrese la ciudad: ");
            ciudad = leer.nextLine();

            if (!Sistema.sonSoloLetras(ciudad)) {
                System.out.println("Ingresa solo letras");
            }
        } while (!Sistema.sonSoloLetras(ciudad));

        String estado;
        do {
            System.out.println("Ingrese el estado: ");
            estado = leer.nextLine();

            if (!Sistema.sonSoloLetras(estado)) {
                System.out.println("Ingresa solo letras");
            }
        } while (!Sistema.sonSoloLetras(estado));


        String sexo;
        do {
            System.out.println("Ingrese el sexo: ");
            sexo = leer.nextLine();

            if (!Sistema.sonSoloLetras(sexo)) {
                System.out.println("Ingresa solo letras");
            }
        } while (!Sistema.sonSoloLetras(sexo));

        String curp = generarCurp(nombre, fatherLastName, motherLastName, fechaNacimiento, sexo, estado);

        String direccion;
        do {
            System.out.println("Domicilio: ");
            direccion = leer.nextLine();

            if (!Sistema.sonSoloLetras(direccion)) {
                System.out.println("Ingresa solo letras");
            }
        } while (!Sistema.sonSoloLetras(direccion));



        System.out.println("Contraseña: ");
        String password = leer.nextLine();

        String fechaRegistro = generarFechaDeRegistro();
        String numeroDeControl = generarNumeroDeControl(nombre, fechaNacimiento, usuario.getCarrera(), userRol);

        datosComun.addAll(Arrays.asList(nombre, fatherLastName, motherLastName, fechaNacimiento, ciudad, estado, curp, direccion, sexo, password, fechaRegistro, numeroDeControl));
        return datosComun;
    }

    public static String generarFechaDeNacimiento(int año, int mes, int dia) {
        return String.format("%04d/%02d/%02d", año, mes, dia);
    }


    public static String generarFechaDeRegistro() {
        LocalDateTime fecha = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return fecha.format(formatter);
    }

    public static String generateRFC(String name, String fatherLastName, String motherLastName, String fechaDeNacimiento) {
        try {

            String nombre = name.substring(0, 1);
            String lastNameFather = fatherLastName.substring(0, 2);
            String lastNameMother = motherLastName.substring(0, 1);


            String añoNacimiento = fechaDeNacimiento.substring(2, 4);
            String mesNacimiento = fechaDeNacimiento.substring(5, 7);
            String diaNacimiento = fechaDeNacimiento.substring(8, 10);

            // Generar RFC
            String newRFC = lastNameFather + lastNameMother + nombre + añoNacimiento + mesNacimiento + diaNacimiento + "POO3";

            return newRFC.toUpperCase();
        } catch (Exception e) {
            System.out.println("No fue posible generar su RFC. Ingrese los datos completos");
            return null;
        }
    }

    public static String generarCurp(String name, String fatherLastName, String motherLastName,
                                     String fechaNacimiento, String sexo, String estado) {
        try {
            String nombre = name.substring(0, 1);
            String apellidoPaterno = fatherLastName.substring(0, 2);
            String apellidoMaterno = motherLastName.substring(0, 1);

            String añoNacimiento = fechaNacimiento.substring(2,4);
            String mesNacimiento = fechaNacimiento.substring(5, 7);
            String diaNacimiento = fechaNacimiento.substring(8, 10);
            String Sexo = sexo.substring(0, 1);

            // Obtener abreviatura del estado
            String estadoAbreviatura = obtenerAbreviaturaEstado(estado.toUpperCase());

            // Generar CURP
            String newCURP = apellidoPaterno + apellidoMaterno + nombre +
                    añoNacimiento + mesNacimiento + diaNacimiento +
                    Sexo + estadoAbreviatura;

            return newCURP.toUpperCase();
        } catch (Exception e) {
            System.out.println(e);
          System.out.println("No fue posible generar su CURP. Ingrese los datos completos");
          return null;
        }
    }
    private static String obtenerAbreviaturaEstado(String estado) {
        for (Estados entidad : Estados.values()) {
            if (entidad.getNombre().equalsIgnoreCase(estado)) {
                return entidad.getAbreviatura();
            }
        }
        return "";
    }

    @Override
    public String toString() {
        return String.format("\nNombre completo: %s %s %s  Rol: %s  Fecha de nacimiento: %s \nEstado: %s  Ciudad: %s  Dirección: %s \nCurp: %s Contraseña: %s Número de control: %s  Carrera: %s" ,
                nombre, apellidoPaterno, apellidoMaterno, rol, fechaNacimiento, estado, ciudad, direccion, CURP.toUpperCase(), contrasena, numeroDeControl, carrera);
    }

    public static String generarNumeroDeControl(String name,  String fechaDeNacimiento, Carreras carrera, Rol rol) {
        try {

            String nombre = name.substring(0, 1);
            String añoNacimiento = fechaDeNacimiento.substring(2, 4);
            String abreviaturaCarrera = String.valueOf(carrera);
            String indice = "";
            if(rol.equals(Rol.ESTUDIANTE)){
                indice = String.valueOf(Estudiante.indiceEstudiantes);
            }
            else if(rol.equals(Rol.PROFESOR)){
                indice = String.valueOf(Profesor.indiceProfesores);
            }


            // Generar Numero de control
            String newNumeroControl = nombre + añoNacimiento + abreviaturaCarrera+ indice;

            return newNumeroControl.toUpperCase();
        } catch (Exception e) {
            System.out.println("No fue posible generar su numero de control. Ingrese los datos completos");
            return null;
        }
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getCURP() {
        return CURP;
    }

    public void setCURP(String CURP) {
        this.CURP = CURP;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public  String getNumeroDeControl() {
        return numeroDeControl;
    }

    public static void setnumeroDeControl(String numeroDeControl) {
        numeroDeControl = numeroDeControl;
    }

    public String getFechaDeRegistro() {
        return fechaDeRegistro;
    }

    public void setFechaDeRegistro(String fechaDeRegistro) {
        this.fechaDeRegistro = fechaDeRegistro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public Carreras getCarrera() {
        return carrera;
    }

    public void setCarrera(Carreras carrera) {
        this.carrera = carrera;
    }
}
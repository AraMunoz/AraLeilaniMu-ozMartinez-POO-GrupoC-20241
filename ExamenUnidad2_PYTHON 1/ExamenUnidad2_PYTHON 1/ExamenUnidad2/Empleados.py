from Persona import Persona

class Empleados(Persona):
    IDENTIFICADOR = 100

    def __init__(self, name, apellidos, fecha_de_nacimiento, CURP,
                 fecha_de_ingreso_como_trabajador, RFC, salary, horario, rol):
        super().__init__(name, apellidos, fecha_de_nacimiento, CURP)
        self.fecha_de_ingreso_como_trabajador = fecha_de_ingreso_como_trabajador
        self.RFC = RFC
        self.salary = salary
        self.horario = horario
        self.rol = rol
        self.id = Empleados.IDENTIFICADOR
        Empleados.IDENTIFICADOR += 1
        if rol=="Guia":
            self.esta_en_visita=False
    

    def get_fecha_de_ingreso_como_trabajador(self):
        return self.fechaDeIngresoComoTrabajador

    def set_Fecha_De_Ingreso_Como_Trabajador(self, fechaDeIngresoComoTrabajador):
        self.fechaDeIngresoComoTrabajador = fechaDeIngresoComoTrabajador

    def get_rfc(self):
        return self.RFC

    def set_rfc(self, RFC):
        self.RFC = RFC

    def get_salary(self):
        return self.salary

    def set_salary(self, salary):
        self.salary = salary

    def get_horario(self):
        return self.horario

    def set_horario(self, horario):
        self.horario = horario

    def get_rol(self):
        return self.rol

    def set_rol(self, rol):
        self.rol = rol

    def get_numero_de_rol(self):
        return self.numeroDeRol

    def set_numero_de_rol(self, numeroDeRol):
        self.numeroDeRol = numeroDeRol

    @staticmethod
    def get_identificador():
        return Empleados.IDENTIFICADOR

    @staticmethod
    def set_identificador(IDENTIFICADOR):
        Empleados.IDENTIFICADOR = IDENTIFICADOR

    def get_id(self):
        return self.id

    def set_id(self, id):
        self.id = id

    def obtener_informacion_empleado(self):
        return (f"\nId: {self.id} \nNombre: {self.get_name()} \nApellido: {self.get_apellidos()} \n"
        f"Fecha de nacimiento: {self.get_fecha_de_nacimiento()} \nCurp: {self.get_CURP()} \n"
        f"Fecha de ingreso como trabajador: {self.fecha_de_ingreso_como_trabajador}")
    
    def get_esta_en_visita(self):
        return self.get_esta_en_visita

    def set_esta_en_visita(self, esta_en_visita):
        self.esta_en_visita = esta_en_visita

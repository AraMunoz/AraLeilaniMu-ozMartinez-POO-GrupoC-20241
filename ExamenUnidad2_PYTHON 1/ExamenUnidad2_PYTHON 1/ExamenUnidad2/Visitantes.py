from Persona import Persona

class Visitantes(Persona):
    IDENTIFICADOR = 0
    NUMERO_DE_VISITAS = 0

    
    def __init__(self, name=None, apellidos=None, fecha_de_nacimiento=None, CURP=None, fecha_de_registro=None, edad=None):
        if name is not None and apellidos is not None and fecha_de_nacimiento is not None and CURP is not None and fecha_de_registro is not None :
            super().__init__(name, apellidos, fecha_de_nacimiento, CURP)
            self.fecha_de_registro = fecha_de_registro
            self.num_de_visitas = 0
            self.esta_en_visita = False
            self.id = Visitantes.IDENTIFICADOR
            Visitantes.IDENTIFICADOR += 1
        else:
            # Aquí maneja el caso donde no se proporcionan todos los argumentos
            pass

    @staticmethod
    def get_NUMERO_DE_VISITAS():
        return Visitantes.NUMERO_DE_VISITAS

    @staticmethod
    def set_NUMERO_DE_VISITAS(NUMERO_DE_VISITAS):
        Visitantes.NUMERO_DE_VISITAS = NUMERO_DE_VISITAS

    def get_fecha_de_registro(self):
        return self.fecha_de_registro

    def set_fecha_de_registro(self, fecha_de_registro):
        self.fecha_de_registro = fecha_de_registro

    def get_num_de_visitas(self):
        return self.num_de_visitas

    def set_num_de_visitas(self):
        self.num_de_visitas += 1

    @staticmethod
    def get_IDENTIFICADOR():
        return Visitantes.IDENTIFICADOR

    @staticmethod
    def set_IDENTIFICADOR(IDENTIFICADOR):
        Visitantes.IDENTIFICADOR = IDENTIFICADOR

    def get_id(self):
        return self.id

    def set_id(self, id):
        self.id = id

    def is_esta_en_visita(self):
        return self.esta_en_visita

    def set_esta_en_visita(self, esta_en_visita):
        self.esta_en_visita = esta_en_visita

    def obtener_informacion_visitante(self):
        return (f"\nId: {self.id} \nNombre: {self.get_name()} \nEdad: {self.calcular_edad()} \nApellido: {self.get_apellidos()} \nFecha de nacimiento: {self.get_fecha_de_nacimiento()} \nCurp: {self.get_CURP()} \nFecha de registro: {self.fecha_de_registro} \nNúmero de visitas: {self.num_de_visitas}")

    def es_visitante(self, id, lista_visitantes):
        for visitante in lista_visitantes:
            if visitante.get_id() == id:

                return visitante
        return None

    def calcular_edad(self):
        # Calcular la edad en años
        # (Suponemos que la fecha de nacimiento está en formato "YYYY-MM-DD")
        nacimiento = self.get_fecha_de_nacimiento().split("-")
        anio_nacimiento = int(nacimiento[0])
        anio_actual = 2024  # Año actual (puede ser obtenido dinámicamente)
        return anio_actual - anio_nacimiento

    def obtener_descuento(self):
        # Cada 5 visitas, se aplica un descuento del 20%
        if self.num_de_visitas == 5:
            return 0.2
        else:
            return 0
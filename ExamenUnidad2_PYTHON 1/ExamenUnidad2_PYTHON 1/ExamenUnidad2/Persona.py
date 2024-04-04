class Persona:
    IDENTIFICADOR = 0

    def __init__(self, name, apellidos, fecha_de_nacimiento, CURP):
        self.name = name
        self.apellidos = apellidos
        self.fecha_de_nacimiento = fecha_de_nacimiento
        self.CURP = CURP
        self.id = Persona.IDENTIFICADOR
        Persona.IDENTIFICADOR += 1

    def get_name(self):
        return self.name

    def set_name(self, name):
        self.name = name

    def get_apellidos(self):
        return self.apellidos

    def set_apellidos(self, apellidos):
        self.apellidos = apellidos

    def get_fecha_de_nacimiento(self):
        return self.fecha_de_nacimiento

    def set_fecha_de_nacimiento(self, fecha_de_nacimiento):
        self.fecha_de_nacimiento = fecha_de_nacimiento

    def get_CURP(self):
        return self.CURP

    def set_CURP(self, CURP):
        self.CURP = CURP

    @staticmethod
    def get_IDENTIFICADOR():
        return Persona.IDENTIFICADOR

    @staticmethod
    def set_IDENTIFICADOR(IDENTIFICADOR):
        Persona.IDENTIFICADOR = IDENTIFICADOR

    def get_id(self):
        return self.id

    def set_id(self, id):
        self.id = id


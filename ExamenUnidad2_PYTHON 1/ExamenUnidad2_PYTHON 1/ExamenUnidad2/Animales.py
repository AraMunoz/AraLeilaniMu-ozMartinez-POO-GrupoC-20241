class Animales:
    IDENTIFICADOR2 = 1000

    def __init__(self, tipo_animal, fecha_de_nacimiento, fecha_de_llegada, enfermedad, tipo_de_alimentacion,
                 peso, frecuencia_de_alimentacion, cuenta_con_vacunas):
        self.tipo_animal = tipo_animal
        self.fecha_de_llegada = fecha_de_llegada
        self.enfermedad = enfermedad
        self.tipo_de_alimentacion = tipo_de_alimentacion
        self.fecha_de_nacimiento = fecha_de_nacimiento
        self.peso = peso
        self.frecuencia_de_alimentacion = frecuencia_de_alimentacion
        self.cuenta_con_vacunas = cuenta_con_vacunas
        self.id = Animales.IDENTIFICADOR2
        Animales.IDENTIFICADOR2 += 1
    
    def set_identificador2(identificador2):
        Animales.IDENTIFICADOR_2 = identificador2

    def get_id(self):
        return self.id

    def set_id(self, id):
        self.id = id

    def get_tipo_animal(self):
        return self.tipo_animal

    def set_tipo_animal(self, tipo_animal):
        self.tipo_animal = tipo_animal

    def get_fecha_de_llegada(self):
        return self.fecha_de_llegada

    def set_fecha_de_llegada(self, fecha_de_llegada):
        self.fecha_de_llegada = fecha_de_llegada

    def get_enfermedad(self):
        return self.enfermedad

    def set_enfermedad(self, enfermedad):
        self.enfermedad = enfermedad

    def get_tipo_de_alimentacion(self):
        return self.tipo_de_alimentacion

    def set_tipo_de_alimentacion(self, tipo_de_alimentacion):
        self.tipo_de_alimentacion = tipo_de_alimentacion

    def get_fecha_de_nacimiento(self):
        return self.fecha_de_nacimiento

    def set_fecha_de_nacimiento(self, fecha_de_nacimiento):
        self.fecha_de_nacimiento = fecha_de_nacimiento

    def get_peso(self):
        return self.peso

    def set_peso(self, peso):
        self.peso = peso

    def get_frecuencia_de_alimentacion(self):
        return self.frecuencia_de_alimentacion

    def set_frecuencia_de_alimentacion(self, frecuencia_de_alimentacion):
        self.frecuencia_de_alimentacion = frecuencia_de_alimentacion

    def is_cuenta_con_vacunas(self):
        return self.cuenta_con_vacunas

    def set_cuenta_con_vacunas(self, cuenta_con_vacunas):
        self.cuenta_con_vacunas = cuenta_con_vacunas 


    

    def obtener_informacion_animal(self):
        enfermedades_string = ", ".join(self.enfermedad) if self.enfermedad else "Ninguna"
        return (f"\nId: {self.id} \nTipo de animal: {self.tipo_animal} \nFecha de nacimiento: {self.fecha_de_nacimiento} \n"
        f"Fecha de llegada al zoológico: {self.fecha_de_llegada} \nPeso: {self.peso:.2f} \nEnfermedades: {enfermedades_string} \n"
        f"Frecuencia de alimentación: {self.frecuencia_de_alimentacion} \nTipo de alimentación: {self.tipo_de_alimentacion}")
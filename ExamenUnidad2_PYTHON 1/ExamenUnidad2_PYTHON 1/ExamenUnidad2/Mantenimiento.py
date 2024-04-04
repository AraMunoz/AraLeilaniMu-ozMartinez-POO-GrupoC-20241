class Mantenimiento:
    IDENTIFICADOR = 200

    def __init__(self, id_encargado, tipo_de_mantenimiento, fecha_proceso, observaciones=None):
        self.id_encargado = id_encargado
        self.tipo_de_mantenimiento = tipo_de_mantenimiento
        self.fecha_proceso = fecha_proceso
        self.observaciones = observaciones
        self.id = Mantenimiento.IDENTIFICADOR
        Mantenimiento.IDENTIFICADOR += 1

        
    def get_id(self):
        return self.id

    def get_id_encargado(self):
        return self.id_encargado
    
    def get_informacion_mantenimiento(self):
        return f"\nId: {self.id} \nTipo de mantenimiento: {self.tipo_de_mantenimiento} \nFecha de mantenimiento: {self.fecha_proceso} \nGuía encargado: {self.id_encargado} \nObservaciones: {self.observaciones}" if self.observaciones else f"\nId: {self.id} \nTipo de mantenimiento: {self.tipo_de_mantenimiento} \nFecha de mantenimiento: {self.fecha_proceso} \nGuía encargado: {self.id_encargado}"

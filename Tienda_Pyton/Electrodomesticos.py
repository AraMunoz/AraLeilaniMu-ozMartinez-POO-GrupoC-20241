from Producto import Producto

class Electrodomesticos(Producto):
    ID = 300

    def __init__(self, nombre, precio, fecha_importacion, stock, voltaje):
        super().__init__(nombre, precio, fecha_importacion, stock)
        self.voltaje = voltaje
        self.id = Electrodomesticos.ID
        Electrodomesticos.ID += 1

    def get_id(self):
        return self.id

    def obtener_informacion_con_voltaje(self):
        return super().obtener_informacion() + ", voltaje " + str(self.voltaje) + " ID: " + str(self.id)

from Producto import Producto
class Alimento(Producto):
    ID = 400

    def __init__(self, nombre, precio, fecha_importacion, stock, fecha_caducidad):
        super().__init__(nombre, precio, fecha_importacion, stock)
        self.fecha_caducidad = fecha_caducidad
        self.id = Alimento.ID
        Alimento.ID += 1

    def get_id(self):
        return self.id

    def obtener_informacion_con_fecha_de_caducidad(self):
        return super().obtener_informacion() + ", fecha de caducidad " + self.fecha_caducidad + " ID: " + str(self.id)

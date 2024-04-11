from Producto import Producto
class Maquillaje(Producto):
    ID = 200

    def __init__(self, nombre, precio, fecha_importacion, stock, color):
        super().__init__(nombre, precio, fecha_importacion, stock)
        self.color = color
        self.id = Maquillaje.ID
        Maquillaje.ID += 1

    def get_id(self):
        return self.id

    def obtener_informacion_con_color(self):
        return super().obtener_informacion() + ", color " + self.color + " ID: " + str(self.id)

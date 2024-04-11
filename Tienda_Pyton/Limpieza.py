from Producto import Producto
class Limpieza(Producto):
    ID = 100

    def __init__(self, nombre=None, precio=None, fecha_importacion=None, stock=None, marca=None):
        super().__init__(nombre, precio, fecha_importacion, stock)
        self.id = Limpieza.ID
        self.marca = marca
        Limpieza.ID += 1

    def get_id(self):
        return self.id

    def obtener_informacion_con_marca(self):
        return super().obtener_informacion() + ", marca " + self.marca + " ID: " + str(self.id)

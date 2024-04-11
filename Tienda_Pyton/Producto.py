class Producto:
    CANTIDAD_PRODUCTO = 0

    def __init__(self, nombre=None, precio=None, fecha_importacion=None, stock=None):
        self.nombre = nombre
        self.precio = precio
        self.fecha_importacion = fecha_importacion
        self.stock = stock
        self.tiene_compras = False
        if nombre is not None and precio is not None and fecha_importacion is not None and stock is not None:
            self.numero_serie = Producto.CANTIDAD_PRODUCTO + 1
            Producto.CANTIDAD_PRODUCTO += 1

    def agregar_stock(self, cantidad):
        self.stock += cantidad

    def eliminar_stock(self, cantidad):
        if self.validar_stock():
            print("No es posible disminuir la cantidad ingresada, el stock disponible es menor")
        else:
            self.stock -= cantidad

    def validar_stock(self):
        return self.stock == 0

    def obtener_informacion(self):
        return f"Nombre: {self.nombre}, precio {self.precio}, fecha de importacion {self.fecha_importacion}, stock {self.stock}, numero de serie {self.numero_serie}"

    def set_tiene_compras(self, tiene_compras):
        self.tiene_compras = tiene_compras
        
    def get_nombre(self):
        return self.nombre
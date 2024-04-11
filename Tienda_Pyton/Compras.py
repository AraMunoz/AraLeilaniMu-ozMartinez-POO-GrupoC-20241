class Compras:
    def __init__(self, cliente, producto, fecha, cantidad):
        self.cliente = cliente
        self.producto = producto
        self.fecha = fecha
        self.cantidad = cantidad

    def obtener_informacion_compra(self):
        return f"El cliente: {self.cliente.get_nombre()} compro: {self.cantidad} {self.producto.get_nombre()} el dia: {self.fecha}"

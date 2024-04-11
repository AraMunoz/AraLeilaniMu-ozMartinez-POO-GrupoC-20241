class Cliente:
    CANTIDAD_CLIENTES = 0

    def __init__(self, id=None, nombre=None, direccion=None):
        self.id = id
        self.nombre = nombre
        self.direccion = direccion
        self.tiene_compras = False
        if id is not None and nombre is not None and direccion is not None:
            Cliente.CANTIDAD_CLIENTES += 1

    def obtener_informacion(self):
        return f"ID: {self.id} nombre: {self.nombre} y direccion {self.direccion}"

    def set_tiene_compras(self, tiene_compras):
        self.tiene_compras = tiene_compras

    def get_nombre(self):
        return self.nombre
    def get_tiene_compras(self):
        return self.tiene_compras

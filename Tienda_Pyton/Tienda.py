import random
from Cliente import Cliente
from Producto import Producto
from Limpieza import Limpieza
from Maquillaje import Maquillaje
from Electrodomesticos import Electrodomesticos
from Alimento import Alimento
from Compras import Compras
class Tienda:
    def __init__(self):
        self.producto = Producto()
        self.cliente = Cliente()
        self.clientes = []
        self.maquillajes = []
        self.producto_limpieza = []
        self.electrodomesticos = []
        self.alimentos = []
        self.compras = []

    def registrar_cliente(self):
        id = self.validar_id_cliente()
        nombre = input("Ingresa el nombre del cliente: ")
        direccion = input("Ingresa la direccion del cliente: ")
        cliente = Cliente(id, nombre, direccion)
        self.clientes.append(cliente)
        print(f"Cliente registrado su id es: {cliente.id}")
        
    def consultar_clientes(self):
        print("***Clientes***")
        for cliente in self.clientes:
            print(cliente.obtener_informacion())

    def validar_id_cliente(self):
        id_valido = False
        while not id_valido:
            id = random.randint(1, 1000)
            if not any(cliente.id == id for cliente in self.clientes):
                id_valido = True
        return id

    def registrar_datos_comun(self):
        datos = []
        nombre = input("Ingresa el nombre: ")
        datos.append(nombre)
        precio = float(input("Ingresa el precio: "))
        datos.append(precio)
        fecha = input("Ingresa fecha de importacion: ")
        datos.append(fecha)
        stock = int(input("Ingresa el stock: "))
        datos.append(stock)
        return datos

    def registrar_producto_limpieza(self):
        print("***Elegiste registrar un producto de limpieza***")
        datos_usuario = self.registrar_datos_comun()
        nombre = datos_usuario[0]
        precio = datos_usuario[1]
        fecha = datos_usuario[2]
        stock = datos_usuario[3]
        marca = input("Ingresa la marca: ")
        limpieza = Limpieza(nombre, precio, fecha, stock, marca)
        print(f"El producto ha sido registrado correctamente el ID es: {limpieza.id}")
        self.producto_limpieza.append(limpieza)

    def registrar_producto_alimento(self):
        print("***Elegiste registrar un producto de alimentos***")
        datos_usuario = self.registrar_datos_comun()
        nombre = datos_usuario[0]
        precio = datos_usuario[1]
        fecha = datos_usuario[2]
        stock = datos_usuario[3]
        fecha_caducidad = input("Ingresa la fecha de caducidad: ")
        alimento = Alimento(nombre, precio, fecha, stock, fecha_caducidad)
        print(f"El producto ha sido registrado correctamente el ID es: {alimento.id}")
        self.alimentos.append(alimento)

    def registrar_producto_electrodomesticos(self):
        print("***Elegiste registrar un producto de electrodomesticos***")
        datos_usuario = self.registrar_datos_comun()
        nombre = datos_usuario[0]
        precio = datos_usuario[1]
        fecha = datos_usuario[2]
        stock = datos_usuario[3]
        voltaje = float(input("Ingresa el voltaje: "))
        electrodomestico = Electrodomesticos(nombre, precio, fecha, stock, voltaje)
        print(f"El producto ha sido registrado correctamente el ID es: {electrodomestico.id}")
        self.electrodomesticos.append(electrodomestico)

    def registrar_producto_maquillaje(self):
        print("***Elegiste registrar un producto de maquillaje***")
        datos_usuario = self.registrar_datos_comun()
        nombre = datos_usuario[0]
        precio = datos_usuario[1]
        fecha = datos_usuario[2]
        stock = datos_usuario[3]
        color = input("Ingresa el color: ")
        maquillaje = Maquillaje(nombre, precio, fecha, stock, color)
        print(f"El producto ha sido registrado correctamente el ID es: {maquillaje.id}")
        self.maquillajes.append(maquillaje)

    def consultar_productos(self):
        print("***Productos***")
        self.consultar_productos_limpieza()
        self.consultar_productos_alimento()
        self.consultar_productos_electrodomesticos()
        self.consultar_productos_maquillaje()

    def consultar_productos_limpieza(self):
        for limpieza in self.producto_limpieza:
            print(limpieza.obtener_informacion_con_marca())

    def consultar_productos_alimento(self):
        for alimento in self.alimentos:
            print(alimento.obtener_informacion_con_fecha_de_caducidad())

    def consultar_productos_electrodomesticos(self):
        for electrodomestico in self.electrodomesticos:
            print(electrodomestico.obtener_informacion_con_voltaje())

    def consultar_productos_maquillaje(self):
        for maquillaje in self.maquillajes:
            print(maquillaje.obtener_informacion_con_color())

    def consultar_total_de_clientes_y_productos(self):
        print(f"El sistema tiene registrados un total de: {self.producto.CANTIDAD_PRODUCTO} productos.")
        print(f"El sistema tiene registrados un total de: {self.cliente.CANTIDAD_CLIENTES} clientes.")

    def comprar_productos(self):
        id = int(input("Ingrese el id del cliente: "))
        cliente_comprador = self.es_cliente(id)
        if cliente_comprador is not None:
            cliente_comprador.tiene_compras = True
            print(f"Bienvenido {cliente_comprador.nombre} ingresa la categoria de productos que deseas comprar: ")
            print("Tipo de producto: ")
            print("1. Limpieza")
            print("2. Electrodomesticos")
            print("3. Alimento")
            print("4. Maquillaje")
            opcion_producto = int(input())
            id_producto = int(input("Ingresa el id del producto: "))
            producto_vendido = self.es_producto(opcion_producto, id_producto)
            if producto_vendido is not None:
                producto_vendido.tiene_compras = True
                cantidad_comprar = int(input("Ingresa la cantidad que deseas comprar: "))
                producto_vendido.eliminar_stock(cantidad_comprar)
                fecha = "09-Abril-2024"
                compra = Compras(cliente_comprador, producto_vendido, fecha, cantidad_comprar)
                self.compras.append(compra)

    def es_cliente(self, id):
        for cliente in self.clientes:
            if cliente.id == id:
                return cliente
        return None

    def es_producto(self, opcion, id):
        if opcion == 1:
            for limpieza in self.producto_limpieza:
                if limpieza.id == id:
                    return limpieza
        elif opcion == 2:
            for electrodomestico in self.electrodomesticos:
                if electrodomestico.id == id:
                    return electrodomestico
        elif opcion == 3:
            for alimento in self.alimentos:
                if alimento.id == id:
                    return alimento
        elif opcion == 4:
            for maquillaje in self.maquillajes:
                if maquillaje.id == id:
                    return maquillaje
        return None
    def ver_compras(self):
        for compra in self.compras:
            print(compra.obtener_informacion_compra())

    def eliminar_cliente(self):
        id = int(input("Ingresa el Id del cliente que deseas eliminar: "))
        for i, cliente in enumerate(self.clientes):
            if cliente.id == id and cliente.get_tiene_compras()==False:
                del self.clientes[i]
                print("El cliente ha sido eliminado correctamente.")
                break

    def eliminar_producto(self):
        print("Ingresa el tipo de producto que deseas eliminar: ")
        print("Tipo de producto: ")
        print("1. Limpieza")
        print("2. Electrodomesticos")
        print("3. Alimento")
        print("4. Maquillaje")
        opcion = int(input())
        id = int(input("Ingresa el id del producto: "))
        if opcion == 1:
            for i, limpieza in enumerate(self.producto_limpieza):
                if limpieza.id == id and not limpieza.tiene_compras:
                    del self.producto_limpieza[i]
                    print("El producto ha sido eliminado correctamente.")
                    return
        elif opcion == 2:
            for i, electrodomestico in enumerate(self.electrodomesticos):
                if electrodomestico.id == id and not electrodomestico.tiene_compras:
                    del self.electrodomesticos[i]
                    print("El producto ha sido eliminado correctamente.")
                    return
        elif opcion == 3:
            for i, alimento in enumerate(self.alimentos):
                if alimento.id == id and not alimento.tiene_compras:
                    del self.alimentos[i]
                    print("El producto ha sido eliminado correctamente.")
                    return
        elif opcion == 4:
            for i, maquillaje in enumerate(self.maquillajes):
                if maquillaje.id == id and not maquillaje.tiene_compras:
                    del self.maquillajes[i]
                    print("El producto ha sido eliminado correctamente.")
                    return

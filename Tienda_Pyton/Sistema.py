
from Tienda import Tienda
class Sistema:
    CONTRASENA_SEGURA = "H1/m"
    tienda = Tienda()
    
    def ejecutar_programa(self):
        contrasena_valida = False
        while not contrasena_valida:
            print("***Bienvenido***")
            print("Ingresa la contraseña: ")
            contrasena = input()
            
            if self.validar_contrasena(contrasena):
                contrasena_valida = True
                # Mostrar menu
                self.mostrar_menu_sistema()
            else:
                print("Contrasena invalida, intenta de nuevo")
    
    def validar_contrasena(self, contrasena):
        return contrasena == self.CONTRASENA_SEGURA
    
    def mostrar_menu_sistema(self):
        opcion = 0
        while opcion != 13:
            print("***Bienvenido***")
            print("Elige una opcion para continuar")
            print("1. Agregar cliente")
            print("2. Agregar producto")
            print("3. Añadir stock")
            print("4. Disminuir stock")
            print("5. Consultar clientes")
            print("6. Consultar productos")
            print("7. Consultar productos por categoria")
            print("8. Realizar una compra")
            print("9. Ver compras")
            print("10. Consultar total de clientes y productos")
            print("11. Eliminar cliente")
            print("12. Eliminar producto")
            print("13. Salir")
            print("Ingresa la opcion: ")
            opcion = int(input())
            
            if opcion == 1:
                self.tienda.registrar_cliente()
            elif opcion == 2:
                print("Ingresa el tipo de producto: ")
                print("1. Limpieza")
                print("2. Electrodomesticos")
                print("3. Alimento")
                print("4. Maquillaje")
                opcion_producto = int(input())
                if opcion_producto == 1:
                    print("***Elegiste la opcion de registrar un producto de limpieza***")
                    self.tienda.registrar_producto_limpieza()
                elif opcion_producto == 2:
                    print("***Elegiste la opcion de registrar un producto de electrodomestico***")
                    self.tienda.registrar_producto_electrodomesticos()
                elif opcion_producto == 3:
                    print("***Elegiste la opcion de registrar un producto de alimento***")
                    self.tienda.registrar_producto_alimento()
                elif opcion_producto == 4:
                    print("***Elegiste la opcion de registrar un producto de maquillaje***")
                    self.tienda.registrar_producto_maquillaje()
            elif opcion == 5:
                self.tienda.consultar_clientes()
            elif opcion == 6:
                self.tienda.consultar_productos()
            elif opcion == 7:
                print("Elegiste la opcion ver productos por categoria: ")
                print("Ingresa el tipo de producto: ")
                print("1. Limpieza")
                print("2. Electrodomesticos")
                print("3. Alimento")
                print("4. Maquillaje")
                opcion_ver = int(input())
                if opcion_ver == 1:
                    print("***Elegiste la opcion de ver productos de limpieza***")
                    self.tienda.registrar_producto_limpieza()
                elif opcion_ver == 2:
                    print("***Elegiste la opcion de ver productos de electrodomestico***")
                    self.tienda.registrar_producto_electrodomesticos()
                elif opcion_ver == 3:
                    print("***Elegiste la opcion de ver productos de alimento***")
                    self.tienda.registrar_producto_alimento()
                elif opcion_ver == 4:
                    print("***Elegiste la opcion de ver productos de maquillaje***")
                    self.tienda.registrar_producto_maquillaje()
            elif opcion == 8: 
                    print("***Elegiste la opcion de realizar una compra***")
                    self.tienda.comprar_productos()
            elif opcion == 9: 
                    print("***Elegiste la opcion de ver todas las compras***")
                    self.tienda.ver_compras()
            elif opcion == 10: 
                    print("***Elegiste la opcion de ver total de productos y clientes***")
                    self.tienda.consultar_total_de_clientes_y_productos()
            elif opcion == 11: 
                    print("***Elegiste la opcion de eliminar clientes***")
                    self.tienda.eliminar_cliente()
            elif opcion == 12: 
                    print("***Elegiste la opcion de eliminar producto***")
                    self.tienda.eliminar_producto()
            elif opcion == 13: 
                    print("Saliendo...")
    

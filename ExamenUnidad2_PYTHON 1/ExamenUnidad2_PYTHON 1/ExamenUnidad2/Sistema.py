from Zoo import Zoo

class Sistema:
    def __init__(self):
        self.objeto_zoo = Zoo()

    CLAVE = "Hola546%"

    def ejecutar_programa(self):
        clave_valida = False

        while not clave_valida:
            clave = input("\nIngrese la contraseña del sistema: ")

            if self.validar_clave(clave):
                clave_valida = True
                self.mostrar_menu()
            else:
                print("\n***Clave inválida, intenta de nuevo***")

    def validar_clave(self, clave):
        return clave == self.CLAVE

    def mostrar_menu(self):
        opcion = 0
        
        while opcion != 16:
            print("\n\n\t***BIENVENIDO AL ZOOLOGICO***")
            print("\nMenú de opciones")
            print("1) Agregar empleado")
            print("2) Agregar visitante")
            print("3) Agregar animal")
            print("4) Mostrar lista de empleados")
            print("5) Mostrar lista de visitantes")
            print("6) Mostrar lista de animales")
            print("7) Eliminar empleado")
            print("8) Eliminar visitante")
            print("9) Eliminar animal")
            print("10) Modificar información de un empleado")
            print("11) Modificar información de un visitante")
            print("12) Modificar información de un animal")
            print("13) Realizar visita")
            print("14) Realizar cuidado de animales")
            print("15) Mostrar mantenimiento de animal")
            print("16) Salir")
            
            opcion = int(input("\nSeleccione una opción: "))
            
            if opcion == 1:
                print("\nSeleccionaste registrar empleado")
                self.objeto_zoo.registrar_persona_empleado()
            elif opcion == 2:
                print("\nSeleccionaste registrar visitantes")
                self.objeto_zoo.registrar_visitantes()
            elif opcion == 3:
                print("\nSeleccionaste registrar animal")
                self.objeto_zoo.registrar_animal()
            elif opcion == 4:
                print("\nSeleccionaste listar empleados")
                self.objeto_zoo.mostrar_empleados()
            elif opcion == 5:
                subopcion = 0
                while subopcion != 4:
                    print("\n**Listas disponibles**")
                    print("\n1) Lista de adultos registrados")
                    print("2) Lista de niños registrados")
                    print("3) Mostrar todos los visitantes")
                    print("4) Volver al menú principal")
                    
                    subopcion = int(input("\nElige una opción: "))
                    
                    if subopcion == 1:
                        self.objeto_zoo.mostrar_visitantes_adultos()
                    elif subopcion == 2:
                        self.objeto_zoo.mostrar_visitantes_menores()
                    elif subopcion == 3:
                        self.objeto_zoo.mostrar_todos_los_visitantes()
                    elif subopcion == 4:
                        print("\nMenú principal")
                    else:
                        print("\nOpción no válida")
            elif opcion == 6:
                print("\nSeleccionaste listar animales")
                self.objeto_zoo.mostrar_animales()
            elif opcion == 7:
                print("\nSeleccionaste eliminar empleado")
                self.objeto_zoo.eliminar_empleado()
            elif opcion == 8:
                print("\nSeleccionaste eliminar visitante")
                self.objeto_zoo.eliminar_visitante()
            elif opcion == 9:
                print("\nSeleccionaste eliminar animal")
                self.objeto_zoo.eliminar_animal()
            elif opcion == 10:
                print("\nSeleccionaste modificar empleado")
                self.objeto_zoo.modificar_empleado()
            elif opcion == 11:
                print("\nSeleccionaste modificar visitante")
                self.objeto_zoo.modificar_visitante()
            elif opcion == 12:
                print("\nSeleccionaste modificar información de animal")
                self.objeto_zoo.modificar_animal()
            elif opcion == 13:
                print("\nSeleccionaste realizar visita")
                self.objeto_zoo.realizar_visita()
            elif opcion == 14:
                print("\nSeleccionaste cuidado de animales")
                self.objeto_zoo.mantenimiento_animales()
            elif opcion == 15:
                print("\nSeleccionaste mostrar mantenimiento de animal")
                self.objeto_zoo.mostrar_mantenimiento()
            elif opcion == 16:
                print("\nSaliendo del programa")
            else:
                print("\nOpción no válida")
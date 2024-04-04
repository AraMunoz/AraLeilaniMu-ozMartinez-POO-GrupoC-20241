from Visitantes import Visitantes
from Mantenimiento import Mantenimiento
from Visita import Visita
from Empleados import Empleados
from Animales import Animales


class Zoo:
    IDENTIFICADOR = 90

    def __init__(self):

        #*************************************LISTAS***********************************
        self.visita_prueba = Visita()
        self.lista_de_empleados = []
        self.lista_de_empleados_veterinarios = []
        self.lista_de_empleados_guias = []
        self.lista_de_empleados_administrativos = []
        self.lista_de_empleados_mantenimiento = []
        self.lista_de_visitantes_adultos = []
        self.lista_de_visitantes_menores = []
        self.lista_de_animales = []
        self.lista_de_visitas = []
        self.lista_de_visitantes_adultos_en_visita = []
        self.lista_de_visitantes_menores_en_visita = []
        self.lista_de_visitantes = []

        self.cantidad_adultos = 0
        self.cantidad_niños = 0


        #***************************************REGISTROS***************************************
    def registrar_persona_empleado(self):
        datos_persona = []

        print("\nTu ID se genera automáticamente")
        new_name = input("Ingresar el nombre: ")
        datos_persona.append(new_name)

        new_apellido = input("Apellido: ")
        datos_persona.append(new_apellido)

        registrar_fecha_de_nacimiento = input("Fecha de Nacimiento:")
        datos_persona.append(registrar_fecha_de_nacimiento)

        new_curp = input("CURP:")
        datos_persona.append(new_curp)

        registrar_fecha_de_ingreso = input("Fecha de ingreso:")
        datos_persona.append(registrar_fecha_de_ingreso)

        new_rfc = input("Ingresar RFC:")
        datos_persona.append(new_rfc)

        new_salary = float(input("Ingresar salario: "))
        datos_persona.append(str(new_salary))

        new_horario = input("Ingresar horario: ")
        datos_persona.append(new_horario)

        print("\n**Ingresar rol** \n1. Veterinario. \n2. Guía. \n3. Administración. \n4. Mantenimiento")
        numero_de_rol = int(input("\nSeleccione una opción: "))

        new_rol = ""
        if numero_de_rol == 1:
            new_rol = "Veterinario"
            datos_persona.append(new_rol)
        elif numero_de_rol == 2:
            new_rol = "Guía"
            datos_persona.append(new_rol)
        elif numero_de_rol == 3:
            new_rol = "Administración"
            datos_persona.append(new_rol)
        elif numero_de_rol == 4:
            new_rol = "Mantenimiento"
            datos_persona.append(new_rol)
        else:
            print("Ingrese una opción válida.")

        new_empleado = Empleados(new_name, new_apellido, registrar_fecha_de_nacimiento, new_curp,
                                 registrar_fecha_de_ingreso, new_rfc, new_salary, new_horario, new_rol)
        self.tipo_de_empleado(numero_de_rol, new_empleado)
        self.lista_de_empleados.append(new_empleado)

        print("\n**Empleado registrado, el id generado es " + str(new_empleado.id) + " **")
        return datos_persona

    def tipo_de_empleado(self, numero_de_rol, new_empleado):
        if numero_de_rol == 1:
            self.lista_de_empleados_veterinarios.append(new_empleado)
        elif numero_de_rol == 2:
            self.lista_de_empleados_guias.append(new_empleado)
        elif numero_de_rol == 3:
            self.lista_de_empleados_administrativos.append(new_empleado)
        elif numero_de_rol == 4:
            self.lista_de_empleados_mantenimiento.append(new_empleado)
        else:
            print("Ingrese una opción válida.")

    
    def registrar_visitantes(self):
        datos_persona_visitante = []

        print("\nTu ID se genera automáticamente")

        new_name = input("Ingresar el nombre: ")
        datos_persona_visitante.append(new_name)

        new_apellido = input("Apellido: ")
        datos_persona_visitante.append(new_apellido)

        registrar_fecha_de_nacimiento = input("Fecha de Nacimiento con formato YYYY-MM-DD:")
        datos_persona_visitante.append(registrar_fecha_de_nacimiento)

        new_curp = input("CURP:")
        datos_persona_visitante.append(new_curp)

        fecha_de_registro = input("Fecha de Registro:")
        datos_persona_visitante.append(fecha_de_registro)

        new_visitante = Visitantes(new_name, new_apellido, registrar_fecha_de_nacimiento, new_curp,
                                   fecha_de_registro)

        self.lista_de_visitantes.append(new_visitante)
        if new_visitante.calcular_edad() >= 18:
            self.lista_de_visitantes_adultos.append(new_visitante)
        else:
            self.lista_de_visitantes_menores.append(new_visitante)

        print("\n**Visitante registrado, el id generado es " + str(new_visitante.id) + " **") 


    def registrar_animal(self):
        print("\nEl id se genera automáticamente")
        tipo_animal = input("Ingresa el tipo de animal: ")
        fecha_de_nacimiento = input("Ingresa la fecha de nacimiento del animal: ")
        fecha_de_llegada = input("Ingresa la fecha de llegada del animal: ")
        enfermedad = input("El animal tiene alguna enfermedad? Si/No: ")

        enfermedades = None
        if enfermedad.lower() == "si":
            print("\nNúmero de enfermedades: ")
            total_enfermedades = int(input())
            enfermedades = []

            for i in range(total_enfermedades):
                print("Enfermedad " + str(i + 1) + " : ")
                enfermedad_actual = input()
                enfermedades.append(enfermedad_actual)

        tipo_de_alimentacion = input("Ingresa el tipo de alimentacion del animal: ")
        peso = float(input("Ingresa el peso del animal: "))
        frecuencia_de_alimentacion = int(input("Ingresa la frecuencia de alimentacion del animal: "))
        cuenta_con_vacuna = int(input("\nEl animal cuenta con vacunas \n 1.Si \n 2.No \nSeleccione una opción: "))
        cuenta_con_vacunas = (cuenta_con_vacuna == 1)

        animal = Animales(tipo_animal, fecha_de_nacimiento, fecha_de_llegada, enfermedades,
                          tipo_de_alimentacion, peso, frecuencia_de_alimentacion, cuenta_con_vacunas)
        self.lista_de_animales.append(animal)

        print("\n**Animal registrado, el id generado es " + str(animal.id) + " **")


        #*********************************MOSTRAR LISTAS*****************************************
    def mostrar_empleados(self):
        if not self.lista_de_empleados:
            print("\n\t***No hay empleados registrados***")
            return
        else:
            print("\n***Empleados registrados***")
            for empleado in self.lista_de_empleados:
                print(empleado.obtener_informacion_empleado())

    def mostrar_todos_los_visitantes(self):
        if not self.lista_de_visitantes:
            print("\n\t***No hay visitantes registrados***")
            return
        else:
            print("\n***Total de Visitantes registrados***")
            for visitante in self.lista_de_visitantes:
                print(visitante.obtener_informacion_visitante())

    def mostrar_visitantes_adultos(self):
        if not self.lista_de_visitantes_adultos:
            print("\n\t***No hay visitantes adultos registrados***")
            return
        else:
            print("\n***Visitantes adultos registrados***")
            for visitante_adulto in self.lista_de_visitantes_adultos:
                print(visitante_adulto.obtener_informacion_visitante())

    def mostrar_visitantes_menores(self):
        if not self.lista_de_visitantes_menores:
            print("\n\t***No hay visitantes menores registrados***")
            return
        else:
            print("\n***Visitantes menores registrados***")
            for visitante_menor in self.lista_de_visitantes_menores:
                print(visitante_menor.obtener_informacion_visitante())

    def mostrar_animales(self):
        if not self.lista_de_animales:
            print("\n\t***No hay animales registrados***")
            return
        else:
            print("\n***Animales registrados***")
            for animal in self.lista_de_animales:
                print(animal.obtener_informacion_animal())

    

    #*********************************************ELIMINACIÓN*************************************
    def eliminar_empleado(self):
        print("\nIngresa el id del empleado que deseas eliminar: ")
        id = int(input())
        indice_del_eliminado = 0

        for empleado in self.lista_de_empleados:
            if empleado.get_id() == id and empleado.get_esta_en_visita()==False:
                self.lista_de_empleados.pop(indice_del_eliminado)
                print("\n**El empleado ha sido eliminado de forma correcta**")
                return
            indice_del_eliminado += 1
        print("\n**El empleado no puede ser eliminado*")


    def eliminar_visitante(self):
        print("\n**Listas disponibles**")
        print("\n1. Niños \n2. Adultos")
        print("\nSeleccione una lista: ")
        opcion = int(input())

        if opcion == 1:
            print("\nIngresa el id del visitante menor que deseas eliminar: ")
            id = int(input())
            indice_del_eliminado = 0

            for visitante in self.lista_de_visitantes_menores:
                if visitante.get_id() == id and visitante.is_esta_en_visita()==False:
                    self.lista_de_visitantes_menores.pop(indice_del_eliminado)
                    print("\n**El visitante menor ha sido eliminado de forma correcta**")
                    return
                indice_del_eliminado += 1
            print("\n**El visitante no puede ser eliminado*")
        elif opcion == 2:
            print("\nIngresa el id del visitante adulto que deseas eliminar: ")
            id = int(input())
            indice_del_eliminado = 0

            for visitante in self.lista_de_visitantes_adultos:
                if visitante.get_id() == id and visitante.is_esta_en_visita()==False:
                    self.lista_de_visitantes_adultos.pop(indice_del_eliminado)
                    print("\n**El visitante adulto ha sido eliminado de forma correcta**")
                    return
                indice_del_eliminado += 1
            print("\n**El visitante no puede ser eliminado*")

        else:
            print("\nOpción inválida.")

    def eliminar_animal(self):
        print("\nIngresa el id del animal que deseas eliminar: ")
        id = int(input())
        indice_del_eliminado = 0

        for animal in self.lista_de_animales:
            if animal.get_id() == id:
                self.lista_de_animales.pop(indice_del_eliminado)
                print("\n**El animal ha sido eliminado de forma correcta**")
                return
            indice_del_eliminado += 1


    #*************************************MODIFICACIÓN DE DATOS******************************************
    def modificar_empleado(self):
        print("\nIngrese el id: ")
        empleado_id = int(input())

        for empleado in self.lista_de_empleados:
            if empleado.get_id() == empleado_id:
                seguir_modificando = 1
                while seguir_modificando != 2:
                    print("\n¿Qué desea modificar?: ")
                    print("\n1. Nombre. \n2. Apellido. \n3. Fecha De Nacimiento \n4. CURP. \n5. Fecha De Ingreso Como Trabajador. \n6. RFC  \n7. Salario. \n8. Horario \n9. Rol")

                    print("\nSeleccione una opción: ")
                    modificacion = int(input())

                    datos_persona = []
                    if modificacion == 1:
                        new_name = input("\nNuevo nombre: ")
                        empleado.set_name(new_name)
                    elif modificacion == 2:
                        new_apellido = input("\nNuevo apellido: ")
                        empleado.set_apellidos(new_apellido)
                    elif modificacion == 3:
                        new_fecha_de_nacimiento = input("\nNueva fecha de nacimiento: ")
                        empleado.set_fecha_de_nacimiento(new_fecha_de_nacimiento)
                    elif modificacion == 4:
                        new_CURP = input("\nCorrección de CURP: ")
                        empleado.set_CURP(new_CURP)
                    elif modificacion == 5:
                        new_fecha_de_ingreso = input("\nFecha de ingreso como trabajador: ")
                        empleado.set_fecha_de_ingreso_como_trabajador(new_fecha_de_ingreso)
                    elif modificacion == 6:
                        new_RFC = input("\nNuevo RFC: ")
                        empleado.set_rfc(new_RFC)
                    elif modificacion == 7:
                        new_salary = float(input("\nNuevo Salario: "))
                        empleado.set_salary(new_salary)
                    elif modificacion == 8:
                        new_horario = input("\nNuevo horario de trabajo: ")
                        empleado.set_horario(new_horario)
                    elif modificacion == 9:
                        print("\nNuevo rol: ")
                        print("\n1. Veterinario. \n2. Guía. \n3. Administración. \n4. Mantenimiento. \n5. Exit:")
                        numero_de_rol = int(input("\nEscriba el número: "))
                        empleado.set_numero_de_rol(numero_de_rol)
                        new_rol = ""
                        if numero_de_rol == 1:
                            new_rol = "Veterinario"
                        elif numero_de_rol == 2:
                            new_rol = "Guía"
                        elif numero_de_rol == 3:
                            new_rol = "Administración"
                        elif numero_de_rol == 4:
                            new_rol = "Mantenimiento"
                        else:
                            print("\nIngrese una opción válida.")
                    else:
                        print("\nIngrese una opción válida.")

                    print("\n¿Desea seguir modificando? \n1. Sí. \n2. No.")
                    seguir_modificando = int(input("\nSeleccione una opción: "))
                    if seguir_modificando != 1:
                        break

    def modificar_visitante(self):
        print("\n**Listas disponibles**")
        print("\n1. Niños \n2. Adultos")
        opcion = int(input("\nSeleccione una lista: "))

        if opcion == 1:
            buscar_visitante = int(input("Ingrese el id del visitante menor: "))

            for new_visitante in self.lista_de_visitantes_menores:
                if new_visitante.get_id() == buscar_visitante:
                    while True:
                        print("\n¿Qué desea modificar?: ")
                        print("\n1. Nombre.   \n2. Apellido.   \n3. Fecha De Nacimiento."
                            + "\n4. CURP.    \n5. Fecha De Registro")
                        modificacion = int(input("\nSeleccione una opción: "))
                        input()

                        if modificacion == 1:
                            new_name = input("\nNuevo nombre: ")
                            new_visitante.set_name(new_name)
                        elif modificacion == 2:
                            new_apellido = input("\nNuevo apellido: ")
                            new_visitante.set_apellidos(new_apellido)
                        elif modificacion == 3:
                            new_fecha_de_nacimiento = input("\nNueva fecha de nacimiento: ")
                            new_visitante.set_fecha_de_nacimiento(new_fecha_de_nacimiento)
                        elif modificacion == 4:
                            new_curp = input("\nNueva CURP: ")
                            new_visitante.set_CURP(new_curp)
                        elif modificacion == 5:
                            new_fecha_de_registro = input("\nNueva fecha de registro: ")
                            new_visitante.set_fecha_de_registro(new_fecha_de_registro)
                        else:
                            print("\nOpción no válida.")

                        seguir_modificando = int(input("\n¿Desea seguir modificando? \n1: Sí \n2: No"
                                                        "\nSeleccione una opción: "))
                        if seguir_modificando == 2:
                            break
        elif opcion == 2:
            buscar_visitante2 = int(input("\nIngrese el id del visitante adulto: "))

            for new_visitante in self.lista_de_visitantes_adultos:
                if new_visitante.get_id() == buscar_visitante2:
                    while True:
                        print("\n¿Qué desea modificar?: ")
                        print("\n1. Nombre.   \n2. Apellido.   \n3. Fecha De Nacimiento."
                            + "\n4. CURP.    \n5. Fecha De Registro")
                        modificacion = int(input("\nSeleccione una opción: "))
                        input()

                        if modificacion == 1:
                            new_name = input("\nNuevo nombre: ")
                            new_visitante.set_name(new_name)
                        elif modificacion == 2:
                            new_apellido = input("\nNuevo apellido: ")
                            new_visitante.set_apellidos(new_apellido)
                        elif modificacion == 3:
                            new_fecha_de_nacimiento = input("\nNueva fecha de nacimiento: ")
                            new_visitante.set_fecha_de_nacimiento(new_fecha_de_nacimiento)
                        elif modificacion == 4:
                            new_curp = input("\nNueva CURP: ")
                            new_visitante.set_CURP(new_curp)
                        elif modificacion == 5:
                            new_fecha_de_registro = input("\nNueva fecha de registro: ")
                            new_visitante.set_fecha_de_registro(new_fecha_de_registro)
                        else:
                            print("\nOpción no válida.")

                        seguir_modificando = int(input("\n¿Desea seguir modificando? \n1: Sí \n2: No"
                                                        "\nSeleccione una opción: "))
                        if seguir_modificando == 2:
                            break
        else:
            print("\nOpción no válida")

    def modificar_animal(self):
        print("\nIngresa el id del animal que deseas modificar: ")
        animal_id = int(input())

        opcion = 0
        for animal in self.lista_de_animales:
            if animal.get_id() == animal_id:
                while opcion != 9:
                    print("\n¿Qué deseas modificar del animal?")
                    print("1. Tipo de animal")
                    print("2. Fecha de nacimiento")
                    print("3. Fecha de llegada")
                    print("4. Enfermedades")
                    print("5. Tipo de alimentación")
                    print("6. Peso")
                    print("7. Frecuencia de alimentación")
                    print("8. Cuenta con vacunas")
                    print("9. Salir")

                    print("\nSeleccione una opción: ")
                    opcion = int(input())

                    if opcion == 1:
                        print("\nIngresa el tipo de animal: ")
                        tipo = input()
                        animal.set_tipo_animal(tipo)
                    elif opcion == 2:
                        print("\nIngresa la fecha de nacimiento: ")
                        fecha = input()
                        animal.set_fecha_de_nacimiento(fecha)
                    elif opcion == 3:
                        print("\nIngresa la fecha de llegada: ")
                        llegada = input()
                        animal.set_fecha_de_llegada(llegada)
                    elif opcion == 4:
                        print("\nIngresa las enfermedades: ")
                        numero_enfermedades = len(animal.get_enfermedad())
                        enfermedades = []
                        for i in range(numero_enfermedades):
                            print("Enfermedad {}: ".format(i + 1))
                            enfermedades.append(input())
                        animal.set_enfermedad(enfermedades)
                    elif opcion == 5:
                        print("\nIngresa el tipo de alimentación: ")
                        alimentacion = input()
                        animal.set_tipo_de_alimentacion(alimentacion)
                    elif opcion == 6:
                        print("\nIngresa el peso: ")
                        peso = float(input())
                        animal.set_peso(peso)
                    elif opcion == 7:
                        print("\nIngresa la frecuencia de alimentación: ")
                        frecuencia_alimentos = int(input())
                        animal.set_frecuencia_de_alimentacion(frecuencia_alimentos)
                    elif opcion == 8:
                        print("\nCuenta con vacunas. \n 1. Si \n 2. No")
                        print("\nSeleccione una opción: ")
                        vacunas = input().lower()
                        if vacunas == "si":
                            animal.set_cuenta_con_vacunas(True)
                        elif vacunas == "no":
                            animal.set_cuenta_con_vacunas(False)
                    elif opcion == 9:
                        print("\nSalir")
                    else:
                        print("Ingresa una opción válida")

                break
        else:
            print("\nEl animal no fue encontrado, verifica el id ingresado.")


    #************************************************VISITA*********************************************
    def realizar_visita(self):
        lista_de_visitantes = []
        print("\nIngresa el id del guía: ")
        id_guia = int(input())

        if self.es_guia(id_guia):
            nueva_visita = Visita()
            print("Ingresa la cantidad de visitantes: ")
            numero_visitantes = int(input())

            for i in range(numero_visitantes):
                print("Ingresa el id del visitante: ")
                id_visitante = int(input())

                nuevo_visitante = Visitantes()

                if self.es_visitante(id_visitante):
                    self.es_visitante(id_visitante).set_num_de_visitas()
                    self.es_visitante(id_visitante).set_esta_en_visita(True)
                    lista_de_visitantes.append(self.es_visitante(id_visitante))
                    self.agregar_visitante(self.es_visitante(id_visitante))

            print("Fecha de la visita con formato YYYY-MM-DD: ")
            fecha_de_la_visita = input()

            nueva_visita = Visita(id_guia, fecha_de_la_visita, self.cantidad_adultos, self.cantidad_niños)
            
            print("\n**Visita agregada, el id generado es " + str(nueva_visita.get_id_visita()) + "**")

            print("\n\n***Información de visita***")
            print("Id de visita: " + str(nueva_visita.get_id_visita()))
            print("No. de adultos en visita: " + str(nueva_visita.get_cantidad_adultos()))
            print("No. de niños en visita: " + str(nueva_visita.get_cantidad_niños()))
            print("Fecha de la visita: " + nueva_visita.get_fecha_de_la_visita())
            print("Costo total de la visita: " + str(nueva_visita.calcular_costo_total(lista_de_visitantes)))
            


    def es_visitante(self, id):
        for visitante in self.lista_de_visitantes:
            if visitante.get_id() == id:
                
                return visitante
        return False

    def agregar_visitante(self, visitante):
        if self.es_adulto(visitante):
            
            self.cantidad_adultos += 1
        else:
            self.cantidad_niños += 1

    def es_adulto(self, visitante):

        return visitante.calcular_edad() >= 18

    def es_guia(self, empleado_id):
        for empleado_buscar in self.lista_de_empleados:
            if empleado_buscar.get_id() == empleado_id:
                return empleado_buscar.get_rol() == "Guía"
        return False
    

    #**********************************************MANTENIMIENTO**************************************
    lista_mantenimientos = []

    def mantenimiento_animales(self):
        print("\nIngresar id del empleado: ")
        empleado_asignado = int(input())

        if self.es_mantenimiento(empleado_asignado):
            print("Id del animal en mantenimiento: ")
            animal_mantenido = int(input())

            if self.es_animal(animal_mantenido):
                proceso_realizado = input("Ingresa el proceso de mantenimiento realizado: ")
                fecha_mantenimiento = input("Ingresa la fecha del mantenimiento: ")

                print("Deseas agregar observaciones al proceso? \n1.Si \n2.No")
                opcion_observaciones = int(input("Seleccione una opción: "))

                if opcion_observaciones == 1:
                    observaciones = input("Ingresa las observaciones correspondientes: ")
                    nuevo_mantenimiento = Mantenimiento(empleado_asignado, proceso_realizado, fecha_mantenimiento, observaciones)
                    self.lista_mantenimientos.append(nuevo_mantenimiento)
                    print("**\nEl mantenimiento ha sido registrado, su id es: " + str(nuevo_mantenimiento.get_id()))
                elif opcion_observaciones == 2:
                    nuevo_mantenimiento = Mantenimiento(empleado_asignado, proceso_realizado, fecha_mantenimiento)
                    self.lista_mantenimientos.append(nuevo_mantenimiento)
                    print("**\nEl mantenimiento ha sido registrado, su id es: " + str(nuevo_mantenimiento.get_id()))
            else:
                print("\nEl id del animal ingresado no corresponde a un animal registrado.")
        else:
            print("\nEl id ingresado no corresponde a un empleado de mantenimiento.")

    def es_mantenimiento(self, empleado_id):
        for empleado_buscar in self.lista_de_empleados:
            if empleado_buscar.get_id() == empleado_id:
                return empleado_buscar.get_rol() == "Mantenimiento"
        return False

    def es_animal(self, animal):
        for animal_buscar in self.lista_de_animales:
            if animal_buscar.get_id() == animal:
                return True
        return False

    def mostrar_mantenimiento(self):
        id_mantenimiento = int(input("\nIngresa el id del mantenimiento: "))
        for mantenimiento in self.lista_mantenimientos:
            if mantenimiento.get_id() == id_mantenimiento:
                for empleado in self.lista_de_empleados:
                    if empleado.get_id() == mantenimiento.get_id_encargado():
                        print(mantenimiento.get_informacion_mantenimiento() + "\nEl nombre del empleado es: " + empleado.get_name())
                        return
        print("No se encontró el mantenimiento con el id proporcionado.")
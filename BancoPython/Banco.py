


class Banco:
    empleados = [] 
    cuentas = [] 

    def agregar_empleado(self, empleado):
        self.empleados.append(empleado)

    def agregar_cuenta(self, cuenta):
        self.cuentas.append(cuenta)

    def get_empleados(self):
        return self.empleados
    
    def mostrarCuenta(self):
        for cuenta in self.cuentas:
            cuenta.mostrar_informacion()

    def mostrar_empleados(self):
        if not self.empleados:
            print("\nNo hay empleados registrados.")
            return

        print("\n*** LISTA DE EMPLEADOS ***")
        for empleado in self.empleados:
            empleado.mostrar_info()

    def mostrar_empleados_por_cuenta(self, num_cuenta):
        if not self.empleados:
            print("\nNo existen empleados registrados.")
            return

        print("\n*** EMPLEADO ***")
        for empleado in self.empleados:
            for cuenta in empleado.get_cuentas():
                if cuenta.get_account_number() == num_cuenta:
                    empleado.ver_cuentas()

    def buscar_empleado(self, num_cuenta):
        for empleado in self.empleados:
            for cuenta in empleado.get_cuentas():
                if cuenta.get_account_number() == num_cuenta:
                    return empleado
        return None
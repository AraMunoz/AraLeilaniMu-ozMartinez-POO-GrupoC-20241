from Employee import Employee
from BankAccount import BankAccount
from Banco import Banco

def main():
    employee = []  # List for employees
    cuentas = []   
    banco = Banco()  # Instance of Banco
    tipo_cuenta = 'a'
    op = 0
    err = False

    while True:
       # print("****BIENVENIDO AL BANCO****")
        print("1. Registrar empleado")
        print("2. Ver todos los empleados")
        print("3. Buscar un empleado")
        print("4. Salir")
        op = int(input())

        if op == 1:
            nombre = input("Ingresa el nombre del empleado: ")
            edad = int(input("Ingresa la edad del empleado: "))
            sueldo = float(input(f"Ingresa el sueldo de {nombre}: "))

            empleado = Employee(nombre, edad, sueldo)
            banco.agregar_empleado(empleado)

            num_cuentas = int(input("Cuantas cuentas deseas ingresar para este usuario? "))
            for _ in range(num_cuentas):
                 tipo_valido = False
                 while not tipo_valido:
                     tipo_cuenta = input("Ingresa el tipo de cuenta del empleado: ").lower()
                     format_account_type = tipo_cuenta.upper()
                     if format_account_type in {'A', 'B', 'C'}:
                         tipo_valido = True
                     else:
                         print("Ingresa un tipo de cuenta valido")

                 numero_cuenta = int(input("Ingresa el numero de cuenta del empleado: "))
                 cuenta = BankAccount(numero_cuenta, tipo_cuenta)  # Instance of BankAccount
                 cuentas.append(cuenta)
                 empleado.set_account(cuenta)
                 empleado.get_cuentas().append(cuenta)

            employee.append(empleado)
           

        elif op == 2:
             banco.mostrar_empleados()

        elif op == 3:
            #banco.mostrar_empleados()
            print("Elegiste la opcion de ver un usuario registrado")
            number = int(input("Ingresa el numero de cuenta del empleado que deseas ver: "))
            us = False
            emplead = banco.buscar_empleado(number)
            if emplead is not None:
                emplead.ver_cuentas()
                i=0
                while i!=1:
                 print(f"Que deseas realizar con la cuenta: {number}\n1. Depositar\n2. Retirar\n3. Salir")
                 op = int(input("R= "))
                 if op == 1:
                     print("Que cantidad deseas depositar $")
                     cantidad = float(input())
                     empleado_deposito = banco.buscar_empleado(number)
                     if empleado_deposito is not None:
                         cuenta_deposito = empleado_deposito.buscar_cuenta(number)
                         if cuenta_deposito is not None:
                             tipo = cuenta_deposito.get_tipo()
                             empleado_deposito.buscar_cuenta(number).depositar(cantidad, tipo)
                         else:
                             print("Número de cuenta no encontrado.")
                     else:
                            print("Empleado no encontrado.")
                 elif op == 2:
                     print("Que cantidad deseas retirar $")
                     cantidad = float(input())
                     empleado_retiro = banco.buscar_empleado(number)
                     if empleado_retiro is not None:
                         cuenta_retiro = empleado_retiro.buscar_cuenta(number)
                         if cuenta_retiro is not None:
                             tipo = cuenta_retiro.get_tipo()
                             empleado_retiro.buscar_cuenta(number).retirar(cantidad, tipo)
                         else:
                             print("Número de cuenta no encontrado.")
                     else:
                         print("Empleado no encontrado.")
                 elif op == 3:
                    print("Good bye!")
                    i=1
            else: 
                print("No se encontro el usuario")

        

       
      

main()
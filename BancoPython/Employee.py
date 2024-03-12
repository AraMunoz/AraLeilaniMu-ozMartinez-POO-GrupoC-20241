class Employee:
    
    __name = ""
    __age = 0
    __salary = 0.0
    cuentas = [] 

    def __init__(self, name, age, salary ):
        self.__name=name
        self.__age=age
        self.__salary=salary

    def agregar_cuenta(self, cuenta):
        self.cuentas.append(cuenta)

    def get_cuentas(self):
        return self.cuentas

    def set_cuentas(self, cuentas):
        self.cuentas = cuentas

    def get_name(self):
        return self.__name

    def set_name(self, name):
        self.__name = name

    def get_age(self):
        return self.__age

    def set_age(self, age):
        self.__age = age

    def get_salary(self):
        return self.__salary

    def set_salary(self, salary):
        self.__salary = salary

    def get_account(self):
        return self.account

    def set_account(self, account):
        self.account = account

    def get_information(self):
        return f"El nombre del empleado es {self.name}, su cuenta {self.account.get_account_number()}, su saldo actual es {self.account.get_monto():.2f} y la cuenta es de tipo {self.account.tipo}"

    def ver_cuentas(self):
        print("\nINFORMACIÓN DEL EMPLEADO")
        print(f"Nombre: {self.__name} Edad: {self.get_age()} Salario: {self.__salary}")
        print("****Cuentas bancarias:")
        for b in self.cuentas:
                b.mostrar_informacion()

    def buscar_cuenta(self, numero_cuenta):
        for cuenta in self.cuentas:
            if cuenta.get_account_number() == numero_cuenta:
                return cuenta
        return None


    def mostrar_info(self):
        print(f"Nombre {self.__name}, edad: {self.__age}")

   
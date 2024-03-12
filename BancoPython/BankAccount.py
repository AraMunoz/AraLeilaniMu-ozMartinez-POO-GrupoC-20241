
class BankAccount:
    
    __accountnumber = 0
    __monto = 0.0
    __tipo = ''
    
      

    def __init__(self, account_number, tipo):
        self.account_number = account_number
        self.tipo = tipo
        self.monto = 0.0

    def get_account_number(self):
        return self.account_number

    def set_account_number(self, account_number):
        self.account_number = account_number

    def get_monto(self):
        return self.monto

    def set_monto(self, monto):
        self.monto = monto

    def get_tipo(self):
        return self.tipo

    def set_tipo(self, tipo):
        self.tipo = tipo

    def mostrar_informacion(self):
        print(f"Número de cuenta: {self.account_number}\nSaldo: {self.monto}\nTipo de cuenta: {self.tipo}")

    def depositar(self, cantidad, tipo):
        try:
            if tipo.lower() == 'a':
                self._add_money_a(cantidad)
            elif tipo.lower() == 'b':
                self._add_money_b(cantidad)
            else:
                self.monto += cantidad
                self._deposito_correcto(cantidad)
        except Exception as e:
            print("Introduce una cantidad valida para tu cuenta")

    def _add_money_a(self, cantidad):
        if self.monto + cantidad >= 50000:
            print("No puedes tener más de 50,000 en tipo de cuenta A")
        else:
            self.monto += cantidad
            self._deposito_correcto(cantidad)

    def _add_money_b(self, cantidad):
        if self.monto + cantidad >= 100000:
            print("No puedes tener más de 100,000 en tipo de cuenta B")
        else:
            self.monto += cantidad
            self._deposito_correcto(cantidad)

    def _deposito_correcto(self, cantidad):
        print(f"Se ha depositado correctamente {cantidad} a su cuenta, ahora su saldo es {self.monto}")

    def retirar(self, cantidad, tipo):
        if tipo.lower() == 'a':
            self._retirar_money_a(cantidad)
        elif tipo.lower() == 'b':
            self._retirar_money_b(cantidad)
        elif tipo.lower() == 'c':
            self._retirar_money_c(cantidad)

    def _retirar_money_a(self, cantidad):
        if self.monto - cantidad >= 1000:
            self.monto -= cantidad
            print(f"Se ha retirado correctamente {cantidad} a su cuenta, ahora su saldo es {self.monto}")
        else:
            print("No puedes tener menos de 1000 en tu cuenta tipo A")

    def _retirar_money_b(self, cantidad):
        if self.monto - cantidad >= 5000:
            self.monto -= cantidad
            print(f"Se ha retirado correctamente {cantidad} a su cuenta, ahora su saldo es {self.monto}")
        else:
            print("No puedes tener menos de 5000 en tu cuenta tipo B")

    def _retirar_money_c(self, cantidad):
        if self.monto - cantidad >= 10000:
            self.monto -= cantidad
            print(f"Se ha retirado correctamente {cantidad} a su cuenta, ahora su saldo es {self.monto}")
        else:
            print("No puedes tener menos de 10000 en tu cuenta tipo C")
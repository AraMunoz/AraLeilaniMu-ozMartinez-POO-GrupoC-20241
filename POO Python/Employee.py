class Employee:
    name = "Ara"
    Age = 19

# Para hacer atributos privados de pone __
    def __init__(self, name, age):
        self.name = name
        self.Age = age


    def get_name (self): 
        return self.name

    def set_name (self, name):
        self.name = name


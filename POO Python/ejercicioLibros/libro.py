import random
class libro:
    __id = 0
    __name = ""
    __autor = ""
    __disponible = false

    def __init__(self, name, autor):
        self.__id = random.randint(1,1000)
        self.__name = name 
        self.__autor = autor 
        self.__disponible = true

    def get__disponible (self):
        return self.__disponible
    
    def set__disponible (self, disponible):
         self.__disponible = disponible
    
    
    
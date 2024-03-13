import random
class Libro:
    __id = 0
    __name = ""
    __autor = ""
    __disponible = False

    def __init__(self, name, autor):
        self.__id = random.randint(1,1000)
        self.__name = name 
        self.__autor = autor 
        self.__disponible = True

    def get__disponible (self):
        return self.__disponible
    
    def get_autor (self):
        return self.__autor
    
    def get_id(self) :
        return self.__id  
    
    def get_name (self):
        return self.__name
    
    def set__disponible (self, disponible):
         self.__disponible = disponible
    
    
    
    
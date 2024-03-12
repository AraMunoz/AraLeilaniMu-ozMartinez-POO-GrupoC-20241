import random

class Usuario:
    __id = 0
    __nombre = ""
    __edad = 0
    __libros_rentados = []

    def __init__(self, id, nombre, edad):
        self.__id = random.randint(1,100)
        self.__nombre = nombre
        self.__edad = edad

    def get_nombre(self) :
        return self.__nombre  
     
    def set_nombre(self, nombre) :
        self.__nombre = nombre  

    def get_edad(self) :
        return self.__edad  
     
    def set_edad(self, edad) :
        self.__edad = edad  

    def get_id(self) :
        return self.__id  
     
    def set_id(self, id) :
        self.__id = id 
    
    def rentar_libro(self, libro ):
        libros_rentados.append(libro)



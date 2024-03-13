import random

class Usuario:
    __id = 0
    __nombre = ""
    __edad = 0
    

    def __init__(self, nombre, edad):
        self.__id = random.randint(1,1000)
        self.__nombre = nombre
        self.__edad = edad
        self.__libros_rentados = []

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
    
    def rentar_libro(self, libro):
        self.__libros_rentados.append(libro)
        print(f"El libro {libro.get_name()} ha sido rentado por {self.__nombre}.")

    def get_libros_rentados(self):
        return self.__libros_rentados
    
    


class Libreria:
    __usuarios = []
    __libros = []
    def agregar_usuario(self, usuario):
        self.__usuarios.append(usuario)

    def agregar_libros(self, libro):
        self.__libros.append(libro)
    
    def mostrar_usuarios (self):
        for usuario in self.__usuarios:
            print("***Usuarios***")
            oracion = f"El nombre del usuario es: {usuario.get_nombre}, su edad es: {usuario.get_edad}"
           
        

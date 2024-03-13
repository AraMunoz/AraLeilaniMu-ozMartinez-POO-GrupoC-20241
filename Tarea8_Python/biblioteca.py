
class Libreria:
    __usuarios = []
    __libros = []
    def agregar_usuario(self, usuario):
        self.__usuarios.append(usuario)

    def agregar_libros(self, libro):
        self.__libros.append(libro)
    
    def mostrar_usuarios (self):
        print("***Usuarios***")
        for usuario in self.__usuarios:
            oracion = f"El nombre del usuario es: {usuario.get_nombre()}, su edad es: {usuario.get_edad()}, su id es: {usuario.get_id()} "
            print(oracion)
    
    def mostrar_libros (self):
         print("***Libros***")
         for libros in self.__libros:
            oracion = f"El nombre del libro es: {libros.get_name()}, su autor es: {libros.get_autor()} su id es: {libros.get_id()}"
            print(oracion)

    def rentar_libro(self, id_usuario, id_libro):
        usuario_encontrado = None
        for usuario in self.__usuarios:
            if usuario.get_id() == id_usuario:
                usuario_encontrado = usuario
                break
        
        if usuario_encontrado is None:
            print("Usuario no encontrado.")
            return
        
        libro_encontrado = None
        for libro in self.__libros:
            if libro.get_id() == id_libro:
                libro_encontrado = libro
                break
        
        if libro_encontrado is None:
            print("Libro no encontrado.")
            return
        
        if libro_encontrado.get__disponible():
            usuario_encontrado.rentar_libro(libro_encontrado)
            libro_encontrado.set__disponible(False)
            print("El libro fue rentado con exito")
        else:
            print("El libro no está disponible para renta.")

    def mostrar_usuarios_con_libros_rentados(self):
        for usuario in self.__usuarios:
            libros_rentados = usuario.get_libros_rentados()
            if libros_rentados != None:
                print(f"Usuario: {usuario.get_nombre()} - Libros rentados:")
                for libro in libros_rentados:
                    print(f"- {libro.get_name()} de {libro.get_autor()}")    

    def mostrar_libros_rentados(self):
        print("Libros rentados:")
        for libro in self.__libros:
            if libro.get__disponible()!= True:
                print(f"El libro {libro.get_name()} de {libro.get_autor()}")
                
    def mostrar_libros_no_rentados(self):
        print("Libros no rentados:")
        for libro in self.__libros:
            if libro.get__disponible():
                print(f"- {libro.get_name()} de {libro.get_autor()}")
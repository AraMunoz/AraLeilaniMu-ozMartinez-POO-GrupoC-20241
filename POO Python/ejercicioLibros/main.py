from biblioteca import Libreria
from usuario import Usuario
from libro import libro

usuario_uno = Usuario ("Maria Perez", 20)
usuario_dos = Usuario ("Ara Martinez", 18)

Libreria.agregar_usuario(usuario_uno)
Libreria.agregar_usuario(usuario_dos)

while True: 
    print("BIENVENIDO A LA LIBRERIA")
    print("Elige una opcion para continuar")
    print("1. Añadir usuario")
    print("2. Añadir libro")
    print("3. Rentar libro")
    print("5. Mostrar Usuarios con libros")
    print("6. Mostrar libros registrados")
    print("7. Mostrar libros disponibles")
    print("8. Mostrar libros en renta")
    print("9. Salir")
    opcion = input("Ingresa a opcion ")

    if opcion == "1":       
     print("\nElegiste la opción 1\n")        
     nombre = input("Ingresa el nombre del usuario: ")      
     edad = int(input("Ingresa la edad del usuario: "))       
     usuario = Usuario(nombre, edad)        
     Libreria.agregar_usuario(usuario)      
     print(f"El usuario {nombre} ha sido registrado\n")    
     
    elif opcion == "2":       
     print("\nElegiste la opción 2\n")        
     nombre = input("Ingresa el nombre del libro: ")      
     autor = input("Ingresa el autor: ")       
     libro = libro(nombre, autor)        
     Libreria.agregar_libro(libro)      
     print(f"El libro {nombre} de autor {autor} ha sido registrado\n") 

    elif opcion == "3":       
     print("\nElegiste la opción 3\n")        
     id_usuario = input("Ingresa tu id de usuario: ")      
     id_libro = input("Ingresa id del libro: ")       
     


    elif opcion == "5":        
        print("\nElegiste la opción 2")      
        print("Se mostrarán los usuarios\n")      
        Libreria.mostrar_usuarios()      
    else:        
       break
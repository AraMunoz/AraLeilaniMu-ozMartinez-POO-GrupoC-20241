from biblioteca import Libreria
from usuario import Usuario
from libro import Libro
Libreria = Libreria()
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
    print("4. Mostrar Usuarios ")
    print("5. Mostrar Usuarios con libros")
    print("6. Mostrar libros registrados")
    print("7. Mostrar libros rentados")
    print("8. Mostrar libros disponibles")
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
     libro = Libro(nombre, autor)        
     Libreria.agregar_libros(libro)      
     print(f"El libro {nombre} de autor {autor} ha sido registrado\n") 

    elif opcion == "3":       
     print("\nElegiste la opción 3\n")        
     id_usuario = int(input("Ingresa tu id de usuario: ") )     
     id_libro = int(input("Ingresa id del libro: ") ) 
     Libreria.rentar_libro(id_usuario,id_libro )

    elif opcion == "4":        
        print("\nElegiste la opción 4")      
        print("Se mostrarán los usuarios\n")      
        Libreria.mostrar_usuarios() 
    
    elif opcion == "5":        
        print("\nElegiste la opción 5")      
        print("Se mostrarán los usuarios con libros rentados\n")      
        Libreria.mostrar_usuarios_con_libros_rentados() 

    elif opcion == "6":        
        print("\nElegiste la opción 6")      
        print("Se mostrarán los libros\n")      
        Libreria.mostrar_libros() 

    elif opcion == "7":        
        print("\nElegiste la opción 7")      
        print("Se mostrarán los libros rentados\n")      
        Libreria.mostrar_libros_rentados() 

    elif opcion == "8":        
        print("\nElegiste la opción 8")      
        print("Se mostrarán los libros que no han sido rentados\n")      
        Libreria.mostrar_libros_no_rentados()      
    else:        
       break
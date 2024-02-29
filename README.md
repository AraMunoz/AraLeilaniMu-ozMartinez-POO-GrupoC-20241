# Tarea 6 - Unidad 2

###Getters and Setters 
En la tarea seis de la segunda unidad se creo la clase "Productos", la cual cuenta con atributos privados y métodos públicos. Todos los métodos cuentan con sus validaciones correspondientes para evitar un stock negativo y un nombre de producto nulo en caso de intentar una modificación en el producto que no sea posible realizar se notifica al usuario con un mensaje. 

###Métodos y atributos de la clase "Productos"
#### Atrubutos

- String name
- float precio
- int stock

#### Métodos

- Getters and Setters de cada atributo
- Aumentar Stock
- Reducir Stock

También se crearon cuatro instancias de la clase "Productos" y se les asignaron datos empleando un constructor. Posteriormente estos datos fueron modificados utilizando los métodos correspondientes 

         Producto producto = new Producto ("Galletas", 28.90f, 20);
        Producto productoDos = new Producto ("Arroz", 20.50f, 10);
        Producto productoTres = new Producto ("Atun", 23.90f);
        Producto productoCuatro = new Producto ("Dulces", 5.90f, 200);



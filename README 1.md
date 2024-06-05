
## EXAMEN FINAL POO


# Integrantes
- Diana Estefani Parrales Ávalos
- Ara Leilani Muñoz Martínez
- José Juan García Jiménez



# Mindbox - Sistema de Gestión Escolar

El Instituto Tecnológico de Morelia está buscando un nuevo sistema para gestionar toda la escuela, incluyendo alumnos, maestros, administrativos, grupos, etc. Han decidido realizar una licitación para este proyecto, en la cual tú y tu equipo de desarrolladores han decidido participar con el nuevo sistema “Mindbox”.

## Requerimientos Principales 🏁

1. **Inicialización del Sistema**: Al iniciar el programa por primera vez, debe cargar las 3 carreras descritas posteriormente. A partir de la segunda ejecución, debe cargar los cambios realizados anteriormente.
2. **Persistencia de Datos**: Toda la información debe guardarse en archivos JSON.
3. **Coordinadores Iniciales**: Debe existir un coordinador por carrera desde el inicio.
4. **Validaciones y Manejo de Excepciones**: El sistema debe ser robusto y sin fallas, con validaciones adecuadas y manejo de excepciones.

## Carreras 📒

El sistema contará con 3 carreras:

| Nombre                              | Abreviación |
| ----------------------------------- | ----------- |
| Ingeniería en Sistemas Computacionales | ISC         |
| Ingeniería en Materiales            | IMAT        |
| Ingeniería Electrónica              | ELC         |

### Atributos de una Carrera

- Id
- Nombre carrera
- Cantidad de grupos
- Cantidad de alumnos
- Cantidad de materias
- Fecha de creación
- Coordinador

## Semestres 📕

El sistema contemplará 3 semestres únicamente. El coordinador tendrá la opción de avanzar un grupo de semestre, asignando las nuevas materias del siguiente semestre a todo el grupo.

### Ejemplo de Avance de Semestre

El grupo A de 1er semestre de la carrera de Sistemas tiene 3 materias: Matemáticas 1, Programación 1 y Cálculo 1. Si el coordinador avanza el semestre de ese grupo, pasará al semestre 2 con nuevas materias: Matemáticas 2, Programación 2 y Cálculo 2, sin calificaciones registradas.

#### Consideraciones:

- Si un alumno reprueba alguna materia, permanecerá en el semestre actual y se le removerán sus calificaciones anteriores.
- Si un alumno no tiene todas sus calificaciones registradas, no podrá avanzar de semestre.

### Atributos de un Semestre

- Id
- Número de semestre
- Carrera
- Grupos

## Graduados 🎓

Registro de los alumnos que ya se graduaron, con los siguientes datos:

- Fecha graduación
- Carrera
- Alumnos (incluyendo el promedio de graduación)
- Generación de graduación (Ejemplo: Ene - Jun 2024, Ago - Dic 2024)

## Grupos 📗

Un grupo contendrá a los alumnos, con un mínimo de 3 estudiantes y un máximo de 20 estudiantes. Debe existir un grupo por carrera, comenzando con el grupo A, y máximo 2 grupos, que sería el B.

### Atributos de un Grupo

- Carrera a la que pertenece
- Alumnos
- Tipo de grupo (A o B)
- Id
- Materias que tiene
- Semestre

## Materias 📙

Las materias dependerán del semestre y de la carrera.

### Atributos de una Materia

- Id
- Carrera a la que pertenece
- Grupo
- Profesor que la imparte

### Distribución de Materias por Carrera y Semestre

| Semestre | Carrera   | Materia 1       | Materia 2       | Materia 3       |
| -------- | --------- | --------------- | --------------- | --------------- |
| 1        | Sistemas  | Programación 1  | Probabilidad 1  | Cálculo 1       |
| 2        | Sistemas  | Programación 2  | Probabilidad 2  | Cálculo 2       |
| 3        | Sistemas  | Programación 3  | Probabilidad 2  | Cálculo 2       |
| 1        | Materiales| Estadística 1   | Contabilidad 1  | Cálculo 1       |
| 2        | Materiales| Estadística 2   | Contabilidad 2  | Cálculo 2       |
| 3        | Materiales| Estadística 3   | Contabilidad 3  | Cálculo 2       |
| 1        | Electrónica| Redes 1         | Circuitos 1     | Cálculo 1       |
| 2        | Electrónica| Redes 2         | Circuitos 2     | Cálculo 2       |
| 3        | Electrónica| Redes 3         | Circuitos 3     | Cálculo 2       |

## Calificaciones 📖

Las calificaciones podrán ser registradas únicamente por el profesor que imparte la materia o el coordinador, y podrán ser aprobatorias (arriba de 70) o reprobatorias. Además, los alumnos podrán ver toda la información de sus calificaciones, separadas por semestre y materia. Una vez que el semestre se ha avanzado, las calificaciones no podrán modificarse.

## Historial 📋

Los alumnos podrán visualizar su información anterior aún cuando cambien de semestre, incluyendo:

- Materias cursadas por semestre 
- Calificaciones de sus materias
- Profesores que les impartieron las materias
- Promedio por semestre 

## Roles ✅

El sistema contará con los siguientes roles:

- Alumno
- Trabajador
  - Profesor
  - Coordinador de carrera (puede ser también profesor)

### Alumno 👨🏽‍🎓

Un alumno podrá ser dado de alta únicamente por el coordinador de carrera. Todos los alumnos al momento de registrarse comenzarán en el semestre 1 de su carrera y pertenecerán a un grupo. Al registrarse, se les generará un número de control.

#### Formato del Número de Control

`l-{Primera letra de su nombre}-{Primero dos dígitos del año}-{Abreviación carrera}-{indice}`

Ejemplo: `lE24ISC0`

### Profesor 👨🏽‍🏫

El profesor podrá ser dado de alta únicamente por cualquier coordinador y podrá impartir más de 1 materia en cualquier carrera. Este rol podrá ver su información, actualizarla, ver sus grupos, asignar calificaciones, modificarlas, etc.

### Coordinador 🧑🏽‍🏫

El coordinador deberá existir cuando se cargue el sistema y podrá impartir 1 o más clases en cualquier carrera. Este rol podrá realizar todas las acciones únicamente en la carrera en la cual esté adscrito y será el único que podrá avanzar el semestre.

#### Formato del Número de Control para Coordinadores y Profesores

- Coordinador: `C-{Primera letra de su nombre}-{Primero dos dígitos del año}-{Abreviación carrera}-{indice}`
- Profesor: `M-{Primera letra de su nombre}-{Primero dos dígitos del año}-{Abreviación carrera}-{indice}`

Ejemplo: `CE24ISC0` y `ME24ISC0`

### Información Requerida para el Registro

#### Alumno

- Nombre
- Apellidos
- Año de nacimiento
- Ciudad
- Estado
- CURP (Crear un algoritmo para generarlo automáticamente de acuerdo a la información del alumno)
- Dirección
- Fecha de registro
- Carrera
- Semestre
- Grupo
- Promedio
- Número de control

#### Profesor/Coordinador

- Nombre
- Apellidos
- Año de nacimiento
- Ciudad
- Estado
- CURP (Crear un algoritmo para generarlo automáticamente de acuerdo a la información del profesor)
- Dirección
- Fecha de registro
- RFC (Crear un algoritmo para generarlo automáticamente de acuerdo a la información del profesor)
- Materias que imparte
- Sueldo
- Número de control
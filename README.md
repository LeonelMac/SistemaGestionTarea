# Prueba Técnica - Sistema de Gestión de Tareas - Leonel Macedo Mora

## Descripción
Este proyecto es un sistema de gestión de tareas que permite crear, consultar, actualizar y eliminar tanto tareas como proyectos. Las tareas están asociadas a un proyecto y pueden tener tres estados: `PENDIENTE`, `EN_PROGRESO` y `COMPLETADA`.

## Tecnologías utilizadas
- **Java 11**
- **Spring Boot 2.7.16**
- **H2 (Base de datos en memoria)**

## Requisitos para correr el proyecto
- **JDK 11** o superior
- **Maven** instalado

## Instrucciones para la ejecución del proyecto
1. Clonar el repositorio
Abre una terminal y clona el repositorio desde GitHub usando el siguiente comando:
* git clone https://github.com/LeonelMac/SistemaGestionTarea.git
Esto descargará todos los archivos del proyecto.

2. Navegar a la carpeta del proyecto
Después de clonar el repositorio, navega a la carpeta del proyecto recién clonado:
* cd tenica
Si usas cli sea bash o powershell, dado el caso de usar una interfaz gráfica busca donde clonaste el repositorio

3. Compilar y construir el proyecto
Usa Maven para limpiar, compilar e instalar las dependencias del proyecto. Ejecuta el siguiente comando en la raíz del proyecto:
* mvn clean install
Este comando se encargará de compilar el proyecto, ejecutar las pruebas, y descargar las dependencias necesarias.

4. Iniciar la aplicación Spring Boot
Una vez que el proyecto esté compilado correctamente, puedes iniciar la aplicación Spring Boot con el siguiente comando:
* mvn spring-boot:run
Este comando levantará el servidor embebido y ejecutará la aplicación Spring Boot.

5. Verificar que la aplicación Spring Boot está corriendo
Para comprobar que la aplicación se ha iniciado correctamente, abre tu navegador e ingresa la siguiente URL:
* http://localhost:8080/
Si ves una página de bienvenida o cualquier respuesta del servidor, significa que la aplicación está corriendo correctamente.

6. Acceder a la consola de H2 (base de datos)
Para interactuar con la base de datos H2 en memoria que está configurada en el proyecto, ingresa la siguiente URL en tu navegador:
* http://localhost:8080/h2-console/
Al acceder a la consola de H2, verás un formulario de inicio de sesión.

7. Ingresar credenciales para la base de datos H2
En la consola de H2, ingresa las credenciales que se encuentran en el archivo **src/main/resources/application.properties**. Estas son las propiedades que debes buscar:

JDBC URL: Probablemente se verá como jdbc:h2:mem:testdb
Username: El nombre de usuario configurado en application.properties que dado este caso es leonel.
Password: El password configurado, que para este caso es vacío.
Una vez que ingreses las credenciales correctas, haz clic en Connect para acceder a la base de datos.

## Endpoints de la API - Pruebas con Postman

*Link de la prueba técnica: **https://documenter.getpostman.com/view/34362609/2sAXxLDF4T**
*Ruta donde se encuentra el json de pruebas en postman: **tenica/Pruebas Postman/Prueba técnica.postman_collection.json**

# Proyectos
* GET /api/proyectos: Listar todos los proyectos.
   http://localhost:8080/api/proyectos
* GET /api/proyectos/{id}: Obtener un proyecto por ID.
   http://localhost:8080/api/proyectos/1
* POST /api/proyectos: Crear un nuevo proyecto.
   http://localhost:8080/api/proyectos
* PUT /api/proyectos/{id}: Actualizar un proyecto existente.
   http://localhost:8080/api/proyectos/3
* DELETE /api/proyectos/{id}: Eliminar un proyecto por ID.
   http://localhost:8080/api/proyectos/2

# Tareas
* GET /api/tareas: Listar todas las tareas.
   http://localhost:8080/api/tareas
* GET /api/tareas/{id}: Obtener una tarea por ID.
   http://localhost:8080/api/tareas/1
* POST /api/tareas: Crear una nueva tarea.
   http://localhost:8080/api/tareas
* PUT /api/tareas/{id}: Actualizar una tarea existente.
   http://localhost:8080/api/tareas/1
* PATCH /api/tareas/{id}/estado: Actualizar Solo el Estado de una Tarea.
   http://localhost:8080/api/tareas/1/estado
* DELETE /api/tareas/{id}: Eliminar una tarea por ID.
   http://localhost:8080/api/tareas/1

## Diagrama entidad-relación (ER).

*Ruta donde se encuentra el json de pruebas en postman: **tenica/Diagrama/**
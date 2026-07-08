# Proyecto CRUD de Productos

Este es un proyecto de ejemplo que demuestra una API REST para operaciones CRUD (Crear, Leer, Actualizar, Eliminar) en entidades de `Producto` y `Categoria`.

## Descripción

La API permite a los usuarios gestionar productos y asignarlos a categorías. Se ha construido utilizando Java y el framework Spring Boot, y se gestiona con Maven.

## Tecnologías  y Dependencias Utilizadas

- **Java**: Lenguaje de programación principal.
- **Spring Boot**: Framework para crear aplicaciones Java autónomas y basadas en microservicios.
- **Maven**: Herramienta para la gestión y construcción de proyectos.
- **MYSQL**: Como tipo de bases de datos relacional.
- **Lombok**: Librería para reducir el código repetitivo en Java.
- **Valid**: Librería para validar datos.
- **Spring Data JPA**: Librería para interactuar con bases de datos relacionales.

## Configuración de la Base de Datos

Para que la aplicación funcione correctamente, es necesario configurar la conexión a tu propia base de datos. Esto se hace en el fichero `src/main/resources/application.properties`.

A continuación, se muestra un ejemplo de cómo configurar una base de datos PostgreSQL:

```properties
spring.datasource.url=jdbc:mysql://localhost:5432/tudatabase
spring.datasource.username=tu-usuario
spring.datasource.password=tu-contraseña
spring.jpa.hibernate.ddl-auto=update
```

Asegúrate de reemplazar `tudatabase`, `tu-usuario` y `tu-contraseña` con los valores correspondientes a tu configuración de base de datos.


### Ejecución de la Aplicación

Para iniciar la aplicación, ejecuta el siguiente comando en la terminal:

```sh
./mvnw spring-boot:run
```

La API estará disponible en `http://localhost:8080/api`.

## Endpoints de la API

A continuación, se describen los endpoints disponibles, que también puedes encontrar en el fichero `src/main/requests.http`.

### Categorías

- `POST /api/categorias`: Crea una nueva categoría.
- `GET /api/categorias`: Obtiene todas las categorías.
- `GET /api/categorias/{id}`: Obtiene una categoría por su ID.
- `PUT /api/categorias/{id}`: Actualiza una categoría existente.
- `DELETE /api/categorias/{id}`: Elimina una categoría.

### Productos

- `POST /api/productos`: Crea un nuevo producto.
- `GET /api/productos`: Obtiene todos los productos.
- `GET /api/productos/{id}`: Obtiene un producto por su ID.
- `PUT /api/productos/{id}`: Actualiza un producto existente.
- `DELETE /api/productos/{id}`: Elimina un producto.

## Estructura del Proyecto

- `src/main/java`: Contiene el código fuente de la aplicación.
  - `controller`: Controladores REST que manejan las peticiones HTTP.
  - `entity`: Clases de entidad que se mapean a las tablas de la base de datos.
  - `repository`: Repositorios de Spring Data JPA para la interacción con la base de datos.
  - `service`: Lógica de negocio de la aplicación.
- `src/main/resources`: Contiene los ficheros de configuración, como `application.properties`.
- `pom.xml`: Fichero de configuración del proyecto Maven.

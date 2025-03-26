# CRUD de Personas

Este proyecto es una aplicación web que implementa un CRUD (Crear, Leer, Actualizar y Eliminar) de personas utilizando tecnologías modernas como JPA con Hibernate, Thymeleaf para la vista, Tailwind CSS para el diseño, MySQL como base de datos y Maven (pom.xml) para la gestión de dependencias.

## Tecnologías utilizadas

- **Spring Boot**: Framework principal del backend.
- **JPA con Hibernate**: Manejo de la persistencia de datos.
- **Thymeleaf**: Motor de plantillas para la capa de presentación.
- **Tailwind CSS**: Estilos y diseño de la interfaz.
- **MySQL**: Base de datos para almacenar la información de las personas.
- **Maven (pom.xml)**: Gestión de dependencias y construcción del proyecto.

## Instalación y configuración

1. **Clonar el repositorio**
   ```sh
   git clone https://github.com/tu_usuario/tu_proyecto.git
   cd tu_proyecto
   ```

2. **Configurar la base de datos**
   - Asegúrate de tener MySQL instalado y ejecutándose.
   - Crea una base de datos con el nombre `crud_personas`.
   - Configura las credenciales en `application.properties` o `application.yml`:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/crud_personas
     spring.datasource.username=tu_usuario
     spring.datasource.password=tu_contraseña
     spring.jpa.hibernate.ddl-auto=update
     spring.jpa.show-sql=true
     ```

3. **Compilar y ejecutar el proyecto**
   ```sh
   mvn clean install
   mvn spring-boot:run
   ```

4. **Acceder a la aplicación**
   - Abre tu navegador y ve a: `http://localhost:8080`

## Funcionalidades

- **Listar personas**: Visualizar todas las personas registradas en la base de datos.
- **Agregar nueva persona**: Formulario para ingresar nuevos registros.
- **Editar persona**: Modificar la información de una persona existente.
- **Eliminar persona**: Opción para eliminar un registro.

## Estructura del Proyecto

```
crud-personas/
│── src/
│   ├── main/
│   │   ├── java/com/tu_proyecto/
│   │   │   ├── controller/ (Controladores de la aplicación)
│   │   │   ├── model/ (Entidades JPA)
│   │   │   ├── repository/ (Interfaces de acceso a datos)
│   │   │   ├── service/ (Lógica de negocio)
│   │   ├── resources/
│   │   │   ├── templates/ (Vistas Thymeleaf)
│   │   │   ├── static/css/ (Estilos con Tailwind)
│── pom.xml (Dependencias del proyecto)
```

## Dependencias principales en `pom.xml`

```xml
<dependencies>
    <!-- Spring Boot y Web -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <!-- JPA y Hibernate -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>

    <!-- MySQL Driver -->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
    </dependency>

    <!-- Thymeleaf -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-thymeleaf</artifactId>
    </dependency>
</dependencies>
```
## Imgenes de muestra
![Pantalla Principal](https://github.com/LuisErnesto1234/TodoListSpring/blob/Main//principal.png)


## Contribución
Si deseas contribuir a este proyecto, por favor haz un fork y envía un pull request con mejoras o nuevas funcionalidades.

## Licencia
Este proyecto se encuentra bajo la licencia MIT.

---
¡Gracias por usar este CRUD de personas! 🚀


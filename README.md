# Online Store - Spring Boot Application

## 📌 Descripción
Este proyecto es una aplicación web de una tienda en línea desarrollada con **Spring Boot**, utilizando **Thymeleaf** para la vista y **Bootstrap 5** para la interfaz de usuario. Permite gestionar productos con funcionalidades CRUD (Crear, Leer, Actualizar y Eliminar).

## 🚀 Tecnologías Utilizadas
- **Java 17** con **Spring Boot 3.x**
- **Maven** para la gestión de dependencias
- **Thymeleaf** como motor de plantillas
- **Bootstrap 5** para el diseño responsivo
- **Jakarta Validation** para validación de formularios
- **Spring MVC** para la gestión de rutas
- **Spring Data JPA** (opcional, si se agrega persistencia en base de datos)

## 📂 Estructura del Proyecto
```
OnlineStore/
│── src/main/java/com/ejemplo/demo/
│   ├── controllers/         # Controladores Spring MVC
│   ├── forms/               # Clases de formulario y validación
│   ├── DemoApplication.java # Clase principal de Spring Boot
│
│── src/main/resources/
│   ├── static/css/          # Archivos de estilos
│   │   ├── app.css
│   ├── templates/           # Vistas Thymeleaf
│   │   ├── fragments/       # Componentes reutilizables (header, footer)
│   │   │   ├── header.html
│   │   │   ├── footer.html
│   │   ├── home/            # Vistas principales
│   │   │   ├── index.html
│   │   │   ├── about.html
│   │   │   ├── contact.html
│   │   ├── product/         # Vistas de productos
│   │   │   ├── index.html
│   │   │   ├── show.html
│   │   │   ├── create.html
│── pom.xml                   # Archivo de configuración de Maven
│── README.md                 # Este archivo de documentación
```

---

## 🛠️ Instalación y Configuración

### 1️⃣ Clonar el Repositorio
```bash
git clone https://github.com/KevinQzG/OnlineStore.git
cd OnlineStore
```

### 2️⃣ Configurar el Proyecto con Spring Initializr (opcional)
Si deseas crear un nuevo proyecto desde cero, puedes usar [Spring Initializr](https://start.spring.io/) con las siguientes configuraciones:
- **Project:** Maven
- **Language:** Java
- **Spring Boot Version:** 3.2.x
- **Dependencias:** Spring Web, Thymeleaf, Validation, Spring Data JPA (si se usa base de datos)

### 3️⃣ Compilar y Ejecutar el Proyecto
```bash
./mvnw spring-boot:run
```
_En Windows usa:_
```bash
mvnw.cmd spring-boot:run
```

### 4️⃣ Acceder a la Aplicación
- **Inicio:** [http://localhost:8080](http://localhost:8080)
- **Productos:** [http://localhost:8080/products](http://localhost:8080/products)
- **Crear Producto:** [http://localhost:8080/products/create](http://localhost:8080/products/create)

---

## 🏗️ Funcionalidades
**Página principal** con introducción a la tienda.  
**Página "Sobre Nosotros"** con información de la empresa.  
**Gestión de productos:**
   - Listado de productos con imágenes.
   - Vista detallada de cada producto.
   - Creación de productos con validaciones.
---
## 📜 Validaciones de Formularios
Se usa `Jakarta Validation` para validar que el nombre y precio sean correctos.
```java
@NotEmpty(message = "El nombre del producto es obligatorio")
private String name;

@NotNull(message = "El precio es obligatorio")
@Positive(message = "El precio debe ser mayor a 0")
private Double price;
```

---

## 🛑 Solución de Errores Comunes
1️⃣ **Error 500 - Internal Server Error**
   - Asegúrate de que el formulario envía datos correctos y cumple con las validaciones.

2️⃣ **Error 405 - Method Not Allowed**
   - Verifica que la petición HTTP (`POST`, `GET`) es correcta en el formulario.

3️⃣ **Puerto en uso (Error al iniciar)**
   ```bash
   lsof -i :8080
   kill -9 <PID>
   ```

---

## 🏆 Contribuciones
¡Las contribuciones son bienvenidas! Para mejorar el proyecto:
1. Realiza un **fork** del repositorio.
2. Crea una nueva **rama** (`git checkout -b feature-nueva`).
3. Realiza tus cambios y haz **commit** (`git commit -m 'Descripción'`).
4. Sube los cambios (`git push origin feature-nueva`).
5. Abre un **Pull Request** y explica qué mejoras hiciste.

---

## 📄 Licencia
Este proyecto está bajo la licencia **MIT**. Puedes usarlo y modificarlo libremente.

---
📌 **Desarrollado con ❤️ por [Kevin Quiroz](https://github.com/KevinQzG)**

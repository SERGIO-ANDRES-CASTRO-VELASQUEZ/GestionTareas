# ✅ Gestión de Tareas  

Este repositorio implementa un sistema de gestión de tareas que permite:  
📝 Crear | 📋 Listar | 🔍 Buscar por ID | ✏️ Actualizar | 🗑 Eliminar | 🎯 Filtrar por estado | ⏰ Filtrar por fecha de vencimiento  

---

## 🎯 Objetivo  
Aplicar conceptos de **Programación Orientada a Objetos en Java**, desarrollando un **CRUD básico con Spring Boot** bajo el patrón **MVC**, y gestionando el proyecto en **GitHub** de manera colaborativa.  

---

## 👥 Integrantes y Cargos  

- 👨‍💻 **Sergio Andres Castro Velasquez** → Entidad, Repositorio y Excepciones  
- 🛠 **Juan Carlos Restrepo Penagos** → Capa Servicios  
- 🎮 **Cristian Steven Casanova Anacona** → Controller  
- 📖 **Santiago Alarcón Gutiérrez** → README  

---

## 🛠 Tecnologías Utilizadas  

- ☕ **Java 17+**  
- 🚀 **Spring Boot 3.5.5**  
- 🗄 **Spring Data JPA**  
- 🌐 **Spring Web**  
- 🐘 **PostgreSQL** (para desarrollo local)  
- 📦 **Maven** (gestión de dependencias)  

---

## 📋 Requisitos Previos  

Antes de ejecutar la aplicación necesitas:  
- ☕ **Java JDK 17** o superior  
- ⚙️ **Maven 3.3.3**  
- 🐙 **Git** (para clonar el repositorio)  

---

## 🔧 Instalación y Configuración  

### 1️⃣ Clonar el repositorio  
```bash
git clone https://github.com/SERGIO-ANDRES-CASTRO-VELASQUEZ/GestionTareas.git
cd GestionTareas
```

### 2️⃣ Verificar instalación de Java y Maven  
```bash
java -version
mvn -version
```

### 3️⃣ Compilar el proyecto  
```bash
mvn clean compile
```

---

## 🚀 Despliegue Local  

### ▶️ Opción 1: Usando Maven  
```bash
mvn spring-boot:run
```

### 💾 Opción 2: Ejecutando el JAR  
```bash
# Generar el JAR
mvn clean package

# Ejecutar la aplicación
java -jar target/GestionTareasAplicacion-1.0.0.jar
```

### 🖥 Opción 3: Desde el IDE  
Ejecutar la clase principal `GestionDeTareas.java` desde tu IDE favorito.  

---

## 🏗 Estructura del Proyecto  

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── trabajo/
│   │           └── gestiontareas/
│   │               ├── controller/
│   │               │   └── TareaController.java
│   │               ├── entity/
│   │               │   ├── enums/
│   │               │   │   ├── Estado.java
│   │               │   │   └── Prioridad.java
│   │               │   └── Tarea.java
│   │               ├── exception/
│   │               │   ├── EntityNotFoundException.java
│   │               │   ├── ExceptionResponse.java
│   │               │   └── ResponseExceptionHandler.java
│   │               ├── repository/
│   │               │   └── TareaRepo.java
│   │               └── service/
│   │                   └── TareaService.java
│   └── resources/
│       ├── static/
│       ├── templates/
│       └── application.properties
└── test/
```

---

## 🌐 Acceso a la Aplicación  

Una vez iniciada, la aplicación estará disponible en:  
- 🌍 **URL base** → `http://localhost:8099/tareas`  

🔑 **Configuración PostgreSQL**  
- URL → `jdbc:postgresql://localhost:5432/tareas`  
- Usuario → `postgresql`  
- Contraseña → `tu_contraseña`  

---

## 📌 Funcionalidades  

- ➕ **Crear tarea** → `POST /tareas`  
- 📋 **Listar tareas** → `GET /tareas`  
- 🔎 **Obtener tarea por ID** → `GET /tareas/{id}`  
- ✏️ **Actualizar tarea** → `PUT /tareas/{id}`  
- 🗑 **Eliminar tarea** → `DELETE /tareas/{id}`  
- 🎯 **Filtrar por estado** → `GET /tareas?estado=...`  
- ⏳ **Filtrar por fecha de vencimiento** → `GET /tareas?antesDe=...`  

---

## 🐛 Solución de Problemas  

### 🔹 Puerto ocupado  
Si el puerto `8099` está en uso, cambia el puerto en `application.properties`:  
```properties
server.port=8081
```

### 🔹 Error de versión de Java  
Asegúrate de usar Java 17+:  
```bash
java -version
```

### 🔹 Error de dependencias Maven  
Reinstala las dependencias:  
```bash
mvn clean install -U
```

---

⭐ **¡No olvides darle una estrella al repositorio si te fue útil!** 🌟  

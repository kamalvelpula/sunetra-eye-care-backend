# Sunetra Eye Care – Backend

A RESTful backend application for the Sunetra Eye Care website, developed using Java 21 and Spring Boot. It manages appointments, contact messages, eye care services, and administrator authentication.

## ✨ Features

- RESTful API development
- Appointment booking and management
- Contact message management
- Eye care services management
- Admin login and authentication
- JWT-based authentication
- Role-based access control
- MySQL database integration
- Spring Data JPA and Hibernate
- Password encryption using BCrypt
- CRUD operations

## 🛠️ Technologies Used

- Java 21
- Spring Boot
- Spring Security
- Spring Data JPA
- Hibernate
- MySQL
- JWT Authentication
- Maven
- REST APIs
- BCrypt Password Encoder

## 🏗️ Architecture

The application follows a layered architecture:

- **Controller Layer:** Handles incoming REST API requests.
- **Service Layer:** Contains business logic.
- **Repository Layer:** Handles database operations.
- **Entity Layer:** Defines database entities.
- **Security Layer:** Manages authentication and authorization.

## 📌 Main API Modules

| Module | Functionality |
|---|---|
| Appointments | Book and manage appointments |
| Contact | Submit and manage contact messages |
| Services | Manage eye care services |
| Admin | Secure administrator authentication |

## ⚙️ Prerequisites

- Java 21
- Maven
- MySQL Server
- Eclipse IDE or IntelliJ IDEA
- Postman

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/kamalvelpula/sunetra-eye-care-backend.git
```

### 2. Navigate to the Project

```bash
cd sunetra-eye-care-backend
```

### 3. Create MySQL Database

```sql
CREATE DATABASE yogeshwar_eye_care;
```

### 4. Configure Environment Variables

Set the following environment variables before running the application:

```text
DB_PASSWORD=your_mysql_password
JWT_SECRET=your_secure_jwt_secret
```

For production, configure:

```text
DB_URL=your_mysql_database_url
DB_USERNAME=your_database_username
DB_PASSWORD=your_database_password
JWT_SECRET=your_secure_jwt_secret
```

### 5. Build the Application

```bash
mvn clean package -DskipTests
```

### 6. Run the Application

```bash
mvn spring-boot:run
```

The backend application runs on:

```text
http://localhost:8080
```

## 🔗 Frontend Integration

This backend is integrated with the React frontend.

**Frontend Repository:**  
https://github.com/kamalvelpula/sunetra-eye-care-frontend

## 🗄️ Database

MySQL is used to store application data, including:

- Appointment details
- Contact messages
- Eye care services
- Administrator details

## 👨‍💻 Developer

**Kamalnath Velpula**

- GitHub: https://github.com/kamalvelpula
- LinkedIn: https://linkedin.com/in/kamalnath-velpula-04bb4724b

---

*Developed using Java, Spring Boot, Spring Security, and MySQL.*
# Student Management System

This repository contains two implementations of a Student Management System:
1. **Spring Boot REST API** - Modern web API with full CRUD operations
2. **Java Console Application** - Classic console-based system

## 🚀 Spring Boot REST API

A complete RESTful API built with Spring Boot for managing student records.

### Features
- ✅ **Full CRUD Operations** - Create, Read, Update, Delete students
- ✅ **REST Endpoints** - Standard HTTP methods (GET, POST, PUT, DELETE)
- ✅ **JSON Support** - Request/response in JSON format
- ✅ **In-Memory Storage** - ArrayList-based data persistence
- ✅ **Error Handling** - Proper validation and error responses

### API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/students/hello` | Test endpoint |
| GET | `/api/students` | Get all students |
| GET | `/api/students/{id}` | Get student by ID |
| POST | `/api/students` | Create new student |
| PUT | `/api/students/{id}` | Update student |
| DELETE | `/api/students/{id}` | Delete student |

### Technologies Used
- **Java 17**
- **Spring Boot 3.4.10**
- **Maven**
- **REST APIs**
- **Tomcat Embedded Server**

### How to Run
```bash
# Clone the repository
git clone https://github.com/rohit47dhurwe/student-management-system.git

# Navigate to Spring Boot project
cd student-api

# Run the application
mvnw.cmd spring-boot:run

# Application will start on http://localhost:8080

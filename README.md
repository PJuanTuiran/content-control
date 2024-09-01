

# Student Management System API

This project implements a RESTful API for a Student Management System using Spring Boot and Swagger. The API allows management of students, classes, and lessons.

## API Endpoints

### Students

- `GET /api/v1/students`: List all students (paginated)
- `GET /api/v1/students/{id}`: Get a specific student
- `POST /api/v1/students`: Add a new student
- `PATCH /api/v1/students/{id}/disable`: Disable a student
- `PUT /api/v1/students`: Update a student

### Classes

- `GET /api/v1/class`: List all classes (paginated)
- `GET /api/v1/class/{id}`: Get a specific class
- `POST /api/v1/class`: Add a new class

### Lessons

- `POST /api/v1/lessons`: Save a new lesson
- `PATCH /api/v1/lessons/{id}/disable`: Disable a lesson
- `GET /api/v1/lessons/{id}/multimedia`: Get a specific lesson with multimedia content

## User Flow

1. List or search for students
2. View student details
3. Add, update, or disable students
4. List or search for classes
5. View class details
6. Add new classes
7. Create lessons with multimedia content
8. Disable lessons if needed
9. Retrieve lesson information with associated multimedia content

## Features

- Pagination for listing students and classes
- Search functionality by name or description
- Data validation (e.g., email validation for students)
- Automatic timestamp for student creation
- Handling of multimedia content for lessons

## Technologies

- Spring Boot
- Swagger for API documentation
- RESTful API design

## Getting Started

1. Clone the repository
2. Configure your database settings in `application.properties`
3. Run the Spring Boot application
4. Access the Swagger UI for API documentation and testing

## Notes

- Ensure proper error handling and validation as per the acceptance criteria
- Implement security measures for API access
- Test thoroughly, especially the multimedia handling for lessons
## Links 
-Context
https://riwiio-my.sharepoint.com/:b:/r/personal/antony_martinez_riwi_io/Documents/Advanced%20route/Spring%20Boot/Workshops/Spring-Boot%20Week%203/Contexto.pdf?csf=1&web=1&e=gzv4bY


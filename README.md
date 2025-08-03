# Scheduling System API

This is the back-end for a scheduling system, developed in Java with the Spring Boot framework. The API allows performing basic scheduling operations, managing users and their respective appointments.

## Features

* RESTful API for scheduling management.
* Endpoint authentication and authorization with Spring Security.
* API documentation automatically generated and accessible via Swagger UI.
* Data persistence with Spring Data JPA.
* Development profile (`dev`) to facilitate local environment setup.

## Tech Stack

* **Java 17**: The Java language version used.
* **Spring Boot 3**: The main framework for building the application.
* **Spring Web**: To create RESTful APIs.
* **Spring Data JPA**: For the data persistence layer.
* **Spring Security**: For the security and authorization layer.
* **MariaDB**: The relational database used in the development environment.
* **Maven**: The project's dependency management and build tool.
* **Springdoc OpenAPI (Swagger)**: For interactive API documentation.
* **Lombok**: To reduce boilerplate code (getters, setters, constructors, etc.).

## Prerequisites

Before you start, you will need to have the following installed on your machine:
* [Java (JDK) 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) or higher.
* [Maven 3.8](https://maven.apache.org/download.cgi) or higher.
* A database client, such as [DBeaver](https://dbeaver.io/) or [MySQL Workbench](https://www.mysql.com/products/workbench/).
* A running instance of [MariaDB](https://mariadb.org/download/) or [MySQL](https://dev.mysql.com/downloads/mysql/).

## Environment Setup

### 1. Clone the Repository

```bash
git clone https://github.com/FeCocco/gestao-clinica-api.git
cd sistema-agendamento
```

### 2. Set Up the Database

The application is configured to connect to a MariaDB/MySQL database. Create a database and a user with the following credentials (or change the `src/main/resources/application-dev.properties` file to match your setup).

Run the following commands in your database client:

```sql
CREATE DATABASE SistemaAgendamento;
CREATE USER 'UserAgendamento'@'localhost' IDENTIFIED BY '[SET_YOUR_PASSWORD]';
GRANT ALL PRIVILEGES ON SistemaAgendamento.* TO 'UserAgendamento'@'localhost';
FLUSH PRIVILEGES;
```

### 3. Review the Application Properties

The `src/main/resources/application-dev.properties` file contains the settings for the development environment:

```properties
# Database Settings
spring.datasource.url=jdbc:mariadb://localhost:3306/SistemaAgendamento
spring.datasource.username=UserAgendamento
spring.datasource.password=[SET_YOUR_PASSWORD]

# Hibernate Settings
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# Swagger Settings
springdoc.swagger-ui.path=/swagger-ui.html
```

## How to Run the Project

With the environment set up, you can start the application using the Maven Wrapper:

```bash
# Cleans the project and installs dependencies
./mvnw clean install

# Starts the application
./mvnw spring-boot:run
```

The application will be running at `http://localhost:8080`.

## 📖 API Documentation (Swagger)

With the application running, the interactive API documentation will be available in your browser. Access the following URL:

👉 **http://localhost:8080/swagger-ui.html**

There, you can see all available endpoints, their parameters, and responses, as well as test them directly from the interface.

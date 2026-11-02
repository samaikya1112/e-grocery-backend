# 🛒 E-Grocery Backend

A Spring Boot-based backend application for an online grocery shopping platform. This project provides REST APIs to support grocery shopping operations, backed by PostgreSQL.

## 📌 Project Overview

The E-Grocery Backend is designed to provide the server-side functionality for an online grocery application. It follows a layered backend architecture and uses Spring Boot, Spring Data JPA, and PostgreSQL for application development and data persistence.

## 🛠️ Tech Stack

- **Backend:** Java, Spring Boot
- **Database:** PostgreSQL
- **ORM:** Hibernate, Spring Data JPA
- **Build Tool:** Maven
- **Testing:** JUnit 5, Mockito
- **Security:** Spring Security, OAuth2 Resource Server, JWT
- **Version Control:** Git, GitHub

## ✨ Key Highlights

- RESTful backend application built using Spring Boot.
- PostgreSQL database integration.
- Database operations using Spring Data JPA and Hibernate.
- JWT-based authentication and authorization configuration.
- Unit testing using JUnit 5 and Mockito.
- Externalized database credentials using environment variables.
- Maven-based build and dependency management.

## 📂 Project Structure

```text
e-grocery-backend/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/onlinegrocery/
│   │   └── resources/
│   │       ├── application-example.properties
│   │       └── application.yml
│   └── test/
│       └── java/
│           └── com/onlinegrocery/
├── .gitignore
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

## ⚙️ Prerequisites

Make sure you have the following installed:

- Java (version compatible with the project configuration)
- PostgreSQL
- Maven (or use the included Maven Wrapper)
- Git

## 🚀 Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/samaikya1112/e-grocery-backend.git
cd e-grocery-backend
```

### 2. Create the PostgreSQL database

Open PostgreSQL and execute:

```sql
CREATE DATABASE ogs;
```

### 3. Configure database credentials

The application uses an environment variable to keep database credentials outside the source code.

Create a local file named:

`src/main/resources/application.properties`

Add the following configuration:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/ogs
spring.datasource.username=postgres
spring.datasource.password=${DB_PASSWORD}

spring.datasource.hikari.auto-commit=false
spring.datasource.autoCommit=false

spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update

spring.mvc.pathmatch.matching-strategy=ant-path-matcher
spring.main.allow-circular-references=true
```

**Spring Tool Suite (STS):**

1. Right-click the project.
2. Select Run As → Run Configurations.
3. Select your Spring Boot application.
4. Open the Environment tab.
5. Add the variable:
   - Name: `DB_PASSWORD`
   - Value: Your local PostgreSQL password.
6. Click Apply → Run.
7.  Never commit your actual password or local `application.properties` file to GitHub.

### 4. Build the project

**Windows:**

```cmd
mvnw.cmd clean install
```

Or, if Maven is installed:

```bash
mvn clean install
```

### 5. Run the application

**Windows:**

```cmd
mvnw.cmd spring-boot:run
```

Or:

```bash
mvn spring-boot:run
```

The application starts on:

```text
http://localhost:8080
```

## 🧪 Running Tests

Run the test suite using:

```bash
mvn test
```

Or on Windows:

```cmd
mvnw.cmd test
```

The project uses JUnit 5 and Mockito for unit testing.

## 🔐 Security & Configuration

- Database credentials are managed through environment variables.
- Local database configuration is excluded using `.gitignore`.
- JWT-based security configuration is maintained separately.
- Never commit passwords, tokens, or other sensitive configuration values.

## 👩‍💻 Author

**Samaikya**

GitHub: [@samaikya1112](https://github.com/samaikya1112)

---

⭐ If you find this project interesting, feel free to explore the repository!

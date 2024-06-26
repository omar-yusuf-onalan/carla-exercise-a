# Carla Exercise A Application

## Overview

The **Carla Exercise A Application** is a Spring Boot application that manages compensation data. The application provides RESTful APIs to retrieve compensation details based on various parameters and criteria.

## Requirements

- Java 17 or higher
- Maven 3.6 or higher
- A database (e.g., PostgreSQL, MySQL) configured for use with Spring Data JPA and JDBC

## Installation

1. Clone the repository:
   ```bash
    git clone https://github.com/omar-yusuf-onalan/carla_exercise_a.git
    cd carla_exercise_a
   ```
   
2. Configure your database in `application.properties`:

    ```properties
    spring.datasource.url=jdbc:your_database_url
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    spring.jpa.hibernate.ddl-auto=update
    ```

3. Build the project using Maven:

    ```bash
    mvn clean install
    ```

4. Run the application:
    ```bash
    mvn spring-boot:run
    ```

## Usage

After starting the application, you can access the API endpoints via http://localhost:8080/compensation. Use tools like curl, Postman, or a web browser to interact with the API.

## Project Structure

```plaintext
    src/
 ├── main/
 │    ├── java/
 │    │    └── com/
 │    │         └── omaryusufonalan/
 │    │              └── carla_exercise_a/
 │    │                   ├── config/          # Configuration files
 │    │                   │    └── JacksonConfig.java
 │    │                   ├── controller/      # REST Controllers
 │    │                   │    └── CompensationController.java
 │    │                   ├── dto/             # Data Transfer Objects
 │    │                   │    └── response/
 │    │                   │         └── CompensationResponse.java
 │    │                   ├── entity/          # JPA Entities
 │    │                   │    └── Compensation.java
 │    │                   ├── mapper/          # Mapper interfaces and implementations
 │    │                   │    ├── CompensationMapper.java
 │    │                   │    └── CompensationRowMapper.java
 │    │                   ├── repository/      # Spring Data JPA Repositories
 │    │                   │    └── CompensationRepository.java
 │    │                   ├── service/         # Service classes
 │    │                   │    └── CompensationService.java
 │    │                   └── CarlaExerciseAApplication.java # Main application class
 │    └── resources/                         # Resources directory
 │         ├── application.properties        # Application properties
 │         └── data.sql                      # Initial data for database (optional)
 └── test/                                   # Test directory

```

## Configuration

### Jackson

The JacksonConfig class configures the Jackson ObjectMapper to exclude null values during serialization. This ensures that the API responses do not contain fields with null values.

```java
    @Configuration
public class JacksonConfig {

    @Bean
    public ObjectMapper objectMapper() {
        return Jackson2ObjectMapperBuilder.json()
                .serializationInclusion(JsonInclude.Include.NON_NULL)
                .build();
    }
}
```

## Endpoints

Get All Compensations
* URL: /compensation
* Method: GET
* Parameters: Optional query parameters for filtering and sorting.
* Response: List of compensations


### Example Request:

```http
    GET /compensation?industry=Software&sort=annual_salary
```

### Example Response:

```json
    [
  {
    "id": 1,
    "timestamp": "2024-01-01T12:00:00Z",
    "ageRange": "25-30",
    "industry": "Software",
    "jobTitle": "Software Engineer",
    "annualSalary": "100000",
    "currency": "USD",
    "location": "New York",
    "postCollegeExperience": "5 years",
    "additionalContext": "None",
    "otherCurrency": "USD"
  }
]
```

### Get Compensation by ID

* URL: /compensation/{id}
* Method: GET
* Path Variables: id - Compensation ID
* Parameters: Optional fields parameter to specify the fields to retrieve.
* Response: Compensation details

### Example Request:

```http
    GET /compensation/1?fields=id,annual_salary,job_title
```

### Example Response:

```json
{
  "id": 1,
  "jobTitle": "Software Engineer",
  "annualSalary": "100000"
}
```



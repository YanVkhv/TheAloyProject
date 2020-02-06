# The Aloy Project

[Github](https://github.com/YanVkhv)

## Tech stack

- Spring Boot
- H2 in-memory database
- JDK 13
- Swagger
- ...

## Usage

### Running Locally
- `mvn clean install` on the entire project, followed by a `mvn spring-boot:run` inside the war folder.
- Surf to `http://localhost:9000/` to verify the backend is running.
- `Ctrl+C` to terminate from commandline.

## OpenAPI / Swagger Documentation
- Read the generated documentation of the Web API on `http://localhost:9000/swagger-ui.html`

## H2 Database
The application will start a H2 in-memory database. 
- As long as the application is running, the data is persisted.
- The moment the application is terminated, the data and database are wiped.

You can access the H2 Database by surfing to:
 - `http://localhost:9000/h2-console`
 
 As the JDBC-url, enter `jdbc:h2:mem:testdb`

## Some example REST Endpoints
TBD

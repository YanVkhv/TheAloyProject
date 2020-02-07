# The Aloy Project   [![Build Status](https://travis-ci.com/YanVkhv/TheAloyProject.svg?branch=master)](https://travis-ci.com/YanVkhv/TheAloyProject)

[Github](https://github.com/YanVkhv/TheAloyProject)

## Tech stack

- Spring Boot
- H2 in-memory database
- JDK 13
- [Swagger](http://localhost:9000/swagger-ui.html)
- Docker
- [Heroku](https://the-aloy-project.herokuapp.com/)
- ...

## Usage

### Running Locally
- `mvn clean install` on the entire project, followed by a `mvn spring-boot:run` inside the war folder.
- Surf to `http://localhost:9000/` to verify the backend is running.
- `Ctrl+C` to terminate from commandline.

### Deploying Docker image on Heroku
1. Build an image from the Dockerfile using the following command:  
       `>_ docker build -t com.yanvkhv/the-aloy-project .`  
          (where . stands for the current directory)  
          (where we tag (-t) our image giving it the unique name com.yanvkhv/the-aloy-project (with version 'latest'))  
               https://docs.docker.com/engine/reference/commandline/build/#tag-an-image--t  
2. Run one (or more) docker container(s) from the created image, using command:  
       `>_ docker run -d -p 9500:9000 com.yanvkhv/the-aloy-project`  
          (option -d will run the container in detatched mode, thus you can reuse your terminal)  
               https://docs.docker.com/engine/reference/run/#detached--d  
          (option -p 9500:9000 will map internal port 9000 on which TheAloyProject runs in the container to the outside docker host port 9500)  
               https://docs.docker.com/config/containers/container-networking/  
3. Navigate in your browser to http://localhost:9500/swagger-ui.html to validate that the container is correctly running your application  
4. (As of here, optional) Create a new app on Heroku  
5. Install the Heroku CLI  
6. Run the following commands in order:  
       `>_ heroku login`  
       `>_ heroku container:login`  
       `>_ heroku container:push web -a the-aloy-project`  
          (where -a the-aloy-project specifies the name of the app on heroku)  
          (where web is the process-type)  
       `>_ heroku container:release web -a the-aloy-project`  
       Runs on: https://the-aloy-project.herokuapp.com/  

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

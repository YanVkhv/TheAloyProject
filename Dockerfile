# Start with a base image containing Java runtime
FROM openjdk:11-jre-slim

# The EXPOSE instruction informs Docker that the container listens on the specified network ports at runtime.
# The EXPOSE instruction does not actually publish the port. It functions as a type of documentation between
# the person who builds the image and the person who runs the container, about which ports are intended to be published.
EXPOSE 9000

# Store the application's jar file in a temporary argument
ARG JAR_FILE=war/target/war-1.2.0-SNAPSHOT.jar

# Copy the application's jar (using the temporary argument) to the docker container (in the root)
COPY ${JAR_FILE} TheAloyProject.jar

# Run the jar file (ENTRYPOINT to deploy Docker image locally, CMD to deploy on Heroku
# ENTRYPOINT ["java","-jar","/TheAloyProject.jar"]
CMD ["sh", "-c", "java -Dserver.port=$PORT -Xmx300m -Xss512k -XX:CICompilerCount=2 -Dfile.encoding=UTF-8 -jar /TheAloyProject.jar"]

# Read this article on R14 and R10 Errors on Heroku: https://blog.codecentric.de/en/2019/08/spring-boot-heroku-docker-jdk11/

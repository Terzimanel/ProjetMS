# Utilisez une image de base Java
FROM openjdk:17-jdk-slim

# Ajoutez un label maintainer
LABEL maintainer="manel.terzi@esprit.tn"

# Ajoutez l'application JAR à l'image Docker
ARG JAR_FILE=target/ConfigServer-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

# Expose le port de l'application
EXPOSE 9093

# Commande pour exécuter l'application
ENTRYPOINT ["java", "-jar", "/app.jar"]

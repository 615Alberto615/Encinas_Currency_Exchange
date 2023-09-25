# Fase de construcción
FROM eclipse-temurin:17-jdk as builder
WORKDIR application
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} application.jar
RUN java -Djarmode=layertools -jar application.jar extract

# Fase de ejecución
FROM eclipse-temurin:17-jre
WORKDIR application

# Crear un usuario no root para ejecutar la aplicación
RUN addgroup --system spring && adduser --system spring --ingroup spring
USER spring:spring

# Copiar las capas del JAR
COPY --from=builder application/dependencies/ ./
COPY --from=builder application/spring-boot-loader/ ./
COPY --from=builder application/snapshot-dependencies/ ./
COPY --from=builder application/application/ ./

# Variables de entorno y configuración
ENV DATABASE_URL "jdbc:postgresql://192.168.1.206:5432/Exchange"
EXPOSE 8083
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]
#docker run -p 8083:8083 myorg/myapp
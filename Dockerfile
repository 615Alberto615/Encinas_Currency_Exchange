FROM eclipse-temurin:17-jdk
COPY target/*.jar app.jar
ENV DATABASE_URL "jdbc:postgresql://localhost:5432/Exchange"
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]


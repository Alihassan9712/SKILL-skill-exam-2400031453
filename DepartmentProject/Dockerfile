FROM eclipse-temurin:21-jdk AS builder

WORKDIR /app

COPY mvnw .
COPY .mvn/ .mvn
COPY pom.xml ./
COPY src ./src

RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:21-jdk

WORKDIR /app
COPY --from=builder /app/target/DepartmentProject-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 2007

ENTRYPOINT ["java", "-jar", "app.jar"]

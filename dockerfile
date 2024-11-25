# Usa una imagen base con Maven y Java
FROM maven:3.9.5-eclipse-temurin-21-alpine AS builder

# Establece el directorio de trabajo
WORKDIR /app

# Copia el archivo de configuración de Maven y el código fuente de la aplicación
COPY pom.xml ./
COPY src src

# Ejecuta el comando de construcción
RUN mvn clean package -DskipTests

# Usa Temurin JRE 21
FROM eclipse-temurin:21-jre-alpine

# Establece una variable de entorno para el puerto
ENV PORT=8080
ENV JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=85.0"

# Crea un usuario y grupo no root para mayor seguridad
RUN addgroup -S spring && adduser -S spring -G spring

# Crea un directorio de trabajo
WORKDIR /app

# Copia el archivo JAR generado desde la etapa de construcción
COPY --from=builder /app/target/*.jar /app/app.jar

# Expone el puerto especificado por la variable de entorno
EXPOSE $PORT

# Cambia al usuario no root
USER spring:spring

# Ejecuta la aplicación Java
CMD ["sh", "-c", "java $JAVA_OPTS -jar /app/app.jar"]
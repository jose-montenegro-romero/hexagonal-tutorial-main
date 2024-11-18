## Repositorio didáctico

Este es un repositorio meramente didáctico, para mostrar la diferencia entre la arquitectura hexagonal y 
la arquitectura en capas.

Básicamente consiste en:

- Carpeta `layered`: Implementación de una arquitectura por capas clásica de Spring Boot. Endpoint expuesto tipo `/layer/products/:id`
- Carpeta `hexagonal`: Implementación de una arquitectura hexagonal. Endpoint expuesto tipo `/hexagonal/products/:id`


Cada una funciona como endpoint y arquitectura independientes. Se han englobado en el mismo proyecto para
facilitar su comparación, pero cualquiera de las dos se podría eliminar y el proyecto aún funcionaría.

## Tests

En la carpeta de test se incluye una batería de tests unitarios y un test de aceptación.

# Command build with maven
mvn clean package -DskipTests
mvn clean package

# Docker commands
docker build -t hexagonal-tutorial:latest .
docker run -p 8080:8080 hexagonal-tutorial:latest






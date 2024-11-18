package com.jaime.hexagonaltutorial.acceptance;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.context.request.WebRequest;

import java.util.NoSuchElementException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class AcceptanceTests {
    @LocalServerPort
    private Integer port;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
    }

    @Test
    void testEndpoints_happyPaths() {

        given()
                .when()
                .get("/layer/products/camiseta-333")
                .then()
                .log()
                .body()
                .assertThat()
                .body("productId", equalTo("camiseta-333"))
                .body("name", equalTo("Camiseta roja"))
                .body("description", equalTo("Camiseta roja xl"))
                .body("price", equalTo("30.0 €"))
                .statusCode(200);

        given()
                .when()
                .get("/hexagonal/products/camiseta-333")
                .then()
                .log()
                .body()
                .assertThat()
                .body("productId", equalTo("camiseta-333"))
                .body("name", equalTo("Camiseta roja"))
                .body("description", equalTo("Camiseta roja xl"))
                .body("price", equalTo("30.0 €"))
                .statusCode(200);

        given()
                .when()
                .get("/layer/products/vaquero-555")
                .then()
                .log()
                .body()
                .assertThat()
                .body("productId", equalTo("vaquero-555"))
                .body("name", equalTo("Pantalón vaquero"))
                .body("description", equalTo("Denim Vaquero Talla L"))
                .body("price", equalTo("40.0 $"))
                .statusCode(200);

        given()
                .when()
                .get("/hexagonal/products/vaquero-555")
                .then()
                .log()
                .body()
                .assertThat()
                .body("productId", equalTo("vaquero-555"))
                .body("name", equalTo("Pantalón vaquero"))
                .body("description", equalTo("Denim Vaquero Talla L"))
                .body("price", equalTo("40.0 $"))
                .statusCode(200);
    }

    @Test
    void testNotFound404() {

        String idThatDoesNotExist = "1001";

        given()
                .when()
                .get("/hexagonal/products/" + idThatDoesNotExist)
                .then()
                .statusCode(500) // Ver comentario abajo del todo ***
                .body(containsStringIgnoringCase("/hexagonal/products/" + idThatDoesNotExist))
                .extract()
                .response();

        given()
                .when()
                .get("/layer/products/" + idThatDoesNotExist)
                .then()
                .statusCode(500) // Ver comentario abajo del todo ***
                .body(containsStringIgnoringCase("/layer/products/" + idThatDoesNotExist))
                .extract()
                .response();
    }

    // ***: Realmente deberíamos devolver un 404 aquí. Tenemos un 500, porque lanzamos la NoSuchElementException.
    // Dicha excepción debería ser capturada en un GlobalExceptionHandler, para devolver nuestro 404.
    // No lo hemos implementado, por ser solo un ejemplo de hexagonal, pero te dejo un link y abajo comentado
    // como sería un GlobalExceptionHandler en springboot
    // Link: https://dev.to/tienbku/global-exception-handler-in-spring-boot-3mbp

//    @ControllerAdvice
//    public class GlobalExceptionHandler {
//
//        @ExceptionHandler(value = {NoSuchElementException.class})
//        public ResponseEntity<ErrorMessage> resourceNotFoundException(NoSuchElementException ex, WebRequest request) {
//            ErrorMessage message = new ErrorMessage(
//                    status,
//                    date,
//                    ex.getMessage(),
//                    description);
//            return new ResponseEntity<ErrorMessage>(message, HttpStatus.NOT_FOUND);
//        }
//    }

}

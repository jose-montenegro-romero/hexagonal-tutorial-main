package com.jaime.hexagonaltutorial.layered.controller;

import com.jaime.hexagonaltutorial.common.ProductDto;
import com.jaime.hexagonaltutorial.layered.providers.ProductDtoProvider;
import com.jaime.hexagonaltutorial.layered.service.ProductService;
import com.jaime.hexagonaltutorial.layered.service.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ProductControllerTest {

    ProductService productService;

    @BeforeEach
    void setUp() {
        productService = mock(ProductServiceImpl.class);
    }


    @ParameterizedTest
    @ArgumentsSource(ProductDtoProvider.class)
    void testGetProductByProductId(ProductDto expectedProductDto) {
        // Given
        ProductController productController = new ProductController(productService);
        when(productService
                .getProductById(anyString()))
                .thenReturn(expectedProductDto);

        // When
        ProductDto productDto = productController.getProductByProductId(expectedProductDto.getProductId());

        // Then
        verify(productService,times(1)).getProductById(expectedProductDto.getProductId());
        assertEquals(expectedProductDto, productDto);
    }

}

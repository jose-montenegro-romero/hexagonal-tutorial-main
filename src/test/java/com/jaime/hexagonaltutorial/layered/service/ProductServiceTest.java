package com.jaime.hexagonaltutorial.layered.service;

import com.jaime.hexagonaltutorial.common.ProductDto;
import com.jaime.hexagonaltutorial.layered.entity.ProductEntity;
import com.jaime.hexagonaltutorial.layered.providers.ProductDtoProvider;
import com.jaime.hexagonaltutorial.layered.repository.ProductJpaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProductServiceTest {

    ProductJpaRepository productJpaRepository;

    @BeforeEach
    void setup() {
        productJpaRepository = mock(ProductJpaRepository.class);
    }


    @ParameterizedTest
    @ArgumentsSource(ProductDtoProvider.class)
    void test(ProductDto expectedProductDto) {

        // given
        ProductService productService = new ProductServiceImpl(productJpaRepository);

        when(productJpaRepository
                .findByProductId(anyString()))
                .thenReturn(Optional.of(new ProductEntity(
                                                    expectedProductDto.getProductId(),
                                                    expectedProductDto.getName(),
                                                    expectedProductDto.getDescription(),
                                                    extractBigDecimalFromPriceString(expectedProductDto),
                                                    extractCurrencyFromPriceString(expectedProductDto)
                )));

        // when
        ProductDto productDto = productService.getProductById(expectedProductDto.getProductId());

        // then
        assertEquals(expectedProductDto, productDto);
    }

    private static BigDecimal extractBigDecimalFromPriceString(ProductDto expectedProductDto) {
        return new BigDecimal(expectedProductDto.getPrice()
                .split(" ")[0]);
    }

    private static String extractCurrencyFromPriceString(ProductDto expectedProductDto) {
        return expectedProductDto.getPrice()
                .split(" ")[1];
    }
}

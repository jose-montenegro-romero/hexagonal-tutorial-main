package com.jaime.hexagonaltutorial.hexagonal.infrastructure.rest.controller;

import com.jaime.hexagonaltutorial.common.PriceFormatter;
import com.jaime.hexagonaltutorial.hexagonal.infrastructure.database.h2.entity.ProductHexaEntity;
import com.jaime.hexagonaltutorial.hexagonal.infrastructure.database.h2.mapper.ProductEntityMapper;
import com.jaime.hexagonaltutorial.hexagonal.providers.ProductEntityProvider;
import com.jaime.hexagonaltutorial.hexagonal.usecase.IProductInteractor;
import com.jaime.hexagonaltutorial.common.ProductDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class ProductRestController2Test {

    IProductInteractor productInteractor;
    ProductRestController productRestController;

    @BeforeEach
    void setUp() {
        productInteractor = mock(IProductInteractor.class);
        productRestController = new ProductRestController(productInteractor);
    }

    @ParameterizedTest
    @ArgumentsSource(ProductEntityProvider.class)
    void test(ProductHexaEntity mockedProductHexaEntity) {
        // given
        given(productInteractor.findProductById(mockedProductHexaEntity.getProductId())).willReturn(ProductEntityMapper.fromEntityToProduct(mockedProductHexaEntity));

        // when
        ProductDto productDto = productRestController.findProductByProductId(mockedProductHexaEntity.getProductId());

        // then
        verify(productInteractor, times(1)).findProductById(mockedProductHexaEntity.getProductId());
        assertEquals(mockedProductHexaEntity.getProductId(), productDto.getProductId());
        assertEquals(mockedProductHexaEntity.getName(), productDto.getName());
        assertEquals(mockedProductHexaEntity.getDescription(), productDto.getDescription());

        String readablePrice = PriceFormatter.formatPrice(mockedProductHexaEntity.getPrice(), mockedProductHexaEntity.getCurrency());
        assertEquals(readablePrice, productDto.getPrice());

    }

}

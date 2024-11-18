package com.jaime.hexagonaltutorial.layered.mapper;

import com.jaime.hexagonaltutorial.common.PriceFormatter;
import com.jaime.hexagonaltutorial.common.ProductDto;
import com.jaime.hexagonaltutorial.layered.entity.ProductEntity;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductEntity2MapperTest {

    @Test
    void fromEntityToDto() {
        // given
        ProductEntity productEntity = new ProductEntity("1", "Camiseta Blanca", "Description 1", new BigDecimal("10.0"), "€");

        // when
        ProductDto productDto = ProductMapper.fromEntityToDto(productEntity);

        // then
        assertEquals(productEntity.getProductId(), productDto.getProductId());
        assertEquals(productEntity.getName(), productDto.getName());
        assertEquals(productEntity.getDescription(), productDto.getDescription());
        String expectedFormattedPrice = PriceFormatter.formatPrice(productEntity.getPrice(), productEntity.getCurrency());
        assertEquals(expectedFormattedPrice, productDto.getPrice());
    }

}

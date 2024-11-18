package com.jaime.hexagonaltutorial.layered.mapper;

import com.jaime.hexagonaltutorial.common.ProductDto;
import com.jaime.hexagonaltutorial.layered.entity.ProductEntity;

public class ProductMapper {
    public static ProductDto fromEntityToDto(ProductEntity productEntity) {
        return new ProductDto(
                productEntity.getProductId(),
                productEntity.getName(),
                productEntity.getDescription(),
                productEntity.getPrice(),
                productEntity.getCurrency());
    }

}

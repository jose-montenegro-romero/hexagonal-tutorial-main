package com.jaime.hexagonaltutorial.hexagonal.infrastructure.database.h2.mapper;

import com.jaime.hexagonaltutorial.hexagonal.domain.model.Product;
import com.jaime.hexagonaltutorial.hexagonal.infrastructure.database.h2.entity.ProductHexaEntity;

public class ProductEntityMapper {

    public static Product fromEntityToProduct(ProductHexaEntity productHexaEntity) {
        return new Product(productHexaEntity.getProductId(),
                           productHexaEntity.getName(),
                           productHexaEntity.getDescription(),
                           productHexaEntity.getPrice(),
                           productHexaEntity.getCurrency()
        );
    }

}

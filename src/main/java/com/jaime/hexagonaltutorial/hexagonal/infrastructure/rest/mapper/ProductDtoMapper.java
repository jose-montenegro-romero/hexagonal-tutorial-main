package com.jaime.hexagonaltutorial.hexagonal.infrastructure.rest.mapper;

import com.jaime.hexagonaltutorial.common.ProductDto;
import com.jaime.hexagonaltutorial.hexagonal.domain.model.Product;

public class ProductDtoMapper {

    public static ProductDto fromProductToDto(Product product) {
        return new ProductDto(product.getProductId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getCurrency()
        );
    }

}

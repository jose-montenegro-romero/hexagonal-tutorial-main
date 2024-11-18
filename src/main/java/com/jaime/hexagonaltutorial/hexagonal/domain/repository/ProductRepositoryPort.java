package com.jaime.hexagonaltutorial.hexagonal.domain.repository;

import com.jaime.hexagonaltutorial.hexagonal.domain.model.Product;

public interface ProductRepositoryPort {
    Product findProductByProductId(String productId);
}

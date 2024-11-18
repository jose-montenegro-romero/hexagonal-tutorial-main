package com.jaime.hexagonaltutorial.hexagonal.usecase;

import com.jaime.hexagonaltutorial.hexagonal.domain.model.Product;

public interface IProductInteractor {
    Product findProductById(String productId);
}

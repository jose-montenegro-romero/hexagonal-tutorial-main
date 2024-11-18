package com.jaime.hexagonaltutorial.hexagonal.usecase;

import com.jaime.hexagonaltutorial.hexagonal.domain.model.Product;
import com.jaime.hexagonaltutorial.hexagonal.domain.repository.ProductRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ProductInteractorImpl implements IProductInteractor {

    private final ProductRepositoryPort productRepository;

    @Override
    public Product findProductById(String productId) {
        return productRepository.findProductByProductId(productId);
    }
}

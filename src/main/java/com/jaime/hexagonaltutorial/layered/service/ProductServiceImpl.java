package com.jaime.hexagonaltutorial.layered.service;

import com.jaime.hexagonaltutorial.common.ProductDto;
import com.jaime.hexagonaltutorial.layered.entity.ProductEntity;
import com.jaime.hexagonaltutorial.layered.repository.ProductJpaRepository;
import com.jaime.hexagonaltutorial.layered.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductJpaRepository productJpaRepository;

    @Override
    public ProductDto getProductById(String productId) {

        Optional<ProductEntity> optionalProductEntity = productJpaRepository.findByProductId(productId);

        return optionalProductEntity
                .map(ProductMapper::fromEntityToDto)
                .orElseThrow(() -> new NoSuchElementException("Product not found")); //
    }
}

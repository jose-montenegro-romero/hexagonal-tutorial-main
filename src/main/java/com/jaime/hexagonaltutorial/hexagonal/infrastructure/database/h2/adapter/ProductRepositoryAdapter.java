package com.jaime.hexagonaltutorial.hexagonal.infrastructure.database.h2.adapter;


import com.jaime.hexagonaltutorial.hexagonal.domain.model.Product;
import com.jaime.hexagonaltutorial.hexagonal.domain.repository.ProductRepositoryPort;
import com.jaime.hexagonaltutorial.hexagonal.infrastructure.database.h2.mapper.ProductEntityMapper;
import com.jaime.hexagonaltutorial.hexagonal.infrastructure.database.h2.repository.ProductJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Component
public class ProductRepositoryAdapter implements ProductRepositoryPort {

    private final ProductJpaRepository productJpaRepository;

    @Override
    public Product findProductByProductId(String productId) {
        return productJpaRepository.findByProductId(productId)  // devuelve un Optional<ProductHexaEntity>
                .map(ProductEntityMapper::fromEntityToProduct)  // usamos el map de optional para convertir nuestro ProductHexaEntity a nuestro Product (modelo)
                .orElseThrow(() -> new NoSuchElementException("Product not found")); // si no hay elemento presente (dentro del optional), devolvemos una excepción
    }

// Si te lías mucho con la sintaxis de arriba, piensa que es equivalente a esta otra que te dejo aquí:

//    public Product findProductByProductId(String productId) {
//        Optional<ProductHexaEntity> optionalProductHexaEntity = productJpaRepository.findByProductId(productId);
//        if (optionalProductHexaEntity.isPresent()) {
//            return ProductEntityMapper.fromEntityToProduct(optionalProductHexaEntity.get());
//        } else {
//            throw new NoSuchElementException("Product not found");
//        }
//    }

//    --------------------------------------

// Por otro lado, si hubiésemos definido nuestro ProductJpaRepository para que no devolviese Optional (ver comentario en
// ProductJpaRepository), el código debería controlar la devolución del null, para lanzar la excepción:

//    public Product2 findProductByProductId(String productId) {
//        ProductHexaEntity productEntity = productJpaRepository2.findProductByProductId(productId);
//        if (productEntity == null)  throw new NoSuchElementException("Product not found");
//        return ProductEntityMapper.fromEntityToProduct(productEntity);
//    }


}

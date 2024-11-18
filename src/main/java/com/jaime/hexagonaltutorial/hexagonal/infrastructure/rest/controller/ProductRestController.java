package com.jaime.hexagonaltutorial.hexagonal.infrastructure.rest.controller;

import com.jaime.hexagonaltutorial.hexagonal.infrastructure.rest.mapper.ProductDtoMapper;
import com.jaime.hexagonaltutorial.hexagonal.usecase.IProductInteractor;
import com.jaime.hexagonaltutorial.common.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RequestMapping("/hexagonal/products")
@RestController
public class ProductRestController {

    private final IProductInteractor productInteractor;

    @GetMapping("/{productId}")
    public ProductDto findProductByProductId(@PathVariable String productId) {
        return ProductDtoMapper.fromProductToDto(productInteractor.findProductById(productId));
    }
}

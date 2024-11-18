package com.jaime.hexagonaltutorial.layered.controller;

import com.jaime.hexagonaltutorial.common.ProductDto;
import com.jaime.hexagonaltutorial.layered.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/layer/products")
@RestController
class ProductController implements IProductController {

    private final ProductService productService;

    @Override
    @GetMapping("/{productId}")
    public ProductDto getProductByProductId(@PathVariable String productId) {
        return productService.getProductById(productId);
    }
}

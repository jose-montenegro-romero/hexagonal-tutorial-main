package com.jaime.hexagonaltutorial.layered.controller;

import com.jaime.hexagonaltutorial.common.ProductDto;
import org.springframework.web.bind.annotation.PathVariable;

public interface IProductController {
    ProductDto getProductByProductId(@PathVariable String productId);
}

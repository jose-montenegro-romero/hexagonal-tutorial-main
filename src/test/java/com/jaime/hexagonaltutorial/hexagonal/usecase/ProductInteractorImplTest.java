package com.jaime.hexagonaltutorial.hexagonal.usecase;

import com.jaime.hexagonaltutorial.hexagonal.domain.model.Product;
import com.jaime.hexagonaltutorial.hexagonal.domain.repository.ProductRepositoryPort;
import com.jaime.hexagonaltutorial.hexagonal.providers.ProductProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ProductInteractorImplTest {

    ProductRepositoryPort productRepository;

    @BeforeEach
    void setUp() {
        productRepository = mock(ProductRepositoryPort.class);
    }

    @ParameterizedTest
    @ArgumentsSource(ProductProvider.class)
    void getProductById_test(Product repositoryMockedProduct) {

        // given
        ProductInteractorImpl productInteractorImpl = new ProductInteractorImpl(productRepository);

        when(productRepository.findProductByProductId(anyString()))
                .thenReturn(repositoryMockedProduct);

        // when
        Product product = productInteractorImpl.findProductById(repositoryMockedProduct.getProductId());

        // then
        verify(productRepository, times(1)).findProductByProductId(repositoryMockedProduct.getProductId());
        assertEquals(repositoryMockedProduct, product);
    }

}

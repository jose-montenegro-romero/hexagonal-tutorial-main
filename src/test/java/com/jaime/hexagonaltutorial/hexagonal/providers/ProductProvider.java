package com.jaime.hexagonaltutorial.hexagonal.providers;

import com.jaime.hexagonaltutorial.hexagonal.domain.model.Product;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.math.BigDecimal;
import java.util.stream.Stream;

public class ProductProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return Stream.of(
                Arguments.of(new Product("1", "Camiseta Blanca", "Description 1", BigDecimal.valueOf(10.0), "€")),
                Arguments.of(new Product("2", "Pantalón negro", "Description 2", BigDecimal.valueOf(20.0), "$"))
            );
    }
}

package com.jaime.hexagonaltutorial.hexagonal.providers;

import com.jaime.hexagonaltutorial.hexagonal.infrastructure.database.h2.entity.ProductHexaEntity;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.math.BigDecimal;
import java.util.stream.Stream;

public class ProductEntityProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return Stream.of(
                Arguments.of(new ProductHexaEntity("1", "Camiseta Blanca", "Description 1", new BigDecimal("10.0"), "€")),
                Arguments.of(new ProductHexaEntity("2", "Pantalón negro", "Description 2", new BigDecimal("20.0"), "$"))
        );
    }
}

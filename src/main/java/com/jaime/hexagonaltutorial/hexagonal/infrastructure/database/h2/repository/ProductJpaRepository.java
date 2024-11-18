package com.jaime.hexagonaltutorial.hexagonal.infrastructure.database.h2.repository;


import com.jaime.hexagonaltutorial.hexagonal.infrastructure.database.h2.entity.ProductHexaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository("hexagonalProductJpaRepository") // this annotation is necessary to avoid conflicts with the other repo in layered folder (named ProductJpaRepository too), it shouldn't be necessary in a real project
public interface ProductJpaRepository extends JpaRepository<ProductHexaEntity, Long> {
    Optional<ProductHexaEntity> findByProductId(String productId);
}

// NOTA: Podríamos haber definido también que nuestro repository no devolviese el resultado envuelto en un optional, sino directamente:
//public interface ProductJpaRepository2 extends JpaRepository<ProductEntity2, UUID> {
//    ProductHexaEntity findProductByProductId(String productId);
//}

// EN CUYO CASO, cuando fuésemos a utilizarlo, debemos tener en cuenta, que si no ha encontrado un ProductHexaEntity,
// devolverá un nulo. Usar un optional, nos permite dejar un código un poco más elegante y descriptivo, como
// puedes ver en el ProductRepositoryAdapter.java
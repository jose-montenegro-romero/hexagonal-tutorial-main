package com.jaime.hexagonaltutorial.layered.repository;


import com.jaime.hexagonaltutorial.layered.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository("layeredProductJpaRepository") // this annotation is necessary to avoid conflicts with the other repo in layered folder (named ProductJpaRepository too), it shouldn't be necessary in a real project
public interface ProductJpaRepository extends JpaRepository<ProductEntity, UUID> {
    Optional<ProductEntity> findByProductId(String productId);
}

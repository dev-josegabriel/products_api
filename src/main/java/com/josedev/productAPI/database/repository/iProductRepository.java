package com.josedev.productAPI.database.repository;

import com.josedev.productAPI.database.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iProductRepository extends JpaRepository<ProductEntity, Long> {

}

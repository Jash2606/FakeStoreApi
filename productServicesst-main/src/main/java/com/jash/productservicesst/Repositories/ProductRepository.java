package com.jash.productservicesst.Repositories;

import com.jash.productservicesst.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {
//    @Override
    Optional<Product> findAllById(Long id);
    @Override
    Product save(Product product);
}

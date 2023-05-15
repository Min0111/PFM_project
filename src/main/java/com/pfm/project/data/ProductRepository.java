package com.pfm.project.data;

import com.pfm.project.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {

    //Optional<List<Product>> findAllByProduct_ProductNameContaining(String search);

}

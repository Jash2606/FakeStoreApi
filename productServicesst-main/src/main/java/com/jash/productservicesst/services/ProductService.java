package com.jash.productservicesst.services;

import com.jash.productservicesst.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id);
    List<Product> getAllProducts();
}

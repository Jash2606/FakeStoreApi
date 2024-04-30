package com.jash.productservicesst.services;

import com.jash.productservicesst.exceptions.ProductNotFoundException;
import com.jash.productservicesst.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id) throws ProductNotFoundException;
    List<Product> getAllProducts();

    Product createProduct(Product product);
}

package com.jash.productservicesst.Controller;

import com.jash.productservicesst.controllers.ProductController;
import com.jash.productservicesst.models.Product;
import com.jash.productservicesst.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductControllerTest {
    @Autowired
    private ProductController productController;

    @MockBean
    private ProductService productService;

    @Test
    void testValidProductId() {

        Product product = new Product();
        product.setId(1L);
        product.setTitle("iphone 15");
        product.setPrice(100000.0);

        when(productService.getProductById(1L))
                .thenReturn(product);

        System.out.println(product.getImage()); // It is NULL....

        Product outputProduct = productController.getProductById(1L);

        System.out.println(product.getImage());
        System.out.println(outputProduct.getImage());

        System.out.println("DEKHO__YAHA");
        assertEquals(product, outputProduct);
    }
}

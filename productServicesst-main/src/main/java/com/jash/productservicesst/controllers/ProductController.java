package com.jash.productservicesst.controllers;

import com.jash.productservicesst.dtos.ExceptionDto;
import com.jash.productservicesst.models.Product;
import com.jash.productservicesst.services.FakeStoreProductService;
import com.jash.productservicesst.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id){
//        ResponseEntity<Product> responseEntity = null;
//        Product product = null;
//        try{
//            product = productService.getProductById(id);
//            responseEntity = new ResponseEntity<>(product, HttpStatus.OK);
//            System.out.println("Hello, This code will only execute when the exception doesn't happens.");
//            return responseEntity;
//        } catch(RuntimeException exception){
//            ExceptionDto dto = new ExceptionDto();
//            dto.setMessage("Something went wrong udit");
//            ResponseEntity<ExceptionDto> response = new ResponseEntity<>(dto, HttpStatus.NOT_FOUND );
//            return response;
//        }
        return productService.getProductById(id);
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
}

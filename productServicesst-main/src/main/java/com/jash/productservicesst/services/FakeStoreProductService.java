package com.jash.productservicesst.services;

import com.jash.productservicesst.dtos.FakeStoreProductDto;
import com.jash.productservicesst.exceptions.ProductNotFoundException;
import com.jash.productservicesst.models.Category;
import com.jash.productservicesst.models.Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component   // it will make an object during start of object..

public class FakeStoreProductService implements ProductService{

    @Override
    public Product getProductById(Long id) {

        RestTemplate restTemplate = new RestTemplate();
        FakeStoreProductDto fakeStoreProductDto =
                restTemplate.getForObject("https://fakestoreapi.com/products/" + id,
                        FakeStoreProductDto.class);

        if (fakeStoreProductDto == null) {
            throw new ProductNotFoundException(id, "Please pass a valid productId");
        }

        //convert FakeStoreProductDto object to Product object.
        return convertFakeStoreDtosToProduct(fakeStoreProductDto);
    }

    public List<Product> getAllProducts(){
        RestTemplate restTemplate = new RestTemplate();
        FakeStoreProductDto[] fakeStoreProductDtos = restTemplate.getForObject("https://fakestoreapi.com/products",
                FakeStoreProductDto[].class);
        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto: fakeStoreProductDtos){
            products.add(convertFakeStoreDtosToProduct(fakeStoreProductDto));
        }
        return products;
    }

    private Product convertFakeStoreDtosToProduct( FakeStoreProductDto fakeStoreProductDto ){
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setImage(fakeStoreProductDto.getImage());
        product.setDescription(fakeStoreProductDto.getDescription());
        Category category = new Category();
        category.setTitle(fakeStoreProductDto.getCategory());
        product.setCategory(category);
        return product;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }
}

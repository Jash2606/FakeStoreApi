package com.jash.productservicesst.services;

import com.jash.productservicesst.dtos.FakeStoreCartDto;
import com.jash.productservicesst.models.Cart;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Component

public class FakeStoreCartService implements CartService {
    RestTemplate restTemplate = new RestTemplate();
    public Cart getCartById(Long id){
        FakeStoreCartDto fakeStoreCartDto = restTemplate.getForObject("https://fakestoreapi.com/carts/"+id , FakeStoreCartDto.class);
        if(fakeStoreCartDto!=null ){
            Cart cart = convertFakeStoreDtosToCart(fakeStoreCartDto);
            return cart;
        }
        return null;
    }
    private Cart convertFakeStoreDtosToCart( FakeStoreCartDto fakeStoreCartDto) {
        Cart cart = new Cart();
        cart.setId(fakeStoreCartDto.getId());
        cart.setUserId(fakeStoreCartDto.getUserId());
        cart.setDate(convertDate(fakeStoreCartDto.getDate()));
        cart.setProducts(fakeStoreCartDto.getProducts());
        return cart;
    }

    private static String convertDate(String inputDate) {
        //10
        StringBuilder str = new StringBuilder();
        for( int i = 0 ; i<10 ; i++ ){
            str.append(inputDate.charAt(i));
        }
        return str.toString();
    }
}


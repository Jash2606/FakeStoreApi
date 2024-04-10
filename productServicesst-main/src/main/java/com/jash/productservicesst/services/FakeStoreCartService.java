package com.jash.productservicesst.services;

import com.jash.productservicesst.dtos.FakeStoreCartDto;
import com.jash.productservicesst.models.Cart;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

//import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component

public class FakeStoreCartService implements CartService {
    RestTemplate restTemplate = new RestTemplate();
    public Cart getCartById(Long id){
        FakeStoreCartDto fakeStoreCartDto = restTemplate.getForObject("https://fakestoreapi.com/carts/"+id , FakeStoreCartDto.class);
        if(fakeStoreCartDto!=null ){
            Cart cart = convertFakeStoreDtosToCart(fakeStoreCartDto);
            return cart;
        }

//        for(FakeStoreProductDto fakeStoreProductDto: fakeStoreCartDtos ){
//            cart.add(convertFakeStoreDtosToCart(fakeStoreCartDto));
//        }
        return null;
    }
    private Cart convertFakeStoreDtosToCart( FakeStoreCartDto fakeStoreCartDto) {
        Cart cart = new Cart();
        cart.setId(fakeStoreCartDto.getId());
        cart.setUserId(fakeStoreCartDto.getUserId());
        cart.setDate(convertDate(fakeStoreCartDto.getDate()));
//        Date date = new ;
//        cart.setDate(convertStringToDate(fakeStoreCartDto.getDate() , "yyyy-MM-dd"));
//        if( fakeStoreCartDto.getProducts()!=null ){
////            List<Cart> products = new ArrayList<>();
//        String dateString = fakeStoreCartDto.getDate();
//        Date date = convertDate(dateString, "yyyy-MM-dd");
//        cart.setDate(date);
//            cart.setProducts(fakeStoreCartDto.getProducts());
//        }


//        cart.setProducts(fakeStoreCartDto.getProducts());
        return cart;
    }
//    private static Date convertStringToDate(String dateString, String formatPattern)  {
//        SimpleDateFormat formatter = new SimpleDateFormat(formatPattern);
//        return formatter.parse(dateString);
//    }
    private static String convertDate(String inputDate) {
        //10
        StringBuilder str = new StringBuilder();
        for( int i = 0 ; i<10 ; i++ ){
            str.append(inputDate.charAt(i));
        }
        return str.toString();
    }
}


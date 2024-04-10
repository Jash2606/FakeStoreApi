package com.jash.productservicesst.controllers;

import com.jash.productservicesst.models.Cart;
import com.jash.productservicesst.services.CartService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carts")
public class CartController{
    CartService cartService ;
    CartController( CartService cartService ){
        this.cartService = cartService;
    }

    @GetMapping("/{id}")
    public Cart getCartService(@PathVariable("id") Long id) {

        return cartService.getCartById(id);
    }
}

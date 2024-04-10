package com.jash.productservicesst.dtos;

import com.jash.productservicesst.models.Products;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FakeStoreCartDto {
        private String id;
        private String userId;
        private String date;
//        private products products;
        private List<Products> products;
//        FakeStoreCartDto(CartProducts cartProducts ){
//            this.cartProducts = cartProducts;
//        }
//    }

}

package com.shopping.services;

import com.shopping.models.Product;
import com.shopping.services.inputOutPut.Print;

import java.util.ArrayList;

public class ShoppingCart implements Print {

    public  int productsCount = 0;
    public  Amount<Product>[] cartProducts = new Amount[5];

    void searchForSimilarProductAndAdd(Product product) {
        int found = -1;
        for (Amount<Product> productAmount : cartProducts) {
            String name = productAmount.getProduct().getName();
            if (name == product.getName()) {
                found = java.util.Arrays.asList(cartProducts).indexOf(productAmount);
                break;
            }


        }

        if (found > 0) {
            cartProducts[found].addCount();
            return;
        }

        for (Amount<Product> productAmount : cartProducts) {
            if (productAmount == null)
                found = java.util.Arrays.asList(cartProducts).indexOf(productAmount);
        }
        if (found > 0) {
            cartProducts[found] = new Amount<Product>(product, 1);
            return;
        }
        if (found < 0)
            err("cart full");

    }

    void searchForSimilarProductAndSub(String productName) {
        int found = -1;
        for (Amount<Product> productAmount : cartProducts) {
            String name = productAmount.getProduct().getName();
            if (name == productName) {
                found = java.util.Arrays.asList(cartProducts).indexOf(productAmount);
                break;
            }


        }
        if(found>0) {
            cartProducts[found].subCount();
            if (cartProducts[found].getCount() == 0) {
                cartProducts[found] = null;
                return;
            }

        }


        if (found < 0)
            err("no item of that kind");

    }

    public static boolean addProduct(Product product) {
        return false;
    }
}

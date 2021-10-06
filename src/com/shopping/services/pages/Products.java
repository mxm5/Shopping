package com.shopping.services.pages;

import com.shopping.models.Product;
import com.shopping.models.User;
import com.shopping.repositories.ProductsRepository;
import com.shopping.repositories.UserRepository;

import java.util.ArrayList;

public class Products extends Page {
    private final User user;
    private final ProductsRepository repo = new ProductsRepository();

    public Products(User user) {
        this.user = user;
    }

    @Override
    void run() {


        ArrayList<Product> products = repo.readAll();
        int k = 1;
        for (Product p : products) {
            p.toFormattedString(k++);
        }

        greet();
    }

    private void greet() {
        line();
        print("welcome " + user.getFirstName() + " " +
                user.getLastName() + "\n");
        line2();
        printTab(" here is a list of products ");
        printTab(" select product by number to add them in your shopping cart");
        line2();
        print("\n");
        line();

    }
}

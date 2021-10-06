package com.shopping.services.pages;

import com.shopping.repositories.ProductsRepository;

public class Main extends Page {

    private final String[] options = {"login", "register", "exit"};

    @Override
    public void run() {

        printOptions(options);

        int select = input(3);

        switch (select) {
            case 1:
                new Login().run();
                break;
            case 2:

                new Register().run();
                break;
            case 3:

                printTitle("Exiting ...");

                break;
            default:

                printTitle("some thing went wrong");

        }
    }
}

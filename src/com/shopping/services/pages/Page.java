package com.shopping.services.pages;

import com.shopping.services.inputOutPut.Input;
import com.shopping.services.inputOutPut.Print;

import java.util.Arrays;

public abstract class Page implements Print , Input {



    Page() {
        String line = "-".repeat(100);
        String[] name = getClass().getName().toUpperCase().split("\\.");
        print(line);
        String f = String.format("%50s", name[name.length - 1] + " page");
        print(f);
        print(line);
    }

    abstract void run();

}

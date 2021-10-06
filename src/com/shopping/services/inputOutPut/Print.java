package com.shopping.services.inputOutPut;

public interface Print {
    default <T> void print(T s) {
        System.out.println(s);
    }

    default <T> void printTab(T s) {
        System.out.println("\t\t\t" + s);
    }

    private void optionPrint(String s) {
        System.out.println("\t" + s);
    }

    default void line() {
        print("-".repeat(100));
    }

    default void line3() {
        print("#".repeat(100));
    }

    default void line2() {
        print(" ".repeat(10) + "-".repeat(80));
    }

    default void line(int a) {
        print("-".repeat(100) + a);
    }

    default void err() {
        print("_".repeat(10) + " ( [Failed]! ) " + "_".repeat(10));
    }

    default void err(String s) {
        print("_".repeat(10) + " ( Failed" + s + " ) " + "_".repeat(10));
    }

    default void success() {
        print("_".repeat(10) + " ( Success ) " + "_".repeat(10));
    }

    default void success(String s) {
        print("_".repeat(10) + " ( [Success]! " + s + " ) " + "_".repeat(10));
    }

    default void printOptions(String[] options) {
        int k = 0;
        for (String option : options) {
            optionPrint(++k + "\t" + option);
        }
        line();
    }

    default <T> void printTitle(T s) {
        line();
        print(s);
        line();
    }
}

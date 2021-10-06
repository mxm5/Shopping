package com.shopping.services.inputOutPut;

import java.util.Scanner;

public interface Input extends Print {


    default String input(String message) {
        System.out.print(message + " : ");

        return new Scanner(System.in).next();

    }


    default int input(int max, String msg) {

        System.out.print(msg);

        int select = 0;
        while (select == 0) {
            try {
                select = new Scanner(System.in).nextInt();

            } catch (Exception e) {
                System.out.print("insert a valid Action number : ");
                select = 0;
            }
            if (select != 0 && select > max) {
                System.out.print("insert a valid Action number from 1 to " + max + " : ");

                select = 0;
            }
            ;
        }
        return select;

    }


    default int input(int max) {
        System.out.print("select an Action number : ");

        int select = 0;
        while (select == 0) {
            try {
                select = new Scanner(System.in).nextInt();

            } catch (Exception e) {
                System.out.print("insert a valid Action number : ");
                select = 0;
            }
            if (select != 0 && select > max) {
                System.out.print("insert a valid Action number from 1 to " + max + " : ");

                select = 0;
            }
            ;
        }
        return select;

    }


    default String inputMin(int minLetter, String msg) {
        String inp = "";
        while (true) {
            inp = input(msg);
            if (inp.length() < minLetter) {
                print("you must provide at least " + minLetter + " Characters");
                err();
            } else break;

        }

        return inp;
    }

    default String inputPassword() {
        String inpA = "a";
        String inpB = "b";
        while (true) {
            inpA = inputMin(8, "insert password");
            inpB = inputMin(8, "insert password again to confirm");
            if (inpB.equals(inpA)) break;
            print("ur passwords did not match \n enter your password again");
            err();
        }

        return inpA;
    }

}

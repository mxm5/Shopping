package com.shopping.services.pages;

import com.shopping.models.User;
import com.shopping.repositories.UserRepository;
import com.shopping.services.inputOutPut.PhoneNumberValidator;

public class Login extends Page implements PhoneNumberValidator {

    private final UserRepository reop = new UserRepository();
    private String phone = "";
    private String pass = "";
    private User user;
    private User tryLogin() {

        phone = inputPhone();
        pass = input("enter password");

       return reop.read(new User(phone, pass));

    }

    @Override
    void run() {
          user =  tryLogin();

            if(user == null) new Main().run();
            else new Products(user).run();

    }

    public String getPhone() {
        return phone;
    }

    public String getPass() {
        return pass;
    }
}

package com.shopping.services.pages;

import com.shopping.models.User;
import com.shopping.repositories.UserRepository;
import com.shopping.services.inputOutPut.PhoneNumberValidator;

public class Register extends Page implements PhoneNumberValidator {
    private String fName;
    private String lName;
    private String pass;
    private String phone;
    private final UserRepository userRepository = new UserRepository();

    @Override
    void run() {


        fName = inputMin(1, "enter your first name");
        lName = inputMin(1, "enter your last name");
        phone = inputPhone();
        pass = inputPassword();

        User registeredUser = new User(fName, lName,phone, pass);

         if(userRepository.create(registeredUser)){
             success();
         }

        new Main().run();

    }

    public String getPhone() {
        return phone;
    }

    public String getPass() {
        return pass;
    }

    public String getlName() {
        return lName;
    }

    public String getfName() {
        return fName;
    }
}

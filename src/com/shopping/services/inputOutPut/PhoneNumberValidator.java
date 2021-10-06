package com.shopping.services.inputOutPut;

import com.shopping.services.pages.Page;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface PhoneNumberValidator extends Input, Print {
    String iranPhoneNumberValidatorRegex
            = "^(\\+98|0098|98|0)?9\\d{9}$";
    Pattern pattern = Pattern.compile(iranPhoneNumberValidatorRegex);

    private boolean isValidPhoneNumber(String phone) {
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }

    default String inputPhone() {
        boolean isValid = false;
        String phone = "";
        while (!isValid) {
            phone = input("enter phone Number");
            isValid = isValidPhoneNumber(phone);
            if (!isValid) {
                print("invalid phone number");
                err();
            }

        }
        return phone;
    }

}

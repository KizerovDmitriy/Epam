package com.epam.rd.autotasks.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EpamEmailValidation {

    public static boolean validateEpamEmail(String email) {
        if (email != null){
            String regex = "\\w+\\_\\w+@epam.com";
            return Pattern.compile(regex).matcher(email).matches();
        }
        return false;
    }
}






package org.example;

public class EmailValidator {

    public static boolean validateEmail (String email) {

        if (email == null || email.isEmpty()) {
            return false;
        }
        int atIndex = email.indexOf("@");
        int dotIndex = email.indexOf(".");

        return atIndex > 0 && dotIndex > atIndex && dotIndex < email.length() - 1;


    }
    
}



package org.example;

import java.util.concurrent.Callable;

public class PasswordValidator {


    public static boolean hasMinimumLength(String password) {
        return password.length() >= 8;
    }

    public static boolean containsDigits(String password) {
        boolean digitFound = false;
        for (char c : password.toCharArray()) {
            digitFound = digitFound || Character.isDigit(c);
        }
        return digitFound;
    }

    public static boolean hasUpperAndLowercaseLetters(String password) {
        boolean uppercaseFound = false;
        boolean lowercaseFound = false;
        for (char c : password.toCharArray()) {
            uppercaseFound = uppercaseFound || Character.isUpperCase(c);
            lowercaseFound = lowercaseFound || Character.isLowerCase(c);
        }
        return uppercaseFound && lowercaseFound;
    }

    public static boolean isCommonlyUsed(String password) {
        return false;
    }
}

package org.example;

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
        return false;
    }

    public static boolean isCommonlyUsed(String password) {
        return false;
    }
}

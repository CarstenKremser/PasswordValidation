package org.example;

import org.apache.commons.lang3.RandomStringUtils;

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
        String[] commonPasswords = {
                "password", "passwort",
                "geheim", "secret",
                "1234", "2345", "3456", "4567", "5678", "6789", "7890",
                "qwert", "asdf", "yxcv",
                "uiop","hjkl"
        };
        for (String commonPassword : commonPasswords) {
            if(password.toLowerCase().contains(commonPassword)) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsSpecialCharacters(String password) {
        char[] specialChars = {
                '!', '"', '§', '$', '%', '&', '/', '(', ')',
                '=', '?', '*', '+', '#', '<', '>', '°', '^',
                '@', ';', ',', ':', '.', '_', '-', '(', ')',
                '[', ']', '{', '}', '|', '\\', '~'
        };

        for (char specialChar: specialChars) {
            if(password.indexOf(specialChar)>=0) {
                return true;
            }
        }
        return false;
    }

    public static String createRandomSecurePassword() {
        boolean isOk;
        String password;
        char[] mychars = ("1234567890" +
                            "ABCDEFGHIJKLMNOPQRSTUVWXYZÄÖÜ" +
                            "abcdefghijklmnopqrstuvwxyzäöü" +
                            "#!§$%&/()=?*+'#;,:._-><@[]{}"
                            ).toCharArray();
        do {
            password = RandomStringUtils.random(10,0,0,false,false, mychars);
            System.out.println(password);
            isOk = hasMinimumLength(password)
                && containsDigits(password)
                && hasUpperAndLowercaseLetters(password)
                && containsSpecialCharacters(password)
                && !isCommonlyUsed(password);
        } while (!isOk);
        return password;
    }
}

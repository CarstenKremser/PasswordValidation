package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class PasswordValidatorTest {

    // Test hasMinimumLength(…)

    @Test
    void hasMinimumLength_shouldReturnTrue_whenCalledWithABCDEFGH() {
        String password = "ABCDEFGH";

        boolean result = PasswordValidator.hasMinimumLength(password);

        Assertions.assertTrue(result);
    }

    @Test
    void hasMinimumLength_shouldReturnFalse_whenCalledWithABCDEFG() {
        String password = "ABCDEFG";

        boolean result = PasswordValidator.hasMinimumLength(password);

        Assertions.assertFalse(result);
    }

    @Test
    void hasMinimumLength_shouldReturnFalse_whenCalledWithEmptyString() {
        String password = "";

        boolean result = PasswordValidator.hasMinimumLength(password);

        Assertions.assertFalse(result);
    }

    // Test containsDigits(…)

    @Test
    void containsDigits_shouldReturnTrue_whenCalledWithBlah1Blubb() {
        String password = "Blah1Blubb";

        boolean result = PasswordValidator.containsDigits(password);

        Assertions.assertTrue(result);
    }

    @Test
    void containsDigits_shouldReturnFalse_whenCalledWithABCDE() {
        String password = "ABCDE";

        boolean result = PasswordValidator.containsDigits(password);

        Assertions.assertFalse(result);
    }

    @Test
    void containsDigits_shouldReturnFalse_whenCalledWithEmptyString() {
        String password = "";

        boolean result = PasswordValidator.containsDigits(password);

        Assertions.assertFalse(result);
    }

    // Test hasUpperAndLowercaseLetters(…)

    @Test
    void hasUpperAndLowercaseLetters_shouldReturnTrue_whenCalledWithAbCdEfGh() {
        String password = "AbCdEfGh";

        boolean result = PasswordValidator.hasUpperAndLowercaseLetters(password);

        Assertions.assertTrue(result);
    }

    @Test
    void hasUpperAndLowercaseLetters_shouldReturnFalse_whenCalledWithABC() {
        String password = "ABC";

        boolean result = PasswordValidator.hasUpperAndLowercaseLetters(password);

        Assertions.assertFalse(result);
    }

    @Test
    void hasUpperAndLowercaseLetters_shouldReturnFalse_whenCalledWithabc() {
        String password = "abc";

        boolean result = PasswordValidator.hasUpperAndLowercaseLetters(password);

        Assertions.assertFalse(result);
    }

    @Test
    void hasUpperAndLowercaseLetters_shouldReturnFalse_whenCalledWithEmptyString() {
        String password = "";

        boolean result = PasswordValidator.hasUpperAndLowercaseLetters(password);

        Assertions.assertFalse(result);
    }

    // Test isCommonlyUsed

    @Test
    void isCommonlyUsed_shouldReturnTrue_whenCalledWithPasswort1() {
        String password = "Passwort1";

        boolean result = PasswordValidator.isCommonlyUsed(password);

        Assertions.assertTrue(result);
    }

    @Test
    void isCommonlyUsed_shouldReturnTrue_whenCalledWithAa345678() {
        String password = "Aa345678";

        boolean result = PasswordValidator.isCommonlyUsed(password);

        Assertions.assertTrue(result);
    }

    @Test
    void isCommonlyUsed_shouldReturnFalse_whenCalledWithWort1() {
        String password = "Wort1";

        boolean result = PasswordValidator.isCommonlyUsed(password);

        Assertions.assertFalse(result);
    }

    @Test
    void isCommonlyUsed_shouldReturnFalse_whenCalledWithEmptyString() {
        String password = "";

        boolean result = PasswordValidator.isCommonlyUsed(password);

        Assertions.assertFalse(result);
    }

    // Test containsSpecialCharacters()

    @Test
    void containsSpecialCharacters_shouldReturnTrue_whenCalledWithBlahDollarBlubb() {
        String password = "Blah$Blubb";

        boolean result = PasswordValidator.containsSpecialCharacters(password);

        Assertions.assertTrue(result);
    }

    @Test
    void containsSpecialCharacters_shouldReturnFalse_whenCalledWithBlahBlubb() {
        String password = "BlahBlubb";

        boolean result = PasswordValidator.containsSpecialCharacters(password);

        Assertions.assertFalse(result);
    }

    @Test
    void containsSpecialCharacters_shouldReturnFalse_whenCalledWithEmptyString() {
        String password = "";

        boolean result = PasswordValidator.containsSpecialCharacters(password);

        Assertions.assertFalse(result);
    }

    // Test createRandomSecurePassword()

    static String testPassword;
    @BeforeAll
    static void createRandomSecurePassword_generatePassword() {
        testPassword = PasswordValidator.createRandomSecurePassword();
    }

    @Test
    void createRandomSecurePassword_generatedPasswordShouldHaveMinimumLength() {
        Assertions.assertTrue(PasswordValidator.hasMinimumLength(testPassword));
    }

    @Test
    void createRandomSecurePassword_generatedPasswordShouldContainDigits() {
        Assertions.assertTrue(PasswordValidator.containsDigits(testPassword));
    }

    @Test
    void createRandomSecurePassword_generatedPasswordShouldHaveUpperAndLowercaseLetters() {
        Assertions.assertTrue(PasswordValidator.hasUpperAndLowercaseLetters(testPassword));
    }

    @Test
    void createRandomSecurePassword_generatedPasswordShouldContainSpecialCharacters() {
        Assertions.assertTrue(PasswordValidator.containsSpecialCharacters(testPassword));
    }

    @Test
    void createRandomSecurePassword_generatedPasswordShouldNotBeCommonlyUsed() {
        Assertions.assertFalse(PasswordValidator.isCommonlyUsed(testPassword));
    }
}
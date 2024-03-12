package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

}
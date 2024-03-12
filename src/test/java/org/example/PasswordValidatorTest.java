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

}
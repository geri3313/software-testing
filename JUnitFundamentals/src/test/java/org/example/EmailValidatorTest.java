package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmailValidatorTest {

    @Test
    public void validTest () {
        Assertions.assertTrue(EmailValidator.validateEmail("test@test.com"));
    }

    @Test
    public void invalidTest () {
        //Assertions.assertTrue(EmailValidator.validateEmail("@1234567."));
        Assertions.assertTrue(EmailValidator.validateEmail(""));
    }
    
}

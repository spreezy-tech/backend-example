package com.abcteam.customerservice;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CustomerServiceApplicationTests {

    Calculator testCalculator = new Calculator();

    @Test
    void itShouldAddTwoNumbers() {
        //given
        int x = 10;
        int y = 30;
        int expectedResult = 40;

        //when
        int result = testCalculator.add(x, y);

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,9,-7})
    @Disabled
    void isOddShouldReturnTrue(int number){
        boolean result = testCalculator.isOdd(number);

        assertThat(result).isTrue();
    }

    @DisplayName("If String is blank return True")
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void isStringBlankReturnTrue(String value){
        boolean result = testCalculator.isBlank(value);

        assertThat(result).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"sarthak"})
    void isStringBlankReturnFalse(String value){
        boolean result = testCalculator.isBlank(value);

        assertThat(result).isFalse();
    }

    class Calculator {

        int add(int a, int b) {
            return a + b;
        }

        boolean isOdd(int number){
            return number % 2 != 0;
        }

        boolean isBlank(String input){
            return input == null || input.trim().isEmpty();
        }
    }

}

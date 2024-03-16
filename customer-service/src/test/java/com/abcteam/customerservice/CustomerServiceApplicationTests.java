package com.abcteam.customerservice;

import org.junit.jupiter.api.Test;

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

    class Calculator {

        int add(int a, int b) {
            return a + b;
        }
    }

}

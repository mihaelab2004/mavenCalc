package com.endava.calculator;

import com.endava.calculator.basic.Basic;
import com.endava.calculator.basic.BasicOperations;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorITAssertJ {

    private BasicOperations basic = new Basic();

    @Test
    public void shouldAddOneOperands() {

        // Given

        //When
        long result = basic.add(167);

        //Then
       assertThat(result).isBetween(100L, 200L)
               .isGreaterThan(150L)
               .isEqualTo(168L)
               .isNotNegative()
               .isNull();

    }
}

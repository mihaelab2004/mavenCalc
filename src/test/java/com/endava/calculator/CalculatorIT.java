package com.endava.calculator;

import com.endava.calculator.basic.Basic;
import com.endava.calculator.basic.BasicOperations;
import com.endava.calculator.expert.Expert;
import com.endava.calculator.expert.ExpertOperations;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertThrows;


//@ExtendWith(TestReporterExtension.class)
public class CalculatorIT {

    private BasicOperations basic;
    private ExpertOperations expert;

    @BeforeAll
    public static void setUpAllTests() {
        System.out.println("Before All");
    }

    @AfterAll
    public static void tearDownAllTests() {
        System.out.println("After All");
    }

    @BeforeEach
    public void setUpEachTest() {
        basic = new Basic();
        expert = new Expert();
        System.out.println("Before Each");
    }

    @AfterEach
    public void tearDownEachTest() {
        System.out.println("After Each");
    }

    @Tags({@Tag("smoke"), @Tag("ui")})
    @ParameterizedTest
    @MethodSource("numberProvider")
    public void shouldAddNumbersGivenOperand0(int a, int b, long expected) {

        // Given

        //When
        long result = basic.add(a, b);

        //Then
        assertThat(result, is(expected));
        assertThat(result, notNullValue());

    }

    public static List<Arguments> numberProvider() {
        List<Arguments> argumentsList = new ArrayList<>();
        argumentsList.add(Arguments.of(0, 2, 2));
        argumentsList.add(Arguments.of(2, 0, 2));

        return argumentsList;
    }

    @Tag("smoke")
    @ParameterizedTest
    @CsvSource({"-2, -4, -6", "-4, -7, -11"})
    @CsvFileSource(resources = "/numberSource.csv")
    public void shouldAddNegativeNumbers(Integer a, Integer b, Long expected) {

        // Given

        //When
        long result = basic.add(a, b);

        //Then
        assertThat(result, is(expected));
    }

    //Bug found
    @Tags({@Tag("smoke"), @Tag("api")})
    @Test
    public void shouldAddLargeNumbers() {

        assertThrows(AssertionError.class, () -> {
            // Given

            //When
            long result = basic.add(Integer.MAX_VALUE, 1);

            //Then
            assertThat(result, is(Integer.MAX_VALUE + 1L));
            assertThat(result, lessThan(0L));
            assertThat(result, notNullValue());
        });
    }

    @Test
    public void shouldAddNoOperands() {

        // Given

        //When
        long result = basic.add();

        //Then
        assertThat(result, is(0L));
    }

    @Test
    public void shouldAddOneOperands() {

        // Given

        //When
        long result = basic.add(167);

        //Then
        assertThat(result, is(167L));
    }

    @Test
    public void shouldAddMoreThan2Operands() {

        // Given

        //When
        long result = basic.add(4, 5, 6, 7);

        //Then
        assertThat(result, is(22L));
        assertThat(result, notNullValue());
    }

    @Test
    public void shouldMultiplyWith0() {

        // Given

        //When
        Long result = basic.multiply(3, 0);

        //Then
        assertThat(result, is(0L));
        assertThat(result, lessThan(3L));


    }

    @Test
    public void shouldMultiplyMoreThan2Operands() {

        // Given

        //When
        long result = basic.multiply(3, 5, 6, 4, 2);

        //Then
        assertThat(result, is(720L));
    }


    @Test
    public void shouldMultiplyWithNegativeNumber() {

        // Given

        //When
        long result = basic.multiply(5, -6);

        //Then
        assertThat(result, is(-30L));
        assertThat(result, lessThan(0L));

    }

    @Test
    public void shouldMultiply2NegativeNumbers() {

        // Given

        //When
        long result = basic.multiply(-5, -6);

        //Then
        assertThat(result, is(30L));
        assertThat(result, greaterThan(0L));

    }

    @Test
    public void shouldMultiplyNoOperands() {

        // Given

        //When
        long result = basic.multiply();

        //Then
        assertThat(result, is(1L));
    }

    @Test
    public void shouldMultiplyOneOperand() {

        // Given

        //When
        long result = basic.multiply(2);

        //Then
        assertThat(result, is(2L));
    }

    @Test
    public void shouldMultiplyMaxIntegerWith2() {

        // Given

        //When
        long result = basic.multiply(Integer.MAX_VALUE, 2);

        //Then
        assertThat(result, is(4294967294L));
        assertThat(result, greaterThan(Long.valueOf(Integer.MAX_VALUE)));
    }

    @Test
    public void shouldMultiplyNumbersWithDecimals() {

        // Given

        //When
        double result = basic.multiply(5.45785, 3.57875454);

        //Then
        assertThat(result, is(19.53));
    }

    @Test
    public void shouldCalculatePowWithExponent0() {

        // Given

        //When
        double result = expert.power(500, 0);

        //Then
        assertThat(result, is(1.0));
        assertThat(result, greaterThan(0.0));
        assertThat(result, lessThan(500.0));
    }

    @Test
    public void shouldCalculatePowWithBase0() {

        // Given

        //When
        double result = expert.power(0, 3);

        //Then
        assertThat(result, is(0.0));
    }

    @Test
    public void shouldCalculatePowNegativeExponent() {

        // Given

        //When
        double result = expert.power(2, -3);

        //Then
        assertThat(result, is(0.125));
        assertThat(result, greaterThan(0.0));
        assertThat(result, lessThan(2.0));
    }

    @Test
    public void shouldCalculatePowNegativeBaseOddExponent() {

        // Given

        //When
        double result = expert.power(-2, 3);

        //Then
        assertThat(result, is(-8.0));
        assertThat(result, lessThan(0.0));
    }

    @Test
    public void shouldCalculatePowNegativeBaseEvenExponent() {

        // Given

        //When
        double result = expert.power(-2, 4);

        //Then
        assertThat(result, is(16.0));
        assertThat(result, greaterThan(0.0));
    }

    @Test
    public void shouldCalculatePowNegativeBaseNegativeOddExponent() {

        // Given

        //When
        double result = expert.power(-4, -3);

        //Then
        assertThat(result, is(-0.015625));
        assertThat(result, lessThan(0.0));
    }

    @Test
    public void shouldCalculatePowNegativeBaseNegativeOEvenExponent() {

        // Given

        //When
        double result = expert.power(-4, -2);

        //Then
        assertThat(result, is(0.0625));
        assertThat(result, greaterThan(0.0));
    }

    @Disabled
    @Test
    public void shouldCalculateFactorialWithNegativeNumber() {

        // Given


        //When
        long result = expert.factRec(-5);

        //Then
        System.out.println(result);
    }

    @Test
    public void shouldCalculateFactorialWith0() {

        // Given

        //When
        long result = expert.fact(0);

        //Then
        assertThat(result, is(1L));
    }

    @Test
    public void shouldCalculateFactorial() {

        // Given

        //When
        long result = expert.fact(20);

        //Then
        assertThat(result, is(2432902008176640000L));
    }
}

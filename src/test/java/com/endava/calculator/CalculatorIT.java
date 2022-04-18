package com.endava.calculator;

import com.endava.calculator.basic.Basic;
import com.endava.calculator.basic.BasicOperations;
import com.endava.calculator.expert.Expert;
import com.endava.calculator.expert.ExpertOperations;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
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
    public void shouldAddNumbersGivenOperand0(int a, int b) {

        // Given

        //When
        long result = basic.add(a, b);

        //Then
        System.out.println(result);
    }

    public static List<Arguments> numberProvider() {
        List<Arguments> argumentsList = new ArrayList<>();
        argumentsList.add(Arguments.of(0, 2));
        argumentsList.add(Arguments.of(2, 0));

        return argumentsList;
    }

    @Tag("smoke")
    @ParameterizedTest
    @CsvSource({"-2, -4", "-4, -7"})
    @CsvFileSource(resources = "/numberSource.csv")
    public void shouldAddNegativeNumbers(Integer a, Integer b) {

        // Given

        //When
        long result = basic.add(a, b);

        //Then
        System.out.println(result);
    }

    @Tags({@Tag("smoke"), @Tag("api")})
    @Test
    public void shouldAddLargeNumbers() {

        // Given

        //When
        long result = basic.add(Integer.MAX_VALUE, 1);

        //Then
        System.out.println(result);
    }

    @Test
    public void shouldAddNoOperands() {

        // Given

        //When
        long result = basic.add();

        //Then
        System.out.println(result);
    }

    @Test
    public void shouldAddOneOperands() {

        // Given

        //When
        long result = basic.add(167);

        //Then
        System.out.println(result);
    }

    @Test
    public void shouldAddMoreThan2Operands() {

        // Given

        //When
        long result = basic.add(4, 5, 6, 7);

        //Then
        System.out.println(result);
    }

    @Test
    public void shouldMultiplyWith0() {

        // Given

        //When
        long result = basic.multiply(3, 0);

        //Then
        System.out.println(result);
    }

    @Test
    public void shouldMultiplyMoreThan2Operands() {

        // Given

        //When
        long result = basic.multiply(3, 5, 6, 4, 2);

        //Then
        System.out.println(result);
    }


    @Test
    public void shouldMultiplyWithNegativeNumber() {

        // Given

        //When
        long result = basic.multiply(5, -6);

        //Then
        System.out.println(result);
    }

    @Test
    public void shouldMultiply2NegativeNumbers() {

        // Given

        //When
        long result = basic.multiply(-5, -6);

        //Then
        System.out.println(result);
    }

    @Test
    public void shouldMultiplyNoOperands() {

        // Given

        //When
        long result = basic.multiply();

        //Then
        System.out.println(result);
    }

    @Test
    public void shouldMultiplyOneOperand() {

        // Given

        //When
        long result = basic.multiply(2);

        //Then
        System.out.println(result);
    }

    @Test
    public void shouldMultiplyMaxIntegerWith2() {

        // Given

        //When
        long result = basic.multiply(Integer.MAX_VALUE, 2);

        //Then
        System.out.println(result);
    }

    @Test
    public void shouldMultiplyNumbersWithDecimals() {

        // Given

        //When
        double result = basic.multiply(5.45785, 3.57875454);

        //Then
        System.out.println(result);
    }

    @Test
    public void shouldCalculatePowWithExponent0() {

        // Given

        //When
        double result = expert.power(500, 0);

        //Then
        System.out.println(result);
    }

    @Test
    public void shouldCalculatePowWithBase0() {

        // Given

        //When
        double result = expert.power(0, 3);

        //Then
        System.out.println(result);
    }

    @Test
    public void shouldCalculatePowNegativeExponent() {

        // Given

        //When
        double result = expert.power(2, -3);

        //Then
        System.out.println(result);
    }

    @Test
    public void shouldCalculatePowNegativeBase() {

        // Given

        //When
        double result = expert.power(-2, 4);

        //Then
        System.out.println(result);
    }

    @Test
    public void shouldCalculatePowNegativeBaseNegativeExponent() {

        // Given

        //When
        double result = expert.power(-4, -2);

        //Then
        System.out.println(result);
    }

    @Test
    public void shouldCalculateFactorialWithNegativeNumber() {

        // Given

        //When
        long result = expert.fact(-5);

        //Then
        System.out.println(result);
    }

    @Test
    public void shouldCalculateFactorialWith0() {

        // Given

        //When
        long result = expert.fact(0);

        //Then
        System.out.println(result);
    }

    @Test
    public void shouldCalculateFactorial() {

        // Given

        //When
        long result = expert.fact(20);

        //Then
        System.out.println(result);
    }
}

package com.codewars.fourkyu.rangeextraction;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private static Stream<Arguments> provideTestValues() {
        return Stream.of(
                Arguments.of("-6,-3-1,3-5,7-11,14,15,17-20", new int[] {-6,-3,-2,-1,0,1,3,4,5,7,8,9,10,11,14,15,17,18,19,20}),
                Arguments.of("-3--1,2,10,15,16,18-20", new int[] {-3,-2,-1,2,10,15,16,18,19,20}),
                Arguments.of("-3--1,2,10,15,16,20", new int[] {-3,-2,-1,2,10,15,16,20}),
                Arguments.of("-3--1,2,10,15,16,19,20", new int[] {-3,-2,-1,2,10,15,16,19,20})
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestValues")
    public void test1(String expected, int[] input) {
        assertEquals(expected, Solution.rangeExtraction(input));
    }

    @ParameterizedTest
    @MethodSource("provideTestValues")
    public void test2(String expected, int[] input) {
        assertEquals(expected, Solution.rangeExtraction2(input));
    }

    @ParameterizedTest
    @MethodSource("provideTestValues")
    public void test3(String expected, int[] input) {
        assertEquals(expected, Solution.rangeExtraction3(input));
    }
}
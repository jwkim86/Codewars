package com.codewars.fourkyu.sumbyfactors;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumOfDividedTest {

    @Test
    public void testOne() {
        assertEquals("(2 12)(3 27)(5 15)", SumOfDivided.sumOfDivided(new int[] {12, 15}));
        assertEquals("(2 118)(59 118)(107 107)", SumOfDivided.sumOfDivided(new int[] {107, 118}));
        assertEquals("(3 0)(17 0)", SumOfDivided.sumOfDivided(new int[] {17, -17, 51, -51}));
    }

    @Test
    public void test2() {
        assertEquals("(2 12)(3 27)(5 15)", SumOfDivided.sumOfDivided2(new int[] {12, 15}));
        assertEquals("(2 118)(59 118)(107 107)", SumOfDivided.sumOfDivided2(new int[] {107, 118}));
        assertEquals("(3 0)(17 0)", SumOfDivided.sumOfDivided2(new int[] {17, -17, 51, -51}));
    }

}
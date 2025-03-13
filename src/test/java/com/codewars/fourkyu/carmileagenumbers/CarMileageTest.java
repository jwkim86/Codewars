package com.codewars.fourkyu.carmileagenumbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarMileageTest {

    @Test
    public void testTooSmall() {
        assertEquals(1, CarMileage.isInteresting2(98, new int[]{3, 256}));
        assertEquals(2, CarMileage.isInteresting2(100, new int[]{3, 256}));
    }

    @Test
    public void testAlmostAwesome() {
        assertEquals(1, CarMileage.isInteresting2(1336, new int[]{1337, 256}));
    }

    @Test
    public void testAwesome() {
        assertEquals(2, CarMileage.isInteresting2(1337, new int[]{1337, 256}));
    }

    @Test
    public void testFarNotInteresting() {
        assertEquals(0, CarMileage.isInteresting2(11208, new int[]{1337, 256}));
    }

    @Test
    public void testAlmostInteresting() {
        assertEquals(1, CarMileage.isInteresting2(11209, new int[]{1337, 256}));
    }

    @Test
    public void testInteresting() {
        assertEquals(2, CarMileage.isInteresting2(11211, new int[]{1337, 256}));
    }

    @Test
    public void testInterestingZeroTrail() {
        assertEquals(2, CarMileage.isInteresting2(10000, new int[]{}));
        assertEquals(2, CarMileage.isInteresting2(90000, new int[]{}));
    }

    @Test
    public void testInterestingSameNumber() {
        assertEquals(2, CarMileage.isInteresting2(11111, new int[]{}));
        assertEquals(1, CarMileage.isInteresting2(11110, new int[]{}));
        assertEquals(1, CarMileage.isInteresting2(11109, new int[]{}));
        assertEquals(0, CarMileage.isInteresting2(11108, new int[]{}));

        assertEquals(2, CarMileage.isInteresting2(99999, new int[]{}));
        assertEquals(1, CarMileage.isInteresting2(99998, new int[]{}));
        assertEquals(1, CarMileage.isInteresting2(99997, new int[]{}));
        assertEquals(0, CarMileage.isInteresting2(99996, new int[]{}));
    }

    @Test
    public void testInterestingInc() {
        assertEquals(2, CarMileage.isInteresting2(67890, new int[]{}));
        assertEquals(1, CarMileage.isInteresting2(67889, new int[]{}));
        assertEquals(1, CarMileage.isInteresting2(67888, new int[]{}));
        assertEquals(0, CarMileage.isInteresting2(67887, new int[]{}));
    }

    @Test
    public void testInterestingDesc() {
        assertEquals(2, CarMileage.isInteresting2(43210, new int[]{}));
        assertEquals(1, CarMileage.isInteresting2(43209, new int[]{}));
        assertEquals(1, CarMileage.isInteresting2(43208, new int[]{}));
        assertEquals(0, CarMileage.isInteresting2(43207, new int[]{}));
    }

    @Test
    public void testInterestingPalindrome() {
        assertEquals(2, CarMileage.isInteresting2(1221, new int[]{}));

        assertEquals(2, CarMileage.isInteresting2(12321, new int[]{}));
        assertEquals(1, CarMileage.isInteresting2(12320, new int[]{}));
        assertEquals(1, CarMileage.isInteresting2(12319, new int[]{}));
        assertEquals(0, CarMileage.isInteresting2(12318, new int[]{}));
    }
}
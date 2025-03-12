package com.codewars.fourkyu.rangeextraction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    public void test1() {
        assertEquals("-6,-3-1,3-5,7-11,14,15,17-20", Solution.rangeExtraction(new int[] {-6,-3,-2,-1,0,1,3,4,5,7,8,9,10,11,14,15,17,18,19,20}));
        assertEquals("-3--1,2,10,15,16,18-20", Solution.rangeExtraction(new int[] {-3,-2,-1,2,10,15,16,18,19,20}));
        assertEquals("-3--1,2,10,15,16,20", Solution.rangeExtraction(new int[] {-3,-2,-1,2,10,15,16,20}));
        assertEquals("-3--1,2,10,15,16,19,20", Solution.rangeExtraction(new int[] {-3,-2,-1,2,10,15,16,19,20}));
    }

    @Test
    public void test2() {
        assertEquals("-6,-3-1,3-5,7-11,14,15,17-20", Solution.rangeExtraction2(new int[] {-6,-3,-2,-1,0,1,3,4,5,7,8,9,10,11,14,15,17,18,19,20}));
        assertEquals("-3--1,2,10,15,16,18-20", Solution.rangeExtraction2(new int[] {-3,-2,-1,2,10,15,16,18,19,20}));
        assertEquals("-3--1,2,10,15,16,20", Solution.rangeExtraction2(new int[] {-3,-2,-1,2,10,15,16,20}));
        assertEquals("-3--1,2,10,15,16,19,20", Solution.rangeExtraction2(new int[] {-3,-2,-1,2,10,15,16,19,20}));
    }

    @Test
    public void test3() {
        assertEquals("-6,-3-1,3-5,7-11,14,15,17-20", Solution.rangeExtraction3(new int[] {-6,-3,-2,-1,0,1,3,4,5,7,8,9,10,11,14,15,17,18,19,20}));
        assertEquals("-3--1,2,10,15,16,18-20", Solution.rangeExtraction3(new int[] {-3,-2,-1,2,10,15,16,18,19,20}));
        assertEquals("-3--1,2,10,15,16,20", Solution.rangeExtraction3(new int[] {-3,-2,-1,2,10,15,16,20}));
        assertEquals("-3--1,2,10,15,16,19,20", Solution.rangeExtraction3(new int[] {-3,-2,-1,2,10,15,16,19,20}));
    }
}
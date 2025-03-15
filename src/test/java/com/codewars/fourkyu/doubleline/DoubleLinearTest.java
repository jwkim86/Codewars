package com.codewars.fourkyu.doubleline;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoubleLinearTest {

    @Test
    public void test() {
        assertEquals(1, DoubleLinear.dblLinear2(0));
        assertEquals(22, DoubleLinear.dblLinear(10));
        assertEquals(57, DoubleLinear.dblLinear(20));
        assertEquals(91, DoubleLinear.dblLinear(30));
        assertEquals(175, DoubleLinear.dblLinear(50));
    }

    @Test
    public void test2() {
        assertEquals(1, DoubleLinear.dblLinear2(0));
        assertEquals(22, DoubleLinear.dblLinear2(10));
        assertEquals(57, DoubleLinear.dblLinear2(20));
        assertEquals(91, DoubleLinear.dblLinear2(30));
        assertEquals(175, DoubleLinear.dblLinear2(50));
    }
}

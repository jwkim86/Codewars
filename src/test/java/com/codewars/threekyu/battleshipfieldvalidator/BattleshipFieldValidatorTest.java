package com.codewars.threekyu.battleshipfieldvalidator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BattleshipFieldValidatorTest {


    private static int[][] battleField = {
            {1, 0, 0, 0, 0, 1, 1, 0, 0, 0},
            {1, 0, 1, 0, 0, 0, 0, 0, 1, 0},
            {1, 0, 1, 0, 1, 1, 1, 0, 1, 0},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

    @Test
    public void SampleTest() {
        assertEquals(true, BattleshipFieldValidator.fieldValidator(battleField));
    }
}
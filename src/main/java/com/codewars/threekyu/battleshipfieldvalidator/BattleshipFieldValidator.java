package com.codewars.threekyu.battleshipfieldvalidator;

import java.util.HashMap;
import java.util.Map;

public class BattleshipFieldValidator {

    // https://www.codewars.com/kata/52bb6539a4cf1b12d90005b7/java
    public static boolean fieldValidator(int[][] field) {
        Map<Integer, Integer> ships = new HashMap<>();
        for(int i=0; i<10; i++) {
            for(int j=0; j<10; j++) {
                // Check if diagonal cells have number. This is MAIN IDEA!!
                if(i<9 && j<9 && hasDiagonalNumber(field, i, j)) return false;

                // If not empty cell
                if(field[i][j] > 0) {

                    // Check if next y cell is filled
                    if(i<9 && field[i+1][j] == 1) {
                        // Fill next y cell with current ship size +1
                        field[i+1][j] = field[i][j]+1;
                        // Check if next y cell ship size over 4
                        if(field[i+1][j] > 4) return false;

                    // Check if next x cell is filled
                    } else if(j<9 && field[i][j+1] == 1) {
                        // Fill next x cell with current ship size +1
                        field[i][j+1] = field[i][j]+1;
                        // Check if next x cell ship size over 4
                        if(field[i][j+1] > 4) return false;

                    // Every next cells are empty
                    } else {
                        // Ship size is confirmed, Add ship count
                        ships.put(field[i][j], ships.getOrDefault(field[i][j], 0)+1);
                    }
                }
            }
        }
        // Check ship count by ship size
        if(ships.getOrDefault(4, 0) != 1) return false;
        if(ships.getOrDefault(3, 0) != 2) return false;
        if(ships.getOrDefault(2, 0) != 3) return false;
        if(ships.getOrDefault(1, 0) != 4) return false;
        return true;
    }

    public static boolean hasDiagonalNumber(int[][] field, int y, int x) {
        if(field[y][x] > 0 && field[y+1][x+1] > 0) return true;
        if(field[y+1][x] > 0 && field[y][x+1] > 0) return true;
        return false;
    }
}

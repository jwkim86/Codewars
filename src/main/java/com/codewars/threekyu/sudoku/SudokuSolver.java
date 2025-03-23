package com.codewars.threekyu.sudoku;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// ref. https://www.codewars.com/kata/5296bc77afba8baa690002d7/java
public class SudokuSolver {

    public static int[][] sudoku(int[][] puzzle) {
        List<List<Set<Integer>>> possible = new ArrayList<>();
        for(int i=0; i<9; i++) {
            List<Set<Integer>> row = new ArrayList<>();
            possible.add(row);
            for(int j=0; j<9; j++) {
                Set<Integer> cell = new HashSet<>();
                row.add(cell);
                for(int k=1; k<=9; k++) {
                    cell.add(k);
                }
            }
        }
        int[][] result = new int[9][9];
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                int n = puzzle[i][j];
                if(n!=0) {
                    possible.get(i).get(j).clear();
                    possible.get(i).get(j).add(n);
                    removeNumbers(i, j, n, possible, result);
                }
            }
        }
        return result;
    }
    private static void removeNumbers(int i, int j, int n, List<List<Set<Integer>>> possible, int[][] result){
        result[i][j] = n;
        for(int k=0; k<9; k++) {
            if(k==j) continue;
            Set<Integer> cell = possible.get(i).get(k);
            if(cell.size()==1) continue;
            cell.remove(n);
            if(cell.size()==1) removeNumbers(i, k, (Integer)cell.toArray()[0], possible, result);
        }
        for(int k=0; k<9; k++) {
            if(k==i) continue;
            Set<Integer> cell = possible.get(k).get(j);
            if(cell.size()==1) continue;
            cell.remove(n);
            if(cell.size()==1) removeNumbers(k, j, (Integer)cell.toArray()[0], possible, result);
        }
        for(int k=(i/3)*3; k<(i/3+1)*3; k++) {
            for(int l=(j/3)*3; l<(j/3+1)*3; l++) {
                Set<Integer> cell = possible.get(k).get(l);
                if(cell.size()==1) continue;
                cell.remove(n);
                if(cell.size()==1) removeNumbers(k, l, (Integer)cell.toArray()[0], possible, result);
            }
        }
    }

    // best practice!
    public static int[][] sudoku2(int[][] puzzle) {

        boolean solved = false;
        boolean changed = true;

        while (!solved && changed) {

            solved = true;
            changed = false;

            for (int x = 0; x < 9; ++x) {
                for (int y = 0; y < 9; ++y) {
                    if (puzzle[x][y] == 0) {
                        final int boxX = x / 3 * 3;
                        final int boxY = y / 3 * 3;
                        int possibility = 0;
                        for (int i = 1; i < 10; ++i) {
                            boolean found = false;
                            for (int k = 0; k < 9; ++ k) {
                                if (puzzle[k][y] == i || puzzle[x][k] == i || puzzle[boxX + k % 3][boxY + k / 3] == i) {
                                    found = true;
                                    break;
                                }
                            }
                            if (!found) {
                                if (possibility == 0) {
                                    possibility = i;
                                } else {
                                    possibility = 0;
                                    break;
                                }
                            }
                        }
                        puzzle[x][y] = possibility;
                        changed |= possibility != 0;
                        solved &= possibility != 0;
                    }
                }
            }
        }

        if (!solved) {
            throw new RuntimeException("Unable to resolve!");
        }

        return puzzle;
    }
}

package com.codewars.fourkyu.doubleline;

import java.util.*;

public class DoubleLinear {

    public static int dblLinear (int n) {
        Set<Integer> mem = new HashSet<>();
        PriorityQueue<Integer> doubleLinear = new PriorityQueue<>();
        doubleLinear.add(1);
        for(int i=0; i<n; i++) {
            int x = doubleLinear.poll();
            if(mem.contains(x)) {
                i--;
                continue;
            }
            mem.add(x);
            doubleLinear.add(2*x+1);
            doubleLinear.add(3*x+1);
        }
        return doubleLinear.poll();
    }

    // best practice
    public static int dblLinear2 (int n) {
        if (n == 0) return 1;
        SortedSet<Integer> u = new TreeSet<>();
        u.add(1);
        for(int i=0; i<n; i++) {
            int x = u.first();
            u.add(x*2+1);
            u.add(x*3+1);
            u.remove(x);
        }
        return u.first();
    }
}

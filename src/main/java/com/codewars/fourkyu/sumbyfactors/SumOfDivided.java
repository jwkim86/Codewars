package com.codewars.fourkyu.sumbyfactors;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

// ref. https://www.codewars.com/kata/54d496788776e49e6b00052f/solutions/java
public class SumOfDivided {
    public static String sumOfDivided(int[] l) {
        Map<Integer, Integer> result = new HashMap<>();
        for(int ij : l) {
            int absIj = Math.abs(ij);
            for(int i=2; i<=absIj/2; i++) {
                if(isPrime(i) && absIj%i == 0) {
                    result.put(i, result.getOrDefault(i, 0)+ij);
                }
            }
            if(isPrime(absIj)) {
                result.put(absIj, result.getOrDefault(absIj, 0)+ij);
            }
        }
        return result.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(e -> String.format("(%d %d)", e.getKey(), e.getValue()))
                .collect(Collectors.joining());
    }

    private static final Set<Integer> primes = new HashSet<>();

    private static boolean isPrime(int num) {
        if(primes.contains(num)) return true;

        for(int i=2; i*i<=num; i++) {
            if(num%i==0) return false;
        }

        primes.add(num);
        return true;
    }

    public static String sumOfDivided2(int[] l) {
        final Map<Integer, Integer> result = new HashMap<>();
        for(final int ij : l) {
            int absIj = Math.abs(ij);
            for(int i=2; i<=absIj; i++) {
                if(absIj%i == 0) {
                    result.put(i, result.getOrDefault(i, 0)+ij);
                    do{
                        absIj /= i;
                    } while (absIj%i==0);
                }

            }
        }
        return result.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(e -> String.format("(%d %d)", e.getKey(), e.getValue()))
                .collect(Collectors.joining());
    }
}

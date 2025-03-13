package com.codewars.fourkyu.carmileagenumbers;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.lang.Integer.parseInt;

// ref: https://www.codewars.com/kata/52c4dd683bfd3b434c000292/train/java
public class CarMileage {

    public static int isInteresting(int number, int[] awesomePhrases) {
        if(isExactlyInteresting(number, awesomePhrases)) return 2;
        if(isExactlyInteresting(number+1, awesomePhrases)) return 1;
        if(isExactlyInteresting(number+2, awesomePhrases)) return 1;
        return 0; // Go to town
    }

    private static boolean isExactlyInteresting(int number, int[] awesomePhrases) {
        if (number <= 99) return false;
        if (Arrays.stream(awesomePhrases).anyMatch(p -> p == number)) return true;
        if (hasOnlyZeroTrail(number)) return true;
        if (hasOnlyOneNumbers(number)) return true;
        if (isSequentialInc(number)) return true;
        if (isSequentialDesc(number)) return true;
        if (isPalindrome(number)) return true;
        return false;
    }

    private static boolean hasOnlyZeroTrail(int number) {
        while(number%10==0) number/=10;
        return number < 10;
    }

    private static boolean hasOnlyOneNumbers(int number) {
        int lastNumber = number%10;
        if(lastNumber == 0) return false;
        int calcNumber = lastNumber;
        while(calcNumber<number) calcNumber = calcNumber*10 + lastNumber;
        return number == calcNumber;
    }

    private static boolean isSequentialInc(int number) {
        int firstNumber = number;
        while(firstNumber > 9) firstNumber /= 10;
        int calcNumber = firstNumber;
        for(int i=firstNumber+1; i<=10 && calcNumber < number; i++) calcNumber = calcNumber*10 + (i==10?0:i);
        return calcNumber == number;
    }

    private static boolean isSequentialDesc(int number) {
        int firstNumber = number;
        while(firstNumber > 9) firstNumber /= 10;
        int calcNumber = firstNumber;
        for(int i=firstNumber-1; i>=0 && calcNumber < number; i--) calcNumber = calcNumber*10 + i;
        return calcNumber == number;
    }

    private static boolean isPalindrome(int number) {
        char[] numberAry = String.valueOf(number).toCharArray();
        for(int i=0; i<numberAry.length/2; i++) {
            if(numberAry[i] != numberAry[numberAry.length-1-i]) return false;
        }
        return true;
    }
    
    // Best practice!!!
    public static boolean isReallyInteresting(int number, final int[] awesomePhrases) {
        return Stream.<Predicate<String>>of(
                s -> s.matches("\\d0+"),
                s -> new StringBuilder(s).reverse().toString().equals(s),
                s -> "1234567890".contains(s),
                s -> "9876543210".contains(s),
                s -> Arrays.stream(awesomePhrases).anyMatch(n -> parseInt(s) == n)
        ).anyMatch( p -> number > 99 && p.test(Integer.toString(number)));
    }

    public static int isInteresting2(int number, int[] awesomePhrases) {
        return isReallyInteresting(number, awesomePhrases) ? 2 :
                isReallyInteresting(number + 1, awesomePhrases) ? 1 :
                        isReallyInteresting(number + 2, awesomePhrases) ? 1 : 0;
    }
}


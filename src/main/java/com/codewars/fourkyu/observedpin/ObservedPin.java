package com.codewars.fourkyu.observedpin;

import java.util.*;
import java.util.stream.Collectors;

public class ObservedPin {

    private static Map<Character, Character[]> numbersNearBy = new HashMap<>(){{
        put('1', new Character[]{'1', '2', '4'});
        put('2', new Character[]{'1', '2', '3', '5'});
        put('3', new Character[]{'2', '3', '6'});
        put('4', new Character[]{'1', '4', '5', '7'});
        put('5', new Character[]{'2', '4', '5', '6', '8'});
        put('6', new Character[]{'3', '5', '6', '9'});
        put('7', new Character[]{'4', '7', '8'});
        put('8', new Character[]{'5', '7', '8', '9', '0'});
        put('9', new Character[]{'6', '9', '8'});
        put('0', new Character[]{'0', '8'});
    }};

    public static List<String> getPINs(String observed) {
        char[] observedChars = observed.toCharArray();
        List<String> results = new ArrayList<>();
        Stack<Character> currentStack = new Stack<>();
        getPINsSub(observedChars, 0, currentStack, results);
        return new ArrayList<>(results);
    } // getPINs

    private static void getPINsSub(char[] observedChars, int index, Stack<Character> currentStack, List<String> results) {
        if(index==observedChars.length) {
            results.add(currentStack.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining()));
            return;
        }
        Character[] nearBys = numbersNearBy.get(observedChars[index]);
        for(int i=0; i<nearBys.length; i++) {
            currentStack.push(nearBys[i]);
            getPINsSub(observedChars, index+1, currentStack, results);
            currentStack.pop();
        }
    }

    // best practice
    private static final Map<Character,String> ADJACENTS = new HashMap<Character,String>() {{
        put('1', "124");
        put('2', "2135");
        put('3', "326");
        put('4', "4157");
        put('5', "54268");
        put('6', "6953");
        put('7', "748");
        put('8', "87590");
        put('9', "986");
        put('0', "08");
    }};

    public static List<String> getPINs2(String observed) {

        List<String> ans = List.of("");

        for (char c: observed.toCharArray()) {

            List<String> tmp = new ArrayList<String>();
            for (char cc: ADJACENTS.get(c).toCharArray()) {
                for (String s: ans) tmp.add(s+cc);
            }
            ans = tmp;
        }
        return ans;
    }


    public static List<String> getPINs3(String observed) {

        List<StringBuilder> ans = new ArrayList<>(){{
            add(new StringBuilder());
        }};
        for (char o: observed.toCharArray()) {
            List<StringBuilder> tmp = new ArrayList<>();
            for (char c: ADJACENTS.get(o).toCharArray()) {
                for (StringBuilder s: ans) {
                    StringBuilder sb = new StringBuilder(s);
                    sb.append(c);
                    tmp.add(sb);
                }
            }
            ans = tmp;
        }
        return ans.stream()
                .map(StringBuilder::toString)
                .collect(Collectors.toList());
    }

}

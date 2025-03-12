package com.codewars.fourkyu.topwords;


import java.util.*;
import java.util.regex.Pattern;

import static java.util.Collections.reverseOrder;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class TopWords {


    public static List<String> top3(String s) {
        String replaced = s.replaceAll("[^(a-zA-Z' )]", " ");
        StringTokenizer st = new StringTokenizer(replaced);
        Pattern p = Pattern.compile("^'+$");

        return Collections.list(st).stream()
                .map(token->(String)token)
                .filter(token -> !p.matcher(token).matches())
                .map(String::toLowerCase)
                .collect(groupingBy(token -> token, counting()))
                .entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue, reverseOrder()))
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();
    }
}

package com.codewars.fivekyu.rot13;

import java.util.stream.Collectors;

public class Rot13 {
    public static String rot13(String str) {
        // A-Z: 65-90, a-z: 97-122
        return str.chars().map(c->{
            if(c>=65 && c<=90) {
                return (c-65+13)%(90-65+1)+65;
            }
            if(c>=97 && c<=122) {
                return (c-97+13)%(122-97+1)+97;
            }
            return c;
        })
                .mapToObj(c -> (char)c)
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    /**
     * improve readability
     */
    public static String rot13_2(String str) {
        return str.chars().map(c->{
                    if(c>='A' && c<='Z') {
                        return (c-'A'+13) % ('Z'-'A'+1) + 'A';
                    }
                    if(c>='a' && c<='z') {
                        return (c-'a'+13) % ('z'-'a'+1) + 'a';
                    }
                    return c;
                })
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}

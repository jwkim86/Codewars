package com.codewars.fourkyu.textalignjustify;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

// ref. https://www.codewars.com/kata/537e18b6147aa838f600001b/train/java
public class Kata {
    public static String justify(String text, int width) {
        String[] words = text.split(" ");
        StringBuilder sb = new StringBuilder();
        Stack<String> line = new Stack<>();
        for(int i=0; i<words.length; i++) {
            line.push(words[i]);
            if(line.stream().mapToInt(s -> s.length() + 1).sum() - 1 > width) {
                line.pop();
                i--;
                appendLine(line, sb, width);
                line.clear();
            }
        }
        // append last line
        sb.append(String.join(" ", line));
        return sb.toString();
    }

    public static void appendLine(Stack<String> line, StringBuilder sb, int width) {
        int gapCount = line.size() -1;
        if(gapCount < 1) {
            sb.append(line.get(0));
        } else {
            int spaces = width - line.stream().mapToInt(String::length).sum();
            int spacePerWord = spaces / gapCount;
            int largeSpaceCount = spaces % gapCount;
            for (int i = 0; i < largeSpaceCount; i++) {
                sb.append(line.get(i));
                sb.append(" ".repeat(spacePerWord + 1));            }
            for (int i = largeSpaceCount; i < line.size() - 1; i++) {
                sb.append(line.get(i));
                sb.append(" ".repeat(spacePerWord));
            }
            sb.append(line.get(line.size()-1));
        }
        sb.append("\n");
    }

    // Best practice!!
    private static String formatLine(Stack<String> line, int width) {
        if (line.size() == 1) return line.pop() + "\n";
        int spaces = width - line.stream().mapToInt(s -> s.length()).sum();
        int spacesPerWord = spaces / (line.size() - 1);
        int largerSpaces = spaces % (line.size() - 1);
        List<String> base = line.stream().map(s -> s + " ".repeat(spacesPerWord)).collect(Collectors.toList());
        for (int i = 0; i < largerSpaces; i++)
            base.set(i, base.get(i) + " ");
        base.set(base.size() - 1, base.get(base.size() - 1).trim());
        return base.stream().collect(Collectors.joining()) + "\n";
    }

    public static String justify2(String text, int width) {
        String lines = "";
        String[] words = text.split(" ");
        Stack<String> line = new Stack<>();
        for (int i = 0; i < words.length; i++) {
            line.push(words[i]);
            if (line.stream().mapToInt(s -> s.length() + 1).sum() - 1 > width) {
                line.pop();
                lines += formatLine(line, width);
                line = new Stack<>();
                i--;
            }
        }
        lines += line.stream().collect(Collectors.joining(" "));

        return lines;
    }
}

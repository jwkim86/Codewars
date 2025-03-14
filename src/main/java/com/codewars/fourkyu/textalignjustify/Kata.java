package com.codewars.fourkyu.textalignjustify;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Kata {
    public static String justify(String text, int width) {

        StringBuilder sb = new StringBuilder();
        int i=0;
        for(int j=width; j<text.length(); i=j+1, j+=width+1) {
            j = text.lastIndexOf(' ', j);
            String line = text.substring(i, j);
            appendLine(line, sb, width);
            sb.append("\n");
        }

        // last line;
        sb.append(text.substring(i).trim());

        return sb.toString();
    }

    public static void appendLine(String line, StringBuilder sb, int width) {
        if(line.length() == width) {
            sb.append(line);
            return;
        }
        String[] tokens = line.split(" ");
        int gapCount = tokens.length -1;
        if(gapCount < 1) {
            sb.append(tokens[0]);
        } else {
            int totalWhiteSpaceSize = width - line.length() + tokens.length - 1;
            int whiteSpaceSize = totalWhiteSpaceSize / gapCount;
            int remainWhiteSpaceSize = totalWhiteSpaceSize % gapCount;
            for (int i = 0; i < remainWhiteSpaceSize; i++) {
                sb.append(String.format("%-" + (tokens[i].length() + whiteSpaceSize + 1) + "s", tokens[i]));
            }
            for (int i = remainWhiteSpaceSize; i < tokens.length - 1; i++) {
                sb.append(String.format("%-" + (tokens[i].length() + whiteSpaceSize) + "s", tokens[i]));
            }
            sb.append(tokens[tokens.length-1]);
        }
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

package com.codewars.fourkyu.textalignjustify;

import java.util.StringTokenizer;

public class Kata {
    public static String justify(String text, int width) {
        StringTokenizer st = new StringTokenizer(text);
        StringBuilder sb = new StringBuilder();

        int sumLength = 0;
        while(sumLength <= width) {
            while(st.hasMoreTokens()) {
                String token = st.nextToken();
                sumLength += token.length() + 1;
            }
        }

        return text;
    }

    public static String justify2(String text, int width) {

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
}

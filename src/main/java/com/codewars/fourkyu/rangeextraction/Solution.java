package com.codewars.fourkyu.rangeextraction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static String rangeExtraction(int[] arr) {
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        int run = 0;
        for(int i=0; i<arr.length; i++) {
            if(run == 0) {
                sb.append(arr[i]);
                run=1;
                continue;
            }
            if(arr[i-1]+1 == arr[i]) {
                run++;
                continue;
            }
            if(run > 2) {
                sb.append("-");
                sb.append(arr[i-1]);
                sb.append(",");
                sb.append(arr[i]);
            } else if(run == 2){
                sb.append(",");
                sb.append(arr[i-1]);
                sb.append(",");
                sb.append(arr[i]);
            } else {
                sb.append(",");
                sb.append(arr[i]);
            }
            run = 1;
        }
        if(run==2) {
            sb.append(",");
            sb.append(arr[arr.length-1]);
        } else if(run>=3) {
            sb.append("-");
            sb.append(arr[arr.length-1]);
        }
        return sb.toString();
    }
    public static String rangeExtraction2(int[] arr) {
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        sb.append(arr[0]);
        int run = 1;
        for(int i=1; i<arr.length; i++) {
            if(arr[i-1] + 1 == arr[i]) {
                run++;
                continue;
            }
            if(run==1) {
                sb.append(",");
                sb.append(arr[i]);
            } else if(run==2) {
                sb.append(",");
                sb.append(arr[i-1]);
                sb.append(",");
                sb.append(arr[i]);
            } else {
                sb.append("-");
                sb.append(arr[i-1]);
                sb.append(",");
                sb.append(arr[i]);
            }
            run=1;
        }
        if(run==2) {
            sb.append(",");
            sb.append(arr[arr.length-1]);
        } else if(run>=3) {
            sb.append("-");
            sb.append(arr[arr.length-1]);
        }
        return sb.toString();
    }

    /**
     * Best practice
     */
    public static String rangeExtraction3(int[] arr) {
        Arrays.sort(arr);
        final int length = arr.length;
        int idx = 0, idx2 = 1;
        List<String> result = new ArrayList<>();
        while (idx < length) {
            while (idx2 < length && arr[idx2] - arr[idx2 - 1] == 1) idx2++;
            if (idx2 - idx >= 3) {
                result.add(arr[idx] + "-" + arr[idx2 - 1]);
                idx = idx2;
            } else {
                for (; idx < idx2; idx++)
                    result.add(String.valueOf(arr[idx]));
            }
            idx2++;
        }
        return String.join(",", result);
    }
}

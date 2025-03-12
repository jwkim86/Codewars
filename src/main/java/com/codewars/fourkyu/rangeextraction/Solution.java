package com.codewars.fourkyu.rangeextraction;

import java.util.Arrays;

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
}

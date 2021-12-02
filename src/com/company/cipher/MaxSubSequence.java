package com.company.cipher;

import java.util.Arrays;

public class MaxSubSequence {
    public int getResult(int[] arr) {
        int[] dp=new int[arr.length];
        dp[0]=1;
        for (int i = 1; i <arr.length ; i++) {


            int max=0;
            for (int j = i; j >=0 ; j--) {
                if (arr[j]<arr[i]&&dp[j]>max){
                    max=dp[j];
                }
            }
            dp[i]=max+1;
        }
        Arrays.sort(dp);
        return dp[dp.length-1];
    }
}

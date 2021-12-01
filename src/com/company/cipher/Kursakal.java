package com.company.cipher;

import java.util.Random;

public class Kursakal {
    int maxn = 100;
    int maxn_n = maxn * (maxn-1)/2;
    int[][] array;
    int [] mark = new int[maxn];
    int n, k, t;

    public Kursakal(int n, int m) {
        this.array = new int[3][maxn_n];
        this.maxn_n = m;
        this.maxn = n;
        for (int i=0; i<m; i++){
            for (int j=0; j<3; j++){
                Random r = new Random();
                array[j][i] = r.nextInt(9)+1;
            }
        }
        for (int i=0; i<m-1; i++){
            for (int j=i+1; j<m; j++){
                if (array[2][i]>array[2][j]){
                    for (int t1=0; t1<3; t1++){
                        k = array[t1][i];
                        array[t1][i]= array[0][j];
                        array[t1][j]=k;
                    }
                }
            }
        }
        for (int i = 0; i < maxn; i++) {
            mark[i] = i;
        }
        k = 0;
        t = m;
        int i = 1;
        while (k<n-1){
            i = 0;
            while ((i <= t) && (mark[array[0][i]] == mark[array[2][ i]]) && (array[0][ i] != 0)){
                i++; k++;
                if (array[0][i] * array[2][ i] != 0){
                    System.out.println(array[0][i]+"; "+array[1][i]+"; "+array[2][i]);
                    changeMark(array[0][i], array[1][i]);
                }
            }
        }
    }
    public void print(){
        for (int i=0; i<3; i++){
            for (int j=0; j<maxn_n; j++){
                System.out.print(array[i][j]+"; ");
            }
            System.out.println();
        }
    }

    void changeMark(int l, int m){
        int i, t;
        if (m<l){
            t=l;
            l=m;
            m=t;
        }
        for (int j = 0; j < n; j++) {
            if (mark[j] ==m)
                mark[j] = l;
        }
    }
}

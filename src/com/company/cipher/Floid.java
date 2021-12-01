package com.company.cipher;

import java.util.Random;

public class Floid {
    int maxV = 1000;
    int n;
    int[][] matrix = new int[maxV][maxV];

    public Floid(int n) {
        this.n = n;
        for (int i=0; i<n; i++){
            Random r = new Random();
            matrix[i][i] = 0;
            for (int j=i+1; j<n; j++){
                int item = r.nextInt(9)+1;
                matrix[j][i] = item;
                matrix[i][j] = item;
            }
        }
    }
    public void floid(){
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                for (int k = 0; k < n; k++) {
                    if (matrix[i][k]+matrix[k][j]<matrix[i][j] || matrix[i][j]==0)
                        matrix[i][j]=matrix[i][k]+matrix[k][j];
                }
            }
        }
    }
    public void print(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}

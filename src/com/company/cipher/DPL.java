package com.company.cipher;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DPL {
    int n = 6;
    int max = 100000;;
    List<Integer> vector = new ArrayList();
    int start;
    int[][] matrix;

    public DPL() {
        matrix = new int[n][n];
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
    public void dpl( int st){
        List<Integer> distance = new ArrayList();
        Integer count = 0;
        int index = 0;
        int u = 0; int m=st+1;
        List<Boolean> visited = new ArrayList();
        for (int j = 0; j < n; j++) {
            visited.add(false);
            distance.add(Integer.MAX_VALUE);
        }
        distance.set(st, 0);
        for (count=0; count<n-1; count++){
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (!visited.get(j) && distance.get(j)<=min){
                    min = distance.get(j); index = j;
                }
            }
            u = index;
            visited.set(u, true);
            for (int j = 0; j < n; j++) {
                if (!visited.get(j) && matrix[u][j] >= 0 && distance.get(u)!=Integer.MAX_VALUE && distance.get(u)+matrix[u][j]<distance.get(j)){
                    distance.set(j,distance.get(u)+matrix[u][j]);
                }
            }
            for (int j = 0; j < n; j++) {
               if (distance.get(j)!=Integer.MAX_VALUE){
                   System.out.println("Стоимость пути из начального маршрута: "+distance.get(j));
               }
               else {
                   System.out.println("Маршрут недопустим");
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

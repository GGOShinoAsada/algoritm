package com.company.cipher;

import java.util.Random;

public class Ford {

    int vMax = 1000;
    int eMax = vMax*(vMax-1)/2;
    int i, j, n;
     int e = 0;
    int start;
    Edges edge[] = new Edges[eMax];
    int d[] = new int[vMax];

    public Ford(int n, int start) {
        this.n = n;
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                Random r = new Random();
                edge[e] = new Edges();
                edge[e].u = j; edge[e].v=i; edge[e].w = r.nextInt(9)+1;
            }
        }
        this.start = start-1;
    }

    public void ford(int n, int s){
        for (int i =0; i<n; i++){
            d[i] = Integer.MAX_VALUE;
        }
        d[s] = 0;
        for (int i=0; i<n; i++){
            for (int j=0; j<e; j++){
                if (d[edge[j].v]+edge[j].w<d[edge[j].u])
                    d[edge[j].u]=d[edge[j].v]+edge[j].w;
            }
        }
        for (int k = 0; k < n; k++) {
            if (d[k]!= Integer.MAX_VALUE){
                System.out.println(start+";"+i+1+";"+d[i]);
            }
            else {
                System.out.println(start+";"+i+1+"; not");
            }
        }
    }

    final class Edges{
        int u;

        int v;

        int w;

        public int getU() {
            return u;
        }

        public void setU(int u) {
            this.u = u;
        }

        public int getV() {
            return v;
        }

        public void setV(int v) {
            this.v = v;
        }

        public int getW() {
            return w;
        }

        public void setW(int w) {
            this.w = w;
        }
    }
}

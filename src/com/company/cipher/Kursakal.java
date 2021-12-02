package com.company.cipher;

import java.util.ArrayList;
import java.util.Random;
import  java.util.List;

public class Kursakal {

    int maxn = 100;
    int maxm = 10000;
    int inf = Integer.MAX_VALUE/2;
    List<Edge> a = new ArrayList();
    List<Integer> s = new ArrayList();
    List<Integer> r = new ArrayList();
    Long m, n;
    Long mst_weight = Long.MAX_VALUE;

    void init(){
        mst_weight = 0l;

    }

    public Kursakal(Long m, Long n) {
        this.m = m;
        this.n = n;
        mst_weight = 0l;
        for (int i=0; i<m; i++){
            Edge item = new Edge();
            Random r = new Random();
            item.x = r.nextInt(2)+1;
            item.y = r.nextInt(2)+1;
            item.w = r.nextInt(2)+1;
            a.add(item);
        }
    }
    void swap(Edge e1, Edge e2){
        Edge e3 = e1;
        e1 = e2;
        e2 = e3;
    }

    void qSort(int l, int r){
        int i = l;
        int j = r-1;
        Random rand = new Random();
        long ind = a.get(l+rand.nextInt(a.size()-1)).w;
         while (ind>=a.size()){
             ind--;
         }
         long x = a.get((int)ind).w;

        do{
            while (a.get(j).w >x) j--;
            while (a.get(i).w < x) i++;
            if (i<=j){
                swap(a.get(i), a.get(j));
                if (i>0 && j>0){
                    i++;
                    j--;
                }

               // break;
            }
        }
        while (i>j);
        if (i>0 && j>0){
            if (l<j) qSort(l, j);
            if (l<r) qSort(i, r);
        }

    }



    public void execute()
    {
        qSort(0, m.intValue());
        for (int i=0; i<n; i++){
            r.add(i);
            s.add(0);
        }
        int k = 0;
        long p=-1; long q = -1;
        for (int i =0; i<n-1; i++){
            do{
                k++;
                p= a.get(k).x; q = a.get(k).y;
                while (r.get((int)p)!=p){
                    p = r.get((int)p);
                }
                while (r.get((int)q)!=q){
                    q= r.get((int)q);
                }
            }
            while (q!=q);
           System.out.println(a.get(k).x+" "+a.get(k).y);
           mst_weight = mst_weight + a.get(k).w;
           if (s.get((int)p)!=s.get((int)q)){
               r.set((int)p,(int)q);
               s.set((int)q, s.get((int)p)+s.get((int)q));
           }
           else{
               r.set((int)q, (int)p);
               s.set((int)p, s.get((int)p)+s.get((int)q));
           }
        }
    }

    public Long getResult() {
        return mst_weight;
    }


    final class Edge{
       Integer x;

       Integer y;

       Integer w;

        public Integer getX() {
            return x;
        }

        public void setX(Integer x) {
            this.x = x;
        }

        public Integer getY() {
            return y;
        }

        public void setY(Integer y) {
            this.y = y;
        }

        public Integer getW() {
            return w;
        }

        public void setW(Integer w) {
            this.w = w;
        }
    }
}

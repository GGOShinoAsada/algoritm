package com.company.cipher;
import java.util.*;

public class BFSSearch {
   private int n;

   private LinkedList<Integer> items[];

    public BFSSearch(int n) {
        this.n = n;
        items = new LinkedList[n];
        for (int i = 0; i < n; ++i)
            items[i] = new LinkedList();
    }
    public void addEdge(int key, int value){
        items[key].add(value);
    }
    public void bfs(int s){
        Boolean visited[] = new Boolean[n];
        for (int i = 0; i < n; i++) {
            visited[i]=false;
        }
        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[s]=true;
        queue.add(s);
        while (queue.size() != 0)
        {
            s = queue.poll();
            System.out.print(s+" ");
            Iterator<Integer> i = items[s].listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                if (!visited[n])
                {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
}

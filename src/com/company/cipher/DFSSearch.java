package com.company.cipher;

import javax.swing.plaf.synth.SynthLookAndFeel;
import java.util.*;

public class DFSSearch {


    private int n;

    private LinkedList<Integer> items[];

    public DFSSearch(int n) {
        this.n = n;
        items = new LinkedList[n];
        for (int i = 0; i < n; ++i)
            items[i] = new LinkedList();
    }
    public void addEdge(int key, int value){
        items[key].add(value);
    }
    final void DFSUtil(int v, Boolean visited[])
    {
        visited[v] = true;
        System.out.print(v + " ");
        Iterator<Integer> i = items[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }
    public void dfs(){
        Boolean visited[] = new Boolean[n];
        for (int i = 0; i < n; i++) {
            visited[i]=false;
        }
        for (int i = 0; i < n; ++i)
            if (visited[i] == false)
                DFSUtil(i, visited);
    }

}

package com.company.cipher;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSort {
    private int value;
    private LinkedList<Integer> items[];
    public TopologicalSort(Integer item){
        value = item;
        items = new LinkedList[item];
        for (int i=0; i<item; i++)
            items[i] = new LinkedList();
    }

    /**
     * добавить новое ребро в граф
      * @param key
     * @param value
     */
    public void addEdge(int key, int value){
        items[key].add(value);
    }
    void topologicalSortUtil(int v, Boolean visited[], Stack stack){
        visited[v] = true;
        Integer i;
        Iterator<Integer> it = items[v].iterator();
        while (it.hasNext())
        {
            i = it.next();
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);
        }
        stack.push(v);
    }
    public void topologicalSort(){
        Stack stack = new Stack();
        Boolean visited[] = new Boolean[value];
        for (int i = 0; i < value; i++)
            visited[i] = false;
        for (int i = 0; i < value; i++)
            if (visited[i] == false)
                topologicalSortUtil(i, visited, stack);
        while (stack.empty()==false)
            System.out.print(stack.pop() + " ");
    }
}

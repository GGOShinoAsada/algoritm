package com.company;

import com.company.cipher.*;

public class Main {

    public static void main(String[] args) {
       Prima graph = new Prima(4 ,false);
        graph.addEdge(0, 1, 8);
        graph.addEdge(0, 2, 9);
        graph.addEdge(0, 3, 5);
        graph.addEdge(1, 2, 7);
        graph.addEdge(2, 3, 6);
        graph.print();
        //MaxSubSequence s = new MaxSubSequence();
       // int[] arr={2,1,5,3,6,4,8,9,7};
       // System.out.println(s.getResult(arr));

       //Kursakal demo = new Kursakal(3l, 3l);
      // demo.execute();
      // demo.getResult();
       // demo.print();
    }
}

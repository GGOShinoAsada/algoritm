package com.company.cipher;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class LinerSearch {
    final List<Integer> array = new ArrayList();
    public LinerSearch(){
        Random random = new Random();
        for (int i=0; i<10; i++){
            array.add(random.nextInt(10)+1);
        }
    }
    public void search(){
        System.out.println("search value: "+array.get(5));
        int search = array.get(5);
        for (int i=0; i<array.size(); i++){
            if (array.get(i)==search){
                System.out.println("element found: "+search);
                break;
            }
        }
    }
}

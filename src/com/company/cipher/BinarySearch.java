package com.company.cipher;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BinarySearch {
    List<Integer> array = new ArrayList();
    public BinarySearch(){
        for (int i=0; i<10; i++){
            Random random = new Random();
            array.add(random.nextInt(10)+1);
        }
    }
    public void search(){
        int start = 0;
        int searchValue = array.get(4);
        System.out.println("search value: "+searchValue);
        int end = array.size()-1;
        int currentIndex = -1;
        while (start<end){
            int data = (start+end)/2;
            if (array.get(data)<searchValue){
                start = data+1;
            }
            else if (start>end){
                end = data-1;
            }
            else {
                currentIndex = data;
                break;
            }
        }
        if (currentIndex>0){
            System.out.println("value found: "+array.get(currentIndex));
        }
        else {
            System.out.println("value not found");
        }
    }
}

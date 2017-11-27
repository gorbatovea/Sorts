package Sorts;

import Interfaces.*;

import java.util.Comparator;

public class CountingSort<T extends IntKeyObject> extends AbstractSortOnComparisons<T> {

    public CountingSort(){
        super();
    }

    public void sort(T[] list) {
        int maxValue = 1;
        for (int i = 0; i < list.length; i++) {
            if (list[i].getKey() > maxValue) maxValue = list[i].getKey();
        }
        int[] count = new int[maxValue + 1];

        for (int i = 0; i < list.length; i++) {
            count[list[i].getKey()]++;
        }
        int[] objectsPositions = new int[count.length];
        int lastPosition = 0;
        for(int i = 0; i < count.length; i++){
            if (count[i] != 0) lastPosition += count[i];
            objectsPositions[i] = lastPosition - 1;
        }
        T[] sortedList = (T[])new IntKeyObject[list.length];
        for(int i = list.length - 1; i >= 0; i--){
            sortedList[objectsPositions[list[i].getKey()]--] = list[i];
        }
        for(int i = 0; i < list.length; i++){
            list[i] = sortedList[i];
        }
    }
}

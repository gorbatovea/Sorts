import java.util.*;
import Interfaces.*;
import Sorts.*;
import Structures.*;

public class Main{

    private static <S extends AbstractSortOnComparisons<T>, T extends Comparable<T>> void checkSort(T[] list, S sort) {
        T[] sortedList = Arrays.copyOf(list, list.length);
        sort.sort(sortedList);

        if (!SortUtils.isArraySorted(sortedList)) {
            System.out.print("Array: ");
            for (T aList : list) System.out.print(aList + " ");
            System.out.println();
            System.out.print(sort.getClass() + ": ");
            for (int i = 0; i < list.length; i++) {
                System.out.print(sortedList[i] + " ");
            }
            System.out.println();
            System.out.println();
        }
        else
            System.out.println(sort.getClass() + ":OK");
    }

    public static void main(String[] args) {
        /*for(int i = 0; i < 50; i++) {
            IntKeyObject[] list = SortUtils.generateArrayIntKeyObjects(100);
            checkSort(list, new CountingSort<>());
        }
        for(int i = 0; i < 50; i++) {
            Integer[] list = SortUtils.generateArray(100);
            checkSort(list, new HeapSort<>());
        }
        for(int i = 0; i < 50; i++) {
            Integer[] list = SortUtils.generateArray(100);
            checkSort(list, new MergeSort<>());
        }
        for(int i = 0; i < 50; i++) {
            Integer[] list = SortUtils.generateArray(100);
            checkSort(list, new QuickSort<>());
        }
        */
        for(int i = 0; i < 50; i++) {
            Integer[] list = SortUtils.generateArray(100);
            checkSort(list, new QuickSort<>());
        }
        System.out.println("DONE!");
    }
}

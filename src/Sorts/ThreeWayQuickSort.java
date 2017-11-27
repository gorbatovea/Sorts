package Sorts;

import java.util.Comparator;

public class ThreeWayQuickSort<T> extends AbstractSortOnComparisons<T>{
    private InsertionSort<T> nestedSort;

    public ThreeWayQuickSort(){
        super();
        nestedSort = new InsertionSort<>();
    }

    public ThreeWayQuickSort(Comparator<? super T> comparator){
        super();
        setComparator(comparator);
        nestedSort = new InsertionSort<>(comparator);
    }

    public void sort(T[] list){
        quickSort(list, 0, list.length - 1);
    }

    private void quickSort(T[] list, int left, int right){
        if (left >= right) return;
        int leftIdx = partition(list, left, right);
        int rightIdx = partition(list, leftIdx + 1, right);
        if (left <= leftIdx)
            quickSort(list, left, leftIdx);
        if (leftIdx + 1 <= rightIdx - 1)
            quickSort(list, leftIdx + 1, rightIdx - 1);
        if (rightIdx <= right)
            quickSort(list, rightIdx , right);
    }

    private int partition(T[] list, int left, int right){
        T p = list[left + (int)(Math.random() * (right - left))];//left + (right - left + 1) / 2
        int i = left, j = right;
        while (i <= j){
            while (lesser(list[i], p)) i++;
            while (greater(list[j], p)) j--;
            if (i <= j) swap (list, i++, j--);
        }
        return j;
    }
}

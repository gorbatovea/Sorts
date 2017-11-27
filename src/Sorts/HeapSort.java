package Sorts;

import Structures.ArrayPriorityQueue;
import java.util.Comparator;

public class HeapSort<T> extends AbstractSortOnComparisons<T> {
    private Comparator<T> comparator =(o1, o2) -> {
        return super.compare(o1, o2);
    };
    public HeapSort(){
        super();
    }

    public HeapSort(Comparator<? super T> comparator){
        super();
        setComparator(comparator);
    }

    public void sort(T[] list){
        ArrayPriorityQueue<T> heap = new ArrayPriorityQueue<T>(list, comparator);
        for(int i = 0; i < list.length; i++)
            list[i] = heap.extractMin();
    }
}

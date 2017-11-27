package Sorts;

import Interfaces.Numerical;

import java.util.Arrays;
import java.util.Comparator;

public class LSDSort<T extends Object & Numerical<T>> extends AbstractSortOnComparisons<T> {

    public LSDSort(){
       super();
    }

    public LSDSort(Comparator comparator){
        super();
        setComparator(comparator);
    }

    @Override
    public void setComparator(Comparator<? super T> comparator) {
        super.setComparator(comparator);
    }

    @Override
    public void sort(T[] array) {
        int range = findMaxDigitValue(array), maxDigitsAmount = findMaxDigitsAmount(array);
        for(int d = 1; d <= maxDigitsAmount; d++){
            int[] count = new int[range + 1];
            for(T object : array)   count[getDigit(object, d)]++;
            for(int i = 1; i < count.length; i++){
                 count[i] += count[i - 1];
            }
            T[] sortedArray = (T[])new Object[array.length];
            for(int i = sortedArray.length - 1; i >= 0; i--){
                sortedArray[--count[getDigit(array[i], d)]] = array[i];
            }
            array = Arrays.copyOf(sortedArray,sortedArray.length);
        }

    }

    private int getDigit(T object, int digit) {
        if (object.getDigitCount() > digit) return object.getDigit(digit);
        return 0;
    }

    private int findMaxDigitsAmount(T[] array) {
        int max = 0;
        for(T x : array){
            if (x.getDigitCount() > max) max = x.getDigitMaxValue();
        }
        return max;
    }

    private int findMaxDigitValue(T[] array) {
        int max = 0;
        for(int i = 0; i < array.length; i++){
            if (array[i].getDigitMaxValue() > max) max = array[i].getDigitMaxValue();
        }
        return max;
    }

    @Override
    protected void swap(T[] array, int i, int j) {
        super.swap(array, i, j);
    }

    @Override
    protected int compare(T firstKey, T secondKey) {
        return super.compare(firstKey, secondKey);
    }

    @Override
    protected boolean greater(T firstKey, T secondKey) {
        return super.greater(firstKey, secondKey);
    }

    @Override
    protected boolean lesser(T firstKey, T secondKey) {
        return super.lesser(firstKey, secondKey);
    }
}

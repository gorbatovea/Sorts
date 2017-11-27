import java.util.*;
import Interfaces.*;
import Sorts.*;
import Structures.*;

public class Main{

    private static <S extends AbstractSortOnComparisons<T>, T extends Comparable<T>> boolean checkSort(T[] list, S sort) {
        T[] sortedList = Arrays.copyOf(list, list.length);
        sort.sort(sortedList);

        if (!SortUtils.isArraySorted(sortedList)) {
            System.out.print("Array: ");
            for (int i = 0; i < list.length; i++) {
                System.out.print(list[i] + " ");
            }
            System.out.println();
            System.out.print(sort.getClass() + ": ");
            for (int i = 0; i < list.length; i++) {
                System.out.print(sortedList[i] + " ");
            }
            System.out.println();
            System.out.println();
            return false;
        }
        else
            System.out.println(sort.getClass() + ":OK");
        return true;
    }

    public static <S extends AbstractSortOnComparisons<SimpleString>> boolean checkSort(SimpleString[] list, S sort) {
        SimpleString[] sortedList = Arrays.copyOf(list, list.length);
        sort.sort(sortedList);

        if (!SortUtils.isArraySorted(sortedList)) {
            System.out.print("Array: ");
            for (int i = 0; i < list.length; i++) {
                System.out.print(list[i] + " ");
            }
            System.out.println();
            System.out.print(sort.getClass() + ": ");
            for (int i = 0; i < list.length; i++) {
                System.out.print(sortedList[i] + " ");
            }
            System.out.println();
            System.out.println();
            return false;
        }
        else
            System.out.println(sort.getClass() + ":OK");
        return true;
    }

    public static void main(String[] args) {
        for(int i = 0; i < 50; i++) {
            SimpleInteger[] list = SortUtils.generateSimpleInteger(5);
            checkSort(list, new LSDSort<SimpleInteger>());
        }
        System.out.println("DONE!");
    }
}

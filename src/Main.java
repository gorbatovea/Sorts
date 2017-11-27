import java.util.*;

import Interfaces.IntKeyObject;
import Interfaces.Numerical;
import Sorts.*;
import Structures.SimpleString;
import Structures.SomeIntKeyObject;

import javax.lang.model.util.SimpleElementVisitor6;

public class Main{

    public static <S extends AbstractSortOnComparisons<T>, T extends Comparable<T>> boolean checkSort(T[] list, S sort) {
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



    public static void main(String[] args) {
        for(int i = 0; i < 50; i++) {
            SimpleString[] list = SortUtils.generateSimpleString(5);
            checkSort(list, new LSDSort<SimpleString>());
        }
        System.out.println("DONE!");
    }
}

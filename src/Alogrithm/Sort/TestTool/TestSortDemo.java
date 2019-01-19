package Alogrithm.Sort.TestTool;

import Alogrithm.Sort.HeapSort.HeapSort;
import Alogrithm.Sort.InsertionSort.InsertionSort;
import Alogrithm.Sort.MergeSort.MergeSort;
import Alogrithm.Sort.ShellSort.ShellSort;

/**
 * @author Yuzhe Ma
 * @date 2019/1/18
 */
public class TestSortDemo {
    public static void main(String[] args) {
        Integer[] integers1 = IntegerTestTool.getRandomArr(0, 10000000, 100000);
        Integer[] integers2 = IntegerTestTool.copyArr(integers1);
        Integer[] integers3 = IntegerTestTool.copyArr(integers1);
        Integer[] integers4 = IntegerTestTool.copyArr(integers1);

        TestSort.testSort("HeapSort", integers1, new HeapSort());
        TestSort.testSort("InsertionSort", integers2, new InsertionSort());
        TestSort.testSort("ShellSort", integers3, new ShellSort());
        TestSort.testSort("MergeSort", integers4, new MergeSort());
    }
}

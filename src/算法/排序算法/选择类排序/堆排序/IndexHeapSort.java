package 算法.排序算法.选择类排序.堆排序;

import 数据结构.堆.IndexMaxHeap;
import 算法.排序算法.common.SortTestHelper;

/**
 * @author feichaoyu
 */
public class IndexHeapSort {

    // 使用最大索引堆进行堆排序, 来验证我们的最大索引堆的正确性
    // 最大索引堆的主要作用不是用于排序, 我们在这里使用排序只是为了验证我们的最大索引堆实现的正确性
    // 在后续的图论中, 无论是最小生成树算法, 还是最短路径算法, 我们都需要使用索引堆进行优化
    public static void sort(Comparable[] arr) {

        int n = arr.length;

        IndexMaxHeap<Comparable> indexMaxHeap = new IndexMaxHeap<Comparable>(n);
        for (int i = 0; i < n; i++) {
            indexMaxHeap.add(i, arr[i]);
        }

        for (int i = n - 1; i >= 0; i--) {
            arr[i] = indexMaxHeap.extractMax();
        }
    }

    public static void main(String[] args) {

        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("算法.排序算法.选择类排序.堆排序.IndexHeapSort", arr);
    }
}

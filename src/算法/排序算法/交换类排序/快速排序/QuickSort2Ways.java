package 算法.排序算法.交换类排序.快速排序;

import 算法.排序算法.common.SortTestHelper;
import 算法.排序算法.插入类排序.直接插入排序.InsertionSort;

/**
 * @author feichaoyu
 */
public class QuickSort2Ways {

    // 双路快速排序的partition
    // 返回p, 使得arr[l...p-1] <= arr[p] ; arr[p+1...r] >= arr[p]
    // 双路快排处理的元素正好等于arr[p]的时候要注意，详见下面的注释
    private static int partition(Comparable[] arr, int l, int r) {

        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap(arr, l, (int) (Math.random() * (r - l + 1)) + l);

        Comparable v = arr[l];

        // arr[l+1...i) <= v; arr(j...r] >= v
        int i = l + 1, j = r;
        while (true) {
            // 注意这里的边界, arr[i].compareTo(v) < 0, 不能是arr[i].compareTo(v) <= 0
            // 不加等号如果遇到相等的情况，这时候while循环就会退出，即交换i和j的值，使得对于包含大量相同元素的数组，
            // 双方相等的数据就会交换，这样就可以一定程度保证两路的数据量平衡

            // 从i开始向后遍历，如果遍历的元素e<v，则继续向后遍历，直到遍历的元素e>=v，则停止遍历
            while (i <= r && arr[i].compareTo(v) < 0) {
                i++;
            }

            // 从j开始向前遍历，如果遍历的元素e>v，则继续向前遍历，直到遍历的元素e<=v，则停止遍历
            while (j >= l + 1 && arr[j].compareTo(v) > 0) {
                j--;
            }

            if (i >= j) {
                break;
            }

            swap(arr, i, j);
            i++;
            j--;
        }

        // 此时j指向的元素是数组中最后一个小于v的元素, i指向的元素是数组中第一个大于v的元素
        swap(arr, l, j);

        return j;
    }

    // 递归使用快速排序,对arr[l...r]的范围进行排序
    private static void sort(Comparable[] arr, int l, int r) {

        // 对于小规模数组, 使用插入排序
        if (r - l <= 15) {
            InsertionSort.sort(arr, l, r);
            return;
        }

        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    public static void sort(Comparable[] arr) {

        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {

        // 双路快速排序算法也是一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("算法.排序算法.交换类排序.快速排序.QuickSort2Ways", arr);
    }
}

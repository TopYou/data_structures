package algorithms.sort.advanced_sort;

import java.sql.Array;
import java.util.Scanner;
/* TODO: 需要注意
 * 归并排序
 * 递归思想
 * 不稳定
 * 时间复杂度: 最好O(logN) 最坏：O(n^2)
 * 最后leftIndex>rightIndex时需要交换从左边最接近leftIndex的比基准值小的那一个
 */
public class MergeSort {
    private int[] assistArr;
    MergeSort(int length){
        assistArr = new int[length];
    }
    public int[] sort(int[] arr, int lo, int hi){
        if(lo>=hi){
            return arr;
        }
        int mid = (lo + hi) / 2;
        // 先递归分到最底层
        sort(arr, lo, mid);
        sort(arr,mid + 1, hi);
        // 再进行合并
        // 辅助数组开始填充数据的指针
        int i = lo;
        // 合并的第一个数组的指针
        int p1 = lo;
        // 合并的第二个数组的指针
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= hi){
            if(arr[p1]<arr[p2]){
                assistArr[i++] = arr[p1++];
            }else {
                assistArr[i++] = arr[p2++];
            }
        }
        // 未填充完毕的数据继续填充到assist中,//下面两个循环，只会执行其中的一个
        while (p1<=mid){
            assistArr[i++] = arr[p1++];
        }
        while (p2<=hi){
            assistArr[i++] = arr[p2++];
        }
        // 到现在为止，assist数组中，从lo到hi的元素是有序的，再把数据拷贝到a数组中对应的索引处
        for (int j = lo; j < hi; j++) {
            arr[j] = assistArr[j];
        }
        return arr;
    }
    public static void main(String[] args) {
        /*测试数据：
        14
        4 5 6 3 2 1 10 15 30 17 33 -10 -5 100
        * */
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            MergeSort mergeSort = new MergeSort(N);
            int[] res = mergeSort.sort(arr,0,arr.length-1);
            for (int i = 0; i < res.length; i++) {
                System.out.print(res[i]+" ");
            }
        }
    }
}

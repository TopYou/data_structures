package algorithms.sort.advanced_sort;

import java.util.Scanner;

/*
 * 快速排序
 * 不稳定
 * 时间复杂度: 最好O(logN) 最坏：O(n^2)
 * 最后leftIndex>rightIndex时需要交换从左边最接近leftIndex的比基准值小的那一个
 */
public class QuickSort {
    public static int[] sort(int[] arr, int lo, int hi){
        //不要忘记这个条件
        if(lo>=hi){
            return arr;
        }
        int partition = lo; //基准值z索引
        int leftIndex = lo; //左指针
        int rightIndex = hi; //右指针
        while (leftIndex<rightIndex){
            while (arr[leftIndex]<arr[partition] ){
                leftIndex++;
            }
            while (arr[rightIndex]>arr[partition] ){
                rightIndex--;
            }
            if(leftIndex<rightIndex){
                int tmp = arr[leftIndex];
                arr[leftIndex] = arr[rightIndex];
                arr[rightIndex] = tmp;
            }
        }
        int tmp  = arr[leftIndex];
        arr[leftIndex] = arr[partition];
        arr[partition] = tmp;
        sort(arr,lo,leftIndex-1);
        sort(arr,leftIndex+1,hi);
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
            int[] res = sort(arr,0,arr.length-1);
            for (int i = 0; i < res.length; i++) {
                System.out.print(res[i]+" ");
            }
        }
    }
}

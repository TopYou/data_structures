package algorithms.sort.advanced_sort;

import java.util.Scanner;
/*
 * 希尔排序
 * 插入排序升级，分成几组插入排序
 * 稳定
 * 时间复杂度: 最好O(logN) 最坏：O(n^2)
 * 最后leftIndex>rightIndex时需要交换从左边最接近leftIndex的比基准值小的那一个
 */
public class ShellSort {
    public static int[] sort(int[] arr){
        int N = arr.length / 2; //分组初始长度
        while (N > 0){
            for (int i = N; i < arr.length; i++) {
                for (int j = i; j >=N ; j-=N) {
                    if(arr[j]<arr[j-N]){
                        int tmp = arr[j];
                        arr[j] = arr[j-N];
                        arr[j-N] = tmp;
                    }
                }
            }
            N/=2;
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
            int[] res = sort(arr);
            for (int i = 0; i < res.length; i++) {
                System.out.print(res[i]+" ");
            }
        }
    }
}

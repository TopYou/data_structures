package algorithms.sort.primary_sort;

import java.util.Scanner;

/*
 *选择排序
 * 稳定
 * 时间复杂度O(n^2)
 */
public class SelectSort {
    public static int[] sort(int[] arr){
        for (int i = arr.length-1; i > 0; i--) {
            int maxIndex = 0;
            for (int j = 1; j <= i; j++) {
                if(arr[maxIndex]<arr[j]){
                    maxIndex = j;
                }
            }
            int tmp = arr[maxIndex];
            arr[maxIndex] = arr[i];
            arr[i] = tmp;
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

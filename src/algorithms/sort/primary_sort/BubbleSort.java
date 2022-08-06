package algorithms.sort.primary_sort;

import java.util.Scanner;

/*
*冒泡排序
* 稳定
* 时间复杂度O(n^2)
*/
public class BubbleSort {
    public static int[] sort(int[] arr){
        for (int i = arr.length-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if(arr[j]>arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
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

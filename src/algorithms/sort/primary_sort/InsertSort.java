package algorithms.sort.primary_sort;

import java.util.Scanner;

/*
 * 插入排序
 * 稳定
 * 时间复杂度O(n^2)
 */
public class InsertSort {
    public static int[] sort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j > 0; j--) {
                if(arr[j]<arr[j-1]){
                    int tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
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

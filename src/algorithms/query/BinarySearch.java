package algorithms.query;

import java.util.Scanner;
/*
 * 二分查找
 * 稳定
 * 时间复杂度O(n^2)
 */
public class BinarySearch {
    public static int query(int[] arr,int key , int lo, int hi){
        if(lo>=hi){
            return -1;
        }
        int mid  = (lo + hi) / 2;
        if(key == arr[mid]){
            return mid;
        }
        if(key < arr[mid]){
            return query(arr,key,lo,mid);
        }
        if(key > arr[mid]){
            return query(arr,key,mid+1,hi);
        }
        return -1;
    }
    public static void main(String[] args) {
        /*测试数据：
        14 10
        -10 -5 1 1 3 3 4 3 10 15 17 30 33 100
        * */
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int N = sc.nextInt();
            int key = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            int res = query(arr,key,0,arr.length);
            System.out.println(res);
        }
    }
}

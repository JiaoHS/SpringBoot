package com.xjtu.JUC;

import java.util.Stack;

/**
 * @auther coraljiao
 * @date 2019/2/19 16:44
 * @description
 */
public class TestSort2 {
    public static void main(String[] args) {
//        System.out.println(0.06+0.05);
        int[] arr = {1, 4, 5, 2, 9, 7};
//        quick_sort2(arr, 0, arr.length - 1);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }
       // maopao_Sort(arr);
        select_sort(arr,arr.length);
    }

    private static void quick_Sort(int arr[], int l, int r) {
        if (l >= r) return;
        //找出基准位置
        int position = positionIndex(arr, l, r);
        quick_Sort(arr, l, position - 1);
        quick_Sort(arr, position + 1, r);
    }

    private static int positionIndex(int[] arr, int l, int r) {
        //基准元素设为第一个
        int v = arr[l];
        //i指向基准元素的下一个，j指向最后一个元素
        int i = l + 1, j = r;
        while (true) {
            while (i <= r && arr[i] < v) i++;
            while (j > l && arr[j] > v) j--;
            //循环终止条件
            if (i > j) break;
            //交换arr[i]与arr[j]的位置
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
            i++;
            j--;
        }
        //交换基准元素与arr[j]
        int t = arr[l];
        arr[l] = arr[j];
        arr[j] = t;
        return j;

    }

    private static void maopao_Sort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                int temp = 0;
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void quick_sort2(int[] arr, int l, int r) {
        if (l >= r) return;
        //确定基准位置
        int position = positionIndex2(arr, l, r);
        //递归
        quick_sort2(arr, l, position - 1);
        quick_sort2(arr, position + 1, r);
    }

    private static int positionIndex2(int[] arr, int l, int r) {
        //将基准元素设置为第一个
        int v = arr[l];
        //i指向基准元素的下一个，j指向最后一个元素
        int i = l + 1, j = r;
        while (true) {
            while (i <= r && arr[i] < v) i++;
            while (j > l && arr[j] > v) j--;
            if (i > j) break;
            //交换arr[i]与arr[j]的位置
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        //交换基准元素与arr[j]
        int temp = arr[l];
        arr[l] = arr[j];
        arr[j] = temp;
        return j;

    }

    private static void select_sort(int[] a,int n){
        int i;        // 有序区的末尾位置
        int j;        // 无序区的起始位置
        int min;    // 无序区中最小元素位置

        for(i=0; i<n; i++) {
            min=i;

            // 找出"a[i+1] ... a[n]"之间的最小元素，并赋值给min。
            for(j=i+1; j<n; j++) {
                if(a[j] < a[min])
                    min=j;
            }

            // 若min!=i，则交换 a[i] 和 a[min]。
            // 交换之后，保证了a[0] ... a[i] 之间的元素是有序的。
            if(min != i) {
                int tmp = a[i];
                a[i] = a[min];
                a[min] = tmp;
            }
        }
        for (int i1 = 0; i1 < a.length; i1++) {
            System.out.println(a[i1]);
        }
    }
}

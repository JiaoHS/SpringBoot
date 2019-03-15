package com.xjtu.JUC;

import javax.sound.midi.Soundbank;

/**
 * @auther coraljiao
 * @date 2019/2/16 20:22
 * @description
 */
public class TestSort {
    public static void main(String[] args) {
        //sort01();
        //sort02();
        //sort03();

        int[] arr = {1, 4, 5, 2, 9, 7};
        //quick_sort(arr,0,arr.length-1);
        quick_sort2(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void sort03() {
        int[] arr = {1, 4, 5, 2, 9, 7};
        int min = 0;
        int max = arr.length - 1;
        int mid = (min + max) / 2;

    }

    private static void sort02() {
        //冒泡排序
        int temp;//定义一个临时变量
        int[] arr = {1, 4, 5, 2, 9, 7};
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j + 1] < arr[j]) {
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

    private static void sort01() {
        //冒泡排序 相邻元素两两比较，大的往后放，第一次完毕，最大值出现在了最大索引处
        int[] arr = {1, 4, 5, 2, 9, 7};
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {//-1是为了索引越界，-i是为了效率
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    /*
     * 快速排序
     *
     * 参数说明：
     *     a -- 待排序的数组
     *     l -- 数组的左边界(例如，从起始位置开始排序，则l=0)
     *     r -- 数组的右边界(例如，排序截至到数组末尾，则r=a.length-1)
     */
    private static void quick_sort(int a[], int l, int r) {
        if (l < r) {
            int i, j, x;

            i = l;
            j = r;
            x = a[i];
            while (i < j) {
                while (i < j && a[j] > x)
                    j--; // 从右向左找第一个小于x的数
                if (i < j)
                    a[i++] = a[j];
                while (i < j && a[i] < x)
                    i++; // 从左向右找第一个大于x的数
                if (i < j)
                    a[j--] = a[i];
            }
            a[i] = x;
            quick_sort(a, l, i - 1); /* 递归调用 */
            quick_sort(a, i + 1, r); /* 递归调用 */
        }
    }


    private static void quick_sort2(int arr[], int l, int r) {
        if (l >= r) return;
        //p为快速排序返回的基准的位置
        int p = partition2(arr, l, r);
        //对基准左边的数进行快排
        quick_sort(arr, l, p - 1);
        //对基准右边的数进行快排
        quick_sort(arr, p + 1, r);
    }

    private static int partition2(int[] arr, int l, int r) {
        return 0;
//        //基准元素设为第一个
//        int v = arr[l];
//        //i指向基准的下一个元素，j指向最后一个元素
//        int i = l + 1, j = r;
//        while (true) {
//            while (i <= r && arr[i] < v) i++;
//            while (j > l && arr[j] > v) j--;
//            //循环终止条件
//            if (i > j) break;
//            //交换arr[i]与arr[j]
//            int t = arr[i];
//            arr[i] = arr[j];
//            arr[j] = t;
//            i++;
//            j--;
//        }
//        //将基准元素与arr[j]交换
//        int t = arr[l];
//        arr[l] = arr[j];
//        arr[j] = t;
//        //返回基准元素所在位置
//        return j;
    }
}

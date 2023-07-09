package lanqiaobei.排序;

import java.util.Arrays;

/**
 * @author limli
 * @date 2023/1/18 10:48
 */
public class sort {
    public static void main(String[] args) {
        int[] arr = {19, 9, 4, 29, 49,30, 48};
        //BubbleSort(arr);
        //InsertSort(arr);
        SelectSort(arr);

    }
   public static void BubbleSort(int[] arr){
        //冒泡排序 每次挑选最大值放在最后
        for (int i = 0; i < arr.length-1; i++) {//循环次数
            for(int j = 0; j < arr.length-1-i;j++){//每次循环交换的值
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            System.out.println(Arrays.toString(arr));
        }
    }
    public static void InsertSort(int[] arr){
        //插入排序 依次将当前值插入到前面已经排好序的数组中 大的元素后移
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];//最小值应该放的下标
            int j = i-1;
            for(;j>=0 && arr[j] > temp;j--){
                arr[j+1] = arr[j];//大的元素后移
            }
            arr[j+1] =temp;//把小的值插入到指定位置
            System.out.println(Arrays.toString(arr));
        }
    }
    public static void SelectSort(int[] arr){
        //选择排序 第i趟把从i到尾部最小值找到 插入到i
        for (int i = 0; i < arr.length-1; i++) {
            int minIndex = i;
            for(int j = i+1;j < arr.length;j++){//找到最小值下标 与 i交换
                if(arr[j] < arr[minIndex]) minIndex = j;
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
            System.out.println(Arrays.toString(arr));
        }
    }
}

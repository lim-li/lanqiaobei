package lanqiaobei.排序;

import java.util.Arrays;

/**
 * @author limli
 * @date 2023/2/1 10:42
 */
public class 快排 {
    public static void main(String[] args) {
        int[] a = {23,54,11,44,54,55,97};
        quickSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));

    }
    public static void quickSort(int[] a,int left,int right){
        if(left > right) return;//区间擦肩而过 不用递归了
        int i = left,j = right,temp = a[left];//a[left] 作为基准点
        while(i!=j){
            while(a[j]>=temp && j>i) j--;//只要a[j]大于基准点 就往前移动
            //if(a[j]<temp && j > i) a[i++] = a[j];//把a[j]小的赋值给a[i] 并且i++
            if(j>i)a[i++]=a[j]; //if语句 a[j] < temp 可以不写因为while循环之后剩下的就是a[j] < temp的
            while(a[i]<=temp && i<j)i++;
            if(i < j && a[i]>temp) a[j--]=a[i];//把a[i]大的赋值给a[j] 并且左滑j--
        }
        a[i] = temp;//以上终止条件为i==j 将基准点的数据给a[i] a[j] 都可以 得到的结果就是基准点排好序 左边的都比基准点小 右边大
        quickSort(a,left,i-1);//基准点左边的递归排序
        quickSort(a,i+1,right);//基准点右边的递归 这两步不包括基准点
    }
}

package lanqiaobei.刷题.研_2022;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author limli
 * @date 2023/2/28 11:56
 */
public class 数位排序 {
    public static void main(String[] args) {
        //按照 数字之和进行排序
        // 如 1 到 13 的排序为：1, 10, 2, 11, 3, 12, 4, 13, 5, 6, 7, 8, 9。第 5 个数为 3
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();//n个数 第m个
//        Integer[] arr = new Integer[n+1];
//        for (int i = 1; i <= n ; i++) {
//            arr[i] = i;
//        }
//        Arrays.sort(arr,1,n+1,(o1,o2)->
//        {
//            return getsum(o1)-getsum(o2);
//        });
        //第二种方法 建立一个二维数组 第一列保存数 第二列保存数位和
        int[][] arr = new int[n+1][2];
        for(int i = 1; i <= n;i++){
            arr[i][0] = i;
            arr[i][1] = getsum(i);
        }
        Arrays.sort(arr,1,n+1,(a,b)->a[1]-b[1]);
        System.out.println(arr[m][0]);

    }
    public static int getsum(int n){
        //计算一个数的数位之和
        int ans = 0;
        while(n > 0){
            ans += n % 10;
            n /= 10;
        }
        return ans;
    }
}

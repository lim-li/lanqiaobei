package lanqiaobei.数学思维与技巧;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author limli
 * @date 2023/2/28 21:34
 */
public class 切巧克力 {
    public static int[][] arr;
    public static int n;
    public static int k;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         n = sc.nextInt();
         k = sc.nextInt();//n块蛋糕 分成k块巧克力
        arr = new int[n][2];
        for(int i = 0;i < n;i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }//arr 分别存储巧克力的长和宽

        //二分枚举 x 的边长 看是否能为多少
        //由题意得知 巧克力最大边长为10^5
        int left = 1,right = 100000;
        while(left <= right){ //循环终止 left>right
            int mid = left + (right-left)/2;
            if(fun(arr,mid) >= k){ //表示边长为mid时 足够 切成k块 这时就要增加边长
                left = mid + 1;
            }else{//不能切成k块 就要缩小边长
                right = mid -1;
            }
        }
        System.out.println(right);
    }
    public static int fun(int[][] arr, int x){//检验切成x边长的巧克力 能切成多少块
        int count = 0;
        for(int i = 0; i< n;i++){
            count += ((arr[i][0]/x) * (arr[i][1]/x));
        }
        return count ;
    }

}

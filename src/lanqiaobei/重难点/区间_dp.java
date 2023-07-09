package lanqiaobei.重难点;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author limli
 * @date 2023/3/19 14:11
 */
public class 区间_dp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] stones = new int[n + 1];//录入n堆石头的重量
        int[] presum = new int[n + 1];//前缀和数组
        int[][] dp = new int[n + 1][n + 1];//dp[i][j] 存储区间i到j这一段石头合并的最小代价
        for(int i = 0;i <= n;i++) Arrays.fill(dp[i],99);//开始的时候默认正无穷
        for(int i = 1;i <= n;i++){
            stones[i] = sc.nextInt();
            presum[i] = presum[i-1]+stones[i];//前缀和 注意stones是从下标1开始填充的
            dp[i][i] = 0;//自己和自己没有合并的意义
        }
        //开始区间dp的操作
        for(int len = 2;len <= n;len++){//1-n大区间 枚举试探很多小的区间
            for(int start = 1;start+len-1 <= n;start++){//枚举指定长度区间的起点
                int end = start+len-1;
                for(int k = start;k < end;k++){//在区间start end之间不断的去划分
                    dp[start][end] = Math.min(dp[start][end],
                            dp[start][k] + dp[k+1][end] + (presum[end]-presum[start-1]));
                }
            }
        }
        System.out.println(dp[1][n]);
    }
}

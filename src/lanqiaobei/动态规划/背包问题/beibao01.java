package lanqiaobei.动态规划.背包问题;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author limli
 * @date 2023/2/18 15:03
 */
public class beibao01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();//n个物品，背包容量为m
        int[] v = new int[n+1];
        int[] w = new int[n+1];//n个物品的大小与价值
        int[][] dp = new int[n+1][m+1];//dp[i][j] 代表前i个物品在背包容量为j的情况下最大的装载价值
        for(int i = 1;i <= n;i++){
            //读入物品的大小与价值
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }
        for(int i = 1;i <= n;i++){//依次遍历n个物品
            for (int j = 1; j <= m ; j++) {//依次穷举背包的容量
                if(j < v[i]) dp[i][j] = dp[i-1][j];//当前背包的容量小于物品的大小(装不下) 那么等于前一个物品在j容量下的价值
                else dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-v[i]]+w[i]);//装得下的情况下 比较装与不装 哪个价值大
            }
        }
        for(int[] x:dp) System.out.println(Arrays.toString(x));
        System.out.println(dp[n][m]);

        for(int i = 1;i <= m;i++){//依次穷举背包的容量
            for (int j = 1; j <= n ; j++) {//穷举容量之后遍历物品
                if(i < v[j]) dp[j][i] = dp[j-1][i];//装不下 j-1个物品在i的容量下最大价值
                else dp[j][i] = Math.max(dp[j-1][i],dp[j-1][i-v[j]]+w[j]);
            }
        }
        for(int[] x:dp) System.out.println(Arrays.toString(x));
        System.out.println(dp[n][m]);
        //用一维dp[] 数组来存储结果
        int[] dp1 = new int[m+1]; //dp1[j]代表背包容量为j的情况下 所能存储物品的最大价值为dp1[j]
        for(int i = 1;i <= n;i++){//遍历物品
            for(int j = m; j >= v[i];j--){//背包容量从大到小遍历 如果大于物品的大小 必须倒序遍历
                dp1[j] = Math.max(dp1[j],dp1[j-v[i]]+w[i]);
            }
        }
        System.out.println(Arrays.toString(dp1));
    }
}

//5 10
//2 6
//5 3
//4 5
//2 4
//3 6



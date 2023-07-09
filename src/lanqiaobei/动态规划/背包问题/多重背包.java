package lanqiaobei.动态规划.背包问题;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author limli
 * @date 2023/2/19 19:57
 */
public class 多重背包 {//每个物品有无穷个
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();//n个物品 m背包的容量
        int[] w = new int[n+1];
        int[] v = new int[n+1];//n个物品的重量w 价值v
        for(int i = 1;i <= n;i++){
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }
        int[] dp = new int[m+1];//dp[i]代表容量为i的背包最大价值
        for(int i = 1;i <= n;i++){//穷举物品
            for(int j = w[i];j <= m;j++){ //穷举背包容量 j++ 倒序遍历就是01背包
                dp[j] = Math.max(dp[j],dp[j-w[i]]+v[i]);//依次找
            }

        }
        System.out.println(Arrays.toString(dp));
        System.out.println(dp[m]);
    }
}

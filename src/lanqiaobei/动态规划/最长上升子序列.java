package lanqiaobei.动态规划;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author limli
 * @date 2023/2/15 19:20
 */
public class 最长上升子序列 {
    public static void main(String[] args) {
        int[] arr = {2,7,1,5,6,4,3,8,9};
        //dp[i] 代表长度为i的子数组最长的连续子序列
        //对于任意的肯定满足 >=1 比如 5 4 3 2 1
        //其次dp[i] = max(dp[j]+1] 其中满足 j<i 且 arr[j]<arr[i]
        //也就是找到比数组中小的元素 其所能组成最大序列基础上+1
        int[] dp = new int[arr.length];
        Arrays.fill(dp,1);//
        System.out.println(Arrays.toString(dp));
        int longest = 0;
        for(int i = 1;i < arr.length;i++){
            for(int j = 0;j < i;j++){
                if(arr[i] > arr[j]){ //满足上升的条件 在满足上升的条件里面寻找最大值再此基础上再加上1
                    dp[i] = Math.max(dp[j]+1,dp[i]);//dp[i]的推导公式
                }
            }
            longest = Math.max(longest,dp[i]);//全局最大值
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(longest);
    }
}

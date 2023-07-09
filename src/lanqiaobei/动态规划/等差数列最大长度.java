package lanqiaobei.动态规划;

/**
 * @author limli
 * @date 2023/4/22 21:44
 */
public class 等差数列最大长度 {
    /**
     * 给定一个数组，返回数组中最长等差数列的长度
     */
    public int longest(int[] nums){
        //由于数组中的值为0~500 因此公差可能为负数 最小的公差为-500 处理一下公差加上500就变成0~1000
        int n = nums.length;
        int[][] dp = new int[n][1000];//dp[i][j]代表长度为i的数组公差为j 最长等差数列的长度
        int ans = 0;
        for(int i = 1;i < n;i++){
            for(int j = 0;j < i;j++){
                int k = nums[i]-nums[j];//各个方差
                dp[i][k] = Math.max(dp[i][k],dp[j][k]+1);
                ans = Math.max(dp[i][k],ans);
            }
        }
        return ans+1;
    }
}

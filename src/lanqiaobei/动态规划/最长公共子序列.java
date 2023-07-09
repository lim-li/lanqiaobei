package lanqiaobei.动态规划;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author limli
 * @date 2023/2/15 18:16
 * 子序列 是字符串中不连续的字符
 * 子串 是字符串中连续的字符
 */
public class 最长公共子序列 {
    static int mod = (int)1e8;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();//BDCABA
        String t = sc.nextLine();//ABCBDAB
        s=s.substring(0,s.length()-1);
        //System.out.println(s);
        t=t.substring(0,t.length()-1);
        /**字符串s和t的公共最长子序列
         dp[i][j] 代表的是s[i](长度为i的s字符) 和 t[j]的公共最长子序列
         dp[i+1][j+1]==> if(s(i+1)=t(i+1)) 即s字符串的第i+1个字符和t[i+1]个字符相等 那么 dp[i+1][j+1] = dp[i][j]+1;
                         else Math.max(dp[i][j+1],dp[i+1][j]) 等于这俩个字符其中一个长度减一 最长子序列的最大值
        */
        int[][] dp = new int[s.length()+1][t.length()+1];
        for(int i = 0;i < s.length();i++){
            for(int j = 0;j < t.length();j++){
                if(s.charAt(i)==t.charAt(j)){
                    dp[i+1][j+1] = dp[i][j]+1;
                }else{
                    dp[i+1][j+1]=Math.max(dp[i][j+1],dp[i+1][j]);
                }
            }
        }
        System.out.println(dp[s.length()][t.length()]);
        for(int[] x:dp) System.out.println(Arrays.toString(x));
        long ans = 0;
        for(int[] x:dp){
            for(int i = 0;i < x.length;i++){
                if(x[i] == dp[s.length()][t.length()])ans++;
            }
        }
        System.out.println(ans%mod);
    }
}

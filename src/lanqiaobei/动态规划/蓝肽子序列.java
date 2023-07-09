package lanqiaobei.动态规划;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author limli
 * @date 2023/2/16 23:30
 */
public class 蓝肽子序列 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine().replaceAll("[A-Z]", ",$0");
//        System.out.println(s);
//        String[] s1 = s.split(",");
//        System.out.println(Arrays.toString(s1));
//        String[] split2 = sc.nextLine().split("[A-Z]");
//        System.out.println(Arrays.toString(split1));
        String s1 = sc.next();
        String s2 = sc.next();
        String str1 = s1.replaceAll("[A-Z]",",$0");
        String str2 = s2.replaceAll("[A-Z]",",$0");
        //System.out.println(str1);
        String[] srr1 = str1.split(",");
        String[] srr2 = str2.split(",");
        //System.out.println(Arrays.toString(srr1));
       // System.out.println(srr1.length);
        //因为ssr1 :LanQiaoBei 转变为数组是[, Lan, Qiao, Bei]
        int[][] dp = new int[srr1.length][srr2.length];//dp[i][j]代表的是长度i的srr1与长度为j的srr2的公共子序列的长度
        for (int i = 1; i <srr1.length ; i++) {
            for(int j = 1;j<srr2.length;j++){
                if(srr1[i].equals(srr2[j])) dp[i][j]=dp[i-1][j-1]+1;
                else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        System.out.println(dp[srr1.length-1][srr2.length-1]);
    }
}

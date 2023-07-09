package lanqiaobei.重难点;

import java.util.Scanner;

/**
 * @author limli
 * @date 2023/3/10 20:48
 * 求Cnm的值 组合数
 */
public class 组合数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(cnm1(n,m));

    }
    public static long cnm1(int n,int m){
        long ans = 1;
        //分子 n*(n-1)*...(n-m+1) 分母m*(m-1)*...2*1
        for(int i = n,j = 1;i > n-m;i--,j++){
            ans = ans*i/j;//此结果能整除 一边乘以 一边除以 防止指数爆炸
        }
        return ans;
    }


}

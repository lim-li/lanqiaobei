package lanqiaobei.排序;

import java.util.Scanner;

/**
 * @author limli
 * @date 2023/1/28 20:31
 */
public class K倍区间 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] s = new int[n];
        int[] remind = new int[k];//k的余数数组
        for (int i = 0; i < n; i++) {
            int m = scan.nextInt();
            if(i==0) s[i]=m%k;
            else s[i] = (s[i-1]+m)%k;
            remind[s[i]]++;
        }
        long res = 0;
        for (int i = 0; i < k; i++)
            res += (long) remind[i] * (remind[i] - 1) / 2;
        res += remind[0];//当前缀和本身可以余数为0 也可以
        System.out.println(res);
    }
}

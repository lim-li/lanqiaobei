package lanqiaobei.刷题.研_2022;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author limli
 * @date 2023/2/27 19:30
 */
public class 质因数个数 {
    public static long n = (long) 1e16;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //数据最大为 1E16
        long n = sc.nextLong();
        //有多少个质数 是n的约数
        // 由唯一分解定理得知 任何一个数都能写成 若干个质数相乘
        HashSet<Long> set = new HashSet<>();
        for(long i = 2; i*i <= n;i++){
            if(n % i==0){
                set.add(i);
                while(n % i == 0) n/=i;
            }
        }
        if(n>1) set.add(n);
        System.out.println(set.size());
    }

}

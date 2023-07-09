package lanqiaobei.数学思维与技巧;

import java.util.Arrays;

/**
 * @author limli
 * @date 2023/1/2 18:41
 * 主要思想：一个数是素数，那么这个数的倍数不是素数
 * 用2~sqrt(n)之间的素数去刷选倍数 标记为合数
 */
public class 埃氏筛法_素数 {
    public static void main(String[] args) {
        int n = 10000;
        boolean[] isprime = new boolean[n+1];
        Arrays.fill(isprime,true);//初始化每个数都是素数
        isprime[0] = false;
        isprime[1] = false;
        for(int i = 2;i*i <= n;i++){
            if(isprime[i]){
                for(int j = 2;j * i <= n;j++){//i的j倍，j=2,3,4...ij<=n
                    isprime[i*j] = false;
                }
            }
        }
        int count = 0;
        for(int i = 2;i <= n;i++){
            if(isprime[i]){
                count++;
                System.out.println(i);
            }
        }
        System.out.printf("从1到%d共有%d个素数",n,count);
    }

}

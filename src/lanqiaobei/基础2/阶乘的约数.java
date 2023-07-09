package lanqiaobei.基础2;

import java.util.Arrays;

/**
 * @author limli
 * @date 2023/1/6 10:42
 * 阶乘约数的个数：任何数都可以分解为多个素数的乘积
 * 阶乘得到的数很大
 * 比如 12 = 2*2*3 = 2^2*3^1 约数个数就为 各个素数的次方+1相乘 即(2+1)*(1+1) = 6个：1,2,3,4,6,12
 * 特殊的 如果5 = 5^1 ：1+1=2 即1,5
 *
 * 求100阶乘约数个数即为求每个数 素数分解后 素数个数+1相乘的结果
 */
public class 阶乘的约数 {
    public static void main(String[] args) {
        int n = 100;
        //4*3*2*1=4!
        int[] ans = new int[n+1];//用来下标表示存储n的素数约数
        long sum = 1;//统计n的阶乘之后约数的个数 乘法的初始值应该为1
        for(int i = 2;i <= n;i++){
            int bak = i;//将i的值做一下标记 因为会变
            for(int j = 2;j * j <= bak;j++){
                while(bak % j == 0){
                    ans[j]++;
                    bak /= j;
                }
            }
            if(bak > 1) ans[bak]++;
        }
        System.out.println(Arrays.toString(ans));//24 100!有24个5 也就是尾数有24个0
        for (int i = 0; i < ans.length; i++) {
            if(ans[i]!=0){
                sum *= (ans[i]+1);
            }
        }
        System.out.println(sum);//39001250856960000 100!的约数个数
    }
}

package lanqiaobei.刷题;

import java.util.Scanner;

/**
 * @author limli
 * @date 2023/2/26 15:50
 */
public class 乘积尾零 {
    public static void main(String[] args) {
        //俩个数相乘 查看可以分解出来多少5 前提是分解出来的2比5多 就是有多少个0
        // 观察题目所给数据 2的个数 可能要比5少 因此计算俩者数量的最小值 即为答案（注意一下，但是题中5 还是比2 少）
        Scanner sc = new Scanner(System.in);
        int ans5 = 0;
        int ans2 = 0;
        for(int i = 0;i < 100;i++){
            int a = sc.nextInt();
            ans5 += fun5(a);
            ans2 += fun2(a);
        }
        System.out.println(ans2);
        System.out.println(ans5);
        System.out.println(Math.min(ans2,ans5));

    }
    public static int fun5(int n){
        //此函数查看分解5的个数
        int count = 0;
        while(n%5==0){//n/5的结果还可能是5的倍数
            count++;
            n /= 5;
        }
        return count;
    }
    public static int fun2(int n){
        //此函数查看分解5的个数
        int count = 0;
        while(n % 2 == 0){
            count++;
            n /= 2;
        }
        return count;
    }
}

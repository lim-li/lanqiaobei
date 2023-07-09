package lanqiaobei.重难点;

import java.util.Scanner;

/**
 * @author limli
 * @date 2023/3/8 18:55
 * 数本身是素数 且 各位相加之和也是素数
 */
public class 美素数 {
    public static void main(String[] args) {
        //1 用欧拉打表 打出100万以内的素数 x/ln(x) 7.8万个
        int MAX = 1000005;
        int[] prime = new int[80000];//一百万的数据 有不超过8万个素数
        boolean[] isp = new boolean[MAX];//isp[i] = false 代表是素数
        isp[0] = isp[1] = true;//0 和 1 都是合数
        int count = 0;//打表记录有多少素数
        for(int i = 2;i < MAX;i++){
            if(isp[i] == false) prime[count++] = i;
            for(int j = 0;j < count && i * prime[j] < MAX;j++){//j取的是素数的个数 i代表的是分别的倍数
                isp[i*prime[j]] = true;
                if(i % prime[j] == 0) break;//保证每个合数都被他最小的素因子筛选一次
            }
        }
        //2 美素数前缀和打表 打出所有的美素数 并做前缀和处理
        int[] beauty = new int[MAX];//beauty[i] 在i之前有多少个(包括n) 美素数
        for(int i = 2 ; i < MAX;i++){
            if(isp[i] == false && isp[getSum(i)] == false) beauty[i] = beauty[i-1] + 1;
            else beauty[i] = beauty[i-1];
        }
        //开始题目的测试
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//n组测试数据
        int left=0,right = 0;
        for(int i = 1;i <= n;i++){
            left = sc.nextInt();
            right = sc.nextInt();
            //包括left 所以left-1
            System.out.println(beauty[right] - beauty[left-1]);
        }

    }
    public static int getSum(int n){//计算n的各位数字之和
        int count = 0;
        while (n > 0){
            count += n % 10;
            n /= 10;
        }
        return count;
    }

}

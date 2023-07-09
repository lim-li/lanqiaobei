package lanqiaobei.基础1;

import java.util.Scanner;

/**
 * @author limli
 * @date 2023/1/7 16:51
 */
public class 求阶乘 {
    public static void main(String[] args) {
       // System.out.println(fun(Long.MAX_VALUE));//2305843009213693937 long值得最大值有这么多的0
        //写个二分 在5 ~Long.MAX_VALUE之间查找
        Scanner sc = new Scanner(System.in);
        long k = sc.nextLong();
        System.out.println(solve(k));

    }

    static long solve(long k) {
        long l = 5, r = Long.MAX_VALUE - 5;
        while (l <= r) {
            long mid = l + (r - l) / 2;
            if (fun(mid) > k) {
                r = mid - 1;
            } else if (fun(mid) < k) {
                l = mid + 1;
            }else if(fun(mid)==k){//找到了 不返回 寻找左边界(最小值)
                r = mid - 1;
            }
        }
        return fun(l) == k ? l:-1;
    }

    static long fun(long n) {//求一个数的阶乘 尾数有多少0
        long count = 0;
        while (n > 0) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }
}

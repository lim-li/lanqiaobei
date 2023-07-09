package lanqiaobei.基础2;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * @author limli
 * @date 2023/1/3 16:15

 * 如果一个元素 x属于 F, 则 3x+2、5x+3 和 8x+5 都属于集合 F 。
 * 最小的 5 个 Fibonacci 数 1,2,3,5,8 属于集合 F 。
 * 则集合第2020小的元素
 */
public class fib集合 {
    public static void main(String[] args) {
        HashSet<BigInteger> set = new HashSet<>();//存储不重复元素
        PriorityQueue<BigInteger> q = new PriorityQueue<>();

        set.add(BigInteger.valueOf(1));
        q.add(BigInteger.valueOf(1));
        set.add(BigInteger.valueOf(2));
        q.add(BigInteger.valueOf(2));
        set.add(BigInteger.valueOf(3));
        q.add(BigInteger.valueOf(3));
        set.add(BigInteger.valueOf(5));
        q.add(BigInteger.valueOf(5));
        set.add(BigInteger.valueOf(8));
        q.add(BigInteger.valueOf(8));
        int cnt = 0;

        while(true) {
            BigInteger x = q.poll();
            cnt++;
            //System.out.println(x);
            if (cnt == 2020){
                System.out.println(x);
                return;
            }

            BigInteger w[] = {
                    BigInteger.valueOf(3).multiply(x).add(BigInteger.valueOf(2)),
                    BigInteger.valueOf(5).multiply(x).add(BigInteger.valueOf(3)),
                    BigInteger.valueOf(8).multiply(x).add(BigInteger.valueOf(5)),};
            for (int i = 0; i < 3; i++) {
                if (!set.contains(w[i])) {
                    set.add(w[i]);
                    q.add(w[i]);
                }
            }
        }

    }
}

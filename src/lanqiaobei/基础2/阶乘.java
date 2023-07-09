package lanqiaobei.基础2;

import java.math.BigInteger;

/**
 * @author limli
 * @date 2023/1/3 15:50
 * 2021*2019*2017...*3*1的后四位
 */
public class 阶乘 {
    public static void main(String[] args) {
        fun(2021);
    }
    public static void fun(int n) {
        BigInteger a = new BigInteger("1");
        //BigInteger b = BigInteger.valueOf(1);第二种赋值
        for (int i = 1; i <= n; i += 2) {
            a = a.multiply(BigInteger.valueOf(i));
        }
        String s = a.toString();
        System.out.println(s);
        System.out.println(s.substring(s.length()-4));

    }
}

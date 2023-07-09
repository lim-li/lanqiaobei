package lanqiaobei.日期;

import java.math.BigInteger;

/**
 * @author limli
 * @date 2023/1/7 16:05
 * 已知今天是星期六，请问 20^22
 * 天后是星期几?
 *
 * 注意用数字 1 到 7 表示星期一到星期日。
 */
public class 星期计算 {
    public static void main(String[] args) {
//        long n = 20^22;
//        System.out.println(n%7);
//        long nn = 20;
//        long sum = 1;
//        for(int i = 1;i <= 22;i++){
//            sum *= nn;
//        }
//        System.out.println(sum);//7974907369840705536
//        System.out.println(sum%7);
        BigInteger a = BigInteger.valueOf(1);
        BigInteger b = BigInteger.valueOf(20);
        for(int i = 1;i <= 22;i++){
            a=a.multiply(b);
        }
        System.out.println(a.toString());//41943040000000000000000000000
        BigInteger mo = BigInteger.valueOf(7);
        System.out.println(a.remainder(mo));//1

    }
}

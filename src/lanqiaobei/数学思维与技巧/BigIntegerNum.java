package lanqiaobei.数学思维与技巧;

import java.math.BigInteger;

/**
 * @author limli
 * @date 2023/1/2 10:56
 */
public class BigIntegerNum {
    public static void main(String[] args) {
        BigInteger b = BigInteger.valueOf(1);
        BigInteger sum = new BigInteger("0");
        for(int i = 1;i < 64;i++){
            b = b.multiply(new BigInteger("2"));
            sum = sum.add(b);
        }
        System.out.println(sum.add(new BigInteger("1")));

    }
}

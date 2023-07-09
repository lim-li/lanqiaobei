package lanqiaobei.数学思维与技巧;

import java.math.BigInteger;

/**
 * @author limli
 * @date 2023/1/3 11:06
 */
public class 大数_阶乘 {
    public static void main(String[] args) {
        //输出一百的阶乘 并统计 结尾有多少个0
        fun(200);
        /**100的阶乘 这么大 158位 且后面0的个数为24位
         * 933262154439441526816992388562667004907159682643816214685929638952175999932299156
         * 08941463976156518286253697920827223758251185210916864000000000000000000000000
         */
        fun2(200);

    }
    public static void fun2(int n){//n的阶乘尾数0的个数
        int count = 0;
        while(n > 0){
            count += n / 5;
            n /= 5;
        }
        System.out.println(count);


    }
    public static void fun(int n){
        int count=0;
        BigInteger a = new BigInteger("1");
        //BigInteger b = BigInteger.valueOf(1);第二种赋值
        for(int i = 2;i <= n;i++){
            a = a.multiply(BigInteger.valueOf(i));
        }
        String s = a.toString();
        System.out.println(s);
        for(int i = s.length()-1;i >= 0;i--){
            if (s.charAt(i)!='0'){
                break;
            }
            count++;
        }
        System.out.println(count);
        System.out.println(s.length());
    }
}

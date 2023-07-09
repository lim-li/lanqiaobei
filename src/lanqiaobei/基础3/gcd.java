package lanqiaobei.基础3;

/**
 * @author limli
 * @date 2022/12/5 18:29
 * 计算俩个数的最大公约数和最小共倍数
 */

public class gcd {

    public static void main(String[] args) {
        int a = 16,b=24;
        System.out.println(gcd1(a,b));
        System.out.println(get(a,b));

    }

    /**例如：
     * 24 16
     * 16 8
     * 8 0
     * 8
     */
    public  static int  gcd1(int a,int b){//辗转相除
        if(b==0) return a;
        return gcd1(b,a%b);
    }
    public static int get(int a,int b){//两个数相乘除以最大公约数 即是 最小共倍数
        return a*b/gcd1(a,b);
    }

}

package lanqiaobei.基础1;

import java.util.Scanner;

/**
 * @author limli
 * @date 2023/1/2 10:09
 */
public class TwoBigNumAdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        String ans = "";
        a = new StringBuffer(a).reverse().toString();
        b = new StringBuffer(b).reverse().toString();
        int len = a.length() > b.length() ? a.length() : b.length();
        int jw = 0;//进位提前定义

        for (int i = 0; i <= len; i++) {//i <= len 最后有一位有进位 999 +1 多循环一次就可以进位算进去
            int ai = i < a.length() ? a.charAt(i) - '0' : 0;
            int bi = i < b.length() ? b.charAt(i) - '0' : 0;
            int num = ai + bi + jw;
            int remind = num % 10;
            jw = num / 10;
            ans = remind + ans;//注意这里 是每算出来一位加上ans 最后结果不用翻转了
        }
        //if(jw == 1) ans = jw + ans; 如果循环写成i<len
        System.out.println(ans);
    }
}

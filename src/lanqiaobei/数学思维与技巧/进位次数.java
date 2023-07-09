package lanqiaobei.数学思维与技巧;

import java.util.Scanner;

/**
 * @author limli
 * @date 2022/12/29 11:03
 */
public class 进位次数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        //输出a+b需要进位几次
        int count = 0,jw = 0;
        for(int i = 0;i < 9;i++){
            jw = (a%10 + b%10 + jw) >= 10 ? 1:0;
            count += jw;
            a /= 10;
            b /= 10;
        }
        System.out.println(count);
    }
}

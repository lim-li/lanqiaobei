package lanqiaobei.基础3;

import java.util.Scanner;

/**
 * @author limli
 * @date 2022/12/18 20:22
 * 给定一个年份，判断这一年是不是闰年。
 *
 * 当以下情况之一满足时，这一年是闰年：
 *
 * 1. 年份是4的倍数而不是100的倍数；
 *
 * 2. 年份是400的倍数。
 *
 * 其他的年份都不是闰年。
 */
public class ruiNian {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }
    }
}

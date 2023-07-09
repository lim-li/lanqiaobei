package lanqiaobei.基础2;

import java.util.Scanner;

/**
 * @author limli
 * @date 2023/1/3 12:05
 * 1 月到 12 月英文的前三个字母分别是 Jan、Feb、Mar、Apr、May、 Jun、Jul、Aug、Sep、Oct、Nov、Dec:
 * 本题也可以用数组存储日期的字母
 */
public class 日期 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        switch (a) {
            case 1:
                System.out.print("Jan");
                break;
            case 2:
                System.out.print("Feb");
                break;
            case 3:
                System.out.print("Mar");
                break;
            case 4:
                System.out.print("Apr");
                break;
            case 5:
                System.out.print("May");
                break;
            case 6:
                System.out.print("Jun");
                break;
            case 7:
                System.out.print("Jul");
                break;
            case 8:
                System.out.print("Aug");
                break;
            case 9:
                System.out.print("Sep");
                break;
            case 10:
                System.out.print("Oct");
                break;
            case 11:
                System.out.print("Nov");
                break;
            case 12:
                System.out.print("Dec");
                break;
            default:
                break;

        }
        System.out.print(b<10?"0"+b:""+b);
    }
}


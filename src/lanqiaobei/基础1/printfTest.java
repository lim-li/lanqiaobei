package lanqiaobei.基础1;

import java.util.Scanner;

/**
 * @author limli
 * @date 2022/12/27 11:51
 */
public class printfTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double pi = 3.1415926535;
        System.out.printf("%.6f",pi);
        System.out.printf("%."+n+"f",pi);//保留n位小数
    }
}

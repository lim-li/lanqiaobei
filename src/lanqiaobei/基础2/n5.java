package lanqiaobei.基础2;

import java.util.Scanner;

/**
 * @author limli
 * @date 2022/12/19 15:02
 * 定义阶乘 n! = 1 × 2 × 3 × · · · × n
 * 请问 100!（100的阶乘）有多少个正约数。
 */
public class n5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        System.out.println(fic(2));


        scan.close();
    }
    public static long fic(int n){
        if(n == 1){
            return 1;
        }
       return fic(n-1)*n;
    }

}

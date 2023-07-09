package lanqiaobei.基础2;

import java.util.Scanner;

/**
 * @author limli
 * @date 2023/1/3 16:03
 * p进制的乘法表
 */
public class 乘法表 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int p = scanner.nextInt();
        for(int i = 1;i < p;i++){
            for(int j = 1;j <= i;j++){
                System.out.print(i+"*"+j+"="+Integer.toString(i*j,p)+" ");
            }
            System.out.println();
        }
    }
}

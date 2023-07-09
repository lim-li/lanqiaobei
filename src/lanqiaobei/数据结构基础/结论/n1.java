package lanqiaobei.数据结构基础.结论;

import java.util.Scanner;

/**
 * @author limli
 * @date 2022/12/27 16:57
 * 两个正整数p,q且互质，那么凑不出来的最大正整数为(p-1)*(q-1)-1
 */
public class n1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        int q = sc.nextInt();
        System.out.println((p-1)*(q-1)-1);

    }
}

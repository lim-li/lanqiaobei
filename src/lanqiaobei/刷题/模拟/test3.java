package lanqiaobei.刷题.模拟;

import java.util.Scanner;

/**
 * @author limli
 * @date 2023/3/5 19:33
 */
public class test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int n = sc.nextInt();
        int mod = n % 7;
        int ans = (w+mod)%7;
        System.out.println(ans);
    }
}

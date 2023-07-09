package lanqiaobei.刷题;

import java.net.SocketTimeoutException;
import java.util.Scanner;

/**
 * @author limli
 * @date 2023/3/1 21:31
 */
public class 饮料换购 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = n;
        while(n >= 3){
            int mod = n % 3;//兑换剩的
            int temp = n/3;//能兑换的
            ans += temp;//总和
            n = temp + mod; // 还能兑换的
        }
        System.out.println(ans);
    }
}

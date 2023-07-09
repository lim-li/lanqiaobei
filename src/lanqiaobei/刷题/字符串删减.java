package lanqiaobei.刷题;

import java.util.Scanner;

/**
 * @author limli
 * @date 2023/3/7 21:53
 * 连续三个 x 要删除使其个数小于3
 */
public class 字符串删减 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        int ans = 0;
        for(int i = 2; i < s.length();i++){
            if(s.charAt(i)=='x' && s.charAt(i-1) == 'x' && s.charAt(i-2) == 'x')ans++;
        }
        System.out.println(ans);
    }
}

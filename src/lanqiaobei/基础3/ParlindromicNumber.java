package lanqiaobei.基础3;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 回文数 且各位之和为定数
 * @author limli
 * @date 2022/11/17 21:29
 */
public class ParlindromicNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        for(int i = 10000;i < 1000000;i++){
            if(ispNumber(i).get(0).equals(i)  && ispNumber(i).get(1).equals(n1)){
                System.out.println(i);
            }
        }
        sc.close();
    }
    public static ArrayList ispNumber(int n){
        ArrayList<Integer> list = new ArrayList<>();
        int ans = 0;
        int num = 0;
        while(n > 0){
            int a = n % 10;
            ans = ans*10 + a;
            num += a;
            n /= 10;
        }
        list.add(ans);
        list.add(num);
        return list;
    }
}

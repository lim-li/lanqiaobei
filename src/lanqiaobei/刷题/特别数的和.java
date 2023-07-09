package lanqiaobei.刷题;

import java.util.Scanner;

/**
 * @author limli
 * @date 2023/2/21 22:38
 */
public class 特别数的和 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        for(int i = 1;i <= n;i++){
            if(fun(i)){
                sum += i;
            }
        }
        System.out.println(sum);
    }
    public static boolean fun(int n){
        while(n>0){
            int b = n % 10;
            if(b==2 || b==0 || b==1 || b==9) return true;
            n /= 10;
        }
        return false;
    }
}

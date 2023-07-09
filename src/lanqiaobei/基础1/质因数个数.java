package lanqiaobei.基础1;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author limli
 * @date 2023/1/2 11:49
 */
public class 质因数个数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        HashSet<Long> set = new HashSet<>();
        for(long i = 2;i*i<=n;i++){
            if(n % i == 0){
                set.add(i);
            }
            while(n%i==0) n/=i;
        }
        if(n > 1) set.add(n);
        System.out.println(set.size());
    }
}

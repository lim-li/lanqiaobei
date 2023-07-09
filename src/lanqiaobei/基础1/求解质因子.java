package lanqiaobei.基础1;

import java.util.*;

/**
 * @author limli
 * @date 2023/1/6 11:36
 * n<=10^12
 */
public class 求解质因子 {
    public static void main(String[] args) {
        Set<Long> set= new TreeSet<>();
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        for (long i = 2; i <= n/i; i++) {
            while(n % i == 0){
                set.add(i);
                n /= i;
            }
        }
        if(n > 1) set.add(n);

        Iterator<Long> it = set.iterator();
        while(it.hasNext()){
            System.out.print(it.next() + " ");
        }

    }

}

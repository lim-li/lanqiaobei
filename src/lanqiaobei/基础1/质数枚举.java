package lanqiaobei.基础1;

import java.util.ArrayList;

/**
 * @author limli
 * @date 2023/1/1 19:05
 */
public class 质数枚举 {
    public int[] closestPrimes(int left, int right) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i =left; i <=right ; i++) {
            if(isPrime(i))
                list.add(i);
        }
        int[] res = new int[]{1,0};
        int min = Integer.MAX_VALUE;
        for(int i = 0;i < list.size()-1;i++){
            if(list.get(i+1) - list.get(i) < min)
                min = list.get(i+1) - list.get(i);
                res[0] = list.get(i);
                res[1] = list.get(i+1);
        }
        return res;
    }

    private boolean isPrime(int n){
        if(n==1){
            return false;
        }
        for (int i = 2; i*i <= n; i++) {
            if(n % i == 0) return false;
        }
        return true;
    }
}

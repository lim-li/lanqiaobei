package lanqiaobei.分治算法;

import java.util.ArrayList;

/**
 * @author limli
 * @date 2023/2/7 23:34
 */
public class 货物摆放 {
    public static void main(String[] args) {
        ArrayList<Long> list = new ArrayList<>();
        long n=2021041820210418l ;//先找到其因子
        for(long i = 1; i <= Math.sqrt(n); i++){
            if(n%i==0){
                list.add(i);
                long m = n / i;
                if(i != m) list.add(m);
            }
        }
        //System.out.println(list.size()); 128
        int ans = 0;
        for(int i = 0;i < list.size();i++){
            for (int j = 0; j < list.size(); j++) {
                if(n%(list.get(i)*list.get(j))==0){
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }

}

package lanqiaobei.基础3;

import java.util.ArrayList;

/**
 * @author limli
 * @date 2022/11/26 16:38
 * // 2021041820210418 这个数显然非常大 int 最大为2^31-1 约为21亿
 * 所以先找到其因子 在因子里面进行for循环
 */
public class 货物摆放 {
    public static void main(String[] args) {
        long sc = 2021041820210418l;
        //存放因子
        ArrayList<Long> list = new ArrayList<>();

        for(long j = 1;j <= Math.sqrt(sc);j++){ //开根方 降低复杂度
            if(sc % j == 0){
                list.add(j);
                long n = sc / j;
                //求另一部分 并且去重复的根
                if( j != n){
                    list.add(n);
                }
            }

        }
        //System.out.println(list.size());
        int sum = 0;
        for (int i=0;i< list.size();i++){
            for(int j=0;j< list.size();j++){
                if(sc %  (list.get(i)* list.get(j)) == 0)
                    sum++;

                }
            }
        System.out.println(sum);
    }
}

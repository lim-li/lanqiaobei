package lanqiaobei.基础1;

import java.util.HashSet;

/**
 * @author limli
 * @date 2023/1/1 18:24
 */
public class 质数分解 {
    public int distinctPrimeFactors(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(Integer a:nums){
            for(int i = 2;i*i < a;i++){
                if(a % i == 0){//仔细感觉这里 每次都找到的是小的质因数
                    set.add(i);
                    while(a % i == 0) a /= i;//把这个质因数 一下除去完
                }
            }
            if(a > 1) set.add(a);//如果最后a 还大于1 说明i没有取完所有的因子
        }
        return set.size();
    }
}

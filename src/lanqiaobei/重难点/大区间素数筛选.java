package lanqiaobei.重难点;

import java.util.Arrays;

/**
 * @author limli
 * @date 2023/3/5 15:18
 * 2<=a<b<=10^12
 * b-a <= 10^6
 */
public class 大区间素数筛选 {
    public static void main(String[] args) {
       int a = 1,b= 100000;//模拟测试范围9592
        //埃氏筛法算出sqrt(b)以内的素数 然后用这个素数去筛选[a,b]的合数
        boolean[] isPrimeSmall = new boolean[(int)Math.sqrt(b) + 5];
        //[0,b-a] 跟原始的[a,b]做映射
        boolean[] isPrimeBig = new boolean[b - a + 5];
        Arrays.fill(isPrimeBig,true);
        Arrays.fill(isPrimeSmall,true);//用true假定这些数都是素数
        for (int i = 2; i*i <=b ; i++) {//b的最大素因子接近sqrt(b) 除了本身
            if(isPrimeSmall[i] == true)//i是素数则 2i 3i 4i ...ki<=sqrt(b) 不是素数
            {
                for(int j = 2;i * j < isPrimeSmall.length;j++){//j是指定倍数 由于是筛选b长度的 j最大取sqrt(b)
                    isPrimeSmall[i*j] = false;//不是素数
                }
                //映射到大区间[a,b] 排除它的合数 (a-1+i)/i*i 表示大于a的第一个能被i除干净的数 j+i也是 i的倍数也是非素数
                for(int j = Math.max(2,(a-1+i)/i)*i;j <= b;j = j+i){
                    isPrimeBig[j-a] = false;//映射到大区间的数在数组间的位置
                }
            }
        }
        int count = 0;
        for(int i = 0;i < (b-a);i++){
            if(isPrimeBig[i] == true && i+a>=2){//i+a>=2防止a=1
                count++;
            }
        }
        System.out.println(count);
    }
}

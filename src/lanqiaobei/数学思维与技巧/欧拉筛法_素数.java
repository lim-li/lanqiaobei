package lanqiaobei.数学思维与技巧;

/**
 * @author limli
 * @date 2023/1/3 10:12
 * 核心思想：某个合数被最小的素数所筛选 且被筛选一遍
 */
public class 欧拉筛法_素数 {
    public static void main(String[] args) {
        final int Max = 100;
        int[] prime = new int[Max];//存储具体的素数
        //isp 中初始化默认为false 也就是素数默认为false
        boolean[] isp = new boolean[Max+5];//标记下标对应的数 是否为素数 是否为某个素数的倍数
        int count = 0;//素数个数
        for (int i = 2; i <= Max ; i++) {
            if(isp[i]==false)prime[count++] = i;//如果i是素数 那么存入到prime里面 且count加1
            for(int j = 0;j < count&&i*prime[j]<=Max;j++){
                isp[i*prime[j]] = true;//素数prime[j] 是素数 i倍也是素数
                if(i % prime[j] == 0) break; //精髓
            }

        }
        for (int i = 0; i < count; i++) {
            System.out.println(prime[i]);
        }
        System.out.printf("从1到%d共有%d个素数",Max,count);
    }
}

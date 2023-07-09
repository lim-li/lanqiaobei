package lanqiaobei.搜索.dfs;

import java.util.Scanner;

/**
 * @author limli
 * @date 2023/2/11 10:06
 */
public class 整数划分dfs {
    public static int ans;//记录总划分的次数
    public static int cnt;//记录dfs调用的次数
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        ans=0;//因为使用全局变量 重新运行时要重新赋值
        cnt=0;
        dfs(n,k,1,"");
        System.out.println("方案数"+ans);
        System.out.println("调用dfs次数"+cnt);
    }

    /**
     *整数 n 划分为k份的的方案
     * @param n 整数
     * @param k 划分为k分
     * @param min 构造的是非降序的数列 保证 1 1 5 而不是 511 目前被拆分的最大值 下次拆分可用的最小值
     * @param fanan 方案数
     */
    public static void dfs(int n,int k,int min,String fanan){
        cnt++;//调用dfs的次数
        if(k==1 && min<=n){ //当划分的次数还剩一下 且 可用的最小值小于n 满足方案
            ans++;
            System.out.println(fanan+n);//这里的n是最后一下的值 不是原始的n
            return;
        }
        //剪枝
        if(min*k>n) return;//如果当前可使用的min和需要剪枝的次数大于 这个数可用的 那么肯定不成立直接去掉
        for (int i = min; i <= n; i++) {
            dfs(n-i,k-1,i,fanan+i+"+");//最小值依次递增 n-i,剩余可划分的数值 k-- 次数依次减小 i就相当于min
        }


    }
}

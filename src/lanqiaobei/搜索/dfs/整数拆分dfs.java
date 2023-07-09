package lanqiaobei.搜索.dfs;

/**
 * @author limli
 * @date 2023/2/11 11:18
 */
public class 整数拆分dfs {
    public static void main(String[] args) {
        dfs(4,0,0,"");

    }

    /**
     * dfs模拟整数拆分的过程
     * @param n
     * @param nowget 当前已经使用的数值总和
     * @param maxused 当前是构造的 最大的整数 因为要保持持续递增的
     * @param ans 结果保存
     */
    public static void dfs(int n,int nowget,int maxused,String ans){
        if(nowget==n){//数值总和等于 n
            ans=ans.substring(0,ans.length()-1);
            System.out.println(n+"="+ans);
            return;
        }
        //开枝散叶 for循环横向 dfs纵向
        for(int i = 1;i <= n-nowget;i++){ //累加到n 目前已经累加到nowget
            //if语句 就是保证递增序列 当前的i 要保证大于上一步i传递所保存的maxused
            if(i >= maxused) dfs(n,nowget+i,i,ans+i+"+");//n不变 nowget要加上i maxused 就是当前的i
        }
    }
}

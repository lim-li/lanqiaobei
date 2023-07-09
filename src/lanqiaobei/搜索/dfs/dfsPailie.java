package lanqiaobei.搜索.dfs;

/**
 * @author limli
 * @date 2023/2/10 21:54
 */
public class dfsPailie {
    public static void main(String[] args) {
       dfs(0,"",3);

    }
    public static void dfs(int depth,String ans,int n){
        if(depth == n){
            System.out.println(ans);
            return;
        }
        for(int i = 1;i <= n;i++){
            if(!ans.contains(""+i)){//剪枝
                dfs(depth+1,ans+i,n);
            }

        }
    }
}

package lanqiaobei.刷题;

import java.util.*;

/**
 * @author limli
 * @date 2023/3/5 11:33
 */
public class 不同路径数 {
    static int N = 10,n,m,k;
    static int a [][]  = new int [N][N];
    static int dx[] = {-1, 1, 0, 0},dy[] = {0 , 0, -1, 1};
    static Set<Integer> hash = new HashSet<>();
    //cnt 表示行动的次数  num 表示行动到第cnt次后的数是什么

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        for(int i = 1 ; i <= n ; i ++)
            for(int j = 1 ; j <= m ; j ++)
                a[i][j] = sc.nextInt();
        //枚举每个起点
        for(int i = 1 ; i <= n ; i ++)
            for(int j = 1 ; j <= m ; j ++)
                dfs(i,j,0,a[i][j]);

        System.out.print(hash.size());
    }

    private static void dfs(int x, int y, int cnt, int num) {
        if(cnt == k){
            hash.add(num);
            return ;
        }
        for(int i = 0;i < 4;i++){
            int tx = x + dx[i];
            int ty = y + dy[i];
           if(tx>=1 && tx <= n && ty>=1 && ty <= m){
               dfs(tx,ty,cnt+1,num*10 + a[tx][ty]);
           }
        }
    }

}

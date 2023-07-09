package lanqiaobei.刷题.模拟;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author limli
 * @date 2023/3/5 21:05
 */
public class 滑行 {
    public static int[][] g ;
    public static int max,n,m,dianMax=0,count=0;//最大滑行距离
    public static int step=0;
    public static boolean[][] vis ;//是否被走过
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,1,-1};
    public static boolean flag = false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        g = new int[n][m];
        vis = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                g[i][j] = sc.nextInt();
            }
        }
        for(int[]x:g) System.out.println(Arrays.toString(x));
        dfs(1,0);
        System.out.println(dianMax);
    }
    //x y 代表当前点 step走到当前点所用的距离
    public static void dfs(int x ,int y){
        if(ing(x,y)){
            dianMax = Math.max(step,dianMax);//这个点的最大滑行距离
            return;
        }
        vis[x][y] = true;
        step++;
        for(int i = 0;i < 4;i++){
            int tx = dx[i]+x;
            int ty = dy[i]+y;
            if(ing(tx,ty) && g[tx][ty] < g[x][y]){
                dfs(tx,ty);
            }else{
                count++  ;
            }
        }

    }
    public static boolean ing(int x,int y){//判断当前点是否在矩阵内
        return x>=0 && x<n && y >= 0 && y < m;
    }
}

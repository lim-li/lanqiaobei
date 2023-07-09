package lanqiaobei.图论;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author limli
 * @date 2023/2/28 19:29
 */
public class 蓝桥公园_floyd {
    public static  long inf = Long.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int Q = sc.nextInt(); //n个景点 m条路径 q个观影计划
        long[][] g = new long[N+1][N+1];//邻接矩阵
        for(int i = 1;i <= N;i++){
            for (int j = 1; j < N+1; j++) {//初始化
                if(i == j) g[i][j] = 0;//自己到自己的距离
                else g[i][j] = inf;//其他的都先设置为无穷大 表示不可达
            }
        }
        //读取可达的bian
        for(int i = 1;i <= M;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            g[u][v]=g[v][u]=Math.min(g[u][v],w);
        }
        //弗洛伊算法 求解任意顶点之间的边的最小距离
        for(int k = 1;k <= N;k++){
            for(int i = 1; i <= N;i++){
                for(int j = 1;j <= N;j++){
                    if(g[i][k] < Long.MAX_VALUE && g[k][j] < Long.MAX_VALUE && i!=j && i!=k && k!=j)
                         g[i][j] = Math.min(g[i][j],g[i][k]+g[k][j]);
                }
            }
        }
       // for(long[] x:g)System.out.println(Arrays.toString(x));
        for(int i = 1;i <= Q;i++){
            int st = sc.nextInt();
            int sd = sc.nextInt();
            if(g[st][sd] >= inf) System.out.println(-1);
            else System.out.println(g[st][sd]);
        }

    }
}

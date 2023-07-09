package lanqiaobei.图论;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author limli
 * @date 2023/3/2 13:04
 */
public class 蓝桥王国_Dijkstra {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        long[][] g = new long[N + 1][N + 1];//邻接矩阵
        long[] dis = new long[N+1];//距离最小的数组
        int[] vis = new int[N+1];//是否作为中转点了 松弛点
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j < N + 1; j++) {//初始化
                if (i == j) g[i][j] = 0;//自己到自己的距离
                else g[i][j] = Long.MAX_VALUE;//其他的都先设置为无穷大 表示不可达
            }
        }
        for (int i = 1; i <= M; i++) {//读取边权值
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            g[u][v] = Math.min(g[u][v], w);
            g[v][u] = Math.min(g[v][u], w);
        }
        //for(long[] x:g) System.out.println(Arrays.toString(x));
        //Dijkstra算法
        for(int i = 1; i <= N;i++)  dis[i] = g[1][i];
        vis[1] = 1;//本身作为中转点了
        for(int i = 1; i < N;i++){//n-1次循环 到达每个点都要寻找一下最小值
            long min = Long.MAX_VALUE;
            //寻找最小的中转点
            int minIndex = 0;
            for(int j = 1; j <= N;j++){
                if(dis[j] < min && vis[j] != 1){//如果此中转点距离小 且之前没有被作为中转点
                    min = dis[j];
                    minIndex = j;
                }
            }
            vis[minIndex] = 1;//将此标记为已经是中转点了
            //寻找到中转点之后 判断是直达近 还是中转近
            for(int j = 1;j <= N;j++){ //中转点 是minIndex --> j
                if(g[minIndex][j] < Long.MAX_VALUE && j != minIndex){//点j与中转点是否可达 且 不是同一个点
                    dis[j] = Math.min(dis[j],dis[minIndex]+g[minIndex][j]);
                }
            }
        }
        //System.out.println(Arrays.toString(dis));
        for(int i = 1;i <= N;i++){
            if(dis[i]!=Long.MAX_VALUE){
                System.out.print(dis[i]+" ");
            }else
                System.out.println(-1 + " ");
        }
    }
}

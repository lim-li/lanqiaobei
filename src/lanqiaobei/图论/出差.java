package lanqiaobei.图论;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author limli
 * @date 2023/3/6 21:35
 * 这一题主要是 g数组的变形 也就是同一条路 a->b 和 b->a的权值 不一样
 */
public class 出差 {
    public static int[][] g;
    public static int[] dis;
    public static int[] vis;//是否已经被作为中转点了
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();//n个城市
        int[] time = new int[N+1];//记录每个城市的隔离时间
        for(int i = 1;i <= N;i++) time[i] = sc.nextInt();
        g = new int[N+1][N+1];//n个城市的通行权值
        dis = new int[N+1];//距离数组
        vis = new int[N+1];//是否为松弛点
        //g数组的初始化
        for(int i = 1;i <= N;i++){
            for (int j = 1; j <=N ; j++) {
                if(i==j) g[i][j] = 0;
                else g[i][j] = Integer.MAX_VALUE;//不可达
            }
        }
        //读取权值
        for(int i = 1 ; i <= M;i++){//线路信息 其中a->b 的权值等于路途距离 加上b隔离的时间
            int u = sc.nextInt();
            int v = sc.nextInt();
            int c = sc.nextInt();
            g[u][v] = c+time[v];
            g[v][u] = c+time[u];
        }
        //开始迪杰斯特拉算法
        for(int[] x:g) System.out.println(Arrays.toString(x));
        for(int i = 1;i <= N;i++) dis[i] = g[1][i];//1到其他顶点距离
        vis[1] = 1;//这个点用过啦
        //for 最外层 需要几次
        for(int i = 1;i < N;i++){
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            //dis里面招最小的
            for(int j = 1;j <= N;j++){
                if(dis[j] < min && vis[j] == 0){
                    min = dis[j];
                    minIndex = j;
                }
            }
            vis[minIndex] = 1;
            //找到最小的 看看是否需要中转
            for(int j = 1;j <= N;j++){
                if(g[minIndex][j] < Integer.MAX_VALUE && minIndex!=j){
                    dis[j] = Math.min(dis[j],dis[minIndex] + g[minIndex][j]);
                }
            }
        }
        //到最后一个城市不需要隔离 因此减去
        System.out.println(dis[N]-time[N]);

    }

}

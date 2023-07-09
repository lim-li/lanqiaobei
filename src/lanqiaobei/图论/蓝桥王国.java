package lanqiaobei.图论;

import java.util.Scanner;

/**
 * @author limli
 * @date 2023/2/28 20:12
 */
public class 蓝桥王国 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        long[][] g = new long[N + 1][N + 1];//邻接矩阵
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
        //弗洛伊算法 求解任意顶点之间的边的最小距离
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (g[i][k] != Long.MAX_VALUE && g[k][i] != Long.MAX_VALUE && i != j && i != k && k != j)
                        g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            if (g[1][i] != Long.MAX_VALUE) System.out.printf(g[1][i] + " ");
            else System.out.printf("-1" + " ");
        }
    }
}

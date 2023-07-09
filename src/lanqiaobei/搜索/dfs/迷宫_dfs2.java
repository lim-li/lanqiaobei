package lanqiaobei.搜索.dfs;

import java.util.Scanner;

/**
 * @author limli
 * @date 2023/2/27 9:48
 * 4 6
 * #.####
 * #.#.##
 * #...@#
 * ######
 * @表示入口 #表示围墙 .表示可行走的路径 靠近边缘的.便是能出去的位置
 * 求解 最小能出去的步数 如果不能输出-1
 */
public class 迷宫_dfs2 {
    public static int n;
    public static int m;//行和列
    public static char[][] maze;//存储
    public static boolean[][] vis;//是否访问
    public static boolean flag = false;//是否能走出去
    public static int minStep = Integer.MAX_VALUE;//最小步数
    public static int step = 0;//步长
    public static int[][] dis = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        maze = new char[n][m];
        vis = new boolean[n][m];
        int x = 0,y = 0;
        for(int i = 0;i < n;i++){
            String str = sc.next();
            int j = str.indexOf('@');
            if(j != -1){
                x = i;
                y = j;
            }
            maze[i] = str.toCharArray();
        }
        sc.close();
        dfs(x,y);
        minStep = flag ? minStep : -1;
        System.out.println(minStep);
    }
    public static boolean inMaze(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }

    public static void dfs(int x, int y) {
        if (step > minStep)
            return;
        if (maze[x][y] == '.' && (x == 0 || x == n - 1 || y == 0 || y == m - 1)) {
            flag = true;
            minStep = Math.min(minStep, step);
            return;
        }
        vis[x][y] = true;
        step++;
        for (int i = 0; i < 4; i++) {
            int tx = x + dis[i][0];
            int ty = y + dis[i][1];
            if (inMaze(tx, ty) && !vis[tx][ty] && maze[tx][ty] != '#') {
                dfs(tx, ty);
            }
        }
        vis[x][y] = false;
        step--;
    }
}

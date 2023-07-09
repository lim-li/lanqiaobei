package lanqiaobei.搜索;

import java.util.Scanner;

/**
 * @author limli
 * @date 2023/2/27 10:55
 */
public class test {


    public static int n;
    public static int m;
    public static boolean flag = false;
    public static int step = 0;
    public static int minStep = Integer.MAX_VALUE;
    public static char[][] maze;
    public static boolean[][] vis;
    public static int[][] dir = new int[][]{
            {1, 0}, {0, -1}, {0, 1}, {-1, 0}
    };
    public static char[] dis = new char[]{'D','L','R','U'};
    public static String S = "";

    public static boolean in(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }

    public static void dfs(int x, int y) {
        if (step > minStep)
            return;
        //出口
        if (x==(n-1) && y == (m-1) ) {
            flag = true;
            minStep = Math.min(minStep, step);
            return;
        }
        vis[x][y] = true;
        step++;
        for (int i = 0; i < 4; i++) {
            int tx = x + dir[i][0];
            int ty = y + dir[i][1];
            if (in(tx, ty) && !vis[tx][ty] && maze[tx][ty] != '1') {
                S += dis[i];
                dfs(tx, ty);
            }
        }
        S = S.substring(0,S.length());
        vis[x][y] = false;
        step--;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        maze = new char[n][m];
        vis = new boolean[n][m];
        int x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            maze[i] = str.toCharArray();
        }
        sc.close();
        dfs(x, y);
        int ans = flag ? minStep : -1;
        System.out.println(ans);
    }
}



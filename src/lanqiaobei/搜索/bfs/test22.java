package lanqiaobei.搜索.bfs;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author limli
 * @date 2023/2/27 15:19
 */
class Node1 { //记录走到哪个点了
    int x;
    int y;
    int step;

     Node1(int x, int y, int step) {
        this.x = x;
        this.y = y;
        this.step = step;
    }

}
public class test22 {

    public static int n;
    public static int m;
    public static char[][] maze;
    // 标记是否走过
    public static boolean[][] vis;
    // 能移动的方向，用数组表示更方便
    public static int[][] dir = new int[][]{
            {-1, 0}, {0, -1}, {1, 0}, {0, 1}
    };

    // 判断是否在迷宫内
    public static boolean inMaze(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }

    public static int bfs(int sx, int sy) {
        Deque<Node1> que = new LinkedList<>();
        // 先将初始位置加入队列，并标记为走过
        que.offer(new Node1(sx, sy, 0));
        vis[sx][sy] = true;
        while (!que.isEmpty()) {
            Node1 currNode = que.pop();
            if (maze[currNode.x][currNode.y] == 'T')
                return currNode.step;
            // 将所有能走的位置加入队列
            for (int i = 0; i < 4; i++) {
                int tx = currNode.x + dir[i][0];
                int ty = currNode.y + dir[i][1];
                if (inMaze(tx, ty) && !vis[tx][ty] && maze[tx][ty] != '*') {
                    vis[tx][ty] = true;
                    que.offer(new Node1(tx, ty, currNode.step + 1));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        maze = new char[n][m];
        vis = new boolean[n][m];
        int sx = 0, sy = 0;
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            // 获取起始位置
            int j = str.indexOf('S');
            if (j != -1) {
                sx = i;
                sy = j;
            }
            maze[i] = str.toCharArray();
        }
        sc.close();
        int ans = bfs(sx, sy);
        System.out.println(ans);
    }


}



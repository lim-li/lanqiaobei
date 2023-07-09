package lanqiaobei.搜索.dfs;

import java.util.Scanner;

/**
 * @author limli
 * @date 2023/2/26 20:00
 * 迷宫类的题目 考试中经常出现 一定练会
 例子：地图如下所示
            3 4
            S**.
            ..*.
            ***T
    3行4列 S代表入口 T代表出口 *代表墙 .代表路
 1.dfs 判断能否走出来
 2.判断出来所走的最小步数  如果无法走出输出-1





 */
public class 迷宫_dfs {
    public static int n;
    public static int m;//定义迷宫的行数和列数
    public static char[][] maze;//定义一个二维char数组 来存储迷宫
    public static boolean[][] vis;//标记走过的位置

    //用一个数组代表走的四个方向 {-1,0}左 {0,-1}下 {1,0}上 {0,1}右
    public static int[][] dir = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};

    //最少步数 走出迷宫
    public static boolean flag = false;
    public static int step = 0;
    public static int minStep = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();//行数
        m = sc.nextInt();//列数
        maze = new char[n][m];
        vis = new boolean[n][m];
        //S 字符代表迷宫的入口 要存储一下他的位置
        int x = 0, y = 0;//存储入口的坐标
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            int start = str.indexOf('S');
            if (start != -1) {//如果这一行含有S入口
                x = i;
                y = start;
            }
            maze[i] = str.toCharArray();//把迷宫的每一列进行存储
        }
        System.out.println(dfs(x,y));
    }

    // 判断是否还在迷宫内
    public static boolean inMaze(int x, int y) {
        return (0 <= x && x < n && 0 <= y && y < m);
    }
    //防止兜圈子 需要二维数组进行用来标记走过的地方 vis如上定义的全局变量

    public static boolean dfs(int x,int y){
        //出口
        if(maze[x][y] == 'T'){
            return true;
        }
        vis[x][y] = true;//表示此位置被访问
        for(int i = 0; i < 4;i++){//循环向四个方向访问
            int tx = x + dir[i][0];
            int ty = y + dir[i][1];
            if(inMaze(tx,ty) && !vis[tx][ty] && maze[tx][ty] != '*' ){//此点 在数组内 没有被访问 且不是墙
                if(dfs(tx,ty)) return true;//重新进入递归 如果if(true) 返回true; if(false) 会访问其他节点 以及回溯
            }
        }
        return false;
    }

}

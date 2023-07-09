package lanqiaobei.搜索.bfs;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author limli
 * @date 2023/3/9 20:48
 * 从左上到右下的最短步数
 */
class node{
    int x;
    int y;
    int step;
    String lu;

    public node(int x, int y, int step, String lu) {
       // super();
        this.x = x;
        this.y = y;
        this.step = step;
        this.lu = lu;
    }
}
public class 迷宫_bfs练习 {
    public static int minStep;//最短步数
    static int xsize = 30;
    static int ysize = 50;
    public static char[][] g ;
    public static boolean[][] vis;
    public static char[] sign = {'D','L','R','U'};//下 左 右 上
    //在g中x代表行 向下x+1 y不变 以此类推
    public static int[] dx = {1,0,0,-1};
    public static int[] dy = {0,-1,1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        g = new char[xsize][ysize];
        vis = new boolean[xsize][ysize];
        for(int i = 0;i < xsize;i++){
            g[i] = in.readLine().toCharArray();
        }
        for(char[] x:g) System.out.println(Arrays.toString(x));
        out.println(bfs(0,0));
        out.println(minStep);
        out.flush();


    }
    public static String bfs(int x ,int y){//起点填进去
       Queue<node> q = new LinkedList<>();
       minStep = 0;
       q.add(new node(x,y,minStep,""));
       while(!q.isEmpty()){
           node now = q.poll();
           vis[now.x][now.y] = true;
           for(int i = 0;i < 4;i++){
               int xx = now.x + dx[i];
               int yy = now.y + dy[i];
               if(ing(xx,yy) && vis[xx][yy] == false && g[xx][yy] == '0'){
                   q.add(new node(xx,yy,now.step+1,now.lu+sign[i]));
                   if(xx == xsize-1 && yy == ysize-1){
                       minStep = now.step+1;//要走出来 加上这个点
                       return now.lu + sign[i];
                   }
               }
           }
       }
       return "";
    }
    public static boolean ing(int x,int y){
        return x >= 0 && x < xsize && y >= 0 && y < ysize;
    }
}

package lanqiaobei.图论;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 8 9
 0 1
 0 2
 1 3
 1 4
 1 5
 3 4
 2 6
 2 7
 6 7
 * @author limli
 * @date 2023/2/25 14:55
 */
public class 图的dfs_bfs {
    public static int n = 0,m = 0;//n个顶点 m条边
    public static int[][] g;//邻接矩阵存储图的顶点和边
    public static int[] visit;//用来记录哪些边被访问了
    public static int vcount=0;//记录多少顶点被访问了
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();//n个顶点m条边
        g = new int[n][n];//二维矩阵 边边之间关系
        visit = new int[n];//存放结点被访问
        for(int i = 0; i < m;i++){
            int from = sc.nextInt();
            int to = sc.nextInt();
            g[from][to] = 1;
            g[to][from] = 1;//无向图 邻接矩阵的特点
        }
      // for(int[] x:g) System.out.println(Arrays.toString(x));
       //visit[0]=1;//标记0结点已被访问
       gdfs(0);
      //  gbfs();
    }
    public static void gbfs(){
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);//默认是把0丢进去
        visit[0] = 1;//标记0已经被访问了
        while(!q.isEmpty()){
            int head = q.poll();
            System.out.print(head + ">");
            for(int i = 0;i < n;i++){
                if(g[head][i]==1 && visit[i]==0){//head与i连通且i未被访问
                    q.add(i);
                    visit[i]=1;
                }
            }
        }
    }
    public static void gdfs(int nownode){
        System.out.print(nownode + ">");//先输出当前结点
        visit[nownode] = 1;
        vcount++;//表示被访问
        if(vcount==n) return;//dfs出口
        for(int i = 0;i < n;i++){//n个相邻的顶点全部跑一遍，没有访问过得 而且挨着才能开支散叶
            if(g[nownode][i]==1&&visit[i]==0){//连通且没有被访问
               // visit[i] = 1;
                gdfs(i);
            }
        }
    }
}

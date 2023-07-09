package lanqiaobei.刷题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 图一般有两种存储方式：
 *
 * 邻接矩阵。开个二维数组，g[i][j] 表示点 i 和点 j 之间的边权。
 * 邻接表。邻接表有两种常用写法，我推荐第二种，代码更简洁，效率也更高，后面有代码模板：
 * (1) 二维List：List<List<Integer>> edge，edge[i][j] 表示第 i 个点的第 j 条邻边。
 * (2) 数组模拟邻接表：为每个点开个单链表，分别存储该点的所有邻边。
 *
 * 本题是没有环的图 就是一颗树
 * 本题是求树的直径
 * 用邻接表进行存储
 */
public class 大臣的旅费 {
    static int n ;
    private static List<Node2>[] g;//数组模拟邻接表
    public static int maxfarNode;//从指定结点出发所能到的最远结点
    private static long max = -1;
    public static boolean[] vis ;//某个点是否被访问
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         n = sc.nextInt();
         vis = new boolean[n+1];
         g = new List[n+1];//编号是从1开始的
        for (int i = 1; i <= n ; i++) {
            g[i] = new ArrayList<Node2>();//初始化数组的值
        }
        for(int i = 0 ;i < n-1;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            g[a].add(new Node2(b,c));//代表的含义是 下标为a的点 到 b点的距离 为c
            g[b].add(new Node2(a,c));//双向的
        }
        dfs(1,0);//找直径的一个端点 可以得知 maxfarnode
        Arrays.fill(vis,false);//上面走过要全部清空呀
        dfs(maxfarNode,0);//找另一个端点的同时max也得知了
        System.out.println(max);
        System.out.println((11+11+max-1)*max/2);
    }
    //num 起始城市 dis目前所走的距离
    public static void  dfs(int num,int dis){
        if(vis[num]) return;
        vis[num] = true;//标记访问这个点
        for(int i = 0;i < g[num].size();i++){//这个点的邻接表存储的Arraylist大小
            int child = g[num].get(i).num;//取与他有通路的点
            int length = g[num].get(i).dis;//距离
            if(vis[child]) continue;//这个点被取过 跳过
            if(dis + length > max){
                max = dis + length;
                maxfarNode = child;
            }
            dfs(child,dis+length);//一条路走到黑
        }

    }
}
  class Node2 {
    int num;//编号
    int dis;//两点间的距离

    public Node2(int num, int dis) {
        this.num = num;
        this.dis = dis;
    }
}



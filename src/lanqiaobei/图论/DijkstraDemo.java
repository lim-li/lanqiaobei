package lanqiaobei.图论;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author limli
 * @date 2023/3/2 9:53
 *  求图中俩点之间的最小距离
 6 9
 0 1 1
 0 2 12
 1 2 9
 1 3 3
 2 4 5
 3 2 4
 3 4 13
 3 5 15
 4 5 4
 */
public class DijkstraDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vn = sc.nextInt();
        int en = sc.nextInt();
        int[][] g = new int[vn][vn];
        int[] dis = new int[vn]; //dis[i] 存放起点v[i] 到其他点 v[j] 目前探测的最小距离
        int[] vis = new int[vn];//松弛顶点 也就是是否经过该节点中转过
        for (int i = 0; i < vn; i++) {
            for (int j = 0; j < vn; j++) {
                if(i == j) g[i][j] = 0;
                else g[i][j] = 999;//不可达 初始化
            }
        }
        for (int i = 0; i < en; i++) {//读取边的权值
            g[sc.nextInt()][sc.nextInt()] = sc.nextInt();
        }
        sc.close();
        for(int[] x:g) System.out.println(Arrays.toString(x));
        // 这个初始化 表示的是0节点 到其他 节点的距离 所以最后结果也只是0节点到其他节点的最小距离
        for (int i = 0; i < vn;i++) dis[i] = g[0][i];//初始化距离数组
        vis[0] = 1;//标记已经松弛过了 使用过
        // 开始迪杰斯特拉 算法
        int minIndex = 0;//记录当前 v0到哪一个点距离最小（未松弛过得点）
        for(int i = 0;i < vn-1;i++){//
            int min = 999;
            for(int j = 0;j < vn;j++){//dis数组找最小的 未松弛过得点
                if(vis[j]==0 && dis[j] < min){
                    min = dis[j];
                    minIndex = j;//记录最小顶点的编号
                }
            }
            vis[minIndex] = 1; //找到最小的标记一下 接下来通过它松弛
            for(int j = 0;j < vn;j++){
                if(g[minIndex][j] < 999 && minIndex != j){
                    dis[j] = Math.min(dis[j],dis[minIndex] + g[minIndex][j]);
                }
            }
        }
        System.out.println(Arrays.toString(dis));//[0, 1, 8, 4, 13, 17]表示结点0到其他节点最小距离
    }
}

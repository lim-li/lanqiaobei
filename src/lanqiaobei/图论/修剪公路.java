package lanqiaobei.图论;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author limli
 * @date 2023/3/1 20:34
 * 最小生成树的应用
 */
public class 修剪公路 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);//n个小区 M条路
        long[][] g = new long[n+1][n+1];
        long[] dis = new long[n+1];//当前最小生成树到其他顶点的距离
        //初始化
        for(int i = 1;i <= n;i++){
            for (int j = 1; j <= n; j++) {
                if(i!=j) g[i][j] = g[j][i] = Long.MAX_VALUE;//不可达
            }
        }
        for(int i = 1 ; i <= m;i++){
            String[] s1 = in.readLine().split(" ");
            int u = Integer.parseInt(s1[0]);
            int v = Integer.parseInt(s1[1]);
            int w = Integer.parseInt(s1[2]);
            g[u][v] = g[v][u] = Math.min(g[u][v],w);//边的真正权值
        }
        //for(long[] x:g) System.out.println(Arrays.toString(x));
        //prime算法
        //假设以1结点开始
        for(int i = 1; i <= n;i++) dis[i] = g[1][i];
        dis[1] = 0;//表示1已经加入最小生成树
        //System.out.println(Arrays.toString(dis));
        long ans = 0;
        for(int j = 1;j < n;j++){//n个顶点 要寻找n-1条边
            long min=Long.MAX_VALUE;
            int minIndex=-1;
            for (int i = 1; i <= n; i++) {
                if(dis[i]<min && dis[i]!=0){//要注意此点还没有加入最小生成树 这个条件dis[i]!=0
                    min = dis[i];
                    minIndex = i;
                }
            }
            dis[minIndex] = 0;
            ans += min;
            //要更新dis数组
            for(int i = 1; i <= n;i++){
                dis[i] = Math.min(dis[i],g[minIndex][i]);
            }
        }
        //判断所有节点是否都加入最小生成树
        boolean flag = true;
        for(int i = 1;i <= n;i++){
            if(dis[i] != 0){
                flag = false;
                System.out.println(-1);
            }
        }
        if(flag) System.out.println(ans);

    }
}

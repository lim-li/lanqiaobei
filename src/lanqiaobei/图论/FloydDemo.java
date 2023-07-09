package lanqiaobei.图论;

import java.util.Scanner;

/**
 * @author limli
 * @date 2023/2/28 19:00
 * floyd 求图中任意俩个结点的最短距离
 */
public class FloydDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vn = sc.nextInt();
        int en = sc.nextInt();//vn 顶点 en边
        int[][] g = new int[vn][vn];//邻接矩阵
        for(int i = 0; i < vn;i++){
            for(int j = 0;j < vn;j++){
                if(i == j) g[i][j] = 0;//自己到自己的距离
                else g[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < en; i++) {
            g[sc.nextInt()][sc.nextInt()] = sc.nextInt();//把边的权值附上
        }
        //两个端点间的距离 可以用以下表示 加上k就是不是直达 需要中转
//        for (int i = 0; i < vn; i++) {
//            for (int j = 0; j < vn; j++) {
//                //if (g[i][k] < Integer.MAX_VALUE && g[k][j] < Integer.MAX_VALUE && i != j && i != k && k != j)
//                    g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
//            }
//        }
        // 弗洛伊德算法
        for(int k = 0;k < vn;k++){
            for(int i = 0;i < vn;i++){
                for (int j = 0; j < vn; j++) {
                    if(g[i][k] < Integer.MAX_VALUE && g[k][j] < Integer.MAX_VALUE && i!=j && i!=k && k!=j) //加不加这个判断都可以
                        g[i][j] = Math.min(g[i][j],g[i][k]+g[k][j]);
                }
            }
        }


    }
}

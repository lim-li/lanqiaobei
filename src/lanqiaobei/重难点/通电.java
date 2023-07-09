package lanqiaobei.重难点;

import java.util.Arrays;
import java.util.Scanner;


/**
 * @author limli
 * @date 2023/3/7 19:31
 * 最小生成树的应用  prime
 */
public class 通电 {
    public static double[][] g;
    public static double[] dis;//图 和 距离数组
    public static int[][] D;//存储各个点的坐标
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        g = new double[n][n];
        dis = new double[n];
        D = new int[n][3];
        for(int i = 0;i < n;i++){
            D[i][0] = sc.nextInt();
            D[i][1] = sc.nextInt();
            D[i][2] = sc.nextInt();
        }
        //计算任意俩点之间的距离
        for(int i = 0; i < n;i++){
            for (int j = 0; j < n; j++) {
                if(i == j) continue;
                else{
                   int x = D[i][0]-D[j][0];
                   int y = D[i][1]-D[j][1];
                   int h = D[i][2]-D[j][2];
                   g[i][j] = Math.sqrt( x*x + y*y)+h*h;
                }
            }
        }
       // for(double[] x:g) System.out.println(Arrays.toString(x));
        //开始prime算法
        for(int i = 0; i < n;i++) dis[i] = g[0][i];//从0开始
        dis[0] = 0;//表示0加入最小生成树
        double ans = 0;
        for(int i = 1;i < n;i++){//需要n-1条边
            double min = Double.MAX_VALUE;
            int minIndex = -1;
            //找没加入最小生成树的点
            for(int j = 0;j < n;j++){
                if(dis[j] < min && dis[j] != 0){
                    min = dis[j];
                    minIndex = j;
                }
            }
            ans += min;
            dis[minIndex] = 0;
            //更新 由于min加入 更新dis 数组
            for(int j = 0;j < n;j++){
                dis[j] = Math.min(dis[j],g[minIndex][j]);
            }

        }
        System.out.printf("%.2f",ans);
        int[] ans1 = new int[2];
        Arrays.sort(ans1);

    }

}

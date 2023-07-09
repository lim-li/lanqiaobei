package lanqiaobei.刷题.模拟;

import java.util.Scanner;

/**
 * @author limli
 * @date 2023/3/5 20:01
 */
public class 灯塔 {
    public static int[][] g;
    public static boolean[][] vis;
    public static void main(String[] args) {
        //查看 每一个点是否被灯塔所覆盖
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int h = sc.nextInt();
        int n = sc.nextInt();
        int r = sc.nextInt();//w宽 h高 n灯塔的个数 r半径
        g = new int[w+1][h+1];
        vis = new boolean[w+1][h+1];
        int ans = 0;
        //对于每一个灯塔覆盖的范围 查看图中的点是否在里面
        for(int i = 0; i < n;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            for(int j = 0;j <= w;j++){
                for(int z = 0; z<= h;z++){
                    if(Math.sqrt((j-x)*(j-x)+(z-y)*(z-y)) <= r && !vis[j][z]){//俩点距离小于半径 且 没有被覆盖
                        ans++;
                        vis[j][z] = true;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}

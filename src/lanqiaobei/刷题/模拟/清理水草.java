package lanqiaobei.刷题.模拟;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author limli
 * @date 2023/3/5 20:34
 */
public class 清理水草 {
    public static int[][] g ;
    public static boolean[][] vis;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int t = sc.nextInt();
        g = new int[n+1][m+1];
        vis = new boolean[n+1][m+1];
        for(int i = 0;i < t;i++){
            int r1 = sc.nextInt();
            int c1 = sc.nextInt();
            int r2 = sc.nextInt();
            int c2 = sc.nextInt();
            for(int j = r1; j <= r2;j++){
                for(int z = c1;z <= c2;z++){
                    vis[j][z] = true;
                }
            }
        }
//        for(boolean[] x:vis){
//            System.out.println(Arrays.toString(x));
//        }
        int ans = 0;
        for(boolean[] x:vis){
            for(int i = 0;i < x.length;i++){
                if(!x[i]) ans++;
            }
        }
        System.out.println(ans-(n+m+1));
    }
}

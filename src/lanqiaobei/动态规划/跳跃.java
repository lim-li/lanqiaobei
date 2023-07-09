package lanqiaobei.动态规划;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author limli
 * @date 2023/2/18 16:47
 */
public class 跳跃 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);//n行m列的数据
        int[][] arr = new int[n+1][m+1];
        int[][] dp = new int[n+1][m+1];//
        for(int i = 1;i <= n;i++){
            String[] s1 = in.readLine().split(" ");
            for(int j = 1;j <= m;j++){
                arr[i][j] = Integer.parseInt(s1[j-1]);
            }
        }
       // for(int[] x:arr) System.out.println(Arrays.toString(x));
        //dp[i][j] 代表i行j列最大的权值和 其可由9个位置推导而来
        int[] x = {-1,-2,-3,0,0,0,-1,-2,-1};
        int[] y = {0,0,0,-1,-2,-3,-2,-1,-1};//这个位置的点变化 要学习一下
        for(int i = 1;i <= n;i++){
            for(int j = 1;j <= m;j++){
                if(i==1&&j==1) dp[i][j]=arr[i][j];//初始化
                else {
                    for(int k = 0;k < 9;k++){
                        int lastX = i + x[k];
                        int lastY = j + y[k];//当前位置 可由哪些位置得来
                        if(lastX>=1 && lastX<=n && lastY>=1 && lastY <= m){//位置合法
                            dp[i][j] = Math.max(dp[i][j],dp[lastX][lastY]+arr[i][j]);//要么等于0,要么等于前面可到达此点权值和最大加上本身
                        }
                    }
                }
            }
        }
        //for(int[] x1:dp) System.out.println(Arrays.toString(x1));
        System.out.println(dp[n][m]);

    }
}

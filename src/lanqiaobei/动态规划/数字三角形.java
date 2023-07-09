package lanqiaobei.动态规划;

        import java.util.Arrays;
        import java.util.Scanner;

/**
 * @author limli
 * @date 2023/2/16 21:57
 */
public class 数字三角形 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n+1][n+1];
        for(int i = 1;i <= n;i++){
            for(int j = 1;j <= i;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        //for(int[] x:arr) System.out.println(Arrays.toString(x));
        //System.out.println("====");
        //int[]
        int[][] dp = new int[n+1][n+1];
        for(int i = 1;i <= n;i++){
            for(int j = 1;j <= i;j++){
                dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-1])+arr[i][j];
            }
        }
        //for(int[] x:dp) System.out.println(Arrays.toString(x));
        if(n%2!=0) System.out.println(dp[n][n/2+1]);
        else System.out.println(Math.max(dp[n][n/2+1],dp[n][n/2]));
    }
}

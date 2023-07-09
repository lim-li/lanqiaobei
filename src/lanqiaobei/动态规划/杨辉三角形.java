package lanqiaobei.动态规划;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author limli
 * @date 2023/2/18 19:35
 */
public class 杨辉三角形 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        int N = scan.nextInt();
        int[][] num = new int[N + 1][N + 1];
        int i,j = 0;
        for ( i = 0; i <= N; i++) {
            for (j = 0; j <= i; j++) {
                if (j == 0 || i == j) {
                    num[i][j] = 1;
                }else{
                    num[i][j] = num[i - 1][j - 1] + num[i - 1][j];
                    if(num[i][j]==N) {
                        System.out.println((1+i)*i/2+j+1);
                        return;
                    }
                }
            }
        }
    }
}

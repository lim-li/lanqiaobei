package lanqiaobei.排序;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author limli
 * @date 2023/2/25 17:51
 */
public class sort_lambda表达式 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] f  = new int[n][3];
        for(int i = 0;i < n;i++){
            f[i][0] = sc.nextInt();
            f[i][1] = sc.nextInt();
            f[i][2] = sc.nextInt();
        }
        Arrays.sort(f,(b,a)->a[0]+a[1]+a[2]-b[0]-b[1]-b[2]);//总和从大到小排序
        Arrays.sort(f,(a,b)->a[0]-b[0]);//按照第一列的大小从小到大排序
        for(int[] x:f) System.out.println(Arrays.toString(x));
    }
}

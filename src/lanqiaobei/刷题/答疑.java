package lanqiaobei.刷题;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author limli
 * @date 2023/2/25 19:51
 */
public class 答疑 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[][] arr = new int[n][3];
        for(int i = 0;i < n;i++){
            String[] s = in.readLine().split(" ");
            arr[i][0] = Integer.parseInt(s[0]);
            arr[i][1] = Integer.parseInt(s[1]);
            arr[i][2] = Integer.parseInt(s[2]);
        }
        Arrays.sort(arr,(a,b)->a[0]+a[1]+a[2]-b[0]-b[1]-b[2]);
        long ans = 0;
        long curTime = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                curTime += arr[i][j];
                if (j == 1) ans += curTime;
            }
        }
        System.out.println(ans);
    }
}

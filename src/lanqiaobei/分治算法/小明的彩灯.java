package lanqiaobei.分治算法;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * @author limli
 * @date 2023/2/3 13:55
 */
public class 小明的彩灯 {
    public static void main(String[] args) throws IOException {
        //差分数组的应用 在区间频繁加减 某一固定数值
        //Scanner sc = new Scanner(System.in);
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String[] s = sc.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int q = Integer.parseInt(s[1]);
        int[] arr = new int[n+1];
        long[] diff = new long[n+1];
        String[] s1 = sc.readLine().split(" ");
        for (int i = 1; i <=n ; i++){
            arr[i] = Integer.parseInt(s1[i-1]);
        }
        for (int i = 1; i <=n ; i++) {
            diff[i] = arr[i]-arr[i-1];
        }
        //System.out.println(Arrays.toString(diff));
        while(q-->0) {
            String[] s2 = sc.readLine().split(" ");

            int l = Integer.parseInt(s2[0]);
            int r = Integer.parseInt(s2[1]);
            int x = Integer.parseInt(s2[2]);
            diff[l] += x;
            if(r<n) diff[r + 1] -= x;
        }
        //System.out.println(Arrays.toString(diff));
        //还原
        for (int i = 1; i <= n; i++) {
            diff[i] += diff[i-1];
        }
        for(int i = 1;i <= n;i++){
            if(diff[i]<0) System.out.print(0+" ");
            else System.out.print(diff[i]+" ");
        }
    }
}

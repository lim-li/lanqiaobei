package lanqiaobei.数学思维与技巧;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author limli
 * @date 2023/1/7 17:35
 */
public class 美丽区间 {
    public static void main(String[] args) {
        //先把输入的数 放进数组中 然后滑动窗口
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] arr = new int[n+1];
        for(int i = 1; i < n+1;i++){
            arr[i] = sc.nextInt();
        }
        //System.out.println(Arrays.toString(arr));
        int sum = 0;//区间和统计
        int ans = n+1;//记录最小区间
        for(int l = 1,r = 1; r < n+1;r++){
            sum += arr[r];
            while(l <= r && sum >= s){ //缩小区间
                ans = Math.min(ans,r-l+1);
                sum -= arr[l];
                l++;
            }
        }
        System.out.println( ans == (n+1) ? 0 : ans);
    }
}

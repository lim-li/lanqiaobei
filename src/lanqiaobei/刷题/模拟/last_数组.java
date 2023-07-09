package lanqiaobei.刷题.模拟;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author limli
 * @date 2023/3/5 21:54
 */
public class last_数组 {
    public static int[] arr;
    public static int[] ans;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s1 = in.readLine();
        int n = Integer.parseInt(s1);
        String[] s = in.readLine().split(" ");
        String s3 = in.readLine();
        int k = Integer.parseInt(s3);
        arr = new int[n+2*k];

        Arrays.fill(arr,1000001);
        int j =1;
        for(int i = 0;i < s.length;i++){
            arr[j] = Integer.parseInt(s[i]);
            j++;
        }
        //ans = arr;//这样他只是个浅拷贝 ans的值改变 也会影响arr
        ans = arr.clone();//深拷贝 克隆
        for(int i = k ;i < k+n;i++){
            int l = i-k,r = i+k;
            int min = 1000002;
            while( l <= r ){
                min = Math.min(min,arr[l]);
                l++;
            }
            ans[i] = min;
        }
        //System.out.println(Arrays.toString(ans));
        for(int i = k;i < ans.length-k;i++){
            System.out.print(ans[i] + " ");
        }
    }
}

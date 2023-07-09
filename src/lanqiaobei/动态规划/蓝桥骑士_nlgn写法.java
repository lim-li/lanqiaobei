package lanqiaobei.动态规划;

import javax.lang.model.element.VariableElement;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author limli
 * @date 2023/2/15 20:58
 */
public class 蓝桥骑士_nlgn写法 {
    static  BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(in.readLine());
        int[] arr = new int[n];
        String[] s = in.readLine().split(" ");
        //1 4 2 2 5 6 ans=4 相当于求最大上升子序列的个数
//        int dp[] = new int[n];
//        Arrays.fill(dp,1);//最少是1
//        int longest = 0;
//        for(int i = 1;i < n;i++){
//            for(int j = 0;j < i;j++){
//                if(arr[i] > arr[j]){
//                    dp[i] = Math.max(dp[i],dp[j]+1);//挑选可构成序列的最大值+1
//                }
//            }
//            longest = Math.max(longest,dp[i]);
//        }

        int[] f = new int[n+5];//f[i] 代表长度为i的上升子序列的末尾元素最小值为f[i]
        int length = 0;//记录最长的子序列
        for(int i = 0;i < n;i++){
            arr[i] = Integer.parseInt(s[i]);
            int l = 0,r = length;
            while(l < r){
                int mid = (l+r+1)>>1;
                if(f[mid] >= arr[i]){
                    r = mid-1;
                }else{
                    l = mid;
                }
            }
            length = Math.max(length,r+1);
            f[r+1] = arr[i];
        }
        System.out.println(Arrays.toString(f));
        System.out.println(length);
    }
}

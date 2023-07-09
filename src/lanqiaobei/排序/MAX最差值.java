package lanqiaobei.排序;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author limli
 * @date 2023/2/2 11:10
 */
public class MAX最差值 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = in.readLine().split(" ");
        int n = Integer.parseInt(s1[0]);
        int k = Integer.parseInt(s1[1]);
        String[] s2 = in.readLine().split(" ");
        //1,先寻找1~k+1的最大值与最小值
       int ans = chazhi(s2,0,k+1);
        //System.out.println(ans);
        //2 滑动窗口 求窗口内的最大值与最小值差的最大值
        //2.1 每次滑动固定窗口 求得最大值与最小值的差
//        int left = 2,right =left+k;
//        while(right<=n){
//            int b = chazhi(s2,left-1,right-1);
//            ans = Math.max(ans,b);
//            left++;
//            right++;
//        }
//        System.out.println(ans);
    }
    public static int chazhi(String[] s2,int left,int right){//left~right内的最大值与最小值差的最大值
        int ans;
        int min = Integer.parseInt(s2[0]),max = Integer.parseInt(s2[0]);
        for(int i = left;i < right;i++){
            int a = Integer.parseInt(s2[i]);
            if(a < min)
                min = a;
            else if(a > max)
                max = a;
        }
        ans = max-min;
        return ans;
    }
}

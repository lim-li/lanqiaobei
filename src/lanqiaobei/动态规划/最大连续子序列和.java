package lanqiaobei.动态规划;
import java.util.Arrays;

/**
 * @author limli
 * @date 2023/2/15 11:37
 */
public class 最大连续子序列和 {
    public static void main(String[] args) {
//        int[] arr = {-2,11,-4,13,-5,2};
//        int dp[] = new int[arr.length];//dp[i] 代表的是以arr[i]结尾的连续最大字段和
//        dp[0] = arr[0];
//        int res = arr[0];
//        for(int i = 1;i < arr.length;i++){
//            dp[i]=Math.max(dp[i-1]+arr[i],arr[i]);
//            res = res>dp[i]?res:dp[i];
//        }
//        System.out.println(Arrays.toString(dp));
//        System.out.println(res);
        fun();
        double[] a = {0.257413997627521,0.098897427330438,0.321756894790603,0.184263618022865,0.117610837438424};
        double ans = 0;
        for(int i = 0;i < a.length;i++){
            ans += a[i];
        }
        System.out.println(ans);

    }
    public static void fun(){//不使用数组来求解 即省略dp数组
        int[] arr = {-2,11,-4,13,-5,2};
        int nowSum = 0;//记录当前i结尾的最大连续子段和
        int max = -999;
        for (int i = 0; i < arr.length; i++) {
            if(nowSum>0) nowSum = nowSum+arr[i];
            else nowSum = arr[i];
            if(max<nowSum) max = nowSum;
        }
        System.out.println(max);
    }
}

package lanqiaobei.分治算法;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author limli
 * @date 2023/2/5 17:08
 */
public class 最少刷题数 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        String[] s = in.readLine().split(" ");
        int[] arr = new int[N];
        int[] temp = new int[N];
        for(int i  = 0;i < N;i++){
            arr[i] = Integer.parseInt(s[i]);
            temp[i] = arr[i];
        }
        Arrays.sort(temp);
        int mid = temp[N/2];//无论奇偶数个 都是N/2
        int less = 0, more = 0;
        for(int i = 0;i < N;i++){
            if(arr[i]>mid) more++;
            else if( arr[i]<mid) less++;
        }
        //less >= more 满足这个条件即可
        if(less > more){
            for (int i = 0; i < N; i++) {//当 less>more 少于中间值的less部分 刷到mid就满足题意 more部分不需要刷题
                if(arr[i]<mid) System.out.print(mid-arr[i]+" ");
                else System.out.print(0+" ");
            }
        }else if (less == more){
            for(int i = 0;i < N;i++){ //当less==more 少于中间的部分要刷到大于mid满足题意 more部分不需要
                if(arr[i]<mid) System.out.print(mid-arr[i]+1+" ");
                else System.out.print(0+" ");
            }
        }
        else {//less<more
            for(int i = 0;i < N;i++){ //因为less<more 依次小于mid要加到大于mid 仔细想一下 等于mid的不动那么 less还是小于more 因此等于的部分也要大于 mid
                if(arr[i]<=mid) System.out.print(mid-arr[i]+1+" ");
                else System.out.print(0+" ");
            }
        }
    }
}

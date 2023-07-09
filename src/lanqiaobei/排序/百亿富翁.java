package lanqiaobei.排序;

import java.util.Scanner;

/**
 * @author limli
 * @date 2023/1/25 18:56
 * 5
 * 3 1 2 5 4
 *
 * -1 1 1 -1 4
 * 4 3 4 -1 -1
 */
public class 百亿富翁 {
    public static void main(String[] args) {
        int[] arr = new int[700002];
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            arr[i]=sc.nextInt();
        }
       //暴力 左右指针
        int[][] ans = new int[n+2][2];//存储答案的数组
        for (int i = 1; i <= n; i++) {
            int left = i,right = i;
            boolean lflag = true;
            boolean rflag = true;
            while(left > 0){
                left--;
                if(arr[left] > arr[i]){
                    ans[i][0] = left;
                    lflag = false;
                    break;
                }
            }
            if(lflag) ans[i][0] = -1;
            while(right < n+1){
                right++;
                if(arr[right]>arr[i]){
                    ans[i][1] = right;
                    rflag = false;
                    break;
                }
            }
            if(rflag) ans[i][1] = -1;
        }
        //遍历数组 查看答案
        for(int i = 0;i <= 1;i++){ //先遍历列
            for(int j = 1;j <= n;j++){
                System.out.print(ans[j][i] + " ");
            }
            System.out.println();
        }
    }
}

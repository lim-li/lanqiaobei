package lanqiaobei.基础2;

import java.util.Scanner;

/**
 * @author limli
 * @date 2022/12/19 11:44
 * 从三角形的顶部到底部有很多条不同的路径。对于每条路径，
 * 把路径上面的数加起来可以得到一个和，你的任务就是找到最大的和。
 *
 * 路径上的每一步只能从一个数走到下一层和它最近的左边的那个数或者右 边的那个数。
 * 此外，向左下走的次数与向右下走的次数相差不能超过 1。
 *
 * 5 行数
 * 7
 * 3 8
 * 8 1 0
 * 2 7 4 4
 * 4 5 2 6 5
 *
 * 27
 *
 */
public class n2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        //输入的三角形数字 只能向正下或右下相加
        int n = scan.nextInt();
        int[][] arr = new int[n+1][n+1];
        for(int i = 1;i < arr.length;i++){
            for(int j = 1; j <= i;j++){
                //当前位置最大路径值 等于上层同列或少一列 最大值加上此位置上的值(动态规划)
                arr[i][j] = Math.max(arr[i-1][j],arr[i-1][j-1])+scan.nextInt();
            }
        }
        //向左向右的差值不能超过1，即当得到动态规划数组 结果要落在中间
        if(n%2==0){//偶
            System.out.println(Math.max(arr[n][n/2],arr[n][n/2+1]));
        }else{
            System.out.println(arr[n][n/2+1]);
        }
        scan.close();
    }
}

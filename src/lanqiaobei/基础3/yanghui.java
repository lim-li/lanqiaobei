package lanqiaobei.基础3;

import java.util.Scanner;

/**
 * @author limli
 * @date 2022/12/15 14:17
 * 如果我们按从上到下、从左到右的顺序把所有数排成一列，可以得到如下数列：
 * 1, 1, 1, 1, 2, 1, 1, 3, 3, 1, 1, 4, 6, 4, 1, \cdots1,1,1,1,2,1,1,3,3,1,1,4,6,4,1,⋯
 * 给定一个正整数 N，请你输出数列中第一次出现 N是在第几个数？
 */
public class yanghui {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        //int N = scan.nextInt();
        int N = 100000;
        int[][] num = new int[N+1][N+1];
        for(int i = 0;i<=N;i++){
            for(int j=0;j<=i;j++){
                if(j==0 || i==j){
                    num[i][j]=1;
                }
            }
        }

        for(int i = 1;i <= N;i++){
            for(int j = 1; j < i;j++){
                num[i][j]=num[i-1][j-1]+num[i-1][j];
            }
        }
//        for(int i = 0;i <=N;i++){
//            for (int j = 0; j <= i ; j++) {
//                System.out.print(num[i][j]+"  ");
//            }
//            System.out.println();
//        }

        for(int i = 0;i <= N;i++){
            boolean flag = false;
            for (int j = 0; j <= i; j++) {
               if(num[i][j]==N){
                   System.out.print(i*(i+1)/2+j+1);
                   flag = true;
                   break;
               }
            }
            if(flag)
                break;
        }


        scan.close();
    }
}

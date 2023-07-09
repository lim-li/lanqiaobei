package lanqiaobei.基础1;

import java.util.Scanner;

/**
 * @author limli
 * @date 2022/12/28 11:28
 * 8
 * 2 5 6 1 4 3 1 3
 *
 * 4
 * 记录当前数前面的最小值,并且减去这个最小值 就是利润，并找出最大利润
 */
public class 最大利润 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int min = scanner.nextInt();
        int max = Integer.MIN_VALUE;
        for(int i = 1; i < n;i++){
            int m = scanner.nextInt();
            max = Math.max(max,m-min);
            min = Math.min(min,m);
        }
        System.out.println(max);
    }
}

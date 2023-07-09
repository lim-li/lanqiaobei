package lanqiaobei.基础1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author limli
 * @date 2023/1/8 20:52
 */
public class test {
    static int m;
    //测试数组排序后 最大值位置
    public static void main(String[] args) {
        int[] ar = new int[26];
        ar[1] = 2;
        ar[2] = 3;
        ar[3] = 4;
        ar[5] = 0;
        Arrays.sort(ar);
        System.out.println(Arrays.toString(ar));
        //最大值 会在最后一个 所以 这个排序会把所有的（包括默认值排序）
        Arrays.fill(ar,0);
        System.out.println(Arrays.toString(ar));
        int m = 1;
        Scanner sc = new Scanner(System.in);


    }


}

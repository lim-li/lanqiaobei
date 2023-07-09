package lanqiaobei.分治算法;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author limli
 * @date 2023/2/3 21:22
 */
public class 成绩分析 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(in.readLine());
        int sum = 0, max = -1, min = 101;
        for (int i = 0; i < n; i++) {
            int score = Integer.parseInt(in.readLine());
            if(score > max) max = score;
            else if(score < min) min = score;
            sum += score;
        }
        System.out.println(max);
        System.out.println(min);
        System.out.println(sum/n);
        System.out.printf("%.2f",(double)sum/n);//传入的double值 保留小数
    }
}

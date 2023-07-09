package lanqiaobei.分治算法;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author limli
 * @date 2023/2/4 21:30
 */
public class 最大间隙 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();
        int n = Integer.parseInt(s);
        String[] s2 = in.readLine().split(" ");
        int max = 0;
        for (int i = 0; i < s2.length-1; i++) {
            int cha = Integer.parseInt(s2[i+1])-Integer.parseInt(s2[i]);
            if(max < cha){
                max = cha;
            }
        }
        System.out.println(max);
    }
}

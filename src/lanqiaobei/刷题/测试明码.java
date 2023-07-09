package lanqiaobei.刷题;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author limli
 * @date 2023/3/11 21:00
 */
public class 测试明码 {
    public static char[][] g ;
    public static void main(String[] args) throws IOException {
        g = new char[180][120];
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0;i < 170;i++){
            String s = in.readLine();
            g[i] = s.toCharArray();
        }
        for(int i = 0;i < g.length;i++){
            for(int j = 0;j < g[0].length;j++){
                if(g[i][j] == '0'){
                    g[i][j] = ' ';
                }else if (g[i][j] == '1'){
                    g[i][j] = '*';
                }
            }
        }
        for(char[] x:g) System.out.println(Arrays.toString(x));

    }
}





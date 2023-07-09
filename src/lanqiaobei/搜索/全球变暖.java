package lanqiaobei.搜索;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author limli
 * @date 2023/2/17 16:36
 */
public class 全球变暖 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
       char[][] g = new char[n][n];
       char[][] temp = new char[n][n];
        for(int i = 0;i < n;i++){
            String s1 = in.readLine();
            g[i] = s1.toCharArray();//用来统计没淹没的岛屿数量
            temp[i] = s1.toCharArray();//统计淹没后的
        }
        //
        int a = getSum(g,n);//没淹没的数量
//        System.out.println(a);
//        for(char[] x:g) System.out.println(Arrays.toString(x));
//        System.out.println("============");
        fun(temp,n);//将temp淹没
//        for(char[] x:temp) System.out.println(Arrays.toString(x));
        int b = getSum(temp,n);//淹没后的数量
//        System.out.println(b);
        System.out.println(a-b);
    }
    public static int getSum(char[][] g ,int n){//求岛屿的数量
        int sum = 0;
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                if(g[i][j] == '#'){
                    sum++;
                    dfs(g,i,j,n);//将连成一片的岛屿全部变成海洋
                }
            }
        }
        return sum;
    }
    public static void dfs(char[][] g,int i,int j,int n){//把连成一片的岛屿淹没
        if(i<0 || i >= n || j < 0 || j >= n) return;//这个点不在图上 结束
        if(g[i][j] == '.') return ;//本身是海洋
        g[i][j] = '.';//上面俩个都不是 那么这个点 就是陆地 将其淹没
        //遍历其周围
        dfs(g,i+1,j,n);
        dfs(g,i-1,j,n);
        dfs(g,i,j-1,n);
        dfs(g,i,j+1,n);
    }
    public static void fun(char[][] g ,int n){//此函数是将周围是海洋的陆地淹没
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                if(g[i][j] == '#'){
                    //判断下面四个边界是防止 最后一个判断条件越界 真秒呀
                    if(i==0 && g[i+1][j]=='.')
                        g[i][j] = ',';
                    else if(i==n-1 && g[i-1][j] == '.')
                        g[i][j] = ',';
                    else if(j == 0 && g[i][j+1]=='.')
                        g[i][j] = ',';
                    else if(j == n-1 && g[i][j-1]=='.')
                        g[i][j] = ',';
                    //满足一个即可
                    else if (g[i+1][j] == '.' || g[i-1][j]=='.' || g[i][j+1]=='.' || g[i][j-1]=='.')
                        g[i][j]= ',';
                }

            }
        }

    }
}

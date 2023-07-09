package lanqiaobei.搜索.dfs;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author limli
 * @date 2023/3/16 20:45
 */
public class 迷宫2 {
    static char[][] arr;
    static boolean[][] vis;
    static int ans = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        arr = new char[10][10];
        for(int i = 0;i < 10;i++){
            String s = sc.next();
            arr[i] = s.toCharArray();
        }
        //判断有多少点能出去
        for(int i = 0;i < 10;i++){
            for(int j = 0;j < 10;j++){
               vis = new boolean[10][10];//每次都重新创建这个vis相当于清空
                dfs(i,j);
            }
        }
        System.out.println(ans);

    }
    public static void dfs(int x,int y){
        if(x < 0 || x >= 10 || y < 0 || y >= 10) {//走出去的情况
            ans++;
            return;
        }
        if(vis[x][y]) return;//这个点已经被走过了 且没有走出去
        vis[x][y] = true;//走这个点
        if(arr[x][y] == 'U'){//上
            dfs(x-1,y);
        }
        else if(arr[x][y] == 'R'){
            dfs(x,y+1);
        }
        else if(arr[x][y] == 'L'){
            dfs(x,y-1);
        }
       else if(arr[x][y] == 'D'){
            dfs(x+1,y);
        }

    }
}

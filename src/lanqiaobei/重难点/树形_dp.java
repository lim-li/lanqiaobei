package lanqiaobei.重难点;

import javax.lang.model.element.VariableElement;
import java.io.*;
import java.util.ArrayList;

/**
 * @author limli
 * @date 2023/3/18 13:55
 */
public class 树形_dp {
    static ArrayList<Integer>[] q;//q[i]这个上司的下属都有谁
    static boolean[] visit ;//判断这个人有没有上司
    static long[][] dp;//dp[i][0]代表这个i这个人不去 dp[i][1] 代表这个人去
    static int[] a;//存储兴奋值
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
       //蓝桥舞会
        int n = Integer.parseInt(in.readLine());
        q = new ArrayList[n+1];
        visit = new boolean[n+1];
        dp = new long[n+1][2];
        a = new int[n+1];
        String[] s = in.readLine().split(" ");
        for(int i = 1;i <= n;i++){
            a[i] = Integer.parseInt(s[i-1]);
            q[i] = new ArrayList<>();//q是一个集合数组 所以每一个元素是一个集合
        }
        //存储上下属关系
        for(int i = 1;i <n;i++){
            String[] s1 = in.readLine().split(" ");
            int u = Integer.parseInt(s1[0]);
            int v = Integer.parseInt(s1[1]);
            visit[u] = true;//表示u这个人有上司
            q[v].add(u);//u的上司是v
        }
        //寻找没有上司的 也就是大老板
        int root = -1;
        for(int i = 1;i <= n;i++){
            if(visit[i]==false){
                root = i;
                break;
            }
        }
        dfs(root);
        System.out.println(Math.max(dp[root][1],dp[root][0]));


    }
    //进行树形dp
    public static void dfs(int root){
        dp[root][1] += a[root];//初始化操作 其实这一步操作可以为每一个二叉树的节点赋值 真是秒呀
        //枚举这个跟的下属
        for(int i = 0;i < q[root].size();i++){
            int to = q[root].get(i);//下属
            dfs(to);//递归 一直往下找
            dp[root][1] += dp[to][0];//根节点去 下属一定不去
            dp[root][0] += Math.max(dp[to][0],dp[to][1]);//根节点不去 下属可以选择去或者不去
        }

    }
}

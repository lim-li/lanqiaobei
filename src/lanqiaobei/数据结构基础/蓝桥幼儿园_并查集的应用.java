package lanqiaobei.数据结构基础;

import java.util.Scanner;

/**
 * @author limli
 * @date 2023/2/28 14:48
 */
public class 蓝桥幼儿园_并查集的应用 {
    public static int[] f;//f[i] 代表i的父亲是f[i]
    public static void main(String[] args) {
        //并查集的使用
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();//n个小朋友 m此操作
        //初始化
        f = new int[n+1];//分别存储每个小朋友的圈子的根节点
        for(int i = 1;i <= n;i++) f[i] = i;
        for(int i = 1;i <= m;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if(a==1){
                union(b,c);
            }else{
                //判断俩个人是否是一个圈子 要找到这个圈子的老大 判断是不是一个人
                //要是只是找有多少个圈子 只需要判断f[i] = i 这个人是不是老大
                int father1 = searchfather(b);
                int father2 = searchfather(c);
                if(father1 == father2) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }
    public static int searchfather(int node){
        //寻找node的根节点
        if(f[node] == node) return node;
        else{
            f[node] = searchfather(f[node]);
            return f[node];
        }
    }
    public static void union(int a,int b){
        int father1 ,father2;
        father1 = searchfather(a);
        father2 = searchfather(b);//寻找a,b的爸爸 如果不相同就把他们设置为相同
        if(f[father1] != f[father2]){
            f[father2] = father1;
        }
    }
}

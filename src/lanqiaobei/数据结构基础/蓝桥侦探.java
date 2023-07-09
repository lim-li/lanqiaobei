package lanqiaobei.数据结构基础;


import java.util.Scanner;

/**
 * @author limli
 * @date 2023/2/2 20:08
 *  并查集的应用
 */
public class 蓝桥侦探 {
    public static int[] f;//f[i]代表i的父节点是f[i]
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();//n 大臣的数量 m口供的数量
        //初始化
        f = new int[n+1];
        for(int i = 1;i <= n;i++) f[i]=i;//每个人的父节点都是自己
        for(int i = 1;i <= m;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int fa1 = searchFatrher(a);
            int fa2 = searchFatrher(b);
            if(fa2 != fa1) union(fa2,fa1);
            else if(fa2 == fa1) {
                System.out.println(a);
                break;
            }
        }


    }
    public static int searchFatrher(int node){//寻找父节点
        if(f[node] == node) return node;
        else {
            f[node] = searchFatrher(f[node]);
            return f[node];
        }

    }

    public static void union(int a,int b){//如果a,b属于同一个团伙 也就是根一样进行合并
        int father1 = searchFatrher(a);
        int father2 = searchFatrher(b);
        if(father2 != father1){//现在的根还不一致 就合并
            f[father2] = father1;
        }
    }


}

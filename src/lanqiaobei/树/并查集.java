package lanqiaobei.树;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author limli
 * @date 2023/2/28 13:52
 10 9
 1 2
 3 4
 5 2
 4 6
 2 6
 8 7
 9 7
 1 6
 2 4
 *
 *
 */
public class 并查集 {
    public static int[] f ;//f[i] 代表i的父节点是f[i]
    public static void main(String[] args) {
        int n = 0, m = 0;//n个犯罪分子，m条线索
        int a = 0, b = 0;
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
             n = sc.nextInt(); //输入 人数
             m = sc.nextInt();//m条线索
             f = new int[n+1];
            init(n);
            for(int i = 1;i <= m;i++){
                a = sc.nextInt();
                b = sc.nextInt();
                union(a,b);
            }
            int count = 0;
            for(int i = 1;i <= n;i++){
                if(f[i] == i) count++;
            }
            System.out.println(Arrays.toString(f));
            System.out.println(count);
        }

    }
    public static void init(int n){
        for (int i = 1; i <= n ; i++) {
            f[i] = i;//初始化 每个节点的父节点是本身
        }
    }
    public static int searchFarther(int node){//寻找根节点
        if(f[node] == node) return node;
        else{
            f[node] = searchFarther(f[node]);//递归寻找上层 比如f[1] = 3 进入else 此时node等于3 判断f[3]是否等于3 等于返回3 不等继续找
            return f[node];
        }
    }
    public static void union(int a,int b){
        int farther1,farther2;
        farther1 = searchFarther(a);
        farther2 = searchFarther(b);
        if(farther1 != farther2){
            f[farther2] = farther1;//约定farther2 的爸爸是 farther1
        }

    }
}

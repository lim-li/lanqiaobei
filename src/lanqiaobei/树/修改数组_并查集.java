package lanqiaobei.树;

import java.util.Scanner;

/**
 * @author limli
 * @date 2023/4/5 10:13
 */
public class 修改数组_并查集 {
    static int[] f = new int[(int)(1e6+1e5)];
    public static void main(String[] args) {
        //f数组初始化 f[i] 代表i的父节点是f[i]
        for(int i = 1;i <f.length;i++) f[i] = i;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] data = new int[n];
        for(int i = 0;i < n;i++) data[i] = sc.nextInt();
        for(int i = 0;i < n;i++){
           //寻找值得爸爸
            int k = searchFather(data[i]);
            data[i] = k;//代替原数组
            // 如果在遇见i这时候它的爸爸就要加一
            f[data[i]] = searchFather(data[i]+1);
       }
        for(int i = 0;i < n;i++) System.out.print(data[i]+" ");
    }
    //并查集的板子 寻找爸爸
    public static  int searchFather(int node){
        if(node == f[node]) return node;
        else{
            f[node] = searchFather(f[node]);
        }
        return f[node];
    }
}

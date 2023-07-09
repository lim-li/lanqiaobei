package lanqiaobei.刷题;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author limli
 * @date 2023/3/1 21:46
 */
public class 修改数组 {
    static int[] f=new int[2000000];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] data = new int[n];

        //初始化f数组
        for (int i = 0; i < n; i++) {
            f[i] = i;
        }
        for (int i = 0; i < n; i++) {
            data[i] = sc.nextInt();
        }
        for(int i = 0;i < n;i++){
            int k = find(data[i]);//找data[i] 的根节点
            data[i] = k;//把根节点赋值给ans数组
            f[data[i]]=find(data[i]+1);//下一次在遇见它 加一 之后跟的值给f数组 方便直接查找
        }
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i]+" ");
        }
    }


    public static int find(int node){
        if(node == f[node]) return node;//自己是根节点
        else f[node] = find(f[node]);
        return f[node];
    }
}

package lanqiaobei.图论;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author limli
 * @date 2023/2/26 11:17
 * prime 算法求最小生成树
 6
 0 6 1 5 0 0
 6 0 5 0 3 0
 1 5 0 5 6 4
 5 0 5 0 0 2
 0 3 6 0 0 6
 0 0 4 2 6 0
 */
public class primedemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//顶点个数
        int[][] g = new int[n][n];//邻接矩阵
        int[] dis = new int[n];//当前最小生成树到其他未访问的顶点的距离 每次挑选最小的
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                int w = sc.nextInt();
                if(i==j) g[i][j]=0;//自己到自己的距离
                else if(w==0) g[i][j] = Integer.MAX_VALUE;//不可达 默认为无穷大
                else g[i][j] = w;//存储真实的权值
            }
        }
        for(int[] x:g) System.out.println(Arrays.toString(x));
        primedo(g,dis,n);
    }
    public static void primedo(int[][] g,int[] dis,int n){
        //默认0是 最小生成树的第一个 节点
        //dis 数组存储最小生成树到其他节点的最小距离
        for (int i =0;i < n;i++) dis[i] = g[0][i];
        dis[0] = 0;//当前结点被纳入最小生成树，所以最小生成树到它的距离为0
        int ans = 0;//存放整体的权重值
        for(int i = 1;i < n;i++){//n个节点，最后选择n-1条边，循环n-1次
            int min = Integer.MAX_VALUE;//找出最小生成树到未选择结点的最小值
            int minIndex = -1;//存储最小结点的编号
            for(int j =0;j < n;j++){
                if(dis[j] < min&&dis[j] != 0){
                    min = dis[j];
                    minIndex = j;//当前j是最小的未被纳入接点的最小编号
                }
            }
            System.out.printf("第%d轮，最小生成树到%2d最小，权重是%d\n",i,minIndex,min);
            ans += dis[minIndex];
            dis[minIndex] = 0;//表示minIndex被纳入最小生成树
            // 由于有新的结点纳入最小生成树 所以要更新
            for(int j = 0;j < n;j++){
                dis[j] = Math.min(dis[j],g[minIndex][j]);//这个结点和之前最小生成树 所组成的距离那个最小
            }
           // System.out.println(ans);//1 5 7 12 15
            System.out.println("选中了"+minIndex+"距离数组"+Arrays.toString(dis));
        }
        System.out.println(ans);
    }
}

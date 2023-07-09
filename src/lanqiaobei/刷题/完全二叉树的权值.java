package lanqiaobei.刷题;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author limli
 * @date 2023/2/25 21:03
 */
public class 完全二叉树的权值 {
    public static void main(String[] args) throws IOException {
        //求完全二叉树的权值最大的那一层 如果一样大返回最小层数 根的深度是1
        //由于题中 输入为 7  //1 6 5 4 3 2 1 这种形式
        //由结点个数 可以求出二叉树的深度 2^n-1
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        String[] s = in.readLine().split(" ");

        int l = 0;
        for(int depth = 1;(Math.pow(2,depth)-1)<=N;depth++){
           l++;
        }
      //  System.out.println(l);//这个层数满二叉树的时候 是正确的的 但是完全二叉树不适用
        // 判断一下层数是否正确
        if((Math.pow(2,l)-1) < N) l++;
        int max = Integer.MIN_VALUE;
        int ans = -1;
        for(int d = 1;d<=l;d++){//每一层
            int sum =0;
            for(int j = (int) Math.pow(2,d-1)-1;j < (int)Math.pow(2,d)-1 && j < N;j++){ //j要满足数组下标
                sum += Integer.parseInt(s[j]);
            }
            if(sum > max) {
                max = sum;
                ans = d;
            }

        }

//        int max = Integer.MIN_VALUE;
//        int ans = -1;
//        int count=0;
//        for(int d = 1;(Math.pow(2,d)-1)<=N;d++){//这样可能会少算一层
//            int sum=0;
//            for(int j =(int) Math.pow(2,d-1)-1; j < (int)Math.pow(2,d)-1&&j<N;j++){
//                 sum += Integer.parseInt(s[j]);
//                 count++;//统计一下计算了多少个结点 因为是完全二叉树 不是满二叉树
//            }
//            if(max<sum){//等于的时候不考虑 所以维护的就是一个最小的深度
//                max = sum;
//                ans = d;
//            }
//        }
//        //计算最后一层
//        int last = 0;
//        for(int i = count;i < s.length;i++){
//            last += Integer.parseInt(s[i]);
//        }
//        if(last > max) ans = l+1;
        System.out.println(ans);
    }
}

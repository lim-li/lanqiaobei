package lanqiaobei.重难点;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author limli
 * @date 2023/3/11 14:35
 */
public class 树状数组_lowbit {

    int[] A;//原始的数组
    int[] C ;//树状数组
    int n ;//题目中所给的数组A的长度
    public 树状数组_lowbit(int A[]){
        this.A = A;
        n = A.length;
        C = new int[n+1];
        for(int i = 1;i <= n;i++){
            add(i,A[i-1]);//调用自己写的添加
        }
    }
    public  int lowbit(int x) {//二进制右边有多少个连续的0 然后lowbit(i) = 2^(0的个数)
        return x&(-x);
    }
    //c[x] 表示区间原始数组 [x-lowbit(x)+1,x]的和
    public  int getSum(int x){//求任意区间[left ,x]的和 令left=1
        int ans = 0;
        //比如求A[1-8] 之间的和 i= 8 i>=1 i-=lowbit(8)= 8即i = 0 结果ans 就等于c[8] 而c[8]确实包含了前缀和
        for(int i = x ;i >= 1;i -= lowbit(i)){//注意i的变化范围 c[8] = A[8]+  c[7] + c[6] + c[4]
            ans += C[i];
        }
        return ans;

    }
    public  void add(int i,int val){//在x这个位置加上数值v
        //原来的值是A[i-1] 现在要改为val 这里的val是增加到 不是增加了
        int data = val-A[i-1];//增加了
        A[i-1] = val;
        for(int j = i;j <= n; j += lowbit(j)){
            C[j] += data;
        }

    }
    public int sumRange(int start ,int end){
        return getSum(end)-getSum(start-0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[]{1,2,3,4};
        树状数组_lowbit t = new 树状数组_lowbit(arr);
        //System.out.println(Arrays.toString(A));
        System.out.println(Arrays.toString(t.C));
        System.out.println(t.getSum(2));

    }
}

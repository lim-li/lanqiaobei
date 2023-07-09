package lanqiaobei.刷题;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author limli
 * @date 2023/3/16 19:44
 */
public class 质数问题 {
    public static void main(String[] args) {
        //首先求出[2,n]之间的素数 n最大为1000
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] isprime = new boolean[1001];
        for(int i = 2;i*i < 1001;i++){
            if(!isprime[i]){//i是质数
                for(int j = 2;j * i <1001;j++){
                    isprime[j*i] = true;//倍数不是质数
                }
            }
        }
        for(int i = 2;i < 1001;i++){
            if(!isprime[i]){
                list.add(i);
            }
        }
        //System.out.println(Arrays.toString(list.toArray()));
        int[] arr = new int[list.size()];
        for(int i = 0;i < list.size()-1;i++){
            arr[i] = list.get(i)+list.get(i+1)+1;
        }
        //System.out.println(Arrays.toString(arr));
        ArrayList<Integer> list1 = new ArrayList<>();//存储相邻相加再加上1之后是素数的数
        for(int i = 0;i < arr.length&&arr[i] < 1001;i++){
            if(!isprime[arr[i]]){
                list1.add(arr[i]);
            }
        }
       // System.out.println(Arrays.toString(list1.toArray()));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0;i < T;i++){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int j ;
            for( j = 0;j < list1.size();j++){
                if(list1.get(j)>n) break;
            }
            System.out.println(j >= k ? "YES":"NO");
        }

    }
}

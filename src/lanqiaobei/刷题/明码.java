package lanqiaobei.刷题;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author limli
 * @date 2023/3/11 19:36
 * 将数字转换为2进制
 */
public class 明码 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = in.readLine().split(" ");
        int n = Integer.parseInt(s1[0]);
        //应该是一行代表一个汉字 16*16
        for(int i = 0;i < n;i++){
            String[] s = in.readLine().split(" ");
            fun1(s);
            System.out.println("=============================================");
        }


    }
    public static void fun1(String[] s){//将给定的字符数组 每个数字转换为二进制且 16个字符换行
       //一行中一个数代表一个字节 不够的前面补上0
       for(int i = 0;i < s.length;i++){
           int a = Integer.parseInt(s[i]);
           fun(a);
           if(i % 2 == 1){
               System.out.println();
           }
       }
    }
    public static void fun(int s){//将s转换为二进制字符且不够8位 补成8位
        String ans = "";
        ans = Integer.toBinaryString(s);
        while(ans.length() < 8){
            ans = '0'+ans;
        }
        System.out.print(ans);
    }
    public static void shuchu(char[][] g){//构建一个超大数组 将输入的1转化为* 0转换为空格

    }
}

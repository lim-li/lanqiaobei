package lanqiaobei.基础1;

import java.util.Scanner;

/**
 * @author limli
 * @date 2022/12/28 10:53
 * 内存空间为32位的整数 也就是int 可能为负数
 * a&(a-1) 每一次与运算都会把a二进制中最右边的1变为0 统计a多少次变为0 即为二进制中1的个数
 */
public class 个数1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
//        int n = Integer.parseInt(str);
//        System.out.println(n);
//        //使用toString()  这个负数情况下 不是补码
//        String s1 = Integer.toString(n, 2);
//        //System.out.println(s1);
//        //使用toBinaryString() 这个是补码
//        String s = Integer.toBinaryString(n);
//        //System.out.println(s);
//        int count = 0;
//        for(int i = 0;i < s.length();i++){
//            if(s.charAt(i) == '1')
//                count++;
//        }
//        System.out.println(count);
        //2 a&(a-1)
        int a = sc.nextInt();
        int sum= 0;
        while(a != 0){ //a!=0 负数也能运算
            a=a&(a-1);
            sum++;
        }
        System.out.println(sum);

    }
}

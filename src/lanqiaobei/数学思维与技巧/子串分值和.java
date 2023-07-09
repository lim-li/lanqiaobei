package lanqiaobei.数学思维与技巧;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author limli
 * @date 2023/1/14 9:54
 * 暴力 超时 (n^2)。。。
 */
public class 子串分值和 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        //截取子串 判断子串不重复个数
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            for(int j = i+1;j <= s.length();j++){
                //System.out.println(s.substring(i,j));
                res += fun(s.substring(i,j));
            }
        }
        System.out.println(res);
    }
    public static int fun(String s1){//统计字符串 不重复的字符有多少个
        Set<Character> set = new HashSet<>();
        char[] ch = s1.toCharArray();
        for(int i = 0; i < ch.length;i++){
            set.add(ch[i]);
        }
        int temp = set.size();
        //System.out.println(temp);
        set.clear();
        return temp;
    }
    /**
     * dp 例如 :ababc
     * a    --> 1
     * ab   --> b,ab (1)+2=3
     * aba  --> a,ba,aba (1+2)+2=5
     * abab --> b,ab,bab,abab (1+2+2)+2= 7
     * ababc--> c,bc,abc,babc,ababc 1+2+3+3+3=12
     */
}

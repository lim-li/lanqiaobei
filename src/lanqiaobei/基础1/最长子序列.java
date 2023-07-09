package lanqiaobei.基础1;

import java.util.Scanner;

/**
 * @author limli
 * @date 2023/1/10 15:54
 * 输入：
 * S;ABCDEABCD
 * T;AABZ
 * 请问 T 中从第一个字符开始最长连续多少个字符 被 S 包含 抽取S必须按顺序排列
 * 输出：3
 */
public class 最长子序列 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        int j = 0,i = 0,count = 0;
        while(j < s.length() && i < t.length()){
            if(t.charAt(i) == s.charAt(j)){
                j++;
                i++;
                count++;
            }else{
                j++;
            }
        }

        System.out.println(count);
    }

}

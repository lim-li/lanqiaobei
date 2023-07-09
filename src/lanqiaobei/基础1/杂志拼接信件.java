package lanqiaobei.基础1;

import java.util.Scanner;

/**
 * @author limli
 * @date 2022/12/26 19:36
 * 输入两行字符串，长度均不超过 100。
 * 第一行为杂志字符串，第二行为信件字符串。
 *
 * 输出一行，若信件可由杂志构成则输出 YES，否则输出 NO。
 */
public class 杂志拼接信件 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String z = sc.next();
        String x = sc.next();
        int[] c = new int[26];
        char[] xx = x.toCharArray();
        for(char x1:xx){ //信件所需字符
            c[x1-'a']++;
        }
        //杂志含有字符
        for(int i = 0;i < z.length();i++){
            c[z.charAt(i)-'a']--;
        }
        //检查数组c中是否含有大于0的未匹配的字符
        boolean flag = true;
        for(int i = 0;i < 26;i++){
            if(c[i] > 0){ //说明未匹配完
               flag = false;
            }
        }
        if (flag){
            System.out.println("Yes");
        }else
            System.out.println("NO");
    }
}

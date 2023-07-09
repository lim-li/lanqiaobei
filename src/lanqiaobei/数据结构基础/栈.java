package lanqiaobei.数据结构基础;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author limli
 * @date 2023/1/29 15:35
 */
public class 栈 {
    public static void main(String[] args) {
        /**
         * 左括号都入栈
         * 当匹配到右括号时，栈空或者弹出来的不匹配 就终止
         * 最后判断 标准是栈空 而且 字符串中的字符每个都遍历完
         */
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            Stack<Character> stack = new Stack<>();
            char[] c = s.toCharArray();
            int i = 0;
            for (; i < c.length; i++) {
                if (c[i] == '(' || c[i] == '[') stack.push(c[i]);//左括号都入栈
                else if(c[i] == ')'){
                    if(stack.isEmpty()||stack.pop()!='(')break;
                }else if(c[i] == ']'){
                    if(stack.isEmpty()||stack.pop()!='[')break;
                }
            }
            if(stack.size()==0 && i == c.length) System.out.println("yes");
            else System.out.println("no");
        }
    }
}

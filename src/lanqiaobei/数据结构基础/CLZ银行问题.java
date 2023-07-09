package lanqiaobei.数据结构基础;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author limli
 * @date 2023/1/29 18:56
 */
public class CLZ银行问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String m = sc.nextLine();
        String[] mm = m.split(" ");
        int M = Integer.parseInt(mm[0]);
        //int M = sc.nextInt(); 不能这样 数字后面的换行或者空格会被 nextLine()读取
        // System.out.println(M);
        Queue<String> V = new LinkedList<>();
        Queue<String> N = new LinkedList<>();
        for(int i = 1;i <= M ;i++) {
            String s = sc.nextLine();
            String[] s1 = s.split(" ");
            //System.out.println(Arrays.toString(s1));
            if(s1[0].equals("IN")){//进
                if(s1[2].equals("V")){
                    V.offer(s1[1]);
                }else
                    N.offer(s1[1]);
            }else{//出
                if(s1[1].equals("V")){
                    V.poll();
                }else
                    N.poll();
            }
        }
        //先输出V 在输出N
        while(!V.isEmpty()){
            System.out.println(V.poll());
        }
        while(!N.isEmpty()){
            System.out.println(N.poll());
        }
    }
}

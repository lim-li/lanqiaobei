package lanqiaobei.数据结构基础;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author limli
 * @date 2023/1/29 16:16
 */
public class 队列_约瑟夫环 {
    public static void main(String[] args) {
        /**
         * 使用队列 当不满足要出去的 就出去再进队列
         */
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int n = sc.nextInt();
            int m = sc.nextInt();//n个人m个出列
            Queue<Integer> q = new LinkedList<>();
            int count = 1;//计数器 统计到n个人的第几个
            for (int i = 1; i <= n; i++) {
                q.offer(i);
            }
            while(!q.isEmpty()){
                if(count==m){
                    System.out.print(q.poll()+"->");
                    count=1;//count 要重新计数
                }else{
                    count++;//不等于计数器要前进
                    q.offer(q.poll());
                }
            }
            System.out.println();
        }
    }
}

package lanqiaobei.贪心;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author limli
 * @date 2023/2/14 20:33
 */
public class 接水问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//人数
        int m = sc.nextInt();//水龙头个数
        PriorityQueue<Integer> q = new PriorityQueue<>();
        //每次往优先队列的最小值 按顺序接水 最后最大值就是要花费的时间
        if (n <= m) {
            for (int i = 0; i < n; i++) {
                q.add(sc.nextInt());
            }
            while (q.size() != 1) {
                q.poll();
            }
            System.out.println(q.peek());
        } else {
            for (int i = 0; i < m; i++) {//队列中添加m个
                q.add(sc.nextInt());
            }
            //然后每次向最小值 也就是队头排队 此时还剩下 n-m个人排队
            for (int i = 0; i < n - m; i++) {
                int temp = q.poll() + sc.nextInt();
                q.add(temp);
            }
            //找出最大值 队尾
            while (q.size() != 1) {
                q.poll();
            }
            System.out.println(q.peek());
        }
    }
}

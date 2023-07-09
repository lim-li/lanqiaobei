package lanqiaobei.贪心;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author limli
 * @date 2023/2/14 19:23
 * 哈夫曼数根节点大小的模拟
 */
public class 贪心例题2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /**
        while (sc.hasNext()) {
            int n = sc.nextInt();//果子堆数
            int[] w = new int[n];
            for (int i = 0; i < n; i++) w[i] = sc.nextInt();
            if (n == 0) break;
            if (n == 1) System.out.println(w[0]);
            int sum = 0;
            Arrays.sort(w);
            for (int i = 1; i < n; i++) {//n堆果子需要n-1次合并
                sum = sum + w[0] + w[1];//每次合并最小的两个
                w[0] += w[1];//最小的两个合为一个
                w[1] = Integer.MAX_VALUE;//把w[1]写成最大值
                Arrays.sort(w);
            }
            System.out.println(sum);
        }
         **/

        //方法2 优先队列
        PriorityQueue<Long> q = new PriorityQueue<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            q.add((long)sc.nextInt());
        }
        //System.out.println(q);
        long sum = 0;
        for (int i = 0; i < n-1; i++) {
            long temp = q.poll()+q.poll();
            sum += temp;
            q.add(temp);
        }
        System.out.println(sum);

    }
}

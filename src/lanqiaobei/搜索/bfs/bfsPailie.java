package lanqiaobei.搜索.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author limli
 * @date 2023/2/10 22:04
 */
public class bfsPailie {
    public static void main(String[] args) {
        int n = 3;//3阶的全排列
        Queue<String> q = new LinkedList<>();
        for(int i = 1;i <= n;i++) q.offer(""+i); //1 2 3 分别进队列
        while (!q.isEmpty()){
            String head = q.poll();//以1 为例
            //开枝散叶
            for (int i = 1;i <= n;i++){
                if (head.contains(i+"")) continue;//如果队头包括i 比如11 那么就跳过本次循环 剪枝
                String son = head+i; // 11 12 13 第二次遍历
                if (son.length()==3) System.out.println(son);//111
                else q.offer(son);//11 12 13 进入队列
            }
        }
    }

}

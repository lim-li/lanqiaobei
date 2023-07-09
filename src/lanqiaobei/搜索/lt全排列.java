package lanqiaobei.搜索;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author limli
 * @date 2023/2/10 22:25
 */
public class lt全排列 {
    static List<List<Integer>> ansDfs = new ArrayList<>();//全局的
    static List<Integer> path = new LinkedList<>();
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        //System.out.println(BFSpermute(nums));
        DFSpermute(nums, (LinkedList<Integer>) path);
        System.out.println(ansDfs);

    }
    public static void DFSpermute(int[] nums, LinkedList<Integer> path) {
        if(path.size()==nums.length){
            ansDfs.add(new ArrayList<>(path));
        }
        for (int i = 0; i < nums.length; i++) {
            if (!path.contains(nums[i])){
                path.add(nums[i]);
                DFSpermute(nums,path);
                path.removeLast();//为什么加上这一句就可以了 回溯的
            }

        }

    }

    public static List<List<Integer>> BFSpermute(int[] nums) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        if(nums.length==1) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(nums[0]);
            ans.add(list);
        }
        Queue<ArrayList<Integer>> q = new LinkedList<>();//队列里面放数组
        for(int i = 0;i < nums.length;i++){
            //头结点
            ArrayList<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            q.offer(list);
        }
        System.out.println(q);
        while(!q.isEmpty()){
            //弹出队头
            ArrayList<Integer> head = q.poll();
            //开枝散叶
            for (int i = 0;i < nums.length;i++){
                if(head.contains(nums[i])) continue;
                ArrayList<Integer> son = new ArrayList<>();
                son.addAll(head);
                son.add(nums[i]);
                if(son.size()==nums.length) ans.add(son);
                else q.offer(son);
            }
        }
        return ans;
    }
}

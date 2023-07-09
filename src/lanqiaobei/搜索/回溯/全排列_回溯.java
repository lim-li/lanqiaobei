package lanqiaobei.搜索.回溯;

import javax.lang.model.element.VariableElement;
import java.util.LinkedList;
import java.util.List;

/**
 * @author limli
 * @date 2023/3/12 21:42
 */
public class 全排列_回溯 {
   static List<List<Integer>> res = new LinkedList<List<Integer>>();

    List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums,track,used);
        return res;
    }

    /**
     * @param nums 选择列表
     * @param track 路径记录在track里面
     * @param used 标记路径中该元素是否备用
     * 结束条件：nums中的元素全部都在track出现过
     */
    static void backtrack(int[] nums,LinkedList<Integer> track,boolean[] used){
        //结束
        if(track.size() == nums.length){
            res.add(new LinkedList<>(track));
            return;
        }
        for(int i = 0;i < nums.length;i++){//其实就是周老师讲的开枝散叶
            if(used[i]) continue;//nums[i] 已经在track中 跳过
            track.add(nums[i]);
            used[i] = true;
            backtrack(nums,track,used);//这个是进入下一层的
            track.removeLast();//回溯 取消选择
            used[i] = false;
        }

    }
}

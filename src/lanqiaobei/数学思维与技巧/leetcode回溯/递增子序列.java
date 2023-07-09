package lanqiaobei.数学思维与技巧.leetcode回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @author limli
 * @date 2023/3/20 20:25
 */
public class 递增子序列 {
    List<List<Integer>> list = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        backTrack(nums,0);
        return list;

    }
    public void backTrack(int[] nums,int startIndex){
        if(path.size()>=2){
            list.add(new ArrayList<>(path));
        }

        if(startIndex >= nums.length) return;
        int[] used = new int[201];//题目中说的数的范围为-100~100 总共201个数字
        for(int i = startIndex;i < nums.length;i++){
            //for循环里面的操作都是相对于本层的操作 不要想那么多
            if(!path.isEmpty() && nums[i] < path.get(path.size()-1) || used[nums[i]+100]==1)continue;
            used[nums[i]+100] = 1;
            path.add(nums[i]);
            backTrack(nums,i+1);//这个递归 才是纵向的操作 其他的都是相对于本层的操作
            path.remove(path.size()-1);
        }
    }
}

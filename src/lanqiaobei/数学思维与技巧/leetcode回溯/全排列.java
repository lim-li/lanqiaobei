package lanqiaobei.数学思维与技巧.leetcode回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @author limli
 * @date 2023/3/20 21:07
 */
public class 全排列 {
    List<List<Integer>> list = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backTrack(nums);
        return list;
    }
    public void backTrack(int[] nums){
        if(path.size()==nums.length){
            list.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0;i < nums.length;i++){
            if(path.contains(nums[i]))continue;
            path.add(nums[i]);
            backTrack(nums);
            path.remove(path.size()-1);
        }
    }
}

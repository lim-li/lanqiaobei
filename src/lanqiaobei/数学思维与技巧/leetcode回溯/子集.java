package lanqiaobei.数学思维与技巧.leetcode回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author limli
 * @date 2023/3/20 19:42
 */
public class 子集 {
    List<List<Integer>> list = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backTrack(nums,0);
        return list;
    }
    public void backTrack(int[] nums,int startIndex){
        list.add(new LinkedList<>(path));
        for(int i = startIndex;i < nums.length;i++){
            path.add(nums[i]);
            backTrack(nums,i+1);
            path.removeLast();
        }
    }
}

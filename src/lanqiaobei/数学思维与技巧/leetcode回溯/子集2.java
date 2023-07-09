package lanqiaobei.数学思维与技巧.leetcode回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author limli
 * @date 2023/3/20 20:15
 */
public class 子集2 {
    List<List<Integer>> list = new ArrayList<>();
    List<Integer> path = new LinkedList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backTrack(nums,0);
        return list;
    }
    public void backTrack(int[] nums,int startIndex){
        list.add(new LinkedList<>(path));//记录所有的节点
        if(startIndex >= nums.length) return; //遍历到的下标
        for(int i = startIndex;i < nums.length;i++){//横向
            if(i > startIndex && nums[i]==nums[i-1]) continue;//同一树层不能有相同的
            path.add(nums[i]);
            backTrack(nums,i+1);//纵向
            path.remove(path.size()-1);
        }
    }
}

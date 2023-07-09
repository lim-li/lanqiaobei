package lanqiaobei.数学思维与技巧.leetcode回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author limli
 * @date 2023/3/20 14:10
 */
public class 组合_总和 {
    List<List<Integer>> list = new ArrayList<>();
    LinkedList<Integer> Path = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backTrack(candidates,target,0,0);
        return list;
    }
    public void backTrack(int[] candidates,int target,int sum,int startIndex){
        if(sum > target) return;
        if(sum == target){
            list.add(new LinkedList<>(Path));
            return;
        }
        for(int i = startIndex;i < candidates.length;i++){//开枝散叶
            Path.add(candidates[i]);
            sum += candidates[i];
            backTrack(candidates,target,sum,i);
            sum -= candidates[i];
            Path.removeLast();
        }
    }
}

package lanqiaobei.数学思维与技巧.leetcode回溯;

import java.util.*;

/**
 * @author limli
 * @date 2023/3/20 14:37
 */
public class 组合总和_2 {
    List<List<Integer>> list = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public static void main(String[] args) {
        int[] can = {10,1,2,7,6,1,5};
        int target = 8;
        组合总和_2 a = new 组合总和_2();
        a.combinationSum2(can,target);

        for(int i = 0;i < a.list.size();i++){
            System.out.println(Arrays.toString(a.list.get(i).toArray()));

        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTrack(candidates,target,0,0);
        return list;
    }
    public void backTrack(int[] candidates,int target,int sum,int startIndex){

        if(sum > target) return;
        if(sum==target){
            list.add(new LinkedList<>(path));
            return;
        }
        for(int i = startIndex;i < candidates.length;i++){//开枝散叶
            //一定要先判断i > startIndex 因为startIndex可能从0开始的
            if(i > startIndex && candidates[i]==candidates[i-1] ){
                continue;
            }
            path.add(candidates[i]);
            sum += candidates[i];
            backTrack(candidates,target,sum,i+1);//i是能重复使用的 i+1是不能重复使用
            sum -= candidates[i];
            path.removeLast();
        }
    }
}

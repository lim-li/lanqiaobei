package lanqiaobei.数学思维与技巧.leetcode回溯;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author limli
 * @date 2023/3/19 19:12
 */
public class 组合3 {
    //定义全局变量
     List<List<Integer>> list = new ArrayList<>();//全局的组合的集合
    LinkedList<Integer> Path = new LinkedList<>();//每一个符合的路径
    //输出k个数的和为n的组合 数字只能使用0-9
    public List<List<Integer>> combinationSum3(int k, int n) {
        backTrack(n,k,1,0);
        return list;

    }
    //和为n k个数  startIndex从哪个数开始遍历的 不能重复 sum当前遍历的数字之和
    public  void backTrack(int n,int k,int startIndex,int sum){
        if(sum > n)return;//剪枝
        if(Path.size()==k){
            if(sum == n){
                list.add(new ArrayList<>(Path));
            }
            return;
        }
        //9-(k-path.size())+1
        for(int i= startIndex;i <= 9-(k-Path.size())+1;i++){
            sum += i;
            Path.add(i);
            backTrack(n,k,i+1,sum);
            Path.removeLast();
            sum -= i;
        }
    }
}

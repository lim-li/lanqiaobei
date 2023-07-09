package lanqiaobei.数学思维与技巧.leetcode回溯;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author limli
 * @date 2023/3/20 16:19
 */
public class 分割回文串 {
    List<List<String>> list = new ArrayList<>();
    Deque<String> path = new LinkedList<>();
    public List<List<String>> partition(String s) {
        backTrack(s,0);
        return list;

    }
    public void backTrack(String s,int startIndex){
        //说明startIndex达到最后了 前面的都是回文串
        if(startIndex >= s.length()){
            list.add(new LinkedList<>(path));
            return;

        }

        for(int i = startIndex;i < s.length();i++){
            if(isp(s,startIndex,i)){
                String sb = s.substring(startIndex, i + 1);
                path.addLast(sb);
            }else{
                continue;
            }
            //起始位置后移 保证不重复
            backTrack(s,i+1);
            path.removeLast();
        }
    }
    public boolean isp(String s,int startIndex,int end){//判断回文
        for(int i = startIndex,j = end;i < j;i++,j--){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        return true;
    }
}

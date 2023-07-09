package lanqiaobei.数学思维与技巧.leetcode回溯;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author limli
 * @date 2023/3/19 20:26
 */
public class 电话号码_组合 {
    List<String> list = new ArrayList<>();//全局的组合的集合

    public List<String> letterCombinations(String digits) {
        if(digits==null) return list;
        //digits的长度 就是组合字符的长度
         String[] numString = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        backTrack(digits,numString,digits.length());
        return list;
    }
    StringBuilder temp = new StringBuilder();
    // numString映射关系 num表示遍历到第几个数字了
    public void backTrack(String digits,String[] numString,int num){
        if(num==digits.length()){//长度一样
            list.add(temp.toString());
            return;
        }
        String str = numString[digits.charAt(num) - '0'];//str代表的是digits的数字所代表的字符串
        for(int i = 0;i < str.length();i++){
            temp.append(str.charAt(i));
            backTrack(digits,numString,num+1);//开始遍历第二个数字代表的字符
            temp.deleteCharAt(temp.length()-1);
        }

    }
}

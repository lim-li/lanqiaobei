package lanqiaobei.数学思维与技巧.leetcode回溯;


import java.util.ArrayList;
import java.util.List;

/**
 * @author limli
 * @date 2023/3/20 19:12
 */
public class 复原ip地址 {
    List<String> list = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        backTrack(s,0,0);
        return list;
    }

    /**
     *
     * @param s 分割字符串s
     * @param startIndex 下一层分割的位置
     * @param pointNum 记录添加逗号的数量
     */
    public void backTrack(String s,int startIndex,int pointNum){
        if(pointNum==3){
            if(check(s,startIndex,s.length()-1)){//判断第四段是否合法
                list.add(s);
            }
            return;
        }

        for(int i = startIndex;i < s.length();i++){
            if(check(s,startIndex,i)){//判断截取的字符串是否合法[startIndex,i]
                pointNum++;//合法添加顿号
                //在i的后面插入顿号
                s= s.substring(0,i+1) + '.' + s.substring(i+1,s.length());
                backTrack(s,i+2,pointNum);//插入逗号 i+2
                pointNum--;
                s = s.substring(0,i+1) + s.substring(i+2);
            }else break;

        }
    }

    private boolean check(String s, int start, int end) {
        if (start > end) {
            return false;
        }
        if (s.charAt(start) == '0' && start != end) { // 0开头的数字不合法
            return false;
        }
        int num = 0;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') { // 遇到⾮数字字符不合法
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255) { // 如果⼤于255了不合法
                return false;
            }
        }
        return true;
    }
}

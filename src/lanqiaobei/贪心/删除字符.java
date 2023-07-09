package lanqiaobei.贪心;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author limli
 * @date 2023/3/20 17:22
 */
public class 删除字符 {
    //删除t个字符能得到的最小字典序的单词
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int t = sc.nextInt();
        //这个题 是每次都将第一个和第二个字符进行比较 删去字典序较大的那个字符 t之后即为所求答案
        ArrayList<Character> s1 = new ArrayList<>();
        for(int i = 0;i < s.length();i++){
            s1.add(s.charAt(i));
        }
        while(t-->0){
            if(s1.get(0)>s1.get(1)){
                s1.remove(0);
            }else if(s1.get(0) < s1.get(1)){
                s1.remove(1);
            }
        }
        for(int i = 0;i < s1.size();i++){
            System.out.print(s1.get(i));
        }
    }
}

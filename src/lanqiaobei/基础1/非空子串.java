package lanqiaobei.基础1;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @author limli
 * @date 2023/1/7 21:06
 */
public class 非空子串 {
    public static void main(String[] args) {
        //String s = "01001100010100010100110001010001";
        String s = "aaab";
        //System.out.println(s.substring(0,1));
        HashSet<String> set = new HashSet<>();
        for(int i = 0;i < s.length();i++){
            for (int j = i+1; j <= s.length(); j++) {
                set.add(s.substring(i,j));
            }
        }
        Iterator<String> it = set.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println(set.size());
    }
}

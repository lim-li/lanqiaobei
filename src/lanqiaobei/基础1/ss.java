package lanqiaobei.基础1;

/**
 * @author limli
 * @date 2023/1/1 18:04
 */
public class ss {
    public static void main(String[] args) {
        System.out.println(new ss().repeatedCharacter("abcba"));
        int a = 2;

    }
    public char repeatedCharacter(String s) {
        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
            if (arr[c - 'a'] == 2) {
                return c;
            }
        }
        return ' ';//必有重复值 所以这个随便返回一个字符就行
    }
    public static boolean areNumbersAscending(String s) {
        int preNum = -1;
        for(String ss:s.split(" ")){
            int curNum = Integer.parseInt(ss);
            if(curNum <= preNum) return false;
            preNum = curNum;
        }

        return true;
    }


}

package lanqiaobei.基础1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author limli
 * @date 2023/1/7 19:44
 * 请你计算最少要修改其中几个字符，可以使 S变为一个 K 次字符串？
 */
public class 重复字符串 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        String s = sc.next();
        if(s.length() % k != 0){
            System.out.println(-1);
            return;
        }
//        int k1 = s.length() / k;
//        int ans = Integer.MAX_VALUE;
//        for(int i = 0;i < s.length();i=i+k1) {
//            String s1 = s.substring(i, i + k1);//记录重复的字符串 这个是错误的 不一定 第一个长度为k1得到的就是最优解
//           // System.out.println(s1);
//            int count = 0;
//            //统计每一个长度为k1的字符串为模板时，需要改变的字符
//            for(int j = 0;j < s.length();){
//                int n = 0;
//                while(n < k1){
//                    if(s1.charAt(n) != s.charAt(j)) {
//                        count++;
//                    }
//                    n++;
//                    j++;
//                }
//            }
//            ans = Math.min(count,ans);
//        }
//        System.out.println(ans);
        //上面暴力模拟 结果还是错了 不能以一个固定的模板字符串 网上的解法 统计模拟串长度的每一个字符的长度 以最多次数的为基础 改变其他的
        /**例如:
         * 输入  3
         *      abcaefebf
         *
         * abc aef ebf 每个字符串转置
         * 写成这样：a a e ==> a : 2 每个字符串的第一个字符
         *         b e b ==> b : 2 第二个
         *         c f f ==> f : 2 第三个
         *         需要改变的字符数量为 9-2*3 = 3个
         *         如果截取一个固定长度的字符为模板 abc==>2+2=4
         *                                  aef==>2+2=4
         *                                  ebf==>2+2=4 故答案是错误的
         *        所以本题的模板字符串为 abf 不是其中任意一个
         * */

        int k1 = s.length() / k; //一份的长度
        int ans = 0;
        for(int i = 0;i < k1;i++){//依次遍历每一份的每个字符
            int[] arr = new int[26];//统计所对应的字符数量
            for(int j = 0;j < k;j++){//需要遍历多少份
                arr[s.charAt(i+k1*j)-'a']++; //i+k1*j k1每一份的长度
            }
            Arrays.sort(arr);
            ans += k-arr[arr.length-1];//k-最大的
            Arrays.fill(arr,0); //数组清零
        }
        System.out.println(ans);
    }
}

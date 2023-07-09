package lanqiaobei.基础1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author limli
 * @date 2023/1/1 11:07
 * 俩个数相乘的模拟
 */
public class TwoBigNumMul {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String a = sc.next();
            String b = sc.next();
            int[] ans = new int[a.length()+b.length()];
            //翻转a,b使得个位对齐
            a = new StringBuffer(a).reverse().toString();
            b = new StringBuffer(b).reverse().toString();
            //ans[i+j] += ai*bj
            for(int i = 0;i < a.length();i++){
                int ai = a.charAt(i)-'0';
                for(int j = 0;j < b.length();j++){
                    int bj = b.charAt(j)-'0';
                    ans[i+j] += ai*bj;
                }
            }
            System.out.println(Arrays.toString(ans));//25*17==>52*71==>[35,19,2,0]
            //模拟进位
            for (int i = 0; i < ans.length-1; i++) {
                //int remind = ans[i] % 10;//优化
                int jw = ans[i] /10;//进位
                //ans[i] = remind;
                ans[i] = ans[i] % 10;
                ans[i+1] += jw;
            }
            System.out.println(Arrays.toString(ans));//ans==>[5,2,4,0]
            /** 找到非0的 [5,2,4,0]
             *  pos=3
             *  --pos 是先减去1 pos = 2 ans[2]!=0 返回false 且满足pos>0 即返回2
             *  pos-- 先运算再减去1 pos=3 ans[3]==0 true 得到2 ans[2] != 0 但是pos又进行了减去1 pos=1
             *
             *pos > 0 是防止99 0 得到 0 0 0
             */
            int pos = ans.length-1;
            while( pos >0 && ans[--pos]==0 );//注意这一行代码
            System.out.println(pos);
            while(pos >= 0) System.out.print(ans[pos--]);

        }
    }
}

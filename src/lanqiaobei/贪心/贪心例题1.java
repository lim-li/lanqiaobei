package lanqiaobei.贪心;

import java.util.Scanner;

/**
 * @author limli
 * @date 2023/2/13 15:24
 * 从m个数里面 选择n个 组成一个大的数字
 */
public class 贪心例题1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String m = sc.next();
        int n = sc.nextInt();
        int baoliu = m.length()-n;
        char[] ch = m.toCharArray();
        int lastSelect = -1;//每一次选择的最大值的后面 再重新选择最大值
        String max = "";
        for(int i = 0;i < baoliu;i++){//循环保留次数次 每次取出最大的字符保留
            char big = '0';//每一次要保留的字符
            for(int j = lastSelect+1;j <= ch.length-(baoliu-i);j++){
                if(ch[j]>big){
                    big = ch[j];
                    lastSelect=j;//记录当前找到的最大位置
                }
            }
            max = max+big;
        }
        System.out.println(max);
    }
}

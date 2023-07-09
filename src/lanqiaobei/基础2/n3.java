package lanqiaobei.基础2;

import java.util.Scanner;

/**
 * @author limli
 * @date 2022/12/19 14:08
 * 小明决定从下周一开始努力刷题准备蓝桥杯竞赛。他计划周一至周五每天 做 a道题目,
 * 周六和周日每天做 b 道题目。请你帮小明计算, 按照计划他将在 第几天实现做题数大于等于 n 题?
 * 10 20 99
 * 8
 */
public class n3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        long a = scan.nextLong();
        long b = scan.nextLong();
        long n = scan.nextLong();
        long ans = 0;
        long q = n / (a*5+b*2);//一周
        ans = q*7;
        n %= (a*5+b*2);
        if(n >5*a){//如果大于五天
            ans += 5;//先加上5天
            n -= 5*a;
            //还需要一天还是俩天
            if(n > b){//俩天
                ans += 2;
            }else{
                ans += 1;
            }
        }else{//五天里面的情况
            if(n % a !=0){//不是整天情况
                ans += 1;
                ans += n / a;
            }else{
                ans += n / a;
            }

        }
        System.out.println(ans);
        scan.close();
    }

}

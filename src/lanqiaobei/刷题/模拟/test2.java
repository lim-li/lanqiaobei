package lanqiaobei.刷题.模拟;

import java.util.Calendar;

/**
 * @author limli
 * @date 2023/3/5 19:13
 */
public class test2 {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.set(1900,0,1);
        int ans = 0;
        while(true){
            //获取日期的年月日
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH)+1;
            int day = cal.get(Calendar.DATE);
            if(fun(year)== fun(month)+fun(day)) ans++;
            cal.add(Calendar.DATE,1);
            if (cal.get(Calendar.YEAR)==9999 && cal.get(Calendar.MONTH)==11 && cal.get(Calendar.DATE)==31){
                break;
            }
        }
        System.out.println(ans);
    }
    public static int fun(int num){//计算一个数的各个位数之和
        int count = 0;
        while(num>0){
            count += num % 10;
            num /= 10;
        }
        return count;
    }
}

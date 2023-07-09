package lanqiaobei.日期;

import java.util.Calendar;

/**
 * @author limli
 * @date 2022/12/27 11:06
 * 从1901,1,1 到 2000,12,31 一共有多少个星期一
 */
public class 星期一 {
    public static void main(String[] args) {
        //初始化
        Calendar cal = Calendar.getInstance();
        cal.set(1901,0,1);//月份减一
        int count = 0;
        while(cal.get(Calendar.YEAR)!=2001){
            if(cal.get(Calendar.DAY_OF_WEEK)==2){
                //星期一是第二天
                count++;
            }
            cal.add(Calendar.DATE,1);
        }
        System.out.println(count);
    }
}

package lanqiaobei.日期;

import java.util.Calendar;

/**
 * @author limli
 * @date 2022/12/27 10:35
 */
public class date {
    public static void main(String[] args) {
        //Calendar 为抽象类 不能new
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.get(Calendar.YEAR)); //当前年份
        //The first month of the year in the Gregorian and Julian calendars is JANUARY which is 0;
        //也就是一月用数值表示为0
        System.out.println(cal.get(Calendar.MONTH)+1);//当前月份 数值加一
        System.out.println(cal.get(Calendar.DATE));//当前号

        System.out.println(cal.get(Calendar.DAY_OF_MONTH));//月份的第几天
        System.out.println(cal.get(Calendar.DAY_OF_WEEK));//一周的第几天 星期日属于第一天 输出3其实今天 周二

        System.out.println("==================");
        //设置当前日期为2023年1月1日
        cal.set(2023,0,1);
        System.out.println(cal.get(Calendar.YEAR));
        System.out.println("test"+cal.get(Calendar.MONTH));
        System.out.println(cal.get(Calendar.DATE));
        System.out.println();

        cal.add(Calendar.DATE,1);//日期加一
        cal.add(Calendar.YEAR,1);//年份加一
        cal.add(Calendar.YEAR,-1);//年份减一 可以为负数
        System.out.println("===========");
        cal.set(2023,0,1);
        cal.add(Calendar.WEEK_OF_MONTH,1);
        System.out.println(cal.get(Calendar.DATE));

    }


}

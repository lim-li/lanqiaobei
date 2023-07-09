package lanqiaobei.日期;

import java.util.Calendar;

/**
 * @author limli
 * @date 2023/3/3 14:41
 */
public class 第几天 {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.set(2000,0,1);//2000.1.1 设置的时候需要 把月份减一
        int count = 1;
        while(true){
            count++;
            cal.add(Calendar.DATE,1);
            if (cal.get(Calendar.YEAR)==2000 && cal.get(Calendar.MONTH)==4 && cal.get(Calendar.DATE)==4){
                break;
            }
        }
        System.out.println(count);
    }
}

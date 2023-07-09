package lanqiaobei.日期;

import java.util.Calendar;

/**
 * @author limli
 * @date 2023/4/21 10:07
 */
public class 特殊日期 {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.set(2000,0,1);
        System.out.println(cal.get(Calendar.MONTH)+1);

        int ans = 0;
        while(cal.get(Calendar.YEAR) < 2000000){
            if((cal.get(Calendar.YEAR) % (cal.get(Calendar.MONTH)+1))==0 && (cal.get(Calendar.YEAR) % cal.get(Calendar.DATE))==0)
                ans++;
            cal.add(Calendar.DATE,1);
        }
        System.out.println(ans);
    }
}

package lanqiaobei.基础3;

import java.util.Scanner;

/**回文日期
 * @author limli
 * @date 2022/11/17 22:17
 */
public class DatePalindrome {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int date = scan.nextInt();
        int next = 0;
        int times = 0;
        int nextAB = 0;
        int firstNext = 0;
        for(int i = date+1;i < 1e+9;i++){
            if(isDate(i)&&huiwen(i)){
                next = i;
                times ++;
                if(times == 1){
                    firstNext = next;
                }
                if(huiweiAB(next)) {//先判断是否为回文再判断为AB回文
                    nextAB = next;
                    break;
                }
            }
        }
        System.out.println(firstNext);
        System.out.println(nextAB);
    }
    public static boolean isDate(int date){
        int year = date / 10000;
        int month = (date /100)%100;
        int day  = date % 100;
        if(month == 1 || month == 3 || month == 5 || month==7 || month == 8 || month==10 || month==12 ){
            if(day <= 31){
                return true;
            }
        }else if(month == 4 || month == 6 || month == 9 || month == 11){
            if(day <= 30){
                return true;
            }
        }
        else if(month == 2){
            if((year%4==0&&year%100!=0)||year%400==0){
                if(day <= 29){
                    return true;
                }
            }else{
                if(day <= 28){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean huiwen(int date){
        String s = Integer.toString(date);
        int left = 0;
        int right = s.length()-1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;

    }
    public static boolean huiweiAB(int date){
        //如果是ABABBABA日期，一定是回文日期且第一位等于第三位和第二位等于第四位
       String s = Integer.toString(date);
       if(s.charAt(0)==s.charAt(2) && s.charAt(1)==s.charAt(3)){
           return true;
       }else{
           return false;
       }
    }
}

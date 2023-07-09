package lanqiaobei.数学思维与技巧;

import java.util.Scanner;

/**
 * @author limli
 * @date 2022/12/23 10:22
 * 第一行包含整数 N，表示后面共有 N 行数据。
 * 接下来 N 行，每行包含空格分开的若干个（不大于100个）
 * 正整数（不大于100000），每个整数代表一个ID号。
 *
 * 要求程序输出1行，含两个整数 m,n，用空格分隔。
 *
 * 其中，m表示断号ID，n表示重号ID。
 *
 * 输入：
 * 2
 * 5 6 8 11 9
 * 10 12 9
 *
 * 输出样例：
 * 7 9
 * */
public class 错误票据 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());//trim()去掉字符串两端多余空格
        int[] arr = new int[1000005];//因为最大整数不大于100000
        int min = 0,max = 0;
        for(int i = 0;i < n;i++){//n行数据
            //split里的参数是正则表达式，被空格(几个无所谓)之间分隔的两个字符串分别赋值给s[i]和s[i+1]
            String[] ss = scanner.nextLine().split("\\s+"); //每一行的字符串数字，
            for(int j = 0;j < ss.length;j++){
                int num = Integer.parseInt(ss[j]);
                min = Math.min(min,num);
                max = Math.max(max,num);
                arr[num] ++;
            }
        }
        int duan = -1,chong = -2;
        for(int i = min;i <= max;i++){
            if(arr[i] == 2){
                chong = i;
            }
            if(arr[i] == 0){
                duan = i;
            }
        }
        System.out.println(duan + " " + chong);
    }
}

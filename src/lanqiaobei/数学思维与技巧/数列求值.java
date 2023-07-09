package lanqiaobei.数学思维与技巧;

/**
 * @author limli
 * @date 2022/12/22 11:28给定数列 1, 1, 1, 3, 5, 9, 17,
 * 1,1,1,3,5,9,17,⋯，从第 44 项开始，每项都是前 33 项的和。
 *
 * 求第 20190324项的最后 44 位数字。
 */
public class 数列求值 {
    public static void main(String[] args) {
        System.out.println(fic(20190324));

    }
    public static long fic(int n){
        int a = 1,b = 1,c = 1,d = 0;

        for(int i = 4;i <= n;i++){
            d = (a+b+c) % 10000;
            a = b;
            b = c;
            c = d;
        }
        return d;
    }
}

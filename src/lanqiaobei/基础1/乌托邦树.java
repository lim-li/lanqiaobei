package lanqiaobei.基础1;

import java.util.Scanner;

/**
 * @author limli
 * @date 2022/12/28 11:15
 */
public class 乌托邦树 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int height = 1;
        for (int i = 1; i <= n; i++) {
            if(i % 2 == 1){//春天
                height *= 2;
            }else{
                height ++;
            }
        }
        System.out.println(height);
    }
}

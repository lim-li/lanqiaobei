package lanqiaobei.数学思维与技巧;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author limli
 * @date 2023/1/2 11:22
 */
public class 数列 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = 0,min = Integer.MAX_VALUE,fc = Integer.MAX_VALUE;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0;i < n;i++){
            int m = sc.nextInt();
            max=Math.max(max,m);
            min=Math.min(min,m);
            list.add(m);
        }
        Collections.sort(list);
        for(int i = 0;i < list.size()-1;i++){
            fc = Math.min(fc,list.get(i+1)-list.get(i));
        }
        //公差为0没有考虑
        //min max fc
        if(fc == 0){
            System.out.println(list.size());
        }else{
            System.out.println((max-min)/fc+1);
        }

    }
}

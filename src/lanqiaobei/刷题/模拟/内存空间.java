package lanqiaobei.刷题.模拟;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author limli
 * @date 2023/5/16 21:31
 */
public class 内存空间 {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        int T=in.nextInt();//指令的条数
        in.nextLine();
        String[] a=new String[T];
        for(int i=0;i<T;i++) {
            a[i]=in.nextLine();
        }
        int sumB=0;
        while(T>0) {
            char[] as=a[T-1].toCharArray();
            //int类型的两种情况
            if(as[0]=='i') {
                if(as[3]=='[') {//int[] aa=new int[123];
                    for(int i=0;i<as.length;i++) {
                        if(as[i]=='['&&as[i+1]!=']') {
                            i++;
                            String shu="";
                            while(as[i]!=']'){
                                shu+=as[i];
                                i++;
                            }
                            sumB+=Integer.parseInt(shu)*4;
                        }
                    }
                }
                if(as[3]==' ') {//int a=1,b=2,c=3;
                    for(int i=0;i<as.length;i++) {
                        if(as[i]=='=')
                            sumB+=4;
                    }
                }
            }
            //long类型的两种情况
            if(as[0]=='l') {
                if(as[4]==' ') {//long a=1,b=2,c=3;
                    for(int i=0;i<as.length;i++) {
                        if(as[i]=='=')
                            sumB+=8;
                    }
                }
                if(as[4]=='[') {//long[] aa=new long[123];
                    for(int i=0;i<as.length;i++) {
                        if(as[i]=='['&&as[i+1]!=']') {
                            i++;
                            String shu="";
                            while(as[i]!=']'){
                                shu+=as[i];
                                i++;
                            }
                            sumB+=Integer.parseInt(shu)*8;
                        }
                    }
                }
            }
            //String类型的一种情况
            if(as[0]=='S') {
                for(int i=8;i<as.length;i++) {
                    if(as[i]=='\"') {
                        i++;
                        while(as[i]!='\"') {
                            sumB++;
                            i++;
                        }

                    }
                }
            }

            T--;
        }
        //System.out.println(sumB);
        if(sumB>=Math.pow(2, 30)) {//GB
            System.out.print((int)(sumB/Math.pow(2, 30))+"GB");
            sumB%=Math.pow(2, 30);
            if((int)(sumB/Math.pow(2, 20))!=0) {
                System.out.print((int)(sumB/Math.pow(2, 20))+"MB");
            }
            sumB%=Math.pow(2, 20);
            if((int)(sumB/Math.pow(2, 10))!=0) {
                System.out.print((int)(sumB/Math.pow(2, 10))+"KB");
            }
            sumB%=Math.pow(2, 10);
            if(sumB!=0) {
                System.out.println(sumB+"B");
            }
            System.exit(0);
        }
        if(sumB>=Math.pow(2, 20)) {//MB
            System.out.print((int)(sumB/Math.pow(2, 20))+"MB");
            sumB%=Math.pow(2, 20);
            if((int)(sumB/Math.pow(2, 10))!=0) {
                System.out.print((int)(sumB/Math.pow(2, 10))+"KB");
            }
            sumB%=Math.pow(2, 10);
            if(sumB!=0) {
                System.out.println(sumB+"B");
            }
            System.exit(0);
        }
        if(sumB>=Math.pow(2, 10)) {//KB
            System.out.println(sumB/Math.pow(2, 10)+"KB");
            sumB%=Math.pow(2, 10);
            if(sumB!=0) {
                System.out.println(sumB+"B");
            }
            System.exit(0);
        }
        System.out.println(sumB+"B");

    }
}

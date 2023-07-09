package lanqiaobei.分治算法;

import java.io.*;

/**
 * @author limli
 * @date 2023/2/2 21:00
 */
public class 快速幂 {
    public static void main(String[] args) throws IOException {
        // a^b%p
        //1,递归求a^b 快速幂
        // b=0,ans=1;b=1,ans=a;b是奇数:a^b=a^(b-1)/2+a^(b+1)/2;2^3=2^1*2^2; b是偶数 类似
        //System.out.println(fun1(2, 10));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        String[] s1 = in.readLine().split(" ");
        int t = Integer.parseInt(s1[0]);
        while(t-->0){
            String[] s = in.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int p = Integer.parseInt(s[2]);
            System.out.println(fun3(n,m,p));
        }

    }
    public static int fun1(int a,int b){
        if(b==0) return 1;
        if(b==1) return a;
        if(b%2==0) return fun1(a,b/2)*fun1(a,b/2);
        else return fun1(a,(b+1)/2)*fun1(a,(b-1)/2);
    }

    // a*a%p=((a%p)*(a%p))%p a^b%p 扩底降幂的思想 b是奇数单独处理 a*a^(b-1) 即((a%p)*(a^(b-1))%p)%p
    //b是偶数时 扩底降幂 a^b%p = (a^2)^(b/2) ==> a=a*a%p b=b/2;
    public static int fun2(int a,int b,int p){
        int ans = 1;
        while(b>0){
            if(b % 2==1) ans = ans*a%p;
            a=a*a%p;//扩底
            b = b/2;//降幂
        }
        return ans;
    }
    public static int fun3(int a,int b,int p){
        int ans = 1;
        while(b>0){
            if((b&1)==1) ans = (int) ((long)ans*a%p); //这里ans*a 可能会是long
            a=(int)((long)a*a%p);//扩底
            b=b>>1;//降幂
        }
        return ans;
    }
    public static long fun4(long a,long b,long p){//为了防止溢出 所以都用long
        long ans = 1;
        while(b>0){
            if((b&1)==1) ans = ans*a%p; //这里ans*a 可能会是long
            a= a*a%p;//扩底
            b=b>>1;//降幂
        }
        return ans;
    }

}

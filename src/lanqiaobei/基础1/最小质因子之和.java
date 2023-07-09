package lanqiaobei.基础1;

import java.io.*;

/**
 * @author limli
 * @date 2023/1/2 16:38
 */
public class 最小质因子之和 {
//    static int index = 0;//素数个数
//    static boolean[] isprime = new boolean[3000001];//是否是素数
//    static int[] prime = new int[3000001];//存储素数
//    static long[] ans = new long[3000001];//存储最小的质因子
//    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
//
//    public static void main(String[] args) throws IOException {
//        get(3000000);
//        for (int i = 2; i <= 3000000 ; i++) {
//           // out.println(ans[i]);
//            ans[i] = ans[i] + ans[i-1];
//        }
//        int n = Integer.parseInt(in.readLine());
//        while(n-->0){
//            out.println(ans[Integer.parseInt(in.readLine())]);
//        }
//        out.flush();
//
//
//    }
//    static void get(int n){
//        for(int i = 2;i <= n;i++){
//            if(isprime[i]) {//素数默认都为false
//                //不是素数
//                continue;
//            }
//            prime[index++] = i;
//            ans[i] = i;
//            for(int j =2;j <= n/i;j++){
//                if(!isprime[i*j]){
//                    isprime[i*j] = true;
//                    ans[i*j] = i; //j*i的最小质因子是i
//                }
//            }
//
//        }
//    }

//    public static void main(String[] args) {

//        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();
//        for (int i = 0; i < t; i++) {
//            int m = sc.nextInt();
//            System.out.println();
//        }
        //System.out.println(fun(15));
        //快读
//       StreamTokenizer in = new StreamTokenizer(new InputStreamReader(System.in));
//       in.nextToken();
//       int t = (int)in.nval;
//       for(int i = 0;i < t;i++){
//           in.nextToken();
//           int m = (int)in.nval;
//           System.out.println(fun(m));
//       }
//    }
//        //用一个数组求得每个数最小质因子的前缀和
//        long[] arr = new long[3000001];
//        int sum = 0;
//        for (int i = 2; i <= 3000000; i++) {
//            boolean flag = true;
//            for (int j = 2; j <= i / j; j++) {
//                if (i % j == 0) {
//                    sum += j;
//                    flag = false;//
//                    break;
//                }
//            }
//            if (flag){
//                sum += i;
//                arr[i] = sum;
//            }
//
//        }
//        System.out.println(Arrays.toString(arr));

    public static void main(String[] args) throws IOException {
        //1.首先用一个数组 记录每个i的最小质因子
        long[] arr = new long[3000001];
        for (int i = 2; i <= 3000000; i++) {
            boolean falg = true;
            for(int j = 2; j <= i/j;j++){
                if(i % j == 0){
                    arr[i] = j;
                    falg = false;
                    break;
                }
            }
            if(falg) arr[i] = i;
        }
        //System.out.println(Arrays.toString(arr));
        //2.把这个数组的前缀和求出来 减小时间复杂度
        for(int i = 1;i < arr.length;i++){
            arr[i] +=arr[i-1];
        }
//        //3.求解
//        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();
//        while(t-->0){
//            int m = sc.nextInt();
//            System.out.println(arr[m]);
//        }
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(in.readLine());
        while(n-->0){
            out.println(arr[Integer.parseInt(in.readLine())]);
        }
        out.flush();
    }
}

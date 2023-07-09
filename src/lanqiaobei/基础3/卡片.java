package lanqiaobei.基础3;

/**
 * @author limli
 * @date 2023/1/12 20:01
 * 计算每个数的卡片最大 能拼接出来的数字
 */
public class 卡片 {
    public static void main(String[] args) {
        System.out.println(fun(0)+1);
        System.out.println(fun(1));
        System.out.println(fun(2));
        System.out.println(fun(3));
        System.out.println(fun(4));
        System.out.println(fun(5));
        System.out.println(fun(6));
        System.out.println(fun(7));
        System.out.println(fun(8));
        System.out.println(fun(0));
    }
    public static int fun(int n){
        int res = 0;
        int i ;
        for( i = 1;i <= 10000;i++){
            int t = i;
            while(t > 0){
                if(t % 10 == n)
                    res++;
                t /= 10;
            }
            if(res == 2021) break;
        }
       return i;
    }
}

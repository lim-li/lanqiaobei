package lanqiaobei.基础3;

/**
 * @author limli
 * @date 2022/12/18 20:06
 * 问题描述
 * 　　1221是一个非常特殊的数，它从左边读和从右边读是一样的，编程求所有这样的四位十进制数。
 */
public class huiwen {
    public static void main(String[] args) {
        for (int i = 1000; i < 10000 ; i++) {
            if(new huiwen().isHuiWen(i)){
                System.out.println(i);
            }
        }
    }
    public boolean isHuiWen(int n){
        int temp = n;
        int ans = 0;
        while(n > 0){
            ans = ans *10 + n % 10;
            n /= 10;
        }
        return ans == temp;
    }
}

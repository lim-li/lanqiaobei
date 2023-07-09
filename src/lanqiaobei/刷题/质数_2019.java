package lanqiaobei.刷题;

/**
 * @author limli
 * @date 2023/2/25 17:22
 */
public class 质数_2019 {
    public static void main(String[] args) {
        int cnt = 0;
        int i ;
        for( i = 2;i < 100000000;i++){
            if(fun(i)) cnt++;
            if(cnt==2019) break;
        }
        System.out.println(i);
    }
    //先判断质数
    public static boolean fun(int n){
        for(int i = 2;i <= Math.sqrt(n);i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}

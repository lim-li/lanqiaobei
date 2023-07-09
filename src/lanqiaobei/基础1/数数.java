package lanqiaobei.基础1;

/**
 * @author limli
 * @date 2023/1/2 12:06
 */
public class 数数 {
    public static void main(String[] args) {
        int sum = 0;
        for(int i = 2333333;i <=23333333;i++){
            if(isZs(i)==12) sum++;
        }
        System.out.println(sum);
    }
    public static int isZs(int n){//返回n能被多少个质数相乘
        int count = 0;
        for (int i = 2; i <= n/i; i++) {
            while(n % i == 0){
                n /= i;
                count++;
            }

        }
        if(n > 1) count++;
        return count;
    }
}

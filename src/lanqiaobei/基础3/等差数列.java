package lanqiaobei.基础3;

/**
 * @author limli
 * @date 2022/11/25 9:46
 * 长度为 10的等差素数列，其公差最小值是多少？
 */
public class 等差数列 {
    public static void main(String[] args) {
        for(int i = 1;i < 1000000;i++){//初始值
            for(int j = 1;j < 10000;j++){//公差
                int k;
                for( k=0;k<10;k++){ //长度
                    if(!isPrime(i+j*k)){
                        break;
                    }
                }
                if(k == 10){
                    System.out.println(j);
                    return;
                }

            }

        }

    }

    public static boolean isPrime(int num){
        for(int i = 2;i <= num/2;i++){
            if(num % i == 0)
                return false;
        }
        return true;
    }
}

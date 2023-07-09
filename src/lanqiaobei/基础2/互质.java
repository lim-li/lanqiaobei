package lanqiaobei.基础2;

/**
 * @author limli
 * @date 2023/1/3 15:37
 * 1~2020 有多少数与1018 互质
 * 初步思路 最大公约数为1
 */
public class 互质 {
    public static void main(String[] args) {
        int count = 0;
        for(int i = 1;i <=2020;i++){
            if(gcd(i,1018)==1){
                count++;
            }
        }
        System.out.println(count);

    }
    static int gcd(int a,int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
}

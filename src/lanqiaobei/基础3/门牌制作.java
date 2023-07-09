package lanqiaobei.基础3;

/**
 * @author limli
 * @date 2022/12/8 14:33
 * 需要制作多少个数字2
 */
public class 门牌制作 {
    public static void main(String[] args) {
        int res = 0;
        for(int i = 1;i <= 3263;i++){
            int t = i;
            while(t > 0){
                if(t % 10 == 2)
                    res++;
                t /= 10;
            }
        }
        System.out.println(res);
    }
}

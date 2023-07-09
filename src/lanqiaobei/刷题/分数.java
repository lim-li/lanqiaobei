package lanqiaobei.刷题;

/**
 * @author limli
 * @date 2023/2/24 14:26
 */
public class 分数 {
    public static void main(String[] args) {
        // 1+ 1/2+1/4+1/8...的前20项的和 2^20-1/2^19
        int a = -1;//分母
        a += Math.pow(2,20);
        int b = 0;
         b += Math.pow(2,19);
        System.out.printf("%d/%d",a,b);

    }
}

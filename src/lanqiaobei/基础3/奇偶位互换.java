package lanqiaobei.基础3;

/**
 * @author limli
 * @date 2022/11/18 18:55
 */
public class 奇偶位互换 {
    public static void main(String[] args) {
        int a = 6;
        System.out.println(Integer.toBinaryString(a));
        System.out.println("========");
        System.out.println(Integer.toBinaryString(conver(a)));

    }

    public static int conver(int i){
        System.out.println(Integer.toBinaryString(i));
        int ou = i&0xaaaaaaaa;
        int ji = i&0x55555555;
        System.out.println("ji"+Integer.toBinaryString(ji));
        System.out.println("ou"+Integer.toBinaryString(ou));
        System.out.println("===========");

        return (ji<<1)^(ou>>1);

    }
}

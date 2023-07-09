package lanqiaobei.基础3;

/**
 * @author limli
 * @date 2022/11/18 17:16
 * 二进制中1的个数:
 *              1,直接&运算
 *              2,x&(x-1)能消掉一个x最低位的1，当运算几次 就有几个1
 *判断一个数是否为2的整数次方
 *              1，即二进制只有一个1
 */
public class numer0f1 {
    public static void main(String[] args) {
        int a = 15;
        System.out.println(Integer.toBinaryString(a));
        System.out.println(numof1(a));
        System.out.println("==========");
        System.out.println(numof2(a));
        System.out.println(numof3(a));

    }
    //方法一
    public static int numof1(int n){
        int count = 0;
        while(n>0){
            if((n&1)==1){
                count++;
            }
            n = n>>1;
        }
        return count;
    }
    //方法二
    public static int numof2(int n){
        int count = 0;
        while(n>0){
            n = n&(n-1);
            count++;
        }
        return count;
    }
    //判断一个数是否为2的整数次幂
    public static boolean numof3(int n){
        int count = 0;
        while(n>0){
            n = n&(n-1);
            count++;
        }
        if(count==1)
            return true;
        return false;
    }

}

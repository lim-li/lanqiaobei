package lanqiaobei.递归;

/**
 * @author limli
 * @date 2022/12/17 11:27
 */
public class returnTest {
    public static void main(String[] args) {
        System.out.println("1,调用returntest之前");
        returntest(0);
        System.out.println("2,调用returntest之后");

    }
    public static void returntest(int x){
        if(x == 2){
            return ;
        }
        System.out.println("x等于"+x+" :3.进入returntest测试");
        returntest(x+1);
        System.out.println("x等于"+x + ":  4.执行完returntest测试");
    }
}
